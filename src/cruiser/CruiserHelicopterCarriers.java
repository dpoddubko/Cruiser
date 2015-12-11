package cruiser;

public class CruiserHelicopterCarriers extends AllCruiser{
    final String NAME = "Крейсер-вертолетоносец";

    public CruiserHelicopterCarriers() {
        setSpeed(15);
        setLifeSum(90);
        setName(this.NAME);
        setDamage(3);
    }
}