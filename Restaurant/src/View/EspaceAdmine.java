package View;
import Model.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.SystemColor;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.Locale.Category;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;

public class EspaceAdmine {

	private JFrame frame;
	private JTextField adminUsrnme_tf,codePlat_tf,nomPlat_tf,prixPlat_tf,categPlat_tf,codeCatg_tf,libelleCateg_tf,idServ_tf,nomServ_tf,prenomServ_tf,usernmeServ_tf,passwrdServ_tf,actifServ_tf,nbrResServ_tf,tableNum_tf,tableNbrPlace_tf;
	private JPasswordField adminMdp_tf;
	private JPanel home,Plats,platsPanel,CategoriePanel,Serveurs,Tables,AdminLoginPanel,Left,right,rightPanel,Plt_Ctag_Panel,platDBPanel,leftPanel,platTitlePanel,categTitlePanel,ServTitlePanel,tablesTitlePanel;
	private JTable PlatsTables,categorieTable,serveurTable,tablesTable;
	private Connection con;
	private Statement stm;
	private ResultSet rs;
	private Plats plat;
	private PlatService platService;
	private JLabel lbladminIcon,PlatsLabel,codePlatLabel,nomPlatLabel,prixPlatLabel,categPlatLabel,codeCategLabel,libelleCategLabel,lblCategories,lblNumero,lblNom,lblPrenom,lblLogin,lblPassword,lblActif,lblNbrReservation,lblServeurs,lblTables,lbNumTable,lblCapacite;
	private JSeparator separator,separator_1,separator_2,separator_3,separator_4,separator_5,separator_6,separator_7;
	private JLabel lblTitle,lblAdminUsrname,lblAdminMdp,lblCnctezVs,lblMdpOublie,lblLogo,lblRestName,lblSlogan;
	private JButton LoginBtn,btnPlats,btnServeur,btnTables,btnLogOut,platPanelBtn,categPanelBtn,backBtn,ajouterPlatBtn,modifierPlatBtn,supprimerPlatBtn,affichierPlatsBtn,searchPlatsBtn,ajouterCategBtn,modifierCategBtn,supprCategBtn,affichCategBtn,searchCategBtn,backkBtn,ajouterServrBtn,modifierServrBtn,supprServrBtn,affichServrBtn,searchServeursBtn,goBackBtn,ajoutTableBtn,modifierTableBtn,supprTableBtn,affichTableBtn,searchTablesBtn;
	private JScrollPane platsTable_JSP,categTable_JSP,serveurTable_JSP,tablesTable_JSP;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		splashScreen();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//splashScreen();
					EspaceAdmine window = new EspaceAdmine();
					window.frame.setVisible(true);
				} catch (Exception e) {	
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EspaceAdmine() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1178, 757);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		AdminLoginPanel = new JPanel();
		frame.getContentPane().add(AdminLoginPanel, "name_522084129790700");
		AdminLoginPanel.setLayout(new BoxLayout(AdminLoginPanel, BoxLayout.X_AXIS));
		
		Left = 	new JPanel();
		AdminLoginPanel.add(Left);
		Left.setBackground(new Color(235,77,75));
		Left.setLayout(null);
		
		lbladminIcon = new JLabel("");
		lbladminIcon.setIcon(new ImageIcon("icons/manager.png"));
		lbladminIcon.setBounds(120, 121, 241, 248);
		Left.add(lbladminIcon);
		
		separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(62, 472, 359, 2);
		Left.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(130, 538, 235, 2);
		Left.add(separator_1);
		
		lblTitle = new JLabel("Espace Admin");
		lblTitle.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 30));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBounds(140, 420, 192, 39);
		Left.add(lblTitle);
		
		right = new JPanel();
		AdminLoginPanel.add(right);
		right.setForeground(Color.WHITE);
		right.setBackground(Color.WHITE);
		right.setLayout(null);
		
		lblAdminUsrname = new JLabel("Nom d'utilisateur :");
		lblAdminUsrname.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblAdminUsrname.setBounds(38, 258, 195, 23);
		right.add(lblAdminUsrname);
		
		lblAdminMdp = new JLabel("Mot de passe :");
		lblAdminMdp.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblAdminMdp.setBounds(38, 430, 158, 26);
		right.add(lblAdminMdp);
		
		adminUsrnme_tf = new JTextField();
		adminUsrnme_tf.setFont(new Font("Tahoma", Font.PLAIN, 17));
		adminUsrnme_tf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		adminUsrnme_tf.setForeground(Color.DARK_GRAY);
		adminUsrnme_tf.setBackground(Color.WHITE);
		adminUsrnme_tf.setBounds(38, 294, 287, 45);
		right.add(adminUsrnme_tf);
		adminUsrnme_tf.setColumns(10);
		
		lblCnctezVs = new JLabel("Connectez-vous");
		lblCnctezVs.setFont(new Font("Poor Richard", Font.BOLD, 44));
		lblCnctezVs.setBounds(38, 93, 322, 82);
		right.add(lblCnctezVs);
		
		separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(41, 352, 277, 2);
		right.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(41, 524, 277, 2);
		right.add(separator_3);
		
		adminMdp_tf = new JPasswordField();
		adminMdp_tf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		adminMdp_tf.setBounds(38, 469, 287, 45);
		right.add(adminMdp_tf);
		
		LoginBtn = new JButton("Se Connecter");
		LoginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				LoginBtn.setBackground(new Color(255, 107, 129));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LoginBtn.setBackground(new Color(235, 77, 75));
			}
		});
		LoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
				    rs=stm.executeQuery("select * from login where username = '"+adminUsrnme_tf.getText()+"' and password = '"+new String(adminMdp_tf.getPassword())+"'");
				    if(rs.next()) {
				    	adminUsrnme_tf.setText("");
				    	adminMdp_tf.setText("");
				    	AdminLoginPanel.setVisible(false);
				    	home.setVisible(true);
				    	con.close();
				    }else {
				    	JOptionPane.showMessageDialog(frame,"Nom d'utilisateur ou Mot de passe incorrecte.");				    	
				    }
				}catch(Exception e) {
					JOptionPane.showMessageDialog(frame,e);
				}
			}
		});
		LoginBtn.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		LoginBtn.setForeground(Color.WHITE);
		LoginBtn.setBackground(new Color(235,77,75));
		LoginBtn.setBounds(41, 566, 284, 52);
		right.add(LoginBtn);
		
		lblMdpOublie = new JLabel("Mot de passe oubli\u00E9 ?");
		lblMdpOublie.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblMdpOublie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMdpOublie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblMdpOublie.setForeground(new Color(27, 156, 252));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMdpOublie.setForeground(SystemColor.textHighlight);
			}
		});
		lblMdpOublie.setForeground(SystemColor.textHighlight);
		lblMdpOublie.setBounds(41, 631, 151, 16);
		right.add(lblMdpOublie);
		
		home = new JPanel();
		frame.getContentPane().add(home, "name_522162720554900");
		home.setLayout(new BoxLayout(home, BoxLayout.X_AXIS));
		
		leftPanel = new JPanel();
		leftPanel.setBackground(new Color(243, 156, 18));
		home.add(leftPanel);
		leftPanel.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("icons/chef.png"));
		lblLogo.setBounds(159, 184, 184, 156);
		leftPanel.add(lblLogo);
		
		lblRestName = new JLabel("Le Restaurant Marocain");
		lblRestName.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 37));
		lblRestName.setForeground(Color.WHITE);
		lblRestName.setBounds(61, 353, 385, 57);
		leftPanel.add(lblRestName);
		
		lblSlogan = new JLabel("Tout Les Plats Marocains Chez Nous");
		lblSlogan.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		lblSlogan.setForeground(Color.WHITE);
		lblSlogan.setBackground(Color.WHITE);
		lblSlogan.setBounds(115, 407, 344, 32);
		leftPanel.add(lblSlogan);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(Color.WHITE);
		separator_4.setBounds(62, 472, 359, 2);
		leftPanel.add(separator_4);
		
		separator_5 = new JSeparator();
		separator_5.setForeground(Color.WHITE);
		separator_5.setBounds(130, 538, 235, 2);
		leftPanel.add(separator_5);
		
		rightPanel = new JPanel();
		rightPanel.setBackground(Color.WHITE);
		home.add(rightPanel);
		rightPanel.setLayout(null);
		
		btnPlats = new JButton("      Plats");
		btnPlats.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPlats.setBackground(new Color(249, 202, 36));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPlats.setBackground(new Color(243, 156, 18));
			}
		});
		btnPlats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.setVisible(false);
				Plats.setVisible(true);
			}
		});
		btnPlats.setHorizontalAlignment(SwingConstants.LEFT);
		btnPlats.setIcon(new ImageIcon("icons/dish.png"));
		btnPlats.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		btnPlats.setForeground(Color.WHITE);
		btnPlats.setBackground(new Color(243, 156, 18));
		btnPlats.setBounds(134, 209, 195, 53);
		rightPanel.add(btnPlats);
		
		btnServeur = new JButton("     Serveurs");
		btnServeur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnServeur.setBackground(new Color(249, 202, 36));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnServeur.setBackground(new Color(243, 156, 18));
			}
		});
		btnServeur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.setVisible(false);
				Serveurs.setVisible(true);
			}
		});
		btnServeur.setHorizontalAlignment(SwingConstants.LEFT);
		btnServeur.setIcon(new ImageIcon("icons/waiter.png"));
		btnServeur.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		btnServeur.setForeground(Color.WHITE);
		btnServeur.setBackground(new Color(243, 156, 18));
		btnServeur.setBounds(134, 332, 195, 53);
		rightPanel.add(btnServeur);
		
		btnTables = new JButton("     Tables");
		btnTables.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTables.setBackground(new Color(249, 202, 36));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnTables.setBackground(new Color(243, 156, 18));
			}
		});
		btnTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.setVisible(false);
				Tables.setVisible(true);
			}
		});
		btnTables.setHorizontalAlignment(SwingConstants.LEFT);
		btnTables.setIcon(new ImageIcon("icons/dinner.png"));
		btnTables.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		btnTables.setForeground(Color.WHITE);
		btnTables.setBackground(new Color(243, 156, 18));
		btnTables.setBounds(134, 453, 195, 53);
		rightPanel.add(btnTables);
		
		btnLogOut = new JButton("");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.setVisible(false);
				AdminLoginPanel.setVisible(true);
			}
		});
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnLogOut.setBackground(new Color(241, 242, 246));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogOut.setBackground(Color.WHITE);
			}
		});
		btnLogOut.setBounds(491, 637, 77, 60);
		rightPanel.add(btnLogOut);
		btnLogOut.setFocusPainted(false);
		btnLogOut.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.setIcon(new ImageIcon("icons/logout (1).png"));
		
		Plats = new JPanel();
		Plats.setBackground(Color.WHITE);
		frame.getContentPane().add(Plats, "name_535374106093800");
		Plats.setLayout(null);
		
		Plt_Ctag_Panel = new JPanel();
		Plt_Ctag_Panel.setBackground(new Color(249, 202, 36));
		Plt_Ctag_Panel.setBounds(0, 0, 247, 710);
		Plats.add(Plt_Ctag_Panel);
		Plt_Ctag_Panel.setLayout(null);
		
		platPanelBtn = new JButton("     Plats");
		platPanelBtn.setFocusPainted(false);
		platPanelBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				platPanelBtn.setBackground(new Color(246, 229, 141));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				platPanelBtn.setBackground(new Color(249, 202, 36));
			}
		});
		platPanelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CategoriePanel.setVisible(false);
				platsPanel.setVisible(true);
				codeCatg_tf.setText("");
				libelleCateg_tf.setText("");
			}
		});
		platPanelBtn.setIcon(new ImageIcon("icons/dish (1).png"));
		platPanelBtn.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		platPanelBtn.setHorizontalAlignment(SwingConstants.LEFT);
		platPanelBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		platPanelBtn.setBackground(new Color(249, 202, 36));
		platPanelBtn.setBounds(24, 190, 200, 57);
		Plt_Ctag_Panel.add(platPanelBtn);
		
		categPanelBtn = new JButton("     Categories");
		categPanelBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				categPanelBtn.setBackground(new Color(246, 229, 141));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				categPanelBtn.setBackground(new Color(249, 202, 36));
			}
		});
		categPanelBtn.setFocusPainted(false);
		categPanelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				platsPanel.setVisible(false);
				CategoriePanel.setVisible(true);
				codePlat_tf.setText("");
				nomPlat_tf.setText("");
				prixPlat_tf.setText("");
				categPlat_tf.setText("");
			}
		});
		categPanelBtn.setIcon(new ImageIcon("icons/salad.png"));
		categPanelBtn.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		categPanelBtn.setHorizontalAlignment(SwingConstants.LEFT);
		categPanelBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		categPanelBtn.setBackground(new Color(249, 202, 36));
		categPanelBtn.setBounds(24, 331, 200, 57);
		Plt_Ctag_Panel.add(categPanelBtn);
		
		backBtn = new JButton("");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backBtn.setBackground(new Color(246, 229, 141));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backBtn.setBackground(new Color(249, 202, 36));
			}
		});
		backBtn.setFocusPainted(false);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Plats.setVisible(false);
				home.setVisible(true);
				codePlat_tf.setText("");
				nomPlat_tf.setText("");
				prixPlat_tf.setText("");
				categPlat_tf.setText("");
				codeCatg_tf.setText("");
				libelleCateg_tf.setText("");
			}
		});
		backBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		backBtn.setBackground(new Color(249, 202, 36));
		backBtn.setIcon(new ImageIcon("icons/left-arrow.png"));
		backBtn.setBounds(0, 13, 87, 39);
		Plt_Ctag_Panel.add(backBtn);
		
		separator_6 = new JSeparator();
		separator_6.setBackground(Color.BLACK);
		separator_6.setForeground(Color.BLACK);
		separator_6.setBounds(24, 260, 200, 2);
		Plt_Ctag_Panel.add(separator_6);
		
		separator_7 = new JSeparator();
		separator_7.setForeground(Color.BLACK);
		separator_7.setBackground(Color.BLACK);
		separator_7.setBounds(24, 401, 200, 2);
		Plt_Ctag_Panel.add(separator_7);
		
		platDBPanel = new JPanel();
		platDBPanel.setBounds(246, 0, 914, 710);
		Plats.add(platDBPanel);
		platDBPanel.setLayout(new CardLayout(0, 0));
		
		platsPanel = new JPanel();
		platsPanel.setBackground(Color.WHITE);
		platDBPanel.add(platsPanel, "name_607913026316200");
		platsPanel.setLayout(null);
		
		platTitlePanel = new JPanel();
		platTitlePanel.setBackground(new Color(235, 77, 75));
		platTitlePanel.setBounds(0, 0, 914, 132);
		platsPanel.add(platTitlePanel);
		platTitlePanel.setLayout(null);
		
		PlatsLabel = new JLabel(" Plats");
		PlatsLabel.setIcon(new ImageIcon("icons/serving-dish.png"));
		PlatsLabel.setForeground(Color.WHITE);
		PlatsLabel.setBackground(Color.WHITE);
		PlatsLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 50));
		PlatsLabel.setBounds(350, 35, 261, 84);
		platTitlePanel.add(PlatsLabel);
		
		codePlatLabel = new JLabel("Code");
		codePlatLabel.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		codePlatLabel.setBounds(59, 260, 95, 39);
		platsPanel.add(codePlatLabel);
		
		nomPlatLabel = new JLabel("Nom");
		nomPlatLabel.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		nomPlatLabel.setBounds(59, 323, 86, 26);
		platsPanel.add(nomPlatLabel);
		
		prixPlatLabel = new JLabel("Prix (Dhs)");
		prixPlatLabel.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		prixPlatLabel.setBounds(59, 386, 106, 33);
		platsPanel.add(prixPlatLabel);
		
		categPlatLabel = new JLabel("Categorie");
		categPlatLabel.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		categPlatLabel.setBounds(59, 449, 95, 33);
		platsPanel.add(categPlatLabel);
		
		ajouterPlatBtn = new JButton("Ajouter");
		ajouterPlatBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					rs = stm.executeQuery("select * from Plate where CodePlat = "+Integer.parseInt(codePlat_tf.getText()));
					if(rs.next()) {
						JOptionPane.showMessageDialog(frame,"Plat existe d�ja");
					}else {						
						stm.executeUpdate("insert into Plate values ("+Integer.parseInt(codePlat_tf.getText())+",'"+nomPlat_tf.getText()+"','"+Double.parseDouble(prixPlat_tf.getText())+"','"+categPlat_tf.getText()+"')");
				    	JOptionPane.showMessageDialog(frame,"Plat Ajout�");
				    	codePlat_tf.setText("");
						nomPlat_tf.setText("");
						prixPlat_tf.setText("");
						categPlat_tf.setText("");
				    	con.close();
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		ajouterPlatBtn.setBackground(new Color(255, 71, 87));
		ajouterPlatBtn.setForeground(Color.WHITE);
		ajouterPlatBtn.setBounds(386, 503, 117, 35);
		platsPanel.add(ajouterPlatBtn);
		
		modifierPlatBtn = new JButton("Modifier");
		modifierPlatBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					stm.executeUpdate("update Plate set NomPlate = '"+nomPlat_tf.getText()+"',PrixPlate="+Double.parseDouble(prixPlat_tf.getText())+",CodeCat='"+categPlat_tf.getText()+"' where CodePlat="+Integer.parseInt(codePlat_tf.getText()));
					JOptionPane.showMessageDialog(frame,"Le Plat avec le code "+codePlat_tf.getText()+" a �t� modifi�");
					codePlat_tf.setText("");
					nomPlat_tf.setText("");
					prixPlat_tf.setText("");
					categPlat_tf.setText("");
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		modifierPlatBtn.setBackground(new Color(255, 71, 87));
		modifierPlatBtn.setForeground(Color.WHITE);
		modifierPlatBtn.setBounds(515, 503, 117, 35);
		platsPanel.add(modifierPlatBtn);
		
		supprimerPlatBtn = new JButton("Supprimer");
		supprimerPlatBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					if(codePlat_tf.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame,"Veuillez entrer le code du plat a supprim�");
					}else {
					    int response = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce plat ?", "Confirmer",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					    if (response == JOptionPane.YES_OPTION) {
					    	rs = stm.executeQuery("select * from Plate where CodePlat = '"+codePlat_tf.getText()+"'");
					    	if(rs.next()) {
					    		stm.executeUpdate("delete from Plate where CodePlat = '"+codePlat_tf.getText()+"'");
					    		JOptionPane.showMessageDialog(frame,"Plat Supprim�");
					    		codePlat_tf.setText("");
					    		nomPlat_tf.setText("");
					    		prixPlat_tf.setText("");
					    		categPlat_tf.setText("");
						}else {
							JOptionPane.showMessageDialog(frame,"Plat n'existe pas.");
						}
					}
					}
								
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		supprimerPlatBtn.setBackground(new Color(255, 71, 87));
		supprimerPlatBtn.setForeground(Color.WHITE);
		supprimerPlatBtn.setBounds(644, 503, 117, 35);
		platsPanel.add(supprimerPlatBtn);
		
		affichierPlatsBtn = new JButton("Afficher");
		affichierPlatsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					rs = stm.executeQuery("select * from Plate");
//					while(rs.next()) {
//						plat = new Plats(Integer.parseInt(rs.getString(2)),rs.getString(3),Double.parseDouble(rs.getString(4)),rs.getString(1));
//						platService.addPlat(plat);
//					}
//					DefaultTableModel dtm = (DefaultTableModel) PlatsTables.getModel();
//					Object[] row = new Object[4];
//					for(int i = 0 ; i<platService.getListPlat().size();i++) {
//						row[0] = platService.getPlatById(i).getCode();
//						row[1] = platService.getPlatById(i).getNom();
//						row[2] = platService.getPlatById(i).getPrix();
//						row[3] = platService.getPlatById(i).getCategorie();
//						dtm.addRow(row);
//					}
//					String[] columns = {"Code","Nom","Prix","Categorie"}; 
//					dtm.setColumnIdentifiers(columns);
//					PlatsTables.setModel(dtm);
					PlatsTables.setModel(DbUtils.resultSetToTableModel(rs));
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		affichierPlatsBtn.setBackground(new Color(255, 71, 87));
		affichierPlatsBtn.setForeground(Color.WHITE);
		affichierPlatsBtn.setBounds(773, 503, 117, 35);
		platsPanel.add(affichierPlatsBtn);
		
		codePlat_tf = new JTextField();
		codePlat_tf.setHorizontalAlignment(SwingConstants.CENTER);
		codePlat_tf.setForeground(new Color(235, 77, 75));
		codePlat_tf.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		codePlat_tf.setBounds(165, 260, 171, 32);
		platsPanel.add(codePlat_tf);
		codePlat_tf.setColumns(10);
		
		nomPlat_tf = new JTextField();
		nomPlat_tf.setHorizontalAlignment(SwingConstants.CENTER);
		nomPlat_tf.setForeground(new Color(235, 77, 75));
		nomPlat_tf.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		nomPlat_tf.setColumns(10);
		nomPlat_tf.setBounds(165, 323, 171, 32);
		platsPanel.add(nomPlat_tf);
		
		prixPlat_tf = new JTextField();
		prixPlat_tf.setHorizontalAlignment(SwingConstants.CENTER);
		prixPlat_tf.setForeground(new Color(235, 77, 75));
		prixPlat_tf.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		prixPlat_tf.setColumns(10);
		prixPlat_tf.setBounds(165, 386, 171, 32);
		platsPanel.add(prixPlat_tf);
		
		categPlat_tf = new JTextField();
		categPlat_tf.setHorizontalAlignment(SwingConstants.CENTER);
		categPlat_tf.setForeground(new Color(235, 77, 75));
		categPlat_tf.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		categPlat_tf.setColumns(10);
		categPlat_tf.setBounds(166, 449, 171, 32);
		platsPanel.add(categPlat_tf);
		
		platsTable_JSP = new JScrollPane();
		platsTable_JSP.setBounds(386, 260, 502, 230);
		platsPanel.add(platsTable_JSP);
		
		PlatsTables = new JTable();
		PlatsTables.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Code", "Nom", "Prix", "Categorie"
			}
		));
		platsTable_JSP.setViewportView(PlatsTables);
		
		searchPlatsBtn = new JButton("");
		searchPlatsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!codePlat_tf.getText().isEmpty()) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
				    rs = stm.executeQuery("select * from Plate where CodePlat = "+Integer.parseInt(codePlat_tf.getText()));
				    if(rs.next()) {
						codePlat_tf.setText(rs.getString(1));
						nomPlat_tf.setText(rs.getString(2));
						prixPlat_tf.setText(rs.getString(3));
						categPlat_tf.setText(rs.getString(4));
											
					}else {
						JOptionPane.showMessageDialog(frame,"Plat n'existe pas.");
						codePlat_tf.setText("");
						nomPlat_tf.setText("");
						prixPlat_tf.setText("");
						categPlat_tf.setText("");
					}
				    	
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}}
			}
		});
		searchPlatsBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				searchPlatsBtn.setBackground(new Color(241, 242, 246));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				searchPlatsBtn.setBackground(Color.WHITE);
			}
		});
		searchPlatsBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		searchPlatsBtn.setFocusPainted(false);

		searchPlatsBtn.setIcon(new ImageIcon("icons/magnifier.png"));
		searchPlatsBtn.setBackground(Color.WHITE);
		searchPlatsBtn.setBounds(335, 260, 39, 32);
		platsPanel.add(searchPlatsBtn);
		
		CategoriePanel = new JPanel();
		CategoriePanel.setBackground(Color.WHITE);
		platDBPanel.add(CategoriePanel, "name_607915146906800");
		CategoriePanel.setLayout(null);
		
		codeCategLabel = new JLabel("Code");
		codeCategLabel.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		codeCategLabel.setBounds(59, 260, 95, 39);
		CategoriePanel.add(codeCategLabel);
		
		libelleCategLabel = new JLabel("Libelle");
		libelleCategLabel.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		libelleCategLabel.setBounds(59, 323, 95, 39);
		CategoriePanel.add(libelleCategLabel);
		
		categTitlePanel = new JPanel();
		categTitlePanel.setLayout(null);
		categTitlePanel.setBackground(new Color(235, 77, 75));
		categTitlePanel.setBounds(0, 0, 914, 132);
		CategoriePanel.add(categTitlePanel);
		
		lblCategories = new JLabel("  Categories");
		lblCategories.setIcon(new ImageIcon("icons/cutlery.png"));
		lblCategories.setForeground(Color.WHITE);
		lblCategories.setFont(new Font("Tempus Sans ITC", Font.BOLD, 50));
		lblCategories.setBackground(Color.WHITE);
		lblCategories.setBounds(288, 35, 389, 84);
		categTitlePanel.add(lblCategories);
		
		codeCatg_tf = new JTextField();
		codeCatg_tf.setForeground(new Color(235, 77, 75));
		codeCatg_tf.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		codeCatg_tf.setColumns(10);
		codeCatg_tf.setBounds(161, 260, 171, 32);
		CategoriePanel.add(codeCatg_tf);
		
		libelleCateg_tf = new JTextField();
		libelleCateg_tf.setForeground(new Color(235, 77, 75));
		libelleCateg_tf.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		libelleCateg_tf.setColumns(10);
		libelleCateg_tf.setBounds(161, 323, 171, 32);
		CategoriePanel.add(libelleCateg_tf);
		
		categTable_JSP = new JScrollPane();
		categTable_JSP.setBounds(386, 260, 502, 230);
		CategoriePanel.add(categTable_JSP);
		
		categorieTable = new JTable();
		categorieTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Libelle", "Code"
			}
		));
		categTable_JSP.setViewportView(categorieTable);
		
		ajouterCategBtn = new JButton("Ajouter");
		ajouterCategBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
				    stm.executeUpdate("insert into Categorie values ('"+codeCatg_tf.getText()+"','"+libelleCateg_tf.getText()+"')");
				    JOptionPane.showMessageDialog(frame,"Categorie Ajout�");
				    codeCatg_tf.setText("");
					libelleCateg_tf.setText("");
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		ajouterCategBtn.setForeground(Color.WHITE);
		ajouterCategBtn.setBackground(new Color(255, 71, 87));
		ajouterCategBtn.setBounds(386, 503, 117, 35);
		CategoriePanel.add(ajouterCategBtn);
		
		modifierCategBtn = new JButton("Modifier");
		modifierCategBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					stm.executeUpdate("update Categorie set LibelleCat = '"+libelleCateg_tf.getText()+"' where CodeCat='"+codeCatg_tf.getText()+"'");
					JOptionPane.showMessageDialog(frame,"La Categorie avec le code "+codeCatg_tf.getText()+" a �t� modifi�e");
					codeCatg_tf.setText("");
					libelleCateg_tf.setText("");
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		modifierCategBtn.setForeground(Color.WHITE);
		modifierCategBtn.setBackground(new Color(255, 71, 87));
		modifierCategBtn.setBounds(513, 503, 117, 35);
		CategoriePanel.add(modifierCategBtn);
		
		supprCategBtn = new JButton("Supprimer");
		supprCategBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					if(codeCatg_tf.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame,"Veuillez entrer le code du Categorie a supprim�e");
					}else {
					    int response = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette categorie ?", "Confirmer",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					    if (response == JOptionPane.YES_OPTION) {
						rs = stm.executeQuery("select * from Categorie where CodeCat = '"+codeCatg_tf.getText()+"'");
						if(rs.next()) {
							stm.executeUpdate("delete from Categorie where CodeCat = '"+codeCatg_tf.getText()+"'");
							JOptionPane.showMessageDialog(frame,"Categorie Supprim�");
							codeCatg_tf.setText("");
							libelleCateg_tf.setText("");
						}else {
							JOptionPane.showMessageDialog(frame,"Categorie n'existe pas.");
						}
					    }
					}
								
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		supprCategBtn.setForeground(Color.WHITE);
		supprCategBtn.setBackground(new Color(255, 71, 87));
		supprCategBtn.setBounds(642, 503, 117, 35);
		CategoriePanel.add(supprCategBtn);
		
		affichCategBtn = new JButton("Afficher");
		affichCategBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					rs = stm.executeQuery("select * from Categorie");
					categorieTable.setModel(DbUtils.resultSetToTableModel(rs));
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		affichCategBtn.setForeground(Color.WHITE);
		affichCategBtn.setBackground(new Color(255, 71, 87));
		affichCategBtn.setBounds(771, 503, 117, 35);
		CategoriePanel.add(affichCategBtn);
		
		searchCategBtn = new JButton("");
		searchCategBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!codeCatg_tf.getText().isEmpty()) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
				    rs = stm.executeQuery("select * from Categorie where CodeCat = '"+codeCatg_tf.getText()+"'");
				    if(rs.next()) {
						codeCatg_tf.setText(rs.getString(1));
						libelleCateg_tf.setText(rs.getString(2));
					}else {
						JOptionPane.showMessageDialog(frame,"Categorie n'existe pas.");
						codeCatg_tf.setText("");
						libelleCateg_tf.setText("");
					}
				    	
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}}
			}
		});
		searchCategBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				searchCategBtn.setBackground(new Color(241, 242, 246));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				searchCategBtn.setBackground(Color.WHITE);
			}
		});
		searchCategBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		searchCategBtn.setFocusPainted(false);

		searchCategBtn.setIcon(new ImageIcon("icons/magnifier.png"));
		searchCategBtn.setBackground(Color.WHITE);
		searchCategBtn.setBounds(335, 260, 39, 32);
		CategoriePanel.add(searchCategBtn);
		
		Serveurs = new JPanel();
		Serveurs.setBackground(Color.WHITE);
		frame.getContentPane().add(Serveurs, "name_618400822586100");
		Serveurs.setLayout(null);
		
		lblNumero = new JLabel("ID");
		lblNumero.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblNumero.setBounds(127, 241, 95, 39);
		Serveurs.add(lblNumero);
		
		idServ_tf = new JTextField();
		idServ_tf.setHorizontalAlignment(SwingConstants.CENTER);
		idServ_tf.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		idServ_tf.setForeground(new Color(235, 77, 75));
		idServ_tf.setColumns(10);
		idServ_tf.setBounds(282, 246, 171, 32);
		Serveurs.add(idServ_tf);
		
		lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblNom.setBounds(127, 304, 95, 39);
		Serveurs.add(lblNom);
		
		nomServ_tf = new JTextField();
		nomServ_tf.setHorizontalAlignment(SwingConstants.CENTER);
		nomServ_tf.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		nomServ_tf.setForeground(new Color(235, 77, 75));
		nomServ_tf.setColumns(10);
		nomServ_tf.setBounds(282, 309, 171, 32);
		Serveurs.add(nomServ_tf);
		
		lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblPrenom.setBounds(127, 367, 95, 39);
		Serveurs.add(lblPrenom);
		
		prenomServ_tf = new JTextField();
		prenomServ_tf.setHorizontalAlignment(SwingConstants.CENTER);
		prenomServ_tf.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		prenomServ_tf.setForeground(new Color(235, 77, 75));
		prenomServ_tf.setColumns(10);
		prenomServ_tf.setBounds(282, 372, 171, 32);
		Serveurs.add(prenomServ_tf);
		
		lblLogin = new JLabel("Username");
		lblLogin.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblLogin.setBounds(127, 430, 95, 39);
		Serveurs.add(lblLogin);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblPassword.setBounds(127, 493, 95, 39);
		Serveurs.add(lblPassword);
		
		lblActif = new JLabel("Actif");
		lblActif.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblActif.setBounds(127, 556, 95, 39);
		Serveurs.add(lblActif);
		
		usernmeServ_tf = new JTextField();
		usernmeServ_tf.setHorizontalAlignment(SwingConstants.CENTER);
		usernmeServ_tf.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		usernmeServ_tf.setForeground(new Color(235, 77, 75));
		usernmeServ_tf.setColumns(10);
		usernmeServ_tf.setBounds(282, 435, 171, 32);
		Serveurs.add(usernmeServ_tf);
		
		passwrdServ_tf = new JTextField();
		passwrdServ_tf.setHorizontalAlignment(SwingConstants.CENTER);
		passwrdServ_tf.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		passwrdServ_tf.setForeground(new Color(235, 77, 75));
		passwrdServ_tf.setColumns(10);
		passwrdServ_tf.setBounds(282, 498, 171, 32);
		Serveurs.add(passwrdServ_tf);
		
		actifServ_tf = new JTextField();
		actifServ_tf.setHorizontalAlignment(SwingConstants.CENTER);
		actifServ_tf.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		actifServ_tf.setForeground(new Color(235, 77, 75));
		actifServ_tf.setColumns(10);
		actifServ_tf.setBounds(282, 561, 171, 32);
		Serveurs.add(actifServ_tf);
		
		lblNbrReservation = new JLabel("Nbr Reservation");
		lblNbrReservation.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblNbrReservation.setBounds(127, 619, 156, 39);
		Serveurs.add(lblNbrReservation);
		
		nbrResServ_tf = new JTextField();
		nbrResServ_tf.setHorizontalAlignment(SwingConstants.CENTER);
		nbrResServ_tf.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		nbrResServ_tf.setForeground(new Color(235, 77, 75));
		nbrResServ_tf.setColumns(10);
		nbrResServ_tf.setBounds(282, 624, 171, 32);
		Serveurs.add(nbrResServ_tf);
		
		ServTitlePanel = new JPanel();
		ServTitlePanel.setBackground(new Color(235, 77, 75));
		ServTitlePanel.setBounds(0, 0, 1160, 194);
		Serveurs.add(ServTitlePanel);
		ServTitlePanel.setLayout(null);
		
		lblServeurs = new JLabel(" Serveurs");
		lblServeurs.setIcon(new ImageIcon("icons/waiter64.png"));
		lblServeurs.setBounds(444, 67, 302, 66);
		lblServeurs.setForeground(Color.WHITE);
		lblServeurs.setFont(new Font("Tempus Sans ITC", Font.BOLD, 50));
		lblServeurs.setBackground(Color.WHITE);
		ServTitlePanel.add(lblServeurs);
		
		backkBtn = new JButton("");
		backkBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				backkBtn.setBackground(new Color(235, 77, 75));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				backkBtn.setBackground(new Color(255, 121, 121));
			}
		});
		backkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Serveurs.setVisible(false);
				home.setVisible(true);
				idServ_tf.setText("");
				nomServ_tf.setText("");
				prenomServ_tf.setText("");
				usernmeServ_tf.setText("");
				passwrdServ_tf.setText("");
				actifServ_tf.setText("");
				nbrResServ_tf.setText("");
			}
		});
		backkBtn.setBackground(new Color(235, 77, 75));
		backkBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		backkBtn.setIcon(new ImageIcon("icons/left-arrow-yellow.png"));
		backkBtn.setBounds(0, 13, 87, 39);
		ServTitlePanel.add(backkBtn);
		
		serveurTable_JSP = new JScrollPane();
		serveurTable_JSP.setBounds(545, 246, 603, 340);
		Serveurs.add(serveurTable_JSP);
		
		serveurTable = new JTable();
		serveurTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero", "Nom", "Prenom", "Username", "Password", "Actif", "NbrRes"
			}
		));
		serveurTable_JSP.setViewportView(serveurTable);
		
		ajouterServrBtn = new JButton("Ajouter");
		ajouterServrBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					rs = stm.executeQuery("select * from Serveur where IDSer = "+Integer.parseInt(idServ_tf.getText()));
					if(rs.next()) {
						JOptionPane.showMessageDialog(frame,"Serveur avec cet ID existe dja");
					}else {
						stm.executeUpdate("insert into Serveur values ("+Integer.parseInt(idServ_tf.getText())+",'"+nomServ_tf.getText()+"','"+prenomServ_tf.getText()+"','"+usernmeServ_tf.getText()+"','"+passwrdServ_tf.getText()+"','"+actifServ_tf.getText()+"','"+Integer.parseInt(nbrResServ_tf.getText())+"')");
						JOptionPane.showMessageDialog(frame,"Serveur Ajout�");
						idServ_tf.setText("");
						nomServ_tf.setText("");
						prenomServ_tf.setText("");
						usernmeServ_tf.setText("");
						passwrdServ_tf.setText("");
						actifServ_tf.setText("");
						nbrResServ_tf.setText("");
						con.close();
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		ajouterServrBtn.setForeground(Color.WHITE);
		ajouterServrBtn.setBackground(new Color(255, 71, 87));
		ajouterServrBtn.setBounds(545, 599, 140, 35);
		Serveurs.add(ajouterServrBtn);
		
		modifierServrBtn = new JButton("Modifier");
		modifierServrBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					stm.executeUpdate("update Serveur set NomSer='"+nomServ_tf.getText()+"',PreNomSer='"+prenomServ_tf.getText()+"',login='"+usernmeServ_tf.getText()+"',password='"+passwrdServ_tf.getText()+"',actif='"+actifServ_tf.getText()+"',NbrRes="+Integer.parseInt(nbrResServ_tf.getText())+" where IDSer="+Integer.parseInt(idServ_tf.getText()));
					JOptionPane.showMessageDialog(frame,"Le Serveur avec le numero "+idServ_tf.getText()+" a �t� modifi�");
					idServ_tf.setText("");
					nomServ_tf.setText("");
					prenomServ_tf.setText("");
					usernmeServ_tf.setText("");
					passwrdServ_tf.setText("");
					actifServ_tf.setText("");
					nbrResServ_tf.setText("");
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		modifierServrBtn.setForeground(Color.WHITE);
		modifierServrBtn.setBackground(new Color(255, 71, 87));
		modifierServrBtn.setBounds(695, 599, 140, 35);
		Serveurs.add(modifierServrBtn);
		
		supprServrBtn = new JButton("Supprimer");
		supprServrBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					if(idServ_tf.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame,"Veuillez entrer le numero du serveur a supprim�");
					}else {
						int response = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce serveur ?", "Confirmer",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					    if (response == JOptionPane.YES_OPTION) {
						rs = stm.executeQuery("select * from Serveur where IDSer = "+Integer.parseInt(idServ_tf.getText()));
						if(rs.next()) {
							stm.executeUpdate("delete from Serveur where IDSer = "+Integer.parseInt(idServ_tf.getText()));
							JOptionPane.showMessageDialog(frame,"Serveur Supprim�");
							idServ_tf.setText("");
							nomServ_tf.setText("");
							prenomServ_tf.setText("");
							usernmeServ_tf.setText("");
							passwrdServ_tf.setText("");
							actifServ_tf.setText("");
							nbrResServ_tf.setText("");
						}else {
							JOptionPane.showMessageDialog(frame,"Serveur avec cet ID n'existe pas.");
						}
					    }
					}
								
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		supprServrBtn.setForeground(Color.WHITE);
		supprServrBtn.setBackground(new Color(255, 71, 87));
		supprServrBtn.setBounds(847, 599, 140, 35);
		Serveurs.add(supprServrBtn);
		
		affichServrBtn = new JButton("Afficher");
		affichServrBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					rs = stm.executeQuery("select * from Serveur");
					serveurTable.setModel(DbUtils.resultSetToTableModel(rs));
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		affichServrBtn.setForeground(Color.WHITE);
		affichServrBtn.setBackground(new Color(255, 71, 87));
		affichServrBtn.setBounds(999, 599, 140, 35);
		Serveurs.add(affichServrBtn);
		
		searchServeursBtn = new JButton("");
		searchServeursBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!idServ_tf.getText().isEmpty()) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
				    rs = stm.executeQuery("select * from Serveur where IDSer = "+Integer.parseInt(idServ_tf.getText()));
				    if(rs.next()) {
						idServ_tf.setText(rs.getString(1));
						nomServ_tf.setText(rs.getString(2));
						prenomServ_tf.setText(rs.getString(3));
						usernmeServ_tf.setText(rs.getString(4));
						passwrdServ_tf.setText(rs.getString(5));
						actifServ_tf.setText(rs.getString(6));
						nbrResServ_tf.setText(rs.getString(7));										
					}else {
						JOptionPane.showMessageDialog(frame,"Serveur avec cet ID n'existe pas.");
						idServ_tf.setText("");
						nomServ_tf.setText("");
						prenomServ_tf.setText("");
						usernmeServ_tf.setText("");
						passwrdServ_tf.setText("");
						actifServ_tf.setText("");
						nbrResServ_tf.setText("");
					}				    	
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}}
			}
		});
		searchServeursBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				searchServeursBtn.setBackground(new Color(241, 242, 246));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				searchServeursBtn.setBackground(Color.WHITE);
			}
		});
		searchServeursBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		searchServeursBtn.setFocusPainted(false);
		searchServeursBtn.setIcon(new ImageIcon("icons/magnifier.png"));
		searchServeursBtn.setBackground(Color.WHITE);
		searchServeursBtn.setBounds(453, 246, 39, 32);
		Serveurs.add(searchServeursBtn);
		
		Tables = new JPanel();
		Tables.setBackground(Color.WHITE);
		frame.getContentPane().add(Tables, "name_625568824359500");
		Tables.setLayout(null);
		
		tablesTitlePanel = new JPanel();
		tablesTitlePanel.setBackground(new Color(235, 77, 75));
		tablesTitlePanel.setBounds(0, 0, 1160, 164);
		Tables.add(tablesTitlePanel);
		tablesTitlePanel.setLayout(null);
		
		lblTables = new JLabel("  Tables");
		lblTables.setIcon(new ImageIcon("icons/table.png"));
		lblTables.setForeground(Color.WHITE);
		lblTables.setFont(new Font("Tempus Sans ITC", Font.BOLD, 50));
		lblTables.setBackground(Color.WHITE);
		lblTables.setBounds(418, 55, 302, 66);
		tablesTitlePanel.add(lblTables);
		
		goBackBtn = new JButton("");
		goBackBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				goBackBtn.setBackground(new Color(255, 121, 121));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				goBackBtn.setBackground(new Color(235, 77, 75));
			}
		});
		goBackBtn.setFocusPainted(false);
		goBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tables.setVisible(false);
				home.setVisible(true);
				tableNum_tf.setText("");
				tableNbrPlace_tf.setText("");
			}
		});
		goBackBtn.setIcon(new ImageIcon("icons/left-arrow-yellow.png"));
		goBackBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		goBackBtn.setBackground(new Color(235, 77, 75));
		goBackBtn.setBounds(0, 13, 87, 39);
		tablesTitlePanel.add(goBackBtn);
		
		lbNumTable = new JLabel("Num\u00E9ro");
		lbNumTable.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lbNumTable.setBounds(127, 303, 95, 39);
		Tables.add(lbNumTable);
		
		lblCapacite = new JLabel("Nbr de Place");
		lblCapacite.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblCapacite.setBounds(127, 382, 139, 39);
		Tables.add(lblCapacite);
		
		tableNum_tf = new JTextField();
		tableNum_tf.setHorizontalAlignment(SwingConstants.CENTER);
		tableNum_tf.setForeground(new Color(235, 77, 75));
		tableNum_tf.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		tableNum_tf.setColumns(10);
		tableNum_tf.setBounds(284, 303, 171, 32);
		Tables.add(tableNum_tf);
		
		tableNbrPlace_tf = new JTextField();
		tableNbrPlace_tf.setHorizontalAlignment(SwingConstants.CENTER);
		tableNbrPlace_tf.setForeground(new Color(235, 77, 75));
		tableNbrPlace_tf.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		tableNbrPlace_tf.setColumns(10);
		tableNbrPlace_tf.setBounds(284, 382, 171, 32);
		Tables.add(tableNbrPlace_tf);
		
		tablesTable_JSP = new JScrollPane();
		tablesTable_JSP.setBounds(594, 271, 537, 164);
		Tables.add(tablesTable_JSP);
		
		tablesTable = new JTable();
		tablesTable.setBackground(Color.WHITE);
		tablesTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Num\u00E9ro", "Nbr de Place"
			}
		));
		tablesTable_JSP.setViewportView(tablesTable);
		
		ajoutTableBtn = new JButton("Ajouter");
		ajoutTableBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					rs = stm.executeQuery("select * from Tables where NumTable = "+Integer.parseInt(tableNum_tf.getText()));
					if(rs.next()) {
						JOptionPane.showMessageDialog(frame,"Table avec ce Numero existe d�ja");
					}else {				
						stm.executeUpdate("insert into Tables values ("+Integer.parseInt(tableNum_tf.getText())+","+Integer.parseInt(tableNbrPlace_tf.getText())+")");
						JOptionPane.showMessageDialog(frame,"Table Ajout�");
						tableNum_tf.setText("");
						tableNbrPlace_tf.setText("");
						con.close();
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		ajoutTableBtn.setForeground(Color.WHITE);
		ajoutTableBtn.setBackground(new Color(255, 71, 87));
		ajoutTableBtn.setBounds(594, 448, 124, 35);
		Tables.add(ajoutTableBtn);
		
		modifierTableBtn = new JButton("Modifier");
		modifierTableBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					stm.executeUpdate("update Tables set NbrPlaceTable = "+Integer.parseInt(tableNbrPlace_tf.getText())+" where NumTable="+Integer.parseInt(tableNum_tf.getText()));
					JOptionPane.showMessageDialog(frame,"La Tables avec le code "+tableNum_tf.getText()+" a �t� modifi�e");
					tableNum_tf.setText("");
					tableNbrPlace_tf.setText("");
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		modifierTableBtn.setForeground(Color.WHITE);
		modifierTableBtn.setBackground(new Color(255, 71, 87));
		modifierTableBtn.setBounds(735, 448, 124, 35);
		Tables.add(modifierTableBtn);
		
		supprTableBtn = new JButton("Supprimer");
		supprTableBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					if(tableNum_tf.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame,"Veuillez entrer le numero du Table a supprim�e");
					}else {
						int response = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette table ?", "Confirmer",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					    if (response == JOptionPane.YES_OPTION) {
						rs = stm.executeQuery("select * from Tables where NumTable = "+Integer.parseInt(tableNum_tf.getText()));
						if(rs.next()) {
							stm.executeUpdate("delete from Tables where NumTable = "+Integer.parseInt(tableNum_tf.getText()));
							JOptionPane.showMessageDialog(frame,"Table Supprim�");
							tableNum_tf.setText("");
							tableNbrPlace_tf.setText("");
						}else {
							JOptionPane.showMessageDialog(frame,"Table avec ce numero n'existe pas.");
						}
					    }
					}
								
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		supprTableBtn.setForeground(Color.WHITE);
		supprTableBtn.setBackground(new Color(255, 71, 87));
		supprTableBtn.setBounds(871, 448, 124, 35);
		Tables.add(supprTableBtn);
		
		affichTableBtn = new JButton("Afficher");
		affichTableBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					rs = stm.executeQuery("select * from Tables");
					tablesTable.setModel(DbUtils.resultSetToTableModel(rs));
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		affichTableBtn.setForeground(Color.WHITE);
		affichTableBtn.setBackground(new Color(255, 71, 87));
		affichTableBtn.setBounds(1007, 448, 124, 35);
		Tables.add(affichTableBtn);
		
		searchTablesBtn = new JButton("");
		searchTablesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tableNum_tf.getText().isEmpty()) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
				    rs = stm.executeQuery("select * from Tables where NumTable = "+Integer.parseInt(tableNum_tf.getText()));
				    if(rs.next()) {
						tableNum_tf.setText(rs.getString(1));
						tableNbrPlace_tf.setText(rs.getString(2));										
					}else {
						JOptionPane.showMessageDialog(frame,"Table avec ce numero n'existe pas.");
						tableNum_tf.setText("");
						tableNbrPlace_tf.setText("");	
					}
				    	
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}}
			}
		});
		searchTablesBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				searchTablesBtn.setBackground(new Color(241, 242, 246));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				searchTablesBtn.setBackground(Color.WHITE);
			}
		});
		searchTablesBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		searchTablesBtn.setFocusPainted(false);
		
		searchTablesBtn.setIcon(new ImageIcon("icons/magnifier.png"));
		searchTablesBtn.setBackground(Color.WHITE);
		searchTablesBtn.setBounds(458, 303, 39, 32);
		Tables.add(searchTablesBtn);
	}
	public static void splashScreen() {
		JWindow jw  = new JWindow();
        jw.getContentPane().add(new JLabel("",new ImageIcon("icons/egg_loader_002.gif"),SwingConstants.CENTER));
        jw.setBounds(450,300,700,500);
        jw.setVisible(true);
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException e){}
        jw.dispose();
	}
}
