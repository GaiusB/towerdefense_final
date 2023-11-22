package towers;

import ennemies.IEnemy;

public class Archer extends ATower{

    private int damage;
    private int range;
    private int cost;

    public Archer() {
        super(10, 1, 80);
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
    
}
