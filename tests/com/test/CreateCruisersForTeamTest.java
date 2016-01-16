package com.test;

import battleField.BaseBattleField;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CreateCruisersForTeamTest {
    @Test
    public void createCruisersForTeamTest() {
        BaseBattleField baseBattleField = new BaseBattleField();
        int numOfCruiserWhiteTeam =
                baseBattleField.getWhiteTeam().getCruisersList().size();
        int numOfCruiserBlackTeam =
                baseBattleField.getBlackTeam().getCruisersList().size();
        assertEquals(10, numOfCruiserWhiteTeam);
        assertEquals(10, numOfCruiserBlackTeam);
    }
}