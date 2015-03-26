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
    
    public Tree (int degree){
        root = new Node(degree,0);
    }
    
    public void add(Pessoa pessoa){
        Node node = new Node(pessoa,0);
        root.addChildren(node);
    }
    
    /**
     * Fiz essa função de busca acredito que fiz busca por profundidade, 
     * pq ele verifica se nó atual é a pessoa procurada, se não for, passa para o filho e isso
     * se repete para todos os filhos do root.
     */
    public Node buscaProfundidade(Pessoa pessoa){
        return root.search(pessoa);
    }
        
}
