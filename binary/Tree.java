import java.util.Calendar;
import java.util.ArrayList;
/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/* 
 *  Calendar nascimento = Calendar.getInstance();
 *  nascimento.set(2000,Calendar.AUGUST,20);
 */
    
public class Tree
{
    private Node root;
    
    public Tree(){
        Pessoa pessoa = new Pessoa();
        root = new Node(pessoa);
    }
        
    public void add(Pessoa pessoa){
        root.addNode(root, pessoa);
    }

    public void add(Node toadd){
        root.addExistentNode(root,toadd);
    }
    
    public void remove(Node toremove){
        Node left = toremove.getLeft();
        Node right = toremove.getRight();
        Node parent = toremove.getParent();
        
        if (parent.getLeft() == toremove){
            parent.setLeft(null);
        }
        else {
            parent.setRight(null);
        }
        
        parent.addExistentNode(parent, left);
        parent.addExistentNode(parent, right);
        
    }
    
    public void createPeople(){
        Pessoa p1 = new Pessoa("13");
        Pessoa p2 = new Pessoa("7");
        Pessoa p3 = new Pessoa("16");
        Pessoa p4 = new Pessoa("6");
        
        add(p1);
        add(p2);
        add(p3);
        add(p4);
    }
    
    private void printPrefix(Node node){
        if (node != null){
            System.out.print(" " + node.getData().getCPF() + " ");
            printPrefix(node.getLeft());
            printPrefix(node.getRight());
        }
    }
    
    private void printPosfix(Node node){
        if (node != null){
            printPosfix(node.getLeft());
            printPosfix(node.getRight());
            System.out.print(" " + node.getData().getCPF() + " ");
        }
    }
    
    private void printOrdered(Node node){
        if (node != null){
            printOrdered(node.getLeft());
            System.out.print(" " + node.getData().getCPF() + " ");
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
    
    public void getHeight(Node node) {
        if (node != null) {
            getHeight(node.getLeft());
            getHeight(node.getRight());
            calcHeight(node);
        }
    }
    
    public void calcHeight(Node node) {
        int alt1, alt2 = 0;
        if (node.getLeft() == null) {
            alt1 = 0;
        }
        else {
            alt1 = node.getLeft().getHeight();
        }
        if (node.getRight() == null) {
            alt2 = 0;
        }
        else {
            alt2 = node.getRight().getHeight();
        }
        if (alt1 > alt2) {
            node.setHeight(alt1 + 1);
        }
        else {
            node.setHeight(alt2 + 1);
        }
    }
}
