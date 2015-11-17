package com.weir.signal;

import sun.misc.Signal;
import sun.misc.SignalHandler;

/**
 * 可以用这个实现nginx的日志切割功能，文件写一直打开的，这个信号告诉程序重新打开文件
 * @author wangwei <br/> 
 * 2015年11月17日 下午5:51:16 <br/>
 */
@SuppressWarnings("restriction")
public class TestSignal implements SignalHandler {

    public void handle(Signal name) {
        System.out.println(name + " is recevied.");
    }

    // 使用linux命令发送信号： kill -SIGUSR2 进程ID 
    
    public static void main(String[] args) throws InterruptedException {
        TestSignal testSignalHandler = new TestSignal();
        // install signals  
        Signal sig2 = new Signal("USR2");
        Signal.handle(sig2, testSignalHandler);
        Thread.sleep(60000);
    }

}
