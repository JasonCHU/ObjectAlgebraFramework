package expDemo3;

//BEGIN_EXP_ALG
@Algebra
interface ExpAlg<Exp> {
	Exp Var(String s);
	Exp Lit(int i);
	Exp Add(Exp e1, Exp e2);
}
//END_EXP_ALG
