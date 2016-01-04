package cruiser;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ShipFactory {
    final static Logger log = Logger.getLogger(ShipFactory.class);
    private List<MissileCruiser> listMissileCr = new ArrayList<MissileCruiser>();
    private List<ProtectedCruiser> listProtectCr = new ArrayList<ProtectedCruiser>();
    private List<CruiserHelicopterCarriers> listHelicopterCr = new ArrayList<CruiserHelicopterCarriers>();

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
        log.info("\n" + listMissileCr);
    }

    public void displayProtectedCruisers() {
        log.info("\n" + listProtectCr);
    }

    public void displaylistHelicopterCrs() {
        log.info("\n" + listHelicopterCr);
    }

    public void displayAll() {
        displayMissileCruisers();
        displayProtectedCruisers();
        displaylistHelicopterCrs();
    }
}

