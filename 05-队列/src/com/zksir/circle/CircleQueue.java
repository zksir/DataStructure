package com.zksir.circle;

@SuppressWarnings("unchecked")
public class CircleQueue<E> {
	
	private int front;
	private int size;
	private E[] elements;
    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;
    
	public CircleQueue() {
    	elements = (E[]) new Object[DEFAULT_CAPACITY];
    }
	
	public int size() {
		return size;
	}
	
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[index(i)] = null;
		}
		size = 0;
		front = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void enQueue(E element) {
		ensureCapacity(size + 1);
		elements[index(size)] = element;
		size++;
	}
	
	public E deQueue() {
		E frontElement = elements[front];
		elements[front] = null;
		front = index(1);
		size--;
		return frontElement;
	}
	
	public E front() {
		return elements[front];
	}
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("capcacity=").append(elements.length)
		.append(" size=").append(size)
		.append(" front=").append(front)
		.append(", [");
		for (int i = 0; i < elements.length; i++) {
			if (i != 0) {
				string.append(", ");
			}
			
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();
	}
	
	private int index(int index) {
		return (front + index) % elements.length;
	}
	
	/**
	 * 保证要有capacity的容量
	 * @param capacity
	 */
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		// 新容量为旧容量的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[index(i)];
		}
		elements = newElements;
		
		// 重置front
		front = 0;
	}
}
