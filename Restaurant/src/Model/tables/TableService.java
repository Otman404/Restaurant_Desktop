package Model.tables;

import java.util.List;


public class TableService {

	private List<Table> listTable;

	
	
	
	public TableService(List<Table> listTable) {
		this.listTable = listTable;
	}

	public List<Table> getListTable() {
		return listTable;
	}

	public void setListTable(List<Table> listTable) {
		this.listTable = listTable;
	}
	
	public Table getTablebyNum(int numTable) {
		return this.listTable.get(numTable);
	}
	public void addTable(Table table) {
		this.listTable.add(table);
	}
	public void removeTable(Table table) {
		this.listTable.remove(table);
	}
	public void removeTableByNum(int numTable) {
		this.listTable.remove(numTable);
	}
	
}
