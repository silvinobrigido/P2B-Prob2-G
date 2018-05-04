package br.furb.programcaoii.problema2.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ariel
 */
public abstract class DAO<O extends Object> {
    
    public void salvar(O obj) {
        Set<Object> objetos = getObjetosPersistidos();
        
        objetos.add(obj);
    }
    
    public void excluir(O obj) {
        Set<Object> objetos = getObjetosPersistidos();
        
        objetos.remove(obj);
    }
    
    public abstract O buscar(String campo);
    
    public abstract Set<Object> getObjetosPersistidos();
}
