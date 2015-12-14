package cruiser;

interface Cruiser {

    void goForward();

    void turnRight();

    void turnLeft();

    void attack(Cruiser cruiser);

    void decreaseLife(int damage);
}
