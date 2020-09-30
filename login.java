package ia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel desktop;
	private JTextField username;
	private JPasswordField password;
	private JTextField txtCreateAccount;
	private JTextField txtForgotPassword;


	static Connection connection = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	@SuppressWarnings("deprecation")
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
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
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logginuser", "root", "241099");
		if (connection != null) {
			System.out.println("Conectat");
		}
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 526);
		desktop = new JPanel();
		desktop.setBackground(new Color(100, 149, 237));
		desktop.setForeground(SystemColor.window);
		desktop.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(desktop);
		desktop.setLayout(null);

		@SuppressWarnings("rawtypes")
		JComboBox usertype = new JComboBox();
		usertype.setModel(new DefaultComboBoxModel<Object>(new String[] { "user", "admin"}));
		usertype.setFont(new Font("Tahoma", Font.PLAIN, 17));
		usertype.setBounds(284, 291, 193, 27);
		desktop.add(usertype);

		JLabel lblSelectUserType = new JLabel("Select user type");
		lblSelectUserType.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSelectUserType.setBounds(38, 287, 128, 29);
		desktop.add(lblSelectUserType);

		username = new JTextField();
		username.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		username.setBounds(152, 109, 465, 55);
		desktop.add(username);
		username.setColumns(10);
		JLabel validation = new JLabel("");
		validation.setForeground(Color.WHITE);
		validation.setBounds(152, 260, 199, 29);
		desktop.add(validation);

		password = new JPasswordField();

		password.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		password.setBounds(152, 195, 465, 55);
		desktop.add(password);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "SELECT * FROM logginuser.accounts WHERE username =? and password =? and usertype =?";
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logginuser", "root","241099");
					pst = connection.prepareStatement(sql);
					pst.setString(1, username.getText());
					pst.setString(2, password.getText());
					pst.setString(3, usertype.getSelectedItem().toString());
					rs = pst.executeQuery();
					if (rs.next()) {
						if (usertype.getSelectedIndex() == 0) {
							dispose();
							String msg = username.getText();
							new windows2(msg).setVisible(true);
						} else if (usertype.getSelectedIndex() == 1) {
							dispose();
							new admin().setVisible(true);
						} 

					} else {
						validation.setText("Invalid Username or Password");
					}
				} catch (Exception p) {
					JOptionPane.showMessageDialog(null, p);
				}

			}
		});

		btnNewButton.addMouseListener(new MouseAdapter() {

		});

		btnNewButton.setBackground(new Color(0, 0, 139));
		btnNewButton.setForeground(SystemColor.window);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(284, 343, 193, 55);
		desktop.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("CLOSE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBounds(24, 424, 106, 45);
		desktop.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("  User");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(38, 107, 88, 55);
		desktop.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("  Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(38, 193, 88, 55);
		desktop.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(234, 10, 288, 89);
		desktop.add(lblNewLabel_2);

		JButton btnNewButton_2 = new JButton("x");
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setForeground(SystemColor.text);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(698, 0, 42, 34);
		desktop.add(btnNewButton_2);

		txtCreateAccount = new JTextField();
		txtCreateAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new newACC().setVisible(true);

			}
		});
		txtCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new newACC().setVisible(true);

			}
		});
		txtCreateAccount.setEditable(false);
		txtCreateAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtCreateAccount.setCaretColor(new Color(0, 0, 0));
		txtCreateAccount.setBackground(new Color(100, 149, 237));
		txtCreateAccount.setForeground(Color.BLUE);
		txtCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		txtCreateAccount.setText("Create account");
		txtCreateAccount.setBounds(284, 424, 193, 19);
		desktop.add(txtCreateAccount);
		txtCreateAccount.setColumns(10);

		txtForgotPassword = new JTextField();
		txtForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new LostPSW().setVisible(true);
			}
		});
		txtForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}

		});
		txtForgotPassword.setEditable(false);
		txtForgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtForgotPassword.setBackground(new Color(100, 149, 237));
		txtForgotPassword.setForeground(Color.BLUE);
		txtForgotPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtForgotPassword.setText("Forgot password");
		txtForgotPassword.setBounds(284, 453, 193, 19);
		desktop.add(txtForgotPassword);
		txtForgotPassword.setColumns(10);
		
		JButton btnChangeForDoctor = new JButton("CHANGE FOR DOCTOR");
		btnChangeForDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new selmed().setVisible(true);
			}
		});
		btnChangeForDoctor.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChangeForDoctor.setForeground(Color.WHITE);
		btnChangeForDoctor.setBackground(Color.RED);
		btnChangeForDoctor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnChangeForDoctor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnChangeForDoctor.setBounds(10, 10, 208, 70);
		desktop.add(btnChangeForDoctor);

	}
}
