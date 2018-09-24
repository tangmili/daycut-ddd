package com.cathay.account.accswitch.domain.cutaccount.convertor;

import com.cathay.account.accswitch.dao.domain.AccTestDO;
import com.cathay.account.accswitch.domain.cutaccount.entity.AccountTestE;
import com.cathay.acctdaycut.dto.AccountTestDto;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by jamestang on 2018/9/23.
 */
@Component
public class AccountTestConverter implements com.cathay.cathaydomain.convertor.ConvertorI<AccountTestDto, AccountTestE, AccTestDO>, ApplicationContextAware {


    private ApplicationContext applicationContext;

    @Override
    public AccountTestE clientToEntity(AccountTestDto o) {
        return null;
    }

    @Override
    public AccountTestDto entityToClient(AccountTestE accountTestE) {
        return null;
    }

    @Override
    public AccountTestDto dataToClient(AccTestDO accTestDO) {
        return null;
    }

    @Override
    public AccountTestE dataToEntity(AccTestDO accTestDO) {
        AccountTestE accountTestE = (AccountTestE) applicationContext.getBean(AccountTestE.class);
        accountTestE.setContent(accTestDO.getContent());
        accountTestE.setDs(accTestDO.getDs());
        accountTestE.setId(accTestDO.getId());
        return accountTestE;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

    }
}
