import java.util.Calendar;
import java.lang.Integer;
import java.util.Date;
import java.text.DateFormat;
/**
 * Classe Pessoa representar� a entidade 'pessoa' do "mundo real" que ser� 
 * registrada na Agenda
 * 
 * @author Gabriela Cavalcante da Silva, Roberto Dantas.
 * @version 1.00
 */
public class Pessoa
{ 
    private String name;    // campo nome
    private Calendar bday;  // campo dia de nascimento
    private String CPF;     // campo CPF
    private String phone;   // campo telefone

    /**
     * Construtor para objetos da classe Pessoa
     * 
     * @params name nome da pessoa
     * @params bday data de anivers�rio 
     * @params CPF n�mero de cpf
     * @params phone n�mero de telefone
     */    
    public Pessoa(String name, Calendar bday, String CPF, String phone) {
        this.name = name;
        this.bday = Calendar.getInstance();
        this.bday.clear();
        this.bday.set(bday.get(Calendar.YEAR), bday.get(Calendar.MONTH), bday.get(Calendar.DAY_OF_MONTH)); 
        this.CPF = CPF;
        this.phone = phone;
    }  
    
    /**
     * Construtor para objetos da Classe pessoa
     * 
     * @params name nome da pessoa
     * @params year ano de nascimanto da pessoa
     * @params month m�s de nascimento da pessoa
     * @params day dia de nascimento da pessoa
     * @params CPF n�mero de cpf
     * @params phone n�mero de telefone
     */
    public Pessoa(String name, int year, int month, int day, String CPF, String phone) {
        this.name = name;
        this.bday = Calendar.getInstance();
        this.bday.clear();
        this.bday.set(year, month - 1, day); 
        this.CPF = CPF;
        this.phone = phone;
    }
    
    /**
     * getName - retorna valor do campo name (name)
     *  
     * @return name valor do atributo nome da inst�ncia
     */
    public String getName() {
        return name;
    }
    
    /**
     * getBday - retorna valor do campo bday (data de nascimento)
     *  
     * @return bday valor do atributo nascimento da inst�ncia
     */
    public Calendar getBday() {
        return bday;
    }
    
    /**
     * getCPF - retorna valor do campo CPF
     *  
     * @return CPF valor do atributo CPF da inst�ncia
     */
    public String getCPF() {
        return CPF;
    }
    
    /**
     * getPhone - retorna valor do campo phone (telefone)
     *  
     * @return phone valor do atributo phone da inst�ncia
     */
    public String getPhone() {
        return phone;
    }
    
    /**
     * setName - modifica o valor do campo nome
     *  
     * @params name valor que ser� atribuido ao campo name (nome) da inst�ncia
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * setNascimento - modifica o valor do campo nascimento
     *  
     * @params c objeto Calendar que contem os valores que ser�o atribuidos ao campo nascimento da inst�ncia
     */
    public void setBday(Calendar c) {
        this.bday.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)); 
    }
    
    /**
     * setCPF - modifica o valor do campo CPF
     *  
     * @params CPF valor que ser� atribuido ao campo CPF da inst�ncia
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    /**
     * setPhone - modifica o valor do campo phone
     *  
     * @params phone valor que ser� atribuido ao campo phone da inst�ncia
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     * getAge - retorna a idade da pessoa
     * 
     * @return valor correspondente a idade da pessoa
     */
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
     * showInfo - imprime todos os dados da inst�ncia 
     */
    public void print() {
        System.out.println();
        System.out.print("Nome : " + name + " | ");
        
        Date data = this.bday.getTime();
        DateFormat formataData = DateFormat.getDateInstance();
        
        System.out.print("Data de Nascimento :  " + formataData.format(data));
        
        System.out.print(" | IDADE : " + getAge() +  " | CPF : " + CPF + " | Phone : " + phone);
    }
    
    /**
     * isEquals - verifica se duas inst�ncias da classe Pessoa possuem o mesmo valor
     * do CPF. No caso, n�o podemos comparar nomes, nem data de nascimento ou telefone,
     * por que duas pessoas podem ter esses valores iguais, mas nunca poder�o ter o 
     * CPF com o mesmo valor.
     * 
     * @return um valor booleano indicando se os dois valores tem o mesmo CPF (true)
     * ou n�o (false)
     */
    public boolean isEquals(Pessoa p) {
        if (Integer.parseInt(this.CPF) == Integer.parseInt(p.CPF)) {
            return true;
        }
        else {
            return false;
        }
    }
}
