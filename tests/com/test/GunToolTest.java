package com.test;

import gun.MissileSystem;
import gunTool.GunTool;
import org.apache.log4j.Logger;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class GunToolTest {
    private final static Logger LOG = Logger.getLogger(GunToolTest.class);

    @Test
    public void gunToolTest() {
        GunTool gunTool = new GunTool(-10, new MissileSystem());
        LOG.info(gunTool);
        assertEquals(0, gunTool.getNumberOfCharge());
    }


}

