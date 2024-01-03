package Other;

import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class QueueClass {

    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        Queue<String> qp = new PriorityQueue<>();

        q.add("Bob");
        qp.add("Bob");
        q.add("Mary");
        qp.add("Mary");
        q.add("Alice");
        qp.add("Alice");
        q.add("John");
        qp.add("John");
        q.add("Richard");
        qp.add("Richard");

        System.out.println("Queue: " + q);
        System.out.println("Priority Queue: " + qp);

        while (!q.isEmpty()) {
            System.out.println("Poll: " + q.poll());
            System.out.println("Queue: " + qp.poll());
        }

    }
}
