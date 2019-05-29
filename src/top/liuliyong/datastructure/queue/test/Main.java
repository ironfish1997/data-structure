package top.liuliyong.datastructure.queue.test;

import top.liuliyong.datastructure.queue.ArrayQueue;
import top.liuliyong.datastructure.queue.LinkedListQueue;
import top.liuliyong.datastructure.queue.LoopQueue;
import top.liuliyong.datastructure.queue.Queue;

import java.util.Random;

/**
 * @Author liyong.liu
 * @Date 2019-05-20
 **/
public class Main {
    private static double testQueue(Queue queue, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue time: " + time1 + " s.");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue time: " + time2 + " s.");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("LinkedListQueue time: " + time3 + " s.");
    }
}
