public class Toolstore extends NormalLocation {

    public Toolstore(Player player) {
        super(player, "Toolstore");
    }

    @Override
    public boolean onLocation(){
        System.out.println("Welcome to Toolstore!");
        return true;
    }
    
}