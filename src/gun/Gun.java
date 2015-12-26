package gun;

public interface Gun {
    String getNameOfGun();

    int getDamage();

    int getDistanceOfFire();

    int compareTo(Object obj);
}
