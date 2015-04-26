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
    private Node root; // nó raiz
    
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
        if (root == null) {         // Caso a raiz ainda esteja vazia
            root = new Node(key);   // Inicializa o Node raiz root
            root.setLeft(null);     // Atribui null ao nó esquerdo 
            root.setRight(null);    // Stribui null ao nó direito 
            root.setMin(root);      // Como a árvore só tem o nó raiz, o valor mínimo será ele mesmo
            root.setMax(root);      // Como a árvore só tem o nó raiz, o valor máximo será ele mesmo
            return root;
        }
        else {
            if (hasNode(key)) {         // Verifica se já existe um registro com essa chave
                System.out.print("Já existe um nó com o key informado");
            }
            else {
                return add(root, key); // Chama o método add passando a raiz e a chave
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
    private Node add(Node node, int key) {  // Complexidade não alterada após min e max em O(1)
        if (node.getKey() > key) {          // Verifica se a chave no node é maior que a key (então, a key ficará a esquerda)
            if (node.getLeft() != null) {
                Node temp = add(node.getLeft(), key); // temp armazenará o nó recentemente adicionado
                //verifica se a chave recentemente adionada é mínima da subárvore da qual node é raiz
                if (node.getMin().getKey() > temp.getKey()) {
                    node.setMin(temp); //atualiza mínimo
                }
                return temp;
            }
            else {
                node.setLeft(new Node(key));
                node.getLeft().setParent(node); 
                node.setMin(node.getLeft()); //altera o mínimo
                return node.getLeft();
            }
        }
        else { //a chave deve ficar á direita
            if (node.getRight() != null) {
                Node temp = add(node.getRight(), key);
                //verifica se a chave recentemente adionada é máxima da subárvore da qual node é raiz
                if (node.getMax().getKey() < temp.getKey()) {
                    node.setMax(temp); //atualiza máximo
                }
                return temp;
            }
            else {
                node.setRight(new Node(key));
                node.getRight().setParent(node);
                node.setMax(node.getRight()); //altera o máximo
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
        if (to != null) { 
            /* Verifica se não tem nenhum filho */
            if (to.getLeft() == null && to.getRight() == null){
                if (to.getParent() == null){
                    root = null;
                }
                if (to.isLeft()){ //se for folha à esquerda
                    if(to.getParent() != null) {
                        //atualiza os mínimos dos nós ancestrais antes de remover
                        //COMPLEXIDADE NÃO MANTIDA, há a necessidade de percorrer todos os ancestrais atualizando os mínimos
                        //A complexidade é mantida se considerado que será necessário buscar o nó antes de remover
                        updateMin(to, to.getParent()); //se um nó folha foi removido da esquerda, o novo candidato a menor será o pai
                        to.getParent().setLeft(null);
                    }
                }
                else { //se for folha à direita
                    if(to.getParent() != null) {
                        //atualiza os máximos dos nós ancestrais antes de remover
                        //COMPLEXIDADE NÃO MANTIDA, há a necessidade de percorrer todos os ancestrais atualizando os máximos
                        //A complexidade é mantida se considerado que será necessário buscar o nó antes de remover
                        updateMax(to, to.getParent()); //se um nó folha foi removido da direita, o novo candidato a maior será o pai
                        to.getParent().setRight(null);
                    }
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
                        //se to está à esquerda só tem um filho na esquerda, não será necessário atualizar o mínimo nos ancestrais
                        //COMPLEXIDADE MANTIDA
                        to.getParent().setLeft(to.getLeft());
                    }
                    else {
                        //se to está à direita e só possui um nó à esquerda, será necessário atualizar o máximo dos ancestrais
                        //COMPLEXIDADE NÃO MANTIDA, há a necessidade de percorrer todos os ancestrais atualizando os máximos
                        //A complexidade é mantida se considerado que será necessário buscar o nó antes de remover
                        updateMax(to, to.getLeft()); //o novo candidato a max é o nó filho à esquerda
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
                        //se to está à esquerda e só possui um nó à direita, será necessário atualizar o mínimo dos ancestrais
                        //COMPLEXIDADE NÃO MANTIDA, há a necessidade de percorrer todos os ancestrais atualizando os mínimos
                        //A complexidade é mantida se considerado que será necessário buscar o nó antes de remover
                        updateMin(to, to.getRight()); //o novo candidato a min é o nó filho à direita
                        to.getParent().setLeft(to.getRight());
                    }
                    else {
                        //se to está à direita só tem um filho na direita, não será necessário atualizar o máximo nos ancestrais
                        //COMPLEXIDADE MANTIDA
                        to.getParent().setRight(to.getRight());
                    }
                }
            }
            /* Verifica se tem dois filhos */
            else if (to.getLeft() != null && to.getRight() != null){
                //se tiver dois filhos, troca o nó atual com o nó com maior chave do subárvore esquerda (maior dos menores)
                Node subs = greaterValue(to.getLeft()); //subs(tituto) armazena o maior dos menores
                //como subs era o maior dos menores, será necessário substituir o max de alguns ancestrais. Há duas situação possíveis:
                //caso subs não possua filhos ou caso possua um filho na esquerda
                if (subs.getLeft() != null) { //se tiver um filho na esquerda
                    updateMax(subs, subs.getLeft()); //atualiza o valor máximo dos ancestrais para o filho à esquerda
                    subs.getParent().setRight(subs.getLeft()); //atualiza o filho da direita do pai para neto (direita, esquerda)
                }
                else { //caso não tenha filhos
                    updateMax(subs, subs.getParent()); //atualiza o valor máximo dos ancestrais para o do pai
                    subs.getParent().setRight(null); //como subs não tem filhos, seu pai não terá mais filhos à direita
                }
                //passa as informações do nó que será removido para o que será substituído
                subs.setParent(to.getParent()); //atualiza pai
                subs.setLeft(to.getLeft()); //atualiza filho da esquerda
                subs.setRight(to.getRight()); //atualiza filho da direita
                subs.setMin(to.getMin()); //atualiza referência para mínimo da subárvore
                subs.setMax(to.getMax()); //atualiza referência para máximo da subárvore
                
                if (to.isRoot()) { //se to for raiz, agora subs será a nova raiz
                    root = subs;
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
     * O menor valor será o do nó mais a esquerda
     * 
     * @return node nó com menor valor da árvore
     */
    public Node lowerValue(){   
        return lowerValue(root); 
    }
  
    /**
     * lowerValue - retorna o nó com menor valor da subárvore da qual node é a raiz (nó mais à esquerda)
     * 
     * @param node raiz da subárvore
     * @return retorna referência ao nó com menor chave da subárvore
     */
    private Node lowerValue(Node node) {
        if (node != null){
            return node.getMin();
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
        return greaterValue(root);
    }
    
    /**
     * greaterValue - retorna o nó com maior valor da subárvore da qual node é a raiz (nó mais à direita)
     * 
     * @param node raiz da subárvore
     * @return retorna referência ao nó com maior chave da subárvore
     */
    private Node greaterValue(Node node) {
        if (node != null){
            return node.getMax();
        }
        return null;
    } 
    
    /**
     * printPrefix - método chamado para imprimir os valores da árvore 
     * seguindo um caminhamento prefixado
     */
    public void printPrefix(){
        System.out.println();
        System.out.println("--------------------- PREFIX --------------------");
        System.out.println("-------------------------------------------------");
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
    
    /**
     * updateMin - Atualiza a referência da chave mínima de uma subárvore em nós ancestrais antes de remover um nó
     * 
     * @param rem Nó que deverá ser removido após a execução do método em chamada externa
     * @param newMin Nó que armazena o novo candidato a menor da árvore
     */
    private void updateMin(Node rem, Node newMin) {
        if (rem != null && newMin != null) {
            Node anc = rem.getParent(); //armazena o nó ancestral do qual a referência para min será atualizada
            while (anc != null && anc.getMin() == rem) {
                anc.setMin(newMin); //atualiza o novo mínimo
                anc = anc.getParent(); //incrementa passo para verificar no nó pai
            }
        }
    }
    
    /**
     * updateMax - Atualiza a referência da chave máxima de uma subárvore em nós ancestrais antes de remover um nó
     * 
     * @param rem Nó que deverá ser removido após a execução do método em chamada externa
     * @param newMax Nó que armazena o novo candidato a maior da árvore
     */
    private void updateMax(Node rem, Node newMax) {
        if (rem != null && newMax != null) {
            Node anc = rem.getParent(); //armazena o nó ancestral do qual a referência para max será atualizada
            while (anc != null && anc.getMax() == rem) {
                anc.setMax(newMax); //atualiza o novo mínimo
                anc = anc.getParent(); //incrementa passo para verificar no nó pai
            }
        }
    }
}