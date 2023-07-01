package model;

import java.util.ArrayList;

/**
 * Classe responsavel por criar uma empresa como ponto de inicio para o cliente.
 * 
 * @author Julia Fortunato e Mauricio Araujo
 * @since 2023
 * @version 1.0
 * 
 */
public class Empresa {
	private String nome;
	private String proprietario;
	private String cnpj;
	private ArrayList<Filial> Filiais = new ArrayList<Filial>();

	
	/**
	 * Construtor da classe empresa.
	 * 
	 * @param nome nome da empresa
	 * @param proprietario proprietario da empresa
	 * @param cnpj cnpj da empresa
	 * @param filiais arraylist de filiais
	 */
	public Empresa(String nome, String proprietario, String cnpj, ArrayList<Filial> filiais) {
		setNome(nome);
		setProprietario(proprietario);
		setCnpj(cnpj);
		setFiliais(Filiais);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getProprietario() {
		return proprietario;
	}
	
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	public ArrayList<Filial> getFiliais() {
		return Filiais;
	}
	
	public void setFiliais(ArrayList<Filial> filiais) {
		Filiais = filiais;
	}

	public String toString() {
		return "Nome: " + nome + "\nProprietario: " + proprietario + "\nCNPJ: " + cnpj;
	}

}
