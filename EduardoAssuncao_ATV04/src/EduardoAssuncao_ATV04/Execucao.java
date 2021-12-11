package EduardoAssuncao_ATV04;

import java.util.Arrays;
import java.util.Scanner;

public class Execucao {
    public static void main(String[] args) {
        /*
        *
        *
        *APRESENTAÇÃO DOS DADOS DENTRO DO ARQUIVO EXEMPLO:
        *121;432;564;23;1;45;788;
        *
        */
        Scanner read = new Scanner(System.in);
        System.out.println("Informe o tamanho do array");
        int tamanho = read.nextInt();
        //String arq = "teste.txt";
        /*int[] dados = { 121, 432, 564, 23, 1, 45, 788 };
        int tamanho = dados.length;
        //System.out.println("Comprimento: "+dados.length);
        RadixSort radixSort = new RadixSort();
        System.out.println(Arrays.toString(dados));
        radixSort.radixSort(dados, tamanho);
        System.out.println();
        System.out.println("Ordenação em ordem crescente: ");
        System.out.println(Arrays.toString(dados));*/
        String ArqConfig = "C:\\Users\\Kenny\\Documents\\IntelliJProjects\\src\\testeLerArquivo\\TesteTexto.txt";
        //String ArqConfig = "conf.con";
        String conteudo = Arquivo.Read(ArqConfig);
        String[] valores = new String[tamanho];
        //System.out.println("Arquivo.Read: "+Arquivo.Read(ArqConfig).length());
        //System.out.println("Comprimento Conteudo.lenght: "+conteudo.length());
        //System.out.println("Comprimento ArqConfig.lenght: "+ArqConfig.length());
        //System.out.println("Comprimento Valores.lenght: "+valores.length);
        int[] valoresInt = new int[tamanho];
        for(int i = 0; i < tamanho;  i++){
            valores[i] = conteudo.split(";") [i];
            valoresInt[i] = Integer.parseInt(conteudo.split(";") [i]);
            //valoresInt[i] = Integer.parseInt(valores[i]);
        }
        //System.out.println("Comprimento valores: "+valores.length);
        /*for(int i = 0; i < 7;  i++){
            valoresInt[i] = Integer.parseInt(valores[i]);
        }*/
        /*for(int i = 0; i < 7;  i++){
            System.out.println("Valores: "+valoresInt[i]);
            //valoresInt[i] = Integer.parseInt(valores[i]);
        }*/
        System.out.println(Arrays.toString(valores));
        //String c1 = conteudo.split(";") [0];
        //String c2 = conteudo.split(";") [1];

        //System.out.println("Numero: "+c1);
        //System.out.println("Numero: "+c2);
        Arquivo arquivo = new Arquivo();
        RadixSort radixSort = new RadixSort();
        radixSort.radixSort(valoresInt, tamanho);
        //radixSort.lerArquivo();
    }
}
