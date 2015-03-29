import java.util.Calendar;
import java.util.ArrayList;
/**
 * Write a description of class Tree here.
 * 
 * @author Roberto D.; Gabriela C.; Gustavo A.
 * @version 1.0
 */

/* 
 *  Calendar nascimento = Calendar.getInstance();
 *  nascimento.set(2000,Calendar.AUGUST,20);
 */
    
public class Tree
{
    private Node root;
    
    public Tree(){ 
        root = null;
    } 
    
    public void addNode(Pessoa pessoa) {
        if (root == null) {
            root.setData(pessoa);
            root.setLeft(null);
            root.setRight(null);
        }
        else {
            if (hasNode(pessoa.getCPF())) {
                System.out.print("Essa pessoa já existe");
            }
            else {
                add(root, pessoa);
            }
        }
    }
    
    private void add(Node node, Pessoa pessoa) { 
        if (node.getData().getName().compareTo(pessoa.getName()) < 0) {
            if (node.getLeft() != null) {
                add(node.getLeft(), pessoa);
            }
            else {
                node.setLeft(new Node(pessoa));
                node.getLeft().setParent(node); 
            }
        }
        else {
            if (node.getRight() != null) {
                add(node.getRight(), pessoa);
            }
            else {
                node.setRight(new Node(pessoa));
                node.getRight().setParent(node); 
            } 
        }
    }
    
    public void seach(String name) {
        searchName(root, name, 0);
    }
    
    private void searchName(Node node, String name, int flag) {
        if (node.getData().getName().compareTo(name) == 0) {
            flag = 1;
        }
        else {
            if (node.getData().getName().compareTo(name) < 0) {
                if (node.getLeft() == null) {
                    flag = 2;
                }
                else {
                    node = node.getLeft();
                }
            }
            else {
                if (node.getRight() == null) {
                    flag = 3;
                }
                else {
                    node = node.getRight();
                }
            }
            if (flag < 1) {
                searchName(node, name, flag);
            }
        }
    }
    
    public boolean hasNode(String CPF) {
        return seachCPF(root, CPF);
    }
    
    private boolean seachCPF(Node node, String CPF) {
        if (node != null){
             if (node.getData().getCPF().equals(CPF)) {
                 return true;
             }
             seachCPF(node.getLeft(), CPF);
             seachCPF(node.getRight(), CPF);
        }
        return false;
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
    
    public void searchLargura(Pessoa pessoa) {
        ArrayList<Node> left = new ArrayList<Node>();
        ArrayList<Node> right = new ArrayList<Node>();
        roamPrefix(root.getLeft, left);
        roamPrefix(root.getRight, right); 
        
        boolean flag_encontrou = false;
        
        Iterator<String> itL = Iterators.forArray(left);
        Iterator<String> itR = Iterators.forArray(right);
        
        while(itL.hasNext() || itR.hasNext()) {
            Node n1 = null;
            Node n2 = null;
            if (itL.hasNext()) {
                n1 = itL.next();
            }
            else if (itR.hasNext()) {
                n2 = itR.next();
            }
            if (n1) {
                if (n1.getData().getName().equals(pessoa.getName()) {
                    System.out.print(n1.getData().getName() + " ");
                    flag_encontrou = true;
                    break;
                }
            }
            if (n2) {
                if (n2.getData().getName().equals(pessoa.getName()) {
                    System.out.print(n2.getData().getName() + " ");
                    flag_encontrou = true;
                    break;
                }
            }
        }
        if (!flag_encontrou) {
            System.out.print("Não encontrou registro");
        }
    }
    
    private void roamPrefix(Node node, ArrayList<Node> array){
        if (node != null){
            array.add(node); 
            prefixLeft(node.getLeft());
            prefixLeft(node.getRight());
        }
    }
    
    public void biggerValue(Node node, int size) {
        if (node != null){
            if (node.getData().getName().size() > size) {
                size = node.getData().getName().size();
            }
            prefixLeft(node.getLeft(), size);
            prefixLeft(node.getRight(), size);
        }
    }
}
