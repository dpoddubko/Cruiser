package com.test;

import cruiser.MissileCruiser;
import cruiser.ProtectedCruiser;
import gun.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeaponsSetTest {
    @Test
    public void weaponsSetTest() {
        MissileCruiser missileCruiser = new MissileCruiser();
        ProtectedCruiser protectedCruiser = new ProtectedCruiser();

        BombGun bombGun = new BombGun();
        MissileSystem missileSystem = new MissileSystem();

        int numberOfChargeProtectedCr = protectedCruiser.getBestGun().getNumberOfCharge();
        Gun bestGunOfProtectedCr = protectedCruiser.getBestGun().getGun();
        assertEquals(bombGun, bestGunOfProtectedCr);
        assertEquals(10, protectedCruiser.getBestGun().getNumberOfCharge());

        missileCruiser.display();
        for (int i = 0; i < numberOfChargeProtectedCr; i++)
            protectedCruiser.attack(missileCruiser);

        assertEquals(missileSystem, protectedCruiser.getBestGun().getGun());
        assertEquals(25, protectedCruiser.getBestGun().getNumberOfCharge());
    }
}