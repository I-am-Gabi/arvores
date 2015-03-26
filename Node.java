import java.util.ArrayList;

/**
 * Write a description of class Node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Node {
    private Node parent;
    private Pessoa person;
    private ArrayList<Node> childrens;
    private static int degree; /* número máximo de filhos */
    
    /**
     * Construtor padrão
     * @param Pessoa que será atribuída a este nó.
     */    
    public Node(Pessoa person){
        parent = null;
        this.person = person;
        childrens = new ArrayList<Node>();
    }
    
    public Node(int degree){
        parent = null;
        person = null;
        childrens = new ArrayList<Node>();
        this.degree = degree;
    }    
    
    /**
     * Construtor padrão
     * @param Pessoa que será atribuída a este nó.
     */    
    public Node(Pessoa person,int degree){
        parent = null;
        this.person = person;
        this.degree = degree;
        childrens = new ArrayList<Node>();
    }
    
    /**
     * Sobrecarga de construtor.
     * @param Pessoa que será atribuída a este nó. Node - parent que será o pai deste nó.
     * 
     */
    public Node(Pessoa person, Node parent, int degree){
        this.parent = parent;
        this.person = person;
        this.degree = degree;
        childrens = new ArrayList<Node>();
    }
    
    /**
     * @param Node parent : Define o nó que é pai deste atual
     */
    public void setParent(Node parent){
        this.parent = parent;
        parent.addChildren(this);
    }
    
    /**
     * @param Pessoa person : Atribui uma pessoa a este nó
     */
    public void setPerson(Pessoa person){
        this.person = person;
    }
    
    public void setDegree(int degree){
        this.degree = degree;
    }
    
    /**
     * @return Pessoa : retorna a pessoa atribuida a este nó
     */
    public Pessoa getPerson(){
        return this.person;
    }
    
    public boolean addChildren(Node children){
        if (childrens.size() < degree){
            childrens.add(children);
            return true;
        }
        return false;
    }
    
    public ArrayList<Node> getChildrens(){
        return this.childrens;
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
