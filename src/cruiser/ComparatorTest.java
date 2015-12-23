package cruiser;
import java.util.*;

import gun.BaseGun;
import gun.BombGun;
import gun.MachineGun;
import gun.MissileSystem;

import java.util.TreeSet;

public class ComparatorTest {
    public static void main(String[] args) {
        int result;


        BaseGun machineGun = new MachineGun();
        BaseGun missileSystem = new MissileSystem();
        BaseGun bombGun = new BombGun();
        BaseGun bombGun2 = new BombGun();

        System.out.println("Использую Set");
        Set<BaseGun> set = new TreeSet<BaseGun>();

        set.add(missileSystem);
        set.add(machineGun);
        set.add(bombGun);

        for(BaseGun s : set) {
            System.out.println("Gun name: " + s.getNameOfGun() + ". Damage : " + s.getDamage());
        }
        System.out.println("");

        System.out.println("Использую List");
        List<BaseGun> list = new ArrayList<BaseGun>();

        list.add(missileSystem);
        list.add(machineGun);
        list.add(bombGun);
        for(BaseGun l : list) {
            System.out.println("Gun name: " + l.getNameOfGun() + ". Damage : " + l.getDamage());
        }
        System.out.println("");

        result = machineGun.compareTo(missileSystem);
        if (result > 0)
            log("machineGun менее мощное оружие, чем missileSystem");
        else
            log("machineGun более мощнное оружие, чем missileSystem");

        result = machineGun.compareTo(bombGun);
        if (result > 0)
            log("machineGun менее мощное оружие, чем bombGun");
        else
            log("machineGun более мощнное оружие, чем bombGun");
        result = missileSystem.compareTo(bombGun);
        if (result > 0)
            log("missileSystem менее мощное оружие, чем bombGun");
        else
            log("missileSystem более мощнное оружие, чем bombGun");
    }

    private static void log(String s) {
        System.out.println(s);
    }

   // public static <BaseGun<? super BaseGun>> void sort(List<BaseGun> list)
}
