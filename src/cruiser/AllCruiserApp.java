package cruiser;

/**
 * Created by dpoddubko on 10.12.2015.
 */
public class AllCruiserApp {
    public static void main(String[] args) {
       MissileCruiser missileCr = new MissileCruiser(30, 100);
        ProtectedCruisers protectedCr = new ProtectedCruisers(20, 100);
        CruiserHelicopterCarriers crHelicopter = new CruiserHelicopterCarriers(15, 100);
        AllCruiser cruiser;

        cruiser = missileCr;
        cruiser.goForward();
        cruiser.turnRight();
        cruiser.turnLeft();
        cruiser.attack();
        System.out.println("");
     System.out.println();
        cruiser = protectedCr;
        cruiser.goForward();
        cruiser.turnRight();
        cruiser.turnLeft();
        cruiser.attack();
        System.out.println("");

        cruiser = crHelicopter;
        cruiser.goForward();
        cruiser.turnRight();
        cruiser.turnLeft();
        cruiser.attack();
    }
}
