package cruiser;

class MissileCruiser extends AllCruiser{
    final String NAME = "Ракетный крейсер";

    public MissileCruiser() {
        setSpeed(30);
        setLifeSum(60);
        setName(this.NAME);
        setDamage(2);
    }
}
