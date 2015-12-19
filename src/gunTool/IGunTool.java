package gunTool;

import gun.Gun;

public interface IGunTool {
    Gun getGun();

    int getNumberOfCharge();

    void decreaseNumberOfCharge();
}
