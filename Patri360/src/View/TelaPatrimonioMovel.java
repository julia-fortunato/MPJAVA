package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Control.*;

/**
 * Tela para mostrar detalhes de moveis e edita-los.
 * 
 * @author Julia Fortunato e Mauricio Araujo
 * @since 2023.1
 * @version 1.0
 * 
 */

public class TelaPatrimonioMovel {


    // Componentes a serem utilizados na tela
    private JFrame telamovel;
    private JTextField inserirclassificacao;
    private JTextField inserircondicao;
    private JTextField inserirfabricante;
    private JTextField inserirnomeitem;
    private JTextField inserirquantidade;
    private JTextField inserirvalor;
    private JLabel labeluso;
    private JLabel nomepatri;
    private JLabel classificacao;
    private JLabel condicao;
    private JLabel fabricante;
    private JLabel nomeitem;
    private JLabel quantidade;
    private JLabel valor;
    private JButton salvar;
    private JButton excluir;
    private JComboBox<String> uso;
    private static ControleEmpresa ce;

    /**
	 * Metodo construtor da tela.
	 * @param index index da filial respectiva do patrimonio a ser aberto
	 * @param controleindex index do movel respectivo a ser aberto
	 * @param dados ControleEmpresa antes aberto na primeira tela
	 */
    public TelaPatrimonioMovel(int index, int controleindex,ControleEmpresa dados) {
        
        ce = dados;

        // Transforma os valores que não são Strings para serem mostrados 
        String mostrarvalor = String.valueOf((new ControleFilial(ce)).retornarmovel(index, controleindex).getvalor());
        String mostrarquantidade = Integer.toString((new ControleFilial(ce)).retornarmovel(index, controleindex).getquantidade());


        // Cria novas instancias de todos os objetos a serem utilizados na tela
        inserirclassificacao = new JTextField((new ControleFilial(ce)).retornarmovel(index, controleindex).getClassificacao());
        inserircondicao = new JTextField((new ControleFilial(ce)).retornarmovel(index, controleindex).getCondicao());
        inserirfabricante = new JTextField((new ControleFilial(ce)).retornarmovel(index, controleindex).getFabricante());
        inserirvalor = new JTextField(mostrarvalor);
        inserirquantidade = new JTextField(mostrarquantidade);
        inserirnomeitem = new JTextField((new ControleFilial(ce)).retornarmovel(index, controleindex).getNomeItem());
        labeluso = new JLabel("Uso: ");
        uso = new JComboBox<String>();
        uso.addItem(" ");
        uso.addItem("Em Uso");
        uso.addItem("Não esta em uso");
        uso.setSelectedIndex(setcombobox((new ControleFilial(ce)).retornarmovel(index, controleindex).getDisponibilidade()));
        salvar = new JButton("Salvar");
        excluir = new JButton("Excluir");
        classificacao = new JLabel("Classificação: ");
        fabricante = new JLabel("Fabricante: ");
        condicao = new JLabel("Condição: ");
        telamovel = new JFrame("Detalhe Móvel");
        nomepatri = new JLabel("Patrimonio Movel");
        nomeitem = new JLabel("Nome do Item : ");
        quantidade = new JLabel("Quantidade: ");
        valor = new JLabel("Valor: ");


        // Seta os tamanhos de todos componentes
        labeluso.setBounds(109, 230, 481, 18);
        salvar.setBounds(76, 378, 266, 67);
        excluir.setBounds(358, 378, 263, 67);
        classificacao.setBounds(109, 190, 481, 18);
        condicao.setBounds(109, 270, 481, 18);
        fabricante.setBounds(109, 310, 481, 18);
        inserirfabricante.setBounds(109, 329, 481, 18);
        inserircondicao.setBounds(109, 289, 481, 18);
        inserirclassificacao.setBounds(109, 209, 481, 18);
        nomepatri.setBounds(280, 30, 137, 19);
        uso.setBounds(109, 249, 481, 18);
        nomeitem.setBounds(109, 60, 481, 18);
        quantidade.setBounds(109, 105, 481, 18);
        valor.setBounds(109, 145, 481, 18);
        inserirvalor.setBounds(109, 165, 481, 18);
        inserirquantidade.setBounds(109, 125, 481, 18);
        inserirnomeitem.setBounds(109, 85, 481, 18);


        // Adiciona todos os componentes na tela
        telamovel.add(labeluso);
        telamovel.add(uso);
        telamovel.add(salvar);
        telamovel.add(excluir);
        telamovel.add(fabricante);
        telamovel.add(classificacao);
        telamovel.add(condicao);
        telamovel.add(inserirclassificacao);
        telamovel.add(inserircondicao);
        telamovel.add(inserirfabricante);
        telamovel.add(nomepatri);
        telamovel.add(nomeitem);
        telamovel.add(quantidade);
        telamovel.add(valor);
        telamovel.add(inserirvalor);
        telamovel.add(inserirquantidade);
        telamovel.add(inserirnomeitem);


        // Seta a dimensao da tela, seu layout como nulo, e a coloca visivel
        telamovel.setBounds(610, 190, 700, 500);
        telamovel.setLayout(null);
        telamovel.setVisible(true);

        salvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Salvar um movel 
                int valordacombobox = uso.getSelectedIndex();
                int a = Integer.parseInt(inserirquantidade.getText());
                Double b = Double.parseDouble(inserirvalor.getText());
                boolean disponivel = false;
                    if (valordacombobox >= 1 || valordacombobox <= 2) {
                        disponivel = setuso(valordacombobox);
                    } else if (valordacombobox == 0) {
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos");
                    }
                 
                new ControleFilial(ce).editarMovel((new ControleFilial(ce)).criarmovel(inserirfabricante.getText(), inserircondicao.getText(),
                        inserirnomeitem.getText(), a, b, disponivel, inserirclassificacao.getText(),(new ControleEmpresa()).retornatudofilial(index)), controleindex, index,ce);
                JOptionPane.showMessageDialog(null, "Patrimonio editado com sucesso");
                telamovel.dispose();
            }
        });
        
        excluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // Excluir um determinado movel
                if((new ControleFilial(ce)).removeMovel(index, controleindex,ce)==true){
                    JOptionPane.showMessageDialog(null, "Patrimonio excluido com sucesso!");
                    telamovel.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Erro, tente novamente");
                }
            }
        });
    }

    /**
     * Metodo para instanciar um boolean atraves de um inteiro sendo TRUE(em uso).
     * @param uso inteiro usado para determinar o boolean
     * @return boolean
     */
    public boolean setuso (int uso){
        if(uso == 1){
            return true;
        } else{
            return false;
        }
    }

    /**
     * Metodo para transformar um boolean em um inteiro sendo TRUE(1) e False(2).
     * @param a boolean a ser transformado
     * @return inteiro gerado a partir do boolean
     */
    public int setcombobox(boolean a) {
        if (a == true) {
            return 1;
        } else {
            return 2;
        }
    }
}