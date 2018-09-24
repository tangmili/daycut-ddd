package com.cathay.acctdaycut.facade;

import com.cathay.basecom.cathayresponse.CathayResponse;
import com.cathay.basecom.response.Response;

/**
 * Created by jamestang on 2018/8/3.
 */
public interface AccounttingDayCutService {


    /**
     * 获取会计日
     *
     * @return
     */
    String getCurrentAcctountDate();


    Response<Boolean> AccountDayCut(String acctDate);


}
