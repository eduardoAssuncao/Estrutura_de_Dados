import java.util.Arrays;
import java.util.Scanner;

public class MinhaApp02 {
    public static void main(String[] args) {
        java.util.Scanner teclado = new java.util.Scanner(System.in);
        //String texto[] = new String[3];
        String texto;
        int id;
        int continua;
        MapaHash mapa = new MapaHash();

        Registro r = new Registro();

        /*Scanner read = new Scanner(System.in);
        System.out.println("Informe o tamanho do array");
        int tamanho = read.nextInt();

        String ArqConfig = "C:\Users\Kenny\Documents\IntelliJProjects\EduardoAssuncao_ATV05\src\dados01.txt";
        String conteudo = Arquivo.Read(ArqConfig);
        String[] valores = new String[tamanho];

        int[] valoresInt = new int[tamanho];
        for(int i = 0; i < tamanho;  i++){
            valores[i] = conteudo.split(";") [i];
            valoresInt[i] = Integer.parseInt(conteudo.split(";") [i]);
        }
        System.out.println(Arrays.toString(valores));
        r.(valoresInt, tamanho);*/

        String ArqConfig = "C:\\Users\\Kenny\\Documents\\IntelliJProjects\\EduardoAssuncao_ATV05\\src\\dados01.txt";
        String conteudo = Arquivo.Read(ArqConfig);
        String[] valores = new String[3];

        String[] teste = new String[3];
        //int[] valoresInt = new int[3];
        for(int i = 0; i < 3;  i++){
            //teste[i] = conteudo.split(";")[i];
            valores[i] = conteudo.split(";") [i];
            //valoresInt[i] = Integer.parseInt(conteudo.split(";") [0]);
            id = Integer.parseInt(valores[0]);
            //id = valoresInt[0];
            texto = valores[0] + valores[1] + valores[2];
            r = new Registro(id, texto);
            System.out.println("ID: "+id+" Texto: "+texto);
        }
        mapa.put(r);

        /*int i = 0;
        do {
            //System.out.println("Digite uma id");
            teste[i] = conteudo.split(";")[i];
            valores[i] = conteudo.split(";") [i];
            id = Integer.parseInt(valores[0]);
            texto = valores[0] + valores[1] + valores[2];
            i++;
            //texto = teclado.next();
            //id = Integer.parseInt(texto);
            //System.out.println("Digite um valor");
            //texto = teclado.next();

            r = new Registro(id, texto);
            mapa.put(r);
        }while(i != 3);*/

        //-----------------------------------------------------
        /*do {
            System.out.println("Digite uma id");
            texto = teclado.next();
            id = Integer.parseInt(texto);
            System.out.println("Digite um valor");
            texto = teclado.next();

            r = new Registro(id, texto);
            mapa.put(r);

            System.out.println("Continua? (1-sim / 0-nao)");
            continua = Integer.parseInt(teclado.next());
        }while(continua != 0);*/
        System.out.println("=================================");
        do {
            System.out.println("Digite uma id");
            id = Integer.parseInt(teclado.next());
            r = mapa.get(id);
            if (id != -1) {
                if (r != null) {
                    System.out.println("Registro = " + r.getValue());
                } else {
                    System.out.println("Não existe");
                }
            }
        }while (id != -1);
    }
}
