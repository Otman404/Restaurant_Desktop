package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import View.EspaceAdmin;

public class ProductDaoImpl implements PlatsDao{

	private Connection con;
	private ResultSet rs;
	private Statement stm;
	private EspaceAdmin espAdmn;
	
	public ProductDaoImpl() {
		
	}

	@Override
	public void ajouterPlat(Plats plat) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
			stm=con.createStatement();
			rs = stm.executeQuery("select * from Plate where CodePlat = "+plat.getCode());
			if(rs.next()) {
				JOptionPane.showMessageDialog(espAdmn.getFrame(),"Plat existe d�ja");
			}else {						
				stm.executeUpdate("insert into Plate values ("+plat.getCode()+",'"+plat.getNom()+"','"+plat.getPrix()+"','"+plat.getCategorie()+"')");
		    	JOptionPane.showMessageDialog(espAdmn.getFrame(),"Plat Ajout�");
		    	espAdmn.getCodePlat_tf().setText("");
		    	espAdmn.getNomPlat_tf().setText("");
				espAdmn.getPrixPlat_tf().setText("");
				espAdmn.getCategPlat_tf().setText("");
		    	con.close();
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(espAdmn.getFrame(),ex);
		}
		
	}

	@Override
	public Plats getPlatByCode(int codePlat) {
		
		return null;
	}

	@Override
	public ArrayList<Plats> getAllPlats() {
		
		return null;
	}

	@Override
	public void updatePlat(Plats plat) {
		
		
	}

	@Override
	public void deletePlat(int codePlat) {
		
		
	}
	
	
}
