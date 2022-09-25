package atividade2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Banco {
    static ArrayList <Conta> contas;
public static void main(String[] args) {
    

   contas = new ArrayList<Conta>();

} 
    
    public static void criarConta(){
        Cliente cliente = new Cliente(JOptionPane.showInputDialog(null, "NOME DO CLIENTE:" ),JOptionPane.showInputDialog(null, "INFORME CPF DO CLIENTE:"),JOptionPane.showInputDialog(null, "DATA DE NASCIMENTO DO CLIENTE:"),JOptionPane.showInputDialog(null,"ENDEREÇO DO CLIENTE: ")); 
        
        Conta conta = new Conta(Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME NÚMERO DA CONTA:")), cliente);
        
        contas.add(conta);
        operacoes(); 
    
}
public static Conta informarConta(int numeroDaConta){
    Conta conta = null;
     if (contas.size() > 0){
         for(Conta c : contas){
             if (c.getNmuConta() == numeroDaConta){
             conta = c;   
         }
     }
     }
     return conta;
     
 }
 public static void saque(){
    int numConta = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME NUMERO DA CONTA!!"));
   Conta conta = informarConta(numConta);
 if (conta != null){
    Double sacar = Double.parseDouble(JOptionPane.showInputDialog(null, "INFORME O VALOR QUE DESEJA SACAR:"));
    conta.sacar(sacar);
    
 }
 else{
    JOptionPane.showMessageDialog(null, "CONTA INEXISTENTE!!","SAQUE",JOptionPane.ERROR_MESSAGE);
 }
operacoes();
   }
   public static void deposito(){
    int numConta = Integer.parseInt(JOptionPane.showInputDialog(null, " INFORME NUMERO DA CONTA!"));
   Conta conta = informarConta(numConta);
 if (conta != null){
    Double depositar = Double.parseDouble(JOptionPane.showInputDialog(null, "INFORME O VALOR QUE DESEJA DEPOSITAR:"));
    conta.depositar(depositar);
    
    
 }
 else{
    JOptionPane.showMessageDialog(null, "CONTA INEXISTENTE!!","DEPOSITO",JOptionPane.ERROR_MESSAGE);
 }
operacoes();
   }
   public static void transferir(){
    int numContaREmetente = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME NUMERO DA CONTA DO REMETENTE:"));

    Conta contaDoRemetente = informarConta(numContaREmetente);
    if (contaDoRemetente != null){
        int numContaDestino = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME NUMERO DA CONTA DE DESTINO:"));
        Conta destino = informarConta(numContaDestino);

        if(destino != null){
            Double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "QUAL VALOR DESEJA TRANSFERIR:"));
            contaDoRemetente.tranferencia(destino, valor);
            JOptionPane.showMessageDialog(null, "TRANSFERÊNCIA REALIZADA COM SUCESSO!", null, JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "NÃO É POSSIVEL FAZER A TRASNFERÊNCIA!", null, JOptionPane.ERROR_MESSAGE);
        }
        
    }
    operacoes();
   }
   public static void contas(){
    if(contas.size() >0){
        for(Conta conta: contas){
            JOptionPane.showMessageDialog(null, conta, "contas", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    else{
        JOptionPane.showMessageDialog(null, "NÃO HÁ CONTAS CADSTRADAS!", null, JOptionPane.DEFAULT_OPTION);
    }
operacoes();

   }
   public static void operacoes(){
    String[] resposta = new String[]{"CRIAR CONTA","DEPOSITAR","SACAR","TRANSFERÊNCIA","CONTAS","VOLTAR"};
    
    int opcao = JOptionPane.showOptionDialog(null, "ESCOLHA SUA OPERAÇÂO:", "BANCO MAUT", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);
    
    switch(opcao){
        case 0:
        Banco.criarConta();
        break;
        case 1:
        deposito();
        break;
        case 2:
        saque();
        break;
        case 3:
        transferir();
        break;
        case 4:
        contas();
        break;
        case 5:
        opcoes();
        
    }
    
    }
    // função criada com o propósito de msotrar um menu proncipal
    public static void opcoes(){

        String[] resposta = new String[]{"OPERAÇÕES","CONTAS","ENCERRAR"}; 
    int opcao = JOptionPane.showOptionDialog(null, "ESCOLHA UMA OPÇÃO:", "BANCO MAUT", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);
    
    switch(opcao){
        case 0:
        operacoes();
        break;
        case 1:
        break;
        case 2:
        System.exit(1);
        break;
    }
    }

}
