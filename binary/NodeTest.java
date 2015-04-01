

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NodeTest.
 *
<<<<<<< HEAD
 * @author  Gabriela Cavalcante, Roberto Dantas
=======
 * @author Gabriela Cavalcante da Silva 2013022760 , Roberto Dantas 2014027940.
>>>>>>> 96379249c977b1bb65933dee997ae0e5f8d8bc00
 * @version 1.0
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
    public void testConstructorData()
    {
        Pessoa pessoa1 = new Pessoa("name", 1970, 12, 12, "123456789", "987654321");
        Node node2 = new Node(pessoa1);
        assertEquals(pessoa1, node2.getData());
    }

    @Test
    public void testData()
    {
        Node node1 = new Node();
        assertNull(node1.getData());
        Pessoa pessoa1 = new Pessoa("pessoa", 1950, 10, 10, "10", "20");
        node1.setData(pessoa1);
        assertEquals(pessoa1, node1.getData());
    }

    @Test
    public void testParent()
    {
        Node node1 = new Node();
        assertNull(node1.getParent());
        Node node2 = new Node();
        node1.setParent(node2);
        assertEquals(node2, node1.getParent());
    }

    @Test
    public void testLeft()
    {
        Node node1 = new Node();
        assertNull(node1.getLeft());
        Node node2 = new Node();
        node1.setLeft(node2);
        assertEquals(node2, node1.getLeft());
    }
    
    @Test
    public void testRight()
    {
        Node node1 = new Node();
        assertNull(node1.getRight());
        Node node2 = new Node();
        node1.setRight(node2);
        assertEquals(node2, node1.getRight());
    }

    @Test
    public void testIsLeft()
    {
        Node node2 = new Node();
        Node node3 = new Node();
        node2.setLeft(node3);
        node3.setParent(node2);
        assertEquals(true, node3.isLeft());
    }

    @Test
    public void testIsRoot()
    {
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        node4.setLeft(node5);
        node4.setRight(node6);
        assertEquals(true, node4.isRoot());
    }
}






