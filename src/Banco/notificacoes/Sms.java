package Banco.notificacoes;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import formatacoes.Formatacao;

public class Sms implements Notificacao {

    Calendar c = Calendar.getInstance();
    Date date  = c.getTime();
    DateFormat fData = DateFormat.getDateInstance(DateFormat.FULL);
    public void enviaNotificacao(String operacao, Double valor) {
        JOptionPane.showMessageDialog(null, "ENVIANDO UM SMS\n" + operacao + " NO VALOR DE: " + Formatacao.coversao(valor)  + "\nData: "+ fData.format(date));
        
    }
    
}
