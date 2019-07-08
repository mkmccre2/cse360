package teamProject;

import java.util.ArrayList;
import java.util.List;

public class Grades {
	
	private List<Double> gradesList = new ArrayList<>();
	private int minGrade, maxGrade;
	private double minA, minB, minC, minD;
	
	public Grades(List<Double> userGrades) {
		this.gradesList = userGrades;
		this.minGrade = 0;
		this.maxGrade = 100;
		this.minA = 90;
		this.minB = 80;
		this.minC = 70;
		this.minD = 60;
	}
	
	public List<Double> getGrades(){
		return gradesList;
	}
	
	
	
	public int getMinGrade() {
		return this.minGrade;
	}
	
	public int getMaxGrade() {
		return this.maxGrade;
	}
	
	public double getMinA() {
		return this.minA;
	}
	
	public double getMinB() {
		return this.minB;
	}
	
	public double getMinC() {
		return this.minC;
	}
	
	public double getMinD() {
		return this.minD;
	}
	
	public void changeMinMaxGrades(int userMinGrade, int userMaxGrade) {
		this.minGrade = userMinGrade;
		this.maxGrade = userMaxGrade;
	}
	
	public void changeGradeRange(double minA, double minB, double minC, double  minD) {
		this.minA = minA;
		this.minB = minB;
		this.minC = minC;
		this.minD = minD;
	}
	
	
	
	

}
