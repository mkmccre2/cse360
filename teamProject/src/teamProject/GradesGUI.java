package teamProject;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.*;

public class GradesGUI {
	
	// frame
	private JFrame frmGradebook; 
	
	// text editor
	private JEditorPane editorPaneT;
	private JScrollPane editorPane;
	
	// 'letter grades' display text window
	private JTextPane textPane;
	private JScrollPane textPaneT;
	
	// labels
	private JLabel lblHighResult;
	private JLabel lblLowResult;
	private JLabel lblAverageResult;
	private JLabel lblMedianResult;
	private JLabel lblAResult;
	private JLabel lblBResult;
	private JLabel lblCResult;
	private JLabel lblDResult;
	private JLabel lblEResult;
	private JLabel lbl20thResult;
	private JLabel lbl70thResult;
	private JLabel lbl90thResult;
	private JLabel lblHigh;
	private JLabel lblLow;
	private JLabel lbl90th;
	private JLabel lblAverage;
	private JLabel lblMedian;
	private JLabel lblLetterGrades;
	private JLabel lblGrades;
	private JLabel lblDistribution;
	private JLabel lblPercentile;
	private JLabel lblE;
	private JLabel lblA;
	private JLabel lbl20th;
	private JLabel lblC;
	private JLabel lblD;
	private JLabel lblB;
	private JLabel lbl70th;
	
	// buttons
	private JButton btnChangeGrade;
	private JButton btnUploadGrades;
	private JButton btnUpdateGrades;
	private JButton btnSetMinMax;
	private JButton btnPrintReport;
	
	// methods
	
	public GradesGUI() {
		initializeFrame();
		initializeLabels();
		initializeButtons();
		initializePanes();
	}
	
	private void initializeFrame() {
		//initialize 'grading application' window
		frmGradebook = new JFrame();
		frmGradebook.getContentPane().setForeground(Color.WHITE);
		frmGradebook.setBounds(100, 100, 784, 417);
		frmGradebook.setTitle("Grading Application"); //title of application
		frmGradebook.setBackground(new Color(0, 51, 102));
		frmGradebook.getContentPane().setBackground(new Color(30, 144, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1, 94, 19, 43, 153, 131, 35, 103, 0};
		gridBagLayout.rowHeights = new int[]{1, 23, 14, 14, 14, 14, 35, 23, 14, 14, 14, 14, 14, 22, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmGradebook.getContentPane().setLayout(gridBagLayout);
	}
	
	private void initializeLabels() {
		
		//'high' label
		lblHigh = new JLabel("HIGH");
		lblHigh.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblHigh = new GridBagConstraints();
		gbc_lblHigh.insets = new Insets(0, 0, 5, 5);
		gbc_lblHigh.gridx = 1;
		gbc_lblHigh.gridy = 2;
		frmGradebook.getContentPane().add(lblHigh, gbc_lblHigh);

		//'high' result label to 0 
		lblHighResult = new JLabel(" ");
		lblHighResult.setForeground(Color.WHITE);
		GridBagConstraints gbcHighResult = new GridBagConstraints();
		gbcHighResult.insets = new Insets(0, 0, 5, 5);
		gbcHighResult.gridx = 3;
		gbcHighResult.gridy = 2;
		frmGradebook.getContentPane().add(lblHighResult, gbcHighResult);
		
		//'low' label
		lblLow = new JLabel("LOW");
		lblLow.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblLow = new GridBagConstraints();
		gbc_lblLow.anchor = GridBagConstraints.NORTH;
		gbc_lblLow.insets = new Insets(0, 0, 5, 5);
		gbc_lblLow.gridx = 1;
		gbc_lblLow.gridy = 3;
		frmGradebook.getContentPane().add(lblLow, gbc_lblLow);

		//'low' result label to 0
		lblLowResult = new JLabel(" ");
		lblLowResult.setForeground(Color.WHITE);
		GridBagConstraints gbcLowResult = new GridBagConstraints();
		gbcLowResult.insets = new Insets(0, 0, 5, 5);
		gbcLowResult.gridx = 3;
		gbcLowResult.gridy = 3;
		frmGradebook.getContentPane().add(lblLowResult, gbcLowResult);
		
		//'average' label
		lblAverage = new JLabel("AVERAGE");
		lblAverage.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblAverage = new GridBagConstraints();
		gbc_lblAverage.insets = new Insets(0, 0, 5, 5);
		gbc_lblAverage.gridx = 1;
		gbc_lblAverage.gridy = 4;
		frmGradebook.getContentPane().add(lblAverage, gbc_lblAverage);
			
		//'average' result label to 0
		lblAverageResult = new JLabel(" ");
		lblAverageResult.setForeground(Color.WHITE);
		GridBagConstraints gbcAverageResult = new GridBagConstraints();
		gbcAverageResult.insets = new Insets(0, 0, 5, 5);
		gbcAverageResult.gridx = 3;
		gbcAverageResult.gridy = 4;
		frmGradebook.getContentPane().add(lblAverageResult, gbcAverageResult);
		
		//'median' label
		lblMedian = new JLabel("MEDIAN");
		lblMedian.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblMedian = new GridBagConstraints();
		gbc_lblMedian.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedian.gridx = 1;
		gbc_lblMedian.gridy = 5;
		frmGradebook.getContentPane().add(lblMedian, gbc_lblMedian);

		//'median' result label
		lblMedianResult = new JLabel(" ");
		lblMedianResult.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblMedianDynamic_1 = new GridBagConstraints();
		gbc_lblMedianDynamic_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedianDynamic_1.gridx = 3;
		gbc_lblMedianDynamic_1.gridy = 5;
		frmGradebook.getContentPane().add(lblMedianResult, gbc_lblMedianDynamic_1);
			
		//'letter grades' label
		lblLetterGrades = new JLabel("LETTER GRADES");
		lblLetterGrades.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblLetterGrades = new GridBagConstraints();
		gbc_lblLetterGrades.anchor = GridBagConstraints.SOUTH;
		gbc_lblLetterGrades.insets = new Insets(0, 0, 5, 5);
		gbc_lblLetterGrades.gridx = 5;
		gbc_lblLetterGrades.gridy = 1;
		frmGradebook.getContentPane().add(lblLetterGrades, gbc_lblLetterGrades);

		//'grades' label
		lblGrades = new JLabel("GRADES");
		lblGrades.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblGrades = new GridBagConstraints();
		gbc_lblGrades.anchor = GridBagConstraints.SOUTH;
		gbc_lblGrades.insets = new Insets(0, 0, 5, 5);
		gbc_lblGrades.gridx = 7;
		gbc_lblGrades.gridy = 1;
		frmGradebook.getContentPane().add(lblGrades, gbc_lblGrades);
		
		//initialize change grade range button
		btnChangeGrade = new JButton("Change Letter Grade Ranges");
		btnChangeGrade.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_btnChange_1 = new GridBagConstraints();
		gbc_btnChange_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnChange_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnChange_1.gridx = 1;
		gbc_btnChange_1.gridy = 6;
		frmGradebook.getContentPane().add(btnChangeGrade, gbc_btnChange_1);
			
		//grade distribution label
		lblDistribution = new JLabel("DISTRIBUTION");
		lblDistribution.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblDistribution = new GridBagConstraints();
		gbc_lblDistribution.insets = new Insets(0, 0, 5, 5);
		gbc_lblDistribution.gridx = 1;
		gbc_lblDistribution.gridy = 7;
		frmGradebook.getContentPane().add(lblDistribution, gbc_lblDistribution);
			
		//'percentile' label
		lblPercentile = new JLabel("PERCENTILE");
		lblPercentile.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblPercentile = new GridBagConstraints();
		gbc_lblPercentile.insets = new Insets(0, 0, 5, 5);
		gbc_lblPercentile.gridx = 4;
		gbc_lblPercentile.gridy = 7;
		frmGradebook.getContentPane().add(lblPercentile, gbc_lblPercentile);
			
		//'A' grade label
		lblA = new JLabel("A");
		lblA.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblA = new GridBagConstraints();
		gbc_lblA.insets = new Insets(0, 0, 5, 5);
		gbc_lblA.gridx = 1;
		gbc_lblA.gridy = 8;
		frmGradebook.getContentPane().add(lblA, gbc_lblA);

		//'number of A's' result display label
		lblAResult = new JLabel(" ");
		lblAResult.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTest = new GridBagConstraints();
		gbc_lblTest.insets = new Insets(0, 0, 5, 5);
		gbc_lblTest.gridx = 2;
		gbc_lblTest.gridy = 8;
		frmGradebook.getContentPane().add(lblAResult, gbc_lblTest);
			
		//'20th percentile' label
		lbl20th = new JLabel("20th Percentile");
		lbl20th.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblBottom = new GridBagConstraints();
		gbc_lblBottom.insets = new Insets(0, 0, 5, 5);
		gbc_lblBottom.gridx = 4;
		gbc_lblBottom.gridy = 8;
		frmGradebook.getContentPane().add(lbl20th, gbc_lblBottom);
			
		//'B' grade label
		lblB = new JLabel("B");
		lblB.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblB = new GridBagConstraints();
		gbc_lblB.insets = new Insets(0, 0, 5, 5);
		gbc_lblB.gridx = 1;
		gbc_lblB.gridy = 9;
		frmGradebook.getContentPane().add(lblB, gbc_lblB);

		//'number of B's' result display label
		lblBResult = new JLabel(" ");
		lblBResult.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTest_1 = new GridBagConstraints();
		gbc_lblTest_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTest_1.gridx = 2;
		gbc_lblTest_1.gridy = 9;
		frmGradebook.getContentPane().add(lblBResult, gbc_lblTest_1);
			
		//20th percentile result display label
		lbl20thResult = new JLabel(" ");
		lbl20thResult.setBackground(Color.WHITE);
		lbl20thResult.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblBottom20Dynamic = new GridBagConstraints();
		gbc_lblBottom20Dynamic.insets = new Insets(0, 0, 5, 5);
		gbc_lblBottom20Dynamic.gridx = 4;
		gbc_lblBottom20Dynamic.gridy = 9;
		frmGradebook.getContentPane().add(lbl20thResult, gbc_lblBottom20Dynamic);

		//'C' grade label
		lblC = new JLabel("C");
		lblC.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblC = new GridBagConstraints();
		gbc_lblC.insets = new Insets(0, 0, 5, 5);
		gbc_lblC.gridx = 1;
		gbc_lblC.gridy = 10;
		frmGradebook.getContentPane().add(lblC, gbc_lblC);

		//'number of C's' result display label
		lblCResult = new JLabel(" ");
		lblCResult.setForeground(Color.WHITE);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 10;
		frmGradebook.getContentPane().add(lblCResult, gbc_label);
			
		//'70th percentile' label
		lbl70th = new JLabel("70th Percentile");
		lbl70th.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblMiddle = new GridBagConstraints();
		gbc_lblMiddle.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddle.gridx = 4;
		gbc_lblMiddle.gridy = 10;
		frmGradebook.getContentPane().add(lbl70th, gbc_lblMiddle);

		// 'D' grade label
		lblD = new JLabel("D");
		lblD.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblD = new GridBagConstraints();
		gbc_lblD.insets = new Insets(0, 0, 5, 5);
		gbc_lblD.gridx = 1;
		gbc_lblD.gridy = 11;
		frmGradebook.getContentPane().add(lblD, gbc_lblD);

		//'number of D's' result display label
		lblDResult = new JLabel(" ");
		lblDResult.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 11;
		frmGradebook.getContentPane().add(lblDResult, gbc_label_1);
			
		//70th percentile result display label
		lbl70thResult = new JLabel(" ");
		lbl70thResult.setBackground(Color.WHITE);
		lbl70thResult.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblMiddle70Dynamic = new GridBagConstraints();
		gbc_lblMiddle70Dynamic.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddle70Dynamic.gridx = 4;
		gbc_lblMiddle70Dynamic.gridy = 11;
		frmGradebook.getContentPane().add(lbl70thResult, gbc_lblMiddle70Dynamic);

		//'E' grade label
		lblE = new JLabel("E");
		lblE.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblE = new GridBagConstraints();
		gbc_lblE.insets = new Insets(0, 0, 5, 5);
		gbc_lblE.gridx = 1;
		gbc_lblE.gridy = 12;
		frmGradebook.getContentPane().add(lblE, gbc_lblE);

		//'number of E's' result display label
		lblEResult = new JLabel(" ");
		lblEResult.setForeground(Color.WHITE);
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 2;
		gbc_label_2.gridy = 12;
		frmGradebook.getContentPane().add(lblEResult, gbc_label_2);
			
		//'90th percentile' label
		lbl90th = new JLabel("90th Percentile");
		lbl90th.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblTop = new GridBagConstraints();
		gbc_lblTop.insets = new Insets(0, 0, 5, 5);
		gbc_lblTop.gridx = 4;
		gbc_lblTop.gridy = 12;
		frmGradebook.getContentPane().add(lbl90th, gbc_lblTop);

		//90th percentile result display label
		lbl90thResult = new JLabel(" ");
		lbl90thResult.setBackground(Color.WHITE);
		lbl90thResult.setForeground(new Color(255, 255, 255));
	}//initialize labels method
	
	private void initializeButtons() {
		btnUploadGrades();
		btnChangeGradeRange();
		btnPrintReport();
		btnSetMinMax();
		btnUpdateGrades();
	}//initialize buttons method
	
	private void btnUploadGrades() {
		//upload grades button 
		btnUploadGrades = new JButton("Upload Grades");
		GridBagConstraints gbcUploadGrades = new GridBagConstraints();
		gbcUploadGrades.insets = new Insets(0, 0, 5, 5);
		gbcUploadGrades.gridwidth = 2;
		gbcUploadGrades.gridx = 0;
		gbcUploadGrades.gridy = 1;
		frmGradebook.getContentPane().add(btnUploadGrades, gbcUploadGrades);
	}//upload grades button actions
	
	private void btnUpdateGrades() {
		//initialize updateGrades button
		btnUpdateGrades = new JButton("Update Grades");
		btnUpdateGrades.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbcUpdateGrades= new GridBagConstraints();
		gbcUpdateGrades.insets = new Insets(0, 0, 0, 5);
		gbcUpdateGrades.gridx = 7;
		gbcUpdateGrades.gridy = 14;
		frmGradebook.getContentPane().add(btnUpdateGrades, gbcUpdateGrades);
	}
		
	private void btnSetMinMax() {
		GridBagConstraints gbc_lblTop10Dynamic = new GridBagConstraints();
		gbc_lblTop10Dynamic.insets = new Insets(0, 0, 5, 5);
		gbc_lblTop10Dynamic.gridx = 4;
		gbc_lblTop10Dynamic.gridy = 13;
		frmGradebook.getContentPane().add(lbl90thResult, gbc_lblTop10Dynamic);
		//initialize btnSetMinMax
		btnSetMinMax = new JButton("Set Min/Max Grade");
		btnSetMinMax.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_btnSetMinmax = new GridBagConstraints();
		gbc_btnSetMinmax.insets = new Insets(0, 0, 0, 5);
		gbc_btnSetMinmax.gridx = 5;
		gbc_btnSetMinmax.gridy = 14;
		frmGradebook.getContentPane().add(btnSetMinMax, gbc_btnSetMinmax);			
	}//betSetMinMax() method

	private void btnChangeGradeRange() {
	}//btnChangeGradeRange() method
	
	private void btnPrintReport() {
		//initialize print report button
		btnPrintReport = new JButton("Print Report");
		GridBagConstraints gbc_btnPrintReport_1 = new GridBagConstraints();
		gbc_btnPrintReport_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrintReport_1.gridx = 4;
		gbc_btnPrintReport_1.gridy = 1;
		frmGradebook.getContentPane().add(btnPrintReport, gbc_btnPrintReport_1);	
	}//btnPrintReport() method
	
	private void initializePanes() {
		editorPaneT = new JEditorPane();
		editorPane = new JScrollPane(editorPaneT);
		textPane = new JTextPane();
		textPaneT = new JScrollPane(textPane);
		textPaneT.setBackground(new Color(30, 144, 255));
		textPane.setForeground(Color.WHITE);
		textPane.setBackground(new Color(30, 144, 255));
		GridBagConstraints gbc_textPaneT = new GridBagConstraints();
		gbc_textPaneT.fill = GridBagConstraints.BOTH;
		gbc_textPaneT.insets = new Insets(0, 0, 5, 5);
		gbc_textPaneT.gridheight = 11;
		gbc_textPaneT.gridx = 5;
		gbc_textPaneT.gridy = 2;
		frmGradebook.getContentPane().add(textPaneT, gbc_textPaneT);
		
		editorPane.setBackground(new Color(255, 255, 255));
		editorPaneT.setForeground(Color.BLACK);
		GridBagConstraints gbc_editorPane = new GridBagConstraints();
		gbc_editorPane.fill = GridBagConstraints.BOTH;
		gbc_editorPane.insets = new Insets(0, 0, 5, 5);
		gbc_editorPane.gridheight = 11;
		gbc_editorPane.gridx = 7;
		gbc_editorPane.gridy = 2;
		frmGradebook.getContentPane().add(editorPane, gbc_editorPane);
	}
	
	public JButton getBtnUploadGrades() {
		return btnUploadGrades;
	}
	
	public JButton getBtnPrintReport() {
		return btnPrintReport;
	}
	
	public JButton getBtnChangeGrade() {
		return btnChangeGrade;
	}
	
	public JButton getBtnUpdateGrades() {
		return btnUpdateGrades;
	}
	
	public JButton getBtnSetMinMax() {
		return btnSetMinMax;
	}

	public JFrame getFrmGradebook() {
		return frmGradebook;
	}

	public JEditorPane getEditorPaneT() {
		return editorPaneT;
	}
	
	public JLabel getLblHighResult() {
		return lblHighResult;
	}
	
	public JLabel getLblLowResult() {
		return lblLowResult;
	}
	
	public JLabel getLblAverageResult() {
		return lblAverageResult;
	}
	
	public JLabel getLblMedianResult() {
		return lblMedianResult;
	}
	
	public JTextPane getTextPane() {
		return textPane;
	}
	
	public JLabel getLblAResult() {
		return lblAResult;
	}
	
	public JLabel getLblBResult() {
		return lblBResult;
	}
	
	public JLabel getLblCResult() {
		return lblCResult;
	}
	
	public JLabel getLblDResult() {
		return lblDResult;
	}
	
	public JLabel getLblEResult() {
		return lblEResult;
	}
	
	public JLabel getLbl20thResult() {
		return lbl20thResult;
	}
	
	public JLabel getLbl70thResult() {
		return lbl70thResult;
	}
	
	public JLabel getLbl90thResult() {
		return lbl90thResult;
	}
}





