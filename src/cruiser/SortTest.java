package cruiser;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import gun.BaseGun;
import gun.BombGun;
import gun.MachineGun;
import gun.MissileSystem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class SortTest {
    BaseGun machineGun = new MachineGun();
    BaseGun missileSystem = new MissileSystem();
    BaseGun bombGun = new BombGun();
    List<BaseGun> list = new ArrayList<BaseGun>();

@Test
   public void sortDamageTest(){
    list.add(missileSystem);
    list.add(machineGun);
    list.add(bombGun);
    int damage = 0;
    Collections.sort(list);
    for (BaseGun l : list) {
        if (damage==0) damage = l.getDamage();
        else
            assertTrue(damage>l.getDamage());
    }
    }
}
