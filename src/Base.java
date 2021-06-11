public interface Base<T> {
    void Crear();
    void Inserir(T data);
    void Esborrar(T data);
    int Longitud();
    int Buscar(T data);
}
