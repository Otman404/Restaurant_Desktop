package Model.tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import View.EspaceAdmin;

public class TableDoImp implements TableDao{

	private Connection con;
	private ResultSet rs;
	private Statement stm;
	private JFrame frame;
	private EspaceAdmin espAdmn;
	
	public TableDoImp(EspaceAdmin espAdmn) {
		this.espAdmn = espAdmn;
	}
	
	@Override
	public Table getTableByNum(int numTable) {
		
		return null;
	}

	@Override
	public ArrayList<Table> getAllTables() {
		
		return null;
	}

	@Override
	public void ajouterTable(Table table) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
			stm=con.createStatement();
			rs = stm.executeQuery("select * from Tables where NumTable = "+table.getNumTable());
			if(rs.next()) {
				JOptionPane.showMessageDialog(frame,"Table avec ce Numero existe d�ja");
			}else {				
				stm.executeUpdate("insert into Tables values ("+table.getNumTable()+","+table.getCapacite()+")");
				JOptionPane.showMessageDialog(frame,"Table Ajout�");
				espAdmn.clearTableTxtFields();
				con.close();
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(frame,ex);
		}	
	}
	@Override
	public void updateTable(Table table) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
			stm=con.createStatement();
			rs = stm.executeQuery("select * from Tables where NumTable = "+table.getNumTable());
			if(!rs.next()) {
				JOptionPane.showMessageDialog(frame,"Table avec ce numero n'existe pas");
			}else {
				stm.executeUpdate("update Tables set NbrPlaceTable = "+table.getCapacite()+" where NumTable="+table.getNumTable());
				JOptionPane.showMessageDialog(frame,"La Tables avec le code "+table.getNumTable()+" a �t� modifi�e");
				espAdmn.clearTableTxtFields();
				con.close();
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(frame,ex);
		}
	}

	@Override
	public void deleteTable(int numTable) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Restaurant","root","mysql");
			stm=con.createStatement();
				rs = stm.executeQuery("select * from Tables where NumTable = "+numTable);
				if(!rs.next()) {
					JOptionPane.showMessageDialog(frame,"Table avec ce numero n'existe pas.");
				}else {
					int response = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette table ?", "Confirmer",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(response == JOptionPane.YES_OPTION) {
						stm.executeUpdate("delete from Tables where NumTable = "+numTable);
						JOptionPane.showMessageDialog(frame,"Table Supprim�");
						espAdmn.clearTableTxtFields();
					}
				}
		    con.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(frame,ex);
		}
		
	}

}
