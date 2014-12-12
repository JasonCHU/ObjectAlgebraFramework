package expDemo2;

import java.util.Set;

/*Directly: Just implement freeVars and substVars directly 
 * without using queries/transformations or our framework;
 */
public class ExpTest {
	
	static <Exp> Exp genExp(ExpAlg<Exp> alg){
		return alg.Add(alg.Add(alg.Lit(2), alg.Var("var1")),alg.Add(alg.Add(alg.Var("var2"), alg.Var("var3")), alg.Lit(5)));
	}
		
	public static void main(String[] args) {
		FreeVarsExpAlg alg = new FreeVarsExpAlg(){};
		SubstVarExpAlg<Set<String>> substVarsExpAlg = new SubstVarExpAlg<Set<String>>() {
			public ExpAlg<Set<String>> expAlg() { return alg; }
			public String x() { return "var1"; }
			public Set<String> e() { return expAlg().Var("var4"); }
		};
		Set<String> res = genExp(substVarsExpAlg);
		for (String s: res) System.out.println(s);
	}
}
