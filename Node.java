import java.util.ArrayList;

/**
 * Write a description of class Node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Node {
    private Node parent;
    private Pessoa data;
    private ArrayList<Node> childrens;
    private static int degree; /* número máximo de filhos */
    private Node brother;
    
    public Node(int degree,int value){
        parent = null;
        brother = null;
        data = null;
        childrens = new ArrayList<Node>();
        this.degree = degree;
    }    
    
    /**
     * Construtor padrão
     * @param Pessoa que será atribuída a este nó.
     */    
    public Node(Pessoa person,int value){
        parent = null;
        this.data = person;
        childrens = new ArrayList<Node>();
    }
        
    /**
     * @param Node parent : Define o nó que é pai deste atual
     */
    public void setParent(Node parent){
        this.parent = parent;
    }
    
    /**
     * @param Pessoa person : Atribui uma pessoa a este nó
     */
    public void setData(Pessoa person){
        this.data = person;
    }
    
    public void setDegree(int degree){
        this.degree = degree;
    }
    
    public void setBrother(Node brother){
        this.brother = brother;
    }
    
    public Node getBrother(){
        return this.brother;
    }
    
    public int getDegree(){
        return degree;
    }
    
    /**
     * @return Pessoa : retorna a pessoa atribuida a este nó
     */
    public Pessoa getData(){
        return this.data;
    }
    
    public boolean addChildren(Node children){       
        if (this.childrens.size() < degree){
           this.childrens.add(children);
           children.setParent(this);
           return true;
       }
       else {
           ArrayList<Node> childList = this.childrens;
           for (Node each : childList){
              childList = each.getChildrens();    
               if (childList.size() < degree){
                    if (childList.size() > 0){
                        children.setBrother(childList.get(childList.size()-1));
                    }
                    childList.add(children);
                    children.setParent(each);
                    return true;
                }
            }
        }
        return false;        
    }
        
    public ArrayList<Node> getChildrens(){
        return this.childrens;
    }
    
    
    /**
     * Fiz essa função de busca acredito que fiz busca por profundidade, 
     * pq ele verifica se nó atual é a pessoa procurada, se não for, passa para o filho e isso
     * se repete para todos os filhos do root.
     */
    public Node search(Pessoa pessoa){
        Node node;
        if (this.data == pessoa){
            return this;
        }
        else {
            for(Node each : childrens){
                node = each.search(pessoa);
                if (node != null) return node;
            }
        }
        return null;    
    }
    
    public Node searchLargura(Pessoa pessoa){
        if (this.getData() == pessoa){
            return this;
        }
        else {
            ArrayList<Node> childs = childrens;
            Node tobrother;
            for (Node each : childs){
                if (each.getData() == pessoa){
                        return each;
                }
                tobrother = each.getBrother();                
                while(tobrother != null){
                    if (each.getData() == pessoa){
                        return each;
                    } 
                    tobrother = each.getBrother();
                }
                
 
            }
            
        }
        return null;
    }
    
    /**
     * @return true : Se é raiz
     * false: se não é raiz
     */
    public boolean isRoot(){
        if (parent == null){ return true;}
        return false;
    }
        
}
