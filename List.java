public interface List<E> extends Iterable<E> {
    void insert(E data);
    void remove(E key);
    E retrieve(int index);
    boolean search(E key);
}