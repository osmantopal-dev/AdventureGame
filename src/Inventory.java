import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private Weapon weapon;
    private Armor armor;
    private List<String> awardEarned = new ArrayList<>();

    public Inventory(){
        this.weapon = new Weapon("Hand", 0, 0, 0);
        this.armor = new Armor(0, "None", 0, 0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public List<String> getAwardEarned() {
        return awardEarned;
    }

    public void setAwardEarned(List<String> awardEarned) {
        this.awardEarned = awardEarned;
    }

}
