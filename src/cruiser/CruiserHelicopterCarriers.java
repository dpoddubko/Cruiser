package cruiser;

import gunTool.WeaponBuilder;

public class CruiserHelicopterCarriers extends BaseCruiser {

    public CruiserHelicopterCarriers() {
        super(15, 90, "Крейсер-вертолетоносец", new WeaponBuilder().
                loadBomb(20).
                loadMashineGun(200).
                build());
    }
}