public class Main {

    public static void main(String[] args) {
        int cantidadEnteros=1000;
        int mediaSkip, mediaDoble;
        int contadorSkip, contadorDoble;
        //bucle para hacer las 50 pruebas
        while (cantidadEnteros!=51000){
            DobleLinkedList<Integer> lista_desviacion = new DobleLinkedList<>();
            DobleLinkedList<Integer> lista1_desviacion = new DobleLinkedList<>();
            SkipList<Long> lista = new SkipList<>();
            DobleLinkedList<Long> lista1 = new DobleLinkedList<>();
            mediaDoble = 0;
            mediaSkip = 0;
            contadorDoble =0;
            contadorSkip = 0;
            //Insertar numeros aleatorios entre 1 y cantidad de entreros / 2
            for (int i = 0; i< cantidadEnteros; i++){
                long n = nRandom(cantidadEnteros);
                lista.Inserir(n);
                lista1.Inserir(n);
            }
            //hacer las busquedas
            for (int i = 0; i< (cantidadEnteros); i++){
                long n =  nRandom(cantidadEnteros);
                //Busqueda Lista Doblemente Encadenada
                try {
                    int aux = lista1.Buscar(n);
                    mediaDoble = mediaDoble +aux ;
                    lista1_desviacion.Inserir(aux);
                    contadorDoble++;
                }catch (RuntimeException e){
                    //En el caso que no se encuentra el dato buscado
                    continue;
                }
                //Busqueda SkipList
                try {
                    int aux = lista.Buscar(n);
                    mediaSkip = mediaSkip + aux;
                    lista_desviacion.Inserir(aux);
                    contadorSkip++;
                }catch (Exception e){
                    //En el caso que no se encuentra el dato buscado
                    continue;
                }
            }
            //Imprimimos por pantalla
            System.out.println(cantidadEnteros);
            //Llamamos la funcion desviavionEsetandar();
            System.out.println("Media SkipList: " + mediaSkip/(contadorSkip) + " Desviacion estandar:"+desviacionEstandar(lista_desviacion, mediaSkip/(contadorSkip))+"\n");
            System.out.println("Media Lista Doblemente Encadenada: " + mediaDoble/(contadorDoble) + " Desviacion estandar:"+desviacionEstandar(lista1_desviacion, mediaDoble/(contadorDoble))+"\n");
            //Aumentamos la cantidad de enteros en 1000
            cantidadEnteros = cantidadEnteros + 1000;
        }



    }


    public static long nRandom(int n){
        double x = Math.random()*(n/2)+1;
        return Math.round(x);
    }

    public static double desviacionEstandar(DobleLinkedList<Integer> list, int media){
        /*
                ________________________
               / Sumatorio((x-media)^2)
              /  ----------------------
            \/      cantidad_numeros

         */
        double resultado = 0;
        int contador = 0;
        list.Principi();
        //Generando el sumatorio
        while (list.getPdi()!=list.getUltimo()){
            list.Avancar();
            resultado = resultado + Math.pow(list.getPdi().getValor()-media, 2);
            contador++;

        }
        //Haciendo la division de sumatorio entre cantidad de numeros y la raiz cuadrada deñ resultado
        resultado = Math.sqrt(resultado/contador);
        return resultado;
    }

}
