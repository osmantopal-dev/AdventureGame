public class Enemy {
    private int ID;
    private int damage;
    private int health;
    private String name;
    
    public Enemy(int ID, int damage, int health, String name){
        this.ID = ID;
        this.damage = damage;
        this.health = health;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
