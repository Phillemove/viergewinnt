package VierGewinnt;

/* Spiel Datenbank. 
 * Deklaration von benötigten Konstanten.
 * Spielfeld wird erzeugt und erstmal mit Wert von LEER befüllt.
 * get() liefert Wert an Stelle x, y in Spielfeld zurück, sofern x und y im Spielfeld liegen.
 * Andernfalls wird ERROR zurück gegeben.
 */

public class Spielfeld {

	static final int X = 7;
	static final int Y = 8;
	static final int SPIELER = 2;
	static final int S1 = 1;
	static final int S2 = 2;
	static final char LEER = '0';
	static final char ERROR = 'E';
	
	char spielfeld[][];

	public Spielfeld() {
		spielfeld = new char[X][Y];
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				spielfeld[i][j] = LEER;
			}
		}
	}

	public char get(int x, int y) {
		if (x >= 0 && x < X && y >= 0 && y < Y) {
			return spielfeld[x][y];
		} else {
			return ERROR;
		}
	}
	
}