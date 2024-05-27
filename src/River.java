public class River extends BattleLocation{

    public River(Player player) {
        super(player, "River", new Bear(), "Water", 2);
    }

    @Override
    public boolean onLocation() {
        System.out.println();
        int enemyNumber = super.randomEnemyNumber(super.getMaxEnemy());
        System.out.println(sb.append("You are in the ").append(super.getName()));
        sb.setLength(0);
        System.out.println(sb.append("There is/are ").append(enemyNumber).append(" ").append(super.getEnemy().getName()));
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
    
}
