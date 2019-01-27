package Model.serveur;

public class Serveur {

	private int idSer;
	private String nomServ;
	private String prenomServ;
	private String login;
	private String password; //it's bad i know
	private String actif;
	private int nbrRes;
	
	
	
	
	public Serveur(int idSer, String nomServ, String prenomServ, String login, String password, String actif,int nbrRes) {
		this.idSer = idSer;
		this.nomServ = nomServ;
		this.prenomServ = prenomServ;
		this.login = login;
		this.password = password;
		this.actif = actif;
		this.nbrRes = nbrRes;
	}
	public int getIDSer() {
		return idSer;
	}
	public void setIDSer(int iDSer) {
		idSer = iDSer;
	}
	public String getNomServ() {
		return nomServ;
	}
	public void setNomServ(String nomServ) {
		this.nomServ = nomServ;
	}
	public String getPrenomServ() {
		return prenomServ;
	}
	public void setPrenomServ(String prenomServ) {
		this.prenomServ = prenomServ;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getActif() {
		return actif;
	}
	public void setActif(String actif) {
		this.actif = actif;
	}
	public int getNbrRes() {
		return nbrRes;
	}
	public void setNbrRes(int nbrRes) {
		nbrRes = nbrRes;
	}
	
	
	
}
