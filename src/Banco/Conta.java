package Banco;

import javax.swing.JOptionPane;

import Banco.notificacoes.Email;
import Banco.notificacoes.Sms;
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

Sms sms = new Sms();
Email email = new Email();

public Conta() {
}

public Conta(String usuario, String senha,String tipo,Cliente cliente) {
    this.saldo = 0.0;
    this.numConta =  (int) (10 + Math.random() * 89);
    this.agencia = 2211;
    this.usuario = usuario;
    this.senha = senha;
    this.tipo = tipo;
    this.cliente = cliente;

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
        String[] resposta = new String[]{"SMS","EMAIL"}; 
    int opcao = JOptionPane.showOptionDialog(null, "NOTIFICAÇÃO", "BANCO SPFC", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);

        this.setSaldo(this.getSaldo() - sacar);
        if (opcao == 0){
        sms.enviaNotificacao("SAQUE", sacar);
        }
        if (opcao == 1){
            email.enviaNotificacao("SAQUE", sacar);

        }
    }
    else{
        JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE","SAQUE",JOptionPane.ERROR_MESSAGE);
    }
   
}
public void depositar(Double depositar){
    if (depositar > 0 ){
        this.setSaldo(this.getSaldo() + depositar);
        JOptionPane.showMessageDialog(null, "DEPOSITO EFETUADO COM SUCESSO");
        String[] resposta = new String[]{"SMS","EMAIL"}; 
        int opcao = JOptionPane.showOptionDialog(null, "NOTIFICAÇÃO", "BANCO SPFC", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);
            if(opcao == 0){
            sms.enviaNotificacao("DEPÓSITO", depositar);
            }
            if(opcao == 1){
                email.enviaNotificacao("DEPÓSITO", depositar);
    }
           
}
    }
    public void tranferencia(Conta transferir, Double valor){
        if (this.getSaldo() >= valor && valor > 0 ){
            this.setSaldo(this.getSaldo() - valor);
            transferir.saldo = transferir.getSaldo() + valor;
            JOptionPane.showMessageDialog(null, "TRANSFERÊNCIA REALIZADA COM SUCESSO!!");  
    String[] resposta = new String[]{"SMS","EMAIL"}; 
    int opcao = JOptionPane.showOptionDialog(null, "NOTIFICAÇÃO", "BANCO SPFC", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);
        if(opcao == 0){
        sms.enviaNotificacao("TRANSFERÊNCIA", valor);
        }
        if(opcao == 1){
            email.enviaNotificacao("TRASFERÊNCIA", valor);
        }    

        }
        
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

    public String statusDaConta() {
        return "\n Tipo: " +this.getTipo()
        + "\n número da conta: " + this.getNmuConta()
        + "\n Agencia: " + this.getAgencia()
        + "\n Cliente: " + this.getCliente().getNome()
        + "\n SALDO: " + Formatacao.coversao(this.getSaldo());
        
        } 

    public String statusDoCliente() {
            return "\n CLIENTE: " +this.getCliente().getNome()
            + "\n DATA: " + this.getCliente().getDataDeNacimento()
            + "\n CPF: " + this.getCliente().getCpf()
            + "\n CIDADE: " + this.getCliente().getEndereco().getCidade()
            + "\n BAIRRO: " + this.getCliente().getEndereco().getBairro()
            + "\n UF: " + this.getCliente().getEndereco().getUf()
            + "\n RUA: " + this.getCliente().getEndereco().getRua()
            + "\n Nº DA CASA: " + this.getCliente().getEndereco().getNum_Da_Casa()
            + "\n CEP: " + this.getCliente().getEndereco().getCep();

            
            }
}
        
