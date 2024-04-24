public class Toolstore extends NormalLocation {

    StringBuilder sb = new StringBuilder();

    public Toolstore(Player player) {
        super(player, "Toolstore");
    }

    @Override
    public boolean onLocation(){
        System.out.println();
        System.out.println("########## Welcome to Toolstore! ##########");
        System.out.println();
        sb.setLength(0);
        System.out.println(sb.append("Your money: ").append(this.getPlayer().getMoney()));
        sb.setLength(0);
        System.out.println();
        System.out.println("1. Weapons");
        System.out.println("2. Armors");
        System.out.println("3. Quit");
        System.out.print("Your choice: ");
        boolean validInput = false;
        while(!validInput){
            try{
                int menuNumber = Location.scan.nextInt();
                if(menuNumber != 1 && menuNumber != 2 && menuNumber != 3)
                    throw new Exception("Please enter a valid number: ");
                switch(menuNumber) {
                    case 1:
                        showWeapons();
                        selectWeapon();
                        break;
                    case 2:
                        showArmors();
                        selectArmor();
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("See you again!");
                        System.out.println();
                        return true;
                }
                validInput = true;
    
            }catch(Exception e){
                System.out.print("Please enter a valid number: ");
                scan.nextLine();
            }
        } 
        
        return true;
    }

    public void showWeapons(){
        System.out.println();
        System.out.println("Weapons");
        sb.setLength(0);
        for(Weapon weapon: Weapon.weapons()){
            System.out.println(sb.append(weapon.getID()).append(". ").append(weapon.getName())
            .append("\t").append("Damage: ").append(weapon.getDamage())
            .append("\t").append("Price: ").append(weapon.getPrice()));
            sb.setLength(0);
        }
        System.out.println("4. Back");
    }

    public void selectWeapon(){
        System.out.println();
        System.out.print("Your choice: ");
        boolean validInput = false;
        int weaponID = -1;
        while(!validInput){
            try{
                weaponID = Location.scan.nextInt();
                validInput = true;
            }catch(Exception e){
                System.out.print("Please enter a valid number: ");
                scan.nextLine();
            }
        }
        Weapon selectedWeapon = Weapon.getWeaponObjByID(weaponID);
        sb.setLength(0);
        if(selectedWeapon != null){
            if(selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Not enough money!");
            }else{
                System.out.println(sb.append("You bought a/an ").append(selectedWeapon.getName()));
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
            }
        }
    }

    public void showArmors(){
        System.out.println();
        System.out.println("Armors");
        sb.setLength(0);
        for (Armor armor : Armor.armors()) {
            System.out.println(sb.append(armor.getID()).append(". ").append(armor.getName())
            .append("\t").append("Damage Blocked: ").append(armor.getDamageBlocked())
            .append("\t").append("Price: ").append(armor.getPrice()));
            sb.setLength(0);
        }
        System.out.println("4. Back");
    }

    public void selectArmor(){
        System.out.println();
        System.out.print("Your choice: ");
        boolean validInput = false;
        int armorID = -1;
        while(!validInput){
            try{
                armorID = Location.scan.nextInt();
                validInput = true;
            }catch(Exception e){
                System.out.print("Please enter a valid number: ");
                scan.nextLine();
            }
        }
        Armor selectedArmor = Armor.getArmorObjByID(armorID);
        sb.setLength(0);
        if(selectedArmor != null){
            if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Not enough money!");
            }else{
                System.out.println(sb.append("You bought a/an ").append(selectedArmor.getName()));
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                this.getPlayer().getInventory().setArmor(selectedArmor);;
            }
        }

    }
    
}