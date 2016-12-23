public abstract class BinaryTree<E> implements Tree<E> {

    protected class Node<T> {
        protected Node(T data) {
            this.data = data;
        }
        protected T data;
        protected Node<T> left;
        protected Node<T> right;
    }

    protected Node<E> root;
}
