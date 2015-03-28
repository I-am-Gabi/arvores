

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste TreeTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class TreeTest
{
    /**
     * Construtor default para a classe de teste TreeTest
     */
    public TreeTest()
    {
    }

    /**
     * Define a .
     *
     * Chamado antes de cada método de caso de teste.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Chamado após cada método de teste de caso.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testRightAndLeft()
    {
        Tree tree1 = new Tree();
        Pessoa pessoa1 = new Pessoa("5");
        Pessoa pessoa2 = new Pessoa("1");
        tree1.addNode(pessoa1);
        tree1.addNode(pessoa2);
    }
}

