package cruiser;

import gunTool.IGunTool;

import java.util.Optional;

public interface Cruiser {

    void goForward();

    void attack(Cruiser cruiser);

    void setLife(int life);

    void decreaseLife(int damage);

    boolean isAlive();

    String getName();

    int getLife();

    Optional<IGunTool> getBestGun();

}
