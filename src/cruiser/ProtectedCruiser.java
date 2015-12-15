package cruiser;

import gunTool.WeaponBuilder;

public class ProtectedCruiser extends BaseCruiser {

    public ProtectedCruiser() {
        super(20, 100, "Бронепалубный Крейсер");
        WeaponBuilder lgt = new WeaponBuilder();
        lgt.loadBomb(10);
        lgt.loadMashineGun(200);
        lgt.loadMissle(12);
    }
}
