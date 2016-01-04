package training;

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
        log.info("");
        Set<BaseGun> set = new TreeSet<BaseGun>();
        set.add(missileSystem);
        set.add(machineGun);
        set.add(bombGun1);
        set.add(bombGun2);
        log.info("bombGun1.equals(bombGun2): " + bombGun1.equals(bombGun2));
        log.info("bombGun1.equals(bombGun1): " + bombGun1.equals(bombGun1));
        log.info("bombGun1.compareTo(bombGun2): " + bombGun1.compareTo(bombGun2));

        log.info("\n" + set);

        log.info("Использую ArrayList");
        log.info("");
        List<BaseGun> list = new ArrayList<BaseGun>();
        list.add(missileSystem);
        list.add(machineGun);
        list.add(bombGun1);

        log.info("Исходный несортированный ArrayList");
        log.info("\n" + list);
        log.info("Сортированный ArrayList по damage");

        Collections.sort(list);
        log.info("\n" + list);
        log.info("\n" + list);

        log.info("Сортированный ArrayList по distanse");
        Collections.sort(list, new DistansComporator());
        log.info("\n" + list);
        log.info("");
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
