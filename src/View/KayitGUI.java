package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.Help;
import Model.Uye;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.DropMode;
import java.awt.Window.Type;
import java.awt.SystemColor;

public class KayitGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	static Uye uye = new Uye();
	private JPanel contentPane;
	private JTextField fld_kullaniciAd;
	private JTextField fld_kullaniciBoy;
	private JTextField fld_kullaniciTc;
	private JTextField fld_kullaniciAdSoayd;
	private JPasswordField fld_kullaniciSifre;
	private JTextField fld_kullaniciKilo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KayitGUI frame = new KayitGUI();
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
	public KayitGUI() {
		setType(Type.UTILITY);
		setTitle("Kayıt Ekranı");
		setForeground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(655, 10, 321, 543);
		tabbedPane.setBackground(SystemColor.menu);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		tabbedPane.addTab("Kayıt Olun", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullanıcı Adı");
		lblNewLabel.setBounds(10, 10, 99, 23);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		
		fld_kullaniciAd = new JTextField();
		fld_kullaniciAd.setBounds(10, 30, 169, 29);
		panel.add(fld_kullaniciAd);
		fld_kullaniciAd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		fld_kullaniciAd.setColumns(10);
		
		JLabel lblTcNumarasi = new JLabel("Kullanıcı Şifre");
		lblTcNumarasi.setBounds(10, 69, 99, 23);
		panel.add(lblTcNumarasi);
		lblTcNumarasi.setForeground(new Color(0, 0, 0));
		lblTcNumarasi.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		
		fld_kullaniciSifre = new JPasswordField();
		fld_kullaniciSifre.setBounds(10, 90, 169, 29);
		panel.add(fld_kullaniciSifre);
		
		JLabel lblBoy = new JLabel("T.C");
		lblBoy.setBounds(10, 129, 71, 23);
		panel.add(lblBoy);
		lblBoy.setForeground(new Color(0, 0, 0));
		lblBoy.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		
		fld_kullaniciTc = new JTextField();
		fld_kullaniciTc.setBounds(10, 150, 169, 29);
		panel.add(fld_kullaniciTc);
		fld_kullaniciTc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		fld_kullaniciTc.setColumns(10);
		
		JLabel lblKilo = new JLabel("Ad Soyad");
		lblKilo.setBounds(10, 189, 71, 23);
		panel.add(lblKilo);
		lblKilo.setForeground(new Color(0, 0, 0));
		lblKilo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		
		fld_kullaniciAdSoayd = new JTextField();
		fld_kullaniciAdSoayd.setBounds(10, 212, 169, 29);
		panel.add(fld_kullaniciAdSoayd);
		fld_kullaniciAdSoayd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		fld_kullaniciAdSoayd.setColumns(10);
		
		JLabel lblifre = new JLabel("Boyunuz");
		lblifre.setBounds(10, 251, 71, 23);
		panel.add(lblifre);
		lblifre.setForeground(new Color(0, 0, 0));
		lblifre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		
		fld_kullaniciBoy = new JTextField();
		fld_kullaniciBoy.setBounds(10, 274, 169, 29);
		panel.add(fld_kullaniciBoy);
		fld_kullaniciBoy.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		fld_kullaniciBoy.setColumns(10);
		
		JLabel lblifreniziOnaylayin = new JLabel("Kilonuz");
		lblifreniziOnaylayin.setBounds(10, 313, 158, 23);
		panel.add(lblifreniziOnaylayin);
		lblifreniziOnaylayin.setForeground(new Color(0, 0, 0));
		lblifreniziOnaylayin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		
		fld_kullaniciKilo = new JTextField();
		fld_kullaniciKilo.setBounds(10, 337, 169, 29);
		panel.add(fld_kullaniciKilo);
		fld_kullaniciKilo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		fld_kullaniciKilo.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 398, 169, 34);
		panel.add(comboBox);
		comboBox.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aylık (600 TL)", "3 Aylık (1500 TL)", "1 Yıllık (4500 TL)"}));
		comboBox.setSelectedIndex(0);
		
		JButton btnNewButton = new JButton("Kayıt Ol");
		btnNewButton.setBounds(185, 433, 121, 34);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_kullaniciAd.getText().length()==0 || fld_kullaniciSifre.getPassword().length==0 || fld_kullaniciTc.getText().length()==0 || fld_kullaniciAdSoayd.getText().length()==0 
						|| fld_kullaniciBoy.getText().length()==0 || fld_kullaniciKilo.getText().length()==0) {
				    Help.ShowMsg("fill");
			  }else {
				    Object selectedItem = comboBox.getSelectedItem();
		            String uyelikDegeri = (selectedItem != null) ? selectedItem.toString() : "";
		            int borcMiktari = 0;
		            int kalanGun = 0;
		            if ("Aylık (600 TL)".equals(uyelikDegeri)) {
		                borcMiktari = 600;
		            }
		            else if ("3 Aylık (1500 TL)".equals(uyelikDegeri)) {
		                borcMiktari = 1500;
		            }
		            else
		            {
		            	borcMiktari = 4500;
		            }
		            if ("Aylık (600 TL)".equals(uyelikDegeri)) {
		            	kalanGun = 30;
		            }
		            else if ("3 Aylık (1500 TL)".equals(uyelikDegeri)) {
		            	kalanGun = 90;
		            }
		            else
		            {
		            	kalanGun = 360;
		            }
				  boolean kontrol = uye.addKullanici(fld_kullaniciAd.getText(), fld_kullaniciSifre.getText(), fld_kullaniciTc.getText(), 
						  fld_kullaniciAdSoayd.getText(), fld_kullaniciBoy.getText(), fld_kullaniciKilo.getText(), uyelikDegeri, borcMiktari, kalanGun);
				  if (kontrol)
				  {
					  Helper.Help.ShowMsg("Kayıt Başarılı");
					  fld_kullaniciAd.setText(null);
					  fld_kullaniciSifre.setText(null);
					  fld_kullaniciTc.setText(null);
					  fld_kullaniciAdSoayd.setText(null);
					  fld_kullaniciBoy.setText(null);
					  fld_kullaniciKilo.setText(null);
				  }
				  
			  }
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setForeground(new Color(0, 0, 0));
		
		JLabel lblyelikSeiniz = new JLabel("Üyelikler");
		lblyelikSeiniz.setBounds(10, 376, 158, 23);
		panel.add(lblyelikSeiniz);
		lblyelikSeiniz.setForeground(new Color(0, 0, 0));
		lblyelikSeiniz.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		
		
		
		JButton btnNewButton_1 = new JButton("Geri Dön");
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(185, 477, 121, 34);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(getClass().getResource("br.jpg")));
		lblNewLabel_1.setBounds(0, 0, 655, 563);
		contentPane.add(lblNewLabel_1);
		


	}
}
