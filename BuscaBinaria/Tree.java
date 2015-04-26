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
    private Node root; // n� raiz
    
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
        if (root == null) {         // Caso a raiz ainda esteja vazia
            root = new Node(key);   // Inicializa o Node raiz root
            root.setLeft(null);     // Atribui null ao n� esquerdo 
            root.setRight(null);    // Stribui null ao n� direito 
            root.setMin(root);      // Como a �rvore s� tem o n� raiz, o valor m�nimo ser� ele mesmo
            root.setMax(root);      // Como a �rvore s� tem o n� raiz, o valor m�ximo ser� ele mesmo
            return root;
        }
        else {
            if (hasNode(key)) {         // Verifica se j� existe um registro com essa chave
                System.out.print("J� existe um n� com o key informado");
            }
            else {
                return add(root, key); // Chama o m�todo add passando a raiz e a chave
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
    private Node add(Node node, int key) {  // Complexidade n�o alterada ap�s min e max em O(1)
        if (node.getKey() > key) {          // Verifica se a chave no node � maior que a key (ent�o, a key ficar� a esquerda)
            if (node.getLeft() != null) {
                Node temp = add(node.getLeft(), key); // temp armazenar� o n� recentemente adicionado
                //verifica se a chave recentemente adionada � m�nima da sub�rvore da qual node � raiz
                if (node.getMin().getKey() > temp.getKey()) {
                    node.setMin(temp); //atualiza m�nimo
                }
                return temp;
            }
            else {
                node.setLeft(new Node(key));
                node.getLeft().setParent(node); 
                node.setMin(node.getLeft()); //altera o m�nimo
                return node.getLeft();
            }
        }
        else { //a chave deve ficar � direita
            if (node.getRight() != null) {
                Node temp = add(node.getRight(), key);
                //verifica se a chave recentemente adionada � m�xima da sub�rvore da qual node � raiz
                if (node.getMax().getKey() < temp.getKey()) {
                    node.setMax(temp); //atualiza m�ximo
                }
                return temp;
            }
            else {
                node.setRight(new Node(key));
                node.getRight().setParent(node);
                node.setMax(node.getRight()); //altera o m�ximo
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
        if (to != null) { 
            /* Verifica se n�o tem nenhum filho */
            if (to.getLeft() == null && to.getRight() == null){
                if (to.getParent() == null){
                    root = null;
                }
                if (to.isLeft()){ //se for folha � esquerda
                    if(to.getParent() != null) {
                        //atualiza os m�nimos dos n�s ancestrais antes de remover
                        //COMPLEXIDADE N�O MANTIDA, h� a necessidade de percorrer todos os ancestrais atualizando os m�nimos
                        //A complexidade � mantida se considerado que ser� necess�rio buscar o n� antes de remover
                        updateMin(to, to.getParent()); //se um n� folha foi removido da esquerda, o novo candidato a menor ser� o pai
                        to.getParent().setLeft(null);
                    }
                }
                else { //se for folha � direita
                    if(to.getParent() != null) {
                        //atualiza os m�ximos dos n�s ancestrais antes de remover
                        //COMPLEXIDADE N�O MANTIDA, h� a necessidade de percorrer todos os ancestrais atualizando os m�ximos
                        //A complexidade � mantida se considerado que ser� necess�rio buscar o n� antes de remover
                        updateMax(to, to.getParent()); //se um n� folha foi removido da direita, o novo candidato a maior ser� o pai
                        to.getParent().setRight(null);
                    }
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
                        //se to est� � esquerda s� tem um filho na esquerda, n�o ser� necess�rio atualizar o m�nimo nos ancestrais
                        //COMPLEXIDADE MANTIDA
                        to.getParent().setLeft(to.getLeft());
                    }
                    else {
                        //se to est� � direita e s� possui um n� � esquerda, ser� necess�rio atualizar o m�ximo dos ancestrais
                        //COMPLEXIDADE N�O MANTIDA, h� a necessidade de percorrer todos os ancestrais atualizando os m�ximos
                        //A complexidade � mantida se considerado que ser� necess�rio buscar o n� antes de remover
                        updateMax(to, to.getLeft()); //o novo candidato a max � o n� filho � esquerda
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
                        //se to est� � esquerda e s� possui um n� � direita, ser� necess�rio atualizar o m�nimo dos ancestrais
                        //COMPLEXIDADE N�O MANTIDA, h� a necessidade de percorrer todos os ancestrais atualizando os m�nimos
                        //A complexidade � mantida se considerado que ser� necess�rio buscar o n� antes de remover
                        updateMin(to, to.getRight()); //o novo candidato a min � o n� filho � direita
                        to.getParent().setLeft(to.getRight());
                    }
                    else {
                        //se to est� � direita s� tem um filho na direita, n�o ser� necess�rio atualizar o m�ximo nos ancestrais
                        //COMPLEXIDADE MANTIDA
                        to.getParent().setRight(to.getRight());
                    }
                }
            }
            /* Verifica se tem dois filhos */
            else if (to.getLeft() != null && to.getRight() != null){
                //se tiver dois filhos, troca o n� atual com o n� com maior chave do sub�rvore esquerda (maior dos menores)
                Node subs = greaterValue(to.getLeft()); //subs(tituto) armazena o maior dos menores
                //como subs era o maior dos menores, ser� necess�rio substituir o max de alguns ancestrais. H� duas situa��o poss�veis:
                //caso subs n�o possua filhos ou caso possua um filho na esquerda
                if (subs.getLeft() != null) { //se tiver um filho na esquerda
                    updateMax(subs, subs.getLeft()); //atualiza o valor m�ximo dos ancestrais para o filho � esquerda
                    subs.getParent().setRight(subs.getLeft()); //atualiza o filho da direita do pai para neto (direita, esquerda)
                }
                else { //caso n�o tenha filhos
                    updateMax(subs, subs.getParent()); //atualiza o valor m�ximo dos ancestrais para o do pai
                    subs.getParent().setRight(null); //como subs n�o tem filhos, seu pai n�o ter� mais filhos � direita
                }
                //passa as informa��es do n� que ser� removido para o que ser� substitu�do
                subs.setParent(to.getParent()); //atualiza pai
                subs.setLeft(to.getLeft()); //atualiza filho da esquerda
                subs.setRight(to.getRight()); //atualiza filho da direita
                subs.setMin(to.getMin()); //atualiza refer�ncia para m�nimo da sub�rvore
                subs.setMax(to.getMax()); //atualiza refer�ncia para m�ximo da sub�rvore
                
                if (to.isRoot()) { //se to for raiz, agora subs ser� a nova raiz
                    root = subs;
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
     * O menor valor ser� o do n� mais a esquerda
     * 
     * @return node n� com menor valor da �rvore
     */
    public Node lowerValue(){   
        return lowerValue(root); 
    }
  
    /**
     * lowerValue - retorna o n� com menor valor da sub�rvore da qual node � a raiz (n� mais � esquerda)
     * 
     * @param node raiz da sub�rvore
     * @return retorna refer�ncia ao n� com menor chave da sub�rvore
     */
    private Node lowerValue(Node node) {
        if (node != null){
            return node.getMin();
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
        return greaterValue(root);
    }
    
    /**
     * greaterValue - retorna o n� com maior valor da sub�rvore da qual node � a raiz (n� mais � direita)
     * 
     * @param node raiz da sub�rvore
     * @return retorna refer�ncia ao n� com maior chave da sub�rvore
     */
    private Node greaterValue(Node node) {
        if (node != null){
            return node.getMax();
        }
        return null;
    } 
    
    /**
     * printPrefix - m�todo chamado para imprimir os valores da �rvore 
     * seguindo um caminhamento prefixado
     */
    public void printPrefix(){
        System.out.println();
        System.out.println("--------------------- PREFIX --------------------");
        System.out.println("-------------------------------------------------");
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
            // NORMAL
            // System.out.println("" + node.getKey());
            // PARA TESTES DE ADD
            // System.out.println("" + node.getKey() + " Min: " + node.getMin().getKey() + " Max: " + node.getMax().getKey());
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
    
    /**
     * updateMin - Atualiza a refer�ncia da chave m�nima de uma sub�rvore em n�s ancestrais antes de remover um n�
     * 
     * @param rem N� que dever� ser removido ap�s a execu��o do m�todo em chamada externa
     * @param newMin N� que armazena o novo candidato a menor da �rvore
     */
    private void updateMin(Node rem, Node newMin) {
        if (rem != null && newMin != null) {
            Node anc = rem.getParent(); //armazena o n� ancestral do qual a refer�ncia para min ser� atualizada
            while (anc != null && anc.getMin() == rem) {
                anc.setMin(newMin); //atualiza o novo m�nimo
                anc = anc.getParent(); //incrementa passo para verificar no n� pai
            }
        }
    }
    
    /**
     * updateMax - Atualiza a refer�ncia da chave m�xima de uma sub�rvore em n�s ancestrais antes de remover um n�
     * 
     * @param rem N� que dever� ser removido ap�s a execu��o do m�todo em chamada externa
     * @param newMax N� que armazena o novo candidato a maior da �rvore
     */
    private void updateMax(Node rem, Node newMax) {
        if (rem != null && newMax != null) {
            Node anc = rem.getParent(); //armazena o n� ancestral do qual a refer�ncia para max ser� atualizada
            while (anc != null && anc.getMax() == rem) {
                anc.setMax(newMax); //atualiza o novo m�nimo
                anc = anc.getParent(); //incrementa passo para verificar no n� pai
            }
        }
    }
}