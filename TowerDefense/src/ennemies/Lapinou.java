package ennemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Lapinou extends AEnemy{

    private float xPosition = 128; // Initial X position
    private float yPosition = 960; // Initial Y position
    private float movementSpeed = 0.75f; // Speed of movement

    private float destinationX;
    private float destinationY;

    private ArrayList<BufferedImage> lapinouList = new ArrayList<>();
    private Timer animationTimer;

    private ArrayList<float[]> intermediatePositions = new ArrayList<>();
    private int currentIntermediateIndex = 0;
    private int currentFrameIndex = 0;

    public Lapinou() {
        super(50, 30, 5, 0.75f, 128, 960);

        intermediatePositions.add(new float[]{128, 448});
        intermediatePositions.add(new float[]{448, 448});
        intermediatePositions.add(new float[]{448, 768});
        intermediatePositions.add(new float[]{1472, 768});
        intermediatePositions.add(new float[]{1472, 448});
        intermediatePositions.add(new float[]{1088, 448});
        intermediatePositions.add(new float[]{1088, 128});
        intermediatePositions.add(new float[]{1344, 128});
        intermediatePositions.add(new float[]{1344, 256});
        intermediatePositions.add(new float[]{1472, 256});
        // Add more intermediate positions...

        setDestination(1504, 192);

        tilesComp();

        animationTimer = new Timer(100, e -> animateCharacter());
        animationTimer.start();
    }

    public void setDestination(int x, int y) {
        this.destinationX = x;
        this.destinationY = y;
    }

    public void tilesComp() {
        File file = new File("/home/abishan/T-JAV-501-PAR_27/TowerDefense/res/personae.png");
        try {
            BufferedImage spriteImage = ImageIO.read(file);
            if (spriteImage != null) {
                for (int i = 0; i < 9; i++) {
                    int subImageX = i * 64;
                    int subImageY = 2 * 64;
                    int subImageWidth = 64;
                    int subImageHeight = 64;
                    lapinouList.add(spriteImage.getSubimage(subImageX, subImageY, subImageWidth, subImageHeight));
                }
            } else {
                System.out.println("Erreur de chargement du fichier d'image.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        // Dessiner l'image actuelle dans la fenêtre de jeu
        g.drawImage(lapinouList.get(currentFrameIndex), (int) xPosition, (int) yPosition, null);
        g.setColor(Color.green);
        g.fillRect((int) xPosition + 5, (int) yPosition, 50, 5);
    }

    // public void draw (Graphics G) {
    //     drawLayer(G, lapinouLayer, (int) xPosition, (int)yPosition);
    // }

    // public void drawLayer(Graphics g, int[][]lapinouLayer, int x, int y) {
    //     for (int i = 0; i < lapinouLayer.length; i++) {
    //         for (int j = 0; j < lapinouLayer[i].length; j++) {
    //             int indiceTuile = lapinouLayer[i][j];
    //             if (indiceTuile >= 0 && indiceTuile < lapinouList.size()) {
    //                 g.drawImage(lapinouList.get(indiceTuile), x + j * 64, y + i * 64, null);
    //             }
    //         }
    //     }
    // }

    @Override
    public boolean isAtgoal() {
        return false;
    }

    public void move() {
        if (currentIntermediateIndex < intermediatePositions.size()) {
            moveTowards(intermediatePositions.get(currentIntermediateIndex)[0], intermediatePositions.get(currentIntermediateIndex)[1]);

            // Check if reached intermediate position
            if (xPosition == intermediatePositions.get(currentIntermediateIndex)[0] &&
                yPosition == intermediatePositions.get(currentIntermediateIndex)[1]) {
                currentIntermediateIndex++;
            }
        } else {
            moveTowards(destinationX, destinationY);
        }
    }

    private void moveTowards(float targetX, float targetY) {
        float dx = targetX - xPosition;
        float dy = targetY - yPosition;
        float distance = (float) Math.sqrt(dx * dx + dy * dy);

        if (distance > movementSpeed) {
            // Move towards the target
            float ratio = movementSpeed / distance;
            xPosition += dx * ratio;
            yPosition += dy * ratio;
        } else {
            // Reached the target
            xPosition = targetX;
            yPosition = targetY;
        }
    }

    public void animateCharacter() {
        // Incrémente l'index du cadre pour la prochaine itération
        currentFrameIndex++;

        // Met à jour l'index du cadre actuel
        if (currentFrameIndex > lapinouList.size() - 1) {
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

    // @Override
    // public int getPosition() {
    //     return new Position(xPosition,yPosition);
        
    // }
}