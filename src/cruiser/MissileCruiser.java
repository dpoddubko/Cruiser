package cruiser;

import gunTool.WeaponBuilder;

public class MissileCruiser extends BaseCruiser {

    public MissileCruiser() {
        super(30, 60, "Ракетный крейсер");
        WeaponBuilder lgt = new WeaponBuilder();
        lgt.loadMashineGun(150);
        lgt.loadMissle(10);
    }

}
