package cruiser;

import gunTool.ListGunTool;

public class CruiserHelicopterCarriers extends BaseCruiser {

    public CruiserHelicopterCarriers() {
        super(15, 90, "Крейсер-вертолетоносец");
        ListGunTool lgt = new ListGunTool();
        lgt.addBombGunTool();
        lgt.addMashineGunTool();
    }
}