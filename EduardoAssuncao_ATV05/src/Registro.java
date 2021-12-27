public class Registro {
    private int key;
    private String nome;
    private String email;
    private Registro proximo;

    public Registro(){
        this.proximo = null;
    }
    public Registro(int key, String nome, String email){
        this.key = key;
        this.nome = nome;
        this.email = email;
        this.proximo = null;
    }

    public void setKey(int key){
        this.key = key;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setProximo(Registro proximo){
        this.proximo = proximo;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public int getKey(){
        return this.key;
    }
    public String getNome(){
        return nome;
    }

    public Registro getProximo(){
        return this.proximo;
    }

    public String getEmail(){
        return email;
    }

    public int hashCode(){
        return key % 100;
    }
}
