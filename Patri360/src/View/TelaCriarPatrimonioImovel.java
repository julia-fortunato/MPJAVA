package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Control.*;
import javax.swing.*;
/**
 * Tela usada para criar um imovel.
 * 
 * @author Julia Fortunato e Mauricio Araujo
 * @since 2023.1
 * @version 1.0
 * 
 */

public class TelaCriarPatrimonioImovel implements ActionListener {

	// Componentes a serem utilizados na tela
	private JFrame telacriarimovel;
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
	private JButton criar;
	private static ControleEmpresa ce;
	
	/**
	 * Metodo que inicia a tela de criar patrimonio imovel.
	 * @param index index da filial a qual esse imovel criado vai ser vinculado
	 * @param dados ControleEmpresa antes iniciada
	 */
	public TelaCriarPatrimonioImovel (int index, ControleEmpresa dados){
		
		ce = dados;
		
		// cria novas instancias de todos os objetos a serem utilizados na tela
		nomeitem = new JLabel("Nome do Item : ");
		quantidade = new JLabel("Quantidade: ");
		valor = new JLabel("Valor: ");
		inserirvalor = new JTextField();
		inserirquantidade = new JTextField();	
		inserirnomeitem = new JTextField();		
		tipo = new JLabel("Tipo: ");
		tamanho = new JLabel("Tamanho: ");
		endereco = new JLabel("Endereço: ");
		dataaqui = new JLabel("Data De Aquisição: ");
		inserirtipo = new JTextField();
		inserirtamanho = new JTextField();
		inserirendereco = new JTextField();
		inserirdataaqui = new JTextField();
		telacriarimovel = new JFrame("Criar Imóvel");
		nomepatri = new JLabel("Criar Patrimonio Imovel");
		criar = new JButton("Criar");
		
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
		criar.setBounds(109,370,481,67);
		
		// Adiciona todos os componentes na tela
		telacriarimovel.add(nomeitem);
		telacriarimovel.add(quantidade);
		telacriarimovel.add(valor);
		telacriarimovel.add(inserirvalor);
		telacriarimovel.add(inserirquantidade);
		telacriarimovel.add(inserirnomeitem);
		telacriarimovel.add(dataaqui);
		telacriarimovel.add(tipo);
		telacriarimovel.add(endereco);
		telacriarimovel.add(tamanho);
		telacriarimovel.add(inserirtipo);
		telacriarimovel.add(inserirtamanho);
		telacriarimovel.add(inserirendereco);
		telacriarimovel.add(inserirdataaqui);
		telacriarimovel.add(nomepatri);
		telacriarimovel.add(criar);
		
		// Seta a dimensao da tela, seu layout como nulo, e a coloca visivel
		telacriarimovel.setBounds(610,190,700,500);
		telacriarimovel.setLayout ( null );
		telacriarimovel.setVisible(true);
		
	
		criar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    salvarimovel(index);
				telacriarimovel.dispose();
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos corretamente");
                }
			}
		});
	}
	
	/**
	 * Metodo que salva um novo imovel a ser criado utilizando do pacote control.
	 * @param index index da filial a qual vai ser salvo tal imovel
	 */
	public void salvarimovel(int index ) {
		int a = Integer.parseInt(inserirquantidade.getText());
		double b = Double.parseDouble(inserirvalor.getText());
		double c = Double.parseDouble(inserirtamanho.getText());
		if((new ControleFilial(ce)).salvarImovel((new ControleFilial(ce)).criarimovel(inserirnomeitem.getText(),a,inserirtipo.getText(),b,c,inserirendereco.getText(),inserirdataaqui.getText(),ce.retornatudofilial(index)),index,ce)==true) {
			JOptionPane.showMessageDialog(null,"Patrimonio cadastrado com sucesso!");
		}
		
	}

	public void actionPerformed(ActionEvent e){}
}
