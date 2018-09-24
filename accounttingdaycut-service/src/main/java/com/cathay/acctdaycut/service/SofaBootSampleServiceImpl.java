package com.cathay.acctdaycut.service;

import com.cathay.acctdaycut.facade.SofaBootSampleService;
import org.springframework.stereotype.Service;

/**
 * Created by jamestang on 2018/4/20.
 */
@Service("sofaBootSampleService")
public class SofaBootSampleServiceImpl implements SofaBootSampleService {
    @Override
    public String excutemethod(String inputParam) {
        return "Hello SofaBoot Call " + inputParam;
    }
}
