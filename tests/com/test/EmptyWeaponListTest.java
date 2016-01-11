package com.test;

import cruiser.MissileCruiser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmptyWeaponListTest {
    @Test
    public void emptyWeaponListTest() {
        EmptyGunCruiser emptyGunCruiser = new EmptyGunCruiser();
        MissileCruiser missileCruiser = new MissileCruiser();
        emptyGunCruiser.attack(missileCruiser);
        assertEquals(60, missileCruiser.getInitialLife());
    }
}
