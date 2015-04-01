/**
 * Write a description of class Node here.
 * 
 * @author Roberto D.; Gabriela C.; Gustavo A.
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
