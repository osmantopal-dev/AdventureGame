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
        return true;
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
