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
        System.out.println(sb.append("You are in the ").append(super.getName()));
        sb.setLength(0);
        System.out.println(sb.append("There is/are ").append(enemyNumber).append(" ").append(this.getEnemy().getName()));
        System.out.println();
        playerStats();
        enemyStats();
        System.out.println();
        System.out.println("1. Fight");
        System.out.println("2. Escape");
        System.out.print("Please select an action: ");
        System.out.println();
        boolean validInput = false;
            while(!validInput){
                try{
                    int selection = scan.nextInt();
                    if(selection != 1 && selection != 2)
                        throw new Exception("Please enter a valid number: ");
                    
                    switch(selection) {
                        case 1:
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
        return true;
    }

    public void playerStats(){
        sb.setLength(0);
        System.out.println(sb.append("Your Health: ").append(super.getPlayer().getHealth())
                            .append("\t")
                            .append("Your Damage: ").append(super.getPlayer().getDamage()));
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
