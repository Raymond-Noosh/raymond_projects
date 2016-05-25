package com.raymond.web;

import com.raymond.queue.RaymondQueue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Raymond Kwong on 3/27/2016.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @RequestMapping("/startProducer")
    String startProducer() {
        RaymondQueue q = RaymondQueue.getInstance();
        int i = 400;
        while (i > 0) {
            q.startProducer();
            i--;
        }

        return "Producer Started";
    }

    @RequestMapping("/startConsumer")
    String startConsumer() {
        RaymondQueue q = RaymondQueue.getInstance();
        int i = 400;
        while (i > 0) {
            q.startConsumer();
            i--;
        }
        return "Consumer Started";
    }

    @RequestMapping("/startSimulation")
    String startSimulation() {
        RaymondQueue q = RaymondQueue.getInstance();

        int i = 400;
        while (i > 0) {
            q.startProducer();
            i--;
        }

        int j = 400;
        while (j > 0) {
            q.startConsumer();
            j--;
        }
        return "Started Simulation";
    }

    @RequestMapping("/checkWaitingThreads")
    String checkWaitingThreads() {
        RaymondQueue q = RaymondQueue.getInstance();
        q.checkWaitingThreads();
        return "Waiting Threads";
    }



}
