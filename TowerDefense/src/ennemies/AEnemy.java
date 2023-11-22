package ennemies;

public abstract class AEnemy implements IEnemy {
    public int health;
    protected int reward;
    protected int damage;
    protected float speed;
    protected int position;
    protected float xPosition ; // Initial X position
    protected float yPosition; 

    

    public AEnemy (int health, int reward, int damage,float speed, float xPosition, float yPosition) {
        this.health = health;
        this.reward = reward;
        this.damage = damage;
        this.speed = speed;
        this.xPosition= xPosition;
        this.yPosition= yPosition;
        this.position = position;
    }

    @Override
    public void move() {
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        if (!isAlive()) {
            onDefeat();
        }
    }

    @Override
    public boolean isAlive() { // verifie si l'ennemi est toujours en vie, return boolean
        return health > 0;
    }

    @Override
    public int getHealth(int health) {
        return health;
    }

    @Override
    public int getReward(int reward) {
        return reward;
    }

    @Override
    public void onReachGoal() {

    }

    @Override 
    public void onDefeat() {

    }  

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public int getPosition() {
        return position;
    }
    public float getxPosition() {
        return xPosition;
    }

    public float getyPosition() {
        return yPosition;
    }

    public int getDamage() {
        return damage;
    }


}