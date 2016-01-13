package cruiser;

import gunTool.GunTool;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class BaseCruiser implements Cruiser {
    private final int speed;
    private final int initialLife;
    private final String name;
    private final List<GunTool> weaponsList;
    private final static Logger LOG = Logger.getLogger(BaseCruiser.class);

    private int lifes;

    public BaseCruiser(int speed, int initialLife, String name, List<GunTool> weaponsList) {
        this.speed = speed;
        this.initialLife = initialLife;
        this.lifes = initialLife;
        this.name = name;
        this.weaponsList = weaponsList == null ? new ArrayList<GunTool>() : weaponsList;
    }

    public List<GunTool> getWeaponsList() {
        return weaponsList;
    }

    public void goForward() {
        if (lifes > (initialLife / 3)) {
            LOG.info("Скорость передвижения крейсера: " +
                    speed + " узлов.");
        }
    }

    public int getInitialLife() {
        return initialLife;
    }

    public boolean isAlive() {
        return lifes > 0;
    }

    public void decreaseLife(int damage) {
        lifes -= damage;
    }

    public Optional<GunTool> getBestGun() {
        Optional<GunTool> bestGun = Optional.empty();
        for (GunTool w : weaponsList) {
            if (w.hasCharge()) {
                if (!bestGun.isPresent()) bestGun = Optional.of(w);
                else if (w.getGun().getDamage() > bestGun.get().getGun().getDamage())
                    bestGun = Optional.of(w);
            }
        }
        return bestGun;
    }

    public void attack(Cruiser cruiser) {
        if (isAlive()) {
            Optional<GunTool> bestGun = getBestGun();
            if (bestGun.isPresent()) {
                cruiser.decreaseLife(bestGun.get().getGun().getDamage());
                bestGun.get().decreaseNumberOfCharge();
            }
        }
    }

    public String toString() {
        return new ToStringBuilder(this).
                append("Название корабля ", name).
                append(" скорость движения", speed).
                append(" начальное количество жизней", initialLife).
                append(" оставшееся количество жизней", lifes).
                append("\n").
                toString();
    }
}