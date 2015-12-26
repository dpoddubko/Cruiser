package gunTool;

import gun.Gun;

public class GunTool implements IGunTool, Comparable<GunTool> {
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

    @Override
    public int compareTo(GunTool obj) {
        if (numberOfCharge <= 0) return 0;
        return gun.compareTo(obj.getGun());
    }

    public String toString() {
        return "Количество патронов: " + numberOfCharge + ". " + gun.toString();
    }
}
