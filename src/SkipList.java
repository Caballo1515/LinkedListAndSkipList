public class SkipList <T extends Comparable<T>> implements Base<T>{
    private NodoSkipList<T> head;

    public SkipList(){
        head = new NodoSkipList<T>(null,1);
    }


    @Override
    public void Crear() {

    }

    @Override
    public void Inserir(T data) {

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
