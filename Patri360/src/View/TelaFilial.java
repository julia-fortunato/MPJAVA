package View;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Control.*;

/**
 * Tela responsavel por editar filiais e por criar patrimonios gerindo os patrimonios de uma filial,
 * alem de levar ao detalhe de um item selecionado.
 * 
 * @author Julia Fortunato e Mauricio Araujo
 * @since 2023.1
 * @version 1.0
 * 
 */

public class TelaFilial implements ActionListener {

	// Componentes a serem utilizados na tela
	private JFrame telafilial;
	private JLabel nomeJB;
	private JLabel enderecoJB;
	private JLabel responsavelJB;
	private JLabel moveis, imoveis;
	private JTextField nome;
	private JTextField endereco;
	private JTextField responsavel;
	private JList<String> listarpatrimoniomovel;
	private JList<String> listarpatrimonioimovel;
	private JButton criarpatrimonioImovel;
	private JButton criarpatrimonioMovel;
	private JButton atualizar;
	private JButton deletar;
	private JButton salvar;
	private static ControleEmpresa ce;

	/**
	 * Metodo construtor da tela filial que inicia a mesma.
	 * @param controleindex index da filial que a tela ta abrindo
	 * @param dados ControleEmpresa antes iniciada
	 */
	public TelaFilial(int controleindex, ControleEmpresa dados) {

		ce = dados;

		// Cria novas instancias de todos os objetos a serem utilizados na tela
		atualizar = new JButton("Atualizar");
		criarpatrimonioImovel = new JButton("+ Criar Patrimonio Imovel");
		criarpatrimonioMovel = new JButton("+ Criar Patrimonio Movel");
		listarpatrimoniomovel = new JList<String>(new ControleFilial(ce).getNomesmoveis(controleindex));
		listarpatrimonioimovel = new JList<String>(new ControleFilial(ce).getNomesimoveis(controleindex));
		telafilial = new JFrame("Detalhe Filial");
		nomeJB = new JLabel("Nome:");
		enderecoJB = new JLabel("Endereco:");
		responsavelJB = new JLabel("Responsavel:");
		deletar = new JButton("Excluir Filial");
		nome = new JTextField(ce.retornaFilial().get(controleindex).getNome());
		endereco = new JTextField(ce.retornaFilial().get(controleindex).getEndereco());
		responsavel = new JTextField(ce.retornaFilial().get(controleindex).getResponsavel());
		salvar = new JButton("Salvar");
		moveis = new JLabel("Moveis: ");
		imoveis = new JLabel("Imoveis: ");


		// Seta os tamanhos de todos componentes
		atualizar.setBounds(550, 550, 100, 35);
		criarpatrimonioImovel.setBounds(168, 500, 366, 35);
		criarpatrimonioMovel.setBounds(168, 550, 366, 35);
		listarpatrimonioimovel.setBounds(21, 160, 310, 310);
		listarpatrimoniomovel.setBounds(341, 160, 310, 310);
		nomeJB.setBounds(21, 20, 204, 67);
		enderecoJB.setBounds(21, 40, 204, 67);
		responsavelJB.setBounds(21, 60, 204, 67);
		deletar.setBounds(10, 550, 150, 35);
		nome.setBounds(100, 45, 500, 18);
		endereco.setBounds(100, 65, 500, 18);
		responsavel.setBounds(100, 85, 500, 18);
		salvar.setBounds(550, 115, 100, 35);
		moveis.setBounds(341, 115, 204, 67);
		imoveis.setBounds(21, 115, 204, 67);

		
		// Adiciona todos os componentes na tela
		telafilial.add(atualizar);
		telafilial.add(criarpatrimonioImovel);
		telafilial.add(criarpatrimonioMovel);
		telafilial.add(listarpatrimonioimovel);
		telafilial.add(listarpatrimoniomovel);
		telafilial.add(nomeJB);
		telafilial.add(enderecoJB);
		telafilial.add(responsavelJB);
		telafilial.add(deletar);
		telafilial.add(nome);
		telafilial.add(endereco);
		telafilial.add(responsavel);
		telafilial.add(salvar);
		telafilial.add(moveis);
		telafilial.add(imoveis);
		

		// Seta a dimensao da tela, seu layout como nulo, e a coloca visivel
		telafilial.setBounds(610, 190, 700, 650);
		telafilial.setLayout(null);
		telafilial.setVisible(true);

		
		// Método que chama o controle para remover uma filial
		deletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ce.removefilial(controleindex);
				JOptionPane.showMessageDialog(null,"Filial excluida com sucesso!");
				telafilial.dispose();
			}
		});

		// Método que chama o controle para salvar, editar uma filial
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ce.editarfilial(ce.criafilial(nome.getText(), endereco.getText(), responsavel.getText()), controleindex);
				JOptionPane.showMessageDialog(null,"Filial editada com sucesso!");
				telafilial.dispose();
			}
		});

		// Captura o click na JList para mostrar informações de imovel
		listarpatrimonioimovel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					int valorselecionado = listarpatrimonioimovel.getSelectedIndex();
					new TelaPatrimonioImovel(valorselecionado, controleindex,ce);
				}
			}
		});

		// Captura o click na JList para mostrar informações de movel
		listarpatrimoniomovel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					int valorselecionado = listarpatrimoniomovel.getSelectedIndex();
					new TelaPatrimonioMovel(valorselecionado, controleindex,ce);
				}
			}
		});

		// Atualiza amabs as JLists da Tela Filial
		atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				listarpatrimoniomovel.setListData(new ControleFilial(ce).getNomesmoveis(controleindex));
				listarpatrimoniomovel.updateUI();
				listarpatrimonioimovel.setListData(new ControleFilial(ce).getNomesimoveis(controleindex));
				listarpatrimonioimovel.updateUI();
			}
		});

		// Abre a tela de criar patrimonio imovel
		criarpatrimonioImovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCriarPatrimonioImovel(controleindex,dados);
			}
		});

		// Abre a tela de criar patrimonio movel
		criarpatrimonioMovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCriarPatrimonioMovel(controleindex,dados);
			}
		});
	}
	public void actionPerformed(ActionEvent e) {}
}
