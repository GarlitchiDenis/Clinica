package ia;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;


import javax.swing.JOptionPane;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultComboBoxModel;

public class newACC extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//dispose();
//new Login().setVisible(true);	
	private JPanel contentPane;
	private JTextField aname;
	private JTextField fname;
	private JPasswordField password;
	private JTextField textField_2;
	private JTextField lname;
	private JTextField ename;
	private JTextField pname;
	private JTextField username;

	/**
	 * Launch the application.
	 */
	static Connection connection =null;		
	PreparedStatement pst= null;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
		{EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newACC frame = new newACC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/logginuser","root","241099");
		if (connection !=null) {
			System.out.println("Conectat");}
	}
	
	
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public newACC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 676);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 742, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRY");
		lblNewLabel.setBackground(new Color(175, 238, 238));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(10, 10, 136, 61);
		panel.add(lblNewLabel);
		
		aname = new JTextField();
		aname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		aname.setBounds(173, 300, 191, 39);
		contentPane.add(aname);
		aname.setColumns(10);
		
		fname = new JTextField();
		fname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fname.setBounds(173, 105, 191, 39);
		contentPane.add(fname);
		fname.setColumns(10);
		
		password = new JPasswordField();
		password.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		password.setBounds(535, 409, 191, 39);
		contentPane.add(password);
		
		JComboBox usertype = new JComboBox();
		usertype.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		usertype.setFont(new Font("Tahoma", Font.PLAIN, 17));
		usertype.setModel(new DefaultComboBoxModel(new String[] {"user"}));
		usertype.setBounds(173, 468, 191, 39);
		contentPane.add(usertype);
		
		JLabel lblUsertype = new JLabel("Usertype");
		lblUsertype.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsertype.setBounds(45, 468, 105, 39);
		contentPane.add(lblUsertype);
		
		JComboBox gname = new JComboBox();
		gname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		gname.setModel(new DefaultComboBoxModel<String>(new String[] {"Male", "Female", "Other"}));
		gname.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gname.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		gname.setBounds(535, 199, 191, 39);
		contentPane.add(gname);
	
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(173, 232, -3, 64);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(45, 109, 82, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(422, 107, 82, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(422, 409, 76, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(428, 302, 54, 29);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(422, 197, 54, 54);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("CREATE ACCOUNT");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					String sqlt=	"INSERT INTO `logginuser`.`accounts` (`username`, `password`, `fname`, `lname`, `addr`, `email`, `phone`, `gen`,usertype) VALUES (?,?,?,?,?,?,?,?,?);";
					connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/logginuser","root","241099"); 
					pst =connection.prepareStatement(sqlt);
					pst.setString(1,username.getText());
					pst.setString(2,password.getText());
					pst.setString(3,fname.getText());
					pst.setString(4,lname.getText());
					pst.setString(5,aname.getText());
					pst.setString(6,ename.getText());
					pst.setString(7,pname.getText());
					pst.setString(8,gname.getSelectedItem().toString());
					pst.setString(9, usertype.getSelectedItem().toString());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Register SUCCESSFULY");
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
				}
			}
		});
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setBounds(276, 549, 219, 80);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login().setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(0, 581, 105, 48);
		contentPane.add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(173, 283, -3, 13);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		ename = new JTextField();
		ename.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ename.setBounds(173, 208, 191, 39);
		contentPane.add(ename);
		ename.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Username");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(45, 409, 105, 32);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAddress.setBounds(45, 307, 76, 19);
		contentPane.add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(45, 218, 45, 13);
		contentPane.add(lblEmail);
		
		lname = new JTextField();
		lname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lname.setBounds(535, 105, 191, 39);
		contentPane.add(lname);
		lname.setColumns(10);
		
		pname = new JTextField();
		pname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pname.setBounds(535, 300, 191, 39);
		contentPane.add(pname);
		pname.setColumns(10);
		
		username = new JTextField();
		username.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		username.setBounds(173, 402, 191, 39);
		contentPane.add(username);
		username.setColumns(10);
		
		
		
	}
}
