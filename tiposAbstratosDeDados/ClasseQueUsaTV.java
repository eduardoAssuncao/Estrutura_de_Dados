package tiposAbstratosDeDados;

public class ClasseQueUsaTV {
    public static void main(String[] args) {
        Televisao t = new Televisao();
        t.defineMarca("Samsung");
        t.ligar();
        t.defineVolume(10);
        t.defineCanal(4);
        t.aumentaVolume();
        t.desligar();
    }
}
