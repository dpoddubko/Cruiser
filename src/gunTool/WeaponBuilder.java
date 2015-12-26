package gunTool;

import gun.BombGun;
import gun.MachineGun;
import gun.MissileSystem;

import java.util.TreeSet;

public class WeaponBuilder {
    private TreeSet<GunTool> weapon = new TreeSet<GunTool>();

    public WeaponBuilder loadMissle(int numOfCharge) {
        weapon.add(new GunTool(numOfCharge, new MissileSystem()));
        return this;
    }

    public WeaponBuilder loadBomb(int numOfCharge) {
        weapon.add(new GunTool(numOfCharge, new BombGun()));
        return this;
    }

    public WeaponBuilder loadMashineGun(int numOfCharge) {
        weapon.add(new GunTool(numOfCharge, new MachineGun()));
        return this;
    }

    public TreeSet<GunTool> build() {
        return weapon;
    }

}