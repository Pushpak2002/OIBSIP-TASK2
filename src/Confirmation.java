import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Project.ConnectionBuilder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Confirmation extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t5;
	private JTextField t7;
	private JTextField t8;
	private JTextField t4;
	private JTextField t6;
	private JTextField t9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String s = "0";
					Confirmation frame = new Confirmation(s);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public Confirmation(String s1) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 20, 748, 471);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("PNR");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(28, 115, 67, 24);
		panel.add(lblNewLabel_1);
		
		t1 = new JTextField();
		t1.setBounds(116, 72, 137, 19);
		panel.add(t1);
		t1.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Train Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(380, 158, 96, 24);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Date");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(39, 67, 67, 24);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Train No.");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(28, 158, 96, 24);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Jur Start");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3_1.setBounds(28, 213, 96, 24);
		panel.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Jur End");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3_2.setBounds(380, 213, 96, 24);
		panel.add(lblNewLabel_1_3_2);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Passenger Name");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3_1_1.setBounds(28, 282, 165, 24);
		panel.add(lblNewLabel_1_3_1_1);
		
		JLabel lblNewLabel_1_3_1_2 = new JLabel("Age");
		lblNewLabel_1_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3_1_2.setBounds(28, 342, 96, 24);
		panel.add(lblNewLabel_1_3_1_2);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(116, 115, 137, 19);
		panel.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(116, 163, 137, 19);
		panel.add(t3);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(116, 218, 137, 19);
		panel.add(t5);
		
		t7 = new JTextField();
		t7.setColumns(10);
		t7.setBounds(169, 287, 137, 19);
		panel.add(t7);
		
		t8 = new JTextField();
		t8.setColumns(10);
		t8.setBounds(116, 342, 137, 19);
		panel.add(t8);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(538, 163, 137, 19);
		panel.add(t4);
		
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(538, 218, 137, 19);
		panel.add(t6);
		
		t9 = new JTextField();
		t9.setColumns(10);
		t9.setBounds(116, 399, 137, 19);
		panel.add(t9);
		
		JLabel lblNewLabel_1_3_1_2_1 = new JLabel("Ticket");
		lblNewLabel_1_3_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3_1_2_1.setBounds(28, 394, 96, 24);
		panel.add(lblNewLabel_1_3_1_2_1);
		
		
		                                // Main Code//
		
		int PNR = Integer.parseInt(s1);
		String pn = Integer.toString(PNR);
		
		
		
		JLabel lblNewLabel = new JLabel("Details");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(340, 10, 96, 24);
		panel.add(lblNewLabel);
		int trainno=0;
		
		try {
			t2.setText(s1);
			Connection con = ConnectionBuilder.getcon();
			Statement st=con.createStatement();
			String sql = "select TrainNo from reservation where PNR = "+ PNR;
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
			 trainno = rs.getInt("TrainNo");
				String tra = Integer.toString(trainno);
				t3.setText(tra);
			}	
			sql = "select TrainName from traindetails where TrainNo = "+ trainno;
			rs = st.executeQuery(sql);
			if(rs.next())
			{
				String s = rs.getString("TrainName");
				t4.setText(s);
			}	
			
			 sql = "select * from reservation where PNR = "+ PNR;
			 rs = st.executeQuery(sql);
			if(rs.next())
			{
				String date = rs.getString("date");
				t1.setText(date);
				String f = rs.getString("from");
				t5.setText(f);
				String t = rs.getString("to");
				t6.setText(t);
				
			}
			sql = "select PassangerName from passenger where PNR = " + PNR;
			rs = st.executeQuery(sql);
			if(rs.next())
			{
				String s = rs.getString("PassangerName");
				t7.setText(s);
			}
			sql = "select age from passenger where PNR = " + PNR;
			rs = st.executeQuery(sql);
			if(rs.next())
			{
				int age = rs.getInt("age");
				String s = Integer.toString(age);
				t8.setText(s);
			}
			int tno = Integer.parseInt(t3.getText());
			sql = "select TicketPrice from ticket where TrainNo ="+ tno;
			rs = st.executeQuery(sql);
			if(rs.next())
			{
				int price = rs.getInt("TicketPrice");
				String s = Integer.toString(price);
				t9.setText(s);
			}
			con.close();
		}
		catch(Exception c)
		{
			
		}
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String s = null;
				Passenger p = new Passenger(s1);
				p.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton b1 = new JButton("Confirm");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String f = t1.getText();
				String s3 = t3.getText();
				String s4 = t4.getText();
				String s5 = t5.getText();
				String s6 = t6.getText();
				String s7 = t7.getText();
				
				int pnr = Integer.parseInt(s1);
				try {
					
					Connection con = ConnectionBuilder.getcon();
					String sql = "insert into finalreservation values(?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1,f);	
					ps.setInt(2,pnr);		
					int n = Integer.parseInt(s3);
					ps.setInt(3,n);		
					ps.setString(4, s4);			
					ps.setString(5, s7);
					int age = Integer.parseInt(t8.getText());
					ps.setInt(6, age);
					ps.setString(7, s5);
					ps.setString(8, s6);
					int tic = Integer.parseInt(t9.getText());
					ps.setInt(9, tic);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Your ticket is confirmed");
					con.close();
					Main m = new Main();
					m.setVisible(true);
					dispose();
				}
				catch(Exception c)
				{
					
				}
				
			}
		});
		b1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		b1.setBounds(307, 440, 129, 21);
		panel.add(b1);
	}
	
	}
