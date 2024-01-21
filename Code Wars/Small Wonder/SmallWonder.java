package DBLinear;

import java.util.HashSet;
import java.util.PriorityQueue;

public class SmallWonder {

    public static void main(String[] args) {

        Robot vicky = new Robot();
        System.out.println(vicky.learnWord("hello"));
        System.out.println(vicky.learnWord("hello"));
        System.out.println(vicky.learnWord("world"));
        System.out.println(vicky.learnWord("world"));
        System.out.println(vicky.learnWord("world!"));
    }
}
