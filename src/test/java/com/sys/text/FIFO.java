package com.sys.text;

import java.util.Iterator;
import java.util.LinkedList;

public class FIFO extends LinkedList {

    public Object get() {
        return super.getFirst();
    }

    @Override
    public void addFirst(Object o) {
        super.addFirst(o);
    }

    @Override
    public void addLast(Object o) {
        super.addLast(o);
    }


    public static void main(String[] args) throws InterruptedException {
        FIFO fifo = new FIFO();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 8; i++) {
                    fifo.addFirst(i);

                }
                System.out.println("完毕");
                System.out.println(fifo.size());
            }


        }.start();

        new Thread() {
            @Override
            public void run() {
                Iterator iterator = fifo.iterator();

                System.out.println("first++++++++" + fifo.getFirst());
                while (iterator.hasNext()) {
                    System.out.println(fifo.size());
                    Object next = iterator.next();
                    System.out.println(fifo.get());
                    Object first = fifo.getFirst();
                    System.out.println("first++++++++" + first);
                    fifo.removeFirst();
                    System.out.println(fifo.removeFirst().toString());
                }

            }
        }.start();

    }

}

