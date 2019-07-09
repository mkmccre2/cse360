/**
    * Author: Mary McCready, Noah Korner, Thais Herve
    * Class: CSE 360 2019 Summer C (41792)
    * Team project
    * The Grading Application calculates useful metrics from
    * and uploaded text file. Users have the ability to make changes
    * to grades and save grade reports.
    */

package teamProject;

import java.util.*;

/**
 * GradingApplication is the base class for the Grading Application program. The Grades model,
 * GUI, and controller are initialized.
 */
public class GradingApplication {
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		List<Double> emptyList = new ArrayList<>();
		Grades grades = new Grades(emptyList);
		GradesGUI gui = new GradesGUI();
		GradesController controller = new GradesController(grades, gui);
		controller.initializeController();
	}
}//GradingApplication class	
	
	
