package top.liuliyong.datastructure.stack;

/**
 * @Author liyong.liu
 * @Date 2019-05-19
 **/
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
