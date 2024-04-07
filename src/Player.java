public class Player {

    private int damage;
    private int health;
    private int money;
    private String name;
    private String characterName;
    
    public Player(String name){
        this.name = name;
    }

    void selectChar(){
        Samurai samurai = new Samurai(characterName, damage, health, money);
        Hunter hunter = new Hunter(characterName, damage, health, money);
        Knight knight = new Knight(characterName, damage, health, money);
        StringBuilder sb = new StringBuilder();
        Character[] characterList = {samurai, hunter, knight};
        for (Character character : characterList) {
            sb.setLength(0);
            System.out.println(sb.append(character.getName())
            .append("\t Damage: ").append(character.getDamage())
            .append("\t Health: ").append(character.getHealth())
            .append("\t Money: ").append(character.getMoney()));
            
        }
        

        
            
    }

    public int getDamage(){
        return damage;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }
    
    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getmoney(){
        return money;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCharacterName(){
        return characterName;
    }

    public void setCharacterName(String characterName){
        this.characterName = characterName;
    }

    
    

    /**
     * @return int return the money
     */
    public int getMoney() {
        return money;
    }

}
