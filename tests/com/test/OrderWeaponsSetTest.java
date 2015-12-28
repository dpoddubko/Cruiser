package com.test;

import gun.BombGun;
import gun.MachineGun;
import gun.MissileSystem;
import gunTool.GunTool;
import org.junit.Test;

import java.util.TreeSet;

import static junit.framework.Assert.assertEquals;

public class OrderWeaponsSetTest {
    @Test
    public void orderWeaponsSetTest() {
        TreeSet<GunTool> weaponSet = new TreeSet<GunTool>();

        GunTool third = new GunTool(20, new MissileSystem());
        weaponSet.add(third);
        GunTool eighth = new GunTool(0, new MissileSystem());
        weaponSet.add(eighth);
        GunTool fourth = new GunTool(10, new MissileSystem());
        weaponSet.add(fourth);

        GunTool sixth = new GunTool(10, new MachineGun());
        weaponSet.add(sixth);
        GunTool fifth = new GunTool(20, new MachineGun());
        weaponSet.add(fifth);
        GunTool ninth = new GunTool(0, new MachineGun());
        weaponSet.add(ninth);

        GunTool first = new GunTool(20, new BombGun());
        weaponSet.add(first);
        GunTool second = new GunTool(10, new BombGun());
        weaponSet.add(second);
        GunTool seventh = new GunTool(0, new BombGun());
        weaponSet.add(seventh);

        GunTool arrWeap[] = new GunTool[weaponSet.size()];
        arrWeap = weaponSet.toArray(arrWeap);

        assertEquals(first, arrWeap[0]);
        assertEquals(second, arrWeap[1]);
        assertEquals(third, arrWeap[2]);
        assertEquals(fourth, arrWeap[3]);
        assertEquals(fifth, arrWeap[4]);
        assertEquals(sixth, arrWeap[5]);
        assertEquals(seventh, arrWeap[6]);
        assertEquals(eighth, arrWeap[7]);
        assertEquals(ninth, arrWeap[8]);

    }

    public static void displaySet(TreeSet<GunTool> weaponSet) {
        for (GunTool w : weaponSet) log("weaponSet element: " + w);
        log("");
    }

    public static void displayArr(GunTool arrWeap[]) {
        for (GunTool wep : arrWeap) log("GunTool element: " + wep);
        log("");
    }

    private static void log(String s) {
        System.out.println(s);
    }
}
