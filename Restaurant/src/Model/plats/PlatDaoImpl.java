package Model.plats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import View.EspaceAdmin;

public class PlatDaoImpl implements PlatsDao{

	private Connection con;
	private ResultSet rs;
	private Statement stm;
	private JFrame frame;
	private EspaceAdmin espAdmn;
	public PlatDaoImpl(EspaceAdmin espAdmn) {
		this.espAdmn = espAdmn;
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
	public void ajouterPlat(Plats plat) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
			stm=con.createStatement();
			rs = stm.executeQuery("select * from Plate where CodePlat = "+plat.getCode());
			if(rs.next()) {
				JOptionPane.showMessageDialog(frame,"Plat existe d�ja");
			}else {						
				stm.executeUpdate("insert into Plate values ("+plat.getCode()+",'"+plat.getNom()+"',"+plat.getPrix()+",'"+plat.getCategorie()+"')");
				JOptionPane.showMessageDialog(frame,"Plat Ajout�");
				espAdmn.clearPlatTxtFields();
				con.close();
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(frame,ex);
		}
		
	}
	
	@Override
	public void updatePlat(Plats plat) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
			stm=con.createStatement();
			stm.executeUpdate("update Plate set NomPlate = '"+plat.getNom()+"',PrixPlate="+plat.getPrix()+",CodeCat='"+plat.getCategorie()+"' where CodePlat="+plat.getCode());
			JOptionPane.showMessageDialog(frame,"Le Plat avec le code "+plat.getCode()+" a �t� modifi�");
			espAdmn.clearPlatTxtFields();
		    con.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(frame,ex);
		}				
	}

	@Override
	public void deletePlat(int codePlat) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
			stm=con.createStatement();
			    	rs = stm.executeQuery("select * from Plate where CodePlat = '"+codePlat+"'");
			    	if(!rs.next()) {
			    		JOptionPane.showMessageDialog(frame,"Plat n'existe pas.");
				}else {
				    int response = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce plat ?", "Confirmer",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (response == JOptionPane.YES_OPTION) {
			    		stm.executeUpdate("delete from Plate where CodePlat = '"+codePlat+"'");
			    		JOptionPane.showMessageDialog(frame,"Plat Supprim�");
			    		espAdmn.clearPlatTxtFields();
			    		}
				}
		    con.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(frame,ex);
		}
		
	}
	
	
}
