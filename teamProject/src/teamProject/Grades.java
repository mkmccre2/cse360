/**
    * Author: Mary McCready, Noah Korner, Thais Herve
    * Class: CSE 360 2019 Summer C (41792)
    * Team project
    * The Grading Application calculates useful metrics from
    * and uploaded text file. Users have the ability to make changes
    * to grades and save grade reports.
    */

package teamProject;

import java.util.ArrayList;
import java.util.List;

/**
 * Grades is the model class that stores all grades and values.
 */
public class Grades {
	
	/** The ArrayList which stores the grades. */
	private List<Double> gradesList = new ArrayList<>();
	/** The minimum and maximum grade variables. */
	private double minGrade, maxGrade;
	/** The minimum score per letter grade variables. */
	private double minA, minB, minC, minD;
	
	/**
	 * Sole class constructor for Grades.
	 * @param userGrades
	 */
	public Grades(List<Double> userGrades) {
		this.gradesList = userGrades;
		this.minGrade = 0;
		this.maxGrade = 100;
		this.minA = 90;
		this.minB = 80;
		this.minC = 70;
		this.minD = 60;
	}
	
	/**
	 * Returns grades
	 * @return gradesList
	 */
	public List<Double> getGrades(){
		return gradesList;
	}
	
	/**
	 * Returns minimum grade
	 * @return minGrade
	 */
	public double getMinGrade() {
		return this.minGrade;
	}
	
	/**
	 * Returns maximum grade
	 * @return maxGrade
	 */
	public double getMaxGrade() {
		return this.maxGrade;
	}
	
	/**
	 * returns minimum score for A
	 * @return minA
	 */
	public double getMinA() {
		return this.minA;
	}
	
	/**
	 * returns minimum score for B
	 * @return minB
	 */
	public double getMinB() {
		return this.minB;
	}
	
	/**
	 * returns minimum score for C
	 * @return minC
	 */
	public double getMinC() {
		return this.minC;
	}
	
	/**
	 * returns minimum score for D
	 * @return minD
	 */
	public double getMinD() {
		return this.minD;
	}
	
	/**
	 * Sets minimum and maximum grade to user input.
	 * @param userMinGrade
	 * @param userMaxGrade
	 */
	public void changeMinMaxGrades(double userMinGrade, double userMaxGrade) {
		this.minGrade = userMinGrade;
		this.maxGrade = userMaxGrade;
	}
	
	/**
	 * Sets new minimum score for each letter grade to user input.
	 * @param minA
	 * @param minB
	 * @param minC
	 * @param minD
	 */
	public void changeGradeRange(double minA, double minB, double minC, double  minD) {
		this.minA = minA;
		this.minB = minB;
		this.minC = minC;
		this.minD = minD;
	}
	
	
	
	

}
