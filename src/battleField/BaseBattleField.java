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
                if (attackTeam(whiteTeam, blackTeam) == 0) {
                    massage = "У черных закончились корабли. Белые победили!";
                    break;
                }
                if (attackTeam(blackTeam, whiteTeam) == 0) {
                    massage = "У белых закончились корабли. Черные победили!";
                    break;
                }
                if (!hasChargeOfTeam(whiteTeam) && !hasChargeOfTeam(blackTeam)) {
                    teamsHaveNoCharge();
                    break;
                }
            }
        logStateTeams();
    }

    public int attackTeam(List<Cruiser> attacker, List<Cruiser> victim) {
        int rndAttacker = randomNum(attacker.size() - 1);
        int rndVictim = randomNum(victim.size() - 1);
        attacker.get(rndAttacker).attack(victim.get(rndVictim));
        if (!victim.get(rndVictim).isAlive()) {
            victim.remove(rndVictim);
            if (victim.isEmpty()) {
                return 0;
            }
        }
        return 1;
    }

    public void teamsHaveNoCharge() {
        if (whiteTeam.size() > blackTeam.size()) {
            massage = "У команд нет патронов, но белых кораблей осталось больше. Белые победили!";
        } else if (whiteTeam.size() < blackTeam.size()) {
            massage = "У команд нет патронов, но черных кораблей осталось больше. Черные победили!";
        } else if (whiteTeam.size() == blackTeam.size()) {
            if (lifeSumOfTeam(whiteTeam) > lifeSumOfTeam(blackTeam)) {
                massage = "У команд нет патронов, количество кораблей одинаковое, но у белых больше жизней. Белые победили!";
            } else if (lifeSumOfTeam(whiteTeam) < lifeSumOfTeam(blackTeam)) {
                massage = "У команд нет патронов, количество кораблей одинаковое, но у черных больше жизней. Черные победили!";
            } else
                massage = "У команд нет патронов, количество кораблей одинаковое, количество жизней одинаковое. Победила ничья!";
        }
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
        String result = new StringBuilder("\n\nКоманда ").
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
                    append(cruiser.getLife()).
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
        for (Cruiser cruiser : team) {
            if (cruiser.getBestGun().isPresent()) result = true;
            break;
        }
        return result;
    }

    public int lifeSumOfTeam(List<Cruiser> team) {
        int result = 0;
        for (Cruiser cruiser : team) result += cruiser.getLife();
        return result;
    }

    public int randomNum(int size) {
        return (int) (Math.random() * size);
    }

    public void setRandomSize(int randomSize) {
        this.randomSize = randomSize;
    }

    public void setWhiteTeam(List<Cruiser> whiteTeam) {
        this.whiteTeam = whiteTeam;
    }

    public void setBlackTeam(List<Cruiser> blackTeam) {
        this.blackTeam = blackTeam;
    }

    public String getMassage() {
        return massage;
    }
}
