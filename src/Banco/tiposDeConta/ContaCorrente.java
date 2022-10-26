package Banco.tiposDeConta;

import javax.swing.JOptionPane;

import Banco.Cliente;
import Banco.Conta;
import formatacoes.Formatacao;

public class ContaCorrente extends Conta {

    private Double chequeEspecial;
    private Double devendo;

    public ContaCorrente(String usuario ,String senha ,String tipo,Cliente cliente) {
        super(usuario, senha,tipo,cliente);
        this.chequeEspecial = (double) 100;
        this.devendo = 0.0;
                 
    }
public ContaCorrente(String tipo){
    super.tipo = "Corrente";

}

public ContaCorrente(){
    
}

public void depositar(Double depositar) {

    this.setSaldo(this.getSaldo() - this.getDevendo());
    this.setChequeEspecial(this.getChequeEspecial() + this.devendo);
    
        Double devendo = this.getDevendo();
        this.setDevendo(this.getDevendo() - devendo);
        this.setDevendo(this.getChequeEspecial() - this.getDevendo());
        devendo = this.getDevendo();
        this.setDevendo(this.getDevendo() - devendo);
           
    super.depositar(depositar);

     
}

public void tranferencia(Conta transferir, Double valor) {
    super.tranferencia(transferir, valor);

}
public void sacar(Double sacar) {
    if (this.getSaldo() < sacar){
    
        this.setDevendo(sacar - this.getSaldo());
        this.setChequeEspecial(this.getChequeEspecial() - this.getDevendo());
        this.setSaldo(this.getSaldo() + this.getChequeEspecial() - sacar);
        this.setSaldo(0.0);

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
public String statusDaConta() {
    super.statusDaConta();
    return "\n Tipo: " +this.getTipo()
    + "\n número da conta: " + this.getNmuConta()
    + "\n Agencia: " + this.getAgencia()
   + "\n Cliente: " + this.getCliente().getNome()
    + "\n SALDO: " + Formatacao.coversao(this.getSaldo())
    + "\n CHEQUE:"+ Formatacao.coversao(this.chequeEspecial)
    + "\n DEVENDO: "+ Formatacao.coversao(this.devendo);

    
    }
public Double getDevendo() {
    return devendo;
}
public void setDevendo(Double devendo) {
    this.devendo = devendo;
}
}


