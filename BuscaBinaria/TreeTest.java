

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
    public void testAddNode()
    {
        Tree tree1 = new Tree();
        assertNotNull(tree1.add(15)); 
    }

    @Test
    public void testSearchBreadth()
    {
        Tree tree1 = new Tree();
        assertNotNull(tree1.add(15));
        assertNotNull(tree1.searchBreadth(15));
    }
    
    @Test
    public void testSearchDepth()
    {
        Tree tree1 = new Tree();
        assertNotNull(tree1.add(15));
        assertNotNull(tree1.searchBreadth(15));
    }

    @Test
    public void testCalcHeight()
    {
        Tree tree1 = new Tree();
        assertNotNull(tree1.add(15));
        assertNotNull(tree1.add(16));
        assertNotNull(tree1.add(48));
        assertNotNull(tree1.add(32));
        assertNotNull(tree1.add(32));
        assertNotNull(tree1.add(9));
        assertNotNull(tree1.add(10));
        Node node1 = tree1.getRoot(); 
        assertEquals(5, tree1.calcHeight(node1));
    }

    @Test
    public void testCalclDepth()
    {
        Tree tree1 = new Tree();
        assertNotNull(tree1.add(10));
        assertNotNull(tree1.add(9));
        assertNotNull(tree1.add(32));
        assertNotNull(tree1.add(48));
        assertNotNull(tree1.add(16));
        Node node1 = tree1.lowerValue(); 
        assertEquals(1, tree1.calcDepht(node1));
    }
    
    @Test
    public void testGreaterValue()
    {
        Tree tree = new Tree();
        assertNotNull(tree.add(10));
        assertNotNull(tree.add(9));
        assertNotNull(tree.add(32));
        assertNotNull(tree.add(48));
        assertNotNull(tree.add(16));          
        assertEquals(tree.searchDepth(48), tree.greaterValue());
    }  
    
    @Test
    public void testLowerValue()
    {
        Tree tree = new Tree();
        assertNotNull(tree.add(10));
        assertNotNull(tree.add(9));
        assertNotNull(tree.add(32));
        assertNotNull(tree.add(48));
        assertNotNull(tree.add(16)); 
        assertEquals(tree.searchDepth(9), tree.lowerValue());
    }      

    @Test
    public void testHeightNull()
    {
        Tree tree = new Tree();
        assertEquals(0, tree.calcHeight(null));
    }


    @Test
    public void testDepthNull()
    {
        Tree tree = new Tree();
        assertEquals(0, tree.calcDepht(null));
    }

    @Test
    public void testRemove()
    {
        Tree tree = new Tree();
        assertNotNull(tree.add(10));
        assertNotNull(tree.add(9));
        assertNotNull(tree.add(32));
        assertNotNull(tree.add(48));
        assertNotNull(tree.add(16)); 
        Node node1 = tree.searchDepth(32);
        tree.remove(node1);
        assertNotSame(null, tree.searchDepth(32));
    }
}




