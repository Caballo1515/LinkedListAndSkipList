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
        System.out.println(lista.toString());


        /*
        DobleLinkedList<Integer> lista = new DobleLinkedList<Integer>();
        lista.Inserir(2);
        lista.Inserir(5);
        lista.Inserir(6);
        lista.Inserir(9);
        for (int i=0;i<100; i++ ){
            lista.Inserir(i);
            double x = Math.random()*6;
            System.out.println((int)Math.round(x));
        }
        lista.Principi();
        lista.Inserir(20);
        lista.Esborrar();
        lista.Esborrar(6);
        System.out.println(lista.Longitud());
        System.out.println(lista.toString());

         */
    }
}
