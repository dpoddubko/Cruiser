package com.test;

import cruiser.MissileCruiser;
import cruiser.ProtectedCruiser;
import gun.BombGun;
import gun.Gun;
import gun.MissileSystem;
import gunTool.GunTool;
import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class AttackWeaponsSetTest {
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
        for (int i = 0; i < numberOfChargeProtectedCr + 1; i++)
            protectedCruiser.attack(missileCruiser);
        displayWeaponSet(protectedCruiser.getWeaponsSet());

        assertEquals(missileSystem, protectedCruiser.getBestGun().getGun());
        assertEquals(24, protectedCruiser.getBestGun().getNumberOfCharge());
    }

    public static void displayWeaponSet(TreeSet<GunTool> weaponSet) {
        for (GunTool w : weaponSet) System.out.println("weaponSet element: " + w);
        System.out.println("");
    }
}