package lista;

import lista.Lista;

public class ListaDinamica {

    Lista primeiro;
    Lista ultimo;
    int tamanho =0;

    public ListaDinamica() {
        primeiro=null;
        ultimo=primeiro;
    }

    public Lista getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Lista primeiro) {
        this.primeiro = primeiro;
    }

    public Lista getUltimo() {
        return ultimo;
    }

    public void setUltimo(Lista ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void adicionar(String nome, String descricao) {

            if(primeiro==null) {
                primeiro = new Lista();
                ultimo=primeiro;
                Lista novaLista = new Lista();
                novaLista.setNome(nome);
                novaLista.setDescricao(descricao);
                novaLista.setProximo(null);
                ultimo.setProximo(novaLista);
                ultimo=novaLista;
                tamanho++;
            } else {
                Lista novaLista = new Lista();
                novaLista.setNome(nome);
                novaLista.setDescricao(descricao);
                novaLista.setProximo(null);
                ultimo.setProximo(novaLista);
                ultimo=novaLista;
                tamanho++;
            }

    }

    public void imprime() {

        Lista percorre = primeiro.getProximo();
        while(percorre != null) {
            System.out.println("Nome: " + percorre.getNome());
            System.out.println("Descricação: " + percorre.getDescricao() );
            percorre = percorre.getProximo();

        }

    }

    public void removeItem(String nome) {

        Lista remove = primeiro.getProximo();
        Lista sentinela = primeiro;

        if (!(primeiro==null)) {

            while( remove != null) {
                if (remove.getNome().equals(nome)) {
                    if (remove.getProximo() == null) {
                        ultimo = sentinela;
                        ultimo.setProximo(null);
                        remove = null;
                        tamanho--;
                        break;
                    } else {
                        sentinela.setProximo(remove.getProximo());
                        remove.setProximo(null);
                        remove = null;
                        tamanho--;
                        break;

                    }
                }
                remove = remove.getProximo();
                sentinela = sentinela.getProximo();
            }

        }

    }

    public void buscaItem(String palavra) {
        Lista percorre = primeiro.getProximo();
        int encontrado=0;
        while (percorre != null) {
            if(percorre.getNome().toLowerCase().equals(palavra.toLowerCase())) {
                System.out.println("Palavra: " + percorre.getNome());
                System.out.println("Descrição: " + percorre.getDescricao());
                encontrado=1;
                break;
            }
            percorre=percorre.getProximo();
        }
        if (encontrado !=1) {
            System.out.println("item: "+ palavra.toUpperCase() + " não encontrado na lista!" );
        }
    }

    @Override
    public String toString() {
        return "ListaDinamica{" +
                "primeiro=" + primeiro +
                ", último=" + ultimo +
                ", tamanho=" + tamanho +
                '}';
    }
}
