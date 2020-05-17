package top.liuliyong.datastructure.set.impl;

import top.liuliyong.datastructure.binarysearchtree.BST;
import top.liuliyong.datastructure.set.Set;

/**
 * 使用二分搜索树实现的集合
 *
 * @Author liyong.liu
 * @Date 2019-05-29
 **/
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
