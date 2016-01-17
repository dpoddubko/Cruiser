package battleField;

import cruiser.Cruiser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;

import java.util.List;

public class BaseBattleField implements BattleField {
    private final static Logger LOG = Logger.getLogger(BattleField.class);

    private List<Cruiser> whiteTeam;
    private List<Cruiser> blackTeam;
    private String massage = "Бой еще не окончен!";
    private int randomSize = 3;

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
                    if (whiteTeam.size() > blackTeam.size()) {
                        massage = "Белые победили!";
                        break;
                    } else if (whiteTeam.size() < blackTeam.size()) {
                        massage = "Черные победили!";
                        break;
                    } else if (whiteTeam.size() == blackTeam.size()) {
                        if (lifeSumOfTeam(whiteTeam) > lifeSumOfTeam(blackTeam)) {
                            massage = "Белые победили!";
                            break;
                        } else if (lifeSumOfTeam(whiteTeam) < lifeSumOfTeam(blackTeam)) {
                            massage = "Черные победили!";
                            break;
                        } else massage = "Победила ничья!";
                    }
                    break;
                }
            }
        logStateTeams();
    }

    @Override
    public List<Cruiser> createCruisersForTeam() {
        ShipsBuilder result = new ShipsBuilder();
        for (int i = 0; i < 10; i++) {
            switch (randomNum(randomSize)) {
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
        return result.build();
    }

    @Override
    public void logStateTeams() {
        LOG.info(stateTeams(getWhiteTeam(), "белых"));
        LOG.info(stateTeams(getBlackTeam(), "черных"));
        LOG.info(massage);
    }

    public String stateTeams(List<Cruiser> team, String colourOfTeam) {
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

    public StringBuilder listCruisersInfo(List<Cruiser> team) {
        StringBuilder out = new StringBuilder("");
        for (Cruiser cruiser : team)
            out.append(cruiser.getName()).
                    append(". Осталось жизней: ").
                    append(cruiser.getLifes()).
                    append(".\n");
        return out;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public List<Cruiser> getWhiteTeam() {
        return whiteTeam;
    }

    public List<Cruiser> getBlackTeam() {
        return blackTeam;
    }

    public boolean hasChargeOfTeam(List<Cruiser> team) {
        boolean result = false;
        for (Cruiser cruiser : team) if (cruiser.getBestGun().get().hasCharge()) result = true;
        return result;
    }

    public int lifeSumOfTeam(List<Cruiser> team) {
        int result = 0;
        for (Cruiser cruiser : team) result += cruiser.getLifes();
        return result;
    }

    public int randomNum(int size) {
        return (int) (Math.random() * size);
    }

    public void setRandomSize(int randomSize) {
        this.randomSize = randomSize;
    }
}
