package gunTool;

import gun.Gun;
import gun.MachineGun;

public abstract class BaseGunTool implements IGunTool {
    private int numberOfCharge;
    private Gun gun;

    public BaseGunTool(int numberOfCharge, Gun gun) {
        this.numberOfCharge = numberOfCharge;
        this.gun = gun;
    }

    public Gun getGun() {
        return gun;
    }

    public int getCount() {
        return numberOfCharge;
    }

    public void decreaseCount() {
        numberOfCharge--;
    }
}
