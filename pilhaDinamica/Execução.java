package pilhaDinamica;

public class Execução {
    public static void main(String[] args) {

        /*
         * A funções a baixo são em relação a um arquivo já existente. Você pode realizar a inserção de item por item, mas também pode adicionar um
         * camilho para o seu arquivo.txt.... Na função LerArquivo, há uma chamada para a função push. Caso queira que as informações do
         * arquivo sejam inseridos de maneira diferente, altere a função do laço da função LerArquivo e os adicione pela classe main (aqui)
         */

        PilhaDin pilha = new PilhaDin();

        pilha.lerArquivo();

        System.out.println("Topo: "+ pilha.consultarTopo());

        while (!pilha.isEmpty()) {
            System.out.println("Valor: "+ pilha.pop());
        }
    }
}
