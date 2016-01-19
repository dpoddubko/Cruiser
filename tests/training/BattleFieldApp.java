package training;

import battleField.BaseBattleField;
import battleField.ShipsBuilder;

public class BattleFieldApp {
    public static void main(String[] args) {
        BaseBattleField battleField = new BaseBattleField(ShipsBuilder.createCruisers(), ShipsBuilder.createCruisers());
            battleField.fight();
    }
}
