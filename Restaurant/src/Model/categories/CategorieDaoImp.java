package Model.categories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import View.EspaceAdmin;

public class CategorieDaoImp implements CategorieDao{

	private Connection con;
	private ResultSet rs;
	private Statement stm;
	private JFrame frame;
	private EspaceAdmin espAdmn;
	public CategorieDaoImp(EspaceAdmin espAdmn) {
		this.espAdmn = espAdmn;
	}
	
	

	@Override
	public Categorie getCategByCode(String codeCateg) {
		
		return null;
	}

	@Override
	public ArrayList<Categorie> getAllCategs() {
		
		return null;
	}
	@Override
	public void ajouterCateg(Categorie categ) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
			stm=con.createStatement();
			rs = stm.executeQuery("select * from Categorie where CodeCat = '"+categ.getCodeCateg()+"'");
			if(rs.next()) {
				JOptionPane.showMessageDialog(frame,"Categorie existe déja");
			}else {	
				stm.executeUpdate("insert into Categorie values ('"+categ.getCodeCateg()+"','"+categ.getLibelle()+"')");
				JOptionPane.showMessageDialog(frame,"Categorie Ajouté");
				espAdmn.clearCategTxtFields();
				con.close();
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(frame,ex);
		}	
		
	}

	@Override
	public void updateCateg(Categorie categ) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
			stm=con.createStatement();
			stm.executeUpdate("update Categorie set LibelleCat = '"+categ.getLibelle()+"' where CodeCat='"+categ.getCodeCateg()+"'");
			JOptionPane.showMessageDialog(frame,"La Categorie avec le code "+categ.getCodeCateg()+" a été modifiée");
			espAdmn.clearCategTxtFields();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(frame,ex);
		}
		
	}

	@Override
	public void deleteCateg(String codeCateg) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
			stm=con.createStatement();
			
			    
				rs = stm.executeQuery("select * from Categorie where CodeCat = '"+codeCateg+"'");
				if(!rs.next()) {
					JOptionPane.showMessageDialog(frame,"Categorie n'existe pas.");
				}else {
				    int response = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette categorie ?", "Confirmer",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    if (response == JOptionPane.YES_OPTION) {
					stm.executeUpdate("delete from Categorie where CodeCat = '"+codeCateg+"'");
					JOptionPane.showMessageDialog(frame,"Categorie Supprimé");
					espAdmn.clearCategTxtFields();
				}
			    }
			
						
		    con.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(frame,ex);
		}
		
	}

}
