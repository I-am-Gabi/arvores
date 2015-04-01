
import java.util.Calendar;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PessoaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PessoaTest
{
    private Pessoa pessoa1;
    private Calendar c;

    /**
     * Default constructor for test class PessoaTest
     */
    public PessoaTest()
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
        pessoa1 = new Pessoa("", 0, 0, 0, "", "");
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
    public void testAge()
    {
        c = Calendar.getInstance();
        c.clear();
        c.set(1980, 10, 10); 
        pessoa1.setBday(c);
        assertEquals(34, pessoa1.getAge());
    }

    @Test
    public void testCPF()
    {
        assertEquals("", pessoa1.getCPF());        
        pessoa1.setCPF("888");
        assertEquals("888", pessoa1.getCPF());              
    }

    @Test
    public void testPrint()
    {
        pessoa1.print();
    }
    
    @Test
    public void testName()
    {
        assertEquals("", pessoa1.getName());  
        pessoa1.setName("Nome");
        assertEquals("Nome", pessoa1.getName());        
    }
    
    @Test
    public void testPhone()
    {
        assertEquals("", pessoa1.getPhone());  
        pessoa1.setPhone("84 9999 9999");
        assertEquals("84 9999 9999", pessoa1.getPhone());        
    } 
    

    @Test
    public void testIsEquals()
    {
        Pessoa pessoa2 = new Pessoa("pessoa1", 1980, 10, 10, "987", "123");
        Pessoa pessoa3 = new Pessoa("pessoa2", 1950, 5, 5, "987", "555");
        assertEquals(true, pessoa2.isEquals(pessoa3));
    }
}




