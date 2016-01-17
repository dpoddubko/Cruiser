package battleField;

import cruiser.Cruiser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class BaseBattleField implements BattleField {
    private final static Logger LOG = Logger.getLogger(BattleField.class);

    private ArrayList<Cruiser> whiteTeam;
    private ArrayList<Cruiser> blackTeam;
    private String massage = "Бой еще не окончен!";

    public BaseBattleField() {
        whiteTeam = createCruisersForTeam();
        blackTeam = createCruisersForTeam();
    }

    @Override
    public void fight() {
        if (whiteTeam.size() != 0 && blackTeam.size() != 0)
            for (int i = 0; i < 10; i++) {
                int rndWhite = randomNum(whiteTeam.size() - 1);
                int rndBlack = randomNum(blackTeam.size() - 1);
                whiteTeam.get(rndWhite).attack(blackTeam.get(rndBlack));
                if (!blackTeam.get(rndBlack).isAlive()) {
                    blackTeam.remove(rndBlack);
                    if (blackTeam.size() == 0) {
                        massage = "Белые победили!";
                        break;
                    }
                    rndBlack = randomNum(blackTeam.size() - 1);
                }
                blackTeam.get(rndBlack).attack(whiteTeam.get(rndWhite));
                if (!whiteTeam.get(rndWhite).isAlive()) {
                    whiteTeam.remove(rndWhite);
                    rndWhite = randomNum(whiteTeam.size() - 1);
                }
                if (whiteTeam.size() != 0 && blackTeam.size() == 0) {
                    massage = "Белые победили!";
                    break;
                }
                if (whiteTeam.isEmpty() && blackTeam.size() != 0) {
                    massage = "Черные победили!";
                    break;
                } else if (!hasChargeOfTeam(whiteTeam) && !hasChargeOfTeam(blackTeam)) {
                    if (whiteTeam.size() > blackTeam.size())
                        massage = "Белые победили!";
                    else if (whiteTeam.size() < blackTeam.size())
                        massage = "Черные победили!";
                    else if (whiteTeam.size() == blackTeam.size()) {
                        if (lifeSumOfTeam(whiteTeam) > lifeSumOfTeam(blackTeam))
                            massage = "Белые победили!";
                        else if (lifeSumOfTeam(whiteTeam) < lifeSumOfTeam(blackTeam))
                            massage = "Черные победили!";
                        else massage = "Победила ничья!";
                    }
                    break;
                }
            }
        logStateTeams();
    }

    @Override
    public ArrayList<Cruiser> createCruisersForTeam() {
        ShipsBuilder result = new ShipsBuilder();
        for (int i = 0; i < 10; i++) {
            int rnd = (int) (Math.random() * 3);
            switch (rnd) {
                case 0:
                    result.addMissileCruiser();
                    break;
                case 1:
                    result.addProtectedCruisers();
                    break;
                case 2:
                    result.addCruiserHelicopterCarriers();
                    break;
            }
        }
        return result.getCruisersList();
    }

    @Override
    public void logStateTeams() {
        LOG.info(stateTeams(getWhiteTeam(), "белых"));
        LOG.info(stateTeams(getBlackTeam(), "черных"));
        LOG.info(massage);
    }

    public String stateTeams(ArrayList<Cruiser> team, String colourOfTeam) {
        String result = new StringBuilder("\nКоманда ").
                append(colourOfTeam).
                append(":\n").
                append("Крейсер(ы), шт.: ").
                append(team.size()).
                append(".\n").
                append(listCruisersInfo(team)).
                toString();
        return result;
    }

    public StringBuilder listCruisersInfo(ArrayList<Cruiser> team) {
        StringBuilder out = new StringBuilder("");
        for (Cruiser cruiser : team)
            out.append(cruiser.getName()) .
                    append(". Осталось жизней: ").
                    append(cruiser.getLifes()).
                    append(".\n");
        return out;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public ArrayList<Cruiser> getWhiteTeam() {
        return whiteTeam;
    }

    public ArrayList<Cruiser> getBlackTeam() {
        return blackTeam;
    }

    public boolean hasChargeOfTeam(ArrayList<Cruiser> team) {
        boolean result = false;
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).getBestGun().get().hasCharge()) result = true;
        }
        return result;
    }

    public int lifeSumOfTeam(ArrayList<Cruiser> team) {
        int result = 0;
        for (int i = 0; i < team.size(); i++) {
            result += team.get(i).getLifes();
        }
        return result;
    }

    public int randomNum(int size) {
        return (int) Math.random() * size;
    }
}
