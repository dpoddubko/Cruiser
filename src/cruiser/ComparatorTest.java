package cruiser;

import java.util.*;

import gun.BaseGun;
import gun.BombGun;
import gun.MachineGun;
import gun.MissileSystem;

import java.util.TreeSet;

public class ComparatorTest {
    public static void main(String[] args) {

        BaseGun machineGun = new MachineGun();
        BaseGun missileSystem = new MissileSystem();
        BaseGun bombGun1 = new BombGun();
        BaseGun bombGun2 = new BombGun();

        log("Использую Set");
        log("Сортированный Set по damage");
        log("");
        Set<BaseGun> set = new TreeSet<BaseGun>();
        set.add(missileSystem);
        set.add(machineGun);
        set.add(bombGun1);
        set.add(bombGun2);
        log("bombGun1.equals(bombGun2): " + bombGun1.equals(bombGun2));
        log("bombGun1.equals(bombGun1): " + bombGun1.equals(bombGun1));
        log("bombGun1.compareTo(bombGun2): "+bombGun1.compareTo(bombGun2));
        //log(""+bombGun1.toString());
        //log(""+bombGun2.toString());

        displaySet(set);

        log("Использую ArrayList");
        log("");
        List<BaseGun> list = new ArrayList<BaseGun>();
        list.add(missileSystem);
        list.add(machineGun);
        list.add(bombGun1);

        log("Исходный несортированный ArrayList");
        displayList(list);
        log("Сортированный ArrayList по damage");

        Collections.sort(list);
        displayList(list);

        log("Сортированный ArrayList по distanse");
        Collections.sort(list, new DistansComporator());
        displayList(list);
        log("");

    }

    private static void log(String s) {
        System.out.println(s);
    }

    public static void displayList(List<BaseGun> list) {
        for (BaseGun l : list) System.out.println(l);
        log("");
    }

    public static void displaySet(Set<BaseGun> set) {
        for (BaseGun s : set) System.out.println(s);
        log("");
    }

    public static class DistansComporator implements Comparator<BaseGun> {
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
