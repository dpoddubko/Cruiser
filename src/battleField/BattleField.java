package battleField;

import cruiser.Cruiser;

import java.util.List;

public interface BattleField {
    int doRound();

    List<Cruiser> createCruisersForTeam();

    void logStateTeams();
}
