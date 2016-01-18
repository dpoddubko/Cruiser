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
            int ranNum = battleField.randomNum(10);
            assertTrue(0 <= ranNum && ranNum <= 9);
        }
        for (int i = 0; i < 10; i++) {
            int ranNum = battleField.randomNum(0);
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
        BaseBattleField battleField = new BaseBattleField();
        List<Cruiser> wTeam = new ArrayList<>();
        List<Cruiser> bTeam = new ArrayList<>();
        wTeam.add(new NullWeaponCruiser());
        wTeam.add(new NullWeaponCruiser());
        bTeam.add(new NullWeaponCruiser());
        battleField.setWhiteTeam(wTeam);
        battleField.setBlackTeam(bTeam);
        battleField.teamsHaveNoCharge();
        assertEquals("У команд нет патронов, но белых кораблей осталось больше. Белые победили!", battleField.getMassage());
        bTeam.add(new NullWeaponCruiser());
        wTeam.remove(0);
        battleField.teamsHaveNoCharge();
        assertEquals("У команд нет патронов, но черных кораблей осталось больше. Черные победили!", battleField.getMassage());
        wTeam.add(new NullWeaponCruiser());
        battleField.teamsHaveNoCharge();
        assertEquals("У команд нет патронов, количество кораблей одинаковое, количество жизней одинаковое. Победила ничья!", battleField.getMassage());
        wTeam.get(0).setLife(20);
        battleField.teamsHaveNoCharge();
        assertEquals("У команд нет патронов, количество кораблей одинаковое, но у белых больше жизней. Белые победили!", battleField.getMassage());
        bTeam.get(0).setLife(30);
        battleField.teamsHaveNoCharge();
        assertEquals("У команд нет патронов, количество кораблей одинаковое, но у черных больше жизней. Черные победили!", battleField.getMassage());
    }

    @Test
    public void attackTeam() {
        BaseBattleField battleField = new BaseBattleField();
        List<Cruiser> wTeam = new ArrayList<>();
        List<Cruiser> bTeam = new ArrayList<>();
        wTeam.add(new ProtectedCruiser());
        bTeam.add(new NullWeaponCruiser());
        bTeam.add(new NullWeaponCruiser());
        battleField.setWhiteTeam(wTeam);
        battleField.setBlackTeam(bTeam);
        assertEquals(false, battleField.attackTeam(wTeam, bTeam));
        assertEquals(true, battleField.attackTeam(wTeam, bTeam));
    }

    @Test
    public void fightTest() {
        BaseBattleField battleField = new BaseBattleField();
        List<Cruiser> wTeam = new ArrayList<>();
        List<Cruiser> bTeam = new ArrayList<>();
        wTeam.add(new ProtectedCruiser());
        bTeam.add(new NullWeaponCruiser());
        battleField.setWhiteTeam(wTeam);
        battleField.setBlackTeam(bTeam);
        battleField.doRound();
        assertEquals("У черных закончились корабли. Белые победили!", battleField.getMassage());

        List<Cruiser> wTeam1 = new ArrayList<>();
        List<Cruiser> bTeam1 = new ArrayList<>();
        wTeam1.add(new NullWeaponCruiser());
        bTeam1.add(new NullWeaponCruiser());
        battleField.setWhiteTeam(wTeam1);
        battleField.setBlackTeam(bTeam1);
        battleField.doRound();
        assertEquals("У команд нет патронов, количество кораблей одинаковое, количество жизней одинаковое. Победила ничья!", battleField.getMassage());

        List<Cruiser> wTeam2 = new ArrayList<>();
        List<Cruiser> bTeam2 = new ArrayList<>();
        wTeam2.add(new NullWeaponCruiser());
        bTeam2.add(new NullWeaponCruiser());
        battleField.setWhiteTeam(wTeam2);
        battleField.setBlackTeam(bTeam2);
        battleField.getWhiteTeam().get(0).setLife(30);
        battleField.doRound();
        assertEquals("У команд нет патронов, количество кораблей одинаковое, но у белых больше жизней. Белые победили!", battleField.getMassage());
    }
}