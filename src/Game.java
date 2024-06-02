import java.util.Scanner;


public class Game {

    private Scanner scan = new Scanner(System.in);
    // private StringBuilder sb = new StringBuilder();

    public void start(){
        
        System.out.println("Welcome to adventure game!");
        System.out.print("Please enter your name: ");
        String playerName = scan.nextLine();
        Player player = new Player(playerName);
        player.selectChar();
        Location location = null;
        boolean gameCheck = true;
        while(gameCheck){
            player.playerInfo();
            System.out.println("1. Safe House");
            System.out.println("2. Toolstore");
            System.out.println("3. Cave");
            System.out.println("4. Forest");
            System.out.println("5. River");
            System.out.print("Please select a location: ");
            boolean validInput = false;
            while(!validInput){
                try{
                    int locationNumber = scan.nextInt();
                    if(locationNumber != 1 && locationNumber != 2 && locationNumber != 3 && locationNumber != 4 && locationNumber != 5)
                        throw new Exception("Please enter a valid number: ");
                    
                    switch(locationNumber) {
                        case 1:
                            location = new SafeHouse(player);
                            break;
                        case 2:
                            location = new Toolstore(player);
                            break;
                        case 3:
                            location = new Cave(player);
                            break;
                        case 4:
                            location = new Forest(player);
                            break;
                        case 5:
                            location = new River(player);
                            break;
                        default:
                            location = new SafeHouse(player);
                    }
                    validInput = true;
        
                }catch(Exception e){
                    System.out.print("Please enter a valid number: ");
                    scan.nextLine();
                }
            } 
            if(!location.onLocation()){
                System.out.println("You are died!");
                System.out.println("Game over!");
                gameCheck = false;
            }

        }
        
    }
}
