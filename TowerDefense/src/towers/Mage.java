package towers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import ennemies.IEnemy;

public class Mage extends ATower{
    private ArrayList<BufferedImage> mage = new ArrayList<>();
    private double xPosition = 576; // Initial X position
    private double yPosition = 516;
    private int currentFrameIndex = 0;

    public Mage() {
        super (30, 1, 10);
    }

    public void update() {
        // Mettre à jour la position, la rotation, la recherche de cibles, etc.
    }

    public void upgrade() {
        // Logique d'amélioration de la tour
    }

    @Override
    public int getTargetNumber() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTargetNumber'");
    }

    protected double calculateDistance(IEnemy enemy) {
        return Math.abs(enemy.getPosition() - this.getPosition());
    }

    private int getPosition() {
        return 0;
    }

    public void tilesComp(){
        File file = new File("/home/abishan/T-JAV-501-PAR_27/TowerDefense/res/personae.png");
        try {
            BufferedImage spriteImage = ImageIO.read(file);
            if (spriteImage != null) {
                for(int i = 0; i<7;i++){
                    int subImageX = i * 64;
                    int subImageY = 6 *64;
                    int subImageWidth = 64;
                    int subImageHeight = 64;
                    mage.add(spriteImage.getSubimage(subImageX, subImageY, subImageWidth, subImageHeight));
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
        // Dessiner l'image actuelle dans la fenêtre de jeu
        g.drawImage(mage.get(currentFrameIndex), (int) xPosition, (int) yPosition, null);
    }

    public double getXPosition() {
        return xPosition;
    }

    public double getYPosition() {
        return yPosition;
    }
}