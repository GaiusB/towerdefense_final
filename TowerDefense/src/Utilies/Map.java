package Utilies;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ennemies.Cyclope;

public class Map extends JFrame{
    // Représentation de la carte en utilisant des indices de tuiles
    private int[][] groundLayer; 
    private int[][] pathLayer; 
    private int[][] castleLayer;  

    private JLabel characterLabel;
    private Image[] characterFrames;
    private int currentFrameIndex = 0;

    // Tableau d'images de tuiles
    private ArrayList<BufferedImage> tilesList ; 
    // private ArrayList<Cyclope> cyclopsList; // Ajout de la liste des cyclopes 


    // Constructeur de la classe Map
    public Map() {
        this.groundLayer = groundMap();
        this.pathLayer = pathMap();
        this.castleLayer = castMap();
        this.tilesList = new ArrayList<>();
        tilesComp();

        //Cyclope
        // this.cyclopsList = new ArrayList<>();
        // initCyclops(); // Initialisez la liste des cyclopes sur la carte
    }

    private int[][] groundMap(){

        int [][] groundLayer = {

			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 ,2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		};

        return groundLayer;
    }

    private int[][] pathMap(){
        int [][] pathLayer = {

			{ 0, 12, 1, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 12, 1, 14, 0, 24, 25, 25, 26, 0, 0, 0, 0, 0, 0, 0, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 0 },
			{ 0, 12, 1, 14, 0, 30, 31, 31, 32, 0, 0, 0, 0, 0, 0, 0, 12, 1, 1, 1, 1, 1, 14, 10, 10, 1, 0 },
			{ 0, 12, 1, 14, 0, 36, 37, 37, 38, 0, 0, 0, 0, 0, 0, 0, 12, 1, 16, 19, 15, 1, 10, 9, 14, 0 },
			{ 0, 12, 1, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 1, 14, 0, 12, 1, 1, 1, 14, 0 },
			{ 0, 12, 1, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 1, 14, 0, 18, 19, 19, 19, 20, 0 },
			{ 7, 9, 1, 10, 7, 7, 7, 7, 8, 0, 0, 0, 0, 0, 0, 0, 12, 1, 10, 7, 7, 7, 7, 7, 8, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 14, 0, 0, 0, 0, 0, 0, 0, 12, 1, 1, 1, 1, 1, 1, 1, 14, 0, 0 },
			{ 19, 15, 1, 16, 19, 19, 15, 1, 14, 0, 0, 0, 0, 0, 0, 0, 18, 19, 19, 19, 19, 19, 15, 1, 14, 0, 0 },
			{ 0, 12, 1, 14, 0, 0, 12, 1, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 1, 14, 0, 0 },
			{ 0, 12, 1, 14, 0, 0, 12, 1, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 1, 14, 0, 0 },
			{ 0, 12, 1, 14, 0, 0, 12, 1, 10, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 9, 1, 14, 0, 0 },
			{ 0, 12, 1, 14, 0, 0, 12, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 14, 0, 0 },
			{ 0, 12, 1, 14, 48, 50, 18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 20, 0, 0 },
			{ 0, 12, 1, 14, 60, 62, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		};

        return pathLayer;
    }

    private int[][] castMap(){

        int [][] castleLayer = {

			{ 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 66, 67, 68, 69 },
			{ 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 72, 73, 74, 75, },
			{ 11, 11, 11, 11, 11, 11, 11, 45, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 78, 79, 80, 81, },
			{ 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 84, 85, 86, 87, },
			{ 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11 },
			{ 43, 11, 11, 11, 11, 44, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11 },
			{ 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11 },
			{ 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11 },
			{ 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11 },
			{ 43, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11 },
			{ 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 42, 11, 11, 11, 11, 11 },
			{ 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11 },
			{ 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11 },
			{ 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11 },
			{ 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11 },
		};

        return castleLayer;
    }

    public void tilesComp(){
        File file = new File("/home/abishan/T-JAV-501-PAR_27/TowerDefense/res/map.png");
        BufferedImage spriteImage;

        try {
            
            spriteImage = ImageIO.read(file);
            if (spriteImage != null) {
                for(int i = 0; i<15;i++){
                    for(int j=0; j<6; j++){
                        int subImageX = j * 64;
                        int subImageY = i * 64;
                        int subImageWidth = 64;
                        int subImageHeight = 64;
                        tilesList.add(spriteImage.getSubimage(subImageX, subImageY, subImageWidth, subImageHeight));
    
                    }
                }
            } else {
                System.out.println("Erreur de chargement du fichier d'image.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw (Graphics G) {
        drawLayer(G, groundLayer);
        drawLayer(G, pathLayer);
        drawLayer(G, castleLayer);
    }

    // Méthode pour dessiner la carte
    public void drawLayer(Graphics g, int[][]groundLayer) {
        for (int i = 0; i < groundLayer.length; i++) {
            for (int j = 0; j < groundLayer[i].length; j++) {
                int indiceTuile = groundLayer[i][j];
                if (indiceTuile >= 0 && indiceTuile < tilesList.size()) {
                    g.drawImage(tilesList.get(indiceTuile), j * 64, i * 64, null);
                }
            }
        }
    }

    // private Image[] loadCharacterFrames() {
    //     try {
    //         ImageIcon spriteAtlas = new ImageIcon("/home/abishan/T-JAV-501-PAR_27/TowerDefense/res/spriteatlas.png");
 
    //         // Convert the ToolkitImage to BufferedImage
    //         Image toolkitImage = spriteAtlas.getImage();
    //         BufferedImage bufferedImage = new BufferedImage(
    //                 toolkitImage.getWidth(null),
    //                 toolkitImage.getHeight(null),
    //                 BufferedImage.TYPE_INT_ARGB
    //         );
    //         Graphics g = bufferedImage.createGraphics();
    //         g.drawImage(toolkitImage, 0, 0, null);
    //         g.dispose();
 
    //         // Split the sprite atlas into sub-images
    //         int frameWidth = 64; // Width of a frame
    //         int frameHeight = 64; // Height of a frame
    //         int numFrames = 9; // Number of frames in the sprite atlas
 
    //         Image[] frames = new Image[numFrames];
 
    //         for (int i = 0; i < numFrames; i++) {
    //             frames[i] = bufferedImage.getSubimage(i * frameWidth, 0, frameWidth, frameHeight);
    //         }
 
    //         return frames;
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         System.out.println("personnage non trouvé");
    //         return null;
    //     }
    // }
 
    // private void animateCharacter() {
    //     // Update the current frame index
    //     if (currentFrameIndex > characterFrames.length - 1) {
    //         currentFrameIndex = 0;
    //     }
    //     characterLabel.setIcon(new ImageIcon(characterFrames[currentFrameIndex]));
    // }
    
}


  
