package br.furb.programcaoii.problema2.controller;

import br.furb.programcaoii.problema2.model.ContaCorrente;
import br.furb.programcaoii.problema2.dao.ContaCorrenteDAO;

/**
 *
 * @author ariel
 */
public class ContaCorrenteController extends Controller<ContaCorrente, ContaCorrenteDAO> {
    
    public ContaCorrenteController() {
        this.dao = new ContaCorrenteDAO();
    }
}
