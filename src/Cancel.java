import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Project.ConnectionBuilder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Cancel extends JFrame {

	private JPanel contentPane;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cancel frame = new Cancel();
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
	public Cancel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 25, 655, 458);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reservation Cancellation");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(201, 30, 266, 65);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter PNR");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(40, 120, 158, 32);
		panel.add(lblNewLabel_1);
		
		t1 = new JTextField();
		t1.setBounds(167, 122, 158, 32);
		panel.add(t1);
		t1.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p = t1.getText();
				int PNR = Integer.parseInt(p);
				JOptionPane.showMessageDialog(null, "Want to confirm delete?");
				
				try {
					Connection con = ConnectionBuilder.getcon();
					String sql = "DELETE FROM reservation WHERE pnr = "+ PNR;
					PreparedStatement ps=con.prepareStatement(sql);
					ps.executeUpdate();
					 sql = "DELETE FROM passenger WHERE pnr = "+ PNR;
					 ps=con.prepareStatement(sql);
					 ps.executeUpdate();
					 sql = "DELETE FROM train.finalreservation WHERE pnr = "+ PNR;
					 ps=con.prepareStatement(sql);
					 ps.executeUpdate();
					
						JOptionPane.showMessageDialog(null, "Reservation cancelled!");
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
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(282, 181, 85, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(0, 0, 85, 21);
		contentPane.add(btnNewButton_1);
	}

}
