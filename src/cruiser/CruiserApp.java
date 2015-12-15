package cruiser;

public class CruiserApp {
    public static void main(String[] args) {
        ShipFactory factory = new ShipFactory();
        factory.addMissileCruiser();
        factory.addMissileCruiser();
        factory.addMissileCruiser();

        factory.addProtectedCruisers();
        factory.addProtectedCruisers();

        factory.addCruiserHelicopterCarriers();

        factory.displayAll();

        factory.getListMissileCr().get(1).attack(factory.getListProtectCr().get(1));
        factory.displayMissileCruisers();
        factory.displayProtectedCruisers();
    }
}
