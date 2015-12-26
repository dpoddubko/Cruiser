package com.test;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import gun.BaseGun;
import gun.BombGun;
import gun.MachineGun;
import gun.MissileSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {
    BaseGun machineGun = new MachineGun();
    BaseGun missileSystem = new MissileSystem();
    BaseGun bombGun = new BombGun();

    @Test
    public void sortTrueDamageTest() {
        List<BaseGun> list = new ArrayList<BaseGun>();
        list.add(missileSystem);
        list.add(machineGun);
        list.add(bombGun);
        Collections.sort(list);
        for (int i = 0; i < list.size()-1; i++) {
            assertTrue(list.get(i).getDamage() > list.get(i + 1).getDamage());
        }
    }
}