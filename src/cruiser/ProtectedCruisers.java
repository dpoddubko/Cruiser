package cruiser;

class ProtectedCruisers extends AllCruiser {
    private static final String NAME = "Бронепалубный Крейсер";

    public ProtectedCruisers() {
        setSpeed(20);
        setLifeSum(100);
        setName(this.NAME);
        setDamage(1);
    }
}
