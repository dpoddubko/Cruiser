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


        GunTool fifth = new GunTool(0, new MissileSystem());
        weaponSet.add(fifth);
        GunTool second = new GunTool(10, new MissileSystem());
        weaponSet.add(second);

        GunTool third = new GunTool(200, new MachineGun());
        weaponSet.add(third);
        GunTool sixth = new GunTool(0, new MachineGun());
        weaponSet.add(sixth);

        GunTool first = new GunTool(15, new BombGun());
        weaponSet.add(first);
        GunTool fourth = new GunTool(0, new BombGun());
        weaponSet.add(fourth);

        GunTool arrWeap[] = new GunTool[weaponSet.size()];
        arrWeap = weaponSet.toArray(arrWeap);
        displayArr(arrWeap);
        displaySet(weaponSet);

        assertEquals(first, arrWeap[0]);
        assertEquals(second, arrWeap[1]);
        assertEquals(third, arrWeap[2]);
        assertEquals(fourth, arrWeap[3]);
        assertEquals(fifth, arrWeap[4]);
        assertEquals(sixth, arrWeap[5]);

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
