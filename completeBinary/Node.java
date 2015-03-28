import java.util.ArrayList;

/**
 * Write a description of class Node here.
 * 
 * @author Roberto Anrafell Araujo Dantas.
 * @version 1.00
 */
public class Node {
    private Pessoa data;
    private Node left;
    private Node right;
    private Node parent;
    private Node brother;
    private Node leftBrother;
    
    public Node (){
        data = null;
        left = null;
        right = null;
        brother = null;
        leftBrother = null;
    }
    
    public Node (Pessoa pessoa){
        data = pessoa;
        left = null;
        right = null;
        brother = null;
        leftBrother = null;
    }    
    
    public boolean isEmpty(){
        if (data == null) { return true; }
        else { return false; }
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
    
    public Node getBrother(){
        return brother;
    }
    
    public Node getLeftBrother(){
        return leftBrother;   
    }
    
    public Node getParent(){
        return parent;
    }
    
    public void setLeft(Node left){
        this.left = left;
    }

    public void setRight(Node right){
        this.right = right;
    }    
    
    public void setBrother(Node brother){
        this.brother = brother;
    }    
    
    public void setLeftBrother(Node brother){
        this.leftBrother = brother;   
    }
    
    public void setParent(Node parent){
        this.parent = parent;
    }
    
    public void setData(Pessoa pessoa){
        data = pessoa;
    }
    
    public void addChildren(Node where, Pessoa pessoa){
        int pessoaCPF = Integer.parseInt(pessoa.getCPF());
        int dataCPF = Integer.parseInt(where.getData().getCPF());        
        if( pessoaCPF < dataCPF ){
            if(where.getLeft() == null){
                where.setLeft(new Node(pessoa));
                where.getLeft().setParent(where);
                if (where.getLeftBrother() != null){
                    where.getLeftBrother().getRight().setBrother(where.getLeft());   
                }
                if(where.getRight() == null){
                    where.setRight(new Node());
                    where.getRight().setParent(where);
                    where.getLeft().setBrother(where.getRight());
                    where.getRight().setLeftBrother(where.getLeft());
                    if (where.getBrother() != null){
                        if (where.getBrother().getLeft() != null){
                            where.getRight().setBrother(where.getBrother().getLeft());
                        }
                    }
                }
            }(a version number or a date)
            else {
                if(where.getLeft().isEmpty()){
                    where.getLeft().setData(pessoa);
                        if(where.getLeftBrother() != null){
                            getLeftBrother().getRight().setBrother(where.getLeft());
                        }
                }
                else {
                    addChildren(where.getLeft(), pessoa);   
                }
            }
       
        }
        else if(pessoaCPF > dataCPF){
            if(where.getRight() == null){
                where.setRight(new Node(pessoa));
                where.getRight().setParent(where);
                if(where.getBrother() != null){
                    if (where.getBrother().getLeft() != null){
                        where.getRight().setBrother(where.getBrother().getLeft());
                    }
                }

                if (where.getLeft() == null){
                    where.setLeft(new Node());
                    where.getLeft().setParent(where);
                    where.getLeft().setBrother(where.getRight());
                    where.getRight().setLeftBrother(where.getLeft());
                     if (where.getLeftBrother() != null){
                        if (where.getLeftBrother().getRight() != null){
                            where.getLeftBrother().getRight().setBrother(where.getLeft());
                        }
                        }    
                }
            }
            else {
                if (where.getRight() != null){
                    if (where.getRight().isEmpty()){
                        where.getRight().setData(pessoa);   
                        if (where.getLeftBrother() != null){
                            if (where.getLeftBrother().getRight() != null){
                                where.getLeftBrother().getRight().setBrother(where.getLeft());
                            }
                        }
                    }
                    else {
                        addChildren(where.getRight(),pessoa);   
                    }
                }
            }
        }   
    }
    
    public void addExistentNode(Node where, Node toadd){
       
    }
    
}
