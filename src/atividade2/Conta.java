package atividade2;

import javax.swing.JOptionPane;

public class Conta{
private int agencia ;
private int nmuConta;
private Double saldo;
private Cliente cliente;
private String usuario;
private String senha;

public Conta(int nmuConta, String usuario , String senha,Cliente cliente) {
    this.cliente = cliente;
    this.saldo = 0.0;
    this.nmuConta = nmuConta;
    this.agencia = 2211;
    this.usuario = usuario;
    this.senha = senha;
}
public int getAgencia() {
    return agencia;
}
public int getNmuConta() {
    return nmuConta;
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
        else{
            JOptionPane.showMessageDialog(null, "IMPOSSIVEL REALIZAR A TRANSFERENCIA","TRANSFERÊNCIA",JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public String toString() {
    return "\n número da conta: " + this.getNmuConta()
    + "\n Agencia: " + this.getAgencia()
    + "\n Cliente: " + this.getCliente().getNome()
    + "\n SALDO: " + this.getSaldo();
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



}
