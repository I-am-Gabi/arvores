
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Classe Tree que representa a árvore em nosso programa
 * 
 * @author Gabriela Cavalcante da Silva 2013022760 , Gustavo Alves Bezerra 2014026460 , Roberto Dantas 2014027940.
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
     * add - método chamado para adicionar um nó na árvore
     * 
     * @params key O valor da chave do nó que será adicionado em na árvore
     * @return Retorna o nó que foi adicionado ou null caso a chave já exista na árvore
     */
    public Node add(int key) {
        if (root == null) {       // caso a raiz ainda esteja vazia
            root = new Node(key);    // inicializa o Node raiz root
            root.setLeft(null);   // seta o nó esquerdo como null
            root.setRight(null);  // seta o nó direito como null
            return root;
        }
        else {
            if (hasNode(key)) { // verifica se já existe um registro com esse CPF
                System.out.print("Já existe um nó com o key informado");
            }
            else {
                return add(root, key); // chama o método add passando a raiz e a pessoa
            }
        }
        return null;
    }
    
     /**
     * add - método que adiciona efetivamente um valor em um determinado nó. Ele verifica pelo valor da chave (key, enviado por parâmetro) se a 
     * instância o novo nó deve ser o filho da esquerda ou a direita do nó.
     * 
     * @params node nó que terá os filhos verificados para um deles ser preenchido
     * @params key valor da chave que será atribuida ao campo key do nó adicionado
     * @return Retorna o nó que foi adicionado
     */
    private Node add(Node node, int key) { 
        if (node.getKey() > key) { // se o nome deve ficar a esquerda
            if (node.getLeft() != null) {
                return add(node.getLeft(), key);
            }
            else {
                node.setLeft(new Node(key));
                node.getLeft().setParent(node); 
                return node.getLeft();
            }
        }
        else {
            if (node.getRight() != null) {
                return add(node.getRight(), key);
            }
            else {
                node.setRight(new Node(key));
                node.getRight().setParent(node); 
                return node.getRight();
            } 
        }
    }
    
    /**
     * remove - método que irá remover um nó da árvore.
     * Três casos podem acontecer.
     * 1) Caso o nó seja uma folha, e não possua sub-árvores
     *  - nesse caso, é só setar como nulo o campo que "aponta" para o nó removido
     * 2) Caso o nó possua apenas uma sub-árvore, a esquerda ou a direita
     *  - nesse caso, o valor que faz referência ao nó removido passa a fazer referência 
     *  a sub-árvore que existia ligado ao este nó
     * 3) Caso o nó possua duas sub-árvores
     *  - nessa situação, pegamos um valor menor, abaixo desse nó que quero remover (no caso, pegarmos um que seja uma folha. 
     *  removemos esse nó folha que estava no final e substituimos o nó que queríamos remover inicialmente, por ele.
     */ 
    public void remove(Node to){
        /* Verifica se não tem nenhum filho */
        if (to != null) { 
            if (to.getLeft() == null && to.getRight() == null){
                if (to.getParent() == null){
                    root = null;
                }
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
                    root = to.getLeft();
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
                    root = to.getRight();
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
 
    /**
     * searchBreadth - buscar um elemento utilizando a estratégia de busca em largura.
     * Inicialmente ele cria dois ArrayLists para armazenar a subárvore a esquerda 
     * e a direita. E então pesquisa o valor 'key' em ambos os arrays.
     * A forma como esses arrays são criados e acessados, faz com que os valores
     * sejam visitados pela técnica da largura
     * 
     * @params key inteiro que armazena o valor da chave a ser pesquisado 
     * @return node nó com o valor que está sendo buscado, caso não encontre retorna null
     */
    public Node searchBreadth(int key) { // Busca por largura
        ArrayList<Node> left = new ArrayList<Node>();
        ArrayList<Node> right = new ArrayList<Node>();
        
        if (root != null){
            roamPrefix(root.getLeft(), left); // PODE DAR NULL EXCEPTION SE CHAMAR COM ROOT NULL
            roamPrefix(root.getRight(), right);  
            
            Iterator<Node> itL = left.iterator();
            Iterator<Node> itR = right.iterator();
            
            //verifica se o root é o objeto procurado
            if (root.getKey() == key){
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
                    if (n1.getKey() == key) { 
                        return n1; 
                    }
                }
                if (n2 != null) {
                    if (n2.getKey() == key) { 
                        return n2; 
                    }
                }
            }
            
        }
        System.out.print("Não encontrou registro");
        return null;
    }
    
    /**
     * searchDepth - buscar um elemento utilizando a estratégia de busca em profundidade
     * 
     * @params key valor da chave do nó que está sendo pesquisada
     * @return node nó com o valor que está sendo buscado. Retornará null caso valor não seja encontrado
     */
    public Node searchDepth(int key) {
        Node no = searchDepth(root, key);  
        return no;
    }
        
    /**
     * searchDepth - buscar um elemento utilizando a estratégia de busca em profundidade
     * 
     * @params node nó que marcará o ponto a partir do qual a busca acontecerá na árvore
     * @params key valor da chave que está sendo pesquisada
     * @return node nó com o valor que está sendo buscado. Retornará null caso valor não seja encontrado
     */
    private Node searchDepth(Node node, int key){
        if (node != null){
            if (node.getKey() == key) {
                return node;
            }
            if (node.getKey() > key) {
                return searchDepth(node.getLeft(),key);
            }
            else {
                return searchDepth(node.getRight(),key);
            }
        }
        return node;
    }
    
    /**
     * hasNode - método chamado quando queremos verificar se há registro com a chave passada por parâmetro
     * 
     * @params key valor da chave que será usado para verificar a existência de um registro semelhante
     * @return True caso tenha encontrado, ou False caso contrário
     */
    private boolean hasNode(int key) {
        return seachKey(root, key);
    }
    
    private boolean seachKey(Node node, int key) {
        if (node != null){
             if (node.getKey() == key) {
                 return true;
             }
             seachKey(node.getLeft(), key);
             seachKey(node.getRight(), key);
        }
        return false;
    }
                      
    /**
     * calcHeight - método que calcula a altura de um determinado nó da árvore
     * 
     * @params node nó que terá a altura calculada
     * @return a    caso o valor da altura da subarvore a esquerda seja maior que a da direita
     * @return b    caso o valor da altura da subarvore a direita seja maior que a da esquerda
     */
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
    
    /**
     * calcDepht - método que calcula e retorna a profundidade de um nó
     * 
     * @params node nó que terá o valor da profundidade calculado
     * @return depth profundidade do nó passado como argumento
     */    
    public int calcDepht(Node node) {
        int depth = 0;
        if (node != null) {
            while(node.getParent() != null){
                node = node.getParent();
                depth++;
            }
        }
        return depth;
    }
   
    /**
     * Salva os valores de uma subárvore num Array em ordem prefixa
     * 
     * @param node nó raiz da subárvore
     * @param array array no qual os valores da subárvore ficarão organizados em ordem prefixa.
     */
    private void roamPrefix(Node node, ArrayList<Node> array){
        if (node != null){
            array.add(node); 
            roamPrefix(node.getLeft(), array);
            roamPrefix(node.getRight(), array);
        }
    }
         
    /**
     * lowerValue - método chamado para retornar o menor valor da árvore.
     * O menor valor será o do nó mais a esquerda.
     * 
     * @return node nó com menor valor da árvore
     */
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
        
    /**
     * greaterValue - método chamado para retornar o maior valor da árvore.
     * No nosso caso, o maior valor será a informação que estiver no nó mais a direita.
     * 
     * @return node nós com maior valor da árvore
     */
    public Node greaterValue(){
        Node node = root;
        if (root != null){
            node = greaterValue(root);
        }
        return node;
    }
    
    /**
     *  greaterValue - método que retorna o nó com "maior" valor da árvore
     *  No nosso caso, o maior valor será a informação que estiver no nó mais a direita.
     *  
     *  @params node nó que marcará o início da busca pelo maior valor na árvore
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
    
    /**
     * printPrefix - método chamado para imprimir os valores da árvore 
     * seguindo um caminhamento prefixado
     */
    public void printPrefix(){
        System.out.println();
        System.out.println("---------------------PREFIX--------------------");
        System.out.println("-----------------------------------------------");
        printPrefix(root);
    }
        
    /**
     * printPrefix - método que imprimirá efetivamente os elementos da árvore 
     * seguindo um caminhamento prefixado
     * 
     * @params node nó que marcará o início da impressão da árvore
     */
    private void printPrefix(Node node){
        if (node != null){
            System.out.println("" + node.getKey());
            System.out.println("-----------------------------------------------");
            printPrefix(node.getLeft());
            printPrefix(node.getRight());
        }
    } 
    
    /**
     * printPosfix - método chamado para imprimir os elementos da árvore 
     * seguindo um caminhamento pós-fixado
     */
    public void printPosfix(){
        System.out.println();
        System.out.println("---------------------POSFIX--------------------");
        System.out.println("-----------------------------------------------");
        printPosfix(root);
    }        
    
    /**
     * printPosfix - método que efetivamente vai imprimir os elementos da árvore 
     * seguindo um caminhamento pós-fixado
     * 
     * @params node nó que marca o início da impressão dos nós da árvore
     */
    private void printPosfix(Node node){
        if (node != null){
            printPosfix(node.getLeft());
            printPosfix(node.getRight());
            System.out.println("" + node.getKey());
            System.out.println("-----------------------------------------------");
        } 
    }
    
    /**
     * getRoot() - Método que retorna o nó raiz da árvore
     * 
     * @return root nó raiz da arvore 
     */
    public Node getRoot(){
        return root;
    }
    
}
