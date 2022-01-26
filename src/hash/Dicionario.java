package hash;


import lista.ListaDinamica;

public class Dicionario {
    // para cada letra do alfabeto uma posicao e em cada
    // posição uma lista encadeada de palavras que começem com a determinada letra
    ListaDinamica vetor[];

    public Dicionario() {
        vetor = new ListaDinamica[26];
        inicializaListas();
    }

    //inicializando cada posição da lista para as 26 letras do alfabeto
    final void inicializaListas() {
        for (int i = 0; i < 26; i++) {
            vetor[i] = new ListaDinamica();
        }
    }

    final int funcaoHash(String palavra) {
        //calcular o hash da palavra
        palavra = palavra.toLowerCase();
        int posicao = palavra.charAt(0);
        return posicao - 97;
    }

    final void adicionarTabela(String palavra, String descricao) {

        vetor[funcaoHash(palavra)].adicionar(palavra, descricao);

    }

    final void excluirItem(String palavra) {
        System.out.println("\nItens nessa lista ANTES da exclusão");
        vetor[funcaoHash(palavra)].imprime();
        vetor[funcaoHash(palavra)].removeItem(palavra);
        System.out.println("\nItens nessa lista APÓS a exclusão de " + palavra.toUpperCase());
        vetor[funcaoHash(palavra)].imprime();

    }

    final void buscaPalavra(String palavra) {
        vetor[funcaoHash(palavra)].buscaItem(palavra);
    }


    public static void main(String[] args) {

        Dicionario dicionario = new Dicionario();
        dicionario.adicionarTabela("Alienado", "Pessoa que padece de algum tipo de alienação mental.");
        dicionario.adicionarTabela("Apático", "Quem espressa apatir, insensibilidade, indiferença.");
        dicionario.adicionarTabela("Gelado", "Algo que se tornou muito frio sob efeito da temperatura.");
        dicionario.adicionarTabela("Medroso", "Pessoa dominada pelo medo.");
        dicionario.adicionarTabela("Zelosa", "Pessoa que demonstra zelo.");
        dicionario.adicionarTabela("Zoeira", "Barulho que não consegue ser distinbuido, como se fosse um zumbido.");
        dicionario.adicionarTabela("Cumbuca", "Vasilha feita com casa de fruto da cuieira.");
        dicionario.adicionarTabela("Planeta", "Corpo que orbita uma estrela e é grande o suficiente para que sua própria gravidade a deixe com forma redonda.");

        System.out.println("\nImprimindo por linha".toUpperCase());
        dicionario.vetor[0].imprime();
        dicionario.vetor[2].imprime();
        dicionario.vetor[12].imprime();
        dicionario.vetor[25].imprime();

        System.out.println("\nImprimindo toda o tabela".toUpperCase());
        int i = 0;
        for (i = 0; i < dicionario.vetor.length; i++) {
            if (!(dicionario.vetor[i].getPrimeiro() == null)) {
                dicionario.vetor[i].imprime();

            }
        }

        dicionario.excluirItem("Zelosa");

        System.out.println("\nMétodo Busca".toUpperCase());
        dicionario.buscaPalavra("Planeta");
        dicionario.buscaPalavra("Paralelepípedo");
        dicionario.buscaPalavra("cuMbuCa");


    }

}
