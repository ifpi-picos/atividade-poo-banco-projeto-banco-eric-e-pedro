package Banco.tiposDeConta;

import javax.swing.JOptionPane;

import Banco.Cliente;
import Banco.Conta;
import formatações.Formatacao;



public class ContaCorrente extends Conta {

    private Double chequeEspecial;

    public ContaCorrente(String senha, Cliente cliente, String tipo) {
        super(senha, cliente,tipo);
        
           
    }
public ContaCorrente(String tipo){
    super.tipo = "Corrente";
}

    
public String statusDaConta() {
    return "\n Tipo: " +this.getTipo()
    + "\n número da conta: " + this.getNmuConta()
    + "\n Agencia: " + this.getAgencia()
    + "\n Cliente: " + this.getCliente().getNome()
    + "\n SALDO: " + Formatacao.coversao(this.getSaldo());
    
    }

public ContaCorrente(){
    
}
}

