public class Enemy {
    private int ID;
    private int damage;
    private int health;
    private String name;
    private int moneyAward;
    private int initHealth;
    
    public Enemy(int ID, int damage, int health, String name, int moneyAward, int initHealth){
        this.ID = ID;
        this.damage = damage;
        this.health = health;
        this.name = name;
        this.moneyAward = moneyAward;
        this.initHealth = initHealth;
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
        if(health < 0){
            this.health = 0;
        }else{
            this.health = health;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoneyAward() {
        return moneyAward;
    }

    public void setMoneyAward(int moneyAward) {
        this.moneyAward = moneyAward;
    }

    public int getInitHealth() {
        return initHealth;
    }

    public void setInitHealth(int initHealth) {
        this.initHealth = initHealth;
    }

}
