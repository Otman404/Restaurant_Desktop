package View;

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

public class AdminLogin {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel home;
	private JPanel Plats;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table_1;
	private JPanel platsPanel;
	private JPanel CategoriePanel;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTable table_2;
	JPanel Serveurs;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTable table_3;
	private JPanel Tables;
	private Connection con;
	private Statement stm;
	private ResultSet rs;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
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
	public AdminLogin() {
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
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Outhm\\Desktop\\MiniProjet_Java\\Icons\\manager.png"));
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
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Outhm\\Desktop\\MiniProjet_Java\\Icons\\chef.png"));
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
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Outhm\\Desktop\\MiniProjet_Java\\Icons\\dish.png"));
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
		btnServeur.setIcon(new ImageIcon("C:\\Users\\Outhm\\Desktop\\MiniProjet_Java\\Icons\\waiter.png"));
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
		btnTables.setIcon(new ImageIcon("C:\\Users\\Outhm\\Desktop\\MiniProjet_Java\\Icons\\dinner.png"));
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
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Outhm\\Desktop\\MiniProjet_Java\\Icons\\logout (1).png"));
		
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
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Outhm\\Desktop\\MiniProjet_Java\\Icons\\dish (1).png"));
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
		btnCategorie.setIcon(new ImageIcon("C:\\Users\\Outhm\\Desktop\\MiniProjet_Java\\Icons\\salad.png"));
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
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\Outhm\\Desktop\\MiniProjet_Java\\Icons\\left-arrow.png"));
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
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Outhm\\Desktop\\MiniProjet_Java\\Icons\\serving-dish.png"));
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
				    stm.executeUpdate("insert into Plate values ('"+textField_1.getText()+"','"+textField_2.getText()+"','"+Double.parseDouble(textField_3.getText())+"','"+textField_4.getText()+"')");
				    JOptionPane.showMessageDialog(frame,"Plat Ajout�");
				    con.close();
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
				    stm.executeUpdate("delete from Plate where CodePlat = '"+textField_1.getText()+"'");
				    JOptionPane.showMessageDialog(frame,"Plat Supprim�");
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
		btnNewButton_8.setBackground(new Color(255, 71, 87));
		btnNewButton_8.setForeground(Color.WHITE);
		btnNewButton_8.setBounds(773, 503, 117, 35);
		platsPanel.add(btnNewButton_8);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(235, 77, 75));
		textField_1.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_1.setBounds(165, 260, 171, 32);
		platsPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(235, 77, 75));
		textField_2.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_2.setColumns(10);
		textField_2.setBounds(165, 323, 171, 32);
		platsPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(235, 77, 75));
		textField_3.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_3.setColumns(10);
		textField_3.setBounds(165, 386, 171, 32);
		platsPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setForeground(new Color(235, 77, 75));
		textField_4.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_4.setColumns(10);
		textField_4.setBounds(166, 449, 171, 32);
		platsPanel.add(textField_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(386, 260, 502, 230);
		platsPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Code", "Nom", "Prix", "Categorie"
			}
		));
		scrollPane.setViewportView(table);
		
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
		lblCategories.setIcon(new ImageIcon("C:\\Users\\Outhm\\Desktop\\MiniProjet_Java\\Icons\\cutlery.png"));
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
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Libelle", "Code"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JButton button = new JButton("Ajouter");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(255, 71, 87));
		button.setBounds(386, 503, 117, 35);
		CategoriePanel.add(button);
		
		JButton button_1 = new JButton("Modifier");
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(255, 71, 87));
		button_1.setBounds(513, 503, 117, 35);
		CategoriePanel.add(button_1);
		
		JButton button_2 = new JButton("Supprimer");
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(255, 71, 87));
		button_2.setBounds(642, 503, 117, 35);
		CategoriePanel.add(button_2);
		
		JButton button_3 = new JButton("Afficher");
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(new Color(255, 71, 87));
		button_3.setBounds(771, 503, 117, 35);
		CategoriePanel.add(button_3);
		
		Serveurs = new JPanel();
		Serveurs.setBackground(Color.WHITE);
		frame.getContentPane().add(Serveurs, "name_618400822586100");
		Serveurs.setLayout(null);
		
		JLabel lblNumero = new JLabel("Num\u00E9ro");
		lblNumero.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 20));
		lblNumero.setBounds(127, 241, 95, 39);
		Serveurs.add(lblNumero);
		
		textField_7 = new JTextField();
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
		textField_10.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_10.setForeground(new Color(235, 77, 75));
		textField_10.setColumns(10);
		textField_10.setBounds(282, 435, 171, 32);
		Serveurs.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_11.setForeground(new Color(235, 77, 75));
		textField_11.setColumns(10);
		textField_11.setBounds(282, 498, 171, 32);
		Serveurs.add(textField_11);
		
		textField_12 = new JTextField();
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
		lblServeurs.setIcon(new ImageIcon("C:\\Users\\Outhm\\Desktop\\MiniProjet_Java\\Icons\\waiter64.png"));
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
		btnNewButton_9.setIcon(new ImageIcon("C:\\Users\\Outhm\\Desktop\\MiniProjet_Java\\Icons\\left-arrow-yellow.png"));
		btnNewButton_9.setBounds(0, 13, 87, 39);
		panel.add(btnNewButton_9);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(545, 246, 603, 340);
		Serveurs.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero", "Nom", "Prenom", "Username", "Password", "Actif", "NbrRes"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		JButton button_4 = new JButton("Ajouter");
		button_4.setForeground(Color.WHITE);
		button_4.setBackground(new Color(255, 71, 87));
		button_4.setBounds(545, 599, 140, 35);
		Serveurs.add(button_4);
		
		JButton button_5 = new JButton("Modifier");
		button_5.setForeground(Color.WHITE);
		button_5.setBackground(new Color(255, 71, 87));
		button_5.setBounds(695, 599, 140, 35);
		Serveurs.add(button_5);
		
		JButton button_6 = new JButton("Supprimer");
		button_6.setForeground(Color.WHITE);
		button_6.setBackground(new Color(255, 71, 87));
		button_6.setBounds(847, 599, 140, 35);
		Serveurs.add(button_6);
		
		JButton button_7 = new JButton("Afficher");
		button_7.setForeground(Color.WHITE);
		button_7.setBackground(new Color(255, 71, 87));
		button_7.setBounds(999, 599, 140, 35);
		Serveurs.add(button_7);
		
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
		lblTables.setIcon(new ImageIcon("C:\\Users\\Outhm\\Desktop\\MiniProjet_Java\\Icons\\table.png"));
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
		btnNewButton_10.setIcon(new ImageIcon("C:\\Users\\Outhm\\Desktop\\MiniProjet_Java\\Icons\\left-arrow-yellow.png"));
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
		textField_14.setForeground(new Color(235, 77, 75));
		textField_14.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_14.setColumns(10);
		textField_14.setBounds(284, 303, 171, 32);
		Tables.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setForeground(new Color(235, 77, 75));
		textField_15.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 17));
		textField_15.setColumns(10);
		textField_15.setBounds(284, 382, 171, 32);
		Tables.add(textField_15);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(594, 271, 537, 164);
		Tables.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Num\u00E9ro", "Nbr de Place"
			}
		));
		scrollPane_3.setViewportView(table_3);
		
		JButton button_8 = new JButton("Ajouter");
		button_8.setForeground(Color.WHITE);
		button_8.setBackground(new Color(255, 71, 87));
		button_8.setBounds(594, 448, 124, 35);
		Tables.add(button_8);
		
		JButton button_9 = new JButton("Modifier");
		button_9.setForeground(Color.WHITE);
		button_9.setBackground(new Color(255, 71, 87));
		button_9.setBounds(735, 448, 124, 35);
		Tables.add(button_9);
		
		JButton button_10 = new JButton("Supprimer");
		button_10.setForeground(Color.WHITE);
		button_10.setBackground(new Color(255, 71, 87));
		button_10.setBounds(871, 448, 124, 35);
		Tables.add(button_10);
		
		JButton button_11 = new JButton("Afficher");
		button_11.setForeground(Color.WHITE);
		button_11.setBackground(new Color(255, 71, 87));
		button_11.setBounds(1007, 448, 124, 35);
		Tables.add(button_11);
	}
}
