package cruiser;

public class AllCruiserApp {
    public static void main(String[] args) {
        MissileCruiser missileCr = new MissileCruiser();
        ProtectedCruisers protectedCr = new ProtectedCruisers();
        CruiserHelicopterCarriers crHelicopter = new CruiserHelicopterCarriers();

        missileCr.display();
        protectedCr.display();
        crHelicopter.display();

        protectedCr.attack(MissileCruiser missileCr);



    }
}
