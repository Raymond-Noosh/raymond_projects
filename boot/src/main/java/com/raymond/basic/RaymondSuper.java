package com.raymond.basic;

/**
 * Created by Raymond Kwong on 6/18/2016.
 */
public class RaymondSuper {

    public String bbb = "bbb";
    public static class RaymondStaticInner {
        public void abc() {
            //can't access bbb, as this behaves like a normal top level class
        }
    }

    public void localClass() {
        String adfd="test";

        class RaymondLocal {
            public RaymondLocal() {
                System.out.println(adfd);
            }
        }

        RaymondLocal ll = new RaymondLocal();
    }

    /*public static void main(String[] args) {
        RaymondSuper suu = new RaymondSuper();
        suu.localClass();
    }*/

        // Valid in JDK 8 and later:

//            public void printOriginalNumbers() {
//                System.out.println("Original numbers are " + phoneNumber1 +
//                    " and " + phoneNumber2);
//            }



}
