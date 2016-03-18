package com.raymond;

import com.raymond.examples.RaymondStack;

/**
 * Hello world!
 *
 */
public class App implements Runnable
{
    @Override
    public void run() {
        RaymondStack.add("abc");
        RaymondStack.add("def");
        RaymondStack.remove();
        RaymondStack.add("ghi");
        //RaymondStack.remove();
        RaymondStack.add("jkl");
        RaymondStack.remove();
        RaymondStack.add("mno");
        RaymondStack.remove();
    }

    public static void main(String[] args )
    {
        System.out.println( "Hello World!" );
        (new Thread(new App())).start();
        (new Thread(new App())).start();
        (new Thread(new App())).start();
        (new Thread(new App())).start();
        (new Thread(new App())).start();
        System.out.println(Thread.activeCount());

        //String str = RaymondStack.remove();
    }
}
