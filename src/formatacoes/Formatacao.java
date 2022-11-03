package formatacoes;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;

public class Formatacao {
    static NumberFormat formato = new DecimalFormat("R$ #,#00.00");

    public static String coversao(Double real){
        return formato.format(real);
     
    }
    public static String format(String txt , String mascara)throws ParseException{
        MaskFormatter mf = new MaskFormatter(mascara);
        mf.setValueContainsLiteralCharacters(false);
        return mf.valueToString(txt);
  
    }

}
