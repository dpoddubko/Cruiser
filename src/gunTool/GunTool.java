package gunTool;

import gun.*;

import java.util.Comparator;

public class GunTool implements IGunTool {
    private int numberOfCharge;
    private Gun gun;

    public GunTool(int numberOfCharge, Gun gun) {
        this.numberOfCharge = numberOfCharge;
        this.gun = gun;
    }

    public boolean hasCharge() {
        return numberOfCharge > 0;
    }

    public Gun getGun() {
        return gun;
    }

    public int getNumberOfCharge() {
        return numberOfCharge;
    }

    public void decreaseNumberOfCharge() {
        if (numberOfCharge > 0)
            --numberOfCharge;
    }
}
