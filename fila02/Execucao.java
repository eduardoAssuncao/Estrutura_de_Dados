package fila02;

public class Execucao {
    public static void main(String[] args) {
        Fila02 fila = new Fila02();

        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        while(!fila.vazia()){
            System.out.println(fila.remover());
        }

        fila.inserir(4);
        fila.inserir(5);
        fila.inserir(6);

        System.out.println("Consulta: "+ fila.consultarElem(0));
    }
}
