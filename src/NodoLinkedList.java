public class NodoLinkedList<T extends Comparable<T>>{
    private T valor;
    private NodoLinkedList<T> siguiente;
    private NodoLinkedList<T> anterioir;

    public NodoLinkedList(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoLinkedList<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLinkedList<T> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoLinkedList<T> getAnterioir() {
        return anterioir;
    }

    public void setAnterioir(NodoLinkedList<T> anterioir) {
        this.anterioir = anterioir;
    }
}
