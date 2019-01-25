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
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel home;
	private JPanel Plats;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable PlatsTables;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable categorieTable;
	private JPanel platsPanel;
	private JPanel CategoriePanel;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTable serveurTable;
	private JPanel Serveurs;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTable tablesTable;
	private JPanel Tables;
	private Connection con;
	private Statement stm;
	private ResultSet rs;
	private Plats plat;
	private PlatService platService;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		frame.setBounds(100, 100, 1178, 757);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel AdminLoginPanel = new JPanel();
		frame.getContentPane().add(AdminLoginPanel, "name_522084129790700");
		AdminLoginPanel.setLayout(new BoxLayout(AdminLoginPanel, BoxLayout.X_AXIS));
		
		JPanel Left = 	new JPanel();
		AdminLoginPanel.add(Left);
		Left.setBackground(new Color(235,77,75));
		Left.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("icons/manager.png"));
		lblNewLabel_2.setBounds(120, 121, 241, 248);
		Left.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(62, 472, 359, 2);
		Left.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(130, 538, 235, 2);
		Left.add(separator_1);
		
		JLabel lblNewLabel_3 = new JLabel("Espace Admin");
		lblNewLabel_3.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 30));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(140, 420, 192, 39);
		Left.add(lblNewLabel_3);
		
		JPanel right = new JPanel();
		AdminLoginPanel.add(right);
		right.setForeground(Color.WHITE);
		right.setBackground(Color.WHITE);
		right.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom d'utilisateur :");
		lblNewLabel.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblNewLabel.setBounds(38, 258, 195, 23);
		right.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblMotDePasse.setBounds(38, 430, 158, 26);
		right.add(lblMotDePasse);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textField.setForeground(Color.DARK_GRAY);
		textField.setBackground(Color.WHITE);
		textField.setBounds(38, 294, 287, 45);
		right.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Connectez-vous");
		lblNewLabel_1.setFont(new Font("Poor Richard", Font.BOLD, 44));
		lblNewLabel_1.setBounds(38, 93, 322, 82);
		right.add(lblNewLabel_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(41, 352, 277, 2);
		right.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(41, 524, 277, 2);
		right.add(separator_3);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		passwordField.setBounds(38, 469, 287, 45);
		right.add(passwordField);
		
		JButton btnNewButton = new JButton("Se Connecter");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnNewButton.setBackground(new Color(255, 107, 129));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(235, 77, 75));
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
				    rs=stm.executeQuery("select * from login where username = '"+textField.getText()+"' and password = '"+new String(passwordField.getPassword())+"'");
				    if(rs.next()) {
				    	textField.setText("");
				    	passwordField.setText("");
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
		btnNewButton.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(235,77,75));
		btnNewButton.setBounds(41, 566, 284, 52);
		right.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Mot de passe oubli\u00E9 ?");
		lblNewLabel_4.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblNewLabel_4.setForeground(new Color(27, 156, 252));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_4.setForeground(SystemColor.textHighlight);
			}
		});
		lblNewLabel_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_4.setBounds(41, 631, 151, 16);
		right.add(lblNewLabel_4);
		
		home = new JPanel();
		frame.getContentPane().add(home, "name_522162720554900");
		home.setLayout(new BoxLayout(home, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(243, 156, 18));
		home.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("icons/chef.png"));
		lblNewLabel_5.setBounds(159, 184, 184, 156);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Le Restaurant Marocain");
		lblNewLabel_6.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 37));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(61, 353, 385, 57);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tout Les Plats Marocains Chez Nous");
		lblNewLabel_7.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBackground(Color.WHITE);
		lblNewLabel_7.setBounds(115, 407, 344, 32);
		panel_1.add(lblNewLabel_7);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.WHITE);
		separator_4.setBounds(62, 472, 359, 2);
		panel_1.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(Color.WHITE);
		separator_5.setBounds(130, 538, 235, 2);
		panel_1.add(separator_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		home.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("      Plats");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2.setBackground(new Color(249, 202, 36));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setBackground(new Color(243, 156, 18));
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.setVisible(false);
				Plats.setVisible(true);
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setIcon(new ImageIcon("icons/dish.png"));
		btnNewButton_2.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(243, 156, 18));
		btnNewButton_2.setBounds(134, 209, 195, 53);
		panel_2.add(btnNewButton_2);
		
		JButton btnServeur = new JButton("     Serveurs");
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
		panel_2.add(btnServeur);
		
		JButton btnTables = new JButton("     Tables");
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
		panel_2.add(btnTables);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.setVisible(false);
				AdminLoginPanel.setVisible(true);
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnNewButton_1.setBackground(new Color(241, 242, 246));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(Color.WHITE);
			}
		});
		btnNewButton_1.setBounds(491, 637, 77, 60);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon("icons/logout (1).png"));
		
		Plats = new JPanel();
		Plats.setBackground(Color.WHITE);
		frame.getContentPane().add(Plats, "name_535374106093800");
		Plats.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(249, 202, 36));
		panel_3.setBounds(0, 0, 247, 710);
		Plats.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("     Plats");
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnNewButton_3.setBackground(new Color(246, 229, 141));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_3.setBackground(new Color(249, 202, 36));
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CategoriePanel.setVisible(false);
				platsPanel.setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("icons/dish (1).png"));
		btnNewButton_3.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		btnNewButton_3.setBackground(new Color(249, 202, 36));
		btnNewButton_3.setBounds(24, 190, 200, 57);
		panel_3.add(btnNewButton_3);
		
		JButton btnCategorie = new JButton("     Categories");
		btnCategorie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCategorie.setBackground(new Color(246, 229, 141));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCategorie.setBackground(new Color(249, 202, 36));
			}
		});
		btnCategorie.setFocusPainted(false);
		btnCategorie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				platsPanel.setVisible(false);
				CategoriePanel.setVisible(true);
			}
		});
		btnCategorie.setIcon(new ImageIcon("icons/salad.png"));
		btnCategorie.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		btnCategorie.setHorizontalAlignment(SwingConstants.LEFT);
		btnCategorie.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		btnCategorie.setBackground(new Color(249, 202, 36));
		btnCategorie.setBounds(24, 331, 200, 57);
		panel_3.add(btnCategorie);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_4.setBackground(new Color(246, 229, 141));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_4.setBackground(new Color(249, 202, 36));
			}
		});
		btnNewButton_4.setFocusPainted(false);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Plats.setVisible(false);
				home.setVisible(true);
			}
		});
		btnNewButton_4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		btnNewButton_4.setBackground(new Color(249, 202, 36));
		btnNewButton_4.setIcon(new ImageIcon("icons/left-arrow.png"));
		btnNewButton_4.setBounds(0, 13, 87, 39);
		panel_3.add(btnNewButton_4);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBackground(Color.BLACK);
		separator_6.setForeground(Color.BLACK);
		separator_6.setBounds(24, 260, 200, 2);
		panel_3.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(Color.BLACK);
		separator_7.setBackground(Color.BLACK);
		separator_7.setBounds(24, 401, 200, 2);
		panel_3.add(separator_7);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(246, 0, 914, 710);
		Plats.add(panel_4);
		panel_4.setLayout(new CardLayout(0, 0));
		
		platsPanel = new JPanel();
		platsPanel.setBackground(Color.WHITE);
		panel_4.add(platsPanel, "name_607913026316200");
		platsPanel.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(235, 77, 75));
		panel_5.setBounds(0, 0, 914, 132);
		platsPanel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Plats");
		lblNewLabel_8.setIcon(new ImageIcon("icons/serving-dish.png"));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBackground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Tempus Sans ITC", Font.BOLD, 50));
		lblNewLabel_8.setBounds(350, 35, 261, 84);
		panel_5.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Code");
		lblNewLabel_9.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(59, 260, 95, 39);
		platsPanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Nom");
		lblNewLabel_10.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(59, 323, 86, 26);
		platsPanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Prix (Dhs)");
		lblNewLabel_11.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(59, 386, 106, 33);
		platsPanel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Categorie");
		lblNewLabel_12.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblNewLabel_12.setBounds(59, 449, 95, 33);
		platsPanel.add(lblNewLabel_12);
		
		JButton btnNewButton_5 = new JButton("Ajouter");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					rs = stm.executeQuery("select * from Plate where CodePlat = "+Integer.parseInt(textField_1.getText()));
					if(rs.next()) {
						JOptionPane.showMessageDialog(frame,"Plat existe d�ja");
					}else {						
						stm.executeUpdate("insert into Plate values ("+Integer.parseInt(textField_1.getText())+",'"+textField_2.getText()+"','"+Double.parseDouble(textField_3.getText())+"','"+textField_4.getText()+"')");
				    	JOptionPane.showMessageDialog(frame,"Plat Ajout�");
				    	textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
				    	con.close();
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		btnNewButton_5.setBackground(new Color(255, 71, 87));
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBounds(386, 503, 117, 35);
		platsPanel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Modifier");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					stm.executeUpdate("update Plate set NomPlate = '"+textField_2.getText()+"',PrixPlate="+Double.parseDouble(textField_3.getText())+",CodeCat='"+textField_4.getText()+"' where CodePlat="+Integer.parseInt(textField_1.getText()));
					JOptionPane.showMessageDialog(frame,"Le Plat avec le code "+textField_1.getText()+" a �t� modifi�");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		btnNewButton_6.setBackground(new Color(255, 71, 87));
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBounds(515, 503, 117, 35);
		platsPanel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Supprimer");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					if(textField_1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame,"Veuillez entrer le code du plat a supprim�");
					}else {
					    int response = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce plat ?", "Confirmer",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					    if (response == JOptionPane.YES_OPTION) {
					    	rs = stm.executeQuery("select * from Plate where CodePlat = '"+textField_1.getText()+"'");
					    	if(rs.next()) {
					    		stm.executeUpdate("delete from Plate where CodePlat = '"+textField_1.getText()+"'");
					    		JOptionPane.showMessageDialog(frame,"Plat Supprim�");
					    		textField_1.setText("");
					    		textField_2.setText("");
					    		textField_3.setText("");
					    		textField_4.setText("");
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
		btnNewButton_7.setBackground(new Color(255, 71, 87));
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.setBounds(644, 503, 117, 35);
		platsPanel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Afficher");
		btnNewButton_8.addActionListener(new ActionListener() {
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
		btnNewButton_8.setBackground(new Color(255, 71, 87));
		btnNewButton_8.setForeground(Color.WHITE);
		btnNewButton_8.setBounds(773, 503, 117, 35);
		platsPanel.add(btnNewButton_8);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(new Color(235, 77, 75));
		textField_1.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_1.setBounds(165, 260, 171, 32);
		platsPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(new Color(235, 77, 75));
		textField_2.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_2.setColumns(10);
		textField_2.setBounds(165, 323, 171, 32);
		platsPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(new Color(235, 77, 75));
		textField_3.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_3.setColumns(10);
		textField_3.setBounds(165, 386, 171, 32);
		platsPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(new Color(235, 77, 75));
		textField_4.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_4.setColumns(10);
		textField_4.setBounds(166, 449, 171, 32);
		platsPanel.add(textField_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(386, 260, 502, 230);
		platsPanel.add(scrollPane);
		
		PlatsTables = new JTable();
		PlatsTables.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Code", "Nom", "Prix", "Categorie"
			}
		));
		scrollPane.setViewportView(PlatsTables);
		
		JButton btnNewButton_11 = new JButton("");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_1.getText().isEmpty()) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
				    rs = stm.executeQuery("select * from Plate where CodePlat = "+Integer.parseInt(textField_1.getText()));
				    if(rs.next()) {
						textField_1.setText(rs.getString(1));
						textField_2.setText(rs.getString(2));
						textField_3.setText(rs.getString(3));
						textField_4.setText(rs.getString(4));
											
					}else {
						JOptionPane.showMessageDialog(frame,"Plat n'existe pas.");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
					}
				    	
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}}
			}
		});
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_11.setBackground(new Color(241, 242, 246));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_11.setBackground(Color.WHITE);
			}
		});
		btnNewButton_11.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		btnNewButton_11.setFocusPainted(false);

		btnNewButton_11.setIcon(new ImageIcon("icons/magnifier.png"));
		btnNewButton_11.setBackground(Color.WHITE);
		btnNewButton_11.setBounds(335, 260, 39, 32);
		platsPanel.add(btnNewButton_11);
		
		CategoriePanel = new JPanel();
		CategoriePanel.setBackground(Color.WHITE);
		panel_4.add(CategoriePanel, "name_607915146906800");
		CategoriePanel.setLayout(null);
		
		JLabel label = new JLabel("Code");
		label.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		label.setBounds(59, 260, 95, 39);
		CategoriePanel.add(label);
		
		JLabel lblLibelle = new JLabel("Libelle");
		lblLibelle.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblLibelle.setBounds(59, 323, 95, 39);
		CategoriePanel.add(lblLibelle);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(235, 77, 75));
		panel_6.setBounds(0, 0, 914, 132);
		CategoriePanel.add(panel_6);
		
		JLabel lblCategories = new JLabel("  Categories");
		lblCategories.setIcon(new ImageIcon("icons/cutlery.png"));
		lblCategories.setForeground(Color.WHITE);
		lblCategories.setFont(new Font("Tempus Sans ITC", Font.BOLD, 50));
		lblCategories.setBackground(Color.WHITE);
		lblCategories.setBounds(288, 35, 389, 84);
		panel_6.add(lblCategories);
		
		textField_5 = new JTextField();
		textField_5.setForeground(new Color(235, 77, 75));
		textField_5.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_5.setColumns(10);
		textField_5.setBounds(161, 260, 171, 32);
		CategoriePanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setForeground(new Color(235, 77, 75));
		textField_6.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_6.setColumns(10);
		textField_6.setBounds(161, 323, 171, 32);
		CategoriePanel.add(textField_6);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(386, 260, 502, 230);
		CategoriePanel.add(scrollPane_1);
		
		categorieTable = new JTable();
		categorieTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Libelle", "Code"
			}
		));
		scrollPane_1.setViewportView(categorieTable);
		
		JButton button = new JButton("Ajouter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
				    stm.executeUpdate("insert into Categorie values ('"+textField_5.getText()+"','"+textField_6.getText()+"')");
				    JOptionPane.showMessageDialog(frame,"Categorie Ajout�");
				    textField_5.setText("");
					textField_6.setText("");
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(255, 71, 87));
		button.setBounds(386, 503, 117, 35);
		CategoriePanel.add(button);
		
		JButton button_1 = new JButton("Modifier");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					stm.executeUpdate("update Categorie set LibelleCat = '"+textField_6.getText()+"' where CodeCat='"+textField_5.getText()+"'");
					JOptionPane.showMessageDialog(frame,"La Categorie avec le code "+textField_5.getText()+" a �t� modifi�e");
					textField_5.setText("");
					textField_6.setText("");
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(255, 71, 87));
		button_1.setBounds(513, 503, 117, 35);
		CategoriePanel.add(button_1);
		
		JButton button_2 = new JButton("Supprimer");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					if(textField_5.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame,"Veuillez entrer le code du Categorie a supprim�e");
					}else {
					    int response = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette categorie ?", "Confirmer",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					    if (response == JOptionPane.YES_OPTION) {
						rs = stm.executeQuery("select * from Categorie where CodeCat = '"+textField_5.getText()+"'");
						if(rs.next()) {
							stm.executeUpdate("delete from Categorie where CodeCat = '"+textField_5.getText()+"'");
							JOptionPane.showMessageDialog(frame,"Categorie Supprim�");
							textField_5.setText("");
							textField_6.setText("");
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
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(255, 71, 87));
		button_2.setBounds(642, 503, 117, 35);
		CategoriePanel.add(button_2);
		
		JButton button_3 = new JButton("Afficher");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
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
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(new Color(255, 71, 87));
		button_3.setBounds(771, 503, 117, 35);
		CategoriePanel.add(button_3);
		
		JButton btnNewButton_12 = new JButton("");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_5.getText().isEmpty()) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
				    rs = stm.executeQuery("select * from Categorie where CodeCat = '"+textField_5.getText()+"'");
				    if(rs.next()) {
						textField_5.setText(rs.getString(1));
						textField_6.setText(rs.getString(2));
					}else {
						JOptionPane.showMessageDialog(frame,"Categorie n'existe pas.");
						textField_5.setText("");
						textField_6.setText("");
					}
				    	
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}}
			}
		});
		btnNewButton_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_12.setBackground(new Color(241, 242, 246));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_12.setBackground(Color.WHITE);
			}
		});
		btnNewButton_12.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		btnNewButton_12.setFocusPainted(false);

		btnNewButton_12.setIcon(new ImageIcon("icons/magnifier.png"));
		btnNewButton_12.setBackground(Color.WHITE);
		btnNewButton_12.setBounds(335, 260, 39, 32);
		CategoriePanel.add(btnNewButton_12);
		
		Serveurs = new JPanel();
		Serveurs.setBackground(Color.WHITE);
		frame.getContentPane().add(Serveurs, "name_618400822586100");
		Serveurs.setLayout(null);
		
		JLabel lblNumero = new JLabel("ID");
		lblNumero.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblNumero.setBounds(127, 241, 95, 39);
		Serveurs.add(lblNumero);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_7.setForeground(new Color(235, 77, 75));
		textField_7.setColumns(10);
		textField_7.setBounds(282, 246, 171, 32);
		Serveurs.add(textField_7);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblNom.setBounds(127, 304, 95, 39);
		Serveurs.add(lblNom);
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_8.setForeground(new Color(235, 77, 75));
		textField_8.setColumns(10);
		textField_8.setBounds(282, 309, 171, 32);
		Serveurs.add(textField_8);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblPrenom.setBounds(127, 367, 95, 39);
		Serveurs.add(lblPrenom);
		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_9.setForeground(new Color(235, 77, 75));
		textField_9.setColumns(10);
		textField_9.setBounds(282, 372, 171, 32);
		Serveurs.add(textField_9);
		
		JLabel lblLogin = new JLabel("Username");
		lblLogin.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblLogin.setBounds(127, 430, 95, 39);
		Serveurs.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblPassword.setBounds(127, 493, 95, 39);
		Serveurs.add(lblPassword);
		
		JLabel lblActif = new JLabel("Actif");
		lblActif.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblActif.setBounds(127, 556, 95, 39);
		Serveurs.add(lblActif);
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_10.setForeground(new Color(235, 77, 75));
		textField_10.setColumns(10);
		textField_10.setBounds(282, 435, 171, 32);
		Serveurs.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_11.setForeground(new Color(235, 77, 75));
		textField_11.setColumns(10);
		textField_11.setBounds(282, 498, 171, 32);
		Serveurs.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_12.setForeground(new Color(235, 77, 75));
		textField_12.setColumns(10);
		textField_12.setBounds(282, 561, 171, 32);
		Serveurs.add(textField_12);
		
		JLabel lblNbrReservation = new JLabel("Nbr Reservation");
		lblNbrReservation.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblNbrReservation.setBounds(127, 619, 156, 39);
		Serveurs.add(lblNbrReservation);
		
		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_13.setForeground(new Color(235, 77, 75));
		textField_13.setColumns(10);
		textField_13.setBounds(282, 624, 171, 32);
		Serveurs.add(textField_13);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(235, 77, 75));
		panel.setBounds(0, 0, 1160, 194);
		Serveurs.add(panel);
		panel.setLayout(null);
		
		JLabel lblServeurs = new JLabel(" Serveurs");
		lblServeurs.setIcon(new ImageIcon("icons/waiter64.png"));
		lblServeurs.setBounds(444, 67, 302, 66);
		lblServeurs.setForeground(Color.WHITE);
		lblServeurs.setFont(new Font("Tempus Sans ITC", Font.BOLD, 50));
		lblServeurs.setBackground(Color.WHITE);
		panel.add(lblServeurs);
		
		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_9.setBackground(new Color(235, 77, 75));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_9.setBackground(new Color(255, 121, 121));
			}
		});
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Serveurs.setVisible(false);
				home.setVisible(true);
			}
		});
		btnNewButton_9.setBackground(new Color(235, 77, 75));
		btnNewButton_9.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		btnNewButton_9.setIcon(new ImageIcon("icons/left-arrow-yellow.png"));
		btnNewButton_9.setBounds(0, 13, 87, 39);
		panel.add(btnNewButton_9);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(545, 246, 603, 340);
		Serveurs.add(scrollPane_2);
		
		serveurTable = new JTable();
		serveurTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero", "Nom", "Prenom", "Username", "Password", "Actif", "NbrRes"
			}
		));
		scrollPane_2.setViewportView(serveurTable);
		
		JButton button_4 = new JButton("Ajouter");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					rs = stm.executeQuery("select * from Serveur where IDSer = "+Integer.parseInt(textField_7.getText()));
					if(rs.next()) {
						JOptionPane.showMessageDialog(frame,"Serveur avec cet ID existe dja");
					}else {
						stm.executeUpdate("insert into Serveur values ("+Integer.parseInt(textField_7.getText())+",'"+textField_8.getText()+"','"+textField_9.getText()+"','"+textField_10.getText()+"','"+textField_11.getText()+"','"+textField_12.getText()+"','"+Integer.parseInt(textField_13.getText())+"')");
						JOptionPane.showMessageDialog(frame,"Serveur Ajout�");
						textField_7.setText("");
						textField_8.setText("");
						textField_9.setText("");
						textField_10.setText("");
						textField_11.setText("");
						textField_12.setText("");
						textField_13.setText("");
						con.close();
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		button_4.setForeground(Color.WHITE);
		button_4.setBackground(new Color(255, 71, 87));
		button_4.setBounds(545, 599, 140, 35);
		Serveurs.add(button_4);
		
		JButton button_5 = new JButton("Modifier");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					stm.executeUpdate("update Serveur set NomSer='"+textField_8.getText()+"',PreNomSer='"+textField_9.getText()+"',login='"+textField_10.getText()+"',password='"+textField_11.getText()+"',actif='"+textField_12.getText()+"',NbrRes="+Integer.parseInt(textField_13.getText())+" where IDSer="+Integer.parseInt(textField_7.getText()));
					JOptionPane.showMessageDialog(frame,"Le Serveur avec le numero "+textField_7.getText()+" a �t� modifi�");
					textField_7.setText("");
					textField_8.setText("");
					textField_9.setText("");
					textField_10.setText("");
					textField_11.setText("");
					textField_12.setText("");
					textField_13.setText("");
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		button_5.setForeground(Color.WHITE);
		button_5.setBackground(new Color(255, 71, 87));
		button_5.setBounds(695, 599, 140, 35);
		Serveurs.add(button_5);
		
		JButton button_6 = new JButton("Supprimer");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					if(textField_7.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame,"Veuillez entrer le numero du serveur a supprim�");
					}else {
						int response = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce serveur ?", "Confirmer",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					    if (response == JOptionPane.YES_OPTION) {
						rs = stm.executeQuery("select * from Serveur where IDSer = "+Integer.parseInt(textField_7.getText()));
						if(rs.next()) {
							stm.executeUpdate("delete from Serveur where IDSer = "+Integer.parseInt(textField_7.getText()));
							JOptionPane.showMessageDialog(frame,"Serveur Supprim�");
							textField_7.setText("");
							textField_8.setText("");
							textField_9.setText("");
							textField_10.setText("");
							textField_11.setText("");
							textField_12.setText("");
							textField_13.setText("");
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
		button_6.setForeground(Color.WHITE);
		button_6.setBackground(new Color(255, 71, 87));
		button_6.setBounds(847, 599, 140, 35);
		Serveurs.add(button_6);
		
		JButton button_7 = new JButton("Afficher");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
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
		button_7.setForeground(Color.WHITE);
		button_7.setBackground(new Color(255, 71, 87));
		button_7.setBounds(999, 599, 140, 35);
		Serveurs.add(button_7);
		
		JButton btnNewButton_13 = new JButton("");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_7.getText().isEmpty()) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
				    rs = stm.executeQuery("select * from Serveur where IDSer = "+Integer.parseInt(textField_7.getText()));
				    if(rs.next()) {
						textField_7.setText(rs.getString(1));
						textField_8.setText(rs.getString(2));
						textField_9.setText(rs.getString(3));
						textField_10.setText(rs.getString(4));
						textField_11.setText(rs.getString(5));
						textField_12.setText(rs.getString(6));
						textField_13.setText(rs.getString(7));										
					}else {
						JOptionPane.showMessageDialog(frame,"Serveur avec cet ID n'existe pas.");
						textField_7.setText("");
						textField_8.setText("");
						textField_9.setText("");
						textField_10.setText("");
						textField_11.setText("");
						textField_12.setText("");
						textField_13.setText("");
					}				    	
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}}
			}
		});
		btnNewButton_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_13.setBackground(new Color(241, 242, 246));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_13.setBackground(Color.WHITE);
			}
		});
		btnNewButton_13.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		btnNewButton_13.setFocusPainted(false);
		btnNewButton_13.setIcon(new ImageIcon("icons/magnifier.png"));
		btnNewButton_13.setBackground(Color.WHITE);
		btnNewButton_13.setBounds(453, 246, 39, 32);
		Serveurs.add(btnNewButton_13);
		
		Tables = new JPanel();
		Tables.setBackground(Color.WHITE);
		frame.getContentPane().add(Tables, "name_625568824359500");
		Tables.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(235, 77, 75));
		panel_8.setBounds(0, 0, 1160, 164);
		Tables.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblTables = new JLabel("  Tables");
		lblTables.setIcon(new ImageIcon("icons/table.png"));
		lblTables.setForeground(Color.WHITE);
		lblTables.setFont(new Font("Tempus Sans ITC", Font.BOLD, 50));
		lblTables.setBackground(Color.WHITE);
		lblTables.setBounds(418, 55, 302, 66);
		panel_8.add(lblTables);
		
		JButton btnNewButton_10 = new JButton("");
		btnNewButton_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_10.setBackground(new Color(255, 121, 121));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_10.setBackground(new Color(235, 77, 75));
			}
		});
		btnNewButton_10.setFocusPainted(false);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tables.setVisible(false);
				home.setVisible(true);
			}
		});
		btnNewButton_10.setIcon(new ImageIcon("icons/left-arrow-yellow.png"));
		btnNewButton_10.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		btnNewButton_10.setBackground(new Color(235, 77, 75));
		btnNewButton_10.setBounds(0, 13, 87, 39);
		panel_8.add(btnNewButton_10);
		
		JLabel label_1 = new JLabel("Num\u00E9ro");
		label_1.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		label_1.setBounds(127, 303, 95, 39);
		Tables.add(label_1);
		
		JLabel lblCapacit = new JLabel("Nbr de Place");
		lblCapacit.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblCapacit.setBounds(127, 382, 139, 39);
		Tables.add(lblCapacit);
		
		textField_14 = new JTextField();
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setForeground(new Color(235, 77, 75));
		textField_14.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_14.setColumns(10);
		textField_14.setBounds(284, 303, 171, 32);
		Tables.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setForeground(new Color(235, 77, 75));
		textField_15.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_15.setColumns(10);
		textField_15.setBounds(284, 382, 171, 32);
		Tables.add(textField_15);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(594, 271, 537, 164);
		Tables.add(scrollPane_3);
		
		tablesTable = new JTable();
		tablesTable.setBackground(Color.WHITE);
		tablesTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Num\u00E9ro", "Nbr de Place"
			}
		));
		scrollPane_3.setViewportView(tablesTable);
		
		JButton button_8 = new JButton("Ajouter");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					rs = stm.executeQuery("select * from Tables where NumTable = "+Integer.parseInt(textField_14.getText()));
					if(rs.next()) {
						JOptionPane.showMessageDialog(frame,"Table avec ce Numero existe d�ja");
					}else {				
						stm.executeUpdate("insert into Tables values ("+Integer.parseInt(textField_14.getText())+","+Integer.parseInt(textField_15.getText())+")");
						JOptionPane.showMessageDialog(frame,"Table Ajout�");
						textField_14.setText("");
						textField_15.setText("");
						con.close();
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		button_8.setForeground(Color.WHITE);
		button_8.setBackground(new Color(255, 71, 87));
		button_8.setBounds(594, 448, 124, 35);
		Tables.add(button_8);
		
		JButton button_9 = new JButton("Modifier");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					stm.executeUpdate("update Tables set NbrPlaceTable = "+Integer.parseInt(textField_15.getText())+" where NumTable="+Integer.parseInt(textField_14.getText()));
					JOptionPane.showMessageDialog(frame,"La Tables avec le code "+textField_14.getText()+" a �t� modifi�e");
					textField_14.setText("");
					textField_15.setText("");
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}
			}
		});
		button_9.setForeground(Color.WHITE);
		button_9.setBackground(new Color(255, 71, 87));
		button_9.setBounds(735, 448, 124, 35);
		Tables.add(button_9);
		
		JButton button_10 = new JButton("Supprimer");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
					if(textField_14.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame,"Veuillez entrer le numero du Table a supprim�e");
					}else {
						int response = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette table ?", "Confirmer",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					    if (response == JOptionPane.YES_OPTION) {
						rs = stm.executeQuery("select * from Tables where NumTable = "+Integer.parseInt(textField_14.getText()));
						if(rs.next()) {
							stm.executeUpdate("delete from Tables where NumTable = "+Integer.parseInt(textField_14.getText()));
							JOptionPane.showMessageDialog(frame,"Table Supprim�");
							textField_14.setText("");
							textField_15.setText("");
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
		button_10.setForeground(Color.WHITE);
		button_10.setBackground(new Color(255, 71, 87));
		button_10.setBounds(871, 448, 124, 35);
		Tables.add(button_10);
		
		JButton button_11 = new JButton("Afficher");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
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
		button_11.setForeground(Color.WHITE);
		button_11.setBackground(new Color(255, 71, 87));
		button_11.setBounds(1007, 448, 124, 35);
		Tables.add(button_11);
		
		JButton btnNewButton_14 = new JButton("");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_14.getText().isEmpty()) {
				try {
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
					stm=con.createStatement();
				    rs = stm.executeQuery("select * from Tables where NumTable = "+Integer.parseInt(textField_14.getText()));
				    if(rs.next()) {
						textField_14.setText(rs.getString(1));
						textField_15.setText(rs.getString(2));										
					}else {
						JOptionPane.showMessageDialog(frame,"Table avec ce numero n'existe pas.");
						textField_14.setText("");
						textField_15.setText("");	
					}
				    	
				    con.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(frame,ex);
				}}
			}
		});
		btnNewButton_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_14.setBackground(new Color(241, 242, 246));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_14.setBackground(Color.WHITE);
			}
		});
		btnNewButton_14.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		btnNewButton_14.setFocusPainted(false);
		
		btnNewButton_14.setIcon(new ImageIcon("icons/magnifier.png"));
		btnNewButton_14.setBackground(Color.WHITE);
		btnNewButton_14.setBounds(458, 303, 39, 32);
		Tables.add(btnNewButton_14);
	}
}