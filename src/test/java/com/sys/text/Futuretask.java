package com.sys.text;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Futuretask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {

        int sum = 0;

        for (int i = 1; i < 3; i++) {
            System.out.println("正在执行call 方法" + Thread.currentThread().getName());
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> task = new FutureTask<>(new Futuretask());
        new Thread(task).start();
        System.out.println("-------------------------------------------------");
        System.out.println(task.get() + Thread.currentThread().getName());

    }
}
