import java.util.Iterator;

public class DobleLinkedList <T extends Comparable<T>> implements  Iterable<T>, Base<T>{
    NodoLinkedList<T> primero;
    NodoLinkedList<T> ultimo;
    NodoLinkedList<T> pdi;

    public DobleLinkedList() {
        this.primero = null;
        this.ultimo = null;
        this.pdi = null;
    }



    public NodoLinkedList<T> getPrimero() {
        return primero;
    }

    public void setPrimero(NodoLinkedList<T> primero) {
        this.primero = primero;
    }

    public NodoLinkedList<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoLinkedList<T> ultimo) {
        this.ultimo = ultimo;
    }

    public NodoLinkedList<T> getPdi() {
        return pdi;
    }

    public void setPdi(NodoLinkedList<T> pdi) {
        this.pdi = pdi;
    }

    public NodoLinkedList<T> Actual(){
        return pdi;
    }

    public void Principi(){
        this.pdi=this.primero;
    }

    public void Final(){
        this.pdi = this.ultimo;
    }

    public void Avancar(){
            pdi = pdi.getSiguiente();
    }

    public void Retrocedir(){
            pdi = pdi.getAnterioir();
    }

    public  void  Esborrar(){
        if(primero==null){
            throw new RuntimeException("Lista vacia");
        }else{
            if(pdi==primero){
                if(pdi.getSiguiente()==null){
                    pdi = null;
                    primero= null;
                    ultimo= null;
                }else {
                    NodoLinkedList<T> aux = pdi.getSiguiente();
                    aux.setAnterioir(null);
                    Avancar();
                    primero=aux;
                }
            }else {
                if(pdi==ultimo){
                    NodoLinkedList<T> aux = pdi.getAnterioir();
                    aux.setSiguiente(null);
                    Retrocedir();
                    ultimo= aux;
                }else {
                    NodoLinkedList<T> siguiente = pdi.getSiguiente();
                    NodoLinkedList<T> anterior = pdi.getAnterioir();
                    siguiente.setAnterioir(anterior);
                    anterior.setSiguiente(siguiente);
                    pdi=siguiente;
                }
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorList<T>(this);
    }

    @Override
    public void Crear() {

    }

    @Override
    public void Inserir(T data) {
        NodoLinkedList<T> nodo = new NodoLinkedList<T>(data);
        if(primero==null){
            primero= nodo;
            ultimo = nodo;
            pdi = nodo;
            primero.setAnterioir(null);
            ultimo.setSiguiente(null);
        }else{
            NodoLinkedList<T> aux = pdi;
            aux = aux.getSiguiente();
            if(aux==null){
                nodo.setAnterioir(pdi);
                pdi.setSiguiente(nodo);
                Avancar();
                ultimo=pdi;
            }else{
                aux.setAnterioir(nodo);
                pdi.setSiguiente(nodo);
                nodo.setSiguiente(aux);
                nodo.setAnterioir(pdi);
                Avancar();
            }
        }
    }

    @Override
    public void Esborrar(T data) {

    }

    @Override
    public int Longitud() {
        return 0;
    }

    @Override
    public int Buscar(T data) {
        return 0;
    }
}
