/**
 * Write a description of class Node here.
 * 
 * @author Roberto D.; Gabriela C.; Gustavo A.
 * @version 1.0
 */
public class Node {
    private Pessoa data;  // informa��o do n�
    private Node left;    // n� a esquerda
    private Node right;   // n� a direita
    private Node parent;  // n� pai
    
    /**
     * Construtor para objetos da classe Node 
     */ 
    public Node (){
        this.data = null;
        this.left = null;
        this.right = null; 
    }
    
    /**
     * Construtor para objetos da classe Node 
     * 
     * @params pessoa Objeto do tipo Pessoa que ser� adicionado no campo data do Node
     */ 
    public Node (Pessoa pessoa){
        this.data = pessoa;
        this.left = null;
        this.right = null;  
    }    
    
    /**
     * getData - m�todo que retorna o valor do campo data do objeto
     * 
     * @return data valor existente no campo data 
     */     
    public Pessoa getData(){
        return data;
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
     * getParent - m�todo que retorna o n� a esqueda no n� atual
     * 
     * @return parent n� pai da inst�ncia de Node atualizada
     */ 
    public Node getParent(){
        return parent;
    }
    
    /**
     * setData - m�todo que modifica o valor do campo data
     * 
     * @params pessoa valor que ser� setado no campo data do n�
     */ 
    public void setData(Pessoa pessoa) {
        this.data = pessoa;
    }
    
    /**
     * setLeft - m�todo que modifica o valor campo que armazena o n� esquedo 
     * 
     * @params left valor que ser� setado no campo que representa o n� esquerdo ao n� atual
     */ 
    public void setLeft(Node left){
        this.left = left;
    }

    /**
     * setRight - m�todo que modifica o valor campo que armazena o n� direito 
     * 
     * @params right valor que ser� setado no campo que representa o n� direito ao n� atual
     */ 
    public void setRight(Node right){
        this.right = right;
    }     
    
    /**
     * setParent - m�todo que modifica o valor campo que armazena o n� pai 
     * 
     * @params parent valor que ser� setado no campo que representa o n� pai do n� atual
     */ 
    public void setParent(Node parent){
        this.parent = parent;
    } 
    
    public void addExistentNode(Node where, Node toadd){
        if (toadd != null){
            int pessoaCPF = Integer.parseInt(toadd.getData().getCPF());
            int dataCPF = Integer.parseInt(data.getCPF());        
            if( pessoaCPF < dataCPF ){
                if(where.getLeft() != null){
                    addExistentNode(where.getLeft(),toadd);
                }
                else{
                    where.setLeft(toadd);
                    where.getLeft().setParent(where); 
                }
            }
            else if(pessoaCPF > dataCPF){
                if (where.getRight() != null){
                    addExistentNode(where.getRight(),toadd);
                }
                else {
                    where.setRight(toadd);
                    where.getRight().setParent(where); 
                }
            }
        }
    }
    
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

    public boolean isRoot(){
        if(parent == null){
            return true;
        }
        return false;
    }

}
