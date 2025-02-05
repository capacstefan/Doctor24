package obiecte;

import java.util.HashMap;
/**
 * Clasa Pacient
 */
public class Pacient {
	private String nume;
	private String username;
	private String password;
	private Particularitati particularitati;
	private String istoric;
	
	/**
	 * Constructor neparametrizabil
	 */
	public Pacient() {}
	
	/**
	 * Constructor parametrizabil
	 */
	public Pacient(String username, String password, String nume, Particularitati particularitati) {
		this.nume = nume;
		this.username = username;
		this.password = password;
		this.istoric = "{}";
		this.particularitati = particularitati;
	}

	/**
	 * Getter nume
	 * @return
	 */
	public String getNume() {
		return nume;
	}
	
	/**
	 * Getter istoric
	 * @return
	 */
	public String getIstoric(){
		return istoric;
	}
	
	/**
	 * Getter sex
	 * @return
	 */
	public String getSex() {
		return particularitati.getSex();
	}
	
	/**
	 * Getter varsta
	 * @return
	 */
	public int getVarsta() {
		return particularitati.getVarsta();
	}
	
	/**
	 * Getter greutate
	 * @return
	 */
	public int getGreutate() {
		return particularitati.getGreutate();
	}
	
	/**
	 * Getter inaltime
	 * @return
	 */
	public int getInaltime() {
		return particularitati.getInaltime();
	}
	
	/**
	 * Getter particularitati
	 * @return
	 */
	public Particularitati getParticularitati() {
		return particularitati;
	}
	
	/**
	 * Getter username
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Getter password
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Setter nume
	 * @param nume
	 */
	public void setNume(String nume) {
		this.nume = nume;
	}
	
	/**
	 * Setter sex
	 * @param sex
	 */
	public void setSex(String sex) {
		particularitati.setSex(sex);
	}
	
	/**
	 * Setter varsta
	 * @param varsta
	 */
	public void setVarsta(int varsta) {
		particularitati.setVarsta(varsta);
	}
	
	/**
	 * Setter greutate
	 * @param greutate
	 */
	public void setGreutate(int greutate) {
		particularitati.setGreutate(greutate);
	}
	
	/**
	 * Setter inaltime
	 * @param inaltime
	 */
	public void setInaltime(int inaltime) {
		particularitati.setInaltime(inaltime);
	}
}
