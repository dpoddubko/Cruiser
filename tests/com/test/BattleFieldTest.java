package com.test;

import battleField.BaseBattleField;
import battleField.ShipsBuilder;
import battleField.Variants;
import cruiser.BaseCruiser;
import cruiser.Cruiser;
import cruiser.MissileCruiser;
import cruiser.ProtectedCruiser;
import cruiserForTest.NullWeaponCruiser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static battleField.ShipsBuilder.*;
import static org.junit.Assert.*;

public class BattleFieldTest {

    @Test
    public void randomNumTest() {
        for (int i = 0; i < 10; i++) {
            int ranNum = chooseCruiser(10);
            assertTrue(0 <= ranNum && ranNum <= 9);
        }
        for (int i = 0; i < 10; i++) {
            int ranNum = chooseCruiser(0);
            assertEquals(0, ranNum);
        }
    }



    @Test
    public void shipsBuilderNotNullTest() {
        ShipsBuilder shipsBuilder = new ShipsBuilder();
        assertNotNull(shipsBuilder.build());
    }

    @Test
    public void createCruisersTest() {
        BaseBattleField battleField = new BaseBattleField(createCruisers(), createCruisers());
        assertNotNull(battleField.getBlackTeam());
        assertNotNull(battleField.getWhiteTeam());
        assertEquals(10, battleField.getWhiteTeam().size());
        assertEquals(10, battleField.getBlackTeam().size());
        for (Cruiser cruiser : battleField.getWhiteTeam()) {
            assertTrue(cruiser instanceof BaseCruiser);
        }
        ShipsBuilder.setRandomSize(0);
        List<Cruiser> list = ShipsBuilder.createCruisers();
        for (Cruiser cruiser : list) assertTrue(cruiser.getClass().equals(MissileCruiser.class));

    }

    @Test
    public void doRoundNoChargeTest() {
        List<Cruiser> wTeam = new ArrayList<>();
        List<Cruiser> bTeam = new ArrayList<>();


        wTeam.add(new NullWeaponCruiser());
        wTeam.add(new NullWeaponCruiser());
        bTeam.add(new NullWeaponCruiser());
        BaseBattleField battleField = new BaseBattleField(wTeam, bTeam);

        assertEquals(Variants.WHITE_TEAM_WIN, battleField.doRound());
        bTeam.add(new NullWeaponCruiser());
        wTeam.remove(0);
        assertEquals(Variants.BLACK_TEAM_WIN, battleField.doRound());
        wTeam.add(new NullWeaponCruiser());
        assertEquals(Variants.TIE, battleField.doRound());
        wTeam.get(0).setLife(20);
        assertEquals(Variants.WHITE_TEAM_WIN, battleField.doRound());
        bTeam.get(0).setLife(30);
        assertEquals(Variants.BLACK_TEAM_WIN, battleField.doRound());
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
        assertEquals(Variants.WHITE_TEAM_WIN, battleField.doRound());

        List<Cruiser> wTeam1 = new ArrayList<>();
        List<Cruiser> bTeam1 = new ArrayList<>();
        wTeam1.add(new NullWeaponCruiser());
        bTeam1.add(new NullWeaponCruiser());
        BaseBattleField battleField1 = new BaseBattleField(wTeam1,bTeam1);
        assertEquals(Variants.TIE, battleField1.doRound());

        List<Cruiser> wTeam2 = new ArrayList<>();
        List<Cruiser> bTeam2 = new ArrayList<>();
        wTeam2.add(new NullWeaponCruiser());
        bTeam2.add(new NullWeaponCruiser());
        BaseBattleField battleField2 = new BaseBattleField(wTeam2,bTeam2);
        battleField2.getWhiteTeam().get(0).setLife(30);
        assertEquals(Variants.WHITE_TEAM_WIN, battleField2.doRound());
    }

}