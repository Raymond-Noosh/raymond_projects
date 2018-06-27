package com.raymond.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.*;

/**
 * Created by Raymond Kwong on 6/26/2018.
 */
public class RaymondFuture {

    public void doIt() {
        System.out.println(Thread.currentThread().getName());
    }

    /*public static void main(String[] args) {
        System.out.println("main start");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        RaymondCallable callable = new RaymondCallable();
        RaymondRunnable runnable = new RaymondRunnable();
        Future<String> task = executorService.submit(callable);

        Future<String> task2 = executorService.submit(runnable, null);
        try {
            String string = task.get();
            System.out.println(string);

            Object string2 = task2.get();
            System.out.println(string2);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        RaymondFuture raymondFuture = new RaymondFuture();
        raymondFuture.doIt();
    }*/
}
