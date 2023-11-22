package ennemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Timer;

import javax.imageio.ImageIO;
public class Schrek extends AEnemy{

    // private int xPosition = 128; // Initial X position
    // private float yPosition = 0; // Initial Y position
    // private float movementSpeed = 0.6f; // Speed of movement
    private int currentFrameIndex = 0;

    private ArrayList<BufferedImage> schrekList;
    private Timer animationTimer;

    public Schrek() {
        super(150, 100, 15, 0.6f, 128, 0);
        this.schrekList = new ArrayList<>();
        tilesComp();

        animationTimer = new Timer(100, e -> animateCharacter());
        animationTimer.start();
    }

    public void tilesComp(){
        File file = new File("/home/abishan/T-JAV-501-PAR_27/TowerDefense/res/personae.png");
        try {
            BufferedImage spriteImage = ImageIO.read(file);
            spriteImage = ImageIO.read(file);
            if (spriteImage != null) {
                for(int i = 0; i<9;i++){
                    int subImageX = i * 64;
                    int subImageY = 3 * 64;
                    int subImageWidth = 64;
                    int subImageHeight = 64;
                    schrekList.add(spriteImage.getSubimage(subImageX, subImageY, subImageWidth, subImageHeight));
                }
            } 
            else {
                System.out.println("Erreur de chargement du fichier d'image.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        g.drawImage(schrekList.get(currentFrameIndex), (int) xPosition, (int) yPosition, null);
        g.setColor(Color.green);
        g.fillRect((int) xPosition + 5, (int) yPosition, 50, 5);
    }

    @Override
    public boolean isAtgoal() {
        return false;
    }

    public void move() {
        // Update the position of the Cyclope
        yPosition += speed; // Adjust the movement speed as needed
    }


    public void animateCharacter() {
        // Incrémente l'index du cadre pour la prochaine itération
        currentFrameIndex++;

        // Met à jour l'index du cadre actuel
        if (currentFrameIndex > schrekList.size() - 1) {
            currentFrameIndex = 0;
        }

        // Déplacer le personnage
        move();
    }

    @Override
    public double calculateDistance(int towerPosition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateDistance'");
    }

}