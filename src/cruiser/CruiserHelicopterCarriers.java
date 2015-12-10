package cruiser;

/**
 * Created by dpoddubko on 10.12.2015.
 */
public class CruiserHelicopterCarriers extends AllCruiser{
    public CruiserHelicopterCarriers(int i, int i1) {
        super(i, i1);
    }
    public void goForward(){
        System.out.println("Скорость передвижения Крейсера-вертолётоносца: "+
                speed + " узлов.");
    }

    public void turnRight(){
        System.out.println("Крейсер-вертолётоносец может поворачивать вправо, но его скорость падает до: "+
                (speed*0.8) + " узлов.");
    }

    public void turnLeft(){
        System.out.println("Крейсер-вертолётоносец может поворачивать влево, но его скорость падает до: "+
                (speed*0.8) + " узлов.");
    }

    public void attack(){
        System.out.println("Крейсер-вертолётоносец атакует - берегитесь!");
    }
}