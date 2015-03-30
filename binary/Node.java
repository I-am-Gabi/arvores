/**
 * Write a description of class Node here.
 * 
 * @author Roberto D.; Gabriela C.; Gustavo A.
 * @version 1.0
 */
public class Node {
    private Pessoa data;
    private Node left;
    private Node right;
    private Node parent; 
    private int height;
    
    public Node (){
        this.data = null;
        this.left = null;
        this.right = null; 
    }
    
    public Node (Pessoa pessoa){
        this.data = pessoa;
        this.left = null;
        this.right = null;  
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
    
    public int getHeight() {
        return height;
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
    
    public void setHeight(int height) {
        this.height = height;
    } 
}
