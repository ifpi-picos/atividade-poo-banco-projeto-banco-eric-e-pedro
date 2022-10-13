import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;

import Banco.Cliente;
import Banco.Conta;
import Banco.Endereco;
public class Principal {
	
   static ArrayList <Conta> contas;
   static HashSet <Integer> lista;
   static ArrayList <Cliente> clientes;;

    public static void main(String[] args) {
        
        lista = new HashSet<Integer>();
        
        contas = new ArrayList<Conta>();

        clientes = new ArrayList<Cliente>();

        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyy");

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
           
    // função  para fazer deposito em determinada conta

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

       // função  para fazer saque em determinada conta

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

    // função para fazer tranferencia em determinada conta

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

   // função para verifcar o status atual de uma determniada conta

   public static void status(){
    
 String s = senha;
    if(contas.size() > 0){
        
        for(Conta conta: contas)

            if (conta.getSenha().equals(s)) {
            JOptionPane.showMessageDialog(null, conta.statusDaConta(), "contas", JOptionPane.INFORMATION_MESSAGE);
            operacoes();
            
            
        }
    }
    else{
        JOptionPane.showMessageDialog(null, "NÃO HÁ CONTAS CADSTRADAS!", null, JOptionPane.DEFAULT_OPTION);
        opcoes();
    }

   }
       // função para mostar qual tipo de operação o cliente vai escolher

   public static void operacoes(){
    String[] resposta = new String[]{"DEPOSITAR","SACAR","TRANSFERÊNCIA","STATUS DO CLIENTE","DADOS DO CLIENTE","VOLTAR"};
    
    int opcao = JOptionPane.showOptionDialog(null, "ESCOLHA SUA OPERAÇÂO:", "BANCO SPFC", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);
    
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
        dadosDoCliente();
        break;
        case 5:
        opcoes();       
    }  
    }

    // função criada com o propósito de msotrar um menu proncipal

    public static void opcoes(){

    String[] resposta = new String[]{"CRIAR CONTA","CADASTRAR CLIENTE","LOGIN","ENCERRAR"}; 
    int opcao = JOptionPane.showOptionDialog(null, "ESCOLHA UMA OPÇÃO:", "BANCO SPFC", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);
    
    switch(opcao){
        case 0:
        criarConta();
        break;
        case 1:
        cadastrarCliente();
        break;
        case 2:
        fazerLogin();
        case 3:
        System.exit(1);
        break;
    }
    }

    // função com o propósito de criar uma conta para determninado cliente
 private static String cpf;
    public static void criarConta(){

       // Endereco endereco = new Endereco();
            
       /*  String nome = JOptionPane.showInputDialog(null,"NOME DO CLIENTE:");
        String cpf = JOptionPane.showInputDialog(null,"QUAL SEU CPF:");
        String data = JOptionPane.showInputDialog(null,"SUA DATA DE NASCIMENTO:");

        Cliente cliente = new Cliente(nome, cpf, data, endereco);
         
         String rua = JOptionPane.showInputDialog(null,"NOME DA RUA:");
         String cep = JOptionPane.showInputDialog(null, "INFORME SEU CEP:");
         int numeroDaCasa = Integer.parseInt(JOptionPane.showInputDialog(null, "NÚMERO DA CASA:"));
         String bairro = JOptionPane.showInputDialog(null, "DIGA O SEU BAIRRO:");
         String cidade = JOptionPane.showInputDialog(null, "DIGA SUA  CIDADE:");
         String estado = JOptionPane.showInputDialog(null,"DIGA SEU ESTADO:");

         endereco = new Endereco(rua,cep,numeroDaCasa,bairro,cidade,estado);

        cliente.setEndereco(endereco);*/
       
       
        Cliente cliente = new Cliente();

        String senhaDeLogin = JOptionPane.showInputDialog(null, "INFORME UMA SENHA DE CADASTRO:");
        Conta conta = new Conta(senhaDeLogin,cliente);


        for (Cliente c: clientes){
        cpf  = JOptionPane.showInputDialog(null, "INFORME CPF DO CLIENTE:");
        cpf = c.getCpf();
    
        if(lista.add(conta.getNmuConta()) && c.getCpf().equals(cpf)){

        contas.add(conta); 
        opcoes();


        }
        else{
            JOptionPane.showMessageDialog(null, "IMPOSSIVEL ADICIONAR SUA CONTA:", null, 0);
            opcoes();
        }
    }
        }
        
        public static void cadastrarCliente(){
            Endereco endereco = new Endereco();
            
        String nome = JOptionPane.showInputDialog(null,"NOME DO CLIENTE:");
        String cpf = JOptionPane.showInputDialog(null,"QUAL SEU CPF:");
        String data = JOptionPane.showInputDialog(null,"SUA DATA DE NASCIMENTO:");

        Cliente cliente = new Cliente(nome, cpf, data, endereco);
         
         String rua = JOptionPane.showInputDialog(null,"NOME DA RUA:");
         String cep = JOptionPane.showInputDialog(null, "INFORME SEU CEP:");
         int numeroDaCasa = Integer.parseInt(JOptionPane.showInputDialog(null, "NÚMERO DA CASA:"));
         String bairro = JOptionPane.showInputDialog(null, "DIGA O SEU BAIRRO:");
         String cidade = JOptionPane.showInputDialog(null, "DIGA SUA  CIDADE:");
         String estado = JOptionPane.showInputDialog(null,"DIGA SEU ESTADO:");

         endereco = new Endereco(rua,cep,numeroDaCasa,bairro,cidade,estado);

        cliente.setEndereco(endereco);

        clientes.add(cliente);
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

    public static void dadosDoCliente(){
        String s = senha;
   for(Cliente cl: clientes){
    for(Conta c : contas){
    if (c != null){
        if(c.getSenha().equals(s)){
            JOptionPane.showMessageDialog(null,"CLIENTE: "+cl.getNome()
             + "\nDATA DE NASCIMENTO: " +cl.getDataDeNacimento()
            + "\nCPF: "+ cl.getCpf()
            + "\nRUA: "+ cl.getEndereco().getRua()
            + "\nCEP: " +cl.getEndereco().getCep()
            + "\nNÚMERO DA CASA: "+ cl.getEndereco().getNum_Da_Casa()
            + "\nBAIRRO: "+ cl.getEndereco().getBairro()
            + "\nCIDADE: "+cl.getEndereco().getCidade()
            + "\nUF: "+ cl.getEndereco().getRua());
            operacoes();
        }
        else{
            JOptionPane.showMessageDialog(null, "SENHA INCORRETA!");
            opcoes();
        }

    }
    else{
        JOptionPane.showMessageDialog(null,"OPS NENHUM CLIENTE CADSTRADO!");
        opcoes();
    }
}
   }
opcoes();
    }
    private static String senha;
    public static void fazerLogin() {
         senha = JOptionPane.showInputDialog("SENHA:");
         if (contas.size() > 0){
        for (Conta c: contas){
            
            if(c.getSenha().equals(senha)){
                operacoes();
                }
                if(c.getSenha() != c.getSenha()){
                    opcoes();
                }

                }
            }
        
        else{
            JOptionPane.showMessageDialog(null, "OPS OUVE UM ERRO ESSA CONTA NÃO EXISTE!");
            opcoes();
        }
      JOptionPane.showMessageDialog(null, "USUARIO OU SENHA INCORRETO","BANCO SPFC" ,0);
      opcoes();
    }

}


