package battleField;

import cruiser.Cruiser;

import java.util.List;

public interface BattleField {
    void fight();

    List<Cruiser> createCruisersForTeam();

    void logStateTeams();
}
