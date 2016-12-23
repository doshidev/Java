public interface Tree<E> extends Iterable<E> {
    void insert(E data);
    void remove(E key);
    boolean search(E key);
}
