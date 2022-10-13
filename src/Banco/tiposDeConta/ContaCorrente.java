package Banco.tiposDeConta;

import javax.swing.JOptionPane;

import Banco.Cliente;
import Banco.Conta;



public class ContaCorrente extends Conta {

    private Double chequeEspecial;

    public ContaCorrente(String usuario, String senha, Cliente cliente) {
        super( senha, cliente);
           
    }


}

