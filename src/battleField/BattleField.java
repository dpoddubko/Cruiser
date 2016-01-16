package battleField;

public interface BattleField {
    void fight();

    ShipsBuilder createCruisersForTeam();

    void logStateTeams();
}
