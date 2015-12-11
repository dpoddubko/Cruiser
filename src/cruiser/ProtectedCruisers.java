package cruiser;

class ProtectedCruisers extends AllCruiser {
    final String NAME = "Бронепалубный Крейсер";

    public ProtectedCruisers() {
        setSpeed(20);
        setLifeSum(100);
        setName(this.NAME);
        setDamage(1);
    }
}
