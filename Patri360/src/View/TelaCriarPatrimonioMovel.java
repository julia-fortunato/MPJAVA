package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Control.*;

/**
 * Tela usada para criar um movel.
 * 
 * @author Julia Fortunato e Mauricio Araujo
 * @since 2023.1
 * @version 1.0
 * 
 */

public class TelaCriarPatrimonioMovel {

    // Componentes a serem utilizados na tela
    private JFrame telacriarmovel;
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
    private JButton criar;
    private JComboBox<String> uso;
    private static ControleEmpresa ce;

    
    /**
	 * Metodo que inicia a tela de criar patrimonio movel.
	 * @param index index da filial a qual esse movel criado vai ser vinculado
	 * @param dados ControleEmpresa antes iniciada
	 */
    public TelaCriarPatrimonioMovel(int index, ControleEmpresa dados) {

        ce = dados;

        // Cria novas instancias de todos os objetos a serem utilizados na tela
        labeluso = new JLabel("Uso: ");
        uso = new JComboBox<String>();
        uso.addItem(" ");
        uso.addItem("Em Uso");
        uso.addItem("Não esta em uso");
        criar = new JButton("Criar");
        classificacao = new JLabel("Classificação: ");
        fabricante = new JLabel("Fabricante: ");
        inserirclassificacao = new JTextField();
        condicao = new JLabel("Condição: ");
        inserircondicao = new JTextField();
        inserirfabricante = new JTextField();
        telacriarmovel = new JFrame("Criar Móvel");
        nomepatri = new JLabel("Criar Patrimonio");
        nomeitem = new JLabel("Nome do Item : ");
        quantidade = new JLabel("Quantidade: ");
        valor = new JLabel("Valor: ");
        inserirvalor = new JTextField();
        inserirquantidade = new JTextField();
        inserirnomeitem = new JTextField();

        // Seta os tamanhos de todos componentes
        labeluso.setBounds(109, 230, 481, 18);
        criar.setBounds(109, 370, 481, 67);
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
        telacriarmovel.add(labeluso);
        telacriarmovel.add(uso);
        telacriarmovel.add(criar);
        telacriarmovel.add(fabricante);
        telacriarmovel.add(classificacao);
        telacriarmovel.add(condicao);
        telacriarmovel.add(inserirclassificacao);
        telacriarmovel.add(inserircondicao);
        telacriarmovel.add(inserirfabricante);
        telacriarmovel.add(nomepatri);
        telacriarmovel.add(nomeitem);
        telacriarmovel.add(quantidade);
        telacriarmovel.add(valor);
        telacriarmovel.add(inserirvalor);
        telacriarmovel.add(inserirquantidade);
        telacriarmovel.add(inserirnomeitem);

        // Seta a dimensao da tela, seu layout como nulo, e a coloca visivel
        telacriarmovel.setBounds(610, 190, 700, 500);
        telacriarmovel.setLayout(null);
        telacriarmovel.setVisible(true);

        
        criar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    salvarmovel(index, uso.getSelectedIndex());
                telacriarmovel.dispose();
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos corretamente");
                }
            }
        });

    }

    /**
     * Metodo que determina o uso atraves de um int transformando ele em boolean.
     * 
     * @param uso valor do uso
     * @return boolean
     */
    public boolean setuso(int uso) {
        if (uso == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que cria um móvel, usando a função feita na control, salvando suas
     * informações.
     * 
     * @param index index da filial a qual o movel vai ser vinculado
     * @param valordacombobox valor da posicao em que a combobox esta
     */
    public void salvarmovel(int in, int valordacombobox) {
        int a = Integer.parseInt(inserirquantidade.getText());
        Double b = Double.parseDouble(inserirvalor.getText());
        boolean disponivel = false;
        if (valordacombobox >= 1 || valordacombobox <= 2) {
            disponivel = setuso(valordacombobox);
        } else if (valordacombobox == 0) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
        }
        

        if (new ControleFilial(ce).salvarMovel(new ControleFilial(ce).criarmovel(inserirfabricante.getText(), inserircondicao.getText(), inserirnomeitem.getText(),
                a, b, disponivel, inserirclassificacao.getText(),
                ce.retornatudofilial(in)), in, ce) == true) {
            JOptionPane.showMessageDialog(null, "Patrimonio cadastrado com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
        }
    }

}
