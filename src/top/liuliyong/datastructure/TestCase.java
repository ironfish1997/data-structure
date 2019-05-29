package top.liuliyong.datastructure;


import org.junit.Test;
import top.liuliyong.datastructure.stack.ArrayStack;

/**
 * @Author liyong.liu
 * @Date 2019-05-19
 **/
public class TestCase {

    @Test
    public void testCase1() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }

    @Test
    public void testHammingDistance() {
        System.out.println(hammingDistance(1, 2));
    }

    private int hammingDistance(int x, int y) {
        //先按位异或，把所有不同的位置1，相同置0
        int statistics = x ^ y;
        System.out.println("statistics: " + statistics);
        int status = 0;
        while (statistics != 0) {
            if (statistics % 2 == 1) {
                status++;
            }
            statistics = statistics / 2;
        }
        return status;
    }
}