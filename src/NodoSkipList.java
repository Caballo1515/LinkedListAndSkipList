public class NodoSkipList <T extends Comparable<T>> {
    private T valor;
    private NodoSkipList<T>[] siguientes;

    public NodoSkipList(T valor, int niveles){
        this.valor = valor;
        siguientes = new NodoSkipList[niveles];
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoSkipList<T> getSiguientes(int nivel) {
        return siguientes[nivel];
    }

    public void setSiguientes(NodoSkipList<T> siguiente, int nivel) {
        this.siguientes[nivel] = siguiente;
    }
}
