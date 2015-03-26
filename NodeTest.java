

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NodeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NodeTest
{
    /**
     * Default constructor for test class NodeTest
     */
    public NodeTest()
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
    public void testDegree()
    {
        Node node1 = new Node(3);        Pessoa pessoa1 = new Pessoa();
        Node node2 = new Node(3);        Pessoa pessoa2 = new Pessoa();
        Node node3 = new Node(3);        Pessoa pessoa3 = new Pessoa();
        Node node4 = new Node(3);        Pessoa pessoa4 = new Pessoa();
        Node node5 = new Node(3);        Pessoa pessoa5 = new Pessoa();
        
        node1.setPerson(pessoa1);
        node2.setPerson(pessoa2);
        node3.setPerson(pessoa3);
        node4.setPerson(pessoa4);
        node5.setPerson(pessoa5);        

        assertEquals(true, node1.addChildren(node2));
        assertEquals(true, node1.addChildren(node3));
        assertEquals(true, node1.addChildren(node4));
        assertEquals(false, node1.addChildren(node5));
    }
}

