package cruiser;

import gunTool.GunTool;

import java.util.Collections;
import java.util.List;

public abstract class BaseCruiser implements Cruiser {
    private final int speed;
    private final int initialLife;
    private final String name;

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

    public void log(String msg) {
        System.out.println(msg);
    }

    public void goForward() {
        if (lifes > (initialLife / 3)) {
            log("Скорость передвижения крейсера: " +
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
        GunTool bestGun = weaponsList.get(0);
        if (bestGun.getNumberOfCharge() == 0) {
            Collections.sort(weaponsList);
            return weaponsList.get(0);
        }
        return bestGun;
    }

    public void attack(Cruiser cruiser) {
        if (isAlive() && getBestGun().hasCharge()) {
            cruiser.decreaseLife(getBestGun().getGun().getDamage());
            getBestGun().decreaseNumberOfCharge();
        }
    }

    public void display() {
        log(name + ": ");
        log("Скорость движения: " + speed + " узлов.");
        log("Начальное количество жизней: " + initialLife + ".");
        log("Оставшееся количество жизней: " + lifes + ".");
        log("");
    }
}