/**
 * Write a description of class Tree here.
 * 
 * @author Gabriela Cavalcante da Silva, Roberto Dantas.
 * @version 1.0
 */

public class Agenda {
    
    private Tree pessoas;
    
    /**
     * Construtor que inicializa 
     */
    public Agenda (){
        pessoas = new Tree();
    }
    
    public void armazenaPessoa(Pessoa pessoa){
       pessoas.add(pessoa);   
    }
    public void removePessoa(String nome){
        Node toremove = pessoas.searchBreadth(nome);
        if (toremove != null){
                pessoas.remove(toremove);
        }
    }
    public Pessoa buscaPessoa(String nome){
        Node node = pessoas.searchBreadth(nome);
        if ( node!= null ) {
            return node.getData();
        }
        else {
            return null;
        }
    }
    public void imprimeAgenda(){
       pessoas.printPrefix();   
    }
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