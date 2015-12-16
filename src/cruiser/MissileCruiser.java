package cruiser;

import gunTool.WeaponBuilder;

public class MissileCruiser extends BaseCruiser {

    public MissileCruiser() {
        super(30, 60, "Ракетный крейсер", new WeaponBuilder().loadMashineGun(150).loadMissle(10).build());
    }
}
