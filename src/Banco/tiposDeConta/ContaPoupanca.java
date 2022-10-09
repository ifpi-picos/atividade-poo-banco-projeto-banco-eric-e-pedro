package Banco.tiposDeConta;

import Banco.Cliente;
import Banco.Conta;

public class ContaPoupanca extends Conta {
    private Double rendimento;

    public ContaPoupanca(String usuario, String senha, Cliente cliente) {
        super( senha, cliente);
    }

    
}
