package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Control.*;
/**
 * Tela para mostrar detalhes de imoveis e edita-los.
 * 
 * @author Julia Fortunato e Mauricio Araujo
 * @since 2023.1
 * @version 1.0
 * 
 */


public class TelaPatrimonioImovel implements ActionListener {
	
	// Componentes a serem utilizados na tela
	private JFrame telaimovel;
	private JLabel nomepatri;
	private JTextField inserirtipo;
	private JTextField inserirtamanho;
	private JTextField inserirendereco;
	private JTextField inserirdataaqui;
	private JTextField inserirnomeitem;
	private JTextField inserirquantidade;
	private JTextField inserirvalor;
	private JLabel nomeitem;
	private JLabel quantidade;
	private JLabel valor;
	private JLabel tipo;
	private JLabel tamanho;
	private JLabel endereco;
	private JLabel dataaqui;
	private JButton salvar;
    private JButton excluir;
	private static ControleEmpresa ce;
	
	/**
	 * Metodo construtor da tela.
	 * @param index index da filial respectiva do patrimonio a ser aberto
	 * @param controleindex index do imovel respectivo a ser aberto
	 * @param dados ControleEmpresa antes aberto na primeira tela
	 */
	public TelaPatrimonioImovel (int index,int controleindex, ControleEmpresa dados){

		ce = dados;
		
		// Transforma os valores que não são Strings para serem mostrados 
		String mostrarvalor = String.valueOf((new ControleFilial(ce)).retornarimovel(index,controleindex).getvalor());
		String mostrarquantidade = Integer.toString((new ControleFilial(ce)).retornarimovel(index,controleindex).getquantidade());
		String mostrartamanho = String.valueOf((new ControleFilial(ce)).retornarimovel(index,controleindex).getTamanho());

		// Cria novas instancias de todos os objetos a serem utilizados na tela
		nomeitem = new JLabel("Nome do Item : ");
		quantidade = new JLabel("Quantidade: ");
		valor = new JLabel("Valor: ");
		inserirvalor = new JTextField(mostrarvalor);
		inserirquantidade = new JTextField(mostrarquantidade);	
		inserirnomeitem = new JTextField((new ControleFilial(ce)).retornarimovel(index,controleindex).getNomeItem());		
		inserirtipo = new JTextField((new ControleFilial(ce)).retornarimovel(index,controleindex).getTipo());
		inserirtamanho = new JTextField(mostrartamanho);
		inserirendereco = new JTextField((new ControleFilial(ce)).retornarimovel(index,controleindex).getEndereco());
		inserirdataaqui = new JTextField((new ControleFilial(ce)).retornarimovel(index,controleindex).getDataAquisicao());
		tipo = new JLabel("Tipo: ");
		tamanho = new JLabel("Tamanho: ");
		endereco = new JLabel("Endereço: ");
		dataaqui = new JLabel("Data De Aquisição: ");
        excluir = new JButton("Excluir");
		telaimovel = new JFrame("Detalhe Imóvel");
		nomepatri = new JLabel("Patrimonio Imovel");
		salvar = new JButton("Salvar");
		
		// Seta os tamanhos de todos componentes
		nomeitem.setBounds(109,60,481,18);
		quantidade.setBounds(109,105,481,18);
		valor.setBounds(109,145,481,18);
		inserirvalor.setBounds(109,165,481,18);
		inserirquantidade.setBounds(109,125,481,18);
		inserirnomeitem.setBounds(109,85,481,18);
		dataaqui.setBounds(109,305,481,18);
		tipo.setBounds(109,185,481,18);
		tamanho.setBounds(109,225,481,18);
		endereco.setBounds(109,265,481,18);
		inserirdataaqui.setBounds(109,325,481,18);
		inserirendereco.setBounds(109,285,481,18);
		inserirtamanho.setBounds(109,245,481,18);
		inserirtipo.setBounds(109,205,481,18);
		nomepatri.setBounds(280,40,137,19);
		salvar.setBounds(76,378,266,67);
        excluir.setBounds(358,378,263,67);
		

		// Adiciona todos os componentes na tela
		telaimovel.add(nomeitem);
		telaimovel.add(quantidade);
		telaimovel.add(valor);
		telaimovel.add(inserirvalor);
		telaimovel.add(inserirquantidade);
		telaimovel.add(inserirnomeitem);
		telaimovel.add(dataaqui);
		telaimovel.add(tipo);
		telaimovel.add(endereco);
		telaimovel.add(tamanho);
		telaimovel.add(inserirtipo);
		telaimovel.add(inserirtamanho);
		telaimovel.add(inserirendereco);
		telaimovel.add(inserirdataaqui);
		telaimovel.add(nomepatri);
		telaimovel.add(salvar);
        telaimovel.add(excluir);
		

		// Seta a dimensao da tela, seu layout como nulo, e a coloca visivel
		telaimovel.setBounds(610,190,700,500);
		telaimovel.setLayout ( null );
		telaimovel.setVisible(true);
		
		// Método que salva as edições feitas a um imovel
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intquantidade = Integer.parseInt(inserirquantidade.getText());
				double doublevalor = Double.parseDouble(inserirtamanho.getText());
				double doublearea = Double.parseDouble(inserirtamanho.getText());

				(new ControleFilial(ce)).editarImovel((new ControleFilial(ce)).criarimovel(inserirnomeitem.getText(),intquantidade,inserirtipo.getText()
				,doublevalor,doublearea,inserirendereco.getText(),inserirdataaqui.getText(),(new ControleEmpresa()).retornatudofilial(index)), controleindex, index,ce);
				JOptionPane.showMessageDialog(null,"Patrimonio editado com sucesso!");
				telaimovel.dispose();
			}
		});
		
		// Método que exclui um imovel
        excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				(new ControleFilial(ce)).removeImovel(index, controleindex,ce);
				JOptionPane.showMessageDialog(null,"Patrimonio excluido com sucesso!");
				telaimovel.dispose();
			}
		});
	}
	public void actionPerformed(ActionEvent e) {}
}