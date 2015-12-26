package Training;

import gun.BombGun;
import gun.MachineGun;
import gun.MissileSystem;
import gunTool.GunTool;

import java.util.Set;
import java.util.TreeSet;

public class WeaponSetTraining {

    public static void main(String[] args) {
        TreeSet<GunTool> weaponSet = new TreeSet<GunTool>();
        weaponSet.add(new GunTool(30, new MissileSystem()));
        weaponSet.add(new GunTool(50, new MachineGun()));
        //weaponSet.add(new GunTool(0, new BombGun()));
        weaponSet.add(new GunTool(60, new BombGun()));

        displaySet(weaponSet);
        log("" + weaponSet.size());
        log(""+weaponSet.first());
    }

    public static void displaySet(Set<GunTool> weapon) {
        for (GunTool w : weapon) System.out.println(w);
        log("");

    }

    private static void log(String s) {
        System.out.println(s);
    }
}
