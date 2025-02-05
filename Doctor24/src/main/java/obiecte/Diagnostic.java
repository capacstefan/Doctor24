package obiecte;

import java.util.ArrayList;
/**
 * Clasa Diagnostic
 */
public class Diagnostic {
	private String nume;
	private ArrayList<String> simptome;
	private String cauze;
	private String indicatii;
	private boolean grav;
	
	/**
	 * Constructor neparametrizabil
	 */
	public Diagnostic() {}
	
	/**
	 * Constructor parametrizabil
	 * @param nume
	 * @param simptome
	 * @param cauze
	 * @param indicatii
	 * @param grav
	 */
	public Diagnostic(String nume, ArrayList<String> simptome, String cauze, String indicatii, boolean grav) {
		this.nume = nume;
		this.cauze = cauze;
		this.simptome = simptome;
		this.indicatii = indicatii;
		this.grav = grav;
	}
	
	
	/**
	 * Getter grav
	 * @return
	 */
	public boolean getGrav() {
		return grav;
	}
	/**
	 * Getter nume
	 * @return
	 */
	public String getNume() {
		return nume;
	}
	/**
	 * Getter simptome
	 * @return
	 */
	public ArrayList<String> getSimptome() {
		return simptome;
	}
	/**
	 * Getter cauze
	 * @return
	 */
	public String getCauze() {
		return cauze;
	}
	/**
	 * Getter indicatii
	 * @return
	 */
	public String getIndicatii() {
		return indicatii;
	}


	
	
}
