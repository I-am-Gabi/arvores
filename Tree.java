import java.util.Calendar;
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
public class Tree
{
    private int ordem; 
    
    Tree (){
        ordem = 3;
    }
    
    Tree (int ordem){
        this.ordem = ordem;
    }
    
    public void test(){
        Calendar nascimento = Calendar.getInstance();
        nascimento.set(2000,Calendar.AUGUST,20);
        Pessoa Joao = new Pessoa("Joao",nascimento,"555.555.777-12","84 555 800");
        Calendar nascimento2 = Calendar.getInstance();
        nascimento2.set(1995,Calendar.DECEMBER,20);
        Pessoa Mariah = new Pessoa ("Mariah",nascimento2, "888.888.999-14","84 777 900");
        
        Joao.showInfo();
        Mariah.showInfo();
    }
    
}
