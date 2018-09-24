package com.cathay.account.accswitch.dao.datatunnel.impl;

import com.cathay.account.accswitch.dao.datatunnel.AccountTestTunnelI;
import com.cathay.account.accswitch.dao.domain.AccTestDO;
import com.cathay.account.accswitch.dao.persistence.AccTestDOMapper;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public class AccountTestDBTunnel implements AccountTestTunnelI {

    @Autowired
    AccTestDOMapper accTestDOMapper;


    @Override
    public List<AccTestDO> findByCriteria(String... strings) {
        return null;
    }

    @Override
    public AccTestDO create(AccTestDO accTestDO) {
        return null;
    }

    @Override
    public AccTestDO get(String s) {
        return accTestDOMapper.selectBycurrentAccDayVO(s);
    }

    @Override
    public int update(AccTestDO accTestDO) {
        return 0;
    }

    @Override
    public AccTestDO getCurrentAccountDo(String date) {
        return accTestDOMapper.selectBycurrentAccDayVO(date);
    }
}
