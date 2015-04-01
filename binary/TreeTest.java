

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
    private Tree tree_withFour;
    private Tree tree_empty1;
    private Tree tree_empty2;
    private Tree tree_empty3;
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
        tree_withFour = new Tree();
        Pessoa pessoa1 = new Pessoa("Pessoa 1", 1970, 9, 9, "111111", "765432");
        Pessoa pessoa2 = new Pessoa("Pessoa 2", 1960, 6, 6, "222222", "2165498");
        Pessoa pessoa3 = new Pessoa("Pessoa 3", 1950, 3, 3, "333333", "456457");
        Pessoa pessoa4 = new Pessoa("Pessoa 4", 1940, 1, 1, "444444", "4846845");
        tree_withFour.add(pessoa1);
        tree_withFour.add(pessoa2);
        tree_withFour.add(pessoa3);
        tree_withFour.add(pessoa4);
        
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
        tree_withFour.printPosfix();
    }
    
    @Test
    public void testPrintPrefix()
    {
        tree_withFour.printPrefix();
    }
}




