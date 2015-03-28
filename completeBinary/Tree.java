import java.util.Calendar;
import java.util.ArrayList;
/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


/* 
 * Calendar nascimento = Calendar.getInstance();
 *  nascimento.set(2000,Calendar.AUGUST,20);
 */
    
public class Tree
{
    private Node root;
    
    public Tree(){
        Pessoa pessoa = new Pessoa("10");
        root = new Node(pessoa);
    }
        
    public void addNode(Pessoa pessoa){
        root.addChildren(root,pessoa);
    }
    
    public void removeNode(Node toremove){
        
    }
    
    public void createPeople(){
        Pessoa p1 = new Pessoa("13");
        Pessoa p2 = new Pessoa("7");
        Pessoa p3 = new Pessoa("16");
        Pessoa p4 = new Pessoa("6");
        
        addNode(p1);
        addNode(p2);
        addNode(p3);
        addNode(p4);
    }
    
    private void printPrefix(Node node){
        if (node != null){
            if (node.getData != null){
            System.out.print(" " + node.getData().getCPF() + " ");
            }
            printPrefix(node.getLeft());
            printPrefix(node.getRight());
        }
    }
    
    private void printPosfix(Node node){
        if (node != null){
            printPosfix(node.getLeft());
            printPosfix(node.getRight());
            if (node.getData != null){
            System.out.print(" " + node.getData().getCPF() + " ");
            }
        }
    }
    
    private void printOrdered(Node node){
        if (node != null){
            printOrdered(node.getLeft());
            if (node.getData != null){
            System.out.print(" " + node.getData().getCPF() + " ");
            }
            printOrdered(node.getRight());
        }
    }
    
    public void printTreeOrdered(){
        System.out.println();
        printOrdered(root);
    }
    
    public void printTreePrefix(){
        System.out.println();
        printPrefix(root);
    }
    
    public void printTreePosfix(){
        System.out.println();
        printPosfix(root);
    }
    
}
