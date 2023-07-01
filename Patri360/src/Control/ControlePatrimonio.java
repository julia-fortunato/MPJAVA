package Control;

/**
 * Classe responsavel por fazer a mediacao dos dados de filiais e patrimonios
 * para listagem e busca.
 * 
 * @author Julia Fortunato e Mauricio Araujo
 * @since 2023.1
 * @version 1.0
 * 
 */

public class ControlePatrimonio {

    private ControleEmpresa ce;

    /**
     * Construtor da classe ControlePatrimonio que serve para utilizar a mesma
     * instancia da classe ControleEmpresa.
     * 
     * @param dados instancia da ControleEmpresa
     */
    public ControlePatrimonio(ControleEmpresa dados) {
        ce = dados;

    }

    /**
     * Metodo que percorre todas as filiais e soma o tamanho das Arraylists de
     * moveis.
     * 
     * @return int
     */
    public int qtdTotalMoveis() {
        int total = 0;
        for (int i = 0; i < ce.getQtdFiliais(); i++) {
            total += ce.retornatudofilial(i).getMoveis().size();
        }
        return total;
    }

    /**
     * Metodo que percorre todas as filiais e soma o tamanho das Arraylists de
     * imoveis.
     * 
     * @return int
     */
    public int qtdTotalImoveis() {
        int total = 0;
        for (int i = 0; i < ce.getQtdFiliais(); i++) {
            total += ce.retornatudofilial(i).getImoveis().size();
        }
        return total;
    }

    /**
     * Metodo que retorna todos os nomes dos moveis de todas as filiais, com dois
     * loopings.
     * 
     * @return String[]
     */
    public String[] fillmoveis() {
        String dados[] = new String[qtdTotalMoveis()];
        int l = 0;

        for (int i = 0; i < ce.getQtdFiliais(); i++) {
            for (int j = 0; j < ce.retornatudofilial(i).getMoveis().size(); j++) {
                dados[l] = ce.retornatudofilial(i).getMoveis().get(j).getNomeItem();
                l++;
            }
        }
        return dados;
    }

    /**
     * Metodo que retorna a posicao da filial de determinado movel atraves do seu
     * nome.
     * 
     * @param m nome do movel a ser pesquisado a filial
     * @return int
     */
    public int posicaofilialmovel(String m) {
        for (int i = 0; i < ce.getQtdFiliais(); i++) {
            for (int j = 0; j < ce.retornatudofilial(i).getMoveis().size(); j++) {
                if (m.equals(ce.retornatudofilial(i).getMoveis().get(j).getNomeItem())) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Metodo que retorna a posicao da filial de determinado imovel atraves do seu
     * nome.
     * 
     * @param m nome do imovel a ser pesquisado a filial
     * @return int
     */
    public int posicaofilialimovel(String m) {
        for (int i = 0; i < ce.getQtdFiliais(); i++) {
            for (int j = 0; j < ce.retornatudofilial(i).getImoveis().size(); j++) {
                if (m.equals(ce.retornatudofilial(i).getImoveis().get(j).getNomeItem())) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Metodo que retorna a posicao de um movel dentro de determinada filial atraves
     * de seu nome.
     * 
     * @param m nome do movel a ser pesquisado dentro de uma filial
     * @return int
     */
    public int posicaomovel(String m) {
        for (int i = 0; i < ce.getQtdFiliais(); i++) {
            for (int j = 0; j < ce.retornatudofilial(i).getMoveis().size(); j++) {
                if (m.equals(ce.retornatudofilial(i).getMoveis().get(j).getNomeItem())) {
                    return j;
                }
            }
        }
        return -1;
    }

    /**
     * Metodo que retorna a posicao de um imovel dentro de determinada filial
     * atraves de seu nome.
     * 
     * @param m nome do imovel a ser pesquisado dentro de uma filial
     * @return int 
     */
    public int posicaoimovel(String m) {
        for (int i = 0; i < ce.getQtdFiliais(); i++) {
            for (int j = 0; j < ce.retornatudofilial(i).getImoveis().size(); j++) {
                if (m.equals(ce.retornatudofilial(i).getImoveis().get(j).getNomeItem())) {
                    return j;
                }
            }
        }
        return -1;
    }

    /**
     * Metodo que retorna todos nomes dos imoveis de todas as filiais, com dois
     * loopings.
     * 
     * @return String[]
     */
    public String[] fillimoveis() {
        String dados[] = new String[qtdTotalImoveis()];
        int l = 0;
        for (int i = 0; i < ce.getQtdFiliais(); i++) {
            for (int j = 0; j < ce.retornatudofilial(i).getImoveis().size(); j++) {
                dados[l] = ce.retornatudofilial(i).getImoveis().get(j).getNomeItem();

                l++;
            }
        }
        return dados;
    }

    /**
     * Funcao de busca de um determinado movel dado seu nome.
     * 
     * @param nome nome do movel a ser procurado
     * @return int
     */
    public int pesquisaMovel(String nome) {
        String[] moveis = fillmoveis();

        for (int i = 0; i < qtdTotalMoveis(); i++) {
            if (moveis[i].equals(nome)) {

                return i; // Retorna o indice se for encontrado

            }
        }
        return -1; // Retorna -1 se o nome não for encontrado
    }
}
