package com.zksir.circle;

import org.omg.CORBA.Current;

import com.zksir.AbstractList;

public class CircleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;
    private Node<E> current;
    private static class Node<E>{
        E element;
        Node<E> prev;
        Node<E> next;
        Node<E> current;

        public Node(Node<E> prev,E element, Node<E> next) {
        	this.prev = prev;
            this.element = element;
            this.next = next;
        }
        
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			
			if (prev != null) {
				sb.append(prev.element);
			} else {
				sb.append("null");
			}
			
			sb.append("_").append(element).append("_");

			if (next != null) {
				sb.append(next.element);
			} else {
				sb.append("null");
			}
			
			return sb.toString();
		}
    }
    
    /**
     * 重置节点
     */
    public void reset() {
		current = first;
	}
    
    /**
     * 当前节点的下一个节点
     * @return
     */
    public E next() {
    	if (current == null) return null;
    	
    	current = current.next;
		return current.element;
	}
    
    /**
     * 删除当前节点
     * @return
     */
    public E remove() {
    	if (current == null) return null;
    	Node<E> next = current.next;
    	E element = remove(current);
    	if (size == 0) {
			current = null;
		} else {
			current = next;
		}
		return element; 
	}

    /**
     * 根据元素删除某个节点
     * @param node
     * @return
     */
    private E remove(Node<E> node) {
    	if (size == 1) {
			first = null;
			last = null;
		} else {
	        Node<E> prev = node.prev;
	        Node<E> next = node.next;
	        prev.next = next;
	        next.prev = prev;
	        
	        if (node == first) {// index == 0
				first = next;
			}
	        if (node == last) {// index == size - 1
				last = prev;
			}
		}
        size--;
        return node.element;
    }
    
    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
        /**
         * 虚拟机，只要没有被g c root这个对象引用，就会被回收
         * g c 对象
         * 1> 被栈指针指向的对象（可以粗暴理解为局部变量）
         * 
         */
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
    	rangeCheckForAdd(index);
    	
    	if (index == size) {// 往最后面添加元素
	    	Node<E> oldLast = last;
    		last = new Node<>(oldLast, element, first);
    		if (oldLast == null) { // 这是链表添加的第一个元素
				first = last;
				first.next = first;
				first.prev = first;
			} else {
				oldLast.next = last;
				first.prev = last;
			}
		} else {
			Node<E> next = node(index);
	    	Node<E> prev = next.prev;
	    	Node<E> node = new Node<>(prev, element, next);
	    	next.prev = node;
	    	prev.next = node;
	    	if (next == first) {// index == 0
				first = node;
			}
		}
        size++;
    }

    @Override
    public E remove(int index) {
    	rangeCheck(index);
        return remove(node(index));
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {  // 如果是空，就比较值
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i; // 否则比较对象值
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取index位置节点对象
     * @param index
     * @return
     */
    private Node<E> node(int index){
        rangeCheck(index);
        if (index < (size << 1)) {
        	Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
		} else {
			Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
		}
    }
    /**
     * 打印数组
     * @return
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(",[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0 ) {
                string.append(", ");
            }
            string.append(node);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }

}
