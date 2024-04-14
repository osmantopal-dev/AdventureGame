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
        return true;
    }

    public void showWeapons(){
        System.out.println();
        System.out.println("Weapons");
        for(Weapon weapon: Weapon.weapons()){
            System.out.println(sb.append(weapon.getName())
            .append("\t").append("Damage: ").append(weapon.getDamage())
            .append("\t").append("Price: ").append(weapon.getPrice()));
            sb.setLength(0);
        }
    }

    public void showArmors(){
        System.out.println();
        System.out.println("Armors");
    }
    
}