package cruiser;

import gunTool.WeaponBuilder;

public class CruiserHelicopterCarriers extends BaseCruiser {

    public CruiserHelicopterCarriers() {
        super(15, 90, "Крейсер-вертолетоносец");
        WeaponBuilder lgt = new WeaponBuilder();
        lgt.loadBomb(20);
        lgt.loadMashineGun(200);
    }
}