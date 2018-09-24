package com.cathay.account.accswitch.domain.cutaccount.entity;

import com.cathay.account.accswitch.domain.cutaccount.respository.AccountTestRespository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jamestang on 2018/9/20.
 * 账户测试 Entity
 */

@Data
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AccountTestE {

    @Autowired
    private AccountTestRespository accountTestRespository;


    private Integer id;


    private String content;


    private String ds;

    @Transactional
    public void accTCut(String befordate) {
        AccountTestE accountTestE = accountTestRespository.getCurrentAccountTest(befordate);
        accountTestE.accTCut(befordate);
    }

}
