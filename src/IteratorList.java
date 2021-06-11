import java.util.Iterator;
public class IteratorList <T extends Comparable<T>> implements Iterator<T>{
    NodoLinkedList<T> iterator;

    public IteratorList(DobleLinkedList<T> list) {
        this.iterator = list.getPrimero();
    }

    public NodoLinkedList<T> getIter() {
        return iterator;
    }

    public void setIter(NodoLinkedList<T> iter) {
        this.iterator = iter;
    }

    @Override
    public boolean hasNext() {
        return iterator.getSiguiente()!=null;
    }

    @Override
    public T next() {
        T valor = iterator.getValor();
        iterator = iterator.getSiguiente();
        return valor;
    }
}
