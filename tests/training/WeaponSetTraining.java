package training;

import gun.BombGun;
import gun.MachineGun;
import gun.MissileSystem;
import gunTool.GunTool;
import org.apache.log4j.Logger;

import java.util.TreeSet;

public class WeaponSetTraining {
    final static Logger log = Logger.getLogger(WeaponSetTraining.class);
    public static void main(String[] args) {
        TreeSet<GunTool> weaponSet = new TreeSet<GunTool>();
        weaponSet.add(new GunTool(30, new MissileSystem()));
        weaponSet.add(new GunTool(50, new MachineGun()));
        weaponSet.add(new GunTool(10, new BombGun()));
        weaponSet.add(new GunTool(60, new BombGun()));

        log.info(weaponSet);
        log.info(weaponSet.size());
        log.info(weaponSet.first());
    }
}
