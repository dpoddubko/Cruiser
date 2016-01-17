package cruiser;

import battleField.ShipsBuilder;

public class CruiserApp {
    public static void main(String[] args) {
        ShipsBuilder factory = new ShipsBuilder();
        factory.addMissileCruiser();
        factory.addMissileCruiser();
        factory.addProtectedCruisers();
        factory.addProtectedCruisers();
        factory.addProtectedCruisers();
        factory.build().get(0).attack(factory.build().get(1));
    }
}
