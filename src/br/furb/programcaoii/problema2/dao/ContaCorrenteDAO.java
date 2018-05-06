package br.furb.programcaoii.problema2.dao;

import br.furb.programcaoii.problema2.classes.ContaCorrente;
import br.furb.programcaoii.problema2.exception.RegistroNaoEncontradoException;
import java.util.Set;

/**
 *
 * @author ariel
 */
public class ContaCorrenteDAO extends DAO<ContaCorrente> {

    @Override
    public ContaCorrente buscar(String campo) {
        Set<Object> contas = getObjetosPersistidos();
        for (Object obj : contas) {
            ContaCorrente contaCorrente = (ContaCorrente) obj;
            
            if (String.valueOf(contaCorrente.getNumero()).contains(campo)) {
                return contaCorrente;
            }
        }
        
        throw new RegistroNaoEncontradoException();
    }
    
    @Override
    public Set<Object> getObjetosPersistidos() {
        return CacheDAO.getObjetosPersistidos(ContaCorrente.class);
    }
}
