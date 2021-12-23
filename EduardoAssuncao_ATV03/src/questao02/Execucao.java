package questao02;

import java.util.Scanner;

public class Execucao {
    public static void main(String[] args) {
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
        Recursao recursao = new Recursao();


    }
}
