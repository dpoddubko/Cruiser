package com.test;

import battleField.BaseBattleField;
import battleField.ShipsBuilder;
import cruiser.BaseCruiser;
import cruiser.Cruiser;
import cruiser.MissileCruiser;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class BattleFieldTest {
    @Test
    public void randomNumTest() {
        BaseBattleField battleField = new BaseBattleField();
        for (int i = 0; i < 10; i++) {
            int mynum = battleField.randomNum(10);
            assertTrue(0 <= mynum && mynum <= 9);
        }
        for (int i = 0; i < 10; i++) {
            int mynum = battleField.randomNum(0);
            assertEquals(0, mynum);
        }
    }

    @Test
    public void shipsBuilderNotNullTest() {
        ShipsBuilder shipsBuilder = new ShipsBuilder();
        assertNotNull(shipsBuilder.build());
    }

    @Test
    public void createCruisersForTeamTest() {
        BaseBattleField battleField = new BaseBattleField();
        assertNotNull(battleField.getBlackTeam());
        assertNotNull(battleField.getWhiteTeam());
        assertEquals(10, battleField.getWhiteTeam().size());
        assertEquals(10, battleField.getBlackTeam().size());
        for (Cruiser cruiser : battleField.getWhiteTeam()) {
            assertTrue(cruiser instanceof BaseCruiser);
        }
        battleField.setRandomSize(0);
        List<Cruiser> list = battleField.createCruisersForTeam();
        for (Cruiser cruiser : list) assertTrue(cruiser.getClass().equals(MissileCruiser.class));
    }
}