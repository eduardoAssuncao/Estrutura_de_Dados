package pilhaDinamica2;

public class Execucao {
    public static void main(String[] args) {
        PilhaDinamica2 pilha = new PilhaDinamica2();

        pilha.inserir("A");
        pilha.inserir("B");
        pilha.inserir("C");
        System.out.println("Retirar: " + pilha.remover());
        pilha.inserir("D");

        Object aux;
        while((aux = pilha.remover()) != null){
            System.out.println("Retirar: " + aux);
        }

    }
}
