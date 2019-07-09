package teamProject;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class GradesControllerTest {

	private List<Double> testGradesList = new ArrayList<>();
	private Grades testGrades;
	private GradesGUI testGui;
	private GradesController testController;
	private String testGradesString;

	@Test
	void testGradesToString() {
		testGradesList.add(100.0);
		testGradesList.add(90.0);
		testGradesList.add(80.0);
		testGradesList.add(70.0);
		testGradesList.add(60.0);
		testGradesList.add(50.0);
		testGradesList.add(40.0);
		
		testGrades = new Grades(testGradesList);
		testGui = new GradesGUI();
		testController = new GradesController(testGrades, testGui);
		testGradesString = "100.0\n90.0\n80.0\n70.0\n60.0\n50.0\n40.0\n";
		
		String result = testController.gradesToString(testGradesList);
		assertEquals(testGradesString, result);
		
	}

	@Test
	void testGradesToDouble() {
		
		List<Double> schema = new ArrayList<>();
		
		schema.add(100.0);
		schema.add(90.0);
		schema.add(80.0);
		schema.add(70.0);
		schema.add(60.0);
		schema.add(50.0);
		schema.add(40.0);
		
		testGradesList.clear();
		testGrades = new Grades(testGradesList);
		testGui = new GradesGUI();
		testController = new GradesController(testGrades, testGui);
		testGradesString = "100\n90\n80\n70\n60\n50\n40\n";
		testController.gradesToDouble(testGradesString);
		
		assertEquals(testController.grades.getGrades(), schema);
	}
}
