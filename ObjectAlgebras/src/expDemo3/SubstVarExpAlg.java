package expDemo3;

//BEGIN_SUBSTVARS_WITH_ID
public interface SubstVarExpAlg<Exp> extends ExpAlgTransform<Exp> {
	String x(); Exp e();
	default Exp Var(String s) { return s.equals(x())? e(): expAlg().Var(s); }
}
//END_SUBSTVARS_WITH_ID
