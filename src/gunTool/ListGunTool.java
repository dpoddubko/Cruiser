package gunTool;

import gun.BombGun;
import gun.MachineGun;
import gun.MissileSystem;

import java.util.ArrayList;
import java.util.List;

public class ListGunTool {
    private List<GunTool> gunToolList = new ArrayList<GunTool>();

    public void addMissleTool() {
        gunToolList.add(new GunTool(new MissileSystem()));
    }

    public void addBombGunTool() {
        gunToolList.add(new GunTool(new BombGun()));
    }

    public void addMashineGunTool() {
        gunToolList.add(new GunTool(new MachineGun()));
    }
}
