package Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;  // Importez la classe ActionEvent
import java.awt.event.ActionListener;
import javax.swing.JButton;

import Utilies.Map;
import main.GameWindow;

public class EditingWindow extends AWindow {
    private GameWindow gameWindow;
    private JButton buttonMenu;
    private int refreshBySecEditing;
    private Map map;
    

    public EditingWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        this.map = new Map();
        this.buttonMenu = new JButton("Menu");
        initializeButtons();
        changePanel();
    }

    @Override
    public void draw(Graphics G) {
        map.draw(G);
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
        refreshBySecEditing++;
    }

    @Override
    public void printRefreshCount() {
        System.out.println("Nombre de frame par seconde (eDITingWindow): " + refreshBySecEditing);
        refreshBySecEditing = 0;
    }

    // Implémentez la méthode actionPerformed
    @Override
    public void actionPerformed(ActionEvent e) {
        // Gérez les événements ici, par exemple, le code pour passer à la fenêtre du menu
        gameWindow.setCurrentFrame(gameWindow.getMenu());
        gameWindow.LauncherWindow(gameWindow.getMenu());
    }
}

