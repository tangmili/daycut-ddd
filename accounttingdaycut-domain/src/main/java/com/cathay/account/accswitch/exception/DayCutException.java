package com.cathay.account.accswitch.exception;

/**
 * 日切异常
 * Created by jamestang on 2018/9/23.
 */
public class DayCutException extends RuntimeException {
    public DayCutException(String ex) {
        super(ex);
    }

    public DayCutException() {
        super();

    }

}
