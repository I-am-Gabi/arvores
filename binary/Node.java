/**
 * Write a description of class Node here.
 * 
 * @author Gabriela Cavalcante da Silva, Roberto Dantas.
 * @version 1.0
 */
public class Node {
    private Pessoa data;
    private Node left;
    private Node right;
    private Node parent;  
    
    public Node (){
        this.data = null;
        this.left = null;
        this.right = null; 
        this.parent = null;
    }
    
    public Node (Pessoa pessoa){
        this.data = pessoa;
        this.left = null;
        this.right = null;
        this.parent = null;  
    }    
        
    public Pessoa getData(){
        return data;
    }
    
    public Node getLeft(){
        return left;
    }
   
    public Node getRight(){
        return right;
    }
     
    public Node getParent(){
        return parent;
    }
    
    public void setData(Pessoa pessoa) {
        this.data = pessoa;
    }
    
    public void setLeft(Node left){
        this.left = left;
    }

    public void setRight(Node right){
        this.right = right;
    }     
    
    public void setParent(Node parent){
        this.parent = parent;
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
