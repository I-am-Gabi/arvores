/**
 * Write a description of class Node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Node {
    private Pessoa data;
    private Node left;
    private Node right;
    private Node parent;
    private Node brother;
    
    public Node (){
        this.data = null;
        this.left = null;
        this.right = null;
        this.brother = null;
    }
    
    public Node (Pessoa pessoa){
        this.data = pessoa;
        this.left = null;
        this.right = null;
        this.brother = null;
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
    
    public void setParent(Node parent){
        this.parent = parent;
    }
    
    public void addNode(Node where, Pessoa pessoa){
        int pessoaCPF = Integer.parseInt(pessoa.getCPF());
        int dataCPF = Integer.parseInt(where.getData().getCPF());        
        if( pessoaCPF < dataCPF ){
            if(where.getLeft() != null){
                addNode(where.getLeft(),pessoa);
            }
            else{
                where.setLeft(new Node(pessoa));
                where.getLeft().setParent(where);
                if (where.getRight() != null){
                    where.getLeft().setBrother(where.getRight());
                }
            }
        }
        else if(pessoaCPF > dataCPF){
            if (where.getRight() != null){
                addNode(where.getRight(),pessoa);
            }
            else {
                where.setRight(new Node(pessoa));
                where.getRight().setParent(where);
                if (where.getLeft() != null){
                    where.getLeft().setBrother(where.getRight());
                }
                if (where.getBrother() != null){
                    if (where.getBrother() != null && where.getBrother().getLeft() != null){
                        where.getRight().setBrother(where.getBrother().getLeft());
                    }
                    
                }
            }
        }
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
                    if (where.getRight() != null){
                        where.getLeft().setBrother(right);
                    }
                }
            }
            else if(pessoaCPF > dataCPF){
                if (where.getRight() != null){
                    addExistentNode(where.getRight(),toadd);
                }
                else {
                    where.setRight(toadd);
                    where.getRight().setParent(where);
                    if (where.getLeft() != null){
                        where.getLeft().setBrother(right);
                    }
                    if (where.getParent() != null && where.getParent().getBrother() != null){
                        if (where.getParent().getBrother().getLeft() != null){
                            where.getRight().setBrother(where.getParent().getBrother().getLeft());
                        }
                    }
                }
            }
        }
    }
    
}
