package cruiser;

import java.util.LinkedList;

public class ShipFactory {
    LinkedList<MissileCruiser> listMissileCr = new LinkedList<MissileCruiser>();
    LinkedList<ProtectedCruiser> listProtectCr = new LinkedList<ProtectedCruiser>();
    LinkedList<CruiserHelicopterCarriers> listHelicopterCr = new LinkedList<CruiserHelicopterCarriers>();

    void addMissileCruiser() {
        listMissileCr.add(new MissileCruiser());
    }

    void addProtectedCruisers() {
        listProtectCr.add(new ProtectedCruiser());
    }

    void addCruiserHelicopterCarriers() {
        listHelicopterCr.add(new CruiserHelicopterCarriers());
    }

    //---------display--------
    void displayMissileCruisers() {
        for (MissileCruiser lm : listMissileCr)
            lm.display();
    }

    void displayProtectedCruisers() {
        for (ProtectedCruiser lp : listProtectCr)
            lp.display();
    }

    void displaylistHelicopterCrs() {
        for (CruiserHelicopterCarriers lh : listHelicopterCr)
            lh.display();
    }

    void displayAll() {
        displayMissileCruisers();
        displayProtectedCruisers();
        displaylistHelicopterCrs();
    }

    //--------------------------
    int getListMissileCr() {
        return listMissileCr.size();
    }

    int getListProtectCr() {
        return listProtectCr.size();
    }

    int getListHelicopterCr() {
        return listHelicopterCr.size();
    }
}

