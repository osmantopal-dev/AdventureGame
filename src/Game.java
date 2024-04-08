import java.util.Scanner;


public class Game {

    private Scanner scan = new Scanner(System.in);
    private StringBuilder sb = new StringBuilder();

    public void start(){
        
        System.out.println("Welcome to adventure game!");
        System.out.print("Please enter your name: ");
        String playerName = scan.nextLine();
        Player player = new Player(playerName);
        player.selectChar();
        System.out.println(sb.append("Your character is ").append(player.getCharacterName()));
        
        

    }
}
