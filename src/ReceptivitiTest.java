import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReceptivitiTest {

	ReceptivitiSolution solution;
	@BeforeEach
	void setUp() throws Exception {
		HashMap<String, HashMap<String, Integer>> map = buildMap();
		this.solution = new ReceptivitiSolution(map);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.solution = null;
	}

	@Test
	void testQuestion1() {
		assertEquals(String.valueOf(9), this.solution.question1());
	}

	@Test
	void testQuestion2() {
		assertEquals(String.valueOf(5), this.solution.question2());
	}

	@Test
	void testQuestion3() {
		assertEquals(String.valueOf(13), this.solution.question3());
	}

	@Test
	void testQuestion4() {
		assertEquals(String.valueOf(22), this.solution.question4());
	}

	@Test
	void testQuestion5() {
		assertEquals("NO SUCH ROUTE", this.solution.question5());
	}

	@Test
	void testQuestion6() {
		assertEquals(String.valueOf(2), this.solution.question6());
	}

	@Test
	void testQuestion7() {
		assertEquals(String.valueOf(3), this.solution.question7());
	}

	@Test
	void testQuestion8() {
		assertEquals(String.valueOf(9), this.solution.question8());
	}

	@Test
	void testQuestion9() {
		assertEquals(String.valueOf(9), this.solution.question9());
	}

	@Test
	void testQuestion10() {
		assertEquals(String.valueOf(7), this.solution.question10());
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
