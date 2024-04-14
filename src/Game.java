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
        while(true){
            System.out.println("1. Safe House");
            System.out.println("2. Toolstore");
            System.out.print("Please select a location: ");
            boolean validInput = false;
            while(!validInput){
                try{
                    int locationNumber = scan.nextInt();
                    if(locationNumber != 1 && locationNumber != 2)
                        throw new Exception("Please enter a valid number: ");
                    
                    switch(locationNumber) {
                        case 1:
                            location = new SafeHouse(player);
                            break;
                        case 2:
                            location = new Toolstore(player);
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
            }

        }
        
    }
}
