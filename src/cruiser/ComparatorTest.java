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

        log("Использую Set");
        Set<BaseGun> set = new TreeSet<BaseGun>();

        set.add(missileSystem);
        set.add(machineGun);
        set.add(bombGun);

        for (BaseGun s : set) {
            log("Gun name: " + s.getNameOfGun() + ". Damage : " + s.getDamage());
        }
        log("");

        log("Использую List");
        log("");
        List<BaseGun> list = new ArrayList<BaseGun>();
        list.add(missileSystem);
        list.add(machineGun);
        list.add(bombGun);

        log("Исходный несортированный List");
        for (BaseGun l : list) {
            log("Gun name: " + l.getNameOfGun() + ". Damage : " + l.getDamage());
        }
        log("");
        log("Сортированный List по damage");

        Collections.sort(list);
        for (BaseGun l : list) {
            log("Gun name: " + l.getNameOfGun() + ". Damage : " + l.getDamage());
        }
        log("");

        log("Сортированный List по distanse");
        Collections.sort(list, new DistansComporator());
        for (BaseGun l : list) {
            log("Gun name: " + l.getNameOfGun() + ". Distanse : " + l.getDistanceOfFire());
        }
        log("");
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

    private static class DistansComporator implements Comparator<BaseGun> {


        @Override
        public int compare(BaseGun o1, BaseGun o2) {
            BaseGun gun1 = o1;
            BaseGun gun2 = o2;

            int result = o2.getDistanceOfFire() - o1.getDistanceOfFire();
            if (result != 0) {
                return (int) result / Math.abs(result);
            }
            return 0;
        }
    }
}
