package com.cathay.component.daycut;

import com.cathay.account.accswitch.domain.cutaccount.entity.AccountTestE;
import com.cathay.account.accswitch.domain.cutaccount.factory.AccTestDomainFactory;
import com.cathay.account.accswitch.exception.DayCutException;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jamestang on 2018/9/23.
 */
@Slf4j
public class DayCutComponent {


    @Autowired
    private AccTestDomainFactory accTestDomainFactory;

    public void daycut(String cutdate) {
        if (Strings.isNullOrEmpty(cutdate)) new DayCutException("cutdate is null");
        AccountTestE accountTestE = accTestDomainFactory.create();
        accountTestE.accTCut(cutdate);
    }
}
