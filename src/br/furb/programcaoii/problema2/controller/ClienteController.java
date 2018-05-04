package br.furb.programcaoii.problema2.controller;

import br.furb.programcaoii.problema2.classes.Cliente;
import br.furb.programcaoii.problema2.classes.ClientePessoaFisica;
import br.furb.programcaoii.problema2.classes.ClientePessoaJuridica;
import br.furb.programcaoii.problema2.dao.ClienteDAO;
import br.furb.programcaoii.problema2.dao.DAO;
import com.sun.xml.internal.fastinfoset.stax.events.Util;

/**
 *
 * @author ariel
 */
public class ClienteController extends Controller<Cliente, ClienteDAO> {
    
    public ClienteController() {
        this.dao = new ClienteDAO();
    }
    
    @Override
    public void salvar(Cliente obj) {
        validarPessoa(obj);
        
        super.salvar(obj);
    }

    private void validarPessoa(Cliente obj) {
        if (Util.isEmptyString(obj.getNome())) {
            throw new RuntimeException("Nome não preenchido");
        }
        
        if (obj instanceof ClientePessoaFisica) {
            if (Util.isEmptyString(((ClientePessoaFisica) obj).getCpf())) {
                throw new RuntimeException("CPF não preenchido");
            }
        } else if (obj instanceof ClientePessoaJuridica) {
            if (Util.isEmptyString(((ClientePessoaJuridica) obj).getCnpj())) {
                throw new RuntimeException("CNPJ não preenchido");
            }
        }
    }
}
