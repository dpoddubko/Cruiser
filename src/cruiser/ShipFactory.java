package cruiser;

import java.util.LinkedList;
import java.util.List;

public class ShipFactory {
    private List<MissileCruiser> listMissileCr = new LinkedList<MissileCruiser>();
    private List<ProtectedCruiser> listProtectCr = new LinkedList<ProtectedCruiser>();
    private List<CruiserHelicopterCarriers> listHelicopterCr = new LinkedList<CruiserHelicopterCarriers>();

    public List<MissileCruiser> getListMissileCr() {
        return listMissileCr;
    }

    public List<ProtectedCruiser> getListProtectCr() {
        return listProtectCr;
    }

    public List<CruiserHelicopterCarriers> getListHelicopterCr() {
        return listHelicopterCr;
    }

    public void addMissileCruiser() {
        listMissileCr.add(new MissileCruiser());
    }

    public void addProtectedCruisers() {
        listProtectCr.add(new ProtectedCruiser());
    }

    public void addCruiserHelicopterCarriers() {
        listHelicopterCr.add(new CruiserHelicopterCarriers());
    }

    public void displayMissileCruisers() {
        for (MissileCruiser lm : listMissileCr)
            lm.display();
    }

    public void displayProtectedCruisers() {
        for (ProtectedCruiser lp : listProtectCr)
            lp.display();
    }

    public void displaylistHelicopterCrs() {
        for (CruiserHelicopterCarriers lh : listHelicopterCr)
            lh.display();
    }

    public void displayAll() {
        displayMissileCruisers();
        displayProtectedCruisers();
        displaylistHelicopterCrs();
    }
}

