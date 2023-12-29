package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Helper.Help;
import Model.Admin;
import Model.Uye;

import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;


public class AdminGUI extends JFrame {

	static Admin admin = new Admin();
	static Uye uye = new Uye();
	private static final long serialVersionUID = 1L;
	private JPanel w_pane;
	private JTextField f_persNm;
	private JTextField f_persTc;
	private JTextField f_persid;
	private DefaultTableModel personelModel=null;
	private DefaultTableModel personelModel1=null;
    private Object[] personelData=null;
    private Object[] personelData1=null;
    private JTable table;
    private JTable table_1;
    private JTextField f_kullaniciId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI frame = new AdminGUI(admin);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AdminGUI(Admin admin) throws SQLException {
		setType(Type.UTILITY);
		personelModel = new DefaultTableModel();
		Object[]personelColon = new Object[3];
		personelColon[0]="ID";
		personelColon[1]="Ad Soyad";
		personelColon[2]="Çalışma Saatleri";
		personelModel.setColumnIdentifiers(personelColon);
		personelData=new Object[3];
		for(int i=0;i < admin.getPersonellerList().size(); i++) {
			personelData[0]=admin.getPersonellerList().get(i).getId();
			personelData[1]=admin.getPersonellerList().get(i).getAd();
			personelData[2]=admin.getPersonellerList().get(i).getwHour();
			personelModel.addRow(personelData);
		}
		personelModel1 = new DefaultTableModel();
		Object[]personelColon1 = new Object[3];
		personelColon1[0]="ID";
		personelColon1[1]="Kullanıcı Adı";
		personelColon1[2]="Kalan Gün";
		personelModel1.setColumnIdentifiers(personelColon1);
		personelData1=new Object[3];
		for(int i=0;i < uye.getUyelerList().size(); i++) {
			personelData1[0]=uye.getUyelerList().get(i).getId();
			personelData1[1]=uye.getUyelerList().get(i).getAd();
			personelData1[2]=uye.getUyelerList().get(i).getSifre();
			personelModel1.addRow(personelData1);
		}
		
		setTitle("Admin Paneli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		w_pane = new JPanel();
		w_pane.setToolTipText("");
		w_pane.setBackground(SystemColor.window);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin:  " + admin.getAd());
		lblNewLabel.setBounds(20, 215, 125, 27);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		w_pane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 240, 966, 326);
		tabbedPane.setBackground(SystemColor.control);
		w_pane.add(tabbedPane);
		
		JPanel w_personelYonet = new JPanel();
		w_personelYonet.setBackground(SystemColor.inactiveCaptionBorder);
		w_personelYonet.setToolTipText("");
		tabbedPane.addTab("Personel Yönetimi", null, w_personelYonet, null);
		w_personelYonet.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ad Soyad");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(737, 1, 80, 28);
		w_personelYonet.add(lblNewLabel_1);
		
		f_persNm = new JTextField();
		f_persNm.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		f_persNm.setBounds(737, 35, 214, 29);
		w_personelYonet.add(f_persNm);
		f_persNm.setColumns(10);
		
		f_persTc = new JTextField();
		f_persTc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		f_persTc.setColumns(10);
		f_persTc.setBounds(737, 112, 214, 29);
		w_personelYonet.add(f_persTc);
		
		JLabel lblNewLabel_1_1 = new JLabel(" Çalışma Saatleri");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(737, 74, 136, 28);
		w_personelYonet.add(lblNewLabel_1_1);
		
		JButton btnNewButton_1 = new JButton("Ekle");
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(f_persNm.getText().length()==0 || f_persTc.getText().length()==0) {
					Help.ShowMsg("fill");
				}else {
					try {
						boolean control = admin.addPersonel(f_persNm.getText(),f_persTc.getText());
						if(control) {
							Help.ShowMsg("ekle");
							f_persNm.setText(null);
							f_persTc.setText(null);
							updatePersonelModel();
						}
					} catch (SQLException e1) {
			
						e1.printStackTrace();
					}
				}
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnNewButton_1.setBounds(737, 166, 214, 30);
		w_personelYonet.add(btnNewButton_1);
		
		f_persid = new JTextField();
		f_persid.setHorizontalAlignment(SwingConstants.CENTER);
		f_persid.setForeground(new Color(153, 0, 51));
		f_persid.setFont(new Font("Arial Black", Font.PLAIN, 15));
		f_persid.setColumns(10);
		f_persid.setBounds(737, 224, 214, 29);
		w_personelYonet.add(f_persid);
		
		JLabel lblNewLabel_1_3 = new JLabel("Kullanıcı ID");
		lblNewLabel_1_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(737, 195, 80, 28);
		w_personelYonet.add(lblNewLabel_1_3);
		
		JButton btnNewButton_1_1 = new JButton("Sil");
		btnNewButton_1_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(f_persid.getText().length()==0) {
					Help.ShowMsg("       Seçim Yapilmadi!");
				}else {
					if(Help.confirm("evet")) {
						int selectID = Integer.parseInt(f_persid.getText());
						try {
							boolean control2 = admin.silPersonel(selectID);
							if(control2) {
								Help.ShowMsg("sil");
								updatePersonelModel();
								f_persid.setText(null);	
							}				
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}

				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(737, 261, 214, 30);
		w_personelYonet.add(btnNewButton_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new CompoundBorder());
		scrollPane.setBounds(0, 1, 727, 306);
		w_personelYonet.add(scrollPane);
		
		table = new JTable(personelModel);
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Arial Black", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		tabbedPane.addTab("Kayıtlı Üyeler", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 722, 299);
		panel.add(scrollPane_1);
		
		table_1 = new JTable(personelModel1);
		table_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Kullanıcı ID");
		lblNewLabel_1_3_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_1_3_1.setBounds(737, 88, 103, 28);
		panel.add(lblNewLabel_1_3_1);
		
		f_kullaniciId = new JTextField();
		f_kullaniciId.setHorizontalAlignment(SwingConstants.CENTER);
		f_kullaniciId.setForeground(new Color(153, 0, 51));
		f_kullaniciId.setFont(new Font("Arial Black", Font.PLAIN, 15));
		f_kullaniciId.setColumns(10);
		f_kullaniciId.setBounds(737, 126, 214, 29);
		panel.add(f_kullaniciId);
		
		JButton btnNewButton_1_1_1 = new JButton("Sil");
		btnNewButton_1_1_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(f_kullaniciId.getText().length()==0) {
					Help.ShowMsg("       Seçim Yapilmadi!");
				}else {
					if(Help.confirm("evet")) {
					int selectID = Integer.parseInt(f_kullaniciId.getText());
					try {
						boolean control2 = uye.silUye(selectID);
						if(control2) {
							Help.ShowMsg("sil");
							updateUyeModel1();
							f_kullaniciId.setText(null);	
						}
							
							
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					}
				}
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnNewButton_1_1_1.setBounds(737, 165, 214, 30);
		panel.add(btnNewButton_1_1_1);
		
		JButton btnNewButton = new JButton("Çıkış Yap");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(870, 10, 106, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				javax.swing.Timer timer = new javax.swing.Timer(300, new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	Login log = new Login();
						log.setVisible(true);
						dispose();
		            }
		        });
		        timer.setRepeats(false); // Tek seferlik çalışması için
		        timer.start();
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		w_pane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon(getClass().getResource("br1.jpg")));
		lblNewLabel_2.setBounds(264, 27, 423, 229);
		w_pane.add(lblNewLabel_2);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					f_persid.setText(table.getValueAt(table.getSelectedRow(),0).toString());
				} catch (Exception ex) {
					
				}
				
			}
		});
		table.getModel().addTableModelListener(new TableModelListener ()
				 {

					@Override
					public void tableChanged(TableModelEvent e) {
						if(e.getType() == TableModelEvent.UPDATE) {
							int selectID = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
							String selectedName = table.getValueAt(table.getSelectedRow(), 1).toString();
							String selectedwHour = table.getValueAt(table.getSelectedRow(), 2).toString();
							
							try {
								boolean control = admin.updatePersonel(selectID, selectedName, selectedwHour);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
			 
				 });
 table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					f_kullaniciId.setText(table_1.getValueAt(table_1.getSelectedRow(),0).toString());
				} catch (Exception ex) {
					
				}
				
			}
		});
		
		
	}
	public void updatePersonelModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
		clearModel.setRowCount(0);
		for(int i=0;i < admin.getPersonellerList().size(); i++) {
			personelData[0]=admin.getPersonellerList().get(i).getId();
			personelData[1]=admin.getPersonellerList().get(i).getAd();
			personelData[2]=admin.getPersonellerList().get(i).getwHour();
			personelModel.addRow(personelData);
		}
	}
	public void updateUyeModel1() throws SQLException {
		DefaultTableModel clearModel1 = (DefaultTableModel) table_1.getModel();
		clearModel1.setRowCount(0);
		for(int i=0;i < uye.getUyelerList().size(); i++) {
			personelData1[0]=uye.getUyelerList().get(i).getId();
			personelData1[1]=uye.getUyelerList().get(i).getAd();
			personelData1[2]=uye.getUyelerList().get(i).getSifre();
			personelModel1.addRow(personelData1);
		}
	}
}
