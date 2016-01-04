package cruiser;

import gun.BaseGun;
import gun.BombGun;
import gun.MachineGun;
import gun.MissileSystem;
import org.apache.log4j.Logger;

import java.util.*;

public class ComparatorTest {
    final static Logger log = Logger.getLogger(ComparatorTest.class);
    public static void main(String[] args) {

        BaseGun machineGun = new MachineGun();
        BaseGun missileSystem = new MissileSystem();
        BaseGun bombGun1 = new BombGun();
        BaseGun bombGun2 = new BombGun();

        log.info("Использую Set");
        log.info("Сортированный Set по damage");
        System.out.println("");
        Set<BaseGun> set = new TreeSet<BaseGun>();
        set.add(missileSystem);
        set.add(machineGun);
        set.add(bombGun1);
        set.add(bombGun2);
        log.info("bombGun1.equals(bombGun2): " + bombGun1.equals(bombGun2));
        log.info("bombGun1.equals(bombGun1): " + bombGun1.equals(bombGun1));
        log.info("bombGun1.compareTo(bombGun2): " + bombGun1.compareTo(bombGun2));

        displaySet(set);

        log.info("Использую ArrayList");
        System.out.println("");
        List<BaseGun> list = new ArrayList<BaseGun>();
        list.add(missileSystem);
        list.add(machineGun);
        list.add(bombGun1);

        log.info("Исходный несортированный ArrayList");
        displayList(list);
        log.info("Сортированный ArrayList по damage");

        Collections.sort(list);
        displayList(list);

        log.info("Сортированный ArrayList по distanse");
        Collections.sort(list, new DistansComporator());
        displayList(list);
        System.out.println("");

    }

    public static void displayList(List<BaseGun> list) {
        for (BaseGun l : list) System.out.println(l);
        System.out.println("");
    }

    public static void displaySet(Set<BaseGun> set) {
        for (BaseGun s : set) System.out.println(s);
        System.out.println("");
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
