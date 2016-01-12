package com.test;

import gun.BombGun;
import gun.MachineGun;
import gun.MissileSystem;
import gunTool.GunTool;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import static junit.framework.Assert.assertEquals;

public class OrderWeaponsTest {
    private final static Logger LOG = Logger.getLogger(OrderWeaponsTest.class);

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
        LOG.info(arrWeap);
        LOG.info(weaponSet);

        assertEquals(first, arrWeap[0]);
        assertEquals(second, arrWeap[1]);
        assertEquals(third, arrWeap[2]);
        assertEquals(fourth, arrWeap[3]);
        assertEquals(fifth, arrWeap[4]);
        assertEquals(sixth, arrWeap[5]);

    }

    @Test
    public void orderWeaponsListTest() {
        List<GunTool> weaponList = new ArrayList<>();
        GunTool third = new GunTool(20, new MissileSystem());
        weaponList.add(third);
        GunTool eighth = new GunTool(0, new MissileSystem());
        weaponList.add(eighth);
        GunTool fourth = new GunTool(10, new MissileSystem());
        weaponList.add(fourth);

        GunTool fifth = new GunTool(30, new MachineGun());
        weaponList.add(fifth);
        GunTool ninth = new GunTool(0, new MachineGun());
        weaponList.add(ninth);
        GunTool sixth = new GunTool(50, new MachineGun());
        weaponList.add(sixth);

        GunTool seventh = new GunTool(0, new BombGun());
        weaponList.add(seventh);
        GunTool first = new GunTool(70, new BombGun());
        weaponList.add(first);
        GunTool second = new GunTool(60, new BombGun());
        weaponList.add(second);

        Collections.sort(weaponList);

        LOG.info("\n" + weaponList);

        assertEquals(first, weaponList.get(0));
        assertEquals(second, weaponList.get(1));
        assertEquals(third, weaponList.get(2));
        assertEquals(fourth, weaponList.get(3));
        assertEquals(fifth, weaponList.get(4));
        assertEquals(sixth, weaponList.get(5));
        assertEquals(seventh, weaponList.get(6));
        assertEquals(eighth, weaponList.get(7));
        assertEquals(ninth, weaponList.get(8));

    }
}
