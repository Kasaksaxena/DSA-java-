import java.util.*;

public class FibonacciRecursion {
    static int fibo(int n){

        if( n <= 1){
            return n;
        }

    return fibo(n-1)  + fibo(n-2);
    }

        public static void main(String[] args) {

        int n = 6;

        System.out.println(fibo(n));
    }

}

// time : O(2^n)  space :O(n)