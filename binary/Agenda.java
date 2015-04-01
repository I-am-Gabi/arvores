/**
 * Classe Tree, usada para criar objetos que representar�o TADS �rvores no nosso sistema
 * 
 * @author Gabriela Cavalcante da Silva, Roberto Dantas.
 * @version 1.0
 */

public class Agenda {
    
    private Tree pessoas;
    
    /**
     * Construtor que inicializa inst�ncias da classe Agenda
     */
    public Agenda (){
        pessoas = new Tree();
    }
    
    /**
     * armazenaPessoa - m�todo chamada para adicionar uma pessoa na agenda
     */
    public void armazenaPessoa(Pessoa pessoa){
       pessoas.add(pessoa);   
    }
    
    /**
     * removePessoa - m�todo chamada para remover uma pessoa da agenda usando como par�metro uma String nome
     * 
     * @params nome String com o valor nome, que ser� usada para buscar o registro a ser removido
     */
    public void removePessoa(String nome){
        Node toremove = pessoas.searchBreadth(nome);
        if (toremove != null){
                pessoas.remove(toremove);
        }
    }
    
    /**
     * buscaPessoa - m�todo que retorna o n� com o valor desejado (passado por par�metro)
     * 
     * @params nome String com valor a ser buscado
     * @return n� com o valor que est� sendo buscado
     */
    public Pessoa buscaPessoa(String nome){
        Node node = pessoas.searchBreadth(nome);
        if ( node!= null ) {
            return node.getData();
        }
        else {
            return null;
        }
    }
    
    /**
     * imprimeAgenda - m�todo chamado para imprimir os dados de todos os registros que est�o em Agenda
     */
    public void imprimeAgenda(){
       pessoas.printPrefix();   
    }
    
    /**
     * imprimePessoa - m�todo que a partir de uma String nome, busca um n� na �rvore e imprime suas informa��es
     * 
     * @params nome String nome que ser� usada para encontrar um valor na �rvore
     */
    public void imprimePessoa(String nome){
       Pessoa pessoa = buscaPessoa(nome);    
       if (pessoa != null){
            pessoa.print();
        }
       else {
            System.out.println("Pessoa n�o encontrada");
        }
    }
    
}