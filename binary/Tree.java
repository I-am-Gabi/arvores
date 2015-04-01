import java.util.Calendar;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class Tree here.
 * 
 * @author Gabriela Cavalcante da Silva, Roberto Dantas.
 * @version 1.0
 */

public class Tree
{
    private Node root;
    
    /**
     * Construtor que inicializar a raiz como nula
     */
    public Tree(){ 
        root = null;
    } 
    
    /**
     * addNode - m�todo chamado para adicionar um n� na �rvore
     * 
     * @params pessoa O objeto pessoa que seja adicionado em um n� da �rvore
     */
    public Node add(Pessoa pessoa) {
        if (root == null) { // caso a raiz ainda esteja vazia
            root = new Node();    // inicializa o Node raiz root
            root.setData(pessoa); // adiciona o parametro pessoa na raiz
            root.setLeft(null);   // seta o n� esquerdo como null
            root.setRight(null);  // seta o n� direito como null
            return root;
        }
        else {
            if (hasNode(pessoa.getCPF())) { // verifica se j� existe um registro com esse CPF
                System.out.print("Essa pessoa j� existe");
            }
            else {
                return add(root, pessoa); // chama o m�todo add passando a raiz e a pessoa
            }
        }
        return null;
    }
    
     /**
     * add - m�todo que adiciona efetivamente um valor em um determinado n�. Ele verifica pelo valor o nome se a 
     * inst�ncia passada de Pessoa deve ficar a esquerda ou a direita do n�.
     * 
     * @params node n� que ter� os filhos verificados para um deles ser preenchido
     * @params pessoa inst�ncia que ser� atribuida ao campo Data do n� adicionado
     */
    private Node add(Node node, Pessoa pessoa) { 
        if (pessoa.getName().compareTo(node.getData().getName()) < 0) { // se o nome deve ficar a esquerda
            if (node.getLeft() != null) {
                return add(node.getLeft(), pessoa);
            }
            else {
                node.setLeft(new Node(pessoa));
                node.getLeft().setParent(node); 
                return node.getLeft();
            }
        }
        else {
            if (node.getRight() != null) {
                return add(node.getRight(), pessoa);
            }
            else {
                node.setRight(new Node(pessoa));
                node.getRight().setParent(node); 
                return node.getRight();
            } 
        }
    }
    
    
    public void remove(Node to){
        /* Verifica se n�o tem nenhum filho */
        if (to != null) { 
            if (to.getLeft() == null && to.getRight() == null){
                if (to.isLeft()){
                    if(to.getParent() != null) to.getParent().setLeft(null);
                }
                else {  
                    if(to.getParent() != null) to.getParent().setRight(null);
                }
            }
            /* Verifica se s� tem um filho esquerdo */
            if (to.getLeft() != null && to.getRight() == null){
                to.getLeft().setParent(to.getParent());
                if (to.isRoot()){
                    root = to;
                }
                else {
                    if (to.isLeft()){
                        to.getParent().setLeft(to.getLeft());
                    }
                    else {
                        to.getParent().setRight(to.getLeft());
                    }
                }
            }
            /* Verifica se s� tem um filho direito */
            if (to.getRight() != null && to.getLeft() == null){
                to.getRight().setParent(to.getParent());
                if (to.isRoot()){
                    root = to;
                }
                else {
                    if (to.isLeft()){
                        to.getParent().setLeft(to.getLeft());
                    }
                    else {
                        to.getParent().setRight(to.getLeft());
                    }
                }
            }
            /* Verifica se tem dois filhos */
            else if (to.getLeft() != null && to.getRight() != null){
                Node minValue = lowerValue(to);
                
                if (minValue != null){
                    if (minValue.isLeft()){
                        minValue.getParent().setLeft(null);
                    }
                    else {
                        minValue.getParent().setRight(null);
                    }
                }
    
                if (to.isRoot()){
                    minValue.setLeft(to.getLeft());
                    minValue.setRight(to.getRight());
                    if (minValue.getLeft() != null){
                        minValue.getLeft().setParent(minValue);                    
                    }
                    if (minValue.getRight() != null){
                        minValue.getRight().setParent(minValue);                    
                    }
                    minValue.setParent(null);
                    root = minValue;
                }
                else {
                    to.getLeft().setParent(minValue);
                    to.getRight().setParent(minValue);
                    minValue.setLeft(to.getLeft());
                    minValue.setRight(to.getRight());
                    if(to.isLeft()){
                        to.getParent().setLeft(minValue);
                    }
                        else {
                        to.getParent().setRight(minValue);
                    }
                } 
            }
        }
    } 
 
    public Node searchBreadth(String name) { // Busca por largura
        ArrayList<Node> left = new ArrayList<Node>();
        ArrayList<Node> right = new ArrayList<Node>();
        
        if (root != null){
            roamPrefix(root.getLeft(), left); // PODE DAR NULL EXCEPTION SE CHAMAR COM ROOT NULL
            roamPrefix(root.getRight(), right);  
            
            Iterator<Node> itL = left.iterator();
            Iterator<Node> itR = right.iterator();
            
            //verifica se o root � o objeto procurado
            if (root.getData().getName().equals(name)){
                return root;
            }
            
            //caso n�o, entra no while.
            while(itL.hasNext() || itR.hasNext()) {
                Node n1 = null;
                Node n2 = null;
                if (itL.hasNext()) {
                    n1 = itL.next();
                }
                else if (itR.hasNext()) {
                    n2 = itR.next();
                }
                if (n1 != null) {
                    if (n1.getData().getName().equals(name)) { 
                        return n1; 
                    }
                }
                if (n2 != null) {
                    if (n2.getData().getName().equals(name)) { 
                        return n2; 
                    }
                }
            }
            
        }
        System.out.print("N�o encontrou registro");
        return null;
    }
    
    /**
     * search - m�todo chamada para pesquisar registro por nome. 
     * 
     * @params name String nome que ser� usada para a busca
     * @return no Node encontrado pelo nome
     */
    public Node searchDepth(String name) {
        Node no = searchDepth(root, name);  
        return no;
    }
        
    public Node searchDepth(Node node, String name){
        if (node != null){
            if (node.getData().getName().compareTo(name) == 0){
                return node;
            }
            if (node.getData().getName().compareTo(name) > 0){
                return searchDepth(node.getLeft(),name);
            }
            else {
                return searchDepth(node.getRight(),name);
            }
        }
        return node;
    }
    
    /**
     * hasNode - m�todo chamado quando queremos verificar se h� registro com o CPF passado por par�metro
     * 
     * @params CPF valor do CPF que ser� usado para verificar a exist�ncia de um registro semelhante
     * @return True caso tenha encontrado, ou False caso contr�rio
     */
    private boolean hasNode(String CPF) {
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
                        
    public int calcHeight(Node node) {
        int a = 0, b = 0;
        if (node == null) {
            return 0;
        }
        else {
            a = calcHeight(node.getLeft()) + 1;
            b = calcHeight(node.getRight()) + 1;
        }
        if (a > b) 
            return a;
        else 
            return b;
    }
    
    public int calcDepht(Node node) {
        int depth = 0;
        while(node.getParent() != null){
            node = node.getParent();
            depth++;
        }
        return depth;
    }
   
    private void roamPrefix(Node node, ArrayList<Node> array){
        if (node != null){
            array.add(node); 
            roamPrefix(node.getLeft(), array);
            roamPrefix(node.getRight(), array);
        }
    }
            
    public Node lowerValue(){   
        Node node = root;
        if (root != null) {
            node = lowerValue(root);
        }
        return node; 
    }
  
    private Node lowerValue(Node node) {
        if (node != null){
            if (node.getLeft() == null){
                return node;
            }
            else {           
                return lowerValue(node.getLeft());
            }            
        }
        return null;
    } 
        
    public Node greaterValue(){
        Node node = root;
        if (root != null){
            node = greaterValue(root);
        }
        return node;
    }
    
    /**
     *  
     */
    private Node greaterValue(Node node) {
        if (node != null){
            if (node.getRight() == null){
                return node;
            }
            else {
                return greaterValue(node.getRight());
            }
        }
        return null;
    } 
    
    public void printPrefix(){
        System.out.println();
        System.out.println("---------------------PREFIX--------------------");
        System.out.println("-----------------------------------------------");
        printPrefix(root);
    }
        
    private void printPrefix(Node node){
        if (node != null){
            System.out.println("> NOME: " + node.getData().getName() + " " + node.getData().getCPF() + " ");
            System.out.println("> CPF: " + node.getData().getCPF() + " ");
            System.out.println("-----------------------------------------------");
            printPrefix(node.getLeft());
            printPrefix(node.getRight());
        }
    } 
    
    public void printPosfix(){
        System.out.println();
        System.out.println("---------------------POSFIX--------------------");
        System.out.println("-----------------------------------------------");
        printPosfix(root);
    }        
    
    private void printPosfix(Node node){
        if (node != null){
            printPosfix(node.getLeft());
            printPosfix(node.getRight());
            System.out.println("> NOME: " + node.getData().getName() + " " + node.getData().getCPF() + " ");
            System.out.println("> CPF: " + node.getData().getCPF() + " ");
            System.out.println("-----------------------------------------------");
        } 
    }
    
    /**
     * getRoot() - M�todo que retorna o n� raiz da �rvore
     * @return root raiz da arvore 
     */
    public Node getRoot(){
        return root;
    }
    
}
