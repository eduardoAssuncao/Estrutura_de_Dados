package questao02;

import java.util.Scanner;

import static questao02.Arquivo.read;

public class Execucao {
    public static void main(String[] args) {
        int tamanho = 5;
        Recursao recursao = new Recursao();
        String ArqCaminho = "C:\\Users\\Kenny\\Documents\\IntelliJProjects\\EduardoAssuncao_ATV03\\src\\questao02\\dados01.txt";
        String conteudo = read(ArqCaminho);
        String[] teste = new String[tamanho];

        for (int i = 0; i < tamanho; i++) {
            teste[i] = conteudo.split(";")[i];
        }
        String resultado = recursao.prefixoComumMaisLongo(teste);
        System.out.print("Entrada 1: " + conteudo);
        System.out.println("Saída 1: O prefixo comum mais longo é " + resultado);

        ArqCaminho = "C:\\Users\\Kenny\\Documents\\IntelliJProjects\\EduardoAssuncao_ATV03\\src\\questao02\\dados02.txt";
        conteudo = read(ArqCaminho);
        teste = new String[tamanho];

        for (int i = 0; i < tamanho; i++) {
            teste[i] = conteudo.split(";")[i];
        }
        resultado = recursao.prefixoComumMaisLongo(teste);
        System.out.print("\nEntrada 2: " + conteudo);
        System.out.println("Saída 2: O prefixo comum mais longo é " + resultado);

        ArqCaminho = "C:\\Users\\Kenny\\Documents\\IntelliJProjects\\EduardoAssuncao_ATV03\\src\\questao02\\dados03.txt";
        conteudo = read(ArqCaminho);
        teste = new String[tamanho];

        for (int i = 0; i < tamanho; i++) {
            teste[i] = conteudo.split(";")[i];
        }
        resultado = recursao.prefixoComumMaisLongo(teste);
        System.out.print("\nEntrada 3: " + conteudo);
        System.out.println("Saída 3: O prefixo comum mais longo é " + resultado);
    }
}
