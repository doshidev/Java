/*
 * File:    BinarySearchTree.java
 * Date:    Dec 21, 2016
 * Student: Devang Doshi | UCID: dbd24
 * Course:  Programming, Data Structure, and Alogrithms | Section: CS50581
 * Desc:    Implementation of Binary Search Tree.

/**
 *
 * @author Devang
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {

    public Node<E> getRoot(){
        return root;
    }

    @Override
    public void insert(E data) {
        Node<E> newNode = new Node<E>(data);
        if (root == null) {
            root = newNode;
        } else {
            InsertHelper(root, newNode);
        }
    }

    private void InsertHelper(Node<E> node, Node<E> newNode) {
        int compareResult = node.data.compareTo(newNode.data);
        if (compareResult <= 0) {
            if (node.right == null) {
                node.right = newNode;
            } else {
                InsertHelper(node.right, newNode);
            }
        } else {
            if (node.left == null) {
                node.left = newNode;
            } else {
                InsertHelper(node.left, newNode);
            }
        }
    }

    @Override
    public void remove(E key) {
        root = RemoveHelper(root, key);
    }

    private E findMinimum(Node<E> node) {
        if (node.left == null) return node.data;
        return findMinimum(node.left);
    }

    private Node<E> RemoveHelper(Node<E> node, E key) {
        int compareResult = node.data.compareTo(key);

        if (compareResult < 0) {
            node.right = RemoveHelper(node.right, key);
        } else if (compareResult > 0) {
            node.left = RemoveHelper(node.left, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            E minValue = findMinimum(node.right);
            node.data = minValue;
            RemoveHelper(node.right, minValue);
        }
        return node;
    }

    @Override
    public boolean search(E key) {
        return SearchHelper(this.root, key);
    }

    private boolean SearchHelper(Node<E> node, E key) {
        if (node == null) return false;
        int compareResult = node.data.compareTo(key);
        if (compareResult == 0) return true;
        return compareResult < 0 ? SearchHelper(node.right, key) : SearchHelper(node.left, key);
    }

    public class BinarySearchTreeIterator implements Iterator<E> {

        private List<E> elements = new ArrayList<E>();
        private int index = 0;

        public BinarySearchTreeIterator(BinarySearchTree<E> tree)
        {
            InOrder(tree.getRoot());
        }

        private void InOrder(Node<E> node) {
            if (node == null) return;
            InOrder(node.left);
            elements.add(node.data);
            InOrder(node.right);
        }


        @Override
        public boolean hasNext() {
            return (index < elements.size());
        }

        @Override
        public E next() {

            if(!hasNext()) return null;
            E temp = elements.get(index);
            index++;
            return temp;
        }

        @Override
        public void remove() {

        }

    }

    public Iterator<E> iterator() {
        return new BinarySearchTreeIterator(this);
    }

}

