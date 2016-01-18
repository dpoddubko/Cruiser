package battleField;

import cruiser.Cruiser;
import exeption.IllegalValueException;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;

import java.util.List;

public class BaseBattleField implements BattleField {
    private final static Logger LOG = Logger.getLogger(BattleField.class);
    private final static int NUMBER = 10;

    private List<Cruiser> whiteTeam;
    private List<Cruiser> blackTeam;
    private int randomSize = 3;

    public BaseBattleField() {
        whiteTeam = createCruisersForTeam();
        blackTeam = createCruisersForTeam();
    }

    public BaseBattleField(List<Cruiser> whiteTeam, List<Cruiser> blackTeam) {
        this.whiteTeam = whiteTeam;
        this.blackTeam = blackTeam;
    }

    public void fight() {
        logStateTeams();

        while (canFight()) {
            doRound();
            logStateTeams();
        }
    }

    @Override
    public int doRound() {
        for (int i = 0; i < NUMBER; i++) {
            if (attack(whiteTeam, blackTeam)) {
                LOG.info("У черных закончились корабли. Белые победили!");
                return 1;
            }
            if (attack(blackTeam, whiteTeam)) {
                LOG.info("У белых закончились корабли. Черные победили!");
                return 2;
            }
            if (!hasCharge(whiteTeam) && !hasCharge(blackTeam)) {
                return teamsHaveNoCharge();
            }
        }
        LOG.info("И вновь продолжается бой!");
        return 0;
    }

    public boolean attack(List<Cruiser> attacker, List<Cruiser> victim) {
        int rndAttacker = chooseCruiser(attacker.size() - 1);
        int rndVictim = chooseCruiser(victim.size() - 1);
        attacker.get(rndAttacker).attack(victim.get(rndVictim));
        if (!victim.get(rndVictim).isAlive()) {
            victim.remove(rndVictim);
            if (victim.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public int teamsHaveNoCharge() {
        if (whiteTeam.size() > blackTeam.size()) {
            LOG.info("У команд нет патронов, но белых кораблей осталось больше. Белые победили!");
            return 3;
        } else if (whiteTeam.size() < blackTeam.size()) {
            LOG.info("У команд нет патронов, но черных кораблей осталось больше. Черные победили!");
            return 4;
        } else if (whiteTeam.size() == blackTeam.size()) {
            if (lifeSumOfTeam(whiteTeam) > lifeSumOfTeam(blackTeam)) {
                LOG.info("У команд нет патронов, количество кораблей одинаковое, но у белых больше жизней. Белые победили!");
                return 5;
            } else if (lifeSumOfTeam(whiteTeam) < lifeSumOfTeam(blackTeam)) {
                LOG.info("У команд нет патронов, количество кораблей одинаковое, но у черных больше жизней. Черные победили!");
                return 6;
            } else
                LOG.info("У команд нет патронов, количество кораблей одинаковое, количество жизней одинаковое. Победила ничья!");
        }
        return 7;
    }

    @Override
    public List<Cruiser> createCruisersForTeam() {
        ShipsBuilder result = new ShipsBuilder();
        for (int i = 0; i < NUMBER; i++) {
            switch (chooseCruiser(randomSize)) {
                case 0:
                    result.addMissileCruiser();
                    break;
                case 1:
                    result.addProtectedCruisers();
                    break;
                case 2:
                    result.addCruiserHelicopterCarriers();
                    break;
                default:
                    throw new IllegalValueException();
            }
        }
        return result.build();
    }

    @Override
    public void logStateTeams() {
        LOG.info(stateTeams(getWhiteTeam(), "белых"));
        LOG.info(stateTeams(getBlackTeam(), "черных"));

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

    public boolean canFight() {
        return (hasCharge(whiteTeam) || hasCharge(blackTeam)) &&
                (!whiteTeam.isEmpty() && !blackTeam.isEmpty());
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

    public boolean hasCharge(List<Cruiser> team) {
        for (Cruiser cruiser : team) {
            if (cruiser.getBestGun().isPresent()) return true;
        }
        return false;
    }

    public int lifeSumOfTeam(List<Cruiser> team) {
        int result = 0;
        for (Cruiser cruiser : team) result += cruiser.getLife();
        return result;
    }

    public int chooseCruiser(int size) {
        return (int) (Math.random() * size);
    }

    public void setRandomSize(int randomSize) {
        this.randomSize = randomSize;
    }
}
