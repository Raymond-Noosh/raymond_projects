package com.raymond.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Raymond Kwong on 5/20/2016.
 */
public class RaymondSingleton {

    private static RaymondSingleton raymond;

    private static final Lock lock = new ReentrantLock();

    private RaymondSingleton () {
        System.out.println("Create");
    }

    public static synchronized RaymondSingleton getInstanceFromSychronizedMethod() {
        if (raymond == null) {
            raymond = new RaymondSingleton();
        }
        return raymond;
    }

    private static volatile RaymondSingleton helper;
    public static RaymondSingleton getInstanceFromHelper() {
        RaymondSingleton result = helper;
        if (result == null) {
            synchronized(RaymondSingleton.class) {
                result = helper;
                if (result == null) {
                    helper = result = new RaymondSingleton();
                }
            }
        }
        return result;
    }

    private static volatile boolean helperInt = false;
    public static RaymondSingleton getInstanceFromHelper2() {
        if (helperInt == false && raymond == null) {
            synchronized(RaymondSingleton.class) {
                if (raymond == null) {
                    raymond = new RaymondSingleton();
                    helperInt = true;
                }
            }
        }
        return raymond;
    }

    public static RaymondSingleton getInstanceFromSychronizedStatements() {
        if (raymond == null) {
            synchronized(RaymondSingleton.class) {
                if (raymond == null) {
                    raymond = new RaymondSingleton();
                }
            }
        }
        return raymond;
    }

    public static RaymondSingleton getInstanceFromLock() {
        if (raymond == null) {
            lock.lock();
            try {
                if (raymond == null) {
                    raymond = new RaymondSingleton();
                }
            }
            catch (Exception e) {
                System.out.println(e);
            }
            finally {
                lock.unlock();
            }
        }
        return raymond;
    }

    private static class RaymondHolder {
        public static final RaymondSingleton helper = new RaymondSingleton();
    }

    public static RaymondSingleton getInstanceByInnerClass() {
        return RaymondHolder.helper;
    }

    public static class FinalWrapper<T> {
        public final T value;
        public FinalWrapper(T value) {
            this.value = value;
        }
    }
    private static FinalWrapper<RaymondSingleton> helperWrapper;
    public static RaymondSingleton getInstanceFromFinalWrapper() {
        FinalWrapper<RaymondSingleton> wrapper = helperWrapper;
        if (wrapper == null) {
            synchronized(RaymondSingleton.class) {
                if (helperWrapper == null) {
                    helperWrapper = new FinalWrapper<RaymondSingleton>(new RaymondSingleton());
                }
                wrapper = helperWrapper;
            }
        }
        return wrapper.value;
    }

}
