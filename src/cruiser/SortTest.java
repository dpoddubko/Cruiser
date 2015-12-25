package cruiser;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import gun.BaseGun;
import gun.BombGun;
import gun.MachineGun;
import gun.MissileSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class SortTest {
    BaseGun machineGun = new MachineGun();
    BaseGun missileSystem = new MissileSystem();
    BaseGun bombGun = new BombGun();
    List<BaseGun> list = new ArrayList<BaseGun>();
    List<BaseGun> list1 = new ArrayList<BaseGun>();

    @Test
    public void sortDamageTest() {
        list.add(missileSystem);
        list.add(machineGun);
        list.add(bombGun);
        int damage = 0;
        Collections.sort(list);
        for (BaseGun l : list) {
            if (damage == 0) damage = l.getDamage();
            else
                assertTrue(damage > l.getDamage());
        }
    }

    @Test
    public void sortTrueDamageTest() {
        list1.add(missileSystem);
        list1.add(machineGun);
        list1.add(bombGun);
        Collections.sort(list1);
        for (int i = 0; i < list1.size()-1; i++) {
            assertTrue(list1.get(i).getDamage() > list1.get(i + 1).getDamage());
        }
    }
}