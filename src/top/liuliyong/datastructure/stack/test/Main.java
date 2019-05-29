package top.liuliyong.datastructure.stack.test;

import top.liuliyong.datastructure.stack.ArrayStack;
import top.liuliyong.datastructure.stack.LinkedListStack;
import top.liuliyong.datastructure.stack.Stack;

import java.util.Random;

/**
 * @Author liyong.liu
 * @Date 2019-05-20
 **/
public class Main {
    private static double testStack(Stack stack, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time2 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack time: " + time2 + " s.");

        LinkedListStack linkedListStack = new LinkedListStack();
        double time1 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack time: " + time1 + " s.");
    }
}
