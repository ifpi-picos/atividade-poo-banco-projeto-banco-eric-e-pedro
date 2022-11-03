package Banco;

import java.time.LocalDate;

public class Cliente  {
    private String nome;
    private String cpf;
    private LocalDate dataDeNacimento;
    private Endereco endereco;
    private Conta conta;
    
    public Cliente(){

    }
    
    public Cliente(String nome, String cpf,LocalDate dataDeNacimento,Endereco endereco) {
    
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
    public LocalDate getDataDeNacimento() {
        return dataDeNacimento;
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

