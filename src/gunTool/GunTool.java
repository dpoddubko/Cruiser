package gunTool;

import gun.*;

public class GunTool implements IGunTool {
    private int numberOfCharge;
    private Gun gun;

    public GunTool(int numberOfCharge, BombGun gun) {
        this.numberOfCharge = numberOfCharge;
        this.gun = gun;
    }

    public GunTool(int numberOfCharge, MachineGun gun) {
        this.numberOfCharge = numberOfCharge;
        this.gun = gun;
    }

    public GunTool(int numberOfCharge, MissileSystem gun) {
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
