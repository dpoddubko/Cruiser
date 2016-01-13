package gun;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class BaseGun implements Gun, Comparable {
    private final String nameOfGun;
    private final int damage;
    private final int distanceOfFire;

    public BaseGun(String nameOfGun, int damage, int distanceOfFire) {
        this.nameOfGun = nameOfGun;
        this.damage = damage;
        this.distanceOfFire = distanceOfFire;
    }

    public String getNameOfGun() {
        return nameOfGun;
    }

    public int getDamage() {
        return damage;
    }

    public int getDistanceOfFire() {
        return distanceOfFire;
    }

    @Override
    public int compareTo(Object obj) {
        BaseGun entry = (BaseGun) obj;
        return new CompareToBuilder()
                .append(entry.damage, this.damage)
                .toComparison();
    }

    public String toString() {
        return new ToStringBuilder(this).
                append("Имя оружия", nameOfGun).
                append(" урон оружия", damage).
                append(" радиус поражения", distanceOfFire).
                append("\n").
                toString();
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object o) {
        BaseGun baseGun = (BaseGun) o;
        return EqualsBuilder.reflectionEquals(this, baseGun);

    }
}
