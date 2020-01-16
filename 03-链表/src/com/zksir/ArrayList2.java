package com.zksir;
/**
 * 有动态缩容
 * @author kaizhang
 *
 * @param <E>
 */
public class ArrayList2<E> extends AbstractList<E> {

    /**
     * 所有元素
     */
    private E[] elements;

    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList2(int capacity){
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    public ArrayList2(){
        this(DEFAULT_CAPACITY);
    }
    /**
     * 清除所有元素
     */
    public void clear(){
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * 返回元素数量
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(E element){
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到尾部
     * @param element
     */
    public void add(E element){
        add(size,element);
    }

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return
     */
    public E set(int index, E element){
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 在index位置插入一个元素
     * @param index
     * @param element
     */
    public void add(int index, E element){
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);

        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index; i < size; i++) {
            elements[i] = elements[i+1];
        }
        elements[--size] = null;
        trim();
        return old;
    }

    /**
     * 查看元素的索引
     * @param element
     * @return
     */
    public int indexOf(E element){
        if (element == null) {  // 如果是空，就比较值
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i; // 否则比较对象值
            }
        }
        return ELEMENT_NOT_FOUND;
    }



    /**
     * 保证capacity容量
     * @param capacity
     */
    private void ensureCapacity(int capacity){
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        //新容量为旧容量1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;

        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }
    
    private void trim() {
		int oldCapacity = elements.length;
		//新容量为旧容量一半
        int newCapacity = oldCapacity >> 1;
		if (size >= newCapacity || oldCapacity <= DEFAULT_CAPACITY) return;
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(oldCapacity + "缩容为" + newCapacity);
	}
    
    /**
     * 打印数组
     * @return
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(",[");
        for (int i = 0; i < size; i++) {
            if (i != 0 ) {
                string.append(", ");
            }
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }
}
