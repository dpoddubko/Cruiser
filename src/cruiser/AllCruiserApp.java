package cruiser;

public class AllCruiserApp {
    public static void main(String[] args) {
        ShipFactory factory = new ShipFactory();
        factory.addMissileCruiser();
        factory.addMissileCruiser();
        factory.addMissileCruiser();

        factory.addProtectedCruisers();
        factory.addProtectedCruisers();

        factory.addCruiserHelicopterCarriers();

        factory.displayAll();

        System.out.println(factory.getListMissileCr());

        factory.listMissileCr.get(1).attack(factory.listMissileCr.get(2));
        factory.displayMissileCruisers();
    }
}
