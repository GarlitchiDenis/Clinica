package ia;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class admin extends javax.swing.JFrame {
	Connection connection = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private static Connection con = null;
	private static String URL = "jdbc:mysql://localhost:3306/logginuser";
	private static String user = "root";
	private static String pass = "241099";

	
	
	


	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private static final long serialVersionUID = 1L;
	private JTextField pas;
	private JTextField fname;
	private JTextField lname;
	private JTextField adr;
	private JTextField em;
	private JTextField usr;
	private JTextField ph;
	private JTextField gn;
	private JTextField ut;
	private JTextField ct;
	private JTable table_2;

	
	public admin() {
		getComponents();
		showTableData();

		Statement stmt;

		String query;

		ResultSet rs;

		Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3", "Row1-Column4","Row1-Column5","Row1-Column6","Row1-Column7","Row1-Column8","Row1-Column9","Row1-Column10" } };

		Object columnNames[] = { "username", "password", "fname", "lname","address","email","phone","gender","usertype","clinictype"};

		DefaultTableModel mTableModel = new DefaultTableModel(rowData, columnNames);
		JTable table = new JTable(mTableModel);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, user, pass);
		
		query = "SELECT * FROM logginuser.accounts";

		stmt = con.createStatement();

		rs = stmt.executeQuery(query);

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JScrollPane scrollPane = new JScrollPane(table);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.setSize(300, 150);
		frame.setVisible(true);

		mTableModel.removeRow(0);

		Object[] rows;

		while (rs.next()) {
			rows = new Object[] { rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10) };
			mTableModel.addRow(rows);
		}
		}catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}

	
		
		getContentPane().setLayout(null);

		pas = new JTextField();
		pas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pas.setBounds(124, 66, 190, 29);
		getContentPane().add(pas);
		pas.setColumns(10);

		fname = new JTextField();
		fname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		fname.setColumns(10);
		fname.setBounds(124, 105, 190, 33);
		getContentPane().add(fname);

		lname = new JTextField();
		lname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lname.setColumns(10);
		lname.setBounds(124, 148, 190, 28);
		getContentPane().add(lname);

		adr = new JTextField();
		adr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		adr.setColumns(10);
		adr.setBounds(124, 186, 190, 25);
		getContentPane().add(adr);

		em = new JTextField();
		em.setFont(new Font("Tahoma", Font.PLAIN, 17));
		em.setColumns(10);
		em.setBounds(124, 228, 190, 29);
		getContentPane().add(em);

		usr = new JTextField();
		usr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		usr.setColumns(10);
		usr.setBounds(124, 27, 190, 29);
		getContentPane().add(usr);

		ph = new JTextField();
		ph.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ph.setColumns(10);
		ph.setBounds(124, 276, 190, 29);
		getContentPane().add(ph);

		gn = new JTextField();
		gn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		gn.setColumns(10);
		gn.setBounds(124, 322, 190, 29);
		getContentPane().add(gn);

		ut = new JTextField();
		ut.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ut.setColumns(10);
		ut.setBounds(124, 370, 190, 28);
		getContentPane().add(ut);

		ct = new JTextField();
		ct.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ct.setColumns(10);
		ct.setBounds(124, 427, 190, 29);
		getContentPane().add(ct);

		JLabel lblCeva = new JLabel("Username\r\n");
		lblCeva.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCeva.setBounds(10, 37, 104, 13);
		getContentPane().add(lblCeva);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(10, 79, 104, 13);
		getContentPane().add(lblPassword);

		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFirstName.setBounds(10, 119, 104, 13);
		getContentPane().add(lblFirstName);

		JLabel lblSecondName = new JLabel("Second name");
		lblSecondName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSecondName.setBounds(10, 157, 104, 13);
		getContentPane().add(lblSecondName);

		JLabel lblAddress = new JLabel("Address\r\n");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAddress.setBounds(10, 192, 104, 13);
		getContentPane().add(lblAddress);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(10, 238, 104, 13);
		getContentPane().add(lblEmail);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPhone.setBounds(10, 286, 104, 13);
		getContentPane().add(lblPhone);

		JLabel lblGen = new JLabel("Gender");
		lblGen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGen.setBounds(10, 332, 104, 13);
		getContentPane().add(lblGen);

		JLabel lblUsertype = new JLabel("Usertype");
		lblUsertype.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsertype.setBounds(10, 379, 104, 19);
		getContentPane().add(lblUsertype);

		JLabel lblClinictype = new JLabel("Clinictype");
		lblClinictype.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblClinictype.setBounds(10, 432, 104, 19);
		getContentPane().add(lblClinictype);

		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "INSERT INTO logginuser.accounts (`username`, `password`, `fname`, `lname`, `addr`, `email`, `phone`, `gen`, `usertype`,`Clinictype`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logginuser", "root",
							"241099");
					pst = connection.prepareStatement(sql);
					pst.setString(1, usr.getText());
					pst.setString(2, pas.getText());
					pst.setString(3, fname.getText());
					pst.setString(4, lname.getText());
					pst.setString(5, adr.getText());
					pst.setString(6, em.getText());
					pst.setString(7, ph.getText());
					pst.setString(8, gn.getText());
					pst.setString(9, ut.getText());
					pst.setString(10, ct.getText());

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Insert complete");
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, ee);

				}

			}
		});
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(75, 496, 115, 33);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("DELETE ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "DELETE FROM logginuser.accounts WHERE username =? ";
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logginuser", "root",
							"241099");
					pst = connection.prepareStatement(sql);
					pst.setString(1, usr.getText());

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Delete complete");
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, ee);

				}

			}
		});
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBounds(249, 496, 115, 33);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "UPDATE logginuser.accounts SET password=?, fname=?, lname=?, addr=?, email=?, phone=?, gen=?, usertype=?,Clinictype=? WHERE username=? ;";
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logginuser", "root",
							"241099");
					pst = connection.prepareStatement(sql);
					pst.setString(10, usr.getText());
					pst.setString(1, pas.getText());
					pst.setString(2, fname.getText());
					pst.setString(3, lname.getText());
					pst.setString(4, adr.getText());
					pst.setString(5, em.getText());
					pst.setString(6, ph.getText());
					pst.setString(7, gn.getText());
					pst.setString(8, ut.getText());
					pst.setString(9, ct.getText());

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Update complete");
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, ee);

				}
			}
		});
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBounds(384, 496, 115, 33);
		getContentPane().add(btnNewButton_2);
		
		table_2 = new JTable();
		table_2.setBounds(54, 455, 1, 1);
		getContentPane().add(table_2);
		
		
	}
	public void showTableData() {
		
	try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logginuser", "root","241099");
		String sqt="SEELECT * FROM logginuser.accounts";
		pst= connection.prepareStatement(sqt);
		rs=pst.executeQuery();
		//tablee.setModel(DbUtils.resultSetToTableModel(rs));
		
		
	} catch (SQLException e) {
		System.out.println(e);
		e.printStackTrace();
	}
	}
}
