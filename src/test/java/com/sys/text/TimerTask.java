package com.sys.text;

import org.jetbrains.annotations.NotNull;
import org.springframework.scheduling.annotation.Async;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@Async
public class TimerTask {

    public static class mytask extends java.util.TimerTask {

        @Override
        public void run() {

            System.out.println("我是定时任务");
            System.out.println("线程" + Thread.currentThread().getName());
        }
    }

    public static class myfutrue extends FutureTask {


        public myfutrue(@NotNull Callable callable) {
            super(callable);
        }

        public myfutrue(@NotNull Runnable runnable, Object result) {
            super(runnable, result);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        mytask mytask = new mytask();
        timer.schedule(mytask, 3000L, 5000l);

        Thread thread = new Thread((Runnable) timer);

    }

    static void text() throws InterruptedException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD-hh:mm:ss");
        String s = format.format(new Date());
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        System.out.println(time);
        Thread.sleep(2000L);
        System.out.println("async1:" + s +
                ",id:" + Thread.currentThread().getId() + Thread.currentThread().getName());
    }


}
