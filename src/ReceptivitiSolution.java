import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ReceptivitiSolution {
	
	private HashMap<String, HashMap<String, Integer>> map;
	private int result;
	
	public ReceptivitiSolution(HashMap<String, HashMap<String, Integer>> map) {
		this.map = map;
	}

	public String question1() {
		HashMap<String, Integer> routesA=this.map.get("A");
		int distanceAB = 0;
		if (null != routesA.get("B")) {
			distanceAB = routesA.get("B");
		} else {
			return "NO SUCH ROUTE";
		}
		
		HashMap<String, Integer> routesB=this.map.get("B");
		int distanceBC = 0;
		if (null != routesB.get("C")) {
			distanceBC = routesB.get("C");
		} else {
			return "NO SUCH ROUTE";
		}
		return String.valueOf(distanceAB+distanceBC);
	}
	
	public String question2() {
		HashMap<String, Integer> routesA=this.map.get("A");
		int distanceAD = 0;
		if (null != routesA.get("D")) {
			distanceAD = routesA.get("D");
		} else {
			return "NO SUCH ROUTE";
		}
		return String.valueOf(distanceAD);
	}
	
	public String question3() {
		HashMap<String, Integer> routesA=this.map.get("A");
		int distanceAD = 0;
		if (null != routesA.get("D")) {
			distanceAD = routesA.get("D");
		} else {
			return "NO SUCH ROUTE";
		}
		
		HashMap<String, Integer> routesD=this.map.get("D");
		int distanceDC = 0;
		if (null != routesD.get("C")) {
			distanceDC = routesD.get("C");
		} else {
			return "NO SUCH ROUTE";
		}
		return String.valueOf(distanceAD+distanceDC);
	}
	
	public String question4() {
		HashMap<String, Integer> routesA=this.map.get("A");
		int distanceAE = 0;
		if (null != routesA.get("E")) {
			distanceAE = routesA.get("E");
		} else {
			return "NO SUCH ROUTE";
		}
		
		HashMap<String, Integer> routesE=this.map.get("E");
		int distanceEB = 0;
		if (null != routesE.get("B")) {
			distanceEB = routesE.get("B");
		} else {
			return "NO SUCH ROUTE";
		}
		
		HashMap<String, Integer> routesB=this.map.get("B");
		int distanceBC = 0;
		if (null != routesB.get("C")) {
			distanceBC = routesB.get("C");
		} else {
			return "NO SUCH ROUTE";
		}
		
		HashMap<String, Integer> routesC=this.map.get("C");
		int distanceCD = 0;
		if (null != routesC.get("D")) {
			distanceCD = routesC.get("D");
		} else {
			return "NO SUCH ROUTE";
		}
		
		return String.valueOf(distanceAE+distanceEB+distanceBC+distanceCD);
	}
	
	public String question5() {
		HashMap<String, Integer> routesA=this.map.get("A");
		int distanceAE = 0;
		if (null != routesA.get("E")) {
			distanceAE = routesA.get("E");
		} else {
			return "NO SUCH ROUTE";
		}
		
		HashMap<String, Integer> routesE=this.map.get("E");
		int distanceED= 0;
		if (null != routesE.get("D")) {
			distanceED = routesE.get("D");
		} else {
			return "NO SUCH ROUTE";
		}
		
		return String.valueOf(distanceAE+distanceED);
	}
	
	public String question6() {
		this.result = 0;
		getMaxRoutes("C", "C", 3);
		return String.valueOf(this.result);
	}
	
	private void getMaxRoutes(String startTown, String targetTown, int depth) {
		if (depth == 0) return;
		HashMap<String, Integer> routes=this.map.get(startTown);
		Iterator<Entry<String, Integer>> iter = routes.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			String town = entry.getKey();
			if (town == targetTown) {
				this.result = this.result+1;
			}
			getMaxRoutes(town, targetTown, depth-1);
		}
	}
	
	public String question7() {
		this.result = 0;
		getExactRoutes("A", "C", 4);
		return String.valueOf(this.result);
	}
	
	private void getExactRoutes(String startTown, String targetTown, int depth) {
		if (depth == 0) return;
		HashMap<String, Integer> routes=this.map.get(startTown);
		Iterator<Entry<String, Integer>> iter = routes.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			String town = entry.getKey();
			if (depth == 1 && town == targetTown) {
				this.result = this.result+1;
			} else {
				getExactRoutes(town, targetTown, depth-1);
			}
		}
	}
	
	public String question8() {
		DijkstraShortestPath path = new DijkstraShortestPath(this.map);
		return String.valueOf(path.getMinDistance("A", "C"));
	}
	
	public String question9() {
		DijkstraShortestPath path = new DijkstraShortestPath(this.map);
		return String.valueOf(path.getMinDistance("B", "B"));
	}

	
	public String question10() {
		this.result = 0;
		getNumRoutes("C", "C", 30);
		return String.valueOf(this.result);
	}

	private void getNumRoutes(String startTown, String targetTown, int maxDistance) {
		if (maxDistance <= 0) return;
		HashMap<String, Integer> routes=this.map.get(startTown);
		Iterator<Entry<String, Integer>> iter = routes.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			String town = entry.getKey();
			int nextMaxDistance = maxDistance-entry.getValue();
			if (nextMaxDistance <= 0) continue;
			if (town == targetTown) {
				this.result = this.result+1;
			} 
			getNumRoutes(town, targetTown, nextMaxDistance);
		}
	}
}
