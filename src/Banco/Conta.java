package Banco;

import javax.swing.JOptionPane;

import formatacoes.Formatacao;
public class Conta{

private int agencia;
private String digito;
private int numConta;
protected Double saldo;
private Cliente cliente;
private String usuario;
private String senha;
protected String tipo;

public Conta() {
}

public Conta(String usuario, String senha,String tipo,Cliente cliente) {
    this.saldo = 0.0;
    this.numConta =  (int) (100000 + Math.random() * 899999);
    this.agencia = 2211;
    this.usuario = usuario;
    this.senha = senha;
    this.tipo = tipo;
    this.cliente = cliente;

}

public Conta(Cliente cliente) {
    this.cliente = cliente;
}

public Conta(String senha) {
    this.senha = senha;
}

public int getAgencia() {
    return agencia;
}
public int getNmuConta() {
    return numConta;
}
public Double getSaldo() {
    return saldo;
}
public Cliente getCliente() {
    return cliente;
}
public void setSaldo(Double saldo) {
    this.saldo = saldo;
}

public void sacar(Double sacar) {
    if (this.getSaldo() > 0){

        this.setSaldo(this.getSaldo() - sacar);
    }
    else{
        JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE","SAQUE",JOptionPane.ERROR_MESSAGE);
    }
   
}
public void depositar(Double depositar){
    if ( depositar > 0 ){
        this.setSaldo(this.getSaldo() + depositar);
        JOptionPane.showMessageDialog(null, "DEPOSITO EFETUADO COM SUCESSO");
    }
    else{
        JOptionPane.showMessageDialog(null, "IMPOSSIVEL REALIZAR O DEPOSITO","DEPOSITO",JOptionPane.ERROR_MESSAGE);

    }
    
    }
    public void tranferencia(Conta transferir, Double valor){
        if (this.getSaldo() >= valor && valor > 0 ){
            this.setSaldo(this.getSaldo() - valor);
            transferir.saldo = transferir.getSaldo() + valor;
            JOptionPane.showMessageDialog(null, "TRANSFERÊNCIA REALIZADA COM SUCESSO!!");      
        }
        
    }
    
    public String statusDaConta() {
    return "\n Tipo: " +this.getTipo()
    + "\n número da conta: " + this.getNmuConta()
    + "\n Agencia: " + this.getAgencia()
    + "\n Cliente: " + this.getCliente().getNome()
    + "\n SALDO: " + Formatacao.coversao(this.getSaldo());
    
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getTipo() {
        return tipo;
    }
   
}
        
