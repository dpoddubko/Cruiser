package training;

import gun.BaseGun;
import gun.BombGun;
import gun.MachineGun;
import gun.MissileSystem;
import org.apache.log4j.Logger;

import java.util.*;

public class ComparatorTest {
    final static Logger LOG = Logger.getLogger(ComparatorTest.class);

    public static void main(String[] args) {

        BaseGun machineGun = new MachineGun();
        BaseGun missileSystem = new MissileSystem();
        BaseGun bombGun1 = new BombGun();
        BaseGun bombGun2 = new BombGun();

        LOG.info("Использую Set");
        LOG.info("Сортированный Set по damage");
        LOG.info("");
        Set<BaseGun> set = new TreeSet<BaseGun>();
        set.add(missileSystem);
        set.add(machineGun);
        set.add(bombGun1);
        set.add(bombGun2);
        LOG.info("bombGun1.equals(bombGun2): " + bombGun1.equals(bombGun2));
        LOG.info("bombGun1.equals(bombGun1): " + bombGun1.equals(bombGun1));
        LOG.info("bombGun1.compareTo(bombGun2): " + bombGun1.compareTo(bombGun2));

        LOG.info("\n" + set);

        LOG.info("Использую ArrayList");
        LOG.info("");
        List<BaseGun> list = new ArrayList<BaseGun>();
        list.add(missileSystem);
        list.add(machineGun);
        list.add(bombGun1);

        LOG.info("Исходный несортированный ArrayList");
        LOG.info("\n" + list);
        LOG.info("Сортированный ArrayList по damage");

        Collections.sort(list);
        LOG.info("\n" + list);
        LOG.info("\n" + list);

        LOG.info("Сортированный ArrayList по distanse");
        Collections.sort(list, new DistansComporator());
        LOG.info("\n" + list);
        LOG.info("");
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
