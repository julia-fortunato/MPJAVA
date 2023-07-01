package model;

/**
 * Classe responsavel por criar os imoveis dentro de uma filial, herda da classe
 * Patrimonio.
 * 
 * @author Julia Fortunato e Mauricio Araujo
 * @since 2023
 * @version 1.0
 * 
 */

public class Imovel extends Patrimonio {

    private String tipo;
    private double area;
    private String endereco;
    private String dataAquisicao;

    /**
     * Metodo construtor de um imovel.
     * 
     * @param nomeItem nome de um determinado imovel    
     * @param quantidade quantidade de imoveis iguais
     * @param tipo tipo do imovel(residencia, terreno, aluguel, loja)
     * @param valor valor desse imovel
     * @param area tamanho desse imovel
     * @param endereco endereco desse imovel
     * @param dataAquisicao data de aquisicao desse imovel
     * @param filial filial a qual esse imovel pertence
     */
    public Imovel(String nomeItem, int quantidade, String tipo, double valor, double area, String endereco,
            String dataAquisicao, Filial filial) {
        super(nomeItem, quantidade, valor, filial);
        setTipo(tipo);
        setTamanho(area);
        setEndereco(endereco);
        setDataAquisicao(dataAquisicao);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getTamanho() {
        return area;
    }

    public void setTamanho(double tamanho) {
        this.area = tamanho;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(String dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String toString() {
        return "Item: " + nomeItem + "\nQuantidade: " + quantidade + "\nTipo: " + tipo +
                "\nValor: R$ " + valor + "\nTamanho: " + area + " metros quadrados" + "\nEndereco: " + endereco
                + "\nData de Aquisicao: " + dataAquisicao;
    }
}