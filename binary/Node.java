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

}
