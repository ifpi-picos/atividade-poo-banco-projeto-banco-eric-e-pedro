import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

public class Teates{
  public static void main(String[] args) throws InterruptedException {
    int n = (int) (10000000 + Math.random() * 99999999);

    System.out.println(n);

    Set <String> lista = new HashSet<String>();
    lista.add("1");
    lista.add("2");
    lista.add("3");
    System.out.println(lista);
    

    
    String[] resposta = new String[]{"INICIAR","SAIR"}; 
    int opcao = JOptionPane.showOptionDialog(null, "BEM VINDO AO BANCO MAUT", "BANCO MAUT", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);
    

  }

  
  }

