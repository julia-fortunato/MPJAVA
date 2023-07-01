package testesJUnit;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import Control.*;
import model.*;
/**
 * Implementa os teste unitarios.
 * 
 * @author Julia Fortunato e Mauricio Araujo
 * @since 2023
 * @version 1.0
 *	
 */

 class TestesJUnit {
	
	ControleEmpresa dados = new ControleEmpresa();
	ControlePatrimonio dadosPatrimonio = new ControlePatrimonio(dados);
	String [] info = new String [50];
	
	/**
	 * Verifica se a variavel info, representa novos dados para a criacao
	 * de uma nova filial.
	 */
	
	@Test 
	void testeCriarFilial () {
		info [0] = "Filial Zenit";
		info [1] = "Avenida Santo Amaro, 35";
		info [3] = "Danilo Naves";
		assertTrue(dados.salvarFilial(new Filial(info[0],info[1],info[2])));
	}
	
	
	/**
	 * Verifica se o parametro 0, que representa uma filial do arraylist
	 * e funciona para o metodo de remocao.
	 */
	@Test 
	void testeRemoveImovel () {
		assertTrue(dados.removefilial(0));
	}
	
	/**
	 * Verifica se o parametro 0, representa a um movel do arraylist 
	 * e se o metodo utilizado o encontra.
	 */
	@Test
	void testePesquisamovel() {
		info[0] = "Movel 1";
		assertEquals(0, dadosPatrimonio.pesquisaMovel(info[0]));
	}
	
}
