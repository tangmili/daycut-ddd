package com.cathay.account.accswitch.domain.cutaccount.factory;

import com.cathay.account.accswitch.domain.cutaccount.entity.AccountTestE;
import com.cathay.account.accswitch.domain.cutaccount.respository.AccountTestRespository;
import com.cathay.cathaydomain.factory.DomainFactoryI;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by jamestang on 2018/9/22.
 */

@Component
public class AccTestDomainFactory implements DomainFactoryI<AccountTestE>, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private AccountTestRespository accountTestRespository;


    @Override
    public AccountTestE create() {
        return applicationContext.getBean(AccountTestE.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
