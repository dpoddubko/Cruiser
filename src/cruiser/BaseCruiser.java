package cruiser;

import gunTool.GunTool;

import java.util.Set;

public abstract class BaseCruiser implements Cruiser {
    private final int speed;
    private final int initialLife;
    private final String name;
    private final Set<GunTool> weaponsList;

    private int lifes;

    public BaseCruiser(int speed, int initialLife, String name, Set<GunTool> weaponsList) {
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

   /*
    public GunTool getBestGun() {
        GunTool defoltGun = weaponsList.get(0);
        GunTool bestGun = null;
        int defoltDamage = 0;
        for (GunTool w : weaponsList) {
            if (w.hasCharge() && w.getGun().getDamage() > defoltDamage) {
                defoltDamage = w.getGun().getDamage();
                bestGun = w;
            } else {
                bestGun = defoltGun;
            }
        }
        return bestGun;
    }

    public void attack(Cruiser cruiser) {
        if (alive() && getBestGun().hasCharge()) {
            cruiser.decreaseLife(getBestGun().getGun().getDamage());
            getBestGun().decreaseNumberOfCharge();
        }
    }
*/
    public void display() {
        log(name + ": ");
        log("Скорость движения: " + speed + " узлов.");
        log("Начальное количество жизней: " + initialLife + ".");
        log("Оставшееся количество жизней: " + lifes + ".");
        log("");
    }
}