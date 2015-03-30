public class Agenda {
    
    private Tree pessoas;
    
    public Agenda (){
        pessoas = new Tree();
    }
    
    public void armazenaPessoa(Pessoa pessoa){
       pessoas.add(pessoa);   
    }
    public void removePessoa(String nome){
        Pessoa toremove = buscaPessoa(nome);
        if (toremove != null){
                pessoas.remove(
        }
    }
    public Pessoa buscaPessoa(String nome){
        return pessoas.searchDepth(nome);
    }
    public void imprimeAgenda(){
       pessoas.printOrdered();   
    }
    public void imprimePessoa(String nome){
       buscaPessoa(nome).print();    
    }
    
}