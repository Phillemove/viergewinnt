package VierGewinnt;

import javax.swing.JOptionPane;

/* Spiellogik. 
 * spielzug führt Spielzug durch, sofern die Mehtode getFreeDepth nicht 0 als Rückgabe hat und win false ist.
 * gewinn zur Gewinnermittlung wird aufgerufen. Wenn ein gewinn vorliegt wird ein MessageDialog aufgerufen.
 * getFreeDepth ermittelt, wie viele Stellen pro Spalte mit LEER befüllt sind -> Wo bleibt der Stein beim  Spielzug liegen. 
 * gewinn prüft Gewinnsituation und gibt true zurück, wenn eine vorliegt.
 * Bei gewinn wird Punkt für Spieler in scoreboard geschrieben.
 * Wenn alle Felder voll sind und kein gewinn vorliegt = Unentschieden.
 */

public class Spielsteuerung extends Spielfeld {

	Steine steine[];
	Spielfeld spielfeld;

	private boolean win = false;
	private int freiefelder = X * Y;

	public Spielsteuerung() {
		steine = new Steine[SPIELER];
		steine[0] = new Steine('R');
		steine[1] = new Steine('G');
		spielfeld = new Spielfeld();
	}

	public void spielzug(int col, int spieler) {
		int tiefe = getFreeDepth(col, spielfeld.spielfeld);
		if (tiefe != 0 && this.win == false) {
			spielfeld.spielfeld[tiefe - 1][col] = steine[spieler - 1].getColor();
			freiefelder--;
			if (gewinn(spieler) == true) {
				JOptionPane.showMessageDialog(null, "Spieler " + spieler + " hat gewonnen");
				this.win = true;
				Scoreboard.getInstance().writescore(spieler);
			} else if (freiefelder == 0) {
				JOptionPane.showMessageDialog(null, "Unentschieden");
			}
		}
	}

	private int getFreeDepth(int col, char[][] spielfeld) {
		int counter = 0;
		for (char[] row : spielfeld) {
			if (row[col] == Spielfeld.LEER) {
				counter++;
			}
		}
		return counter;
	}

	private boolean gewinn(int spieler) {
		boolean winsituation = false;
		char farbe = steine[spieler - 1].getColor();
		for (int row = Spielfeld.Y - 1; row >= 0; row--) {
			for (int col = 0; col <= Spielfeld.X; col++) {
				// Gewinnsituation Reihe
				if (spielfeld.get(row, col) == farbe && spielfeld.get(row - 1, col) == farbe
						&& spielfeld.get(row - 2, col) == farbe && spielfeld.get(row - 3, col) == farbe) {
					winsituation = true;
				// Gewinnsituation Spalte
				} else if (spielfeld.get(row, col) == farbe && spielfeld.get(row, col + 1) == farbe
						&& spielfeld.get(row, col + 2) == farbe && spielfeld.get(row, col + 3) == farbe) {
					winsituation = true;
				// Gewinnsituation Diagonal 1 (unten links nach oben rechts)
				} else if (spielfeld.get(row, col) == farbe && spielfeld.get(row - 1, col + 1) == farbe
						&& spielfeld.get(row - 2, col + 2) == farbe && spielfeld.get(row - 3, col + 3) == farbe) {
					winsituation = true;
				// Gewinnsituation Diagonal 2 (oben links nach unten rechts)
				} else if (spielfeld.get(row + 3, col) == farbe && spielfeld.get(row + 2, col - 1) == farbe
						&& spielfeld.get(row + 1, col - 2) == farbe && spielfeld.get(row, col - 3) == farbe) {
					winsituation = true;
				}
			}
		}
		return winsituation;
	}

}