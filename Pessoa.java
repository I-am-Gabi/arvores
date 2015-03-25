import java.util.Calendar;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.Instant;
import java.time.Period;
import java.util.Date;
/**
 * Write a description of class Pessoa here.
 * 
 * @author Gabriela Cavalcante da Silva , Gustavo Alves , Roberto Dantas.
 * @version 1.00
 */
public class Pessoa
{
    // instance variables - replace the example below with your own
    private String nome;
    private Calendar nascimento;
    private String CPF;
    private String telefone;

    /**
     * Constructor for objects of class Pessoa
     */
    public Pessoa(String nome_, Calendar nascimento_, String CPF_, String telefone_)
    {
        nome = nome_;
        nascimento.set(Calendar.YEAR, nascimento_.YEAR); 
        nascimento.set(Calendar.MONTH, nascimento_.MONTH); 
        nascimento.set(Calendar.DAY_OF_MONTH, nascimento_.DAY_OF_MONTH);
        CPF = CPF_;
        telefone = telefone_;
    } 
    
    public Pessoa()
    {
        nome = "";
        nascimento = Calendar.getInstance();
        CPF = "";
        telefone = "";
    }

    /**
     * getNome - retorna valor do campo nome
     *  
     * @return nome valor do atributo nome da instância
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * getNascimento - retorna valor do campo nascimento
     *  
     * @return nascimento valor do atributo nascimento da instância
     */
    public Calendar getNascimento() {
        return nascimento;
    }
    
    /**
     * getCpf - retorna valor do campo CPF
     *  
     * @return CPF valor do atributo CPF da instância
     */
    public String getCpf() {
        return CPF;
    }
    
    /**
     * getTelefone - retorna valor do campo telefone
     *  
     * @return telefone valor do atributo telefone da instância
     */
    public String getTelefone() {
        return telefone;
    }
    
    
    /**
     * setNome - modifica o valor do campo nome
     *  
     * @params nome_ valor que será atribuido ao campo nome da instância
     */
    public void setNome(String nome_) {
        nome = nome_;
    }
    
    /**
     * setNascimento - modifica o valor do campo nascimento
     *  
     * @params cal objeto Calendar que contem os valores que será atribuidos ao campo nascimento da instância
     */
    public void setNascimento(Calendar c) {
        nascimento.set(Calendar.YEAR, c.YEAR); 
        nascimento.set(Calendar.MONTH, c.MONTH); 
        nascimento.set(Calendar.DAY_OF_MONTH, c.DAY_OF_MONTH);
    }
    
    /**
     * setCpf - modifica o valor do campo CPF
     *  
     * @params cpf_ valor que será atribuido ao campo CPF da instância
     */
    public void setCpf(String cpf_) {
        CPF = cpf_;
    }
    
    /**
     * setTelefone - modifica o valor do campo telefone
     *  
     * @params telefone_ valor que será atribuido ao campo telefone da instância
     */
    public void setTelefone(String telefone_) {
        telefone = telefone_;
    }
    
    /**
     * showInfo - imprime todos os dados da instância 
     */
    public void showInfo() {
        System.out.print("Nome : " + nome + " | Data de Nascimento : " + nascimento + " | CPF : " + CPF + " | Telefone : " + telefone);
    }
    
    public int getIdade() {
        Calendar c = Calendar.getInstance();    
        
        /* LocalDate aniv = LocalDate.of(aniversario.YEAR, aniversario.MONTH, aniversario.DAY_OF_MONTH);
        LocalDate hoje = LocalDate.now();
        */ 
       
       LocalDate homemNoEspaco = LocalDate.of(1961, Month.APRIL, 12);
       LocalDate homemNaLua = LocalDate.of(1969, Month.MAY, 25);
        Period periodo = Period.between(homemNoEspaco, homemNaLua); 
         
        System.out.printf("%s anos, %s mês e %s dias", 
        periodo.getYears() , periodo.getMonths(), periodo.getDays());
        //X anos, Y mês e Z dias 

        return 0; 
    }
}
