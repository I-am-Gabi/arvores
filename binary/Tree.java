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
    
    
    public void remove(Node to){
        /* Verifica se não tem nenhum filho */
        if (to.getLeft() == null && to.getRight() == null){
            if (to.isLeft()){
                if(to.getParent() != null) to.getParent().setLeft(null);
            }
            else {  
                if(to.getParent() != null) to.getParent().setRight(null);
            }
        }
        /* Verifica se só tem um filho esquerdo */
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
        /* Verifica se só tem um filho direito */
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
    
    private void removeLower(Node q){
        Node aux = lowerValue(q);
    }
    
    public Node searchBreadth(String name) { // Busca por largura
        ArrayList<Node> left = new ArrayList<Node>();
        ArrayList<Node> right = new ArrayList<Node>();
        
        if (root != null){
            roamPrefix(root.getLeft(), left); // PODE DAR NULL EXCEPTION SE CHAMAR COM ROOT NULL
            roamPrefix(root.getRight(), right);  
            
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
            System.out.print("Não encontrou registro");
            return null;
    }
    
    /**
     * search - método chamada para pesquisar registro por nome. 
     * 
     * @params name String nome que será usada para a busca
     * @return no Node encontrado pelo nome
     */
    public Node searchDepth(String name) {
        Node no = searchDepth(root, name, 0); 
        return no;
    }
    
    /**
     * searchName - método chamada no search para fazer uma busca por profundidade na árvare, usando o valor do nome
     * 
     * @params node nó atual usadao para a busca
     * @params name String com valor usado como parâmetro para a busca
     * @params flag flag que indica se já foi encontrado ou não o nó com valor buscado
     * 
     * @return node nó com valor buscado
     */
    private Node searchDepth(Node node, String name, int flag) {
        if (node.getData().getName().compareTo(name) == 0) { 
            return node;
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
        return null;
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
    
    public void getDeph(Node node) {
        if (node != null) {
            getDeph(node.getLeft());
            getDeph(node.getRight());
            calcDeph(node);
        }
    }
    
    private void calcDeph(Node node) {
        
        
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
        printPrefix(root);
    }
        
    private void printPrefix(Node node){
        if (node != null){
            System.out.print("| " + node.getData().getName() + " " + node.getData().getCPF() + " ");
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
            System.out.print("| " + node.getData().getName() + " " + node.getData().getCPF() + " ");
        } 
    }
    
    public Node getRoot(){
        return root;
    }
    
    public void CreatePeople(){
        
        Pessoa pessoa1 = new Pessoa("Jo", 1977, 12, 5, "12323456", "4456789");
        Pessoa pessoa6 = new Pessoa("J", 1977, 12, 5, "123456", "456789");
        Pessoa pessoa2 = new Pessoa("Loanerresman", 1950, 7, 7, "123123", "789456");
        Pessoa pessoa3 = new Pessoa("Poplin", 1955, 5, 5, "454545", "789542");
        Pessoa pessoa4 = new Pessoa("Mariah J", 1977, 10, 20, "456789", "123456");
         
        add(pessoa1); add(pessoa2); add(pessoa3); add(pessoa4);add(pessoa6);
    }
    
}
