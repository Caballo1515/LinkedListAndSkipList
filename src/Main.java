public class Main {

    public static void main(String[] args) {
	// write your code here
        DobleLinkedList<Integer> lista = new DobleLinkedList<Integer>();
        lista.Inserir(2);
        lista.Inserir(5);
        lista.Inserir(6);
        lista.Inserir(9);
        for (int i=0;i<100; i++ ){
            lista.Inserir(i);
        }
        lista.Principi();
        lista.Inserir(20);
        lista.Esborrar();
        lista.Esborrar(6);
        System.out.println(lista.Longitud());
        System.out.println(lista.toString());
    }
}
