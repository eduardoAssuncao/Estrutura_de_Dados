package pilha;

public class Pilha {
    private int valores[];
    private int topo;

    public Pilha() {
        valores = new int[10];
        topo = -1; //topo tem que aponta antes de um valor válido
    }

    public void push(int elemento) {
        topo = topo + 1;//avança o topo para uma posição válida
        valores[topo] = elemento;//adiciona o novo elemento na posição do topo
    }

    public boolean isEmpty() {
        return (topo == -1);
    }

    public boolean isFull() {
        return (topo == 9);
    }

    public int pop() {
        int elem = valores[topo];
        topo--;
        return elem;
    }
}