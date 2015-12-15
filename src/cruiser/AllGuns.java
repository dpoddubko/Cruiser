package cruiser;

public abstract class AllGuns implements GunsOfCruisers{
    private final String nameOfGun;
    private final int damage;
    private final int distanceOfFire;

    public AllGuns(String nameOfGun, int damage, int distanceOfFire) {
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
}
