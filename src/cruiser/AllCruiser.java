package cruiser;

public abstract class AllCruiser implements Cruiser {
    private final int speed;
    private final int initialLife;
    private final int damage;
    private final String name;
    private int lifeSum;

    public AllCruiser(int speed, int initialLife, String name, int damage) {
        this.speed = speed;
        this.initialLife = initialLife;
        this.lifeSum = initialLife;
        this.name = name;
        this.damage = damage;
    }

    public void log(String msg) {
        System.out.println(msg);
    }

    public void goForward() {
        if (lifeSum > (initialLife / 3)) {
            log("Скорость передвижения крейсера: " +
                    speed + " узлов.");
        } else {
            log("Крейсер двигаться не может");
        }
    }

    public boolean alive() {
        return lifeSum > 0;
    }

    public void turnRight() {

    }

    public void turnLeft() {

    }

    public void decreaseLife(int damage) {
        lifeSum-=damage;
    }

    @Override
    public void attack(Cruiser cruiser) {
        if (alive()) {
            cruiser.decreaseLife(damage);

        }
    }

    public void display() {
        log(name + ": ");
        log("Скорость движения: " + speed + " узлов.");
        log("Начальное количество жизней: " + initialLife + ".");
        log("Оставшееся количество жизней: " + lifeSum + ".");
        log("За один выстрел наносит урон " + damage + " бал(а).");
        log("");
    }
}
