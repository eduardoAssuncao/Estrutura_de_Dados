package listaDuplamenteEncadeada;


public class Execucao {
    public static void main(String[] args){

        /*
        * A funções a baixo são em relação a um arquivo já existente. Você pode realizar a inserção de item por item, mas também pode adicionar um
        * camilho para o seu arquivo.txt.... Na função LerArquivo, há uma chamada para a função inserirInicio. Caso queira que as informações do
        * arquivo sejam inseridos de maneira diferente, altere a função do laço da função LerArquivo e os adicione pela classe main (aqui)
        */

        ListaLigada lista = new ListaLigada();


        lista.lerArquivo();
        System.out.println(lista);

        lista.removerMeio(2);
        System.out.println(lista);

        lista.removerInicio();
        System.out.println(lista);
    }
}
