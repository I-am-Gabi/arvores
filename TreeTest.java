

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
    private Pessoa pessoa1;
    private Pessoa pessoa2;
    private Pessoa pessoa3;
    private Pessoa pessoa4;
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
        tree1 = new Tree(2);
        pessoa1 = new Pessoa();
        pessoa2 = new Pessoa();
        pessoa3 = new Pessoa();
        pessoa4 = new Pessoa();
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
    public void testSearch()
    {
        tree1.add(pessoa1);
        tree1.add(pessoa2);
        tree1.add(pessoa3);
        assertNotNull(tree1.buscaProfundidade(pessoa2));
        assertNotNull(tree1.buscaProfundidade(pessoa3));
        assertNotNull(tree1.buscaProfundidade(pessoa1));
    }
}

