package training;

import battleField.BaseBattleField;

public class BattleFieldApp {
    public static void main(String[] args) {
        BaseBattleField baseBattleField = new BaseBattleField();
        for (int i = 0; i < 12; i++) {
            baseBattleField.fight();
        }
    }
}
