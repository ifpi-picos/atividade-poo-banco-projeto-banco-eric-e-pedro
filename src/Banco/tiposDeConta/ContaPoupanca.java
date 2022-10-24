package Banco.tiposDeConta;

import Banco.Cliente;
import Banco.Conta;

public class ContaPoupanca extends Conta {
    private Double rendimento;

    public ContaPoupanca(String usuario ,String senha,String tipo,Cliente cliente) {
        super(usuario, senha,tipo,cliente);
    }
    public ContaPoupanca(String tipo){
        super.tipo = "Poupança";
    }
    public ContaPoupanca(){
        
    }

    
}
