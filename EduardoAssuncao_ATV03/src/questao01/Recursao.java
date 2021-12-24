package questao01;

public class Recursao {

    public int maior(int arr[], int tamanho) {
        if (tamanho == 1){//caso base em que temos apenas um valor armazenado no array
            return arr[0];
        }
        else {
            int x;
            x = maior(arr, tamanho - 1);//processo de empilhamento das opeações a serem desempilhadas e analisadas
            if (x > arr[tamanho-1]){
                return x;
            }else{
                return arr[tamanho-1];
            }
        }
    }

    public int menor(int arr[], int tamanho) {
        if (tamanho == 1){
            return arr[0];
        }
        else {
            int x;
            x = menor(arr, tamanho - 1);
            if (x < arr[tamanho-1]){
                return x;
            }else{
                return arr[tamanho-1];
            }
        }
    }
}
