package org.seckill.exception;

/**
 * 秒杀关闭异常,秒杀结束时用户还要进行秒杀就会出现的异常
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
