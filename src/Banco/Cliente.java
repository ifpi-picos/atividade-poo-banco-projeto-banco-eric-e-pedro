package Banco;


public class Cliente  {
    private String nome;
    private String cpf;
    private String dataDeNacimento;
    private Endereco endereco;
    private Conta conta;

    public Cliente(){

    }
    
    public Cliente(String nome, String cpf,String dataDeNacimento,Endereco endereco) {
    
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNacimento = dataDeNacimento;
        this.endereco = endereco;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getDataDeNacimento() {
        return dataDeNacimento;
    }

    
    public String toString() {
        return "Cliente [nome=" + nome + "]";
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
   
   
}

