public class Toolstore extends NormalLocation {

    StringBuilder sb = new StringBuilder();

    public Toolstore(Player player) {
        super(player, "Toolstore");
    }

    @Override
    public boolean onLocation(){
        System.out.println();
        System.out.println("Welcome to Toolstore!");
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
                        break;
                    case 2:
                        showArmors();
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
        selectWeapon();
        return true;
    }

    public void showWeapons(){
        System.out.println();
        System.out.println("Weapons");
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
        System.out.println();
        boolean validInput = false;
        sb.setLength(0);
        while(!validInput){
            try{
                int menuNumber = Location.scan.nextInt();
                if(menuNumber < 1 || menuNumber > Weapon.weapons().length)
                    throw new Exception("Please enter a valid number: ");
                switch(menuNumber) {
                    case 1:
                        System.out.println(sb.append("You bought ").append(Weapon.weapons()[0].getName()).append("!"));
                        break;
                    case 2:
                        System.out.println(sb.append("You bought ").append(Weapon.weapons()[1].getName()).append("!"));
                        break;
                    case 3:
                        System.out.println(sb.append("You bought ").append(Weapon.weapons()[2].getName()).append("!"));
                        break;
                    case 4:
                        break;
                }

                validInput = true;
            }catch(Exception e){
                System.out.print("Please enter a valid number: ");
                scan.nextLine();
            }
        } 

    }

    public void showArmors(){
        System.out.println();
        System.out.println("Armors");
    }
    
}