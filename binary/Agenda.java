/**
 * Classe Tree, usada para criar objetos que representarão TADS árvores no nosso sistema
 * 
 * @author Gabriela Cavalcante da Silva, Roberto Dantas.
 * @version 1.0
 */

public class Agenda {
    
    private Tree pessoas;
    
    /**
     * Construtor que inicializa instâncias da classe Agenda
     */
    public Agenda (){
        pessoas = new Tree();
    }
    
    /**
     * armazenaPessoa - método chamada para adicionar uma pessoa na agenda
     */
    public void armazenaPessoa(Pessoa pessoa){
       pessoas.add(pessoa);   
    }
    
    /**
     * removePessoa - método chamada para remover uma pessoa da agenda usando como parâmetro uma String nome
     * 
     * @params nome String com o valor nome, que será usada para buscar o registro a ser removido
     */
    public void removePessoa(String nome){
        Node toremove = pessoas.searchBreadth(nome);
        if (toremove != null){
                pessoas.remove(toremove);
        }
    }
    
    /**
     * buscaPessoa - método que retorna o nó com o valor desejado (passado por parâmetro)
     * 
     * @params nome String com valor a ser buscado
     * @return nó com o valor que está sendo buscado
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
     * imprimeAgenda - método chamado para imprimir os dados de todos os registros que estão em Agenda
     */
    public void imprimeAgenda(){
       pessoas.printPrefix();   
    }
    
    /**
     * imprimePessoa - método que a partir de uma String nome, busca um nó na árvore e imprime suas informações
     * 
     * @params nome String nome que será usada para encontrar um valor na árvore
     */
    public void imprimePessoa(String nome){
       Pessoa pessoa = buscaPessoa(nome);    
       if (pessoa != null){
            pessoa.print();
        }
       else {
            System.out.println("Pessoa não encontrada");
        }
    }
    
}