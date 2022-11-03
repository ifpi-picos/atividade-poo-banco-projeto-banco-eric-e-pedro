import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;


import Banco.Cliente;
import Banco.Conta;
import Banco.Endereco;
import Banco.tiposDeConta.ContaCorrente;
import Banco.tiposDeConta.ContaPoupanca;
import formatacoes.Formatacao;
public class Principal {
	 
     static ArrayList <Conta> contas;
     static HashSet <Integer> lista;
     static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) throws HeadlessException, ParseException {
        
        lista = new HashSet<Integer>(); // impede a repetição do número da conta
        
        contas = new ArrayList<Conta>();

    String[] resposta = new String[]{"INICIAR","SAIR"}; 
    int opcao = JOptionPane.showOptionDialog(null, "BEM VINDO AO BANCO SPFC", "BANCO SPFC", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);
    
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

   public static void deposito(String usuario ,String senha) throws HeadlessException, ParseException{

    int numConta = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME NÚMERO DA CONTA!"));
    int agencia  = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME A AGÊNCIA DO BANCO:"));
    
   Conta conta = informarConta(numConta,agencia);


 if (conta != null){
    
    Double depositar = Double.parseDouble(JOptionPane.showInputDialog(null, "INFORME O VALOR QUE DESEJA DEPOSITAR:"));
    
    conta.depositar(depositar);

    }  
    
 else{
        JOptionPane.showMessageDialog(null, "CONTA NÃO ENCONTRADA","DEPOSITO",JOptionPane.ERROR_MESSAGE);
 }
   
operacoes();
   }

  // função  para fazer saque em determinada conta

   public static void saque(String usuario, String senha) throws HeadlessException, ParseException{
    int numConta = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME NUMERO DA CONTA!!"));

    int agencia  = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME A AGÊNCIA DO BANCO:"));

   Conta conta = informarConta(numConta,agencia);

 if (conta != null){
    Double sacar = Double.parseDouble(JOptionPane.showInputDialog(null, "INFORME O VALOR QUE DESEJA SACAR:"));
    conta.sacar(sacar);

 }
 else{
    JOptionPane.showMessageDialog(null, "CONTA NÃO ENCONTRADA","SAQUE",JOptionPane.ERROR_MESSAGE);
}
operacoes();
}

    // função para fazer tranferencia em determinada conta

   public static void transferencia(String usuario, String senha) throws HeadlessException, ParseException{
    int numContaREmetente = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME NUMERO DA CONTA DO REMETENTE:"));

    int agencia  = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME A AGÊNCIA DO BANCO:"));

    Conta contaDoRemetente = informarConta(numContaREmetente,agencia);
    if (contaDoRemetente != null){
        for (Conta c : contas){
            if (numContaREmetente == c.getNmuConta() && usuario.equals(c.getUsuario())&& senha.equals(c.getSenha())){
        int numContaDestino = Integer.parseInt(JOptionPane.showInputDialog(null, 
        "INFORME NUMERO DA CONTA DE DESTINO:"));
        int agenciaDestino  = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME A AGÊNCIA DO BANCO:"));

        Conta destino = informarConta(numContaDestino,agenciaDestino);

        if(destino != null){
            Double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "QUAL VALOR DESEJA TRANSFERIR:"));
            contaDoRemetente.tranferencia(destino, valor);
           
        }
        
    }
           
    }
    }
    else{
        JOptionPane.showMessageDialog(null, "CONTA NÃO ENCONTRADA","TRANSFERÊNCIA",JOptionPane.ERROR_MESSAGE);
 }
    operacoes();
   }

   // função para verifcar o status atual de uma determniada conta

   public static void status(String usuariologin, String Senhalogin) throws HeadlessException, ParseException{

    if(contas.size() > 0){
    
        for(Conta conta: contas){
            
            if(conta.getUsuario().contains(usuariologin) && conta.getSenha().contains(Senhalogin)){
            JOptionPane.showMessageDialog(null, conta.statusDaConta(), "contas", JOptionPane.INFORMATION_MESSAGE);
            operacoes();
                   
        }
    }
        
}
   }

       // função para mostrar qual tipo de operação o cliente vai escolher

   public static void operacoes() throws HeadlessException, ParseException{

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

    public static void opcoes() throws HeadlessException, ParseException{

    String[] resposta = new String[]{"CRIAR CONTA","LOGIN","ENCERRAR"}; 
    int opcao = JOptionPane.showOptionDialog(null, "ESCOLHA UMA OPÇÃO:", "BANCO SPFC", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);
    
    switch(opcao){
        case 0:
        criarConta();
        break;
        case 1:
        fazerLogin();
        case 2:
        System.exit(1);
        break;
    }

    }

    // função com o propósito de criar uma conta para determninado cliente
    
    public static void criarConta() throws HeadlessException, ParseException{
        ContaCorrente cc = new ContaCorrente();
        ContaPoupanca cp = new ContaPoupanca();
        Cliente cliente = new Cliente();

       
        Endereco endereco = new Endereco();
            
        String nome = JOptionPane.showInputDialog(null,"NOME DO CLIENTE:");
        String cpf = Formatacao.format(JOptionPane.showInputDialog(null,"QUAL SEU CPF:"), "###.###.###-##");

        LocalDate data = LocalDate.parse( JOptionPane.showInputDialog(null,"SUA DATA DE NASCIMENTO:"),dtf);
    
        cliente = new Cliente(nome, cpf, data, endereco);
             
        String rua = JOptionPane.showInputDialog(null,"NOME DA RUA:");
        String cep = Formatacao.format(JOptionPane.showInputDialog(null, "INFORME SEU CEP:"), "#####-###");
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

        cp = new ContaPoupanca(usuariologin, senhalogin,"Poupança",cliente);
        cp.setCliente(cliente);


         String resposta[] = new String[]{"CORRENTE","POUPANÇA"};
         int op = JOptionPane.showOptionDialog(null, "ESCOLHA O TIPO DE CONTA:", "BANCO SPFC", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, resposta, resposta);
          
          switch(op){
              case 0:
              // impede que aja números repetidos
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
      
        
        
    // função com o propósito de verificar o número da conta de determninado cliente

    public static Conta informarConta(int numeroDaConta , int agencia){
        Conta conta = null;
        if (contas.size() > 0){
            for(Conta c : contas){
                if (c.getNmuConta() == numeroDaConta && c.getAgencia() == agencia){
                conta =  c;   
            }
        }
        }
        return conta;
        
    }

    public static void dadosDoCliente(String usuariologin , String Senhalogin) throws HeadlessException, ParseException{
    
    for(Conta c : contas){
    if (c != null){
        if(c.getUsuario().contains(usuariologin) && c.getSenha().contains(Senhalogin)){
            JOptionPane.showMessageDialog(null, c.statusDoCliente(), "CLIENTE", JOptionPane.INFORMATION_MESSAGE);
            operacoes();
        }
    }
    }

   }

   private static String usuario;
   private static String senha;
    
    public static void fazerLogin() throws HeadlessException, ParseException{

    usuario = JOptionPane.showInputDialog(null, "INFORMNE SEU USUARIO:");

    senha = JOptionPane.showInputDialog(null, "INFORME SUA SENHA:");
        
    for (Conta c : contas){
    if (c.getUsuario().contains(usuario) && c.getSenha().contains(senha)){
                operacoes();

            }
        }   
        opcoes();
    }   
    
}







