import java.util.Calendar;
import java.lang.Integer;
/*
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.Instant;
import java.time.Period; 
*/
import java.util.Date;
import java.text.DateFormat;
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
    public Pessoa(String nome, Calendar c, String CPF, String telefone)
    {
        this.nome = nome;
        this.nascimento = Calendar.getInstance();
        this.nascimento.clear();
        this.nascimento.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)); 
        this.CPF = CPF;
        this.telefone = telefone;
    } 
    
    public Pessoa()
    {
        nome = " ";
        nascimento = Calendar.getInstance();
        CPF = "0";
        telefone = " ";
    }

    public Pessoa(String cpf)
    {
        nome = " ";
        nascimento = Calendar.getInstance();
        CPF = cpf;
        telefone = " ";
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
    public String getCPF() {
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
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * setNascimento - modifica o valor do campo nascimento
     *  
     * @params cal objeto Calendar que contem os valores que será atribuidos ao campo nascimento da instância
     */
    public void setNascimento(Calendar c) {
        this.nascimento.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)); 
    }
    
    /**
     * setCpf - modifica o valor do campo CPF
     *  
     * @params cpf_ valor que será atribuido ao campo CPF da instância
     */
    public void setCpf(String cpf) {
        CPF = cpf;
    }
    
    /**
     * setTelefone - modifica o valor do campo telefone
     *  
     * @params telefone_ valor que será atribuido ao campo telefone da instância
     */
    public void setTelefone(String telefone) {
        telefone = telefone;
    }
   
    public int getIdade() {
        Calendar today = Calendar.getInstance();  
        today.getTime();
              
        if (today.get(Calendar.MONTH) >= nascimento.get(Calendar.MONTH)){
            if (today.get(Calendar.DAY_OF_MONTH) >= nascimento.get(Calendar.DAY_OF_MONTH)){
                return today.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);
            }
        }
        return today.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR) -1;
    }
    
    /**
     * showInfo - imprime todos os dados da instância 
     */
    public void showInfo() {
        System.out.println();
        System.out.print("Nome : " + nome + " | ");
        
        Date data = nascimento.getTime();
        DateFormat formataData = DateFormat.getDateInstance();
        
        System.out.print("Data de Nascimento :  " + formataData.format(data));
        
        System.out.print(" | IDADE : " + getIdade() +  " | CPF : " + CPF + " | Telefone : " + telefone);
    }
    
    public boolean isEquals(Pessoa p) {
        if (Integer.parseInt(this.CPF) == Integer.parseInt(p.CPF)) {
            return true;
        }
        else {
            return false;
        }
    }
}
