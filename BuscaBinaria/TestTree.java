/**
 * Classe Tree, usada para criar objetos que representarão TADS árvores no nosso sistema
 * 
 * @author Gabriela Cavalcante da Silva 2013022760, Gustavo Alves Bezerra 2014026460, Roberto Dantas 2014027940.
 * @version 2.0
 */

public class TestTree {
    
    private Tree treeValues;
    
    /**
     * Construtor que inicializa instâncias da classe TestTree
     */
    public TestTree (){
        treeValues = new Tree();
        add(50);
        add(35);
        add(70);
        add(25);
        add(40);
        add(65);
        add(90);
        add(30);
        add(80);
        add(20);
        add(100);
        add(37);
    }
    
    /**
     * add - método chamada para adicionar um nó com o key
     * @params key Int a ser armazenado
     */
    public void add(int key){
       treeValues.add(key);   
    }
    
    /**
     * removeNode - método chamada para remover um nó da arvore usando como parâmetro um Int key
     * 
     * @params key Int com o valor que será usada para buscar o registro a ser removido
     */
    public void removeNode(int key){
        Node toremove = treeValues.searchBreadth(key);
        if (toremove != null){
                treeValues.remove(toremove);
        }
    }
    
    /**
     * buscaNode - método que retorna o nó com o valor desejado (passado por parâmetro)
     * 
     * @params key Int com valor a ser buscado
     * @return Node que está sendo buscado
     */
    public Node buscaNode(int key){
        Node node = treeValues.searchBreadth(key);
        if ( node!= null ) {
            return node;
        }
        else {
            return null;
        }
    }
    
    /**
     * imprime a arvore - método chamado para imprimir os dados de todos os registros que estão na arvore
     */
    public void imprime(){
       treeValues.printPrefix();   
    }
        
}