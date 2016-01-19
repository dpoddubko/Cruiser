package battleField;

import cruiser.Cruiser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;

import java.util.List;

public class BaseBattleField implements BattleField {
    private final static Logger LOG = Logger.getLogger(BattleField.class);
    private final static int NUMBER = 10;

    private List<Cruiser> whiteTeam;
    private List<Cruiser> blackTeam;


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
    public Variants doRound() {
        for (int i = 0; i < NUMBER; i++) {
            if (attack(whiteTeam, blackTeam)) {
                return Variants.WHITE_TEAM_WIN;
            }
            if (attack(blackTeam, whiteTeam)) {
                return Variants.BLACK_TEAM_WIN;
            }
            if (!hasCharge(whiteTeam) && !hasCharge(blackTeam)) {
                int whiteSize = whiteTeam.size();
                int blackSize = blackTeam.size();
                int whiteLife = lifeSumOfTeam(whiteTeam);
                int blackLife = lifeSumOfTeam(blackTeam);
                if (whiteSize > blackSize) {
                    return Variants.WHITE_TEAM_WIN;
                } else if (whiteSize < blackSize) {
                    return Variants.BLACK_TEAM_WIN;
                } else if (whiteSize == blackSize) {
                    if (whiteLife > blackLife) {
                        return Variants.WHITE_TEAM_WIN;
                    } else if (whiteLife < blackLife) {
                        return Variants.BLACK_TEAM_WIN;
                    }
                }
                return Variants.TIE;
            }
        }
        return Variants.CONTINUE;
    }

    public boolean attack(List<Cruiser> attacker, List<Cruiser> victim) {
        int rndAttacker = ShipsBuilder.chooseCruiser(attacker.size() - 1);
        int rndVictim = ShipsBuilder.chooseCruiser(victim.size() - 1);
        attacker.get(rndAttacker).attack(victim.get(rndVictim));
        if (!victim.get(rndVictim).isAlive()) {
            victim.remove(rndVictim);
            if (victim.isEmpty()) {
                return true;
            }
        }
        return false;
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
        StringBuilder out = new StringBuilder();
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
}
