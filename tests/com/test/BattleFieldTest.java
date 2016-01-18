package com.test;

import battleField.BaseBattleField;
import battleField.ShipsBuilder;
import cruiser.BaseCruiser;
import cruiser.Cruiser;
import cruiser.MissileCruiser;
import cruiser.ProtectedCruiser;
import cruiserForTest.NullWeaponCruiser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BattleFieldTest {
    @Test
    public void randomNumTest() {
        BaseBattleField battleField = new BaseBattleField();
        for (int i = 0; i < 10; i++) {
            int ranNum = battleField.chooseCruiser(10);
            assertTrue(0 <= ranNum && ranNum <= 9);
        }
        for (int i = 0; i < 10; i++) {
            int ranNum = battleField.chooseCruiser(0);
            assertEquals(0, ranNum);
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

    @Test
    public void teamsHaveNoChargeTest() {
        List<Cruiser> wTeam = new ArrayList<>();
        List<Cruiser> bTeam = new ArrayList<>();


        wTeam.add(new NullWeaponCruiser());
        wTeam.add(new NullWeaponCruiser());
        bTeam.add(new NullWeaponCruiser());
        BaseBattleField battleField = new BaseBattleField(wTeam, bTeam);

        assertEquals(3, battleField.teamsHaveNoCharge());
        bTeam.add(new NullWeaponCruiser());
        wTeam.remove(0);
        assertEquals(4, battleField.teamsHaveNoCharge());
        wTeam.add(new NullWeaponCruiser());
        assertEquals(7, battleField.teamsHaveNoCharge());
        wTeam.get(0).setLife(20);
        assertEquals(5, battleField.teamsHaveNoCharge());
        bTeam.get(0).setLife(30);
        assertEquals(6, battleField.teamsHaveNoCharge());
    }

    @Test
    public void attackTeam() {

        List<Cruiser> wTeam = new ArrayList<>();
        List<Cruiser> bTeam = new ArrayList<>();
        wTeam.add(new ProtectedCruiser());
        bTeam.add(new NullWeaponCruiser());
        bTeam.add(new NullWeaponCruiser());
        BaseBattleField battleField = new BaseBattleField(wTeam,bTeam);

        assertEquals(false, battleField.attack(wTeam, bTeam));
        assertEquals(true, battleField.attack(wTeam, bTeam));
    }

    @Test
    public void doRoundTest() {

        List<Cruiser> wTeam = new ArrayList<>();
        List<Cruiser> bTeam = new ArrayList<>();
        wTeam.add(new ProtectedCruiser());
        bTeam.add(new NullWeaponCruiser());
        BaseBattleField battleField = new BaseBattleField(wTeam,bTeam);
        assertEquals(1, battleField.doRound());

        List<Cruiser> wTeam1 = new ArrayList<>();
        List<Cruiser> bTeam1 = new ArrayList<>();
        wTeam1.add(new NullWeaponCruiser());
        bTeam1.add(new NullWeaponCruiser());
        BaseBattleField battleField1 = new BaseBattleField(wTeam1,bTeam1);
        assertEquals(7, battleField1.doRound());

        List<Cruiser> wTeam2 = new ArrayList<>();
        List<Cruiser> bTeam2 = new ArrayList<>();
        wTeam2.add(new NullWeaponCruiser());
        bTeam2.add(new NullWeaponCruiser());
        BaseBattleField battleField2 = new BaseBattleField(wTeam2,bTeam2);
        battleField2.getWhiteTeam().get(0).setLife(30);
        assertEquals(5, battleField2.doRound());
    }
}