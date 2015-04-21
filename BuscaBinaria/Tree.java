
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Classe Tree que representa a �rvore em nosso programa
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
     * add - m�todo chamado para adicionar um n� na �rvore
     * 
     * @params key O valor da chave do n� que ser� adicionado em na �rvore
     * @return Retorna o n� que foi adicionado ou null caso a chave j� exista na �rvore
     */
    public Node add(int key) {
        if (root == null) {       // caso a raiz ainda esteja vazia
            root = new Node(key);    // inicializa o Node raiz root
            root.setLeft(null);   // seta o n� esquerdo como null
            root.setRight(null);  // seta o n� direito como null
            return root;
        }
        else {
            if (hasNode(key)) { // verifica se j� existe um registro com esse CPF
                System.out.print("J� existe um n� com o key informado");
            }
            else {
                return add(root, key); // chama o m�todo add passando a raiz e a pessoa
            }
        }
        return null;
    }
    
     /**
     * add - m�todo que adiciona efetivamente um valor em um determinado n�. Ele verifica pelo valor da chave (key, enviado por par�metro) se a 
     * inst�ncia o novo n� deve ser o filho da esquerda ou a direita do n�.
     * 
     * @params node n� que ter� os filhos verificados para um deles ser preenchido
     * @params key valor da chave que ser� atribuida ao campo key do n� adicionado
     * @return Retorna o n� que foi adicionado
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
     * remove - m�todo que ir� remover um n� da �rvore.
     * Tr�s casos podem acontecer.
     * 1) Caso o n� seja uma folha, e n�o possua sub-�rvores
     *  - nesse caso, � s� setar como nulo o campo que "aponta" para o n� removido
     * 2) Caso o n� possua apenas uma sub-�rvore, a esquerda ou a direita
     *  - nesse caso, o valor que faz refer�ncia ao n� removido passa a fazer refer�ncia 
     *  a sub-�rvore que existia ligado ao este n�
     * 3) Caso o n� possua duas sub-�rvores
     *  - nessa situa��o, pegamos um valor menor, abaixo desse n� que quero remover (no caso, pegarmos um que seja uma folha. 
     *  removemos esse n� folha que estava no final e substituimos o n� que quer�amos remover inicialmente, por ele.
     */ 
    public void remove(Node to){
        /* Verifica se n�o tem nenhum filho */
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
            /* Verifica se s� tem um filho esquerdo */
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
            /* Verifica se s� tem um filho direito */
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
     * searchBreadth - buscar um elemento utilizando a estrat�gia de busca em largura.
     * Inicialmente ele cria dois ArrayLists para armazenar a sub�rvore a esquerda 
     * e a direita. E ent�o pesquisa o valor 'key' em ambos os arrays.
     * A forma como esses arrays s�o criados e acessados, faz com que os valores
     * sejam visitados pela t�cnica da largura
     * 
     * @params key inteiro que armazena o valor da chave a ser pesquisado 
     * @return node n� com o valor que est� sendo buscado, caso n�o encontre retorna null
     */
    public Node searchBreadth(int key) { // Busca por largura
        ArrayList<Node> left = new ArrayList<Node>();
        ArrayList<Node> right = new ArrayList<Node>();
        
        if (root != null){
            roamPrefix(root.getLeft(), left); // PODE DAR NULL EXCEPTION SE CHAMAR COM ROOT NULL
            roamPrefix(root.getRight(), right);  
            
            Iterator<Node> itL = left.iterator();
            Iterator<Node> itR = right.iterator();
            
            //verifica se o root � o objeto procurado
            if (root.getKey() == key){
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
        System.out.print("N�o encontrou registro");
        return null;
    }
    
    /**
     * searchDepth - buscar um elemento utilizando a estrat�gia de busca em profundidade
     * 
     * @params key valor da chave do n� que est� sendo pesquisada
     * @return node n� com o valor que est� sendo buscado. Retornar� null caso valor n�o seja encontrado
     */
    public Node searchDepth(int key) {
        Node no = searchDepth(root, key);  
        return no;
    }
        
    /**
     * searchDepth - buscar um elemento utilizando a estrat�gia de busca em profundidade
     * 
     * @params node n� que marcar� o ponto a partir do qual a busca acontecer� na �rvore
     * @params key valor da chave que est� sendo pesquisada
     * @return node n� com o valor que est� sendo buscado. Retornar� null caso valor n�o seja encontrado
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
     * hasNode - m�todo chamado quando queremos verificar se h� registro com a chave passada por par�metro
     * 
     * @params key valor da chave que ser� usado para verificar a exist�ncia de um registro semelhante
     * @return True caso tenha encontrado, ou False caso contr�rio
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
     * calcHeight - m�todo que calcula a altura de um determinado n� da �rvore
     * 
     * @params node n� que ter� a altura calculada
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
     * calcDepht - m�todo que calcula e retorna a profundidade de um n�
     * 
     * @params node n� que ter� o valor da profundidade calculado
     * @return depth profundidade do n� passado como argumento
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
     * Salva os valores de uma sub�rvore num Array em ordem prefixa
     * 
     * @param node n� raiz da sub�rvore
     * @param array array no qual os valores da sub�rvore ficar�o organizados em ordem prefixa.
     */
    private void roamPrefix(Node node, ArrayList<Node> array){
        if (node != null){
            array.add(node); 
            roamPrefix(node.getLeft(), array);
            roamPrefix(node.getRight(), array);
        }
    }
         
    /**
     * lowerValue - m�todo chamado para retornar o menor valor da �rvore.
     * O menor valor ser� o do n� mais a esquerda.
     * 
     * @return node n� com menor valor da �rvore
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
     * greaterValue - m�todo chamado para retornar o maior valor da �rvore.
     * No nosso caso, o maior valor ser� a informa��o que estiver no n� mais a direita.
     * 
     * @return node n�s com maior valor da �rvore
     */
    public Node greaterValue(){
        Node node = root;
        if (root != null){
            node = greaterValue(root);
        }
        return node;
    }
    
    /**
     *  greaterValue - m�todo que retorna o n� com "maior" valor da �rvore
     *  No nosso caso, o maior valor ser� a informa��o que estiver no n� mais a direita.
     *  
     *  @params node n� que marcar� o in�cio da busca pelo maior valor na �rvore
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
     * printPrefix - m�todo chamado para imprimir os valores da �rvore 
     * seguindo um caminhamento prefixado
     */
    public void printPrefix(){
        System.out.println();
        System.out.println("---------------------PREFIX--------------------");
        System.out.println("-----------------------------------------------");
        printPrefix(root);
    }
        
    /**
     * printPrefix - m�todo que imprimir� efetivamente os elementos da �rvore 
     * seguindo um caminhamento prefixado
     * 
     * @params node n� que marcar� o in�cio da impress�o da �rvore
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
     * printPosfix - m�todo chamado para imprimir os elementos da �rvore 
     * seguindo um caminhamento p�s-fixado
     */
    public void printPosfix(){
        System.out.println();
        System.out.println("---------------------POSFIX--------------------");
        System.out.println("-----------------------------------------------");
        printPosfix(root);
    }        
    
    /**
     * printPosfix - m�todo que efetivamente vai imprimir os elementos da �rvore 
     * seguindo um caminhamento p�s-fixado
     * 
     * @params node n� que marca o in�cio da impress�o dos n�s da �rvore
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
     * getRoot() - M�todo que retorna o n� raiz da �rvore
     * 
     * @return root n� raiz da arvore 
     */
    public Node getRoot(){
        return root;
    }
    
}
