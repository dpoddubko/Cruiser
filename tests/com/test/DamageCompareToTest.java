package com.test;

import gun.BaseGun;
import gun.BombGun;
import gun.MachineGun;
import gun.MissileSystem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DamageCompareToTest {

    BaseGun machineGun = new MachineGun();
    BaseGun missileSystem = new MissileSystem();
    BaseGun bombGun = new BombGun();
    BaseGun bombGun2 = new BombGun();

    @Test
    public void damageCompareToTest() {
        assertEquals(1, machineGun.compareTo(bombGun));
        assertEquals(-1, bombGun.compareTo(missileSystem));
        assertEquals(0, bombGun.compareTo(bombGun2));
    }
}
