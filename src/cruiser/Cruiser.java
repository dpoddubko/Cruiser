package cruiser;

public interface Cruiser {

    void goForward();

    void attack(Cruiser cruiser);

    void decreaseLife(int damage);

}
