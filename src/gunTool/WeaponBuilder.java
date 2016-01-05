package gunTool;

import gun.BombGun;
import gun.MachineGun;
import gun.MissileSystem;

import java.util.ArrayList;
import java.util.List;

public class WeaponBuilder {
    private List<GunTool> weaponList = new ArrayList<>();

    public WeaponBuilder loadMissle(int numOfCharge) {
        weaponList.add(new GunTool(numOfCharge, new MissileSystem()));
        return this;
    }

    public WeaponBuilder loadBomb(int numOfCharge) {
        weaponList.add(new GunTool(numOfCharge, new BombGun()));
        return this;
    }

    public WeaponBuilder loadMashineGun(int numOfCharge) {
        weaponList.add(new GunTool(numOfCharge, new MachineGun()));
        return this;
    }

    public List<GunTool> build() {
        return weaponList;
    }

}