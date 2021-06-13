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
