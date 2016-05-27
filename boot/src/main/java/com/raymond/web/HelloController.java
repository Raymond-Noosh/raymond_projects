package com.raymond.web;

import com.raymond.queue.RaymondBlockingQueue;
import com.raymond.queue.RaymondNormalQueue;
import com.raymond.queue.RaymondQueueConsumer;
import com.raymond.queue.RaymondQueueProducer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Raymond Kwong on 3/27/2016.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @RequestMapping("/startSimulation")
    String startSimulation() {
        RaymondBlockingQueue q = RaymondBlockingQueue.getInstance();

        int i = 11;
        while (i > 0) {
            new Thread(new RaymondQueueProducer(q)).start();//1
            i--;
        }

        int j = 10;
        while (j > 0) {
            new Thread(new RaymondQueueConsumer(q)).start();//1
            j--;
        }
        return "Started Simulation";
    }

    @RequestMapping("/checkQueueSize")
    String checkWaitingThreads() {
        RaymondBlockingQueue q = RaymondBlockingQueue.getInstance();
        return "QueueSize=" + q.getSize();
    }

}
