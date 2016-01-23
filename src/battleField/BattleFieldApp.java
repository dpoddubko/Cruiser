package battleField;

public class BattleFieldApp {
    public static void main(String[] args) {
        BaseBattleField battleField = new BaseBattleField(ShipsBuilder.createCruisers(), ShipsBuilder.createCruisers());
            battleField.fight();
    }
}
