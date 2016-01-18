package battleField;

import cruiser.Cruiser;

import java.util.List;

public interface BattleField {
    void doRound();

    List<Cruiser> createCruisersForTeam();

    void logStateTeams();
}
