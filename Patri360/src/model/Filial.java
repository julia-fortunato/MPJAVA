package model;

import java.util.ArrayList;

/**
 * Classe responsavel por criar as filiais de determinada empresa.
 * 
 * @author Julia Fortunato e Mauricio Araujo
 * @since 2023
 * @version 1.0
 * 
 */

public class Filial {
    private String nome;
    private String endereco;
    private String responsavel;
    private ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
    private ArrayList<Movel> moveis = new ArrayList<Movel>();

    /**
     * Metodo construtor da classe filial.
     * 
     * @param nome nome a ser dado a uma filial
     * @param endereco endereco de uma filial
     * @param responsavel responsavel de uma filial
     */
    public Filial(String nome, String endereco, String responsavel) {
        setNome(nome);
        setEndereco(endereco);
        setResponsavel(responsavel);
    }

    /**
     * Metodo que retorna a quantidade total de patrimonios dentro de uma filial.
     * 
     * @return int
     */
    public int qtdpatrimonio() {
        int qtdmoveis = moveis.size();
        int qtdimoveis = imoveis.size();
        int qtdtotal = qtdimoveis + qtdmoveis;

        return qtdtotal;
    }

    public ArrayList<Imovel> getImoveis() {
        return imoveis;
    }

    public ArrayList<Movel> getMoveis() {
        return moveis;
    }

    public void setMoveis (ArrayList <Movel> moveis){
        this.moveis = moveis;
    }

    public void setImoveis(ArrayList<Imovel> imoveis){
        this.imoveis = imoveis;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return "Nome: " + nome + "\nEndereco: " + endereco + "\nResponsavel: " + responsavel;
    }

}