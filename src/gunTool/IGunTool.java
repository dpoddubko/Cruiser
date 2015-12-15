package gunTool;

import gun.Gun;

public interface IGunTool {
    Gun getGun();

    int getCount();

    void decreaseCount();
}
