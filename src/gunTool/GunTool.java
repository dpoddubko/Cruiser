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
        int result = gun.compareTo(obj.getGun());//0, 1, -1

        if (result == 1 && obj.getNumberOfCharge() == 0 && getNumberOfCharge() == 0) return 1;
        if (result == 1 && obj.getNumberOfCharge() == 0 && getNumberOfCharge() > 0) return -1;
        if (result == 1 && obj.getNumberOfCharge() > 0 && getNumberOfCharge() == 0) return 1;
        if (result == 1 && obj.getNumberOfCharge() > 0 && getNumberOfCharge() > 0) return 1;

        if (result == 0 && obj.getNumberOfCharge() == getNumberOfCharge()) return 0;
        if (result == 0 && obj.getNumberOfCharge() == 0 && getNumberOfCharge() == 0) return 0;
        if (result == 0 && obj.getNumberOfCharge() == 0 && getNumberOfCharge() > 0) return -1;
        if (result == 0 && obj.getNumberOfCharge() > 0 && getNumberOfCharge() == 0) return 1;

        if (result == 0 && obj.getNumberOfCharge() > 0 && getNumberOfCharge() > 0 && obj.getNumberOfCharge() > getNumberOfCharge())
            return 1;
        if (result == 0 && obj.getNumberOfCharge() > 0 && getNumberOfCharge() > 0 && obj.getNumberOfCharge() < getNumberOfCharge())
            return -1;

        if (result == -1 && obj.getNumberOfCharge() == 0 && getNumberOfCharge() == 0) return -1;
        if (result == -1 && obj.getNumberOfCharge() == 0 && getNumberOfCharge() > 0) return -1;
        if (result == -1 && obj.getNumberOfCharge() > 0 && getNumberOfCharge() == 0) return 1;
        if (result == -1 && obj.getNumberOfCharge() > 0 && getNumberOfCharge() > 0) return -1;

        return -1;
    }

    @Override
    public boolean equals(Object o) {
        GunTool obj = (GunTool) o;
        if (this.compareTo(obj) == 0) return true;
        return false;
    }

    public String toString() {
        return "Количество патронов: " + numberOfCharge + ". " + gun.toString();
    }
}
