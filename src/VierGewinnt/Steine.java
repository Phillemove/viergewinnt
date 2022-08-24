package VierGewinnt;

/* Spielobjekte. 
 * Spielobjekt bekommt Attribut Farbe bei Erzeugung zugewiesen.
 * getColor liefert Wert des Attributs von Spielobjekt.
 */

public class Steine {
	
	private char farbe;
	
	public Steine(char farbe) {
		this.farbe = farbe;
	}
	
	public char getColor() {
		return farbe;
	}
	
}