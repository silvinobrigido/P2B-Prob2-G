package br.furb.programcaoii.problema2.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ariel
 */
public class CacheDAO<O extends Object> {
    
    private static final Map<String, Set<Object>> map = new HashMap<>();
    
    public static <O extends Object> Set<Object> getObjetosPersistidos(Class<O> clazz) {
        String nomeClasse = getNomeClasse(clazz);
        Set<Object> objetos = map.get(nomeClasse);
        
        if (null == objetos) {
            objetos = new HashSet<>();
            map.put(nomeClasse, objetos);
        }
        
        return objetos;
    }
    
    private static <O extends Object> String getNomeClasse(Class<O> clazz) {
        return clazz.getName();
    }
}
