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

        int result = entry.damage - damage;
        if (result != 0) {
            return (int) result / Math.abs(result);
        }
        return 0;
    }

    public String toString() {
        String result = new StringBuilder("Имя оружия: ").
                append(nameOfGun).
                append(". Урон, наносимый оружием: ").
                append(damage).
                append(". Радиус поражения: ").
                append(distanceOfFire).
                append(".\n").
                toString();
        return result;
    }

    @Override
    public int hashCode() {
        int result = nameOfGun != null ? nameOfGun.hashCode() : 0;
        result = 31 * result + damage;
        result = 31 * result + distanceOfFire;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseGun baseGun = (BaseGun) o;
        if (damage != baseGun.damage) return false;
        if (distanceOfFire != baseGun.distanceOfFire) return false;
        return !(nameOfGun != null ? !nameOfGun.equals(baseGun.nameOfGun) : baseGun.nameOfGun != null);
    }
}
