package cruiser;

public class CruiserApp {
    public static void main(String[] args) {
        ShipFactory factory = new ShipFactory();
        factory.addMissileCruiser();
        factory.addProtectedCruisers();
        factory.getListMissileCr().get(0).attack(factory.getListProtectCr().get(0));
        factory.displayAll();
        System.out.println(factory.getListMissileCr().get(0).getBestGun().toString());
    }
}
