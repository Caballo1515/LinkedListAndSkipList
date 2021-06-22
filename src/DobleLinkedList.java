
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
        //Se borra el elemento que es apuntado con el pdi
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
    public IteratorList<T> iterator() {
        return new IteratorList<>(this);
    }

    @Override
    public void Crear() {

    }

    @Override
    public void Inserir(T data) {
        NodoLinkedList<T> nodo = new NodoLinkedList<>(data);
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
        //Borramos el elemento que entra por parametro
        if(primero==null){
            throw new RuntimeException("Lista vacia");
        }else{
            IteratorList<T> iterator =  this.iterator();
            while (iterator.hasNext() && (iterator.getIterator().getValor()!=data)){
                iterator.next();
            }
            if(iterator.getIterator().getValor()!=data){
                throw new RuntimeException("No esta el valor buscado");
            }else{
                if(iterator.getIterator()==primero){
                    if(iterator.getIterator().getSiguiente()==null){
                        pdi = null;
                        primero= null;
                        ultimo= null;
                    }else {
                        NodoLinkedList<T> aux = iterator.getIterator().getSiguiente();
                        aux.setAnterioir(null);
                        Avancar();
                        primero=aux;
                    }
                }else {
                    if (iterator.getIterator() == ultimo) {
                        NodoLinkedList<T> aux = iterator.getIterator().getAnterioir();
                        aux.setSiguiente(null);
                        Retrocedir();
                        ultimo = aux;
                    } else {
                        if(pdi == iterator.getIterator()){
                            pdi = iterator.getIterator().getSiguiente();
                        }
                        NodoLinkedList<T> siguiente = iterator.getIterator().getSiguiente();
                        NodoLinkedList<T> anterior = iterator.getIterator().getAnterioir();
                        siguiente.setAnterioir(anterior);
                        anterior.setSiguiente(siguiente);
                    }
                }
            }
        }

    }

    @Override
    public int Longitud() {
        int contador = 0;
        for (T ignored : this) {
            contador++;
        }
        contador++;
        return contador;
    }

    @Override
    public int Buscar(T data) {
        int contador = 1;
        IteratorList<T> iterator = this.iterator();
        while (!(iterator.getIterator().getValor().compareTo(data) ==0) && iterator.getIterator()!=ultimo){
            contador++;
            iterator.next();
        }
        if(!(iterator.getIterator().getValor().compareTo(data)==0)){
            throw new RuntimeException("No existe este valor, se ha utilizado "+ contador + " veces la funcion");
        }
        return contador;
    }

    @Override
    public String toString(){
        StringBuilder lista = new StringBuilder();
        IteratorList<T> iterator = this.iterator();
        if(primero!=null){
            do{
                lista.append("<").append(iterator.next()).append(">");
            }while (iterator.hasNext());
            lista.append("<").append(iterator.getIterator().getValor()).append(">");
        }

        return lista.toString();
    }
}
