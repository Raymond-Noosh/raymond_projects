package com.raymond;

import com.raymond.examples.RaymondStack;
import com.raymond.examples.AddToStackThread;
import com.raymond.examples.RemoveFromStackThread;

//import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App
{
    //static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args )
    {
        AddToStackThread thread1 = new AddToStackThread();
        thread1.run();

        RaymondStack.getList().add("Possible to still modify variables if the method is not synchronized");

        RemoveFromStackThread thread2 = new RemoveFromStackThread();
        thread2.run();

        System.out.println(RaymondStack.getSize());
    }
}
