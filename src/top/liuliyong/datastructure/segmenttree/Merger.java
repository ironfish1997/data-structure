package top.liuliyong.datastructure.segmenttree;

/**
 * @Author liyong.liu
 * @Date 2019-06-02
 **/
public interface Merger<E> {
    E merge(E a, E b);
}
