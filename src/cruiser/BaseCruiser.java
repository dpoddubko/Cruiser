package cruiser;

import gunTool.GunTool;

import java.util.List;

public abstract class BaseCruiser implements Cruiser {
    private final int speed;
    private final int initialLife;
    private final String name;
    private final List<GunTool> weaponsList;

    private static int countFireGlob = 1;

    private int countFireCruiser = 0;
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

    public boolean alive() {
        return lifes > 0;
    }

    public void decreaseLife(int damage) {
        lifes -= damage;
    }

    public GunTool GetTheBestGun() {
        GunTool defoltGun = weaponsList.get(0);
        GunTool TheBestGun = null;
        int defoltDamage = 0;
        for (GunTool w : weaponsList) {
            if (w.getNumberOfCharge() > 0 && w.getGun().getDamage() > defoltDamage) {
                defoltDamage = w.getGun().getDamage();
                TheBestGun = w;
            } else {
                TheBestGun = defoltGun;
            }
        }
        return TheBestGun;
    }

    public void attack(Cruiser cruiser) {
        if (alive()) {
            if (countFireGlob > countFireCruiser) {
                if (GetTheBestGun().getNumberOfCharge() > 0) {
                    cruiser.decreaseLife(GetTheBestGun().getGun().getDamage());
                    GetTheBestGun().decreaseNumberOfCharge();
                }
                countFireGlob++;
                countFireCruiser = countFireGlob;
            }
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