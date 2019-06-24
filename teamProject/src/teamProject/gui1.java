package teamProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;

public class gui1 {

	private JFrame frmGradebook;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui1 window = new gui1();
					window.frmGradebook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGradebook = new JFrame();
		frmGradebook.setTitle("GRADEBOOK");
		frmGradebook.setBackground(new Color(0, 51, 102));
		frmGradebook.getContentPane().setBackground(new Color(30, 144, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmGradebook.getContentPane().setLayout(gridBagLayout);
		
		JButton btnUploadGrades = new JButton("UPLOAD GRADES");
		GridBagConstraints gbc_btnUploadGrades = new GridBagConstraints();
		gbc_btnUploadGrades.insets = new Insets(0, 0, 5, 5);
		gbc_btnUploadGrades.gridx = 0;
		gbc_btnUploadGrades.gridy = 0;
		frmGradebook.getContentPane().add(btnUploadGrades, gbc_btnUploadGrades);
		
		JButton btnPrintReport = new JButton("PRINT REPORT");
		GridBagConstraints gbc_btnPrintReport = new GridBagConstraints();
		gbc_btnPrintReport.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrintReport.gridx = 1;
		gbc_btnPrintReport.gridy = 0;
		frmGradebook.getContentPane().add(btnPrintReport, gbc_btnPrintReport);
		
		JLabel lblLetterGrades = new JLabel("LETTER GRADES");
		lblLetterGrades.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblLetterGrades = new GridBagConstraints();
		gbc_lblLetterGrades.anchor = GridBagConstraints.SOUTH;
		gbc_lblLetterGrades.gridwidth = 2;
		gbc_lblLetterGrades.insets = new Insets(0, 0, 5, 5);
		gbc_lblLetterGrades.gridx = 6;
		gbc_lblLetterGrades.gridy = 0;
		frmGradebook.getContentPane().add(lblLetterGrades, gbc_lblLetterGrades);
		
		JLabel lblGrades = new JLabel("GRADES");
		lblGrades.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblGrades = new GridBagConstraints();
		gbc_lblGrades.anchor = GridBagConstraints.SOUTH;
		gbc_lblGrades.insets = new Insets(0, 0, 5, 5);
		gbc_lblGrades.gridx = 9;
		gbc_lblGrades.gridy = 0;
		frmGradebook.getContentPane().add(lblGrades, gbc_lblGrades);
		
		JTextPane textPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridheight = 12;
		gbc_textPane.gridwidth = 2;
		gbc_textPane.insets = new Insets(0, 0, 5, 5);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 6;
		gbc_textPane.gridy = 1;
		frmGradebook.getContentPane().add(textPane, gbc_textPane);
		
		JEditorPane editorPane = new JEditorPane();
		GridBagConstraints gbc_editorPane = new GridBagConstraints();
		gbc_editorPane.gridheight = 12;
		gbc_editorPane.insets = new Insets(0, 0, 5, 5);
		gbc_editorPane.fill = GridBagConstraints.BOTH;
		gbc_editorPane.gridx = 9;
		gbc_editorPane.gridy = 1;
		frmGradebook.getContentPane().add(editorPane, gbc_editorPane);
		
		JLabel lblHigh = new JLabel("HIGH");
		lblHigh.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblHigh = new GridBagConstraints();
		gbc_lblHigh.insets = new Insets(0, 0, 5, 5);
		gbc_lblHigh.gridx = 0;
		gbc_lblHigh.gridy = 2;
		frmGradebook.getContentPane().add(lblHigh, gbc_lblHigh);
		
		JLabel lblHighDynamic = new JLabel("");
		lblHighDynamic.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblHighDynamic = new GridBagConstraints();
		gbc_lblHighDynamic.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighDynamic.gridx = 1;
		gbc_lblHighDynamic.gridy = 2;
		frmGradebook.getContentPane().add(lblHighDynamic, gbc_lblHighDynamic);
		
		JLabel lblLow = new JLabel("LOW");
		lblLow.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblLow = new GridBagConstraints();
		gbc_lblLow.anchor = GridBagConstraints.BASELINE;
		gbc_lblLow.insets = new Insets(0, 0, 5, 5);
		gbc_lblLow.gridx = 0;
		gbc_lblLow.gridy = 3;
		frmGradebook.getContentPane().add(lblLow, gbc_lblLow);
		
		JLabel lblLowDynamic = new JLabel("");
		lblLowDynamic.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblLowDynamic = new GridBagConstraints();
		gbc_lblLowDynamic.insets = new Insets(0, 0, 5, 5);
		gbc_lblLowDynamic.gridx = 1;
		gbc_lblLowDynamic.gridy = 3;
		frmGradebook.getContentPane().add(lblLowDynamic, gbc_lblLowDynamic);
		
		JLabel lblAverage = new JLabel("AVERAGE");
		lblAverage.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblAverage = new GridBagConstraints();
		gbc_lblAverage.insets = new Insets(0, 0, 5, 5);
		gbc_lblAverage.gridx = 0;
		gbc_lblAverage.gridy = 4;
		frmGradebook.getContentPane().add(lblAverage, gbc_lblAverage);
		
		JLabel lblAverageDynamic = new JLabel("");
		lblAverageDynamic.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblAverageDynamic = new GridBagConstraints();
		gbc_lblAverageDynamic.insets = new Insets(0, 0, 5, 5);
		gbc_lblAverageDynamic.gridx = 1;
		gbc_lblAverageDynamic.gridy = 4;
		frmGradebook.getContentPane().add(lblAverageDynamic, gbc_lblAverageDynamic);
		
		JLabel lblMedian = new JLabel("MEDIAN");
		lblMedian.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblMedian = new GridBagConstraints();
		gbc_lblMedian.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedian.gridx = 0;
		gbc_lblMedian.gridy = 5;
		frmGradebook.getContentPane().add(lblMedian, gbc_lblMedian);
		
		JLabel lblMedianDynamic = new JLabel("");
		lblMedianDynamic.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblMedianDynamic = new GridBagConstraints();
		gbc_lblMedianDynamic.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedianDynamic.gridx = 1;
		gbc_lblMedianDynamic.gridy = 5;
		frmGradebook.getContentPane().add(lblMedianDynamic, gbc_lblMedianDynamic);
		
		JLabel lblDistribution = new JLabel("DISTRIBUTION");
		lblDistribution.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblDistribution = new GridBagConstraints();
		gbc_lblDistribution.insets = new Insets(0, 0, 5, 5);
		gbc_lblDistribution.gridx = 0;
		gbc_lblDistribution.gridy = 7;
		frmGradebook.getContentPane().add(lblDistribution, gbc_lblDistribution);
		
		JButton btnChange = new JButton("CHANGE GRADE RANGE");
		btnChange.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnChange = new GridBagConstraints();
		gbc_btnChange.insets = new Insets(0, 0, 5, 5);
		gbc_btnChange.gridx = 1;
		gbc_btnChange.gridy = 7;
		frmGradebook.getContentPane().add(btnChange, gbc_btnChange);
		
		JLabel lblA = new JLabel("A");
		lblA.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblA = new GridBagConstraints();
		gbc_lblA.insets = new Insets(0, 0, 5, 5);
		gbc_lblA.gridx = 0;
		gbc_lblA.gridy = 8;
		frmGradebook.getContentPane().add(lblA, gbc_lblA);
		
		JLabel lblB = new JLabel("B");
		lblB.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblB = new GridBagConstraints();
		gbc_lblB.insets = new Insets(0, 0, 5, 5);
		gbc_lblB.gridx = 0;
		gbc_lblB.gridy = 9;
		frmGradebook.getContentPane().add(lblB, gbc_lblB);
		
		JLabel lblC = new JLabel("C");
		lblC.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblC = new GridBagConstraints();
		gbc_lblC.insets = new Insets(0, 0, 5, 5);
		gbc_lblC.gridx = 0;
		gbc_lblC.gridy = 10;
		frmGradebook.getContentPane().add(lblC, gbc_lblC);
		
		JLabel lblD = new JLabel("D");
		lblD.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblD = new GridBagConstraints();
		gbc_lblD.insets = new Insets(0, 0, 5, 5);
		gbc_lblD.gridx = 0;
		gbc_lblD.gridy = 11;
		frmGradebook.getContentPane().add(lblD, gbc_lblD);
		
		JLabel lblE = new JLabel("E");
		lblE.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblE = new GridBagConstraints();
		gbc_lblE.insets = new Insets(0, 0, 5, 5);
		gbc_lblE.gridx = 0;
		gbc_lblE.gridy = 12;
		frmGradebook.getContentPane().add(lblE, gbc_lblE);
		
		JButton btnSaveGradesTo = new JButton("SAVE TO FILE");
		btnSaveGradesTo.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_btnSaveGradesTo = new GridBagConstraints();
		gbc_btnSaveGradesTo.insets = new Insets(0, 0, 0, 5);
		gbc_btnSaveGradesTo.gridx = 9;
		gbc_btnSaveGradesTo.gridy = 14;
		frmGradebook.getContentPane().add(btnSaveGradesTo, gbc_btnSaveGradesTo);
		frmGradebook.setBounds(100, 100, 723, 419);
		frmGradebook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
