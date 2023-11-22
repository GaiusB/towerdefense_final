package towers;



public abstract class ATower implements ITower {

    private int damage;
    private int level;
    private int range;
    private int cost;
    

    public ATower(int damage, int level, int range) {
        this.damage = damage;
        this.level = level;
        this.range = range;
    }

    @Override
    public void upgradeDamage() {
        this.damage += 5;
    }

    @Override
    public void upgradeRange() {
        this.range += 10;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public int getRange() {
        return this.range; // renvoie la valeur de l'attribut range
    }
  
}