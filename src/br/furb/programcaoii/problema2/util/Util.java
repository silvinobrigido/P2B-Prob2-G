package br.furb.programcaoii.problema2.util;

import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author ariel
 */
public class Util {
    
    private static final DateFormat df = DateFormat.getDateInstance();
    
    public static Integer castInt(String numero) {
        try {
            return Integer.valueOf(numero);
        } catch (Exception e) {
            return null;
        }
    }

    public static Double castDouble(String numero) {
        try {
            return Double.valueOf(numero);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static String castDateToString(Date date) {
        return df.format(date);
    }
    
}
