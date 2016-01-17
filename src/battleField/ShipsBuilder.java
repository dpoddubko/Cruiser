package battleField;

import cruiser.*;

import java.util.ArrayList;

public class ShipsBuilder extends ArrayList<BaseCruiser> {
    private ArrayList<Cruiser> baseCruisersList = new ArrayList<>();
    public void addMissileCruiser() {
        baseCruisersList.add(new MissileCruiser());
    }

    public void addProtectedCruisers() {
        baseCruisersList.add(new ProtectedCruiser());
    }

    public void addCruiserHelicopterCarriers() {
        baseCruisersList.add(new CruiserHelicopterCarriers());
    }
    public ArrayList<Cruiser> build() {
        return baseCruisersList;
    }


}
