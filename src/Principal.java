import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
import Banco.Cliente;
import Banco.Conta;
import Banco.Endereco;
import Banco.tiposDeConta.ContaCorrente;
import Banco.tiposDeConta.ContaPoupanca;
public class Principal {
	
     static ArrayList <Conta> contas;
     static HashSet <Integer> lista;
   
    public static void main(String[] args) {
        
        lista = new HashSet<Integer>();
        
        contas = new ArrayList<Conta>();
    
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

   public static void deposito(String usuario ,String senha){
    int numConta = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME NUMERO DA CONTA!"));
    
 
   Conta conta = informarConta(numConta);

 if (conta != null){
    for (Conta c : contas){
        if (numConta == c.getNmuConta() && usuario.equals(c.getUsuario())&& senha.equals(c.getSenha())){

    
    Double depositar = Double.parseDouble(JOptionPane.showInputDialog(null, "INFORME O VALOR QUE DESEJA DEPOSITAR:"));
    if (conta.getTipo().equalsIgnoreCase("Corrente")){
    conta.depositar(depositar);


    }
    else if(conta.getTipo().equalsIgnoreCase("Poupança")){
        conta.depositar(depositar);
    }  
    } 
  /*else{
        JOptionPane.showMessageDialog(null, "CONTA NÃO ENCONTRADA","DEPOSITO",JOptionPane.ERROR_MESSAGE);
    }*/
   
}
 }
 else{
    JOptionPane.showMessageDialog(null, "CONTA INEXISTENTE!!","DEPOSITO",JOptionPane.ERROR_MESSAGE);
 }
operacoes();
   }

       // função  para fazer saque em determinada conta

   public static void saque(String usuario, String senha){
    int numConta = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME NUMERO DA CONTA!!"));
   ContaCorrente conta = informarConta(numConta);
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

   public static void transferencia(String usuario, String senha){
    int numContaREmetente = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME NUMERO DA CONTA DO REMETENTE:"));

    Conta contaDoRemetente = informarConta(numContaREmetente);
    if (contaDoRemetente != null){
        for (Conta c : contas){
            if (numContaREmetente == c.getNmuConta() && usuario.equals(c.getUsuario())&& senha.equals(c.getSenha())){
        int numContaDestino = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME NUMERO DA CONTA DE DESTINO:"));
        Conta destino = informarConta(numContaDestino);

        if(destino != null){
            Double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "QUAL VALOR DESEJA TRANSFERIR:"));
            contaDoRemetente.tranferencia(destino, valor);
        }
    }
        else{
            JOptionPane.showMessageDialog(null, "NÃO É POSSIVEL FAZER A TRASNFERÊNCIA!", null, JOptionPane.ERROR_MESSAGE);
        }
        
    }
    }
    operacoes();
   }

   // função para verifcar o status atual de uma determniada conta

   public static void status(String usuariologin, String Senhalogin){

    if(contas.size() > 0){
        
        for(Conta conta: contas){
            if(conta.getUsuario().contains(usuariologin) && conta.getSenha().contains(Senhalogin)){
            JOptionPane.showMessageDialog(null, conta.statusDaConta(), "contas", JOptionPane.INFORMATION_MESSAGE);
            operacoes();
                   
        }
    }
        
}
   }

       // função para mostar qual tipo de operação o cliente vai escolher

   public static void operacoes(){

    String[] resposta = new String[]{"DEPOSITAR","SACAR","TRANSFERÊNCIA","STATUS DO CLIENTE","DADOS DO CLIENTE","VOLTAR"};
    
    int opcao = JOptionPane.showOptionDialog(null, "ESCOLHA SUA OPERAÇÂO:", "BANCO SPFC", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);

    
    switch(opcao){
        case 0:
        deposito(usuario,senha);
        break;
        case 1:
        saque(usuario,senha);
        break;
        case 2:
        transferencia(usuario, senha);
        break;
        case 3:
        status(usuario,senha);
        break;
        case 4:
        dadosDoCliente(usuario,senha);
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
    
    public static void criarConta(){
        ContaCorrente cc = new ContaCorrente();
        ContaPoupanca cp = new ContaPoupanca();
  

       String resposta[] = new String[]{"Corrente","Poupança"};
       int op = JOptionPane.showOptionDialog(null, "ESCOLHA O TIPO DE CONTA:", "BANCO SPFC", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, resposta, resposta);
        
        switch(op){
            case 0:
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
            
    
        String usuariologin = JOptionPane.showInputDialog(null, "INFORME UM USÚARIO DE CADASTRO:");
        String senhalogin = JOptionPane.showInputDialog(null, "INFORME UMA SENHA DE CADASTRO:");
         cc = new ContaCorrente(usuariologin, senhalogin,"Corrente",cliente);
         cc.setCliente(cliente);

       
        
        if(lista.add(cc.getNmuConta())){
            contas.add(cc);
        JOptionPane.showMessageDialog(null, "CONTA CADASTRADA COM SUCESSO!!");

        opcoes();

        }    
    
    else{
        JOptionPane.showMessageDialog(null, "IMPOSSIVEL ADICIONAR SUA CONTA:", null, 0);
        opcoes();     
    }

        break;
        case 1:
         usuario = JOptionPane.showInputDialog(null, "INFORME UM USÚARIO DE CADASTRO:");

         senha = JOptionPane.showInputDialog(null, "INFORME UMA SENHA DE CADASTRO:");
         cp = new ContaPoupanca(usuario,senha,"Poupança",null);

          
        if(lista.add(cp.getNmuConta()) ){
            contas.add(cp);
        JOptionPane.showMessageDialog(null, "CONTA CADASTRADA COM SUCESSO!!");

        opcoes();

        }    
    
    else{
        JOptionPane.showMessageDialog(null, "IMPOSSIVEL ADICIONAR SUA CONTA:", null, 0);
        opcoes();
        
        break;
    }
    }
    }
       public static Conta informarCliente (String cpf){
        Cliente cliente  = new Cliente();
            Conta conta = new Conta();
            conta.setCliente(cliente);
            if(contas.size() > 0){
                for(Conta c : contas){
                    if (c.getCliente().getCpf().equals(cpf)){
                        conta = c;
                    }
                }
               
            }
            return  conta;

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
        

        Conta conta = new Conta(cliente);
        conta.setCliente(cliente);


        opcoes();

        }
        
    // função com o propósito de verificar o número da conta de determninado cliente

    public static ContaCorrente informarConta(int numeroDaConta){
        ContaCorrente conta = null;
        if (contas.size() > 0){
            for(Conta c : contas){
                if (c.getNmuConta() == numeroDaConta){
                conta = (ContaCorrente) c;   
            }
        }
        }
        return conta;
        
    }

    public static void dadosDoCliente(String usuariologin , String Senhalogin){
    
    for(Conta c : contas){
    if (c != null){
        if(c.getUsuario().contains(usuariologin) && c.getSenha().contains(Senhalogin)){
            JOptionPane.showMessageDialog(null,"CLIENTE: "+c.getCliente().getNome()
             + "\nDATA DE NASCIMENTO: " +c.getCliente().getDataDeNacimento()
            + "\nCPF: "+ c.getCliente().getCpf()
            + "\nRUA: "+ c.getCliente().getEndereco().getRua()
            + "\nCEP: " +c.getCliente().getEndereco().getCep()
            + "\nNÚMERO DA CASA: "+ c.getCliente().getEndereco().getNum_Da_Casa()
            + "\nBAIRRO: "+ c.getCliente().getEndereco().getBairro()
            + "\nCIDADE: "+c.getCliente().getEndereco().getCidade()
            + "\nUF: "+ c.getCliente().getEndereco().getRua());
            operacoes();
        }
    
        else{
            JOptionPane.showMessageDialog(null, "SENHA INCORRETA!");
            opcoes();
        }
    }
    }

   }

    
    static String usuario;
    static String senha;

      public static void fazerLogin(){
        usuario = JOptionPane.showInputDialog(null, "INFORMNE SEU USUARIO:");

         senha = JOptionPane.showInputDialog(null, "INFORME SUA SENHA:");

         for (Conta c : contas){
            if (usuario.equals(c.getUsuario()) && senha.equals(c.getSenha())){
                operacoes();

            }
         }

      }
    }
    


