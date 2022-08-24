package VierGewinnt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/* Einstiegspunkt in Spiel.
 * Erstellt Frame und erzeugt Gui.
 * actionListener für Menue um Spiel neu zu starten oder zu beenden.
 * actionListener für neu starten wird an gui übergeben.
 */

@SuppressWarnings("serial")
public class Frame extends JFrame {
	// Eigens definierte Farben
	Color myblue = Color.decode("#18397C");
	Color mygrey = Color.decode("#BCBCBC");

	public Frame() {
		Gui gui = new Gui();
		// Menue
		JMenuBar menue = new JMenuBar();
		setJMenuBar(menue);
		JMenu spiel = new JMenu("Spiel");
		menue.add(spiel);
		JMenuItem newgame = new JMenuItem("Neues Spiel");
		JMenuItem quit = new JMenuItem("Beenden");
		spiel.add(newgame);
		spiel.add(quit);
		newgame.addActionListener(gui);
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}

		});
		// Header
		JPanel header = new JPanel();
		header.setLayout(new BorderLayout());
		header.setBackground(myblue);
		
		JLabel überschrift = new JLabel("<html><u>Vier Gewinnt</u></html>");
		Font fontüberschrift = new Font("Serif", Font.BOLD, 50);
		überschrift.setFont(fontüberschrift);
		überschrift.setForeground(mygrey);
		überschrift.setHorizontalAlignment(JLabel.CENTER);
		
		Font fontscore = new Font("Serif", Font.PLAIN, 20);
		Scoreboard.getInstance().setForeground(mygrey);
		Scoreboard.getInstance().setFont(fontscore);
		
		JLabel player = new JLabel("<html><u>Spielerfarben</u><p/>Spieler 1: Rot <p/> Spieler 2: Gelb</html>");
		player.setFont(fontscore);
		player.setForeground(mygrey);
		
		header.add(BorderLayout.NORTH, überschrift);
		header.add(BorderLayout.WEST, player);
		header.add(BorderLayout.EAST, Scoreboard.getInstance());
		// Footer
		JLabel signature = new JLabel("by Jan-Philipp Theis");
		Font fontsignature = new Font("Verdana", Font.PLAIN, 10);
		signature.setFont(fontsignature);
		signature.setHorizontalAlignment(JLabel.CENTER);
		// Frame
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.NORTH, header);
		this.add(BorderLayout.CENTER, gui);
		this.add(BorderLayout.SOUTH, signature);
		this.setSize(600, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
        Frame spielbildschirm = new Frame();
	}

}