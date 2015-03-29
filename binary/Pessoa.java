import java.util.Calendar;
import java.lang.Integer;
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
    private String name;
    private Calendar bday;
    private String CPF;
    private String phone;

    /**
     * Constructor for objects of class Pessoa
     */
    public Pessoa(){
        this.name = " ";
        this.bday = Calendar.getInstance();
        this.CPF = "0";
        this.phone = " ";
    }
    public Pessoa(String name, Calendar bday, String CPF, String telefone){
        this.name = name;
        this.bday = Calendar.getInstance();
        this.bday.clear();
        this.bday.set(bday.get(Calendar.YEAR), bday.get(Calendar.MONTH),bday.get(Calendar.DAY_OF_MONTH)); 
        this.CPF = CPF;
        this.phone = phone;
    } 
    public Pessoa(String CPF){
        this.name = " ";
        this.bday = Calendar.getInstance();
        this.CPF = CPF;
        this.phone = " ";
    }
    
    /**
     * getNome - retorna valor do campo nome
     *  
     * @return nome valor do atributo nome da instância
     */
    public String getName() {
        return name;
    }
    /**
     * getNascimento - retorna valor do campo nascimento
     *  
     * @return nascimento valor do atributo nascimento da instância
     */
    public Calendar getBday() {
        return bday;
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
     * getTelefone - retorna valor do campo this.phone
     *  
     * @return this.phone valor do atributo this.phone da instância
     */
    public String getPhone() {
        return this.phone;
    }
    /**
     * setNome - modifica o valor do campo nome
     *  
     * @params nome_ valor que será atribuido ao campo nome da instância
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * setNascimento - modifica o valor do campo nascimento
     *  
     * @params cal objeto Calendar que contem os valores que será atribuidos ao campo nascimento da instância
     */
    public void setBday(Calendar c) {
        this.bday.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)); 
    }
    /**
     * setCpf - modifica o valor do campo CPF
     *  
     * @params cpf_ valor que será atribuido ao campo CPF da instância
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    /**
     * setTelefone - modifica o valor do campo this.phone
     *  
     * @params telefone_ valor que será atribuido ao campo this.phone da instância
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getAge() {
        Calendar today = Calendar.getInstance();  
        today.getTime();
              
        if (today.get(Calendar.MONTH) >= this.bday.get(Calendar.MONTH)){
            if (today.get(Calendar.DAY_OF_MONTH) >= this.bday.get(Calendar.DAY_OF_MONTH)){
                return today.get(Calendar.YEAR) - this.bday.get(Calendar.YEAR);
            }
        }
        return today.get(Calendar.YEAR) - this.bday.get(Calendar.YEAR) -1;
    }
    /**
     * showInfo - imprime todos os dados da instância 
     */
    public void print() {
        System.out.println();
        System.out.print("Nome : " + name + " | ");
        
        Date data = this.bday.getTime();
        DateFormat formataData = DateFormat.getDateInstance();
        
        System.out.print("Data de Nascimento :  " + formataData.format(data));
        
        System.out.print(" | IDADE : " + getAge() +  " | CPF : " + CPF + " | this.phone : " + this.phone);
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
