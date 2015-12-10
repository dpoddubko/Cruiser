package cruiser;

class ProtectedCruisers extends AllCruiser{
    public ProtectedCruisers(int i, int i1) {
        super(i, i1);
    }
    public void goForward(){
        System.out.println("Скорость передвижения Бронепалубного крейсера: "+
                speed + " узлов.");
    }

    public void turnRight(){
        System.out.println("Бронепалубный крейсер может поворачивать вправо, но его скорость падает до: "+
                (speed*0.8) + " узлов.");
    }

    public void turnLeft(){
        System.out.println("Бронепалубный крейсер может поворачивать влево, но его скорость падает до: "+
                (speed*0.8) + " узлов.");
    }

    public void attack(){
        System.out.println("Бронепалубный крейсер атакует - берегитесь!");
    }
}
