package ennemies;

public interface IEnemy {

    void move(); // comment l'ennemi doit se deplacer, met a jour la position ennemi

    float getSpeed();

    void takeDamage(int damage);// represente la quantite de degat a& infliger

    boolean isAtgoal(); // Permet de verifier si l'ennemi a atteint le chateau

    boolean isAlive(); // verifie si l'ennemi est toujours en vie

    int getHealth(int health); // Recupe&re les points de vie actuel de l'ennemy

    // Le boss final pourrait obtenir un partie de la vie des ennemis qui meurent sur la carte

    int getReward(int reward); // Retourne la valeur de recompense que le joeur gagne lorsqu'il vainc l'ennemi


    void onReachGoal(); // Definit les actions ou la logique a executer lorsque l'ennemi atteint le chateau
    // perte de points de vie, ou affichage d'un game over


    void onDefeat(); // specifie les actions ou la logique a executer lorsque l'ennemi sera vaincu
    // disparition de la map, plus ajout de la moitie de sa capacité
    // de vie si le boss est present sur la map

    double calculateDistance(int towerPosition);

    int getPosition();
    

}
