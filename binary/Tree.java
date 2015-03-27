import java.util.Calendar;
import java.util.ArrayList;
/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/*
-Child: A child node is a node extending from another node. 
-Degree: the degree of a node is the number of children of the node.
-Depth: the depth of node A is the length of the path from A to the root node.
The root node is said to have depth 0.
-Edge: the connection between nodes.
-Forest: a set of trees.
-Height: the height of node A is the length of the longest path through children to a leaf node.
-Internal node: a node with at least one child.
-Leaf node: a node with no children.
-Root node: a node distinguished from the rest of the tree nodes. Usually, it is depicted as the highest node of the tree.
-Sibling nodes: these are nodes connected to the same parent node.
 
 * 
 * 
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

    public void addNode(Node toadd){
        root.addExistentNode(root,toadd);
    }
    
    public void removeNode(Node toremove){
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
        Pessoa p1 = new Pessoa("11");
        Pessoa p2 = new Pessoa("9");
        Pessoa p3 = new Pessoa("12");
        Pessoa p4 = new Pessoa("8");
        
        addNode(p1);
        addNode(p2);
        addNode(p3);
        addNode(p4);
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
    
}
