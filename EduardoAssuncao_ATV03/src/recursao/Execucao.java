package recursao;

import java.util.Scanner;

public class Execucao {
    public static void main(String[] args) {
        //int arr[] = {120, 150, 15, 1234, 2};
        Recursao recursao = new Recursao();
        //System.out.println("Maior: "+recursao.maior(arr, 5));
        //System.out.println("Menor: "+recursao.menor(arr, 5));

        Scanner read = new Scanner(System.in);
        System.out.println("Informe o tamanho do array");
        int tamanho = read.nextInt();

        String ArqConfig = "C:\\Users\\Kenny\\Documents\\IntelliJProjects\\src\\testeLerArquivo\\dados.txt";
        String conteudo = Arquivo.Read(ArqConfig);
        String[] valores = new String[tamanho];

        int[] valoresInt = new int[tamanho];
        for(int i = 0; i < tamanho;  i++){
            valores[i] = conteudo.split(";") [i];
            valoresInt[i] = Integer.parseInt(conteudo.split(";") [i]);
        }
        //System.out.println(Arrays.toString(valores));
        //RadixSort radixSort = new RadixSort();
        System.out.println("Maior valor: "+recursao.maior(valoresInt, tamanho));
        System.out.println("Menor valor: "+recursao.menor(valoresInt, tamanho));
    }
}
