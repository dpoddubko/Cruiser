package battleField;

import cruiser.BaseCruiser;
import cruiser.CruiserHelicopterCarriers;
import cruiser.MissileCruiser;
import cruiser.ProtectedCruiser;

import java.util.ArrayList;

public class ShipsBuilder {
    private ArrayList<BaseCruiser> baseCruisersList = new ArrayList<>();
    public void addMissileCruiser() {
        baseCruisersList.add(new MissileCruiser());
    }

    public void addProtectedCruisers() {
        baseCruisersList.add(new ProtectedCruiser());
    }

    public void addCruiserHelicopterCarriers() {
        baseCruisersList.add(new CruiserHelicopterCarriers());
    }
    public ArrayList<BaseCruiser> getCruisersList() {
        return baseCruisersList;
    }


}
