package Banco.tiposDeConta;

import javax.swing.JOptionPane;

import Banco.Cliente;
import Banco.Conta;
import formatacoes.Formatacao;

public class ContaCorrente extends Conta {

    private Double chequeEspecial;

    public ContaCorrente(String usuario ,String senha ,String tipo,Cliente cliente) {
        super(usuario, senha,tipo,cliente);
        chequeEspecial = (double) 100;
                 
    }
public ContaCorrente(String tipo){
    super.tipo = "Corrente";

}

public ContaCorrente(){
    
}
@Override
public void depositar(Double depositar) {
    // TODO Auto-generate
    super.depositar(depositar);

    if (this.getChequeEspecial() < 100){
        this.setSaldo(this.getSaldo()- depositar);
    }

}

@Override
public void tranferencia(Conta transferir, Double valor) {
    super.tranferencia(transferir, valor);

}
@Override
public void sacar(Double sacar) {
    // TODO Auto-generated method stub
    super.sacar(sacar);
    if (this.getSaldo() < sacar){
        this.setSaldo(this.getSaldo() + this.getChequeEspecial());
        JOptionPane.showMessageDialog(null, "SAQUE COM CHEQUE EFETUADO COM SUCESSO!");

    }
    else if(this.getSaldo() + this.getChequeEspecial() < sacar){
        JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE:");
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
    + "\n CHEQUE:"+ Formatacao.coversao(this.chequeEspecial);

    
    }
}


