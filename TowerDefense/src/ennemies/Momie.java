package ennemies;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Timer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.GameWindow;

public class Momie extends AEnemy{

    private int[][] momieLayer;

    // private float xPosition = 128; // Initial X position
    // private float yPosition = 1; // Initial Y position
    // private float movementSpeed = 1.2f; // Speed of movement
    private float destinationX;
    private float destinationY;
    private float intermediateX1 = 128;
    private float intermediateY1 = 448;
    private float intermediateX1bis = 128;
    private float intermediateY1bis = 512;
    private float intermediateX2 = 448;
    private float intermediateY2 = 448;
    private float intermediateX2bis = 512;
    private float intermediateY2bis = 448;
    private float intermediateX3 = 448;
    private float intermediateY3 = 768;
    private float intermediateX3bis = 448;
    private float intermediateY3bis = 832;
    private float intermediateX4 = 1472;
    private float intermediateY4 = 768;
    private float intermediateX4bis = 1536;
    private float intermediateY4bis = 768;
    private float intermediateX5 = 1472;
    private float intermediateY5 = 448;
    private float intermediateX5bis = 1472;
    private float intermediateY5bis = 384;
    private float intermediateX6 = 1088;
    private float intermediateY6 = 448;
    private float intermediateX6bis = 1024;
    private float intermediateY6bis = 448;
    private float intermediateX7 = 1088;
    private float intermediateY7 = 128;
    private float intermediateX7bis = 1088;
    private float intermediateY7bis = 64;
    private float intermediateX8 = 1344;
    private float intermediateY8 = 128;
    private float intermediateX8bis = 1408;
    private float intermediateY8bis = 128;
    private float intermediateX9 = 1344;
    private float intermediateY9 = 256;
    private float intermediateX9bis = 1344;
    private float intermediateY9bis = 320;
    private float intermediateX10 = 1472;
    private float intermediateY10 = 256;
    private boolean reachedIntermediate1, reachedIntermediate1bis, reachedIntermediate2, reachedIntermediate2bis ,reachedIntermediate3, reachedIntermediate3bis ,reachedIntermediate4, reachedIntermediate4bis, reachedIntermediate5, reachedIntermediate5bis, reachedIntermediate6, reachedIntermediate6bis, reachedIntermediate7, reachedIntermediate7bis, reachedIntermediate8, reachedIntermediate8bis, reachedIntermediate9, reachedIntermediate9bis, reachedIntermediate10 = false;
    private int currentFrameIndex = 0;

    private ArrayList<BufferedImage> momieList;
    private Timer animationTimer;

    public Momie() {
        super(150, 50, 40, 1.2f, 128, 1);
        this.momieList = new ArrayList<>();
        tilesComp();
        setDestination(1504, 192);

        animationTimer = new Timer(200, e -> animateCharacter());
        animationTimer.start();
    }

    public void setDestination(int x, int y) {
        this.destinationX = x;
        this.destinationY = y;
    }

    public void tilesComp(){
        File file = new File("/home/abishan/T-JAV-501-PAR_27/TowerDefense/res/personae.png");
        try {
            BufferedImage spriteImage = ImageIO.read(file);
            spriteImage = ImageIO.read(file);
            if (spriteImage != null) {
                for(int i = 0; i<6;i++){
                    int subImageX = i * 64;
                    int subImageY = 4 * 64;
                    int subImageWidth = 64;
                    int subImageHeight = 64;
                    momieList.add(spriteImage.getSubimage(subImageX, subImageY, subImageWidth, subImageHeight));
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
        g.drawImage(momieList.get(currentFrameIndex), (int) xPosition, (int) yPosition, null);
        g.setColor(Color.green);
        g.fillRect((int) xPosition, (int) yPosition, 50, 5);
    }

    @Override
    public boolean isAtgoal() {
        return false;
    }

    public void move() {
        if (!reachedIntermediate1bis) {
            moveTowards1(intermediateX1bis, intermediateY1bis);
            if (xPosition == intermediateX1bis && yPosition == intermediateY1bis) {
                reachedIntermediate1bis = true;
            }
        } else if (!reachedIntermediate1) {
            moveTowards1(intermediateX1, intermediateY1);
            if (xPosition == intermediateX1 && yPosition == intermediateY1) {
                reachedIntermediate1 = true;
            }
        } else if (!reachedIntermediate2bis) {
            moveTowards1(intermediateX2bis, intermediateY2bis);
            if (xPosition == intermediateX2bis && yPosition == intermediateY2bis) {
                reachedIntermediate2bis = true;
            }
        } else if (!reachedIntermediate2) {
            moveTowards1(intermediateX2, intermediateY2);
            if (xPosition == intermediateX2 && yPosition == intermediateY2) {
                reachedIntermediate2 = true;
            }
        } else if (!reachedIntermediate3bis) {
            moveTowards1(intermediateX3bis, intermediateY3bis);
            if (xPosition == intermediateX3bis && yPosition == intermediateY3bis) {
                reachedIntermediate3bis = true;
            }
        } else if (!reachedIntermediate3) {
            moveTowards1(intermediateX3, intermediateY3);
            if (xPosition == intermediateX3 && yPosition == intermediateY3) {
                reachedIntermediate3 = true;
            }
        } else if (!reachedIntermediate4bis) {
            moveTowards1(intermediateX4bis, intermediateY4bis);
            if (xPosition == intermediateX4bis && yPosition == intermediateY4bis) {
                reachedIntermediate4bis = true;
            }
        } else if (!reachedIntermediate4) {
            moveTowards1(intermediateX4, intermediateY4);
            if (xPosition == intermediateX4 && yPosition == intermediateY4) {
                reachedIntermediate4 = true;
            }
        } else if (!reachedIntermediate5bis) {
            moveTowards1(intermediateX5bis, intermediateY5bis);
            if (xPosition == intermediateX5bis && yPosition == intermediateY5bis) {
                reachedIntermediate5bis = true;
            }
        } else if (!reachedIntermediate5) {
            moveTowards1(intermediateX5, intermediateY5);
            if (xPosition == intermediateX5 && yPosition == intermediateY5) {
                reachedIntermediate5 = true;
            }
        } else if (!reachedIntermediate6bis) {
            moveTowards1(intermediateX6bis, intermediateY6bis);
            if (xPosition == intermediateX6bis && yPosition == intermediateY6bis) {
                reachedIntermediate6bis = true;
            }
        } else if (!reachedIntermediate6) {
            moveTowards1(intermediateX6, intermediateY6);
            if (xPosition == intermediateX6 && yPosition == intermediateY6) {
                reachedIntermediate6 = true;
            }
        } else if (!reachedIntermediate7bis) {
            moveTowards1(intermediateX7bis, intermediateY7bis);
            if (xPosition == intermediateX7bis && yPosition == intermediateY7bis) {
                reachedIntermediate7bis = true;
            }
        } else if (!reachedIntermediate7) {
            moveTowards1(intermediateX7, intermediateY7);
            if (xPosition == intermediateX7 && yPosition == intermediateY7) {
                reachedIntermediate7 = true;
            }
        } else if (!reachedIntermediate8bis) {
            moveTowards1(intermediateX8bis, intermediateY8bis);
            if (xPosition == intermediateX8bis && yPosition == intermediateY8bis) {
                reachedIntermediate8bis = true;
            }
        } else if (!reachedIntermediate8) {
            moveTowards1(intermediateX8, intermediateY8);
            if (xPosition == intermediateX8 && yPosition == intermediateY8) {
                reachedIntermediate8 = true;
            }
        } else if (!reachedIntermediate9bis) {
            moveTowards1(intermediateX9bis, intermediateY9bis);
            if (xPosition == intermediateX9bis && yPosition == intermediateY9bis) {
                reachedIntermediate9bis = true;
            }
        } else if (!reachedIntermediate9) {
            moveTowards1(intermediateX9, intermediateY9);
            if (xPosition == intermediateX9 && yPosition == intermediateY9) {
                reachedIntermediate9 = true;
            }
        } else if (!reachedIntermediate10) {
            moveTowards1(intermediateX10, intermediateY10);
            if (xPosition == intermediateX10 && yPosition == intermediateY10) {
                reachedIntermediate10 = true;
            }
        } else {
            moveTowards1((int)destinationX, destinationY);
        }
        
        // Update the position of the Cyclope
        // yPosition += movementSpeed; // Adjust the movement speed as needed
    }

    private void moveTowards1(float targetX1, float targetY1) {
        float epsilon = 1.0f; // Marge d'erreur

        if (Math.abs(xPosition - targetX1) <= epsilon && Math.abs(yPosition - targetY1) <= epsilon) {
            // Atteint la position intermédiaire
            xPosition = (int)targetX1; // Assure une position exacte
            yPosition = (int)targetY1;
        } else {
            // Déplacement normal
            if (xPosition < targetX1) {
                xPosition += speed;
            } else if (xPosition > targetX1) {
                xPosition -= speed;
            }

            if (yPosition < targetY1) {
                yPosition += speed;
            } else if (yPosition > targetY1) {
                yPosition -= speed;
            }
        }

    }

    public float getXPosition() {
        return xPosition;
    }

    public float getYPosition() {
        return yPosition;
    }

    public void animateCharacter() {
        // Incrémente l'index du cadre pour la prochaine itération
        currentFrameIndex++;

        // Met à jour l'index du cadre actuel
        if (currentFrameIndex > momieList.size() - 1) {
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