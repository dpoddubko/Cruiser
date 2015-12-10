package cruiser;

abstract class AllCruiser implements Cruiser {
     int speed;
     int damage;

    AllCruiser(int speed, int damage) {
        this.speed = speed;
        this.damage = damage;
    }

    public abstract void goForward();

    public abstract void turnRight();

    public abstract void turnLeft();

    public abstract void attack();
}
