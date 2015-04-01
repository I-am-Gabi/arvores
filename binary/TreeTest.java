

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TreeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TreeTest
{
    private Tree tree1;
    private Tree tree_withSix;
    private Tree tree_empty0;
    private Tree tree_empty1;
    private Tree tree_empty2;
    private Tree tree_empty3;
    private Tree tree_empty4;
    private Tree tree_empty5;    
    /**
     * Default constructor for test class TreeTest
     */
    public TreeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {    
        tree_withSix = new Tree();
        Pessoa pessoa0 = new Pessoa("Larissa", 1975, 12, 5, "09127", "51351324");
        Pessoa pessoa1 = new Pessoa("Jo", 1977, 12, 5, "12323456", "4456789");
        Pessoa pessoa2 = new Pessoa("J", 1977, 12, 5, "123456", "456789");
        Pessoa pessoa3 = new Pessoa("Juliana", 1977, 12, 5, "09393", "849028");
        Pessoa pessoa4 = new Pessoa("Loanerresman", 1950, 7, 7, "123123", "789456");
        Pessoa pessoa5 = new Pessoa("Poplin", 1955, 5, 5, "454545", "789542");
        Pessoa pessoa6 = new Pessoa("Mariah J", 1977, 10, 20, "456789", "123456");
        tree_withSix.add(pessoa1);
        tree_withSix.add(pessoa2);
        tree_withSix.add(pessoa3);
        tree_withSix.add(pessoa4);
        tree_withSix.add(pessoa5);
        tree_withSix.add(pessoa6);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }


    @Test
    public void testAddRoot()
    {
        tree_empty1 = new Tree();
        Pessoa pessoa1 = new Pessoa("Name", 1970, 10, 10, "123456", "654321");
        assertSame(tree_empty1.add(pessoa1),tree_empty1.getRoot());
    }

    @Test
    public void testAddTwoNodes()
    {
        tree_empty2 = new Tree();
        Pessoa pessoa1 = new Pessoa("Pessoa 1", 1970, 5, 5, "234567", "765432");
        Pessoa pessoa2 = new Pessoa("Pessoa 2", 1960, 3, 3, "8945612", "2165498");
        assertNotNull(tree_empty2.add(pessoa1));
        assertNotNull(tree_empty2.add(pessoa2));
    }
    
    @Test
    public void testAddFourNodes(){
        tree_empty3 = new Tree();        
        Pessoa pessoa1 = new Pessoa("Pessoa 1", 1970, 9, 9, "111111", "765432");
        Pessoa pessoa2 = new Pessoa("Pessoa 2", 1960, 6, 6, "222222", "2165498");
        Pessoa pessoa3 = new Pessoa("Pessoa 3", 1950, 3, 3, "333333", "456457");
        Pessoa pessoa4 = new Pessoa("Pessoa 4", 1940, 1, 1, "444444", "4846845");
        assertNotNull(tree_empty3.add(pessoa1));
        assertNotNull(tree_empty3.add(pessoa2));
        assertNotNull(tree_empty3.add(pessoa3));
        assertNotNull(tree_empty3.add(pessoa4));
    }

    @Test
    public void testPrintPosfix()
    {
        tree_withSix.printPosfix();
    }
    
    @Test
    public void testPrintPrefix()
    {
        tree_withSix.printPrefix();
    }

    @Test
    public void testSearchBreadth()
    {
        Node node1 = tree_withSix.searchBreadth("Juliana");
        assertEquals(tree_withSix.getRoot().getRight(), node1);
        
        Node node2 = tree_withSix.searchBreadth("J");
        assertEquals(tree_withSix.getRoot().getLeft(), node2);
    }
    
    @Test
    public void testSearchDepth()
    {
        Node node1 = tree_withSix.searchDepth("Juliana");
        assertEquals(tree_withSix.getRoot().getRight(), node1);
        
        Node node2 = tree_withSix.searchDepth("J");
        assertEquals(tree_withSix.getRoot().getLeft(), node2);
    }

    @Test
    public void testRemoveNodeEmptyTree()
    {
        Tree tree1 = new Tree();
        Node node1 = new Node();
        tree1.remove(node1);
    }

    @Test
    public void testHeight()
    {
        Node node1 = tree_withSix.searchDepth("Jo");
        assertEquals(5, tree_withSix.calcHeight(node1));
    }

    @Test
    public void testDepth()
    {
        Node node1 = tree_withSix.getRoot();
        assertEquals(0, tree_withSix.calcDepht(node1));
        
        Node node2 = tree_withSix.searchDepth("Juliana");
        assertEquals(1, tree_withSix.calcDepht(node2));
    }

    @Test
    public void testGreaterValue()
    {
        tree_empty0 = new Tree();
        assertEquals(null,tree_empty0.greaterValue());
        assertEquals(tree_withSix.searchDepth("Poplin"), tree_withSix.greaterValue());
    }  
    
    @Test
    public void testLowerValue()
    {
        tree_empty4 = new Tree();
        assertEquals(null,tree_empty4.greaterValue());
        assertEquals(tree_withSix.searchDepth("J"), tree_withSix.lowerValue());
    }      
    
    @Test
    public void testPrintEmptyTree(){
        tree_empty5 = new Tree();
        tree_empty5.printPosfix();
        tree_empty5.printPrefix();
    }

    @Test
    public void testHeightNull()
    {
        assertEquals(0, tree_withSix.calcHeight(null));
    }


    @Test
    public void testDepthNull()
    {
        assertEquals(0, tree_withSix.calcDepht(null));
    }

    @Test
    public void testRemove()
    {
        Node node1 = tree_withSix.searchDepth("Poplin");
        tree_withSix.remove(node1);
        assertNotSame(node1, tree_withSix.greaterValue());
    }
}













