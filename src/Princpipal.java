import javax.swing.JOptionPane;

public class Princpipal{
  public static void main(String[] args) throws InterruptedException {
    int n = (int) (10000000 + Math.random() * 99999999);
    System.out.println(n);

    
    String[] resposta = new String[]{"INICIAR","SAIR"}; 
    int opcao = JOptionPane.showOptionDialog(null, "BEM VINDO AO BANCO MAUT", "BANCO MAUT", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);
    

  }

  
  }

