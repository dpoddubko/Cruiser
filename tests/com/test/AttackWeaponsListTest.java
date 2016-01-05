package com.test;

import cruiser.MissileCruiser;
import cruiser.ProtectedCruiser;
import gun.BombGun;
import gun.Gun;
import gun.MissileSystem;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AttackWeaponsListTest {
    final static Logger LOG = Logger.getLogger(AttackWeaponsListTest.class);

    @Test
    public void weaponsListTest() {
        MissileCruiser missileCruiser = new MissileCruiser();
        ProtectedCruiser protectedCruiser = new ProtectedCruiser();

        BombGun bombGun = new BombGun();
        MissileSystem missileSystem = new MissileSystem();

        int numberOfChargeProtectedCr = protectedCruiser.getBestGun().getNumberOfCharge();
        Gun bestGunOfProtectedCr = protectedCruiser.getBestGun().getGun();
        assertEquals(bombGun, bestGunOfProtectedCr);
        assertEquals(10, protectedCruiser.getBestGun().getNumberOfCharge());

        LOG.info("\n" + missileCruiser);
        for (int i = 0; i < numberOfChargeProtectedCr + 1; i++)
            protectedCruiser.attack(missileCruiser);
        LOG.info("\n" + protectedCruiser.getWeaponsList());

        assertEquals(missileSystem, protectedCruiser.getBestGun().getGun());
        assertEquals(24, protectedCruiser.getBestGun().getNumberOfCharge());

    }
}