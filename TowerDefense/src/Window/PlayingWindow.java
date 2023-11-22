package Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;  // Importez la classe ActionEvent
import java.awt.event.ActionListener;
import javax.swing.JButton;

import Utilies.Map;
import ennemies.Cyclope;
import ennemies.Lapinou;
import ennemies.Momie;
import ennemies.Schrek;
import ennemies.SkeletonBoss;
import main.GameWindow;
import main.Move;
import towers.Arbalette;
import towers.Mage;
import towers.Mortier;

public class PlayingWindow extends AWindow {
    private GameWindow gameWindow;
    private JButton buttonMenu;
    private int refreshBySecPlaying;
    private Map map;
    private Cyclope cyclope;
    private SkeletonBoss skeletonBoss;
    private Lapinou lapinou;
    private Momie momie;
    private Schrek schrek;
    private JButton resumeButton;
    private boolean isPaused = false;
    private Mortier mortier;
    private Mage mage;
    private Arbalette arbalette;

    public PlayingWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        this.map = new Map();
        this.buttonMenu = new JButton("Menu");
        this.cyclope = new Cyclope();
        this.skeletonBoss = new SkeletonBoss();
        this.lapinou = new Lapinou();
        this.momie = new Momie();
        this.schrek = new Schrek();
        this.mortier = new Mortier();
        this.mage = new Mage();
        this.arbalette = new Arbalette();
        initializeButtons();
        changePanel();
        cyclope.tilesComp();
        cyclope.setDestination(1504, 192);
        skeletonBoss.tilesComp();
        skeletonBoss.setDestination(1504, 192);
        lapinou.tilesComp();
        lapinou.setDestination(1504, 192);
        momie.tilesComp();
        momie.setDestination(1504, 192);
        schrek.tilesComp();
        mortier.tilesComp();
        mage.tilesComp();
        arbalette.tilesComp();

        resumeButton = new JButton("Pause");
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Appel de la méthode pour mettre en pause ou reprendre le jeu
                togglePauseResume();
            }
        });

        add(resumeButton);

    }

    private void togglePauseResume() {
        // Logique pour mettre en pause ou reprendre le jeu
        isPaused = !isPaused;

        // Mettez à jour le libellé du bouton
        resumeButton.setText(isPaused ? "Resume" : "Pause");

        // Redessiner la fenêtre (vous devrez peut-être appeler repaint())
        repaint();
    }

    @Override
    public void draw(Graphics G) {
        map.draw(G);
        skeletonBoss.move(); // Appeler la méthode de déplacement
        skeletonBoss.draw(G);
        momie.move(); // Appeler la méthode de déplacement
        momie.draw(G);
        schrek.move(); // Appeler la méthode de déplacement
        schrek.draw(G);
        lapinou.move(); // Appeler la méthode de déplacement
        lapinou.draw(G);
        cyclope.move(); // Appeler la méthode de déplacement
        cyclope.draw(G);
        mortier.update();
        mortier.draw(G);
        mage.update();
        mage.draw(G);
        arbalette.update();
        arbalette.draw(G);
        // int xPosition = cyclope.getXPosition();
        // int yPosition = cyclope.getYPosition();
        // lapinou.animateCharacter(); // Animer le personnage avant de le déplacer
        // lapinou.move(); // Appeler la méthode de déplacement
        // int x = (int) lapinou.getXPosition();
        // int y = (int) lapinou.getYPosition();
        // lapinou.draw(G);
    }

    @Override
    public void initializeButtons() {
        setUpButton(buttonMenu, 15, 15, 100, 30);
    }

    @Override
    public void changePanel() {
        buttonMenu.addActionListener(this);  // Ajoutez ActionListener à buttonMenu
    }

    // Implémentez les méthodes de l'interface Refreshable
    @Override
    public void handleRefresh() {
        refreshBySecPlaying++;
    }

    @Override
    public void printRefreshCount() {
        System.out.println("Nombre de frame par seconde (PlayingWindow): " + refreshBySecPlaying);
        refreshBySecPlaying = 0;
    }

    // Implémentez la méthode actionPerformed
    @Override
    public void actionPerformed(ActionEvent e) {
        // Gérez les événements ici, par exemple, le code pour passer à la fenêtre du menu
        gameWindow.setCurrentFrame(gameWindow.getMenu());
        gameWindow.LauncherWindow(gameWindow.getMenu());
    }
}

