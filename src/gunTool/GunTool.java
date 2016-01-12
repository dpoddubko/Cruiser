package gunTool;

import exeption.MinusException;
import gun.Gun;

public class GunTool implements IGunTool, Comparable<GunTool> {
    private int numberOfCharge;
    private Gun gun;

    public GunTool(int numberOfCharge, Gun gun) {
        this.gun = gun;
        try {
            if (numberOfCharge<0) throw new MinusException();
            this.numberOfCharge = numberOfCharge;
        }catch(MinusException e){
            System.out.println(e);
        }
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
        try {
            if (numberOfCharge<0) throw new MinusException();
            --numberOfCharge;
        }catch (MinusException e){
            numberOfCharge=0;
        }
    }

    @Override
    public int compareTo(GunTool obj) {
        if (obj.getNumberOfCharge() == 0 ^ getNumberOfCharge() == 0) {
            if (obj.getNumberOfCharge() != 0) return 1;
            return -1;
        }
        return gun.compareTo(obj.getGun());
    }

    @Override
    public boolean equals(Object o) {
        GunTool obj = (GunTool) o;
        return this.compareTo(obj) == 0;
    }

    @Override
    public int hashCode() {
        int result = numberOfCharge;
        result = 31 * result + (gun != null ? gun.hashCode() : 0);
        return result;
    }

    public String toString() {
        String result = new StringBuilder("Количество патронов: ").
                append(numberOfCharge).
                append(". ").
                append(gun.toString()).
                toString();
        return result;
    }
}
