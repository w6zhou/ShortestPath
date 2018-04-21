import java.util.HashMap;

public class ReceptivitiMain {
	ReceptivitiSolution testSolution;
	
	public static void main(String[] args) {
		HashMap<String, HashMap<String, Integer>> map = buildMap();
		ReceptivitiSolution solution = new ReceptivitiSolution(map);
		System.out.println("Output #1: "+solution.question1());
		System.out.println("Output #2: "+solution.question2());
		System.out.println("Output #3: "+solution.question3());
		System.out.println("Output #4: "+solution.question4());
		System.out.println("Output #5: "+solution.question5());
		System.out.println("Output #6: "+solution.question6());
		System.out.println("Output #7: "+solution.question7());
		System.out.println("Output #8: "+solution.question8());
		System.out.println("Output #9: "+solution.question9());
		System.out.println("Output #10: "+solution.question10());
	}
	
	public static HashMap<String, HashMap<String, Integer>> buildMap() {
		HashMap<String, HashMap<String, Integer>> map = new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, Integer> routesA = new HashMap<String, Integer>();
		routesA.put("B", 5);
		routesA.put("D", 5);
		routesA.put("E", 7);
		map.put("A", routesA);
		
		HashMap<String, Integer> routesB = new HashMap<String, Integer>();
		routesB.put("C", 4);
		map.put("B", routesB);
		
		HashMap<String, Integer> routesC = new HashMap<String, Integer>();
		routesC.put("D", 8);
		routesC.put("E", 2);
		map.put("C", routesC);
		
		HashMap<String, Integer> routesD = new HashMap<String, Integer>();
		routesD.put("C", 8);
		routesD.put("E", 6);
		map.put("D", routesD);
		
		HashMap<String, Integer> routesE = new HashMap<String, Integer>();
		routesE.put("B", 3);
		map.put("E", routesE);
		
		return map;
	}

}