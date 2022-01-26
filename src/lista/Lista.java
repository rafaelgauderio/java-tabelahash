package lista;

public class Lista {

    private String nome;
    private String Descricao;
    private Lista proximo;

    public Lista() {

    }

    public Lista(String nome, String descricao, Lista proximo) {
        this.nome = nome;
        Descricao = descricao;
        this.proximo = proximo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public Lista getProximo() {
        return proximo;
    }

    public void setProximo(Lista proximo) {
        this.proximo = proximo;
    }

}
