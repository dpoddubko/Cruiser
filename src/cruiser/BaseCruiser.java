package cruiser;

import gunTool.GunTool;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.List;

public abstract class BaseCruiser implements Cruiser {
    private final int speed;
    private final int initialLife;
    private final String name;
    final static Logger LOG = Logger.getLogger(BaseCruiser.class);

    public List<GunTool> getWeaponsList() {
        return weaponsList;
    }

    private List<GunTool> weaponsList;

    private int lifes;

    public BaseCruiser(int speed, int initialLife, String name, List<GunTool> weaponsList) {
        this.speed = speed;
        this.initialLife = initialLife;
        this.lifes = initialLife;
        this.name = name;
        this.weaponsList = weaponsList;
    }

    public void goForward() {
        if (lifes > (initialLife / 3)) {
            LOG.info("Скорость передвижения крейсера: " +
                    speed + " узлов.");
        }
    }

    public boolean isAlive() {
        return lifes > 0;
    }

    public void decreaseLife(int damage) {
        lifes -= damage;
    }

    public GunTool getBestGun() {
        Collections.sort(weaponsList);
        return weaponsList.get(0);
    }

    public void attack(Cruiser cruiser) {
        if (isAlive() && getBestGun().hasCharge()) {
            cruiser.decreaseLife(getBestGun().getGun().getDamage());
            getBestGun().decreaseNumberOfCharge();
        }
    }

    public String toString() {
        return "Название корабля: " + name + ". Скорость движения: " + speed + " узлов" + ". Начальное количество жизней: " + initialLife + ". Оставшееся количество жизней: " + lifes + ". \n";
    }
}