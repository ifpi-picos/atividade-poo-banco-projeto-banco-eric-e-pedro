import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import Banco.Cliente;
import Banco.Conta;
import Banco.Endereco;
public class Principal {
	
   static HashSet <Conta> contas;
    public static void main(String[] args) {
        
        contas = new HashSet<Conta>();
        
        String[] resposta = new String[]{"INICIAR","SAIR"}; 
    int opcao = JOptionPane.showOptionDialog(null, "BEM VINDO AO BANCO SPFC", "BANCO MAUT", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);
    

    switch(opcao){
        case 0:
        opcoes();
        break;
        case 1:
        System.exit(1);
        break;
    }
    
    }
           
   public static void deposito(){
    int numConta = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME NUMERO DA CONTA!"));
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
   public static void transferir(){
    int numContaREmetente = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME NUMERO DA CONTA DO REMETENTE:"));

    Conta contaDoRemetente = informarConta(numContaREmetente);
    if (contaDoRemetente != null){
        int numContaDestino = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME NUMERO DA CONTA DE DESTINO:"));
        Conta destino = informarConta(numContaDestino);

        if(destino != null){
            Double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "QUAL VALOR DESEJA TRANSFERIR:"));
            contaDoRemetente.tranferencia(destino, valor);
        }
        else{
            JOptionPane.showMessageDialog(null, "NÃO É POSSIVEL FAZER A TRASNFERÊNCIA!", null, JOptionPane.ERROR_MESSAGE);
        }
        
    }
    operacoes();
   }

   public static void status(){
    if(contas.size() > 0){
        for(Conta conta: contas){
            JOptionPane.showMessageDialog(null, conta.hashCode(), "contas", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    else{
        JOptionPane.showMessageDialog(null, "NÃO HÁ CONTAS CADSTRADAS!", null, JOptionPane.DEFAULT_OPTION);
    }
operacoes();
   }
       // função para mostar qual tipo de operação o cliente vai escolher

   public static void operacoes(){
    String[] resposta = new String[]{"DEPOSITAR","SACAR","TRANSFERÊNCIA","STATUS","VOLTAR"};
    
    int opcao = JOptionPane.showOptionDialog(null, "ESCOLHA SUA OPERAÇÂO:", "BANCO MAUT", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);
    
    switch(opcao){
        case 0:
        deposito();
        break;
        case 1:
        saque();
        break;
        case 2:
        transferir();
        break;
        case 3:
        status();
        break;
        case 4:
        opcoes();
        break;
            
    }
    
    }
    // função criada com o propósito de msotrar um menu proncipal
    public static void opcoes(){

        String[] resposta = new String[]{"CRIAR CONTA","LOGIN","ENCERRAR"}; 
    int opcao = JOptionPane.showOptionDialog(null, "ESCOLHA UMA OPÇÃO:", "BANCO MAUT", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);
    
    switch(opcao){
        case 0:
        criarConta();
        break;
        case 1:
        fazerLogin();
        break;
        case 2:
        System.exit(1);
        break;
    }
    }

    // função com o propósito de criar uma conta para determninado cliente

    public static void criarConta(){

        Endereco endereco = new Endereco();
            
        Cliente cliente = new Cliente(JOptionPane.showInputDialog(null, "NOME DO CLIENTE:" ),JOptionPane.showInputDialog(null, "INFORME CPF DO CLIENTE:"),JOptionPane.showInputDialog(null, "DATA DE NASCIMENTO DO CLIENTE:"),endereco);

         endereco = new Endereco( JOptionPane.showInputDialog(null,"RUA:"),JOptionPane.showInputDialog(null, "CEP:"),Integer.parseInt(JOptionPane.showInputDialog(null, "NÚMERO DA CASA:")),JOptionPane.showInputDialog(null, "BAIRRO:"),JOptionPane.showInputDialog(null, "CIDADE:"),JOptionPane.showInputDialog(null,"ESTADO:")); 

        Conta conta = new Conta(Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME NÚMERO DA CONTA:")),JOptionPane.showInputDialog(null, "INFORME UN NOME DE USUARIO:"),JOptionPane.showInputDialog(null, "INFORME UMA SENHA DE CADASTRO:"),cliente);
        contas.add(conta);
        
        opcoes();
 
        }  
        
    // função com o propósito de verificar o número da conta de determninado cliente
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

    public static Conta login(String usuario , String senha){
        Conta conta = null;
        if (contas.size() > 0){
            for(Conta c : contas){
                if (c.getUsuario().equals(usuario) && c.getSenha().equals(senha)) {
                conta = c;   
            }
        }
        }
        return conta;
        
    }
    
    public static void fazerLogin(){
        String usuario = JOptionPane.showInputDialog(null, "USUARIO;");
        String senha = JOptionPane.showInputDialog(null, "SENHA:");

        Conta conta = login(usuario, senha);
        if (conta != null){
            operacoes();
        }
        else{
            JOptionPane.showMessageDialog(null, "USUARIO OU SENHA INCORRETOS TENTE NOVAMENTE...", "ERRO",JOptionPane.ERROR_MESSAGE);
            
            String[] resposta = new String[]{"TENTAR NOVAMENTE","VOLTAR"};
            int opcao = JOptionPane.showOptionDialog(null, "ESCOLHA UMA OPÇÃO", "OPÇÕES", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta, 0);

            switch(opcao){
                case 0:
                fazerLogin();
                break;
                case 1:
                opcoes();
                break;        
            }
        }
    }
}

