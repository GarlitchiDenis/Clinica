package ia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class windows2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String String = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windows2 frame = new windows2(String);
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
	@SuppressWarnings({ })
	public windows2(String abc) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 753, 67);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSelecteaza = new JLabel("Selecteaza");
		lblSelecteaza.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSelecteaza.setBounds(10, 10, 152, 28);
		panel.add(lblSelecteaza);
		
		JLabel lblSelecteazaClinica = new JLabel("Selecteaza clinica:");
		lblSelecteazaClinica.setBackground(Color.WHITE);
		lblSelecteazaClinica.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSelecteazaClinica.setBounds(289, 77, 225, 60);
		contentPane.add(lblSelecteazaClinica);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login().setVisible(true);
			}
		});
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setBackground(Color.RED);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(10, 534, 120, 49);
		contentPane.add(btnBack);
		
		JLabel lblDsad = new JLabel("<html>Specializare: Stomatologie (Doar adulti)<br/> Doctor principal: Matei Iancu</html>");
		lblDsad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDsad.setBounds(272, 158, 378, 49);
		contentPane.add(lblDsad);
		
		JLabel lblNewLabel = new JLabel("<html>Specializare: Psihiatrie <br/> Doctor principal Margulescu Beregoi<html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(276, 240, 300, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html> Specializare: Ortopedie <br/> Doctor principal: Tanase Ibrahimovici <html>");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(276, 336, 300, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("<html>Specializare: Alergologie <br/> Doctor principal: Raie Caprescu <html>");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(279, 426, 247, 49);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Clinnica Vasilescu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Clinica2(abc).setVisible(true);
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(10, 174, 205, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clinica SpaceDrop");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Clinica3(abc).setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(10, 256, 205, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clinica Spartan\r\n\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Clinica41(abc).setVisible(true);
				
			}
		});
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_2.setBounds(10, 342, 205, 33);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Clinica Maria");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Clinica51(abc).setVisible(true);
			}
		});
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_4.setBounds(10, 426, 205, 33);
		contentPane.add(btnNewButton_4);
	}
}
