package top.liuliyong.datastructure.array;

/**
 * @Author liyong.liu
 * @Date 2019-05-07
 **/
public class Array<E> {
    private E[] data;
    private int size;

    //构造数组，传入数组的容量capacity构造array
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        data = (E[]) new Object[10];
        size = 0;
    }

    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        System.arraycopy(arr, 0, data, 0, arr.length);
        size = arr.length;
    }

    //获取数组中的元素个数
    public int getSize() {
        return size;
    }

    //获取数组容量
    public int getCapacity() {
        return data.length;
    }

    //返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向所有元素后添加一个元素
    public void addLast(E element) {
        add(size, element);
    }

    public void addFirst(E element) {
        add(0, element);
    }

    //获取索引位置的元素
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed, index is illegal");
        }
        return data[index];
    }

    //修改index索引位置的元素为element
    public void set(int index, E element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed, index is illegal");
        }
        data[index] = element;
    }

    //查找数组中是否存在元素target
    public boolean contains(E target) {
        for (E element : data) {
            if (target.equals(element)) {
                return true;
            }
        }
        return false;
    }

    //寻找元素在数组中的位置
    public int find(E target) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    //从数组中删除index位置的元素,返回删除的元素
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed, index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        //如果数组利用率到了一半以下，则把数组容积减半
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 交换数组中i下标元素和j下标元素的位置
     */
    public void swap(int i, int j) {
        if (i < 0 || i > getSize() - 1 || j < 0 || j > getSize() - 1) {
            throw new IllegalArgumentException("index is out of range");
        }
        E iOri = data[i];
        data[i] = data[j];
        data[j] = iOri;
    }

    //从数组中删除第一个元素
    public E removeFirst() {
        if (size == 0 || data.length == 0) {
            throw new ArrayIndexOutOfBoundsException("remove first failed, array is empty");
        }
        return remove(0);
    }

    //从数组删除最后一个元素
    public E removeLast() {
        if (size == 0 || data.length == 0) {
            throw new ArrayIndexOutOfBoundsException("remove first failed, array is empty");
        }
        return remove(size - 1);
    }

    //从数组删除一个指定元素
    public boolean removeElement(E element) {
        int index = find(element);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    //元素插入数组指定位置
    public void add(int index, E element) {
        if (index < 0 || index > data.length) {
            throw new IllegalArgumentException("Add element failed, require index should be less than data length and be more than 0");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void resize(int newCapacity) {
        E[] expandArray = (E[]) new Object[newCapacity];
        if (size >= 0) System.arraycopy(data, 0, expandArray, 0, size);
        data = expandArray;
    }
}