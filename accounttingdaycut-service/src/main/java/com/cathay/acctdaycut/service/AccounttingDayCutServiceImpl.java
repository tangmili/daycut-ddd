package com.cathay.acctdaycut.service;

import com.cathay.account.accswitch.exception.DayCutException;
import com.cathay.acctdaycut.facade.AccounttingDayCutService;
import com.cathay.basecom.response.Response;
import com.cathay.component.daycut.DayCutComponent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jamestang on 2018/8/3.
 */
public class AccounttingDayCutServiceImpl implements AccounttingDayCutService {


    @Autowired
    private DayCutComponent dayCutComponent;

    @Override
    public String getCurrentAcctountDate() {
        return null;
    }

    @Override
    public Response<Boolean> AccountDayCut(String acctDate) {
        try {
            dayCutComponent.daycut(acctDate);
            return new Response();
        } catch (DayCutException ex) {
            return new Response().setFailCause(ex.getMessage());
        } catch (Exception ex) {
            return new Response().setFailCause(ex.getMessage());
        }
    }
}
