package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.DBConnection;
import Model.Kartlar;
import Model.User;
import Model.Uye;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window.Type;

public class Odeme extends JFrame {

	private static Uye uye;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DBConnection conn = new DBConnection();
	private JTextField fld_kartNo;
	private JTextField fld_Tutar;
	private JPasswordField fld_kartSifre;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Odeme frame = new Odeme(uye);
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
	public Odeme(Uye uye) {
		setType(Type.UTILITY);
		setBackground(new Color(255, 255, 255));
		setTitle("Ödeme Ekranı");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kart Numarası :");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(200, 147, 174, 20);
		contentPane.add(lblNewLabel);
		
		fld_kartNo = new JTextField();
		fld_kartNo.setBounds(391, 145, 126, 31);
		contentPane.add(fld_kartNo);
		fld_kartNo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Şifre :");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(300, 191, 78, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Ödeme Yap");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass1 = new String(fld_kartSifre.getPassword());
				if(fld_kartNo.getText().length()==0 || fld_kartSifre.getPassword().length==0 || fld_Tutar.getText().length()==0)  {
				    Helper.Help.ShowMsg("fill");
			  }
				else
				{
					try {
						Connection con = conn.connDB();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM kartlar");
						
						
						boolean userFound = false;
						while (rs.next())
						{
							if(fld_kartNo.getText().equals(rs.getString("kartNo")) && pass1.equals(rs.getString("kartSifre")))
							{
								Kartlar kartlar = new Kartlar();
								kartlar.setId(rs.getInt("idKartlar"));
								kartlar.setKartNo(rs.getString("kartNo"));
								kartlar.setSifre(rs.getString("kartSifre"));
								userFound = true;
								Helper.Help.ShowMsg("odemebasarili");
                                int tutar = Integer.parseInt(fld_Tutar.getText());
                                int currentBakiye = uye.getBakiye();
                                int updatedBakiye = currentBakiye + tutar;
                                st.executeUpdate("UPDATE user SET bakiye = " + updatedBakiye+ " WHERE KullaniciId = " + uye.getId());
                                
								break;
							}
						}
						if (!userFound) 
						{
			                Helper.Help.ShowMsg("hatali");
			            }
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(254, 266, 143, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Geri");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(255, 51, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = conn.connDB();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM user WHERE KullaniciId=" + uye.getId());
					
					while (rs.next()) {
					    Uye user = new Uye();
					    user.setId(rs.getInt("KullaniciId"));
					    user.setKullaniciAdi(rs.getString("kullaniciadi"));
					    user.setSifre(rs.getString("kullanicisifre"));
					    user.setTcno(rs.getString("tc"));
					    user.setAd(rs.getString("adsoyad"));
					    user.setBoy(rs.getString("boy"));
					    user.setKilo(rs.getString("kilo"));
					    user.setUyelik(rs.getString("uyelik"));
					    user.setBakiye(rs.getInt("bakiye"));
					    user.setBorc(rs.getInt("borc"));
					    user.setKalanGun(rs.getInt("kalanGun"));

					    UserGUI uGUI = new UserGUI(user);
					    uGUI.setVisible(true);
					    dispose();
						}

					
					}catch (SQLException e1) {
					e1.printStackTrace();
						}
					}
		});
		btnNewButton_1.setBounds(418, 266, 99, 36);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Yatırılacak Tutar :");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(175, 227, 203, 20);
		contentPane.add(lblNewLabel_2);
		
		fld_Tutar = new JTextField();
		fld_Tutar.setBounds(391, 225, 126, 31);
		contentPane.add(fld_Tutar);
		fld_Tutar.setColumns(10);
		
		fld_kartSifre = new JPasswordField();
		fld_kartSifre.setBounds(391, 186, 126, 31);
		contentPane.add(fld_kartSifre);
		
		JLabel lblNewLabel_3 = new JLabel(new ImageIcon(getClass().getResource("paypal.jpg")));
		lblNewLabel_3.setBounds(271, 313, 56, 36);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(new ImageIcon(getClass().getResource("visa.jpg")));
		lblNewLabel_4.setBounds(366, 318, 56, 31);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(new ImageIcon(getClass().getResource("mastercar.jpg")));
		lblNewLabel_5.setBounds(461, 318, 56, 31);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(new ImageIcon(getClass().getResource("card2.jpg")));
		lblNewLabel_6.setForeground(new Color(0, 0, 255));
		lblNewLabel_6.setBounds(539, 139, 270, 163);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(new ImageIcon(getClass().getResource("arkaplan.jpg")));
		lblNewLabel_7.setBounds(0, 0, 984, 561);
		contentPane.add(lblNewLabel_7);
	}
}