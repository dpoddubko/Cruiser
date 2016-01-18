package cruiserForTest;

import cruiser.BaseCruiser;
import gunTool.WeaponBuilder;

public class NullWeaponCruiser extends BaseCruiser {
    public NullWeaponCruiser() {
        super(5, 10, "Крейсер без патронов", new WeaponBuilder().
                loadMissle(0).
                build());
    }
}
