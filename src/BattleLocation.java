import java.util.Random;

public abstract class BattleLocation extends Location{

    private Enemy enemy;
    private String award;
    StringBuilder sb = new StringBuilder();
    private int maxEnemy;

    public BattleLocation(Player player, String name, Enemy enemy, String award, int maxEnemy) {
        super(player, name);
        this.enemy = enemy;
        this.award = award;
        this.maxEnemy = maxEnemy;
    }

    
    @Override
    public boolean onLocation() {
        System.out.println();
        int enemyNumber = randomEnemyNumber(this.getMaxEnemy());
        System.out.println(sb.append("You are in the ").append(this.getName()));
        sb.setLength(0);
        System.out.println(sb.append("There is/are ").append(enemyNumber).append(" ").append(this.getEnemy().getName()));
        System.out.println();
        playerStats();
        enemyStats();
        System.out.println();
        System.out.println("1. Fight");
        System.out.println("2. Escape");
        System.out.print("Please select an action: ");
        boolean validInput = false;
            while(!validInput){
                try{
                    int selection = scan.nextInt();
                    if(selection != 1 && selection != 2)
                        throw new Exception("Please enter a valid number: ");
                    
                    switch(selection) {
                        case 1:
                            sb.setLength(0);
                            combat(enemyNumber);
                            break;
                        case 2:
                            break;
                        default:
                    }
                    validInput = true;
                }catch(Exception e){
                    System.out.print("Please enter a valid number: ");
                    scan.nextLine();
                }
            }
            if(combat(enemyNumber)){
                sb.setLength(0);
                System.out.println(sb.append("You cleared a ").append(this.getName()).append("!").append("\n").append("Your award is ").append("yarrak"));
            }else{
                return false;
            }
        return true;
    }

    public boolean combat(int enemyNumber){
        boolean escapeCheck = true;
        int i = 0;
        while(i < enemyNumber && escapeCheck){
            if(this.getPlayer().getHealth() == 0){
                return false;
            }
            this.getEnemy().setHealth(this.getEnemy().getInitHealth());
            sb.setLength(0);
            System.out.println(sb.append(this.getEnemy().getName()).append(" is coming towards you!"));
            while(this.getPlayer().getHealth() > 0 && this.getEnemy().getHealth() > 0 && escapeCheck){
                System.out.println();
                System.out.println("1. Hit");
                System.out.println("2. Escape");
                System.out.print("Please select an action: ");
                boolean validInput = false;
                while(!validInput){
                    try{
                        int selection = scan.nextInt();
                        if(selection != 1 && selection != 2)
                            throw new Exception("Please enter a valid number: ");
                        switch(selection) {
                            case 1:
                                this.getEnemy().setHealth(this.getEnemy().getHealth() - this.getPlayer().getDamage());
                                int damageTaken = this.getEnemy().getDamage() - this.getPlayer().getInventory().getArmor().getDamageBlocked();
                                if(damageTaken < 0){
                                    damageTaken = 0;
                                }
                                if(this.getEnemy().getHealth() != 0){
                                    this.getPlayer().setHealth(this.getPlayer().getHealth() - damageTaken);
                                }else{
                                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getEnemy().getMoneyAward());
                                    sb.setLength(0); 
                                    System.out.println(sb.append("1 ").append(this.getEnemy().getName()).append(" is dead!"));
                                }
                                break;
                            case 2:
                                escapeCheck = false;
                                return false;
                            default:
                        }
                        validInput = true;
                    }catch(Exception e){
                        System.out.print("Please enter a valid number: ");
                        scan.nextLine();
                    }
                }
                playerStats();
                enemyStats();
            } 
            i++;
        }
        return true;
    }

    public void playerStats(){
        sb.setLength(0);
        System.out.println(sb.append("Your Health: ").append(this.getPlayer().getHealth())
                            .append("\t")
                            .append("Your Damage: ").append(this.getPlayer().getDamage()));
    }

    public void enemyStats(){
        sb.setLength(0);
        System.out.println(sb.append("Enemy Health: ").append(this.getEnemy().getHealth())
                            .append("\t")
                            .append("Enemy Damage: ").append(this.getEnemy().getDamage()));
    }
    
    

    public int randomEnemyNumber(int maxEnemyNumber){
        Random r = new Random();
        return r.nextInt(1, maxEnemyNumber + 1);
    }

    public int randomEnemyNumber(int number1, int number2){
        Random r = new Random();
        return r.nextInt(number1, number2 + 1);
    }
    
    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxEnemy() {
        return maxEnemy;
    }

    public void setMaxEnemy(int maxEnemy) {
        this.maxEnemy = maxEnemy;
    }

}
