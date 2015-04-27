
/**
 * Classe Node ser� usada para representar o cada n� da �rvore
 * 
 * @author Gabriela Cavalcante da Silva 2013022760 | Gustavo Alves Bezerra 2014026460 | Roberto Dantas 2014027940.
 * @version 2.0
 */
public class Node {
    private int key;      // informa��o do n�
    private Node left;    // n� de refer�ncia para o filho da esquerda
    private Node right;   // n� de refer�ncia para o filho da direita
    private Node parent;  // n� de refer�ncia para o n� pai
    private Node min;     // n� que aponta para o menor valor da sub-�rvore (pode ser ele mesmo)
    private Node max;     // n� que aponta para o menor valor da sub-�rvore (pode ser ele mesmo)
    
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
     * @params key informa��o quer ser� armazenada no n� no campo key
     */ 
    public Node (int key){
        this.key = key;     // inicializar n� chave com a informa��o
        this.left = null;
        this.right = null;
        this.parent = null;
        this.min = this;
        this.max = this;
    }    
    
    /**
     * getkey - m�todo que retorna o valor do campo key do objeto
     * 
     * @return key valor existente no campo key 
     */     
    public int getKey(){
        return key;
    }
    
    /**
     * getLeft - m�todo que retorna o n� a esqueda no n� atual
     * 
     * @return left n� a esquerda da inst�ncia de Node atualizada
     */ 
    public Node getLeft(){
        return left;
    }
   
    /**
     * getRight - m�todo que retorna o n� a direita no n� atual
     * 
     * @return right n� a direita da inst�ncia de Node atualizada
     */ 
    public Node getRight(){
        return right;
    }
     
    /**
     * getParent - m�todo que retorna o n� pai do n� atual
     * 
     * @return parent n� pai da inst�ncia de Node atualizada
     */ 
    public Node getParent(){
        return parent;
    }
    
    /**
     * getMin - m�todo que retorna o n� que contem a chave com menor valor da 
     * sub�rvore cujo this � raiz
     * 
     * @return return refer�ncia ao n� com menor chave da sub�rvore
     */
    public Node getMin() {
        return min;
    }
    
    /**
     * getMax - m�todo que retorna o n� que contem a chave com maior valor da 
     * sub�rvore cujo this � raiz
     * 
     * @return return refer�ncia ao n� com menor chave da sub�rvore
     */    
    public Node getMax() {
        return max;
    }
    
    /**
     * setkey - m�todo que modifica o valor do campo key
     * 
     * @params key valor que ser� setado no campo key do n�
     */ 
    public void setKey(int key) {
        this.key = key;
        /**
         * N�o altera os valores m�nimo e m�ximo pois caso a key seja alterada, 
         * ser� necess�rio uma reorganiza��o da �rvore, estando fora do escopo 
         * do n�
         */
    }
    
    /**
     * setLeft - m�todo que modifica o valor campo que armazena o n� esquedo 
     * 
     * @params left valor que ser� setado no campo que representa o n� esquerdo 
     * ao n� atual
     */ 
    public void setLeft(Node left){
        this.left = left;
        /**
         * n�o altera o valor m�nimo pois ser� necess�rio mudar o valor m�nimo 
         * dos pais, o que est� fora do escopo do n�, sendo a responsabilidade 
         * transferida para a �rvore
         */
    }

    /**
     * setRight - m�todo que modifica o valor campo que armazena o n� direito 
     * 
     * @params right valor que ser� setado no campo que representa o n� direito 
     * ao n� atual
     */ 
    public void setRight(Node right){
        this.right = right;
        /**
         * N�o altera o valor m�ximo pois ser� necess�rio mudar o valor m�ximo 
         * dos pais, o que est� fora do escopo do n�, sendo a responsabilidade 
         * transferida para a �rvore
         */
    }     
    
    /**
     * setParent - m�todo que modifica o valor campo que armazena o n� pai 
     * 
     * @params parent valor que ser� setado no campo que representa o n� pai do
     * n� atual
     */ 
    public void setParent(Node parent){
        this.parent = parent;
    }
    
    /**
     * setMin - atualiza refer�ncia do n� que a chave � o menor valor da 
     * sub�rvore da qual this � a raiz
     * 
     * @param min novo n� que conter� o novo valor m�nimo da sub-�rvore da 
     * qual this � a raiz
     */
    public void setMin(Node min) {
        this.min = min;
    }

    /**
     * setMax - atualiza refer�ncia do n� que a chave � o maior valor da 
     * sub�rvore da qual this � a raiz
     * 
     * @param max novo n� que conter� o novo valor m�ximo da sub�rvore da 
     * qual this � a raiz
     */
    public void setMax(Node max) {
        this.max = max;
    }
        
    /**
     * isLeft - m�todo que retorna true caso o n� seja o n� esquerdo do seu pai
     * 
     * @return true caso ele seja o n� esquerdo, e false caso contr�rio
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
     * isRoot - m�todo verifica se o n� � um n� raiz
     * 
     * @return true caso o n� seja raiz, e false caso contr�rio
     */ 
    public boolean isRoot(){
        if(parent == null){
            return true;
        }
        return false;
    }

}
