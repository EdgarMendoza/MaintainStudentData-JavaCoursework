import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDisplay extends JFrame
{
	//Variables for program data
	private PersonQueries personQueries;
	
	//Variables for display window
	private JButton previousButton, nextButton;
	private JButton findButton1, findButton2;
	private JButton browseButton, insertButton, updateButton;
	
	private JTextField countField1, countField2;
	private JTextField idField, firstNameField, lastNameField, majorField, emailField, phoneNumberField, dobField, addressField, zipField;
	private JTextField findIDField, findLastNameField;
	
	private JLabel ofLabel, idLabel, firstNameLabel, lastNameLabel, majorLabel, emailLabel, phoneNumberLabel, dobLabel, addressLabel, zipLabel;
	private JLabel findIDLabel, findLastNameLabel;
	
	private JPanel navigationPanel, infoPanel, findIDPanel, findLastNamePanel, bottomButtonsPanel;
	
	public StudentDisplay()
	{
		super("Maintain Student Data");
		setLayout(new FlowLayout(FlowLayout.CENTER, 35, 5));
		setSize(500, 450);
		setResizable(false);
		
		//start database connection
		personQueries = new PersonQueries(); //NOTE: changed userId and password to that specified in the email
		
		//Top Navigation Area
		navigationPanel = new JPanel();
		navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.X_AXIS));
		previousButton = new JButton("Previous");
		previousButton.setEnabled(false);
		countField1 = new JTextField(2);
		countField1.setHorizontalAlignment(JTextField.CENTER);
		ofLabel = new JLabel("of");
		countField2 = new JTextField(2);
		countField2.setHorizontalAlignment(JTextField.CENTER);
		countField2.setEditable(false);
		nextButton = new JButton("Next");
		nextButton.setEnabled(false);
		
		previousButton.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed (ActionEvent event)
				{
					previousButtonActionPerformed(event);
				}
			}
		);
		countField1.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					indexTextFieldActionPerformed(event);
				}
			}
		);
		nextButton.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					nextButtonActionPerformed(event);
				}
			}
		);
		
		navigationPanel.add(previousButton);
		navigationPanel.add(Box.createHorizontalStrut(10));
		navigationPanel.add(countField1);
		navigationPanel.add(Box.createHorizontalStrut(10));
		navigationPanel.add(ofLabel);
		navigationPanel.add(Box.createHorizontalStrut(10));
		navigationPanel.add(countField2);
		navigationPanel.add(Box.createHorizontalStrut(10));
		navigationPanel.add(nextButton);
		navigationPanel.add(Box.createHorizontalStrut(10));
		
		//Display Information Area
		infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(9, 2, 4, 4));
		idLabel = new JLabel("Student ID:");
		idField = new JTextField();
		firstNameLabel = new JLabel("First Name:");
		firstNameField = new JTextField();
		lastNameLabel = new JLabel("Last Name:");
		lastNameField = new JTextField();
		majorLabel = new JLabel("Major:");
		majorField = new JTextField();
		emailLabel = new JLabel("Email:");
		emailField = new JTextField();
		phoneNumberLabel = new JLabel("Phone Number:");
		phoneNumberField = new JTextField();
		dobLabel = new JLabel("Date of Birth:");
		dobField = new JTextField();
		zipLabel = new JLabel("Zip Code:");
		zipField = new JTextField();
		
		infoPanel.add(idLabel);
		infoPanel.add(idField);
		infoPanel.add(firstNameLabel);
		infoPanel.add(firstNameField);
		infoPanel.add(lastNameLabel);
		infoPanel.add(lastNameField);
		infoPanel.add(majorLabel);
		infoPanel.add(majorField);
		infoPanel.add(emailLabel);
		infoPanel.add(emailField);
		infoPanel.add(phoneNumberLabel);
		infoPanel.add(phoneNumberField);
		infoPanel.add(dobLabel);
		infoPanel.add(dobField);
		infoPanel.add(zipLabel);
		infoPanel.add(zipField);
		
		//Find student by ID area
		findIDPanel = new JPanel();
		findIDPanel.setLayout(new BoxLayout(findIDPanel, BoxLayout.X_AXIS));
		findIDPanel.setBorder(BorderFactory.createTitledBorder("Find an entry by student ID"));
		findIDLabel = new JLabel("Student ID:");
		findIDField = new JTextField(10);
		findButton1 = new JButton("Find");
		
		findButton1.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					findIDActionPerformed(event);
				}
			}
		);
		
		findIDPanel.add(Box.createHorizontalStrut(5));
		findIDPanel.add(findIDLabel);
		findIDPanel.add(Box.createHorizontalStrut(10));
		findIDPanel.add(findIDField);
		findIDPanel.add(Box.createHorizontalStrut(10));
		findIDPanel.add(findButton1);
		findIDPanel.add(Box.createHorizontalStrut(5));
		
		//Find student by last name area
		findLastNamePanel = new JPanel();
		findLastNamePanel.setLayout(new BoxLayout(findLastNamePanel, BoxLayout.X_AXIS));
		findLastNamePanel.setBorder(BorderFactory.createTitledBorder("Find an entry by student last name"));
		findLastNameLabel = new JLabel("Last Name:");
		findLastNameField = new JTextField(10);
		findButton2 = new JButton("Find");
		
		findButton2.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					findLastNameActionPerformed(event);
				}
			}
		);
		
		findLastNamePanel.add(Box.createHorizontalStrut(5));
		findLastNamePanel.add(findLastNameLabel);
		findLastNamePanel.add(Box.createHorizontalStrut(10));
		findLastNamePanel.add(findLastNameField);
		findLastNamePanel.add(Box.createHorizontalStrut(10));
		findLastNamePanel.add(findButton2);
		findLastNamePanel.add(Box.createHorizontalStrut(5));
		
		//Bottom three buttons
		bottomButtonsPanel = new JPanel();
		bottomButtonsPanel.setLayout(new GridLayout(1, 3, 4, 4));
		browseButton = new JButton("Browse All Entries");
		insertButton = new JButton("Insert New Entry");
		updateButton = new JButton("Update Current Entry");
		
		browseButton.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					browseButtonActionPerformed(event);
				}
			}
		);
		insertButton.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					insertButtonActionPerformed(event);
				}
			}
		);
		updateButton.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					updateButtonActionPerformed(event);
				}
			}
		);
		
		bottomButtonsPanel.add(browseButton);
		bottomButtonsPanel.add(insertButton);
		bottomButtonsPanel.add(updateButton);
		
		//add panels to window
		add(navigationPanel);
		add(infoPanel);
		add(findIDPanel);
		add(findLastNamePanel);
		add(bottomButtonsPanel);
		
		addWindowListener
		(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent evt)
				{
					personQueries.close();
					System.exit(0);
				}
			}
		);
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args)
	{
		new StudentDisplay();
	}
}