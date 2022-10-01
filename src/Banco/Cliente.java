package Banco;

public class Cliente {
    private String nome;
    private String cpf;
    private String dataDeNacimento;
    private Conta conta;
    private Endereco endereco;
  
    public Cliente(String nome, String cpf,String dataDeNacimento, Endereco endereco) {
    
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNacimento = dataDeNacimento;
                
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
    public Conta getConta() {
        return conta;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Endereco getEndereco() {
        return endereco;
    }

   
}
