package cruiser;

public abstract class BaseCruiser implements Cruiser {
    private final int speed;
    private final int initialLife;
    private final String name;
    private int lifeSum;

    public BaseCruiser(int speed, int initialLife, String name) {
        this.speed = speed;
        this.initialLife = initialLife;
        this.lifeSum = initialLife;
        this.name = name;
    }

    public void log(String msg) {
        System.out.println(msg);
    }

    public void goForward() {
        if (lifeSum > (initialLife / 3)) {
            log("Скорость передвижения крейсера: " +
                    speed + " узлов.");
        }
    }

    public boolean alive() {
        return lifeSum > 0;
    }

    public void decreaseLife(int damage) {
        lifeSum -= damage;
    }

    public void attack(Cruiser cruiser) {
        if (alive()) {
        }
    }

    public void display() {
        log(name + ": ");
        log("Скорость движения: " + speed + " узлов.");
        log("Начальное количество жизней: " + initialLife + ".");
        log("Оставшееся количество жизней: " + lifeSum + ".");
        log("");
    }
}
