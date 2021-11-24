package listaDuplamenteEncadeada;


public class Execucao {
    public static void main(String[] args){
        ListaLigada lista = new ListaLigada();

        lista.lerArquivo();
        /*System.out.println(lista);
        lista.inserirFim(10);
        System.out.println(lista);
        lista.inserirFim(11);
        System.out.println(lista);
        lista.inserirFim(20);
        System.out.println(lista);

        lista.inserirMeio(1, 2);
        System.out.println(lista);

        lista.removerMeio(2);
        System.out.println(lista);

        lista.removerFim();
        System.out.println(lista);

        lista.removerInicio();*/
        System.out.println(lista);

        lista.removerMeio(2);
        System.out.println(lista);

        lista.removerInicio();
        System.out.println(lista);



        /*for (int i = 0; i < 6; i++){
            lista.adiciona("" + (int) (i + 97));
            System.out.println(lista);
        }

        System.out.println("--------------------------");
        lista.removerInicio();

        for (int i = 0; i < 6; i++){
            System.out.println(lista);
        }

        System.out.println("--------------------------");
        lista.inserirFim(200);

        for (int i = 0; i < 1; i++){
            System.out.println(lista);
        }

        System.out.println("--------------------------");
        lista.removerFim();

        for (int i = 0; i < 1; i++){
            System.out.println(lista);
        }

        System.out.println("--------------------------");
        lista.removerMeio(1);

        for (int i = 0; i < 1; i++){
            System.out.println(lista);
        }

        lista.lerArquivo();*/
    }
}
