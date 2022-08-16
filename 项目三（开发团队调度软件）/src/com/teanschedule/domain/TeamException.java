package com.teanschedule.domain;

/**
 * @author huyongkun
 * @ClassName TeamException
 * @create 2022-06-02 20:35
 * @Version 1.0
 * @description: 异常类
 */
public class TeamException extends RuntimeException{
    static final long serialVersionUID = -7034897190745766939L;

    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
