
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Magic8ball extends JFrame{
	private JPanel topPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	JLabel textField = new JLabel ("Ask a question and shake!");

	private int message;
	
	public Magic8ball(){	
		
		initGUI();
		
		setTitle("Game Window");
		setSize(700, 200); //pixels
		setResizable(false);
		pack();
		setLocationRelativeTo(null); //centers on screen, do this after packing but before visible

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	public void initGUI(){
		
		add(topPanel, BorderLayout.PAGE_START);
		topPanel.setBackground(Color.black);
		topPanel.add(textField);
		textField.setHorizontalAlignment(JLabel.CENTER);
		
		Font textFont = new Font("Times New Roman", Font.PLAIN, 64);
		textField.setFont(textFont);
		textField.setForeground(Color.white);
		Dimension size = new Dimension (700, 100);
		topPanel.setPreferredSize(size);
		topPanel.setSize(getPreferredSize());
		
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setBackground(Color.white);
		Dimension questionDimensions = new Dimension (600, 30);
		centerPanel.setPreferredSize(questionDimensions);
		centerPanel.setSize(getPreferredSize());
		JTextField question = new JTextField(16);
		centerPanel.add(question, BorderLayout.CENTER);
		question.setHorizontalAlignment(JLabel.CENTER);
		
		
		JPanel buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.PAGE_END);
		buttonPanel.setBackground(Color.black);
		Font buttonFont = new Font("Times New Roman", Font.PLAIN, 25);
		
		JButton button = new JButton("shake");
		
		button.setFont(buttonFont);
		button.setForeground(Color.white);
		button.setBackground(Color.black);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateMessage();
			}
		});
		buttonPanel.add(button);
		
		Dimension sizeButtonPanel = new Dimension (600, 50);
		buttonPanel.setPreferredSize(sizeButtonPanel);
		buttonPanel.setSize(getPreferredSize());
	}
	
	public void generateMessage() {
		int message = (int) (Math.random() * 10) + 1;
		String m = "";
		if (message == 1) {
			m = "It is certain";
		} else if (message == 2) {
			m = "Don't count on it";
		} else if (message == 3) {
			m = "I'm not sure, give it another shake";
		} else if (message == 4) {
			m = "Yes definitely";
		} else if (message == 5) {
			m = "Without a doubt. 100%";
		} else if (message == 6) {
			m = "Ask again later";
		} else if (message == 7) {
			m = "My reply is no";
		} else if (message == 8) {
			m = "My sources say no";
		} else if (message == 9) {
			m = "Cannot predict now";
		} else if (message == 10) {
			m = "Very doubtful";
		}
		textField.setText(m);
	}
	
	
	public static void main(String[] args) {
		try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch ( Exception e) {}
        
        EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
                new Magic8ball();
            }   
        });

	}

}