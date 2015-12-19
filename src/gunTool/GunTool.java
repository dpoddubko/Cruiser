package gunTool;

import gun.*;

public class GunTool implements IGunTool {
    private int numberOfCharge;
    private Gun gun;

    public GunTool(int numberOfCharge, Gun gun) {
        this.numberOfCharge = numberOfCharge;
        this.gun = gun;
    }

    public Gun getGun() {
        return gun;
    }

    public int getNumberOfCharge() {
        return numberOfCharge;
    }

    public void decreaseNumberOfCharge() {
        --this.numberOfCharge;
    }
}
