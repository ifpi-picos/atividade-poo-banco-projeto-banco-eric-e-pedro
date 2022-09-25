package atividade2;

public class Cliente  {
    private String nome;
    private String cpf;
    private String dataDeNacimento;
    private Conta bancoMaut;

    public Conta getBancoMaut() {
        return bancoMaut;
    }
    public Cliente(String nome, String cpf,String dataDeNacimento,String endereco) {
    
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNacimento = dataDeNacimento;
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
    
    
   
}
