package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import Control.*;
/**
 * Tela de listagem de patrimonios gerais e de busca por patrimonio dado o seu nome.
 * 
 * @author Julia Fortunato e Mauricio Araujo
 * @since 2023.1
 * @version 1.0
 * 
 */

public class TelaListaPatrimonioGeral implements ActionListener {

	// Componentes a serem utilizados na tela
	private JFrame tela;
	private JButton atualizar, pesquisar;
	private JLabel movel, imovel;
	private JTextField pesquisarpatrimonio;
	private JList<String> listaimoveis;
	private JList<String> listamoveis;
	private JScrollPane scrollimoveis;
	private JScrollPane scrollmoveis;
	private JLabel empresa;
	private JLabel proprietario;
	private JLabel cnpj;
	private JLabel listagempatrimonio;
	private JLabel buscarpatrimonio;
	private static ControleEmpresa ce;

	/**
	 * Metodo construtor da tela de listagem e busca de patrimonios.
	 * @param dados ControleEmpresa antes iniciada
	 */
	public TelaListaPatrimonioGeral(ControleEmpresa dados) {

		ce = dados;

		// Cria novas instancias de todos os objetos a serem utilizados na tela
		movel = new JLabel("Moveis: ");
		imovel = new JLabel("Imoveis: ");
		atualizar = new JButton("Atualizar");
		listamoveis = new JList<String>((new ControlePatrimonio(ce)).fillmoveis());
		listaimoveis = new JList<String>((new ControlePatrimonio(ce)).fillimoveis());
		scrollmoveis = new JScrollPane(listamoveis);
		scrollimoveis = new JScrollPane(listaimoveis);
		tela = new JFrame("Patri 360");
		empresa = new JLabel("Empresa Matriz");
		proprietario = new JLabel("Proprietário: Luiz Eduardo Morais");
		cnpj = new JLabel("CNPJ: 12.345.678/0001-00");
		listagempatrimonio = new JLabel("Listagem de patrimônio geral");
		pesquisarpatrimonio = new JTextField();
		buscarpatrimonio = new JLabel("Pesquisar por patrimonio:");
		pesquisar = new JButton("Pesquisar");

		// Seta os tamanhos de todos componentes
		movel.setBounds(341, 160, 100, 18);
		imovel.setBounds(21, 160, 100, 18);
		scrollmoveis.setBounds(341, 180, 310, 410);
		scrollimoveis.setBounds(21, 180, 310, 410);
		atualizar.setBounds(21, 600, 640, 50);
		empresa.setBounds(21, 10, 204, 67);
		proprietario.setBounds(21, 25, 204, 67);
		cnpj.setBounds(21, 40, 204, 67);
		listagempatrimonio.setBounds(250, 100, 200, 19);
		pesquisarpatrimonio.setBounds(210, 130, 300, 19);
		buscarpatrimonio.setBounds(55, 130, 366, 19);
		pesquisar.setBounds(520, 130, 120, 19);

		// Adiciona todos os componentes na tela
		tela.add(atualizar);
		tela.getContentPane().add(scrollmoveis);
		tela.getContentPane().add(scrollimoveis);
		tela.add(empresa);
		tela.add(proprietario);
		tela.add(cnpj);
		tela.add(listagempatrimonio);
		tela.add(pesquisarpatrimonio);
		tela.add(buscarpatrimonio);
		tela.add(movel);
		tela.add(imovel);
		tela.add(pesquisar);

		// Seta a dimensao da tela, seu layout como nulo, e a coloca visivel
		tela.setBounds(610, 190, 700, 700);
		tela.setLayout(null);
		tela.setVisible(true);

		pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Funcao que utiliza do pacote controle para realizar uma busca de um patrimonio dado seu nome
				String nomePesquisado = pesquisarpatrimonio.getText();

					int f ;
					int m ;
					if (new ControlePatrimonio(ce).posicaofilialmovel(nomePesquisado)==-1) {
						if(new ControlePatrimonio(ce).posicaofilialimovel(nomePesquisado)==-1){
							JOptionPane.showMessageDialog(null,
							"O patrimonio " + nomePesquisado + " nao foi encontrado");
						}else{
							f = new ControlePatrimonio(ce).posicaofilialimovel(nomePesquisado);
							m = new ControlePatrimonio(ce).posicaoimovel(nomePesquisado);
							JOptionPane.showMessageDialog(null,
							"O patrimonio " + nomePesquisado + " foi encontrado");
							new TelaPatrimonioImovel(m, f, ce);
						}
					}else{
						f = new ControlePatrimonio(ce).posicaofilialmovel(nomePesquisado);
						m = new ControlePatrimonio(ce).posicaomovel(nomePesquisado);
						JOptionPane.showMessageDialog(null,
							"O patrimonio " + nomePesquisado + " foi encontrado");
						new TelaPatrimonioMovel(m,f,ce);
					}
			}
		});
	}
	// Atualiza e lista os moveis e imoveis
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == atualizar) {
			listamoveis.setListData(new ControlePatrimonio(ce).fillmoveis());
			listamoveis.updateUI();
			listaimoveis.setListData(new ControlePatrimonio(ce).fillimoveis());
			listaimoveis.updateUI();
		}
	}

	public void KeyReleased(KeyEvent e) {

	}

}