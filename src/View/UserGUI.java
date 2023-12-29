package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Uye;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.Color;


import Helper.DBConnection;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window.Type;
import javax.swing.Icon;

public class UserGUI extends JFrame {
		
	private static Uye uye; // uye bilgilerini çekmek için kullanıyoruz
	private static final long serialVersionUID = 1L;
	private DBConnection conn = new DBConnection();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUI frame = new UserGUI(uye);
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
	

	public UserGUI(Uye uye) {
		setType(Type.UTILITY);
		setBackground(new Color(255, 255, 255));
		setTitle("Kullanıcı Detay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("Cuzdan.png")));
		lblNewLabel.setBounds(677, 246, 46, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(uye.getTcno());
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(416, 216, 120, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tc No:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(329, 221, 74, 14);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_3 = new JLabel("Adı Soyadı: ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(267, 186, 113, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(uye.getAd());
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(416, 191, 71, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Boyunuz: ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(305, 248, 104, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(uye.getBoy());
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(416, 253, 60, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Kilonuz: ");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(315, 280, 104, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(uye.getKilo());
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBounds(417, 284, 70, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Üyelik: ");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setBounds(329, 308, 82, 20);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(uye.getUyelik());
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setBounds(416, 313, 143, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Bakiyeniz:");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setBounds(523, 256, 90, 32);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_13 = new JLabel(String.valueOf(uye.getBakiye()) + " TL");
		lblNewLabel_13.setForeground(new Color(255, 255, 255));
		lblNewLabel_13.setBounds(618, 267, 71, 14);
		contentPane.add(lblNewLabel_13);
		
		JButton btnNewButton = new JButton("Bakiye Yükle");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Odeme odeme = new Odeme(uye);
				odeme.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(523, 290, 144, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_12 = new JLabel(String.valueOf(uye.getBorc()) + " TL");
		lblNewLabel_12.setForeground(new Color(255, 255, 255));
		lblNewLabel_12.setBounds(622, 193, 113, 14);
		contentPane.add(lblNewLabel_12);
		
		JButton btnNewButton_1 = new JButton("Ödeme Yap");
		btnNewButton_1.setBackground(new Color(255, 153, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(uye.getBakiye() >= uye.getBorc() && uye.getBorc() != 0)
				{
				try {
					Connection con = conn.connDB();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM user");
					
							int guncelbakiye = 0;
							int guncelborc = 0;
							int eskibakiye, eskiborc;
							eskibakiye = uye.getBakiye();
							eskiborc = uye.getBorc();
							
							guncelbakiye = eskibakiye - eskiborc;
							guncelborc = 0;
							st.executeUpdate("UPDATE user SET bakiye = " + guncelbakiye + ", borc = " + guncelborc + " WHERE KullaniciId = " + uye.getId());
							uye.setBakiye(guncelbakiye); //yeni
							uye.setBorc(guncelborc); //yeni
							Helper.Help.ShowMsg("odemebasarili");
							lblNewLabel_12.setText(String.valueOf(guncelborc) + " TL"); // yeni
							lblNewLabel_13.setText(String.valueOf(guncelbakiye) + " TL"); // yeni
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}
				else if (uye.getBorc() == 0) // yeni
				{
					Helper.Help.ShowMsg("borcyok");
				}
				else
				{
					Helper.Help.ShowMsg("bakiyeyetersiz");
				}
			}
		});
		btnNewButton_1.setBounds(523, 215, 144, 36);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_14 = new JLabel("REBELLION");
		lblNewLabel_14.setForeground(new Color(255, 255, 255));
		lblNewLabel_14.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_14.setBounds(396, 11, 272, 73);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_14_1 = new JLabel("BEAR");
		lblNewLabel_14_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_14_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_14_1.setBounds(451, 49, 272, 73);
		contentPane.add(lblNewLabel_14_1);
		
		JLabel lblNewLabel_16 = new JLabel("Borcunuz:");
		lblNewLabel_16.setForeground(new Color(255, 255, 255));
		lblNewLabel_16.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_16.setBounds(523, 191, 90, 14);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel(new ImageIcon(getClass().getResource("profils.jpg")));
		lblNewLabel_17.setBounds(329, 110, 104, 59);
		contentPane.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel(new ImageIcon(getClass().getResource("borc.jpg")));
		lblNewLabel_18.setBounds(677, 156, 46, 48);
		contentPane.add(lblNewLabel_18);
		
		JButton btnGeri = new JButton("Çıkış Yap");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				javax.swing.Timer timer = new javax.swing.Timer(300, new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	Login log = new Login();
						log.setVisible(true);
						dispose();
		            }
		        });
		        timer.setRepeats(false); 
		        timer.start();
			}
		});
		btnGeri.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnGeri.setBackground(new Color(255, 0, 0));
		btnGeri.setBounds(329, 467, 131, 36);
		contentPane.add(btnGeri);
		
		JLabel lblNewLabel_15 = new JLabel(new ImageIcon(getClass().getResource("odemearka1.jpg")));
		lblNewLabel_15.setBounds(0, 0, 1000, 600);
		contentPane.add(lblNewLabel_15);
	/*	setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, lblNewLabel_6, lblNewLabel_7, lblNewLabel_8, lblNewLabel_9, lblNewLabel_10, panel, lblNewLabel, lblNewLabel_11, lblNewLabel_13, btnNewButton, lblNewLabel_12}));*/
	}
}