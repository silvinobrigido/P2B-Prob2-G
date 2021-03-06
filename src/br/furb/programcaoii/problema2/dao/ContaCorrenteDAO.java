package br.furb.programcaoii.problema2.dao;

import br.furb.programcaoii.problema2.model.ContaCorrente;
import br.furb.programcaoii.problema2.exception.RegistroNaoEncontradoException;
import java.util.Set;

/**
 *
 * @author ariel
 */
public class ContaCorrenteDAO extends CacheDAO<ContaCorrente> {

    @Override
    public ContaCorrente buscar(String campo) {
        Set<ContaCorrente> contas = getObjetosPersistidos();
        for (ContaCorrente contaCorrente : contas) {
            
            if (contaCorrente.getChave().contains(campo)) {
                return contaCorrente;
            }
        }
        
        throw new RegistroNaoEncontradoException();
    }

    @Override
    public Class<ContaCorrente> getEntityClass() {
        return ContaCorrente.class;
    }
}
