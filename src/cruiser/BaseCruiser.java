package cruiser;

import gunTool.GunTool;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

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
        Optional<List<GunTool>> list = Optional.ofNullable(weaponsList);
        Optional<GunTool> bestGun = Optional.empty();
        int defoltDamage = 0;
        if (list.isPresent()) {
            for (GunTool w : weaponsList) {
                if (w.hasCharge() && w.getGun().getDamage() > defoltDamage) {
                    defoltDamage = w.getGun().getDamage();
                    bestGun = Optional.of(w);
                }
            }
        }
        return bestGun;
    }

    public void attack(Cruiser cruiser) {
        if (isAlive() && getBestGun().isPresent()) {
            cruiser.decreaseLife(getBestGun().get().getGun().getDamage());
            getBestGun().get().decreaseNumberOfCharge();
        }
    }

    public String toString() {
        String result = new StringBuilder("Название корабля: ").
                append(name).
                append(". Скорость движения: ").
                append(speed).
                append(" узлов. Начальное количество жизней: ").
                append(initialLife).
                append(". Оставшееся количество жизней: ").
                append(lifes).append(". \n").
                toString();
        return result;
    }
}