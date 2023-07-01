package Control;
import model.*;
import java.util.ArrayList;

/**
 * Classe responsavel por fazer o intermediario entre os pacotes model e view,
 * gerenciando as filiais.
 * 
 * @author Julia Fortunato e Mauricio Araujo
 * @since 2023.1
 * @version 1.0
 * 
 */

public class ControleEmpresa {

	private ArrayList<Filial> filiais = new ArrayList<Filial>();

	/**
	 * Construtor da classe ControleEmpresa.
	 */
	public ControleEmpresa() {
		fillwithsomedata();
	}

	/**
	 * Metodo para gerar filiais aleatorias preenchendo a Arraylist da empresa.
	 */
	public void fillwithsomedata() {
		for (int i = 0; i < 5; i++) {
			int a = i+1;
			Filial todas_filiais = new Filial("Filial " + a, "Avenida " + a, "Resposavel " + a);
			filiais.add(todas_filiais);
			new ControleFilial(this).fillwithsomedatamoveis(i, this);
			new ControleFilial(this).fillwithsomedataimoveis(i, this);
		}
	}

	/**
	 * Metodo que salva uma determinada filial dentro da ArrayList de filiais.
	 * 
	 * @param filial uma filial para ser salva dentro da ArrayList
	 * @return boolean
	 */
	public boolean salvarFilial(Filial filial) {

		if (filial != null) {
			filiais.add(filial);
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Filial> retornaFilial() {
		return filiais;
	}

	/**
	 * Metodo utilizado para retornar a quantidade total de filiais dentro da
	 * ArrayList de filiais.
	 * 
	 * @return int quantidade de filiais
	 */
	public int getQtdFiliais() {
		return filiais.size();
	}

	/**
	 * Metodo utilizado para retornar uma filial dado o seu index.
	 * 
	 * @param a index da filial a ser retornada
	 * @return Filial
	 */
	public Filial retornatudofilial(int a) {
		Filial b = filiais.get(a);
		return b;
	}

	/**
	 * Metodo utilizado para retornar um vetor de Strings contendo os nomes de todas
	 * a filiais dentro da ArrayList de filiais.
	 * 
	 * @return String[] dos nomes das filiais
	 */
	public String[] getNomesfilial() {
		//System.out.println(filiais.size());
		String[] nomes = new String[filiais.size()];
		
		int i = 0;
		for (Filial a : filiais) {
			nomes[i] = a.getNome();
			//System.out.println(nomes[i]);
			//System.out.println(filiais.get(i));
			i++;
		}
		return nomes;
	}

	/**
	 * Metodo utilizado para apagar uma filial de dentro da ArrayList de filiais.
	 * dado o seu index.
	 * 
	 * @param a index da filial a ser apagada
	 * @return boolean
	 */
	public boolean removefilial(int a) {
		if (a > -1) {
			filiais.remove(a);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo utilizado para editar uma filial dentro da ArrayList de filiais.
	 * 
	 * @param filial filial que vai substituir a filial a ser editada
	 * @param a index da posicao da filial a ser editada
	 * @return boolean
	 */
	public boolean editarfilial(Filial filial, int a) {
		if (filial != null) {
			filial.setImoveis(retornatudofilial(a).getImoveis());
			filial.setMoveis(retornatudofilial(a).getMoveis());
			filiais.set(a, filial);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo para criar uma Filial importando o construtor de sua classe na model.
	 * @param nome nome de uma filial
	 * @param endereco endereco de uma filial
	 * @param responsavel responsavel de uma filial
	 * @return filial criada
	 */
	public Filial criafilial(String nome, String endereco, String responsavel){
		Filial criado = new Filial(nome,endereco,responsavel);
		return criado;
	}

}
