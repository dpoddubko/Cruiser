package cruiser;

import gunTool.GunTool;

import java.util.TreeSet;

public abstract class BaseCruiser implements Cruiser {
    private final int speed;
    private final int initialLife;
    private final String name;

    public void setWeaponsSet(TreeSet<GunTool> weaponsSet) {
        this.weaponsSet = weaponsSet;
    }

    public TreeSet<GunTool> getWeaponsSet() {
        return weaponsSet;
    }

    private TreeSet<GunTool> weaponsSet;

    private int lifes;

    public BaseCruiser(int speed, int initialLife, String name, TreeSet<GunTool> weaponsSet) {
        this.speed = speed;
        this.initialLife = initialLife;
        this.lifes = initialLife;
        this.name = name;
        this.weaponsSet = weaponsSet;
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

    public void sortWeaponsSet(TreeSet<GunTool> weaponsSet) {
        TreeSet<GunTool> newWeaponSet = new TreeSet<GunTool>();
        GunTool arrWeap[] = new GunTool[weaponsSet.size()];
        arrWeap = weaponsSet.toArray(arrWeap);
        for (GunTool w : arrWeap) newWeaponSet.add(w);
        setWeaponsSet(newWeaponSet);
    }

    public GunTool getBestGun() {
        GunTool bestGun = weaponsSet.first();
        if (bestGun.getNumberOfCharge() == 0) {
            sortWeaponsSet(weaponsSet);
            return weaponsSet.first();
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