

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
        tree1 = new Tree();
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
    public void testSearchBreadthRoot()
    {
        Pessoa pessoa1 = new Pessoa("Joseph", 1977, 10, 8, "45678912311", "8455796");
        tree1.add(pessoa1);
        assertNotNull(tree1.searchBreadth("Joseph"));
    }

    @Test
    public void testGreaterAndLowerValueRoot()
    {
        Pessoa pessoa1 = new Pessoa("Mariah J", 1977, 10, 20, "456789", "123456");
        tree1.add(pessoa1);
        assertEquals(8, tree1.greaterValue());
        assertEquals(8, tree1.lowerValue());
    }
}


