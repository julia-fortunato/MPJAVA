package model;

import java.util.ArrayList;

/**
 * Classe responsavel por criar os Arraylists a serem utilizados no pacote
 * control.
 * 
 * @author Julia Fortunato e Mauricio Araujo
 * @since 2023.1
 * @version 1.0
 * @deprecated
 * 
 */

public class Dados {

    private String nomesfiliais;
    private String nomesimoveis;
    private String nomesmoveis;
    private ArrayList<Filial> filiais = new ArrayList<Filial>();
    private ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
    private ArrayList<Movel> moveis = new ArrayList<Movel>();

    /**
     * Metodo construtor da classe Dados.
     * 
     * @param nomesfiliais nome de uma filial a ser salva
     * @param nomesimoveis nome de um imovel a ser salvo
     * @param nomesmoveis nome de um movel a ser salvo
     * @param filiais ArrayList de filiais a ser iniciada
     * @param imoveis ArrayList de imoveis a ser iniciada
     * @param moveis ArrayList de moveis a ser iniciada
     */
    public Dados(String nomesfiliais, String nomesimoveis, String nomesmoveis, ArrayList<Filial> filiais,
            ArrayList<Imovel> imoveis, ArrayList<Movel> moveis) {
        this.nomesfiliais = nomesfiliais;
        this.filiais = filiais;
        this.nomesimoveis = nomesimoveis;
        this.imoveis = imoveis;
        this.nomesmoveis = nomesmoveis;
        this.moveis = moveis;
    }

    public String getNomesfiliais() {
        return nomesfiliais;
    }

    public void setNomesfiliais(String nomesfiliais) {
        this.nomesfiliais = nomesfiliais;
    }

    public String getNomesimoveis() {
        return nomesimoveis;
    }

    public void setNomesimoveis(String nomesimoveis) {
        this.nomesfiliais = nomesimoveis;
    }

    public String getNomesmoveis() {
        return nomesmoveis;
    }

    public void setNomesmoveis(String nomesmoveis) {
        this.nomesfiliais = nomesmoveis;
    }

    public ArrayList<Filial> getFiliais() {
        return filiais;
    }

    public void setFiliais(ArrayList<Filial> filiais) {
        this.filiais = filiais;
    }

    public void setFiliais(Filial a) {
        filiais.add(a);
    }

    /**
     * Metodo que recebe uma filial e a adiciona no Arraylist de filiais.
     * 
     * @param a filial a ser adicionada na ArrayList de filiais
     */
    public void cadastrarFilial(Filial a) {
        filiais.add(a);
    }

    // Métodos para ArrayList de Imoveis

    public ArrayList<Imovel> getImoveis() {
        return imoveis;
    }

    public void setImoveis(ArrayList<Imovel> imoveis) {
        this.imoveis = imoveis;
    }

    public void setImoveis(Imovel im) {
        imoveis.add(im);
    }

    public void cadastrarImovel(Imovel im) {
        imoveis.add(im);
    }

    // Métodos para Arraylist de Moveis
    public ArrayList<Movel> getMoveis() {
        return moveis;
    }

    public void setMoveis(ArrayList<Movel> moveis) {
        this.moveis = moveis;
    }

    public void setMoveis(Movel m) {
        moveis.add(m);
    }

    public void cadastrarMoveis(Movel m) {
        moveis.add(m);
    }

    /**
     * Se informa sobre o tamanho da ArrayList de Filiais.
     * 
     * @return int
     */
    public int getQtFiliais() {
        return filiais.size();
    }

    /**
     * Se informa sobre o tamanho da ArrayList de Imoveis.
     * 
     * @return int
     */
    public int getQtImoveis() {
        return imoveis.size();
    }

    /**
     * Se informa sobre o tamanho da ArrayList de Moveis.
     * 
     * @return int
     */
    public int getQtMoveis() {
        return moveis.size();
    }

    public String toString() {
        return nomesfiliais + filiais + nomesimoveis + imoveis + nomesmoveis + moveis;
    }
}
