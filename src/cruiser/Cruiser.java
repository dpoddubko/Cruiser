package cruiser;

import gunTool.IGunTool;

import java.util.Optional;

public interface Cruiser {

    void goForward();

    void attack(Cruiser cruiser);

    void decreaseLife(int damage);
    boolean isAlive();
    String getName();
    int getLifes();
    Optional<IGunTool> getBestGun();

}
