package cn.leet.code;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 双向链表倒置功能实现
 * @author pan
 * @date 2019-02-21
 * @param <E>
 */
public class LeetCodeLinkedList<E> {
	transient Node<E> first;
    transient Node<E> last;
    transient int size = 0;


    /**
     * 返回列表中的元素个数.
     */
    public int size() {
        return size;
    }


    /**
     * 将指定的元素追加到列表的末尾.
     * @param e element to be appended to this list
     */
    public void add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    /**
     * 返回列表中指定位置的元素
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(String.format("Index out of bound %d", index));
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x.item;

        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.previous;
            return x.item;
        }
    }

	/**
	* 颠倒指定列表中的元素的顺序
	*/
	public void reverse() {
	    if(first == null || first.next == null) {
	        return;
	    }
	    Node<E> temp = first;
	    first = last;
	    last = temp;
	
	    Node<E> node = first;
	    while(node != null) {
	        temp = node.next;
	        node.next = node.previous;
	        node.previous = temp;
	        node = node.next;
	    }
	}
 
	/**
	 * 返回列表中元素的列表迭代器
	 * @throws NoSuchElementException
	 * @throws IllegalStateException
	 * @throws RuntimeException
	 */
    public Iterator<E> iterator() {
        return new Itr();
    }

	private class Itr implements Iterator<E> {
	
	    int cursor = 0;
	    int lastRet = -1;
	
	    public boolean hasNext() {
	        return cursor != size();
	    }
	
	    public E next() {
	        try {
	            E next = get(cursor);
	            lastRet = cursor++;
	            return next;
	        } catch (IndexOutOfBoundsException e) {
	            throw new NoSuchElementException();
	        }
	    }
	
	    @Override
	    public void remove() {
	        if (lastRet == -1)
	            throw new IllegalStateException();
	        throw new RuntimeException("remove is denied");
	    }
	}

}
