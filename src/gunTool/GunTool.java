package gunTool;

import gun.BombGun;
import gun.MachineGun;
import gun.MissileSystem;

public class GunTool extends BaseGunTool {
    public GunTool(BombGun gun) {
        super(10, gun);
    }

    public GunTool(MachineGun gun) {
        super(300, gun);
    }

    public GunTool(MissileSystem gun) {
        super(15, gun);
    }
}
