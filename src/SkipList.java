public class SkipList <T extends Comparable<T>> implements Base<T>{
    private NodoSkipList<T> head;

    public SkipList(){
        head = new NodoSkipList<>(null, 1);
    }

    public int nRandom(){
        int contador = 0;
        double p_nivel = 0.50;
        while (Math.random() <= p_nivel) {
            contador++;
            p_nivel = p_nivel / 2;
        }
        return contador;
    }

    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder();
        int nivel = head.getNivel();
        while (nivel != 0) {
            nivel = nivel - 1;
            NodoSkipList x = head.getSiguientes(nivel);

            aux.append("Nivel: ").append(nivel).append("\n");
            if (x != null) {
                aux.append(x.getValor());
                x = x.getSiguientes(nivel);
            }
            while (x != null) {
                aux.append(",").append(x.getValor());
                x = x.getSiguientes(nivel);

            }
            aux.append("\n");
        }

        return aux.toString();
    }

    @Override
    public void Crear() {

    }

    @Override
    public void Inserir(T data) {
        int nivel = nRandom();
        //En el caso de que la lista este vacia
        if(head.getSiguientes(0)==null){
            NodoSkipList<T> nuevoN = new NodoSkipList<>(data, nivel);
            head= new NodoSkipList<>(null, nivel);
            while (nivel>=0){
                head.setSiguientes(nuevoN, nivel);
                nivel--;
            }
        }else{
            //El caso de que la lista no esta vacia, primero creamos el nodo nuevo con los respectivos niveles y luego redimensionamos el head si hace falta
            NodoSkipList<T> nuevoN= new NodoSkipList<>(data, nivel);
            if(nivel>=head.getNivel()){
               NodoSkipList<T> newHead = new NodoSkipList<>(null, nivel);
               int nivel_head = head.getNivel();
               while (nivel_head>=0){
                   if(nivel_head>=head.getNivel()){
                       newHead.setSiguientes(null, nivel);
                   }else{
                       newHead.setSiguientes(head.getSiguientes(nivel_head), nivel_head);
                   }
                   nivel_head--;
               }
               head=newHead;
            }
            NodoSkipList aux = head;
            //Recorremos la lista hasta encontrar la posicion de nuestro nuevo nodo
            while (nivel>=0){
                if(head.getSiguientes(nivel) == null){
                    head.setSiguientes(nuevoN, nivel);
                } else {
                   while ((aux.getSiguientes(nivel) != null) && (aux.getSiguientes(nivel).getValor().compareTo(data) < 0)){
                       aux = aux.getSiguientes(nivel);
                   }
                   if(aux.getSiguientes(nivel) != null){
                       NodoSkipList x = aux.getSiguientes(nivel);
                       NodoSkipList y = aux;
                       aux.setSiguientes(nuevoN, nivel);
                       nuevoN.setSiguientes(x, nivel);
                       aux=y;

                   }else {
                       aux.setSiguientes(nuevoN, nivel);
                   }
                }
                nivel--;
            }
        }

    }

    @Override
    public void Esborrar(T data) {
        int nivel = head.getNivel()-1;
        NodoSkipList aux = head;
        //Recorremos la lista hasta encontrar la posicion del nodo no deseado
        while (nivel!=-1){
            while ((aux.getSiguientes(nivel) != null) && (aux.getSiguientes(nivel).getValor().compareTo(data) < 0)){
                aux = aux.getSiguientes(nivel);
                while (aux.getSiguientes(nivel) == null){
                    nivel--;
                    if (nivel ==-1) break;
                }
            }
            // Eliminamos dicho nodo
            while (aux.getSiguientes(nivel).getValor().compareTo(data)>0) nivel--;
            if(aux.getSiguientes(nivel).getValor() == data){
                NodoSkipList x = aux.getSiguientes(nivel);
                x = x.getSiguientes(nivel);
                if(aux==head) head.setSiguientes(x, nivel);
                else aux.setSiguientes(x, nivel);
                nivel--;
            } else {
                throw new RuntimeException("El valor no existe");
            }
        }

    }

    @Override
    public int Longitud() {
        //Recorre el nivel 0 hasta el final
        int contador = 0;
        NodoSkipList aux = head.getSiguientes(0);
        while (aux!=null){
            contador++;
            aux = aux.getSiguientes(0);
        }
        return contador;
    }

    @Override
    public int Buscar(T data) {
        int nivel = head.getNivel()-1;
        int contador = 1;
        NodoSkipList aux = head;
        while (nivel!=-1){
            //Recorre hasta la posicion donde deberia de estar el nodo
            while ((aux.getSiguientes(nivel) != null) && (aux.getSiguientes(nivel).getValor().compareTo(data) < 0)){
                aux = aux.getSiguientes(nivel);
                while (aux.getSiguientes(nivel) == null){
                    nivel--;
                    contador++;
                    if (nivel ==-1) throw new RuntimeException("ERROR no se ha encontrado el elemento, se ha accedido a "+ contador+" posiciones");
                }
                contador++;
            }
            //se comprueba si es el nodo buscado
            if( aux.getSiguientes(nivel) != null && aux.getSiguientes(nivel).getValor() == data) return contador;
            else if (nivel!=-1) nivel--;
            else throw new RuntimeException("ERROR no se ha encontrado el elemento, se ha accedido a "+ contador+" posiciones");
        }

        return contador;
    }
}
