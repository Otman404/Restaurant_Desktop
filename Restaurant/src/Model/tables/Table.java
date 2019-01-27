package Model.tables;

public class Table {

	private int numTable;
	private int capacite;
	
	
	
	public Table(int numTable, int capacite) {
		this.numTable = numTable;
		this.capacite = capacite;
	}
	public int getNumTable() {
		return numTable;
	}
	public void setNumTable(int numTable) {
		this.numTable = numTable;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	
	
}
