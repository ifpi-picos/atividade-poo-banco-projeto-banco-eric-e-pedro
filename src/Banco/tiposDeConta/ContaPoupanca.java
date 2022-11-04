package Banco.tiposDeConta;

import javax.swing.JOptionPane;

import Banco.Cliente;
import Banco.Conta;
import Banco.notificacoes.Email;
import Banco.notificacoes.Sms;

public class ContaPoupanca extends Conta {
    private Double rendimento;

    Sms sms = new Sms();
    Email email = new Email();
    
    public ContaPoupanca(String usuario ,String senha,String tipo,Cliente cliente) {
        super(usuario,senha,tipo,cliente);
        this.rendimento = 0.10;
    }
    
    public ContaPoupanca(){
        
    }
    public Double getRendimento() {
        return rendimento;
    }
    public void setRendimento(Double rendimento) {
        this.rendimento = rendimento;
    }
    
    public void depositar(Double depositar) {
        super.depositar(depositar);
        this.setSaldo(this.getSaldo() + this.getSaldo() * this.getRendimento());
    }
    
    public void transfere(Conta transferir, Double valor) {
    if (valor > 0  && this.getSaldo() >= valor){
    Double tx = valor * 5/100;
    transferir.setSaldo(valor +( transferir.getSaldo() - tx));
    this.setSaldo(this.getSaldo() - valor);
    Double envio = valor - tx;

    String[] resposta = new String[]{"SMS","EMAIL"}; 
    int opcao = JOptionPane.showOptionDialog(null, "NOTIFICAÇÃO", "BANCO SPFC", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);
        if(opcao == 0){
        sms.enviaNotificacao("TRANSFERÊNCIA", envio);
        }
        if(opcao == 1){
        email.enviaNotificacao("TRANSFERÊNCIA", envio);
        }

}
else{
    JOptionPane.showMessageDialog(null, "IMPOSSIVEL REALIZAR ESSA SUA TRANSFERÊNCIA!!","TRANSFERÊNCIA",JOptionPane.ERROR_MESSAGE);
}
}
}