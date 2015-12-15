package cruiser;

import gunTool.ListGunTool;

public class MissileCruiser extends BaseCruiser {

    public MissileCruiser() {
        super(30, 60, "Ракетный крейсер");
        ListGunTool lgt = new ListGunTool();
        lgt.addMashineGunTool();
        lgt.addMissleTool();
    }

}
