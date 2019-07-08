package teamProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class GradesController {
	
	private Grades grades;
	private GradesGUI gui;
	private double high = 0, low = 0, average = 0, median = 0;
	private int numA = 0, numB = 0, numC = 0, numD = 0, numE = 0;
	private double percentile20th = 0, percentile70th = 0, percentile90th = 0;
	private String filePath = null;
	private String gradesString = "";
	
	public GradesController(Grades initGrades, GradesGUI initGui) {
		grades = initGrades;
		gui = initGui;
		initializeGradesGUI();
	}
	
	public void initializeGradesGUI() {
		try {
			gui.getFrmGradebook().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initializeController() {
		gui.getBtnUploadGrades().addActionListener(e ->  uploadGrades());
		gui.getBtnPrintReport().addActionListener(e -> printReport());
		gui.getBtnChangeGrade().addActionListener(e -> changeGrade());
		gui.getBtnUpdateGrades().addActionListener(e -> updateGrades());
		gui.getBtnSetMinMax().addActionListener(e -> setMinMax());
	}

	private void uploadGrades() {
		//initialize local variables
    	double newGrade = 0;
    	//initialize file chooser
    	JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			filePath = selectedFile.getAbsolutePath();
			if(selectedFile.getName().toLowerCase().endsWith("txt")){
				try {
					Scanner scan = new Scanner(selectedFile);

			        while(scan.hasNextDouble())
			        {
			        	newGrade = scan.nextDouble();
			        	if(newGrade > grades.getMaxGrade() || newGrade < grades.getMinGrade()) { //grade is out of range
			        		JOptionPane.showMessageDialog(gui.getFrmGradebook(), "Imported text document " + selectedFile.getPath() 
			        		+ " contains grade(s) which are\nout of range. Those grades have not been added. "
			        		+ "Use 'Set Min/Max Grade' button to change grade range.");
			        	}
			        	else {
			        		grades.getGrades().add(newGrade); //add each grade to the ArrayList grades
			        	}
			        }
			        scan.close();
			        gradesString = gradesToString(grades.getGrades()); //set grades string
			        gui.getEditorPaneT().setText(gradesString);
			        analyzeGrades();
				}
				catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(gui.getFrmGradebook(), "Imported text document (" + selectedFile.getPath() + ") not formatted correctly.");
				}
				catch (Exception eee) {
					eee.printStackTrace();
				}
			}
			else{
				JOptionPane.showMessageDialog(gui.getFrmGradebook(), "Incorrect file type.", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}//if file approved
	}
	
	private void printReport() {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int retrieval = jfc.showSaveDialog(null);
		if (retrieval == JFileChooser.APPROVE_OPTION) {
			if (grades.getGrades().size() != 0) {
				try {
					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(jfc.getSelectedFile() + ".txt"));
					
					String out = "";
					out = 
						"GRADES\n" +
						"----------------------\n";
				
							//add grades to file
					out += 
						"\nSTATISTICS\n" + 
						"----------------------\n" + 
						"HIGH = " + high +
						"\nLOW = " + low +
						"\nAVERAGE = " + average +
						"\nMEDIAN = " + median + 
						"\n\nDISTRIBUTION\n" + 
						"----------------------\n" +
						"A\t|\t" + numA + 
						"\nB\t|\t" + numB + 
						"\nC\t|\t" + numC + 
						"\nD\t|\t" + numD +
						"\nE\t|\t" + numE + 
						"\n\n20th Percentile: " + percentile20th +
						"\n70th Percentile: " + percentile70th + 
						"\n90th Percentile: " + percentile90th;
					bufferedWriter.write(out);
					bufferedWriter.close();	
				} 
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(gui.getFrmGradebook(), "No grades have been imported.");
			}
		}
	}
	
	private void changeGrade() {
		double newA, newB, newC, newD;
		try {
			newA = Double.parseDouble(JOptionPane.showInputDialog("Enter minimum grade for A:"));
			newB = Double.parseDouble(JOptionPane.showInputDialog("Enter minimum grade for B:"));
			newC = Double.parseDouble(JOptionPane.showInputDialog("Enter minimum grade for C:"));
			newD = Double.parseDouble(JOptionPane.showInputDialog("Enter minimum grade for D:"));
				
			if(newA > newB && newB > newC && newC > newD) {
				
				grades.changeGradeRange(newA, newB, newC, newD);
				analyzeGrades();
			}
			else {
				JOptionPane.showMessageDialog(gui.getFrmGradebook(), "Grade ranges must follow the following format: A > B > C > D > E. Please try again.", "Error", JOptionPane.WARNING_MESSAGE);
			}
		} catch(Exception ee) {
			ee.printStackTrace();
		}
	}
			
	private void updateGrades() {
		if (filePath == null) { //no grades have been uploaded yet
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			int retrieval = jfc.showSaveDialog(null);
			if (retrieval == JFileChooser.APPROVE_OPTION) {
				filePath = jfc.getSelectedFile().getAbsolutePath();
			}
		}
    	gradesString = gui.getEditorPaneT().getText(); //update grades string
    	grades.getGrades().clear();
    	gradesToDouble(gradesString); //update grade array list
    	saveGrades();
    	analyzeGrades();
	}
	
	private void setMinMax() {
		try {
			int newMin = Integer.parseInt(JOptionPane.showInputDialog("Enter minimum score:"));
			int newMax = Integer.parseInt(JOptionPane.showInputDialog("Enter maximum score:"));
			if (newMin < newMax && newMin >= 0) {
				grades.changeMinMaxGrades(newMin, newMax);
			}
			else {
				JOptionPane.showMessageDialog(gui.getFrmGradebook(), "Minimum grade must be positive and Maximum grade must be larger than Minimum grade.", "Error", JOptionPane.WARNING_MESSAGE);
			}
			
		} catch (Exception exx) {
			exx.printStackTrace();
		}
	}
	
	protected String gradesToString(List<Double> grades) {
		String temp = "";
		for (int i = 0; i < grades.size(); i++) {
			temp += grades.get(i) + "\n";
		}	
		return temp;	
	}
	
	protected void gradesToDouble(String gradesString) {
		String temp;
		double grade;
		Scanner scan = new Scanner(gradesString);
		while (scan.hasNext()) {
			temp = scan.next();
			grade = Double.parseDouble(temp);
			grades.getGrades().add(grade);
		}
		scan.close();
	}
	
	protected void saveGrades() {
		String temp = "";
		File saveFile = new File(filePath);
		try {
			//clear the file first
			FileWriter clrFileWriter = new FileWriter(filePath, false); 
			PrintWriter clrPrintWriter = new PrintWriter(clrFileWriter, false);
			clrPrintWriter.flush();
			clrPrintWriter.close();
			clrFileWriter.close();
			
			//save new grades to file
			FileWriter fileWriter = new FileWriter(saveFile);
			for(int index = 0; index < grades.getGrades().size(); index++) {
				temp = grades.getGrades().get(index).toString() + "\n";
				fileWriter.write(temp);
				fileWriter.write("\n");
			}
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void analyzeGrades() {
		String gradesReceived = "";
		//calculate sum of grades
		double sum = 0;
			for (int index = 0; index < grades.getGrades().size(); index++) {
				sum += grades.getGrades().get(index);
			}
		
		DecimalFormat decimal = new DecimalFormat("#.##");
		
		//create new list and sort in increasing order
		List<Double> sortedGrades = new ArrayList<>();
		sortedGrades.addAll(grades.getGrades());
		Collections.sort(sortedGrades);
		
		//calculate and display high result
		high = sortedGrades.get(sortedGrades.size() - 1);
		gui.getLblHighResult().setText(decimal.format(high)); 
		//calculate and display low result
		low = sortedGrades.get(0);
		gui.getLblLowResult().setText(decimal.format(low)); 
		//calculate and display average result
		average = sum / grades.getGrades().size();
		gui.getLblAverageResult().setText(decimal.format(average));
		//calculate and display median result
		if(sortedGrades.size() % 2 == 0) { //even number of grades
			median = (double)(sortedGrades.get(((grades.getGrades().size()/2) - 1)) + sortedGrades.get((grades.getGrades().size() / 2))) / 2.0;
		}
		else {
			median = (double)sortedGrades.get((grades.getGrades().size() / 2));
		}
		gui.getLblMedianResult().setText(decimal.format(median)); 
		
		//calculate grade distributions
		for (int index = 0; index < grades.getGrades().size(); index++) {
			double currentGrade = grades.getGrades().get(index); 
			if (currentGrade >= grades.getMinA() - .5) {
				gradesReceived += "A\n";
				numA++;
			}
			else if (currentGrade >= grades.getMinB() - .5) {
				gradesReceived += "B\n";
				numB++;
			}
			else if (currentGrade >= grades.getMinC() - .5) {
				gradesReceived += "C\n";
				numC++;
			}
			else if (currentGrade >= grades.getMinD() - .5) {
				gradesReceived += "D\n";
				numD++;
			}
			else {
				gradesReceived += "E\n";
				numE++;
			}
		}
		//display grades received
		gui.getTextPane().setText(gradesReceived);
		//display number of each grade
		gui.getLblAResult().setText(Integer.toString(numA));
		gui.getLblBResult().setText(Integer.toString(numB));
		gui.getLblCResult().setText(Integer.toString(numC));
		gui.getLblDResult().setText(Integer.toString(numD));
		gui.getLblEResult().setText(Integer.toString(numE));
		
		//calculate and display percentiles
		percentile20th = sortedGrades.get((int)Math.ceil(0.2 * sortedGrades.size())-1);
		percentile70th = sortedGrades.get((int)Math.ceil(0.7 * sortedGrades.size())-1);
		percentile90th = sortedGrades.get((int)Math.ceil(0.9 * sortedGrades.size())-1);
		gui.getLbl20thResult().setText(decimal.format(percentile20th)); //20th percentile
		gui.getLbl70thResult().setText(decimal.format(percentile70th)); //70th percentile
		gui.getLbl90thResult().setText(decimal.format(percentile90th)); //90th percentile
	}

}
