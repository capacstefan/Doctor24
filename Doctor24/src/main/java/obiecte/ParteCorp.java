package obiecte;

import java.util.ArrayList;
/**
 * Clasa ParteCorp
 */
public class ParteCorp {
	private String nume;
	private ArrayList<Diagnostic> diagnostice;
	
	/**
	 * Constructor neparametrizabi;
	 */
	public ParteCorp() {}
	
	/**
	 * Constructor parametrizabil
	 * @param nume
	 * @param diagnostice
	 */
	public ParteCorp(String nume, ArrayList<Diagnostic> diagnostice) {
		this.nume = nume;
		this.diagnostice = diagnostice;
	}
	/**
	 * Getter nume
	 * @return
	 */
	public String getNume() {
		return nume;
	}
	
	/**
	 * Getter diagnostice
	 * @return
	 */
	public ArrayList<Diagnostic> getDiagnostice() {
		return diagnostice;
	}


	
}
