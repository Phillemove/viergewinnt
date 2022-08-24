package VierGewinnt;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.JPanel;

/* Erzeugen von Spiel GUI.
 * EventHandler Mouseclick für Spielzugsdurchführung.
 * Spielsteuerung wird erzeugt (Erstellen der Logik des Spiels).
 * Zeichnen des Spielfeldes anhand Spielfeld (Datenbank) mit paint Methode.
 * Attribut player gibt an, welcher Spieler am Zug ist.
 * Methode actionPerformed ist für den Neustart des Spiels. Sie erzeugt ein neues Spiel objekt und fordert repaint an.
 */
@SuppressWarnings("serial")
public class Gui extends JPanel implements MouseListener, ActionListener {

	private Spielsteuerung spiel;
	
	private Image leer;
	private Image rot;
	private Image gelb;
	// Eigens definierte Farbe
	Color myblue = Color.decode("#18397C");

	private int col;
	private int player = Spielsteuerung.S1;

	public Gui() {
		this.addMouseListener(this);
		spiel = new Spielsteuerung();
		URL leeresfeld = getClass().getResource("/bilder/leer.gif");
		URL roterstein = getClass().getResource("/bilder/rot.gif");
		URL gelberstein = getClass().getResource("/bilder/gelb.gif");
		leer = Toolkit.getDefaultToolkit().getImage(leeresfeld);
		rot = Toolkit.getDefaultToolkit().getImage(roterstein);
		gelb = Toolkit.getDefaultToolkit().getImage(gelberstein);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.setBackground(myblue);
		int x = getWidth() / Spielsteuerung.Y;
		int y = getHeight() / Spielsteuerung.X;
		for (int i = 0; i < Spielsteuerung.Y; i++) {
			for (int j = 0; j < Spielsteuerung.X; j++) {
				g.drawImage(leer, 0 + (i * x), 0 + (j * y), x, y, null);
				// Aufruf Repaint direkt hier zum Zeichnen des Spielfeldes an sich, damit bei Programmstart das Spielfeld gezeichnet ist und die Logik funktioniert
				repaint();
				if (String.valueOf(spiel.spielfeld.get(j, i)).equals(String.valueOf(spiel.steine[0].getColor()))) {
					g.drawImage(rot, 0 + (i * x), 0 + (j * y), x, y, null);
				} else if (String.valueOf(spiel.spielfeld.get(j, i))
						.equals(String.valueOf(spiel.steine[1].getColor()))) {
					g.drawImage(gelb, 0 + (i * x), 0 + (j * y), x, y, null);
				} 
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.spiel = new Spielsteuerung();
		this.player = Spielsteuerung.S1;
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int fieldC = getWidth() / Spielsteuerung.Y;
		this.col = e.getX() / fieldC;
		if (player == Spielsteuerung.S1) {
			spiel.spielzug(col, player);
			player = Spielsteuerung.S2;
		} else {
			spiel.spielzug(col, player);
			player = Spielsteuerung.S1;
		}
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}