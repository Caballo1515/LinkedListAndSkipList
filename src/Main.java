public class Main {

    public static void main(String[] args) {
	// write your code here
        int cantidadEnteros=1000;
        int mediaSkip, mediaDoble;
        int contadorSkip, contadorDoble;
        while (cantidadEnteros!=51000){
            DobleLinkedList<Integer> lista_desviacion = new DobleLinkedList<Integer>();
            DobleLinkedList<Integer> lista1_desviacion = new DobleLinkedList<Integer>();
            SkipList<Long> lista = new SkipList<Long>();
            DobleLinkedList<Long> lista1 = new DobleLinkedList<Long>();
            mediaDoble = 0;
            mediaSkip = 0;
            contadorDoble =0;
            contadorSkip = 0;
            for (int i = 0; i< cantidadEnteros; i++){
                long n = nRandom(cantidadEnteros);
                lista.Inserir(n);
                lista1.Inserir(n);
            }

            for (int i = 0; i< (cantidadEnteros); i++){
                long n =  nRandom(cantidadEnteros);
                try {
                    int aux = lista1.Buscar(n);
                    mediaDoble = mediaDoble +aux ;
                    lista1_desviacion.Inserir(aux);
                    contadorDoble++;
                }catch (RuntimeException e){
                    continue;
                }
                try {
                    int aux = lista.Buscar(n);
                    mediaSkip = mediaSkip + aux;
                    lista_desviacion.Inserir(aux);
                    contadorSkip++;
                }catch (Exception e){
                    continue;
                }
            }
            System.out.println(cantidadEnteros);
            System.out.println("Media SkipList: " + mediaSkip/(contadorSkip) + " Desviacion estandar:"+desviacionEstandar(lista_desviacion, mediaSkip/(contadorSkip))+"\n");
            System.out.println("Media Lista Doblemente Encadenada: " + mediaDoble/(contadorDoble) + " Desviacion estandar:"+desviacionEstandar(lista1_desviacion, mediaDoble/(contadorDoble))+"\n");
            cantidadEnteros = cantidadEnteros + 1000;
        }



    }


    public static long nRandom(int n){
        double x = Math.random()*(n/2)+1;
        return (long) Math.round(x);
    }

    public static double desviacionEstandar(DobleLinkedList<Integer> list, int media){
        double resultado = 0;
        int contador = 0;
        list.Principi();
        
        while (list.getPdi()!=list.getUltimo()){
            list.Avancar();
            resultado = resultado + Math.pow(list.getPdi().getValor()-media, 2);
            contador++;

        }
        resultado = Math.sqrt(resultado/contador);
        return resultado;
    }

}
