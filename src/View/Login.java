package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Helper.DBConnection;
import Helper.Help;
import Model.Admin;
import Model.Uye;

import java.awt.SystemColor;
import java.awt.Window.Type;
public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel w_log;
	private JTextField fld_uyeNo;
	private DBConnection conn = new DBConnection();
	private JTextField f_adminTc;
	private JPasswordField fld_uyePass;
	private JPasswordField f_adminPas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setType(Type.UTILITY);
		setBackground(new Color(255, 255, 255));
		setTitle("Bear Gym");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		w_log = new JPanel();
		w_log.setBackground(new Color(255, 255, 255));
		w_log.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(w_log);
		w_log.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(655, 10, 321, 543);
		w_log.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.controlText);
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		tabbedPane.addTab("Üye girişi",null, panel, null);
		panel.setLayout(null);
		
		JLabel lblyeNo = new JLabel("Kullanıcı Adı:");
		lblyeNo.setBackground(new Color(0, 0, 0));
		lblyeNo.setForeground(new Color(0, 0, 0));
		lblyeNo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblyeNo.setBounds(27, 52, 94, 31);
		panel.add(lblyeNo);
		
		JLabel lblifre = new JLabel("Şifre:");
		lblifre.setForeground(new Color(0, 0, 0));
		lblifre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblifre.setBounds(27, 119, 51, 31);
		panel.add(lblifre);
		
		fld_uyeNo = new JTextField();
		fld_uyeNo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		fld_uyeNo.setBackground(new Color(255, 255, 255));
		fld_uyeNo.setBounds(126, 51, 180, 31);
		panel.add(fld_uyeNo);
		fld_uyeNo.setColumns(10);
		
		JButton btnNewButton = new JButton("Giriş Yap");
		btnNewButton.setBackground(new Color(51, 153, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = new String(fld_uyePass.getPassword());
				if(fld_uyeNo.getText().length()==0 || fld_uyePass.getPassword().length==0) {
				    Helper.Help.ShowMsg("fill");
			  }
				else
				{
					try {
						Connection con = conn.connDB();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM user");
						
						boolean userFound = false;
						while (rs.next())
						{
							if(fld_uyeNo.getText().equals(rs.getString("kullaniciadi")) && pass.equals(rs.getString("kullanicisifre")))
							{
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
								userFound = true;
								javax.swing.Timer timer = new javax.swing.Timer(300, new ActionListener() {
						            @Override
						            public void actionPerformed(ActionEvent e) {
						            	UserGUI uGUI = new UserGUI(user);
										uGUI.setVisible(true);
										dispose();
						            }
						        });
						        timer.setRepeats(false); 
						        timer.start();
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
		
				btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 16));
				btnNewButton.setBounds(126, 407, 180, 35);
				panel.add(btnNewButton);
				
				JButton btnKayitOl = new JButton("Kayıt Ol");
				btnKayitOl.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 
						javax.swing.Timer timer = new javax.swing.Timer(300, new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent e) {
				                KayitGUI kayit = new KayitGUI();
				                kayit.setVisible(true);
				                dispose();
				            }
				        });
				        timer.setRepeats(false); 
				        timer.start();
						
					
					}}	
				);
				btnKayitOl.setForeground(new Color(0, 0, 0));
				btnKayitOl.setBackground(new Color(0, 255, 51));
				btnKayitOl.setFont(new Font("Arial Black", Font.PLAIN, 16));
				btnKayitOl.setBounds(126, 471, 180, 35);
				panel.add(btnKayitOl);
				
				fld_uyePass = new JPasswordField();
				fld_uyePass.setFont(new Font("Arial Black", Font.PLAIN, 14));
				fld_uyePass.setBounds(126, 119, 180, 31);
				panel.add(fld_uyePass);
				
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBackground(SystemColor.inactiveCaptionBorder);
				tabbedPane.addTab("Admin Paneli", null, panel_1, null);
				
				JLabel w_persTc = new JLabel("Login:");
				w_persTc.setForeground(new Color(0, 0, 0));
				w_persTc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
				w_persTc.setBounds(27, 52, 94, 31);
				panel_1.add(w_persTc);
				
				JLabel lblifre_1 = new JLabel("Şifre:");
				lblifre_1.setForeground(new Color(0, 0, 0));
				lblifre_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
				lblifre_1.setBounds(27, 119, 51, 31);
				panel_1.add(lblifre_1);
				
				f_adminTc = new JTextField();
				f_adminTc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
				f_adminTc.setColumns(10);
				f_adminTc.setBackground(Color.WHITE);
				f_adminTc.setBounds(126, 52, 180, 31);
				panel_1.add(f_adminTc);
				
				JButton btnNewButton_1 = new JButton("Giriş Yap");
				btnNewButton_1.setBackground(new Color(51, 153, 255));
				btnNewButton_1.setForeground(new Color(0, 0, 0));
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String pas1 = new String(f_adminPas.getPassword());
						if(f_adminTc.getText().length()==0 || f_adminPas.getPassword().length==0) {
						    Help.ShowMsg("fill");
					  }else {
						     
						try {
						Connection con = conn.connDB();
						Statement s = con.createStatement();
						ResultSet r = s.executeQuery("SELECT * FROM gym");
						
						boolean userFound1 = false;
						
						  while(r.next()) {
							  if(f_adminTc.getText().equals(r.getString("isim")) && pas1.equals(r.getString("password"))){  
								    Admin admin = new Admin();
									admin.setId(r.getInt("id"));
									admin.setAd(r.getString("isim"));
									admin.setSifre(r.getString("password"));
									admin.setTcno(r.getString("tcno"));
									javax.swing.Timer timer = new javax.swing.Timer(200, new ActionListener() {
							            @Override
							            public void actionPerformed(ActionEvent e) {
							            	AdminGUI adminGUI;
											try {
												adminGUI = new AdminGUI(admin);
												 adminGUI.setVisible(true);
												    dispose();
											} catch (SQLException e1) {
												e1.printStackTrace();
											}
							            }
							        });
							        timer.setRepeats(false); 
							        timer.start();
								    userFound1 = true;
									break;
							  }
						  }
						  if (!userFound1) 
							{
				                Helper.Help.ShowMsg("hatali");
				                }
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						  
						
					  }
					}
				});
				btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
				btnNewButton_1.setBounds(126, 407, 180, 35);
				panel_1.add(btnNewButton_1);
				
				f_adminPas = new JPasswordField();
				f_adminPas.setFont(new Font("Arial Black", Font.PLAIN, 15));
				f_adminPas.setBounds(126, 119, 180, 31);
				panel_1.add(f_adminPas);
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon(getClass().getResource("ark.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1128, 563);
		w_log.add(lblNewLabel_2);
		
		
	}
}
