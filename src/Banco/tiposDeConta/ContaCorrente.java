package Banco.tiposDeConta;

import Banco.Cliente;
import Banco.Conta;
import formatacoes.Formatacao;

public class ContaCorrente extends Conta {

    private Double chequeEspecial;
    private Double devendo;
    private int contagem;

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
    Double devendo = this.getDevendo();

    if(depositar >= this.getDevendo()){
      this.setSaldo(depositar - this.getDevendo());
      this.setChequeEspecial(this.getChequeEspecial() + this.devendo);
      this.setDevendo(this.getDevendo() - devendo);
    }

    else{
        this.setSaldo(this.getDevendo() - depositar);
        this.setChequeEspecial(this.getChequeEspecial() + this.devendo);
        this.setDevendo(this.getDevendo() - devendo);
        this.setDevendo(this.getSaldo() - this.getDevendo());
        this.setChequeEspecial(this.chequeEspecial - this.getSaldo());
        this.setSaldo(0.0);

        }
          
}

public void tranferencia(Conta transferir, Double valor) {
    super.tranferencia(transferir, valor);
    this.contagem += 1;
    if (this.contagem > 2){
        Double tx = valor * 7/100;
        transferir.setSaldo(transferir.getSaldo() - tx);
    }

}
public void sacar(Double sacar) {
    if (this.getSaldo() < sacar){
        this.setDevendo(sacar - this.getSaldo());
        this.setChequeEspecial(this.getChequeEspecial() - this.getDevendo());
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
    + "\n DEVENDO: "+ Formatacao.coversao(this.devendo)
    + "\n CONTAGEM: "+this.contagem;
  
    }
public Double getDevendo() {
    return devendo;
}
public void setDevendo(Double devendo) {
    this.devendo = devendo;
}
}


