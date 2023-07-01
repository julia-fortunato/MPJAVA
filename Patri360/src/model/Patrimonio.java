package model;

/**
 * Classe abstrata Patrimonio que ira ser a classe pai de Movel e Imovel.
 * 
 * @author Julia Fortunato e Mauricio Araujo
 * @since 2023.1
 * @version 1.0
 * 
 */

public abstract class Patrimonio {

    protected String nomeItem;
    protected int quantidade;
    protected double valor;
    protected Filial filial_correspondente;

    /**
     * Metodo construtor de um patrimonio.
     * 
     * @param nomeItem nome do patrimonio
     * @param quantidade quantidade de tal patrimonio
     * @param valor valor de tal patrimonio
     * @param filial_correspondente filial a qual esse patrimonio esta vinculada
     */
    public Patrimonio(String nomeItem, int quantidade, double valor, Filial filial_correspondente) {
        setNomeItem(nomeItem);
        setquantidade(quantidade);
        setvalor(valor);
        setFilial(filial_correspondente);
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public int getquantidade() {
        return quantidade;
    }

    public double getvalor() {
        return valor;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public void setquantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setvalor(double valor) {
        this.valor = valor;
    }

    public Filial getFilial() {
        return filial_correspondente;
    }

    public void setFilial(Filial filial_correspondente) {
        this.filial_correspondente = filial_correspondente;
    }
}