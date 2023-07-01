package Control;

import model.*;

/**
 * Classe responsavel pelo controle de um patrimonio em determinada filial,
 * utilizando das informacoes da model para se conectar com a interface.
 * 
 * @author Julia Fortunato e Mauricio Araujo
 * @since 2023
 * @version 1.0
 * 
 */

public class ControleFilial {

	private ControleEmpresa ce1;

	/**
	 * Construtor da classe ControleFilial, criando uma nova instancia dos objetos em ControleEmpresa,
	 * tal que e temporaria.
	 * 
	 * @param ControleEmpresa
	 * 
	 */
	public ControleFilial(ControleEmpresa dados) {
		ce1 = dados;
	}

	/**
	 * Metodo de looping para instanciar os imoveis e adiciona-los a ArrayList 
	 * de uma determinada filial.
	 * 
	 * @param index Numero index da filial a qual vai ser criado as instancias
	 * @param ce controle empresa
	 */
	public void fillwithsomedataimoveis(int index, ControleEmpresa ce) {
		for (int i = 0; i < 5; i++) {
			int a = i+1;
			Imovel todos_imoveis = new Imovel("Imovel " + a, a, "Residencia " + a, a * 5, a * 20,
					"Rua Santa Maria " + a, "02/07/2023", ce.retornatudofilial(index));
			ce.retornatudofilial(index).getImoveis().add(todos_imoveis);
		}
	}

	/**
	 * Metodo de looping para instanciar os moveis e adiciona-los a ArrayList 
	 * de uma determinada filial.
	 * 
	 * @param index Numero index da filial a qual vai ser criado as instancias
	 * @param ce controle empresa
	 */
	public void fillwithsomedatamoveis(int index, ControleEmpresa ce) {
		for (int i = 0; i < 5; i++) {
			int a = i+1;
			Movel todos_moveis = new Movel("Fabricante " + a, "Novo " + a,
					"Movel " + a, a+1, a*5, true, "Veiculo " + a, ce.retornatudofilial(index));
			ce.retornatudofilial(index).getMoveis().add(todos_moveis);
		}
	}

	/**
	 * Salva um determinado imovel na Arraylist de Imoveis, utilizando o controle de filial.
	 * 
	 * @param im Uma nova instancia de um imovel
	 * @param index Filial ao qual o imovel pertece
	 * @param ce controle empresa
	 * 
	 * @return boolean
	 */
	public boolean salvarImovel(Imovel im, int index, ControleEmpresa ce){
		if (im != null) {
			ce.retornatudofilial(index).getImoveis().add(im);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Salva um determinado movel na Arraylist de Moveis, utilizando o controle de filial.
	 * 
	 * @param m Uma nova instancia de um movel
	 * @param index Filial ao qual o movel pertence 
	 * @param ce controle empresa
	 * 
	 * @return boolean
	 */
	public boolean salvarMovel(Movel m, int index, ControleEmpresa ce) {

		if (m != null) {
			ce.retornatudofilial(index).getMoveis().add(m);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Remove um determiando imovel na Arraylist de Imoveis.
	 * 
	 * @param im A instancia do imovel que se deseja excluir
	 * @param index Filial a qual o imovel pertence
	 * @param ce controle empresa
	 * 
	 * @return boolean
	 */
	public boolean removeImovel(int im, int index, ControleEmpresa ce) {
		if (im > -1) {
			ce.retornatudofilial(index).getImoveis().remove(im);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Remove um determiando movel na Arraylist de Moveis.
	 * 
	 * @param im A instancia do movel que se deseja excluir
	 * @param index Filial a qual o movel pertence
	 * @param ce controle empresa
	 * 
	 * @return boolean
	 */
	public boolean removeMovel(int m, int index, ControleEmpresa ce) {
		if (m > -1) {
			ce.retornatudofilial(index).getMoveis().remove(m);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Edita um determiando movel na Arraylist de Moveis, de acordo com
	 * a posicao de sua filial.
	 * 
	 * @param movel A instancia do movel que se deseja editar
	 * @param a index da filial onde o movel se encontra 
	 * @param index index do movel a ser editado 
	 * @param ce controle empresa
	 * 
	 * @return boolean
	 */
	public boolean editarMovel(Movel movel, int a, int index, ControleEmpresa ce) {
		System.out.println(ce.retornaFilial().get(a).getMoveis().get(index));
		if (movel != null) {
			ce.retornatudofilial(a).getMoveis().set(index, movel);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Edita um determiando imovel na Arraylist de Imoveis, de acordo com
	 * a posicao de sua filial.
	 * 
	 * @param imovel A instancia do imovel que se deseja editar
	 * @param a index da filial onde o imovel se encontra
	 * @param index index do imovel que e desejado editar 
	 * @param ce controle empresa
	 * 
	 * @return boolean
	 */
	public boolean editarImovel(Imovel imovel, int a, int index, ControleEmpresa ce) {
		if (imovel != null) {
			ce.retornatudofilial(a).getImoveis().set(index, imovel);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Coleta os nomes de todos os itens Moveis de uma determinada filial.
	 * 
	 * @param index filial desses moveis
	 * 
	 * @return String 
	 */
	public String[] getNomesmoveis(int index) {
		String[] nomes = new String[ce1.retornatudofilial(index).getMoveis().size()];
		int i = 0;
		for (Movel m : ce1.retornatudofilial(index).getMoveis()) { 
			// Looping que percorre a filial e coloca no vetor de Strings os nomes de Moveis
			nomes[i] = m.getNomeItem();
			i++;
		}
		return nomes;
	}
	/**
	 * Coleta os nomes de todos os itens Imoveis de uma determinada filial.
	 * 
	 * @param index filial desses imoveis
	 * @return String 
	 */
	public String[] getNomesimoveis(int index) {
		String[] nomes = new String[ce1.retornatudofilial(index).getImoveis().size()];
		int i = 0;
		for (Imovel im : ce1.retornatudofilial(index).getImoveis()) {
			// Looping que percorre a filial e coloca no vetor de Strings os nomes de Imoveis
			nomes[i] = im.getNomeItem();
			i++;
		}
		return nomes;
	}

	/**
	 * Retorna o imovel atraves do index da filial.
	 * 
	 * @param im imovel a se procurar
	 * @param index filial a qual esse imovel pertence
	 * 
	 * @return Imovel 
	 */
	public Imovel retornarimovel(int im, int index) {
		return ce1.retornatudofilial(index).getImoveis().get(im);
	}

	/**
	 * Retorna o movel atraves do index da filial.
	 * 
	 * @param m movel a se procurar
	 * @param index filial a qual esse movel pertence
	 * 
	 * @return Movel
	 */
	public Movel retornarmovel(int m, int index) {
		return ce1.retornatudofilial(index).getMoveis().get(m);
	}

	/**
	 * Metodo que invoca o construtor da classe Imovel, para a criação de um novo.
	 * @param nomeitem nome do imovel
	 * @param quantidade quantidade de imoveis iguais
	 * @param tipo tipo do imovel
	 * @param valor valor do imovel
	 * @param area tamanho em metros quadrados do imovel
	 * @param endereco endereco do imovel
	 * @param datadeaquisicao a data de aquisicao do imovel
	 * @param filial a filial a qual esse imovel pertence
	 * @return o imovel criado
	 */
	public Imovel criarimovel(String nomeitem,int quantidade,String tipo,double valor,double area,String endereco,String datadeaquisicao,Filial filial){
		Imovel criado = new Imovel(nomeitem, quantidade, tipo, valor, area, endereco, datadeaquisicao, filial);
		return criado;
	}

	/**
	 * Metodo que invoca o construtor da classe movel, para a criacao de um novo.
	 * @param fabricante fabricante do movel
	 * @param condicao condicao do movel
	 * @param nomeItem nome do movel
	 * @param quantidade quantidade de moveis iguais
	 * @param valor valor do movel
	 * @param disponibilidade disponibilidade atual do movel (em uso ou nao)
	 * @param classificacao classificacao do movel
	 * @param filial filial a qual esse movel pertence
	 * @return o movel criado
	 */
	public Movel criarmovel(String fabricante, String condicao, String nomeItem, int quantidade, double valor,boolean disponibilidade, String classificacao, Filial filial){
		Movel criado = new Movel(fabricante,condicao,nomeItem,quantidade,valor,disponibilidade,classificacao,filial);
		return criado;
	}
}
