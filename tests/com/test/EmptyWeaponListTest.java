package com.test;

import cruiser.MissileCruiser;
import cruiserForTest.NullWeaponCruiser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmptyWeaponListTest {
    @Test
    public void emptyWeaponListTest() {
        NullWeaponCruiser emptyGunCruiser = new NullWeaponCruiser();
        MissileCruiser missileCruiser = new MissileCruiser();
        emptyGunCruiser.attack(missileCruiser);
        assertEquals(60, missileCruiser.getInitialLife());
    }
}
