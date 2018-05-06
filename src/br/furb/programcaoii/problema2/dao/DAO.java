package br.furb.programcaoii.problema2.dao;

import java.util.Set;

/**
 *
 * @author ariel
 * @param <O>
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
