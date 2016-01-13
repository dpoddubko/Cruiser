package com.test;

import exeption.NegativeSignException;
import gun.BombGun;
import gunTool.GunTool;
import org.junit.Test;

public class DecreaseNumberOfChargeTest {
    @Test(expected = NegativeSignException.class)
    public void decreaseNumberOfChargeTest() {
        GunTool gunTool = new GunTool(0, new BombGun());
        gunTool.decreaseNumberOfCharge();
    }
}

