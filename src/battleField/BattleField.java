package battleField;

import cruiser.Cruiser;

import java.util.ArrayList;

public interface BattleField {
    void fight();

    ArrayList<Cruiser> createCruisersForTeam();

    void logStateTeams();
}
