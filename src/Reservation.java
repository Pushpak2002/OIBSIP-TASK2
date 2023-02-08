import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import Project.ConnectionBuilder;
import java.util.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;

public class Reservation extends JFrame {

	private JPanel contentPane;
	private JTextField t3;
	private JTextField t4;
	private JTextField t6;
	private JTextField t7;
	private JComboBox<Integer> t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation frame = new Reservation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public int Random()
	{
		int num = 0;
		Random r = new Random();
		num = r.nextInt(10000);
		return num;
	}
	int PNR = Random();
	private JTextField t8;
	
	public void fillcombobox()
	{
		try {
			Connection con = ConnectionBuilder.getcon();
			String sql = "select TrainNo from traindetails";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next())
			{
				t1.addItem(rs.getInt("TrainNo"));
			}
			con.close();
		}
		catch(Exception c)
		{
			
		}
	}
	
	
	public Reservation() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 25, 654, 456);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Train No.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(26, 115, 104, 29);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Jur Start");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(26, 192, 94, 13);
		panel.add(lblNewLabel_1);
		
		t3 = new JTextField();
		t3.setBounds(186, 191, 96, 19);
		panel.add(t3);
		t3.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Jur End");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(356, 192, 94, 18);
		panel.add(lblNewLabel_1_1);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(466, 191, 96, 19);
		panel.add(t4);
		
		JDateChooser t5 = new JDateChooser();
		t5.setBounds(186, 246, 142, 19);
		panel.add(t5);
		
		 t1 = new JComboBox<Integer>();
		t1.setBounds(169, 121, 159, 21);
		panel.add(t1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Jur Date");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(26, 252, 94, 13);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Reservation details");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(259, 49, 269, 39);
		panel.add(lblNewLabel_2);
		
		
		fillcombobox();
		int TrainNo = (Integer) t1.getSelectedItem();
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = ConnectionBuilder.getcon();
					String sql = "insert into reservation values(?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1,TrainNo);
					ps.setInt(2,PNR);
					ps.setString(3,t3.getText());
					ps.setString(4, t4.getText());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(t5.getDate());
					ps.setString(5, date);
					ps.executeUpdate();
					con.close();
				}
				catch(Exception c)
				{
					
				}
				
				// sql = "insert into reservation values(" + t1.getText()+"," + t2.getText()+",'" + t3.getText()+"','" + t4.getText()+"','" + t5.getText()+"')";
				
				
				String s1 = Integer.toString(PNR);    // S1 is copy of PNR in form of String
				Passenger p = new Passenger(s1);
				p.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(232, 406, 152, 40);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ticket(Adult)");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1.setBounds(26, 297, 128, 29);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Ticket(Child)");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1_1.setBounds(26, 352, 128, 29);
		panel.add(lblNewLabel_1_2_1_1);
		
		t6 = new JTextField();
		t6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					Connection con = ConnectionBuilder.getcon();
					Statement st=con.createStatement();
					String sql = "select ticketPrice from Ticket where TrainNo = "+TrainNo;
					ResultSet rs = st.executeQuery(sql);
					if(rs.next())
					{
						int price = rs.getInt("TicketPrice");
						sql = Integer.toString(price);
						t6.setText(sql);
						price=price/2;
						sql = Integer.toString(price);
						t7.setText(sql);
						con.close();
					}	
				}
				catch(Exception c)
				{
					
				}
				
				
			}
		});
		t6.setColumns(10);
		t6.setBounds(186, 304, 96, 19);
		panel.add(t6);
		
		t7 = new JTextField();
		t7.setColumns(10);
		t7.setBounds(186, 359, 96, 19);
		panel.add(t7);
		
		JLabel lblTrainName = new JLabel("Train Name");
		lblTrainName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrainName.setBounds(346, 115, 104, 29);
		panel.add(lblTrainName);
		
		t8 = new JTextField();
		t8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					Connection con = ConnectionBuilder.getcon();
					Statement st=con.createStatement();
					String sql = "select TrainName from traindetails where TrainNo = "+ TrainNo;
					
					ResultSet rs = st.executeQuery(sql);
					if(rs.next())
					{
						String s = rs.getString("TrainName");
						t8.setText(s);
						con.close();
					}	
				}
				catch(Exception c)
				{
					
				}
				
			}
		});
		t8.setColumns(10);
		t8.setBounds(466, 122, 128, 19);
		panel.add(t8);
		
		
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = ConnectionBuilder.getcon();
					String sql = "DELETE FROM reservation WHERE pnr = "+ PNR;
					PreparedStatement ps=con.prepareStatement(sql);
					ps.executeUpdate();
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
		btnNewButton_1.setBounds(0, 0, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
