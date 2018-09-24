
package com.cathay.acctdaycut.dao;

import com.cathay.account.accswitch.dao.domain.AccTestDO;
import com.cathay.account.accswitch.dao.persistence.AccTestDOMapper;
import com.cathay.acctdaycut.base.AbstractTestBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by jamestang on 2018/8/3.
 */

@Slf4j
public class AccountTestMapperTest extends AbstractTestBase {

    @Autowired
    private AccTestDOMapper accTestDOMapper;


    @Test
    public void gettestinfo() {
        AccTestDO accTestDO = accTestDOMapper.selectByPrimaryKey(1);
        log.info("accTestDo is {}", accTestDO);
    }
}

