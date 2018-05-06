package br.furb.programcaoii.problema2.dao;

import br.furb.programcaoii.problema2.classes.Cliente;
import br.furb.programcaoii.problema2.exception.RegistroNaoEncontradoException;
import java.util.Set;


/**
 *
 * @author ariel
 */
public class ClienteDAO extends CacheDAO<Cliente> {

    @Override
    public Cliente buscar(String campo) {
        Set<Cliente> clientes = getObjetosPersistidos();
        for (Object obj : clientes) {
            Cliente cliente = (Cliente) obj;
            
            if (cliente.getNome().contains(campo)) {
                return cliente;
            }
        }
        
        throw new RegistroNaoEncontradoException();
    }

    @Override
    public Class<Cliente> getEntityClass() {
        return Cliente.class;
    }
    
}
