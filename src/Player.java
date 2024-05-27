import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int money;
    private String name;
    private String characterName;
    private Scanner scan = new Scanner(System.in);
    private StringBuilder sb = new StringBuilder();
    private Inventory inventory;
    
    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar(){
        Samurai samurai = new Samurai(characterName, damage, health, money);
        Hunter hunter = new Hunter(characterName, damage, health, money);
        Knight knight = new Knight(characterName, damage, health, money);
        
        Character[] characterList = {samurai, hunter, knight};
        System.out.println();
        for (Character character : characterList) {
            sb.setLength(0);
            System.out.println(sb.append(character.getID()).append(". ")
            .append(character.getName())
            .append("\t Damage: ").append(character.getDamage())
            .append("\t Health: ").append(character.getHealth())
            .append("\t Money: ").append(character.getMoney()));
        }

        System.out.println();
        System.out.print("Please select your character: ");
        boolean validInput = false;
        while(!validInput){
            try{
                int input = scan.nextInt();
                if(input != 1 && input != 2 && input != 3)
                    throw new Exception("Please enter a valid number: ");

                validInput = true;
                initCharacter(characterList[input - 1]);
    
            }catch(Exception e){
                System.out.print("Please enter a valid number: ");
                scan.nextLine();
            }
        }
        sb.setLength(0);
        System.out.println();
    }

    private void initCharacter(Character character){
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setMoney(character.getMoney());
        this.setCharacterName(character.getName());
    }

    public void playerInfo(){
        sb.setLength(0);
        System.out.println();
        System.out.println(sb.append("Your character: ").append("<").append(this.getCharacterName()).append("   ")
        .append("Damage: ").append(this.getDamage()).append(" ")
        .append("Money: ").append(this.getMoney()).append(" ")
        .append("Health: ").append(this.getHealth()).append(" ")
        .append("Armor: ").append(this.getInventory().getArmor().getName()).append(" ")
        .append("Weapon: ").append(this.getInventory().getWeapon().getName()).append(">"));
        System.out.println();
    }

    public int getDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage){
        this.damage = damage;
    }
    
    public int getHealth(){
        return health + getInventory().getArmor().getDamageBlocked();
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getMoney(){
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}
