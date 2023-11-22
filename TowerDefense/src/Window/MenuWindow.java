package Window;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import main.GameWindow;

public class MenuWindow extends AWindow {
    private JButton buttonPlaying;
    private JButton buttonCommand;
    private JButton buttonEditing;
    private JButton buttonQuit;
    private GameWindow gameWindow;

    public MenuWindow(GameWindow gameWindow) {
        setLayout(null);
        this.gameWindow = gameWindow;
        this.buttonPlaying = new JButton("Playing");
        this.buttonCommand = new JButton("Command");
        this.buttonEditing = new JButton("Editing");
        this.buttonQuit = new JButton("Quit");
        initializeButtons();
        changePanel();
    }

    @Override
    public void initializeButtons() {
        int yIncr = 50;
        int w = 120;
        int x = 1800 / 2 - (w / 2);
        int h = w / 3;

        // Ajouter les boutons à la liste des boutons de la classe de base (AWindow)
        // addButton(buttonPlaying);
        // addButton(buttonCommand);
        // addButton(buttonEditing);
        // addButton(buttonQuit);

        // Ajouter les boutons à la fenêtre
        setUpButton(buttonPlaying, x, yIncr + w, w, h);
        setUpButton(buttonCommand, x, yIncr+ w * 2, w, h);
        setUpButton(buttonEditing, x, yIncr+ w * 3, w, h);
        setUpButton(buttonQuit, x, yIncr+ w * 4, w, h);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    @Override
    public void draw(Graphics g) {
        // Dessiner quelque chose si nécessaire
    }

    @Override
    public void changePanel() {
        for (JButton b : this.getButtonList()) {
            b.addActionListener(this);  // Ajouter ActionListener à chaque bouton
        }
    }

    // Implémenter la méthode actionPerformed
    @Override
    public void actionPerformed(ActionEvent e) {
        // Gérer les événements ici, par exemple, le code pour passer à la fenêtre de jeu
        JButton sourceButton = (JButton) e.getSource();
        switch (sourceButton.getText()) {
            case "Playing":
                gameWindow.setCurrentFrame(gameWindow.getPlaying());
                gameWindow.LauncherWindow(gameWindow.getPlaying());
                break;
            case "Command":
                gameWindow.setCurrentFrame(gameWindow.getCommand());
                gameWindow.LauncherWindow(gameWindow.getCommand());
                break;
            case "Editing":
                gameWindow.setCurrentFrame(gameWindow.getEditing());
                gameWindow.LauncherWindow(gameWindow.getEditing());
                break;
            case "Quit":
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
