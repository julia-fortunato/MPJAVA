package View;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Control.*;

/**
 * Tela pricipal do mini projeto utilizada como ponto de inicio para criar
 * filiais.
 * 
 * @author Julia Fortunato e Mauricio Araujo
 * @since 2023.1
 * @version 1.0
 * 
 */

public class TelaEmpresa implements ActionListener {

	// Componentes a serem utilizados na tela
	private JButton JBlistar;
	private JButton botao2;
	private JFrame tela;
	private JButton botao;
	private JLabel textonome;
	private JLabel textoendereco;
	private JLabel textoresponsavel;
	private JTextField inserirnomef;
	private JTextField inserirenderecof;
	private JTextField inserirresponsavelf;
	private JList<String> lista;
	private JLabel empresa;
	private JLabel proprietario;
	private JLabel cnpj;
	private JLabel listagemfilial;
	private static ControleEmpresa ce = new ControleEmpresa();
	private String[] listaf = ce.getNomesfilial();
	private int valorselecionado;

	/**
	 * Metodo que inicia a tela de empresa
	 */
	public TelaEmpresa() {

		// Cria novas instancias de todos os objetos a serem utilizados na tela
		lista = new JList<String>(listaf);
		tela = new JFrame("Patri 360");
		botao = new JButton("+ Criar Filial");
		textonome = new JLabel("Inserir Nome:");
		textoendereco = new JLabel("Inserir Endereço:");
		textoresponsavel = new JLabel("Inserir Responsável:");
		inserirnomef = new JTextField();
		inserirresponsavelf = new JTextField();
		inserirenderecof = new JTextField();
		empresa = new JLabel("Empresa Matriz");
		proprietario = new JLabel("Proprietário: Luiz Eduardo Morais");
		cnpj = new JLabel("CNPJ: 12.345.678/0001-00");
		listagemfilial = new JLabel("Listagem de Filiais");
		JBlistar = new JButton("Listar Patrimonio");
		botao2 = new JButton("Atualizar");

		// Seta os tamanhos de todos componentes
		JBlistar.setBounds(21, 615, 140, 35);
		lista.setBounds(21, 160, 640, 330);
		inserirresponsavelf.setBounds(168, 591, 366, 18);
		inserirenderecof.setBounds(168, 556, 366, 18);
		inserirnomef.setBounds(168, 521, 366, 18);
		textonome.setBounds(168, 440, 262, 137);
		textoendereco.setBounds(168, 475, 262, 137);
		textoresponsavel.setBounds(168, 510, 262, 137);
		botao.setBounds(168, 615, 366, 35);
		empresa.setBounds(21, 10, 204, 67);
		proprietario.setBounds(21, 25, 204, 67);
		cnpj.setBounds(21, 40, 204, 67);
		listagemfilial.setBounds(250, 120, 200, 21);
		botao2.setBounds(550, 615, 100, 35);
		listagemfilial.setFont(new Font("Arial", Font.BOLD, 20));

		// Adiciona todos os componentes na tela
		tela.add(JBlistar);
		tela.add(botao2);
		tela.add(lista);
		tela.add(botao);
		tela.add(textonome);
		tela.add(textoendereco);
		tela.add(textoresponsavel);
		tela.add(inserirnomef);
		tela.add(inserirenderecof);
		tela.add(inserirresponsavelf);
		tela.add(empresa);
		tela.add(proprietario);
		tela.add(cnpj);
		tela.add(listagemfilial);

		// Seta a dimensao da tela, seu layout como nulo, e a coloca visivel
		tela.setBounds(610, 190, 700, 700);
		tela.setLayout(null);
		tela.setVisible(true);

		// Adiciona um ActionListener aos botoes e a JList
		botao.addActionListener(this);
		botao2.addActionListener(this);
		JBlistar.addActionListener(this);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


		
		lista.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				valorselecionado = lista.getSelectedIndex();
				
				if (e.getValueIsAdjusting()) {
					new TelaFilial(valorselecionado, ce);

				}
			}
		});
	}

	public static void main(String[] args) {
		new TelaEmpresa();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botao) {
			salvarf();
		}
		if (e.getSource() == botao2) {
			// Refresh na pagina
			lista.setListData(ce.getNomesfilial());
			lista.updateUI();
		}
		if (e.getSource() == JBlistar) {
			// Abre a tela de lista de patrimonio geral
			new TelaListaPatrimonioGeral(ce);
		}
	}

	/**
	 * Metodo que cria uma nova filial, utilizando da função do package control
	 */
	public void salvarf() {
		if (ce.salvarFilial(ce.criafilial(inserirnomef.getText(), inserirenderecof.getText(),
				inserirresponsavelf.getText())) == true) {
			JOptionPane.showMessageDialog(null, "Filial cadastrada com sucesso!");
		}else {
			JOptionPane.showMessageDialog(null, "Filial nao cadastrada");
		}
	}
}
