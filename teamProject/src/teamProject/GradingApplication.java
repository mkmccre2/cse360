package teamProject;

import java.util.*;


public class GradingApplication {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		List<Double> emptyList = new ArrayList<>();
		Grades grades = new Grades(emptyList);
		GradesGUI gui = new GradesGUI();
		GradesController controller = new GradesController(grades, gui);
		controller.initializeController();
	}
}//GradingApplication class	
	
	
