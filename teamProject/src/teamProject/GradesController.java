/**
    * Author: Mary McCready, Noah Korner, Thais Herve
    * Class: CSE 360 2019 Summer C (41792)
    * Team project
    * The Grading Application calculates useful metrics from
    * and uploaded text file. Users have the ability to make changes
    * to grades and save grade reports.
    */

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

/**
 * The GradesController class is used to manipulate the Grades model from user input in the GUI.
 */
public class GradesController {
	/** Grades object */
	private Grades grades;
	/** GradesGUI object */
	private GradesGUI gui;
	/** Initial high, lowe, average, and median values */
	private double high = 0, low = 0, average = 0, median = 0;
	/** Initial A, B, C, D, E score values */
	private int numA = 0, numB = 0, numC = 0, numD = 0, numE = 0;
	/** Initial 20th, 70th, and 90th percentile values  */
	private double percentile20th = 0, percentile70th = 0, percentile90th = 0;
	/** File path string */
	private String filePath = null;
	/** Empty grades string */
	private String gradesString = "";
	
	/**
	 * Sole GradesController constructor.
	 * @param initGrades
	 * @param initGui
	 */
	public GradesController(Grades initGrades, GradesGUI initGui) {
		grades = initGrades;
		gui = initGui;
		initializeGradesGUI();
	}
	
	/**
	 * Initializes the Grades GUI
	 */
	public void initializeGradesGUI() {
		try {
			gui.getFrmGradebook().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Initializes the controller. Starts with optional application tour, then initializes listeners.
	 */
	public void initializeController() {
		
		// dialog box tour
		Object[] options1 = {"Take tour", "Get started"};
		Object[] options2 = {"Next tip", "Leave tour"};
		Object[] options3 = {"Get started!", "Restart tour"};
		int counter = 0;
		int tour = JOptionPane.showOptionDialog(gui.getFrmGradebook(), "Welcome to the "
				+ "Grading Application! \nIf this is your first time using the app, "
				+ "select 'Take tour'. \nIf you've been here before, select 'Get "
				+ "started' to go directly to the app.", "Welcome to the Grading "
						+ "Application", JOptionPane.OK_CANCEL_OPTION, 
						JOptionPane.INFORMATION_MESSAGE, null, options1, options1[0]);
		
		String[] tourMessages = {
				"To upload your grades, select the 'Upload Grades' button "
				+ "\nand navigate to a text file that contains the grades. "
				+ "\nOnly text files are accepted, and grades must be comma, "
				+ "\nspace, or line delimited.",
				
				"To change the letter grade ranges, select 'Change Letter Grade "
				+ "\n Ranges' and enter the minimum score for each letter grade.",
				
				"The default minimum grade is 0 and the default maximum grade is "
				+ "\n100. To change the minimum and maximum grades, selext the 'Set "
				+ "\nMin/Max Grade' button and enter the desired grades.",
				
				"Grades can be updated directly in the GRADES editor at any time. "
				+ "\nYou can make changes to uploaded grades, or you can begin adding "
				+ "\ngrades manually. To update the grades metrics, select the 'Update "
				+ "\nGrades' button and the metrics will automatically update. If you "
				+ "\nuploaded grades, the changes will be saved to the original file. "
				+ "\nIf you did not upload grades, you will be prompted to save your "
				+ "\nchanges to a new grades file.",
				
				"You can save a report at any time after you have uploaded or "
				+ "\nupdated grades. Select the 'Save Report' button and choose a "
				+ "\nsave location."
		};
		
		while(tour == JOptionPane.OK_OPTION && counter < 5) {
			if (counter != 4) {
				tour = JOptionPane.showOptionDialog(gui.getFrmGradebook(), tourMessages[counter], "Grading "
						+ "Application Tour", JOptionPane.OK_CANCEL_OPTION, 
						JOptionPane.INFORMATION_MESSAGE, null, options2, options2[0]);
			}
			else {
				tour = JOptionPane.showOptionDialog(gui.getFrmGradebook(), tourMessages[counter], "Grading "
						+ "Application Tour", JOptionPane.OK_CANCEL_OPTION, 
						JOptionPane.INFORMATION_MESSAGE, null, options3, options3[0]);
				if(tour == JOptionPane.CANCEL_OPTION) {
					counter = -1;
				}
			}
			
			counter++;
		}
		
		// listeners
		gui.getBtnUploadGrades().addActionListener(parameter -> uploadGrades());
		gui.getBtnPrintReport().addActionListener(parameter -> printReport());
		gui.getBtnChangeGrade().addActionListener(parameter -> changeGrade());
		gui.getBtnUpdateGrades().addActionListener(parameter -> updateGrades());
		gui.getBtnSetMinMax().addActionListener(parameter -> setMinMax());
	}

	/**
	 * Launches file chooser for user to select grade file. Grades are saved to grades ArrayList.
	 */
	private void uploadGrades() {
		//initialize local variables
    	double newGrade = 0;
    	//initialize file chooser
    	JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			grades.getGrades().clear();
			File selectedFile = jfc.getSelectedFile();
			filePath = selectedFile.getAbsolutePath();
			if(selectedFile.getName().toLowerCase().endsWith("txt")){
				try {
					Scanner scan = new Scanner(selectedFile);
					// check for comma, space, and line delimiter
					scan.useDelimiter("[,| |\n]");

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
				catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(gui.getFrmGradebook(), "Imported text document (" + selectedFile.getPath() + ") not formatted correctly.");
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
			}
			else{
				JOptionPane.showMessageDialog(gui.getFrmGradebook(), "Incorrect file type.", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}//if file approved
	}
	
	/**
	 * If grades are present, prompts user to save report.
	 */
	private void printReport() {
		if (grades.getGrades().size() != 0) {
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			int retrieval = jfc.showSaveDialog(null);
			if (retrieval == JFileChooser.APPROVE_OPTION) {
				try {
					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(jfc.getSelectedFile() + ".txt"));
					
					String out = "";
					out = 
						"GRADE REPORT\n" +
						"----------------------\n";
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
						"\n\nPERCENTILE\n" + 
						"----------------------\n" +
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
		}
		else {
			JOptionPane.showMessageDialog(gui.getFrmGradebook(), "No grades have been imported.",
					"Error", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	/**
	 * Allows user to change score minimums for each grade.
	 */
	private void changeGrade() {
		double newA, newB, newC, newD;
		try {
			
			JTextField newAField = new JTextField(4);
			JTextField newBField = new JTextField(4);
			JTextField newCField = new JTextField(4);
			JTextField newDField = new JTextField(4);
			
			JPanel changeGradesPanel = new JPanel();
			changeGradesPanel.add(new JLabel("A:"));
			changeGradesPanel.add(newAField);
			changeGradesPanel.add(new JLabel("B:"));
			changeGradesPanel.add(newBField);
			changeGradesPanel.add(new JLabel("C:"));
			changeGradesPanel.add(newCField);
			changeGradesPanel.add(new JLabel("D:"));
			changeGradesPanel.add(newDField);
			
			int result = JOptionPane.showConfirmDialog(null, changeGradesPanel, "Enter"
					+ "minimum scores for each grade", JOptionPane.OK_CANCEL_OPTION);
			
			if (result == JOptionPane.OK_OPTION) {
				newA = Double.parseDouble(newAField.getText());
				newB = Double.parseDouble(newBField.getText());
				newC = Double.parseDouble(newCField.getText());
				newD = Double.parseDouble(newDField.getText());
				
				if(newA > newB && newB > newC && newC > newD) {
					
					grades.changeGradeRange(newA, newB, newC, newD);
					analyzeGrades();
				}
				else {
					JOptionPane.showMessageDialog(gui.getFrmGradebook(), "Grade ranges must follow the "
							+ " format: A > B > C > D > E. Please try again.", 
							"Error", JOptionPane.WARNING_MESSAGE);
				}
			}
			
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
		
	/**
	 * If grades were uploaded, changes are saved to the original file. If grades were not uploaded,
	 * user is prompted to save a new grade file.
	 */
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
	
	/**
	 * User can set new minimum and maximum allowed grades for an assignemnt.
	 */
	private void setMinMax() {
		double newMin, newMax;
		try {
			
			JTextField newMinField = new JTextField(4);
			JTextField newMaxField = new JTextField(4);
			
			JPanel changeGradesPanel = new JPanel();
			changeGradesPanel.add(new JLabel("Minimum score:"));
			changeGradesPanel.add(newMinField);
			changeGradesPanel.add(new JLabel("Maximum score:"));
			changeGradesPanel.add(newMaxField);
			
			int result = JOptionPane.showConfirmDialog(null, changeGradesPanel, "Enter"
					+ "the minimum and maximum score.", JOptionPane.OK_CANCEL_OPTION);
			
			if (result == JOptionPane.OK_OPTION) {
				newMin = Double.parseDouble(newMinField.getText());
				newMax = Double.parseDouble(newMaxField.getText());
				
				if(newMin < newMax && newMin >= 0) {
					grades.changeMinMaxGrades(newMin, newMax);
				}
				else {
					JOptionPane.showMessageDialog(gui.getFrmGradebook(), "Minimum grade must be positive and "
							+ "Maximum grade must be larger than Minimum grade.", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
			
		} catch (Exception exx) {
			exx.printStackTrace();
		}
	}
	
	/**
	 * Returns String of grades from List<Double>
	 * @param grades
	 * @return gradeString
	 */
	protected String gradesToString(List<Double> grades) {
		String gradeString = "";
		for (int i = 0; i < grades.size(); i++) {
			gradeString += grades.get(i) + "\n";
		}	
		return gradeString;	
	}
	
	/**
	 * Parses grades from string of grades and stores them in grades ArrayList
	 * @param gradesString
	 */
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
	
	/**
	 * Saves new grades to file.
	 */
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
				temp = grades.getGrades().get(index).toString();
				fileWriter.write(temp);
				fileWriter.write("\n");
			}
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Calculates and displays grade metrics.
	 */
	private void analyzeGrades() {
		String gradesReceived = "";
		numA = 0;
		numB = 0;
		numC = 0;
		numD = 0;
		numE = 0;
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
			median = (double)(sortedGrades.get(((grades.getGrades().size()/2) - 1)) + 
					sortedGrades.get((grades.getGrades().size() / 2))) / 2.0;
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
