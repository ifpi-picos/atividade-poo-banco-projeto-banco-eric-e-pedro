package Banco.tiposDeConta;

import Banco.Cliente;
import Banco.Conta;

public class ContaPoupanca extends Conta {
    private Double rendimento;

    public ContaPoupanca(String senha, Cliente cliente,String tipo) {
        super( senha, cliente,tipo);
    }
    public ContaPoupanca(String tipo){
        super.tipo = "Poupança";
    }
    public ContaPoupanca(){
        
    }

    
}
