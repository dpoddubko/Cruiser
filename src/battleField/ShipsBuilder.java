package battleField;

import cruiser.*;

import java.util.ArrayList;
import java.util.List;

public class ShipsBuilder extends ArrayList<BaseCruiser> {
    private List<Cruiser> baseCruisersList = new ArrayList<>();
    private static int randomSize = 3;
    public void addMissileCruiser() {
        baseCruisersList.add(new MissileCruiser());
    }

    public void addProtectedCruisers() {
        baseCruisersList.add(new ProtectedCruiser());
    }

    public void addCruiserHelicopterCarriers() {
        baseCruisersList.add(new CruiserHelicopterCarriers());
    }
    public List<Cruiser> build() {
        return baseCruisersList;
    }

    public static List<Cruiser> createCruisers() {
        ShipsBuilder result = new ShipsBuilder();
        for (int i = 0; i < 10; i++) {
            switch (chooseCruiser(randomSize)) {
                case 0:
                    result.addMissileCruiser();
                    break;
                case 1:
                    result.addProtectedCruisers();
                    break;
                case 2:
                    result.addCruiserHelicopterCarriers();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return result.build();
    }
    public static int chooseCruiser(int size) {
        return (int) (Math.random() * size);
    }
    public static void setRandomSize(int random) {
        randomSize = random;
    }
}
