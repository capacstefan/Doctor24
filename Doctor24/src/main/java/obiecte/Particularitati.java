package obiecte;

import java.lang.reflect.Constructor;

import com.google.gson.Gson;
/**
 * Clasa particularitati
 */
public class Particularitati {
	private String sex;
	private int varsta;
	private int greutate;
	private int inaltime;
	
	/**
	 * Constructor nearametrizabil
	 */
	public Particularitati() {}
	
	/**
	 * Comstructor parametrizabil
	 * @param s
	 * @param v
	 * @param g
	 * @param i
	 */
	public Particularitati(String s, int v,int g, int i) {
		sex = s;
		varsta = v;
		greutate = g;
		inaltime = i;
	}
	
	/**
	 * Getter sex
	 * @return
	 */
	public String getSex() {
		return sex;
	}
	
	/**
	 * Setter sex
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	/**
	 * Getter varsta
	 * @return
	 */
	public int getVarsta() {
		return varsta;
	}
	
	/**
	 * Setter varsta
	 * @param varsta
	 */
	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}
	/**
	 * Getter greutate
	 * @return
	 */
	public int getGreutate() {
		return greutate;
	}
	
	/**
	 * Setter greutate
	 * @param greutate
	 */
	public void setGreutate(int greutate) {
		this.greutate = greutate;
	}
	
	/**
	 * Getter inaltime
	 * @return
	 */
	public int getInaltime() {
		return inaltime;
	}
	
	/**
	 * Setter inaltime
	 * @param inaltime
	 */
	public void setInaltime(int inaltime) {
		this.inaltime = inaltime;
	}
}
