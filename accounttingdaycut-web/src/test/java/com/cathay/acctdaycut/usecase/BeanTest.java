package com.cathay.acctdaycut.usecase;

import com.cathay.acctdaycut.base.AbstractTestBase;
import com.cathay.acctdaycut.facade.SofaBootSampleService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * BeanTest
 * <p>
 * Created by yangguanchao on 16/12/9.
 */
public class BeanTest extends AbstractTestBase {

    @Autowired
    private SofaBootSampleService sampleService;

    @Test
    public void testRpcSimple() throws Exception {
        String result = sampleService.excutemethod("hello");
        System.out.printf("Sample Service Result = " + result);
        Assert.assertTrue(result != null && result.length() > 0);
    }
}
