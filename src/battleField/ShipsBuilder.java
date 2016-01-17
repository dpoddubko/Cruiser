package battleField;

import cruiser.*;

import java.util.ArrayList;
import java.util.List;

public class ShipsBuilder extends ArrayList<BaseCruiser> {
    private List<Cruiser> baseCruisersList = new ArrayList<>();
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


}
