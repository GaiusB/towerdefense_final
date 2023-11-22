package Window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import main.GameWindow;

public class CommandWindow extends AWindow {
    private GameWindow gameWindow;
    private JButton buttonMenu;
    private int refreshBySecCommand;

    public CommandWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        this.buttonMenu = new JButton("Menu");
        initializeButtons();
        changePanel();
    }

    @Override
    public void draw(Graphics g) {
        final int WIDTH = 1000;
        final int HEIGHT = 1000;

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.black);

        g.drawString ("Objectifs", 10,80);
        g.drawString (" Defend your base by strategically placing towers to stop waves of enemy units.",20,95);

        g.drawString ("Tower Upgrades:",10,115);
        g.drawString (" Increases their effectiveness. Earn upgrade points by defeating enemies.",20,135);


        g.drawString ("Resources:" ,10,155);
        g.drawString (" Collect resources from defeated enemies to build and upgrade towers.",20,175);

        g.drawString ("Wave Information:" ,10,195);
        g.drawString (" Monitor the wave counter to know when the next wave of enemies is approaching",20,205);

        g.drawString ("Base Health:", 10,225);
        g.drawString ("  Keep an eye on your base health. If it reaches zero, the game is over.",20,245);

        g.drawString ("Special Abilities:" ,10,265);
        g.drawString (" Some towers have special abilities. Activate them strategically during battle for an advantage.",20,285);

        g.drawString ("Tower Placement:",10,305);
        g.drawString (" Click on an empty tile to place a tower. Different towers have unique abilities and attack ranges.",20,325);

        g.drawString ("Tower Upgrades:",10,345);
        g.drawString (" Upgrade your towers to increase their effectiveness. Earn upgrade points by defeating enemies.",20,365);


        g.drawString ("Enemy Types:",10,385);
        g.drawString (" Different enemies have varying strengths and weaknesses. Plan your defenses accordingly.",20,405);

        g.drawString ("Settings:",10,425);
        g.drawString (" Adjust game settings, including sound and graphics, to suit your preferences.",20,465);

        g.drawString ("How to play :",50,495);

        g.drawString ("Use the mouse to drag a tower and drop it strategically where you wish to initiate the attack ",30,530);
        g.drawString ("Pay attention on the five different enemies",30,550);

        g.drawString ("The towers can be placed everywhere except the road ",30,570);
        drawButton(g, buttonMenu, "Menu", 15, 15, 100, 30);
    }

    private void drawText(Graphics g, String text, int x, int y) {
        g.drawString(text, x, y);
    }

    private void drawButton(Graphics g, JButton button, String text, int x, int y, int width, int height) {
        button.setPreferredSize(new Dimension(width, height));
        button.setBounds(x, y, width, height);
        button.setVisible(true);
        add(button);
    }

    @Override
    public void initializeButtons() {
        // Utilisez des constantes pour les positions et dimensions des boutons
        setUpButton(buttonMenu, 15, 15, 100, 30);
    }

    @Override
    public void changePanel() {
        buttonMenu.addActionListener(this);
    }

    @Override
    public void handleRefresh() {
        refreshBySecCommand++;
    }

    @Override
    public void printRefreshCount() {
        System.out.println("Nombre de frames par seconde (CommandWindow): " + refreshBySecCommand);
        refreshBySecCommand = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameWindow.setCurrentFrame(gameWindow.getMenu());
        gameWindow.LauncherWindow(gameWindow.getMenu());
    }
    
}
