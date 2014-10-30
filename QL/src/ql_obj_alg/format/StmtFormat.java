package ql_obj_alg.format;

import java.util.List;

import ql_obj_alg.box.BoxAlg;
import ql_obj_alg.box.IFormat;
import ql_obj_alg.check.types.Type;
import ql_obj_alg.syntax.IStmtAlg;

public interface StmtFormat extends IStmtAlg<IFormatWithPrecedence, IFormat> {
	BoxAlg<IFormat> box();

	
	@Override
	default IFormat iff(final IFormatWithPrecedence cond, final List<IFormat> statements) {
		return box().V(box().H(1,box().L("if"),box().H(box().L("("),cond,box().L(")")),box().L("{")),
						box().I(2,statements), box().L("}"));
	}

	@Override
	default IFormat iffelse(final IFormatWithPrecedence cond, final List<IFormat> statementsIf, final List<IFormat> statementsElse) {
		return box().V(box().H(1,box().L("if"),box().H(box().L("("),cond,box().L(")")),box().L("{")),
					 box().I(2,statementsIf), 
					 box().L("}"),
					 box().H(1, box().L("else"),box().L("{")),
					 box().I(2,statementsElse),
					 box().L("}"));
	}

	@Override
	default IFormat question(final String id, final String label, final Type type) {
		return box().H(1,box().L(id),box().L("\"" + label + "\""),box().L(type.toString()));
	}

	@Override
	default IFormat question(final String id, final String label, final Type type,
			final IFormatWithPrecedence exp) {
		return 	box().H(1,box().L(id),box().L("\"" + label + "\""),box().L(type.toString()), box().L("="), box().H(0, box().L("("), exp, box().L(")")));
	}

}
