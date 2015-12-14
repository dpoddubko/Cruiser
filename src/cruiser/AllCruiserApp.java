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
        System.out.println(factory.getListProtectCr());

        factory.listMissileCr.get(1).attack(factory.listProtectCr.get(1));
        factory.displayMissileCruisers();
        factory.displayProtectedCruisers();
    }
}
