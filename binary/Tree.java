import java.util.Calendar;
import java.util.ArrayList;
import java.util.Iterator;
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
    
    /**
     * Construtor que inicializar a raiz como nula
     */
    public Tree(){ 
        root = null;
    } 
    
    /**
     * addNode - método chamado para adicionar um nó na árvore
     * 
     * @params pessoa O objeto pessoa que seja adicionado em um nó da árvore
     */
    public void add(Pessoa pessoa) {
        if (root == null) { // caso a raiz ainda esteja vazia
            root = new Node();    // inicializa o Node raiz root
            root.setData(pessoa); // adiciona o parametro pessoa na raiz
            root.setLeft(null);   // seta o nó esquerdo como null
            root.setRight(null);  // seta o nó direito como null
        }
        else {
            if (hasNode(pessoa.getCPF())) { // verifica se já existe um registro com esse CPF
                System.out.print("Essa pessoa já existe");
            }
            else {
                add(root, pessoa); // chama o método add passando a raiz e a pessoa
            }
        }
    }
    
     /**
     * add - método que adiciona efetivamente um valor em um determinado nó. Ele verifica pelo valor o nome se a 
     * instância passada de Pessoa deve ficar a esquerda ou a direita do nó.
     * 
     * @params node nó que terá os filhos verificados para um deles ser preenchido
     * @params pessoa instância que será atribuida ao campo Data do nó adicionado
     */
    private void add(Node node, Pessoa pessoa) { 
        if (pessoa.getName().compareTo(node.getData().getName()) < 0) { // se o nome deve ficar a esquerda
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
    
    public Node searchBreadth(String name) { // Busca por largura
        ArrayList<Node> left = new ArrayList<Node>();
        ArrayList<Node> right = new ArrayList<Node>();
        roamPrefix(root.getLeft(), left);
        roamPrefix(root.getRight(), right); 
        
        boolean flag_encontrou = false;
         
        Iterator<Node> itL = left.iterator();
        Iterator<Node> itR = right.iterator();
        
        //verifica se o root é o objeto procurado
        if (root.getData().getName().equals(name)){
            return root;
        }
        
        //caso não, entra no while.
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
                    flag_encontrou = true;
                    return n1;
                    //System.out.print(n1.getData().getName() + " ");
                    //break;
                }
            }
            if (n2 != null) {
                if (n2.getData().getName().equals(name)) {
                    flag_encontrou = true;
                    return n2;
                    //System.out.print(n2.getData().getName() + " ");
                    //break;
                }
            }
        }
        if (!flag_encontrou) {
            System.out.print("Não encontrou registro");
        }
        return null;
    }
    
    /**
     * search - método chamada para pesquisar registro por nome. 
     * 
     * @params name String nome que será usada para a busca
     */
    public void searchDepth(String name) {
        searchDepth(root, name, 0);
        // INSERIR RETORNO DE NODE
    }
    
    /**
     * searchName - método chamada no search para fazer uma busca por profundidade na árvare, usando o valor do nome
     * 
     * @params node nó atual usadao para a busca
     * @params name String com valor usado como parâmetro para a busca
     * @params flag flag que indica se já foi encontrado ou não o nó com valor buscado
     */
    private void searchDepth(Node node, String name, int flag) {
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
                searchDepth(node, name, flag);
            }
        }
    }
    
    /**
     * hasNode - método chamado quando queremos verificar se há registro com o CPF passado por parâmetro
     * 
     * @params CPF valor do CPF que será usado para verificar a existência de um registro semelhante
     * @return True caso tenha encontrado, ou False caso contrário
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
                        
    public void getHeight(Node node) {
        if (node != null) {
            getHeight(node.getLeft());
            getHeight(node.getRight());
            calcHeight(node);
        }
    }
    
    private void calcHeight(Node node) {
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
      
    private void roamPrefix(Node node, ArrayList<Node> array){
        if (node != null){
            array.add(node); 
            roamPrefix(node.getLeft(), array);
            roamPrefix(node.getRight(), array);
        }
    }
            
    public int lowerValue(){
        int value = -1;    
        if (root != null) {
            value = lowerValue(root,root.getData().getName().length());
            if (value == -1){
                return root.getData().getName().length();
            }
        }
        return value; 
    }
    
    private int lowerValue(Node node, int size) {
        if (node != null){
            if (node.getData().getName().length() < size) {
                size = node.getData().getName().length();
            } 
            lowerValue(node.getLeft(), size);
            lowerValue(node.getRight(), size);
        }
        return size;
    }
         
    public int greaterValue(){
        int value = -1;  
        if (root != null) {
                value = greaterValue(root,root.getData().getName().length());
                if (value == -1){
                    return root.getData().getName().length();
                }
        }
        return value; 
    }
    
    private int greaterValue(Node node, int size) {
        if (node != null){
            if (node.getData().getName().length() > size) {
                size = node.getData().getName().length();
            } 
            greaterValue(node.getLeft(), size);
            greaterValue(node.getRight(), size);
        }
        return size;
    }    
    
    public void printPrefix(){
        System.out.println();
        printPrefix(root);
    }
        
    private void printPrefix(Node node){
        if (node != null){
            System.out.print(" " + node.getData().getCPF() + " ");
            printPrefix(node.getLeft());
            printPrefix(node.getRight());
        }
    }
    
    public void printPosfix(){
        System.out.println();
        printPosfix(root);
    }        
    
    private void printPosfix(Node node){
        if (node != null){
            printPosfix(node.getLeft());
            printPosfix(node.getRight());
            System.out.print(" " + node.getData().getCPF() + " ");
        }
    }
    
    
}
