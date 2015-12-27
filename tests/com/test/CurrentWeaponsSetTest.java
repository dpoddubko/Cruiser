package com.test;

import gun.BombGun;
import gun.MachineGun;
import gun.MissileSystem;
import gunTool.GunTool;
import org.junit.Test;

import java.util.TreeSet;

public class CurrentWeaponsSetTest {
    @Test
    public void weaponsSetFalseTest(){
        TreeSet<GunTool> weaponSet = new TreeSet<GunTool>();

        weaponSet.add(new GunTool(20, new MissileSystem()));
        weaponSet.add(new GunTool(0, new MissileSystem()));
        weaponSet.add(new GunTool(10, new MissileSystem()));

        weaponSet.add(new GunTool(10, new MachineGun()));
        weaponSet.add(new GunTool(20, new MachineGun()));
        weaponSet.add(new GunTool(0, new MachineGun()));

        weaponSet.add(new GunTool(20, new BombGun()));
        weaponSet.add(new GunTool(10, new BombGun()));
        weaponSet.add(new GunTool(0, new BombGun()));

        displaySet(weaponSet);

    }
    public static void displaySet(TreeSet<GunTool> weaponSet) {
        for (GunTool w : weaponSet) System.out.println(w);
        log("");
    }

    private static void log(String s) {
        System.out.println(s);
    }
}
