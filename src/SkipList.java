public class SkipList <T extends Comparable<T>> implements Base<T>{
    private NodoSkipList<T> head;

    public SkipList(){
        head = new NodoSkipList<T>(null,1);
    }

    public int nRandom(){
        double x = Math.random()*6;
        return (int)Math.round(x);
    }

    @Override
    public String toString() {
        String aux = "";
        int nivel = head.getNivel();
        while (nivel != 0) {
            nivel = nivel - 1;
            NodoSkipList<T> x = head.getSiguientes(nivel);

            aux = aux + "Nivel: " + nivel + "\n";
            if (x != null) {
                aux = aux + x.getValor();
                x = x.getSiguientes(nivel);
            }
            while (x != null) {
                aux = aux + "," + x.getValor();
                x = x.getSiguientes(nivel);

            }
            aux = aux + "\n";
        }

        return aux;
    }

    @Override
    public void Crear() {

    }

    @Override
    public void Inserir(T data) {
        int nivel = nRandom();
        if(head.getSiguientes(0)==null){
            NodoSkipList<T> nuevoN = new NodoSkipList<T>(data, nivel);
            head=new NodoSkipList<T>(null, nivel);
            while (nivel>=0){
                head.setSiguientes(nuevoN, nivel);
                nivel--;
            }
        }else{
            NodoSkipList<T> nuevoN=new NodoSkipList<T>(data, nivel);
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
            NodoSkipList<T> aux = head;
            while (nivel>=0){
                if(head.getSiguientes(nivel) == null){
                    head.setSiguientes(nuevoN, nivel);
                } else {
                   while ((aux.getSiguientes(nivel) != null) && (aux.getSiguientes(nivel).getValor().compareTo(data) < 0)){
                       aux = aux.getSiguientes(nivel);
                   }
                   if(aux.getSiguientes(nivel) != null){
                       NodoSkipList<T> x = aux.getSiguientes(nivel);
                       NodoSkipList<T> y = aux;
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
        NodoSkipList<T> aux = head;
        while (nivel!=-1){
            while ((aux.getSiguientes(nivel) != null) && (aux.getSiguientes(nivel).getValor().compareTo(data) < 0)){
                aux = aux.getSiguientes(nivel);
                while (aux.getSiguientes(nivel) == null){
                    nivel--;
                    if (nivel ==-1) break;
                }
            }
            while (aux.getSiguientes(nivel).getValor().compareTo(data)>0) nivel--;
            if(aux.getSiguientes(nivel).getValor() == data){
                NodoSkipList<T> x = aux.getSiguientes(nivel);
                x = x.getSiguientes(nivel);
                if(aux==head) head.setSiguientes(x, nivel);
                else aux.setSiguientes(x, nivel);
                nivel--;
            }
        }

    }

    @Override
    public int Longitud() {
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
        NodoSkipList<T> aux = head;
        while (nivel!=-1){
            while ((aux.getSiguientes(nivel) != null) && (aux.getSiguientes(nivel).getValor().compareTo(data) < 0)){
                aux = aux.getSiguientes(nivel);
                while (aux.getSiguientes(nivel) == null){
                    nivel--;
                    contador++;
                    if (nivel ==-1) throw new RuntimeException("ERROR no se ha encontrado el elemento, se ha accedido a "+ contador+" posiciones");
                }
                contador++;
            }
            while ( aux.getSiguientes(nivel).getValor().compareTo(data)>0 && nivel != 0) {
                nivel--;
                contador++;
            }
            if( aux.getSiguientes(nivel).getValor() == data) return contador;
            else throw new RuntimeException("ERROR no se ha encontrado el elemento, se ha accedido a "+ contador+" posiciones");


        }

        return contador;
    }
}
