package cruiser;

import gunTool.ListGunTool;

public class ProtectedCruiser extends BaseCruiser {

    public ProtectedCruiser() {
        super(20, 100, "Бронепалубный Крейсер");
        ListGunTool lgt = new ListGunTool();
        lgt.addBombGunTool();
        lgt.addMashineGunTool();
        lgt.addMissleTool();
    }
}
