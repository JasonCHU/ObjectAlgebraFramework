package ql_obj_alg.format;

import ql_obj_alg.box.IFormat;
import ql_obj_alg.syntax.IRepeatAlg;

public interface RepeatFormat extends StmtFormat, IRepeatAlg<IFormat> {
	default IFormat repeat(int n, java.util.List<IFormat> body) {
		return box().V(box().H(1,box().L("repeat"),box().H(box().L("("),box().L("" + n),box().L(")")),box().L("{")),
				box().I(2,body), box().L("}"));
	}
}
