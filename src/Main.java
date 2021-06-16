public class Main {

    public static void main(String[] args) {
	// write your code here


        SkipList<Integer> lista = new SkipList<Integer>();
        lista.Inserir(8);
        lista.Inserir(6);
        lista.Inserir(2);
        lista.Esborrar(6);
        lista.Inserir(5);
        lista.Inserir(9);
        for (int i = 0; i< 10000; i++){
            lista.Inserir(i);
        }


        System.out.println(lista.Buscar(4000));
        System.out.println(lista.toString());



        DobleLinkedList<Integer> lista1 = new DobleLinkedList<Integer>();
        lista1.Inserir(2);
        lista1.Inserir(5);
        lista1.Inserir(6);
        lista1.Inserir(9);
        for (int i=0;i<10000; i++ ){
            lista1.Inserir(i);
        }
        lista1.Principi();
        lista1.Inserir(20);
        lista1.Esborrar(2);
        lista1.Esborrar(6);
        System.out.println(lista1.Longitud());
        System.out.println(lista1.toString());
        System.out.println(lista1.Buscar(4000));


    }
}
