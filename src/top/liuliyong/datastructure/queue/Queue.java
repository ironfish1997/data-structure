package top.liuliyong.datastructure.queue;

/**
 * @Author liyong.liu
 * @Date 2019-05-20
 **/
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
