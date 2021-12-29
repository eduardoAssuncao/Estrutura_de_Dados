public class MapaHash {
    private Registro valores[];

    public MapaHash(){
        valores = new Registro[100];
    }

    public void put (Registro registro){
        int posicao = registro.hashCode();
        if(valores[posicao] == null){
            valores[posicao] = registro;
            //System.out.println("=======Posicao vazia!! Novo Registro");
        }else{
            //System.out.println("Ops... Colisao >>>");
            Registro reg = valores[posicao];

            // especial para tratar o primeiro elemento
            if (reg.getKey() == registro.getKey()){ // o registro que quero inseir é o mesmo que
                reg.setNome(reg.getNome()); // apenas substituo o valor
                //System.out.println("É o primeiro Registro Existente - atualizando...");
                return;
            }
            // se ele tá no meio da lista
            while (reg.getProximo() != null){
                if (reg.getKey() == registro.getKey()){ // o registro que quero inseir é o mesmo que
                    reg.setNome(registro.getNome()); // apenas substituo o valor
                    //System.out.println("Tá no meio da lista - Registro Existente - atualizando");
                    return;
                }
                reg = reg.getProximo();
            }
            //se ele é o último da lista
                if(reg.getKey() == registro.getKey()){
                    reg.setNome(registro.getNome());
                    //System.out.println("É o último! Registro Existente - atualizando");
                    return;
                }
            reg.setProximo(registro); // coloquei o novo registro na última posição
            //System.out.println("Novo Registro!");
        }
    }

    public Registro get (int key){
        Registro r = new Registro();
        r.setKey(key);
        int posicao = r.hashCode();
        Registro resultado = valores[posicao]; // tento encontrar o registro
        if (resultado != null && resultado.getKey() == key){ // é o que eu tô procutando?
            return resultado;
        }else{
            while(resultado != null){ // enquanto tiver gente na lista...
                resultado = resultado.getProximo(); // vou para o próximo
                if (resultado != null && resultado.getKey() == key){ // é o cara?
                    return resultado; // se for, retorno ele
                }
            }
        }
        return null;
    }
}
