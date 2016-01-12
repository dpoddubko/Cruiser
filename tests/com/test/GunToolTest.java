package com.test;

import exeption.NegativeSignException;
import gun.MissileSystem;
import gunTool.GunTool;
import org.apache.log4j.Logger;
import org.junit.Test;

public class GunToolTest {
    private final static Logger LOG = Logger.getLogger(GunToolTest.class);

    @Test(expected = NegativeSignException.class)
    public void gunToolTest() {
        GunTool gunTool = new GunTool(-10, new MissileSystem());
        LOG.info(gunTool);
    }
}

