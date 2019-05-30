package top.liuliyong.datastructure.set;

/**
 * @Author liyong.liu
 * @Date 2019-05-29
 **/
public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
