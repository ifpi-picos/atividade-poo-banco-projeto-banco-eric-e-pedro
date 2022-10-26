package Banco.tiposDeConta;

import Banco.Cliente;
import Banco.Conta;

public class ContaPoupanca extends Conta {
    private Double rendimento;

    public ContaPoupanca(String usuario ,String senha,String tipo,Cliente cliente) {
        super(usuario,senha,tipo,cliente);
        this.rendimento = 0.10;

    }
    public ContaPoupanca(String tipo){
        super.tipo = "Poupança";
    }
    public ContaPoupanca(){
        
    }
    public Double getRendimento() {
        return rendimento;
    }
    public void setRendimento(Double rendimento) {
        this.rendimento = rendimento;
    }
    @Override
    public void depositar(Double depositar) {
        super.depositar(depositar);
        this.setSaldo(this.getSaldo() + this.getSaldo() * this.getRendimento());
    }
    
    public void tranferencia(Conta transferir, Double valor) {
super.tranferencia(transferir, valor);
transferir.setSaldo(transferir.getSaldo() - (transferir.getSaldo() * 5/100));

    

    

    
}
}