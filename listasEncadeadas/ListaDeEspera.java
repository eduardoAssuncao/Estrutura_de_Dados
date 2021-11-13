package listasEncadeadas;

import java.awt.print.PrinterGraphics;

public class ListaDeEspera {
    public static void main(String[] args) {
        String elementosR = "";
        Lista lista = new Lista();
        lista.inserir(872);
        lista.inserir(123);
        lista.inserir(1597);
        lista.inserir(2);

        while (!lista.isEmpty()){
            int e = lista.retirar();
            elementosR += Integer.toString(e)+"-";
            System.out.println("Retirei o elemento "+e);
        }
        System.out.println("Elementos retirandos "+elementosR);
    }
}
