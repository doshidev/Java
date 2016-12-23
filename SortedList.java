/*
 * File:    BinarySearchTree.java
 * Date:    Dec 21, 2016
 * Student: Devang Doshi | UCID: dbd24
 * Course:  Programming, Data Structure, and Alogrithms | Section: CS50581
 * Desc:    Implementation of Binary Search Tree.
 */

import java.util.Iterator;

public class SortedList<E extends Comparable<? super E>> extends AbstractList<E> {


    @Override
    public void insert(E data) {
        Node<E> newNode = new Node<E>(data);
        if (head == null) {
            head = newNode;
        } else {
            insertHelper(head, newNode);
        }
    }

    private void insertHelper(Node<E> node, Node<E> newNode) {
        int compareResult = newNode.data.compareTo(node.data);
        if (compareResult <= 0) {
            newNode.next = node.next;
            node.next = newNode;
            E temp = newNode.data;
            newNode.data = node.data;
            node.data = temp;
        } else {
            insertHelper(node.next, newNode);
        }
    }

    @Override
    public void remove(E key) {
        head = removeHelper(head, key);
    }

    private Node<E> removeHelper(Node<E> node, E key) {
        if (node == null) return null;
        if (node.data.compareTo(key) == 0) {
            return node.next;
        } else {
            node.next = removeHelper(node.next, key);
            return node;
        }
    }
    @Override
    public E retrieve(int index) {
        return retrieveHelper(head, index);
    }

    private E retrieveHelper(Node<E> node, int remainingIndex) {
        if (node == null) return null;
        if (remainingIndex == 0) return node.data;
        return retrieveHelper(node.next, remainingIndex - 1);
    }

    public Node<E> head = null;
    @Override
    public boolean search(E key) {
        return searchHelper(head, key);
    }

    private boolean searchHelper(Node<E> node, E key) {
        if (node == null) return false;
        if (node.data.compareTo(key) == 0) return true;
        return searchHelper(node.next, key);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}