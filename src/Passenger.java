import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Project.ConnectionBuilder;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import java.awt.Color;
import java.util.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.DefaultComboBoxModel;

public class Passenger extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField t3;
	private JTextField t4;
	private JTable table_1;
	private JComboBox c2;
	private JComboBox c1;
	private JComboBox c3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String s3 = "PNR";
					Passenger frame = new Passenger(s3);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public int Random1()
	{
		int id = 0;
		Random r = new Random();
		id = r.nextInt(10);
		return id;
	}
	
	public Passenger(String s2) // s2 is act as a PNR//
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 20, 662, 466);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel i2 = new JLabel("1");
		i2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		i2.setBounds(365, 210, 57, 41);
		panel.add(i2);
		
		JLabel lblNewLabel = new JLabel("Passanger Details");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(242, 10, 210, 67);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Passenger");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i =1;
				String a = (String)c1.getSelectedItem();
				String b = (String)c2.getSelectedItem();
				int ans = Integer.parseInt(a) + Integer.parseInt(b);
				String i1 = Integer.toString(i+1);
				i2.setText(i1);
				while(i < ans)
				{
					try {
						Connection con = ConnectionBuilder.getcon();
						String sql = "insert into passenger values(?,?,?,?,?)";
						PreparedStatement ps=con.prepareStatement(sql);
						int PNR = Integer.parseInt(s2);
						ps.setInt(1,i);
						
						ps.setInt(2,PNR);
						ps.setString(3,t3.getText());
						ps.setString(4, t4.getText());
						String g = (String) c3.getSelectedItem();
						ps.setString(5, g);
						ps.executeUpdate();
						con.close();
						i++;
						t3.setText(null);
						t4.setText(null);
					}
					catch(Exception c1)
					{
						
					}
				}
				if(i == ans)
				{
					try {
						JButton btnNewButton = new JButton("Submit");
						Connection con = ConnectionBuilder.getcon();
						String sql = "insert into passenger values(?,?,?,?)";
						PreparedStatement ps=con.prepareStatement(sql);
						int PNR = Integer.parseInt(s2);
						ps.setInt(1,Random1());
						
						ps.setInt(2,PNR);
						ps.setString(3,t3.getText());
						ps.setString(4, t4.getText());
						String g = (String) c3.getSelectedItem();
						ps.setString(5, g);
						ps.executeUpdate();
						con.close();
						JOptionPane.showMessageDialog(null, "Want to proceed to next step?");
						Confirmation c = new Confirmation(s2);
						c.setVisible(true);
						dispose();
					}
					catch(Exception c1)
					{
						
					}
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(257, 387, 170, 32);
		panel.add(btnNewButton);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(221, 334, 1, 1);
		panel.add(desktopPane);
		
		table = new JTable();
		table.setBounds(28, 359, 131, -52);
		panel.add(table);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblName.setBounds(82, 248, 57, 41);
		panel.add(lblName);
		
		JLabel i1 = new JLabel("");
		i1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		i1.setBounds(242, 156, 57, 41);
		panel.add(i1);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(209, 261, 193, 19);
		panel.add(t3);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAge.setBounds(82, 286, 57, 49);
		panel.add(lblAge);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(209, 305, 193, 19);
		panel.add(t4);
		
		JLabel lblAdult = new JLabel("Adult");
		lblAdult.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAdult.setBounds(52, 100, 57, 41);
		panel.add(lblAdult);
		
		 c1 = new JComboBox();
		c1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				String a = (String)c1.getSelectedItem();
				String b = (String)c2.getSelectedItem();
				int c = Integer.parseInt(a) + Integer.parseInt(b);
				i1.setText(Integer.toString(c));
				
			}
		});
		c1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		 c1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6"}));
		c1.setBounds(135, 112, 65, 21);
		panel.add(c1);
		
		JLabel lblChild = new JLabel("Child");
		lblChild.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblChild.setBounds(289, 100, 57, 41);
		panel.add(lblChild);
		
		 c2 = new JComboBox();
		 c2.addMouseListener(new MouseAdapter() {
		 	
		 	@Override
		 	public void mouseExited(MouseEvent e) {
		 		
		 		String a = (String)c1.getSelectedItem();
				String b = (String)c2.getSelectedItem();
				int c = Integer.parseInt(a) + Integer.parseInt(b);
				i1.setText(Integer.toString(c));
		 	}
		 });
		c2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6"}));
		c2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		c2.setBounds(404, 112, 65, 21);
		panel.add(c2);
		
		JLabel lblTotalPassenger = new JLabel("Total Passenger = ");
		lblTotalPassenger.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTotalPassenger.setBounds(52, 156, 170, 41);
		panel.add(lblTotalPassenger);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblGender.setBounds(82, 334, 77, 49);
		panel.add(lblGender);
		
		 c3 = new JComboBox();
		c3.setToolTipText("");
		c3.setModel(new DefaultComboBoxModel(new String[] {"--select--", "Male", "Female", "Trans"}));
		c3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		c3.setBounds(208, 345, 193, 21);
		panel.add(c3);
		
		JLabel lblNewLabel_1 = new JLabel("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
		lblNewLabel_1.setBounds(10, 193, 642, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Passanger Details");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(202, 207, 153, 44);
		panel.add(lblNewLabel_2);
		
		
		
		
		
		table_1 = new JTable();
		table_1.setBackground(new Color(255, 128, 0));
		table_1.setBounds(570, 320, -63, -118);
		contentPane.add(table_1);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = ConnectionBuilder.getcon();
					int PNR = Integer.parseInt(s2);
					String sql = "DELETE FROM passenger WHERE pnr = "+ PNR;
					PreparedStatement ps=con.prepareStatement(sql);
					ps.executeUpdate();
					con.close();
					Reservation r = new Reservation();
					r.setVisible(true);
					dispose();

					
				}
				catch(Exception c)
				{
					
				}
				Reservation r = new Reservation();
				r.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(0, 0, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
