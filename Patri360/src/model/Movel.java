package model;

/**
 * Classe responsavel por criar os moveis dentro de uma determinada filial,
 * herda da classe Patrimonio.
 * 
 * @author Julia Fortunato e Mauricio Araujo
 * @since 2023.1
 * @version 1.0
 * 
 */
public class Movel extends Patrimonio {

    private String classificacao;
    private boolean disponibilidade;
    private String condicao;
    private String fabricante;

    /**
     * Metodo construtor da classe movel.
     * 
     * @param fabricante fabricante desse movel
     * @param condicao condicao desse movel quando cadastrado
     * @param nomeItem nome desse movel
     * @param quantidade quantidade de moveis iguais
     * @param valor valor desse movel(unitariamente)
     * @param disponibilidade disponibilidade(se esta sendo usado)
     * @param classificacao qual e o tipo desse movel
     * @param filial filial vinculada a esse movel
     */
    public Movel(String fabricante, String condicao, String nomeItem, int quantidade, double valor,
            boolean disponibilidade, String classificacao, Filial filial) {
        super(nomeItem, quantidade, valor, filial);
        setClassificacao(classificacao);
        setDisponibilidade(disponibilidade);
        setCondicao(condicao);
        setFabricante(fabricante);
    }

    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    /**
     * Metodo que serve para checar a disponibilidade de um movel TRUE(em uso) e
     * False(em desuso).
     * 
     * @param disponibilidade se esta sendo usado ou nao TRUE(esta sendo usado)
     * @return String
     */
    public String checarDisponibilidade(boolean disponibilidade) {
        String utilidade;
        if (disponibilidade == true) {
            utilidade = "Em uso";
        } else {
            utilidade = "Em desuso";
        }
        return utilidade;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classficacao) {
        this.classificacao = classficacao;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String toString() {
        String utilidade;
        utilidade = checarDisponibilidade(disponibilidade);
        return "Nome: " + nomeItem + "Quantidade: " + quantidade +
                "Valor: R$ " + valor + "Situacao de utilidade: " + utilidade +
                "Classificacao: " + classificacao + "Condicao: " + condicao + "Fabricante: " + fabricante;
    }

}