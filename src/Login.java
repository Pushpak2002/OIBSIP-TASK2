import java.awt.EventQueue;
import java.sql.*;
import java.util.logging.Logger;

//import Project.ConnectionBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax. swing. *;
import java.sql.*;
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(232, 231, 233));
		panel.setBounds(97, 79, 463, 254);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(196, 32, 60, 30);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = t1.getText();
				String s2 = t2.getText();
				
				if(s1.equals("") && s2.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please enter id and password");
				}
				
				else if(s1.equals("Admin") && s2.equals("Pass"))
				{
					
					Main m = new Main();
					m.setVisible(true);
					dispose();
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect user id and password");
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(196, 197, 85, 21);
		panel.add(btnNewButton);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setForeground(new Color(128, 128, 255));
		panel_1.setBounds(75, 68, 339, 112);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("UserId");
		lblNewLabel_1.setBounds(52, 23, 41, 18);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		t1 = new JTextField();
		t1.setBounds(171, 24, 96, 19);
		panel_1.add(t1);
		t1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(52, 64, 82, 13);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(171, 64, 96, 19);
		panel_1.add(t2);
		
		
		
	}
}
