

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AgendaTest.
 *
 * @author Gabriela Cavalcante da Silva 2013022760 , Roberto Dantas 2014027940.
 * @version 1.0
 */
public class AgendaTest
{
    /**
     * Default constructor for test class AgendaTest
     */
    public AgendaTest()
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
    public void testArmazenaPessoa()
    {
        Agenda agenda1 = new Agenda();
        Pessoa pessoa1 = new Pessoa("Gabriela", 1995, 1, 6, "09153214991", "1230843");
        agenda1.armazenaPessoa(pessoa1);
        assertNotNull(agenda1.buscaPessoa("Gabriela"));
    }

    @Test
    public void testRemoverPessoa()
    {
        Agenda agenda1 = new Agenda();
        Pessoa pessoa1 = new Pessoa("Gabriela", 1995, 1, 6, "01931823", "1234098");
        Pessoa pessoa2 = new Pessoa("Roberto", 1994, 7, 19, "23418937", "1234098");
        agenda1.armazenaPessoa(pessoa1);
        agenda1.armazenaPessoa(pessoa2);
        agenda1.removePessoa("Gabriela");
        assertNull(agenda1.buscaPessoa("Gabriela"));
    }

    @Test
    public void testBuscaPessoa()
    {
        Agenda agenda1 = new Agenda();
        Pessoa pessoa1 = new Pessoa("Gabriela", 1994, 7, 19, "23418937", "1234098");
        agenda1.armazenaPessoa(pessoa1);
        assertNotNull(agenda1.buscaPessoa("Gabriela"));
    }
}





