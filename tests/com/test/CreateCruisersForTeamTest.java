package com.test;

import battleField.ShipsBuilder;
import cruiser.Cruiser;
import cruiser.CruiserHelicopterCarriers;
import cruiser.MissileCruiser;
import cruiser.ProtectedCruiser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateCruisersForTeamTest {
    @Test
    public void createCruisersForTeamTest() {
        ShipsBuilder result = new ShipsBuilder();
        int mynum = (int) (Math.random() * 3);
        assertTrue(0 <= mynum && mynum <= 2);
        switch (mynum) {
            case 0:
                result.addMissileCruiser();
                break;
            case 1:
                result.addProtectedCruisers();
                break;
            case 2:
                result.addCruiserHelicopterCarriers();
                break;
        }
        Cruiser cruiser = result.getCruisersList().get(0);
        if (mynum == 0) assertEquals(cruiser, new MissileCruiser());
        if (mynum == 1) assertEquals(cruiser, new ProtectedCruiser());
        if (mynum == 2) assertEquals(cruiser, new CruiserHelicopterCarriers());
    }
}