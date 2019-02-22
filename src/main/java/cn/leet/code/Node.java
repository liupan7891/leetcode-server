package cn.leet.code;


/**
 * 节点元素
 * @author pan
 * @date 2019-02-21
 * @param <E>
 */
public class Node<E> {

	E item;
	Node<E> next; 
	Node<E> previous;

	Node(Node<E> previous, E element, Node<E> next) {
		this.item = element;
		this.next = next;
		this.previous = previous;
	}
}
