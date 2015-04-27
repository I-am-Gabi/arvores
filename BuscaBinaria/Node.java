
/**
 * Classe Node será usada para representar o cada nó da árvore
 * 
 * @author Gabriela Cavalcante da Silva 2013022760 | Gustavo Alves Bezerra 2014026460 | Roberto Dantas 2014027940.
 * @version 2.0
 */
public class Node {
    private int key;      // informação do nó
    private Node left;    // nó de referência para o filho da esquerda
    private Node right;   // nó de referência para o filho da direita
    private Node parent;  // nó de referência para o nó pai
    private Node min;     // nó que aponta para o menor valor da sub-árvore (pode ser ele mesmo)
    private Node max;     // nó que aponta para o menor valor da sub-árvore (pode ser ele mesmo)
    
    /**
     * Construtor para objetos da classe Node  
     */ 
    public Node (){       
        this.left = null;
        this.right = null;
        this.parent = null;
        this.min = this;
        this.max = this;
    }  
      
    /**
     * Construtor para objetos da classe Node 
     * 
     * @params key informação quer será armazenada no nó no campo key
     */ 
    public Node (int key){
        this.key = key;     // inicializar nó chave com a informação
        this.left = null;
        this.right = null;
        this.parent = null;
        this.min = this;
        this.max = this;
    }    
    
    /**
     * getkey - método que retorna o valor do campo key do objeto
     * 
     * @return key valor existente no campo key 
     */     
    public int getKey(){
        return key;
    }
    
    /**
     * getLeft - método que retorna o nó a esqueda no nó atual
     * 
     * @return left nó a esquerda da instância de Node atualizada
     */ 
    public Node getLeft(){
        return left;
    }
   
    /**
     * getRight - método que retorna o nó a direita no nó atual
     * 
     * @return right nó a direita da instância de Node atualizada
     */ 
    public Node getRight(){
        return right;
    }
     
    /**
     * getParent - método que retorna o nó pai do nó atual
     * 
     * @return parent nó pai da instância de Node atualizada
     */ 
    public Node getParent(){
        return parent;
    }
    
    /**
     * getMin - método que retorna o nó que contem a chave com menor valor da 
     * subárvore cujo this é raiz
     * 
     * @return return referência ao nó com menor chave da subárvore
     */
    public Node getMin() {
        return min;
    }
    
    /**
     * getMax - método que retorna o nó que contem a chave com maior valor da 
     * subárvore cujo this é raiz
     * 
     * @return return referência ao nó com menor chave da subárvore
     */    
    public Node getMax() {
        return max;
    }
    
    /**
     * setkey - método que modifica o valor do campo key
     * 
     * @params key valor que será setado no campo key do nó
     */ 
    public void setKey(int key) {
        this.key = key;
        /**
         * Não altera os valores mínimo e máximo pois caso a key seja alterada, 
         * será necessário uma reorganização da árvore, estando fora do escopo 
         * do nó
         */
    }
    
    /**
     * setLeft - método que modifica o valor campo que armazena o nó esquedo 
     * 
     * @params left valor que será setado no campo que representa o nó esquerdo 
     * ao nó atual
     */ 
    public void setLeft(Node left){
        this.left = left;
        /**
         * não altera o valor mínimo pois será necessário mudar o valor mínimo 
         * dos pais, o que está fora do escopo do nó, sendo a responsabilidade 
         * transferida para a árvore
         */
    }

    /**
     * setRight - método que modifica o valor campo que armazena o nó direito 
     * 
     * @params right valor que será setado no campo que representa o nó direito 
     * ao nó atual
     */ 
    public void setRight(Node right){
        this.right = right;
        /**
         * Não altera o valor máximo pois será necessário mudar o valor máximo 
         * dos pais, o que está fora do escopo do nó, sendo a responsabilidade 
         * transferida para a árvore
         */
    }     
    
    /**
     * setParent - método que modifica o valor campo que armazena o nó pai 
     * 
     * @params parent valor que será setado no campo que representa o nó pai do
     * nó atual
     */ 
    public void setParent(Node parent){
        this.parent = parent;
    }
    
    /**
     * setMin - atualiza referência do nó que a chave é o menor valor da 
     * subárvore da qual this é a raiz
     * 
     * @param min novo nó que conterá o novo valor mínimo da sub-árvore da 
     * qual this é a raiz
     */
    public void setMin(Node min) {
        this.min = min;
    }

    /**
     * setMax - atualiza referência do nó que a chave é o maior valor da 
     * subárvore da qual this é a raiz
     * 
     * @param max novo nó que conterá o novo valor máximo da subárvore da 
     * qual this é a raiz
     */
    public void setMax(Node max) {
        this.max = max;
    }
        
    /**
     * isLeft - método que retorna true caso o nó seja o nó esquerdo do seu pai
     * 
     * @return true caso ele seja o nó esquerdo, e false caso contrário
     */ 
    public boolean isLeft(){
        if (this.getParent() != null){
            if (this.getParent().getLeft() == this){
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    /**
     * isRoot - método verifica se o nó é um nó raiz
     * 
     * @return true caso o nó seja raiz, e false caso contrário
     */ 
    public boolean isRoot(){
        if(parent == null){
            return true;
        }
        return false;
    }

}
