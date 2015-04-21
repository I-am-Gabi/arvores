
/**
 * Classe Node ser� usada para representar o cada n� da �rvore
 * 
 * @author Gabriela Cavalcante da Silva 2013022760 , Roberto Dantas 2014027940.
 * @version 1.0
 */
public class Node {
    private int key;  // informa��o do n�
    private Node left;    // n� a esquerda
    private Node right;   // n� a direita
    private Node parent;  // n� pai
    private Node min;   //n� que aponta para o menor valor da sub-�rvore (pode ser ele mesmo)
    private Node max;   //n� que aponta para o menor valor da sub-�rvore (pode ser ele mesmo)
    
    /**
     * Construtor para objetos da classe Node 
     */ 
    public Node (){
        this.left = null;
        this.right = null; 
        this.parent = null;
        this.min = null;
        this.max = null;
    }
    
    /**
     * Construtor para objetos da classe Node 
     * 
     * @params pessoa Objeto do tipo Pessoa que ser� adicionado no campo key do Node
     */ 
    public Node (int key){
        this.key = key;
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
     * setkey - m�todo que modifica o valor do campo key
     * 
     * @params pessoa valor que ser� setado no campo key do n�
     */ 
    public void setKey(int key) {
        this.key = key;
        /*n�o altera os valores m�nimo e m�ximo pois caso a key seja alterada, ser� necess�rio uma reorganiza��o da �rvore, estando
         * fora do escopo do n�
         */
    }
    
    /**
     * setLeft - m�todo que modifica o valor campo que armazena o n� esquedo 
     * 
     * @params left valor que ser� setado no campo que representa o n� esquerdo ao n� atual
     */ 
    public void setLeft(Node left){
        this.left = left;
        /*n�o altera o valor m�nimo pois ser� necess�rio mudar o valor m�nimo dos pais, o que est� fora do escopo do n�,
         * sendo a responsabilidade transferida para a �rvore
         */
    }

    /**
     * setRight - m�todo que modifica o valor campo que armazena o n� direito 
     * 
     * @params right valor que ser� setado no campo que representa o n� direito ao n� atual
     */ 
    public void setRight(Node right){
        this.right = right;
        /*n�o altera o valor m�ximo pois ser� necess�rio mudar o valor m�ximo dos pais, o que est� fora do escopo do n�,
         * sendo a responsabilidade transferida para a �rvore
         */
    }     
    
    /**
     * setParent - m�todo que modifica o valor campo que armazena o n� pai 
     * 
     * @params parent valor que ser� setado no campo que representa o n� pai do n� atual
     */ 
    public void setParent(Node parent){
        this.parent = parent;
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
