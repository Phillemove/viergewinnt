package VierGewinnt;

import javax.swing.JLabel;

/* Scoreboard für das Spiel
 * Immer wenn ein Spieler gewonnen hat, wird für ihn ein Punkt in ein Array geschrieben. 
 * Stelle 0 im Array ist dabei Spieler 1 und Stelle 1 ist Spieler 2.
 * Das Scoreboard ist als Singleton konzipiert, da es nur einmal benötigt wird, um bei neuen Spielrunden den Score weiter zu behalten.
 * writescore ist dabei für das Schreiben des Scores bei gewinnsituation zuständig.
 */

@SuppressWarnings("serial")
public class Scoreboard extends JLabel {

	static private Scoreboard instance = null;
	private int[] score = new int[2];

	private Scoreboard() {
		this.setText("<html><u>Punktestand</u> <p/> Spieler 1: " + score[0] + "<p/> Spieler 2: " + score[1] + "</html>");
	}

	static public Scoreboard getInstance() {
		if (instance == null) {
			instance = new Scoreboard();
		}
		return instance;
	}

	public void writescore(int spieler) {
		score[spieler - 1] += 1;
		this.setText("<html><u>Punktestand</u> <p/> Spieler 1: " + score[0] + "<p/> Spieler 2: " + score[1] + "</html>");
	}

}