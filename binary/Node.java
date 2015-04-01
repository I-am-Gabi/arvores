/**
 * Write a description of class Node here.
 * 
 * @author Gabriela Cavalcante da Silva, Roberto Dantas.
 * @version 1.0
 */
public class Node {
    private Pessoa data;  // informação do nó
    private Node left;    // nó a esquerda
    private Node right;   // nó a direita
    private Node parent;  // nó pai
    
    /**
     * Construtor para objetos da classe Node 
     */ 
    public Node (){
        this.data = null;
        this.left = null;
        this.right = null; 
        this.parent = null;
    }
    
    /**
     * Construtor para objetos da classe Node 
     * 
     * @params pessoa Objeto do tipo Pessoa que será adicionado no campo data do Node
     */ 
    public Node (Pessoa pessoa){
        this.data = pessoa;
        this.left = null;
        this.right = null;
        this.parent = null;  
    }    
    
    /**
     * getData - método que retorna o valor do campo data do objeto
     * 
     * @return data valor existente no campo data 
     */     
    public Pessoa getData(){
        return data;
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
     * getParent - método que retorna o nó a esqueda no nó atual
     * 
     * @return parent nó pai da instância de Node atualizada
     */ 
    public Node getParent(){
        return parent;
    }
    
    /**
     * setData - método que modifica o valor do campo data
     * 
     * @params pessoa valor que será setado no campo data do nó
     */ 
    public void setData(Pessoa pessoa) {
        this.data = pessoa;
    }
    
    /**
     * setLeft - método que modifica o valor campo que armazena o nó esquedo 
     * 
     * @params left valor que será setado no campo que representa o nó esquerdo ao nó atual
     */ 
    public void setLeft(Node left){
        this.left = left;
    }

    /**
     * setRight - método que modifica o valor campo que armazena o nó direito 
     * 
     * @params right valor que será setado no campo que representa o nó direito ao nó atual
     */ 
    public void setRight(Node right){
        this.right = right;
    }     
    
    /**
     * setParent - método que modifica o valor campo que armazena o nó pai 
     * 
     * @params parent valor que será setado no campo que representa o nó pai do nó atual
     */ 
    public void setParent(Node parent){
        this.parent = parent;
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
