package atividade2;

public class Cliente extends Endereco  {
    private String nome;
    private String cpf;
    private String dataDeNacimento;
    private Conta conta;

    
    public Cliente(String nome, String cpf,String dataDeNacimento,String rua,String cep ,int numDaCasa,String bairro ,String cidade,String estado) {
    
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNacimento = dataDeNacimento;
        super.rua = rua;
        super.cep = cep;
        super.numeroDaCasa = numDaCasa;
        super.bairro = bairro;
        super.cidade = cidade;
        super.estado = estado;
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
    
   
   
}
