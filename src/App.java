import java.util.ArrayList;
import javax.swing.JOptionPane;
import atividade2.Conta;
import atividade2.Cliente;

public class App {

    static ArrayList <Conta> contas;
    public static void main(String[] args) throws Exception {
        
        
        contas = new ArrayList<Conta>();
        String[] resposta = new String[]{"INICIAR","SAIR"}; 
    int opcao = JOptionPane.showOptionDialog(null, "BEM VINDO AO BANCO MAUT", "BANCO MAUT", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, resposta,0);
    

    switch(opcao){
        case 0:
        banco.opcoes();
        break;
        case 1:
        System.exit(1);
        break;
    }
    
    }
}
   
