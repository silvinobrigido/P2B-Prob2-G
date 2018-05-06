package br.furb.programcaoii.problema2.dao;

import java.util.Set;

/**
 *
 * @author ariel
 * @param <O>
 */
public interface DAO<O extends Object> {
    
    void salvar(O obj);
    
    void excluir(O obj);
    
    O buscar(String campo);
    
    Set<O> getObjetosPersistidos();
}
