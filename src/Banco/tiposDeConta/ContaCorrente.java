package Banco.tiposDeConta;

import javax.swing.JOptionPane;
import Banco.Cliente;
import Banco.Conta;
import Banco.notificacoes.Email;
import Banco.notificacoes.Sms;
import formatacoes.Formatacao;
public class ContaCorrente extends Conta {

    private Double chequeEspecial;
    private Double devendo;
    private int contagem;

    Sms sms = new Sms();
    Email email = new Email();

    public ContaCorrente(){
    
    }
    public ContaCorrente(String usuario ,String senha ,String tipo,Cliente cliente) {
        super(usuario,senha,tipo,cliente);
        this.chequeEspecial = (double) 100;
        this.devendo = 0.0;
        this.contagem = 0;

    }           
    

public void depositar(Double depositar) {
    Double devendo = this.getDevendo();

    if(depositar > this.getDevendo()){
      super.depositar(depositar);
      this.setChequeEspecial(this.getChequeEspecial() + this.devendo);
      this.setDevendo(this.getDevendo() - devendo);
      this.setSaldo(this.getSaldo() - devendo);
    }
    else if(depositar <= 0){
        
            JOptionPane.showMessageDialog(null, "IMPOSSIVEL REALIZAR O DEPOSITO","DEPOSITO",JOptionPane.ERROR_MESSAGE);

    }
  // caso deposito seja menor que o valor que o cliente esteja devendo ao cheque
    else{
        super.depositar(depositar);
        this.setSaldo(this.getDevendo() - depositar);
        this.setChequeEspecial(this.getChequeEspecial() + this.devendo);
        this.setDevendo(this.getDevendo() - devendo);
        this.setDevendo(this.getSaldo() - this.getDevendo());
        this.setChequeEspecial(this.chequeEspecial - this.getSaldo());
        this.setSaldo(0.0);

        }    

}

public void transfere(Conta transferir, Double valor) {
    this.contagem += 1;
    if (this.contagem <= 2){
        super.transfere(transferir, valor);
    }
    else{
        if (this.getSaldo() >= valor && valor > 0 ){
        Double tx = valor * 7/100;
        transferir.setSaldo(valor + (transferir.getSaldo() - tx));
        this.setSaldo(this.getSaldo() - valor);
        Double envio = valor - tx;
        String[] resposta = new String[]{"SMS","EMAIL"}; 
    int opcao = JOptionPane.showOptionDialog(null, "NOTIFICAÇÃO", "BANCO SPFC", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);
        if(opcao == 0){
        sms.enviaNotificacao("TRANSFERÊNCIA", envio);
        }
        if(opcao == 1){
            email.enviaNotificacao("TRASFERÊNCIA", envio);
        }
    }
    else{
        JOptionPane.showMessageDialog(null, "NÃO É POSSIVEL REALIZAR ESSE TRANFÊRENCIA VERIFIQUE SEU SALDO E TENTE NOVAMENTE","TRANSFERÊNCIA",JOptionPane.ERROR_MESSAGE);
    }
    }

}
public void sacar(Double sacar) {

    Double devendo = 100.00;

    if(this.getChequeEspecial() <= 0){
        JOptionPane.showMessageDialog(null, "IMPOSSIVEL SACAR!!");
        
    }

    else if (this.getSaldo() < sacar){
        
       Double cheque = sacar - this.getSaldo();
       if(cheque <= this.getChequeEspecial()){
        String[] resposta = new String[]{"SMS","EMAIL"}; 
        int opcao = JOptionPane.showOptionDialog(null, "NOTIFICAÇÃO", "BANCO SPFC", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);
        this.setChequeEspecial(this.getChequeEspecial() - cheque);
        this.setDevendo(devendo - this.getChequeEspecial());
        this.setSaldo(0.0);
        if(opcao == 0){
        sms.enviaNotificacao("SAQUE", sacar);
        }
        if(opcao == 1){
        email.enviaNotificacao("SAQUE", sacar);
        }

       }
       else{
        JOptionPane.showMessageDialog(null, "erro!!");
        
       }
    
    }
    else {
        super.sacar(sacar);
    }
}
public Double getChequeEspecial() {
    return chequeEspecial;
}
public void setChequeEspecial(Double chequeEspecial) {
    this.chequeEspecial = chequeEspecial;
}
 
public Double getDevendo() {
    return devendo;
}
public void setDevendo(Double devendo) {
    this.devendo = devendo;
}
public String statusDaConta() {
    super.statusDaConta();
    return "\nTIPO: " +this.getTipo()
    + "\n Nº DA CONTA: " + this.getNmuConta()
    + "\n AGÊNCIA: " + this.getAgencia()
    + "\n CLIENTE: " + this.getCliente().getNome()
    + "\n SALDO: " + Formatacao.coversao(this.getSaldo())
    + "\n CHEQUE: "+ Formatacao.coversao(this.chequeEspecial)
    + "\n DEVENDO: " + Formatacao.coversao(this.devendo);
    
}
}



