package com.cathay.account.accswitch.domain.cutaccount.respository;

import com.cathay.account.accswitch.dao.datatunnel.AccountTestTunnelI;
import com.cathay.account.accswitch.dao.domain.AccTestDO;
import com.cathay.account.accswitch.domain.cutaccount.convertor.AccountTestConverter;
import com.cathay.account.accswitch.domain.cutaccount.entity.AccountTestE;
import com.cathay.account.accswitch.exception.DayCutException;
import com.cathay.cathaydomain.repository.RepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by jamestang on 2018/9/23.
 */
@Repository
public class AccountTestRespository implements RepositoryI<AccountTestE> {

    @Autowired
    private AccountTestTunnelI accountTestTunnelI;

    @Autowired
    private AccountTestConverter accountTestConverter;

    @Override
    public void persist(AccountTestE accountTestE) {


    }

    /**
     * 获取当前日切领域对象
     *
     * @return
     */
    public AccountTestE getCurrentAccountTest(String cutbefordate) {

        AccTestDO accTestDO = accountTestTunnelI.getCurrentAccountDo(cutbefordate);
        if (null == accTestDO) {
            throw new DayCutException("cutday is not exist");
        }
        return accountTestConverter.dataToEntity(accTestDO);
    }



}
