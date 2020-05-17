package top.liuliyong.datastructure.heap;

import top.liuliyong.datastructure.array.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 最大堆
 *
 * @Author liyong.liu
 * @Date 2019-05-30
 **/
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * Heapify,直接把数组转换成堆
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }


    //向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    //查看堆中最大的元素
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Heap is empty.");
        }
        return data.get(0);
    }

    //取出堆中最大的元素
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    //取出堆中最大元素并替换成元素e
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;

    }


    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 does not have parent.");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private void siftUp(int index) {
        //index所在的父亲元素和index所在元素比大小
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    private void siftDown(int index) {
        while (leftChild(index) < data.getSize()) {
            int l = leftChild(index);
            int r = rightChild(index);
            //找出左右孩子中最大的节点在数组中的索引
            if (r < data.getSize() && data.get(l).compareTo(data.get(r)) < 0) {
                l = r;
            }
            if (data.get(l).compareTo(data.get(index)) <= 0) {
                break;
            }
            data.swap(l, index);
            index = l;
        }
    }

    /**
     * 测试heapify的速度
     */
    private static double testMaxHeap(Integer[] testCase, boolean isHeapify) {
        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testCase);
        } else {
            maxHeap = new MaxHeap<>();
            for (int i : testCase) {
                maxHeap.add(i);
            }
        }
        int[] arr = new int[testCase.length];
        for (int i = 0; i < testCase.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Complete MaxHeap Test, Success!");
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int n = 10000000;
        Random random = new Random();
        Integer[] oriArr = new Integer[n];

        for (int i = 0; i < n; i++) {
            oriArr[i] = random.nextInt(Integer.MAX_VALUE);
        }
        System.out.println("heapify time:" + testMaxHeap(oriArr, true));
        System.out.println("unheapify time:" + testMaxHeap(oriArr, false));
    }

}
