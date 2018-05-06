package br.furb.programcaoii.problema2.controller;

import br.furb.programcaoii.problema2.dao.DAO;
import java.util.Set;

/**
 *
 * @author ariel
 * @param <O>
 * @param <D>
 */
public abstract class Controller<O extends Object, D extends DAO<O>> {
    
    protected DAO<O> dao;
    
    public void salvar(O obj) {
        dao.salvar(obj);
    }
    
    public void excluir(O obj) {
        dao.excluir(obj);
    }
    
    public O buscar(String campo) {
        return dao.buscar(campo);
    }
    
    public Set<Object> getObjetosPersistidos() {
        return dao.getObjetosPersistidos();
    }
}
