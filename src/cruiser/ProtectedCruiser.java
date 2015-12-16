package cruiser;

import gunTool.WeaponBuilder;

public class ProtectedCruiser extends BaseCruiser {

    public ProtectedCruiser() {
        super(20, 100, "Бронепалубный Крейсер", new WeaponBuilder().loadBomb(10).loadMashineGun(200).build());
    }
}
