package main;

import java.awt.Component;

import javax.swing.*;

import Window.AWindow;
import Window.CommandWindow;
import Window.IWindow;
import Window.MenuWindow;
import Window.PlayingWindow;
import ennemies.Cyclope;
import Window.EditingWindow;

public class GameWindow extends JFrame {
    private AWindow currentFrame;
    private MenuWindow menu;
    private PlayingWindow playing;
    private CommandWindow command;
    private EditingWindow editing;

    private int refreshBySecMenu;
    private int refreshBySecPlaying;
    private int refreshBySecCommand;
    private int refreshBySecEditing;

    private Timer timer;
    private Timer secondTimer;

    public GameWindow() {
        this.menu = new MenuWindow(this);
        this.playing = new PlayingWindow(this);
        this.editing = new EditingWindow(this);
        this.command = new CommandWindow(this);
        currentFrame = menu;
        LauncherWindow(currentFrame);
    }

    public <T extends AWindow> void LauncherWindow(T newFrame) {
        SwingUtilities.invokeLater(() -> {
            if (this.currentFrame != null) {
                this.currentFrame.setVisible(false);
            }

            getContentPane().removeAll();
            getContentPane().add((Component) newFrame);
            newFrame.setVisible(true);

            refreshFrame();
            setSize(1930, 1056);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);

            // Arrêter les timers s'ils sont déjà en cours
            if (timer != null && timer.isRunning()) {
                timer.stop();
            }
            if (secondTimer != null && secondTimer.isRunning()) {
                secondTimer.stop();
            }

            // Créer de nouveaux timers
            timer = new Timer(16, e -> {
                refreshFrame();
                if (newFrame instanceof PlayingWindow) {
                    refreshBySecPlaying++;
                } else if (newFrame instanceof EditingWindow) {
                    refreshBySecEditing++;
                } else if (newFrame instanceof CommandWindow) {
                    refreshBySecCommand++;
                } else {
                    refreshBySecMenu++;
                }
            });

            secondTimer = new Timer(1000, e -> {
                if (newFrame instanceof PlayingWindow) {
                    System.out.println("Nombre de frame par seconde (PlayingWindow): " + refreshBySecPlaying);
                    refreshBySecPlaying = 0;
                } else if (newFrame instanceof EditingWindow) {
                    System.out.println("Nombre de frame par seconde (EditingWindow): " + refreshBySecEditing);
                    refreshBySecEditing = 0;
                } else if (newFrame instanceof CommandWindow) {
                    System.out.println("Nombre de frame par seconde (CommandWindow): " + refreshBySecCommand);
                    refreshBySecCommand = 0;
                } else {
                    System.out.println("Nombre de frame par seconde (MenuWindow): " + refreshBySecMenu);
                    refreshBySecMenu = 0;
                }
            });

            timer.start();
            secondTimer.start();
        });
    }

    public void refreshFrame() {
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        
    }

    public IWindow getCurrentFrame() {
        return currentFrame;
    }

    public MenuWindow getMenu() {
        return menu;
    }

    public <T extends AWindow> void setCurrentFrame(T newFrame) {
        if (this.currentFrame != null) {
            this.currentFrame.setVisible(false);
        }
        this.currentFrame = newFrame;
        this.currentFrame.setVisible(true);
    }

    public PlayingWindow getPlaying() {
        return playing;
    }

    public CommandWindow getCommand() {
        return command;
    }

    public EditingWindow getEditing() {
        return editing;
    }
}

