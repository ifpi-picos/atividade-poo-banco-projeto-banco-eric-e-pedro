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
   static ArrayList <Cliente> clientes;

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
    if (conta.getTipo().equalsIgnoreCase("Corrente")){
    conta.depositar(depositar);
    }
    else if(conta.getTipo().equalsIgnoreCase("Poupança")){
        conta.depositar(depositar);
    } 
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
    String s =  JOptionPane.showInputDialog(null,"IMFORME A SUA SENHA:");
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

    String[] resposta = new String[]{"CRIAR CONTA","CADASTRAR CLIENTE","OPERAÇÕES","ENCERRAR"}; 
    int opcao = JOptionPane.showOptionDialog(null, "ESCOLHA UMA OPÇÃO:", "BANCO SPFC", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);
    
    switch(opcao){
        case 0:
        criarConta();
        break;
        case 1:
        cadastrarCliente();
        break;
        case 2:
        operacoes();
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

        Cliente cliente = new Cliente();
        switch(op){
            case 0:
        String senha = JOptionPane.showInputDialog(null, "INFORME UMA SENHA DE CADASTRO:");
         cc = new ContaCorrente(senha,cliente,"Corrente");

    
        
       String CPF  = JOptionPane.showInputDialog(null, "INFORME CPF DO CLIENTE:");
        Cliente  c = informarCliente(CPF);
        if(lista.add(cc.getNmuConta()) && clientes.contains(c) ){
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
         senha = JOptionPane.showInputDialog(null, "INFORME UMA SENHA DE CADASTRO:");
         cp = new ContaPoupanca(senha,cliente,"Poupança");

        CPF  = JOptionPane.showInputDialog(null, "INFORME CPF DO CLIENTE:");
          c = informarCliente(CPF);
        if(lista.add(cp.getNmuConta()) && clientes.contains(c) ){
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

        public static Cliente informarCliente (String cpf){
            Cliente cliente = null;
            if(clientes.size() > 0){
                for(Cliente c : clientes){
                    if (c.getCpf().equals(cpf)){
                        cliente = c;
                    }
                }
               
            }
            return cliente;

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
        String senha = JOptionPane.showInputDialog("INFORME SUA SENHA:");
        
   for(Cliente cl: clientes){
    for(Conta c : contas){
    if (cl != null){
        if(cl.getSenhaCliente().equals(senha)){
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

   }
}
    }
   
      
}


