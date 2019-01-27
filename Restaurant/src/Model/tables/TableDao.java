package Model.tables;

import java.util.ArrayList;


public interface TableDao {

		public void ajouterTable(Table table);
	    public Table getTableByNum(int numTable);
	    public ArrayList<Table> getAllTables();
	    public void updateTable(Table table);
	    public void deleteTable(int numTable);
	
}

