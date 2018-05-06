package br.furb.programcaoii.problema2.util;

/**
 *
 * @author ariel
 */
public class Util {
    
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
    
}
