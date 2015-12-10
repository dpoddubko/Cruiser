package cruiser;

class MissileCruiser extends AllCruiser{
     MissileCruiser(int i, int i1) {
        super(i, i1);
    }
    public void goForward(){
        System.out.println("Скорость передвижения Ракетного крейсера: "+
        speed + " узлов.");
    }

    public void turnRight(){
        System.out.println("Ракетный крейсер может поворачивать вправо, но его скорость падает до: "+
                (speed*0.8) + " узлов.");
    }

    public void turnLeft(){
        System.out.println("Ракетный крейсер может поворачивать влево, но его скорость падает до: "+
                (speed*0.8) + " узлов.");
    }

    public void attack(){
        System.out.println("Ракетный крейсер атакует - берегитесь!");
    }
}
