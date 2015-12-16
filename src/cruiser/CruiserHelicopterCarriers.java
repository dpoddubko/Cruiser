package cruiser;

import gunTool.GunTool;
import gunTool.WeaponBuilder;

import java.util.List;

public class CruiserHelicopterCarriers extends BaseCruiser {

    public CruiserHelicopterCarriers() {
        super(15, 90, "Крейсер-вертолетоносец", new WeaponBuilder().
                loadBomb(20).
                loadMashineGun(200).
                build());
    }
}