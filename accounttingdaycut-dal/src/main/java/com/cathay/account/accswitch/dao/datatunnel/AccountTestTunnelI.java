package com.cathay.account.accswitch.dao.datatunnel;

import com.cathay.account.accswitch.dao.domain.AccTestDO;
import com.cathay.cathaydomain.repository.DataTunnel;


public interface AccountTestTunnelI extends DataTunnel<AccTestDO> {


    /**
     * get Current AccountDayDO
     *
     * @param date
     * @return
     */
    public AccTestDO getCurrentAccountDo(String date);


}
