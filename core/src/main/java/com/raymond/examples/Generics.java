package com.raymond.examples;

/**
 * Created by Raymond Kwong on 3/16/2016.
 */


 //A generic class is defined with the following format:
 //class name<T1, T2, ..., Tn> { /* ... */

 //The type parameter section, delimited by angle brackets (<>), follows the class name. It specifies the type parameters (also called type variables) T1, T2, ..., and Tn.

public class Generics <T, V, K> {
    public class Box<N> {

    }


    public V add(V item) {
        return item;
    }

    public <N>N remove (N item) {
        return item;
    }

    public void test () {
        Generics <String, Integer, Object> generics1 = new Generics<>();//diamond it
        Generics <String, Integer, Box<K>> generics2 = new Generics<>();//diamond it
    }

    public static <T> T[] addToArray(T item, T... items){
        T[] array;
        int array_size = 1;

        if(items !=null){ array_size = items.length+1; }

        array = java.util.Arrays.copyOf(items, array_size);
        array[array_size-1] = item;

        return array;
    }


    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
