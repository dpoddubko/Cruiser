package gunTool;

import exeption.NegativeSignException;
import gun.Gun;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class GunTool implements IGunTool, Comparable<GunTool> {
    private int numberOfCharge;
    private Gun gun;

    public GunTool(int numberOfCharge, Gun gun) {
        this.gun = gun;
        if (numberOfCharge < 0) throw new NegativeSignException();
        this.numberOfCharge = numberOfCharge;
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
        if (numberOfCharge == 0) throw new NegativeSignException();
        --numberOfCharge;
    }

    @Override
    public int compareTo(GunTool obj) {
        if ((obj.getNumberOfCharge() == 0 && getNumberOfCharge() != 0)
                || (obj.getNumberOfCharge() != 0 && getNumberOfCharge() == 0)) {
            if (obj.getNumberOfCharge() != 0) return 1;
            return -1;
        }
        return gun.compareTo(obj.getGun());
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object o) {
        GunTool baseGun = (GunTool) o;
        return EqualsBuilder.reflectionEquals(this, baseGun);

    }

    public String toString() {
        return new ToStringBuilder(this).
                append("Количество патронов", numberOfCharge).
                append(gun.toString()).
                toString();
    }
}
