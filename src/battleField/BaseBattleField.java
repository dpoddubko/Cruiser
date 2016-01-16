package battleField;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;

public class BaseBattleField implements BattleField {
    private final static Logger LOG = Logger.getLogger(BattleField.class);

    private ShipsBuilder whiteTeam;
    private ShipsBuilder blackTeam;
    private String massage = "Бой еще не окончен!";

    public BaseBattleField() {
        whiteTeam = createCruisersForTeam();
        blackTeam = createCruisersForTeam();
    }

    @Override
    public void fight() {
        int wSize=whiteTeam.getCruisersList().size();
        int bSize=blackTeam.getCruisersList().size();

        if(wSize != 0 && bSize != 0)
        for (int i = 0; i < 10; i++) {
            int rndWhite = randomNum(wSize - 1);
            int rndBlack = randomNum(bSize - 1);
            whiteTeam.getCruisersList().get(rndWhite).attack(blackTeam.getCruisersList().get(rndBlack));
            if (!blackTeam.getCruisersList().get(rndBlack).isAlive()) {
                blackTeam.getCruisersList().remove(rndBlack);
                if (blackTeam.getCruisersList().size()==0){
                massage = "Белые победили!";
                break;
                }
                rndBlack = randomNum(blackTeam.getCruisersList().size() - 1);

            }
            blackTeam.getCruisersList().get(rndBlack).attack(whiteTeam.getCruisersList().get(rndWhite));
            if (!whiteTeam.getCruisersList().get(rndWhite).isAlive()) {
                whiteTeam.getCruisersList().remove(rndWhite);
                rndWhite = randomNum(whiteTeam.getCruisersList().size() - 1);
            }

            if (whiteTeam.getCruisersList().size() != 0 && blackTeam.getCruisersList().size() == 0) {
                massage = "Белые победили!";
                break;
            }
            if (whiteTeam.getCruisersList().size() == 0 && blackTeam.getCruisersList().size() != 0) {
                massage = "Черные победили!";
                break;
            } else if (!hasChargeOfTeam(whiteTeam) && !hasChargeOfTeam(blackTeam)) {
                if (whiteTeam.getCruisersList().size() > blackTeam.getCruisersList().size())
                    massage = "Белые победили!";
                else if (whiteTeam.getCruisersList().size() < blackTeam.getCruisersList().size())
                    massage = "Черные победили!";
                else if (whiteTeam.getCruisersList().size() == blackTeam.getCruisersList().size()) {
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
    public ShipsBuilder createCruisersForTeam() {
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
        return result;
    }

    @Override
    public void logStateTeams() {
        LOG.info(StateTeams(getWhiteTeam(), "белых"));
        LOG.info(StateTeams(getBlackTeam(), "черных"));
        LOG.info(massage);
    }

    public String StateTeams(ShipsBuilder team, String colourOfTeam) {
        String result = new StringBuilder("\nКоманда ").
                append(colourOfTeam).
                append(":\n").
                append("Крейсер(ы), шт.: ").
                append(team.getCruisersList().size()).
                append(".\n").
                append(listCruisersInfo(team)).
                toString();
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public ShipsBuilder getWhiteTeam() {
        return whiteTeam;
    }

    public ShipsBuilder getBlackTeam() {
        return blackTeam;
    }

    public String listCruisersInfo(ShipsBuilder team) {
        String result = "";
        for (int i = 0; i < team.getCruisersList().size(); i++)
            result += new StringBuilder("№ ").
                    append(i + 1).
                    append(". ").
                    append(team.getCruisersList().get(i).getName()).
                    append(". Осталось жизней: ").
                    append(team.getCruisersList().get(i).getLifes()).
                    append(".\n").
                    toString();

        return result;
    }

    public boolean hasChargeOfTeam(ShipsBuilder team) {
        boolean result = false;
        for (int i = 0; i < team.getCruisersList().size(); i++) {
            if (team.getCruisersList().get(i).getBestGun().get().hasCharge()) result = true;
        }
        return result;
    }

    public int lifeSumOfTeam(ShipsBuilder team) {
        int result = 0;
        for (int i = 0; i < team.getCruisersList().size(); i++) {
            result += team.getCruisersList().get(i).getLifes();
        }
        return result;
    }
    public int randomNum(int size){
        return (int) Math.random() * size;
    }
}
