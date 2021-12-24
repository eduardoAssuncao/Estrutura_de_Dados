package questao01;

public class Recursao {

    //função recusiva responsável por determinar o menor valor do array
    public int maior(int arr[], int tamanho) {
        int maior, x;
        if (tamanho == 1){//caso base em que temos apenas um valor armazenado no array
            return arr[0];
        }
        else {
            x = maior(arr, tamanho - 1);//processo de empilhamento dos valores a serem desempilhados e analisados
            if (x > arr[tamanho-1]){//análise feita no processo de desempilhamento
                maior = x;
                return maior;
            }else{
                return arr[tamanho-1];
            }
        }
    }

    //função recusiva responsável por determinar o menor valor do array
    public int menor(int arr[], int tamanho) {
        int menor, y;
        if (tamanho == 1){//caso base em que temos apenas um valor armazenado no array
            return arr[0];
        }
        else {
            y = menor(arr, tamanho - 1);//processo de empilhamento dos valores a serem desempilhados e analisados
            if (y < arr[tamanho-1]){//análise feita no processo de desempilhamento
                menor = y;
                return menor;
            }else{
                return arr[tamanho-1];
            }
        }
    }
}
