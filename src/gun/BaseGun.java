package gun;

public abstract class BaseGun implements Gun, Comparable {
    private final String nameOfGun;
    private final int damage;
    private final int distanceOfFire;

    public BaseGun(String nameOfGun, int damage, int distanceOfFire) {
        this.nameOfGun = nameOfGun;
        this.damage = damage;
        this.distanceOfFire = distanceOfFire;
    }

    public String getNameOfGun() {
        return nameOfGun;
    }

    public int getDamage() {
        return damage;
    }

    public int getDistanceOfFire() {
        return distanceOfFire;
    }

    @Override
    public int compareTo(Object obj) {
        BaseGun entry = (BaseGun) obj;

        int result = entry.damage-damage;
        if (result != 0) {
            return (int) result / Math.abs(result);
        }
        return 0;
    }
}
