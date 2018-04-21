import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

public class DijkstraShortestPath {

	private HashMap<String, HashMap<String, Integer>> map;
	private HashMap<String, Integer> townMinDistance;
	private HashSet<String> visitedTowns;
	private LinkedList<String> nextTowns;
	
	public DijkstraShortestPath(HashMap<String, HashMap<String, Integer>> map) {
		this.map = map;
		this.visitedTowns = new HashSet<String>();
		this.nextTowns = new LinkedList<String>();
		this.townMinDistance = new HashMap<String, Integer>();
	}
	
	public int getMinDistance(String startTown, String endTown) {
		this.nextTowns.add(startTown);
		step();
		if (this.townMinDistance.containsKey(endTown)) {
			return this.townMinDistance.get(endTown);
		}
		return -1;
	}

	private void step() {
		if (this.nextTowns == null || this.nextTowns.size() < 1) {
			return;
		}
		String start = nextTowns.removeFirst();
		int minDistance = 0;
		if (this.townMinDistance.containsKey(start)) {
			minDistance = townMinDistance.get(start);
		}
		HashMap<String, Integer> routes=this.map.get(start);
		Iterator<Entry<String, Integer>> iter = routes.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			String nextTown = entry.getKey();
			// just in case of self-loop
			if (nextTown == start) {
				continue;
			}
			int nextTownDistance = entry.getValue() + minDistance;
			if ((!this.nextTowns.contains(nextTown)) && (!this.visitedTowns.contains(nextTown))) {
				this.nextTowns.add(nextTown);
			}
			if (this.townMinDistance.containsKey(nextTown)) {
				if (nextTownDistance < this.townMinDistance.get(nextTown)) {
					this.townMinDistance.put(nextTown, nextTownDistance);
				}
			} else {
				this.townMinDistance.put(nextTown, nextTownDistance);
			}
		}
		this.visitedTowns.add(start);
		step();
	}

}