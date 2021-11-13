package listaCircularDuplamEncad;

public class MyApp {
    public static void main(String[] args) {
        ListaDuplaCircular lista = new ListaDuplaCircular();
        lista.inserir(87);
        lista.inserir(23);
        lista.inserir(71);
        lista.inserir(38);
        lista.inserir(973);

        lista.exibirNaOrdem();
        System.out.println("------------------------");
        lista.exibirNaOrdemInversa();
    }
}
