package br.furb.programcaoii.problema2.controller;

import br.furb.programcaoii.problema2.model.Cliente;
import br.furb.programcaoii.problema2.model.ClientePessoaFisica;
import br.furb.programcaoii.problema2.model.ClientePessoaJuridica;
import br.furb.programcaoii.problema2.dao.ClienteDAO;
import br.furb.programcaoii.problema2.factory.ControllerFactory;
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
    
    @Override
    public void excluir(Cliente obj) {
        ControllerFactory.getController(ContaCorrenteController.class).excluirContasCorrentePorCliente(obj);
        super.excluir(obj);
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

    public void salvar(Cliente cliente, String nome, String telefoneCelular, String telefoneFixo, String cpfCnpj, String servidorJms, boolean pessoaFisica, boolean pessoaJuridica) {
        validarTipoPessoa(pessoaFisica, pessoaJuridica);
        
        if (null == cliente) {
            cliente = instanciarCliente(pessoaFisica, pessoaJuridica);
        }
        
        popularCliente(cliente, nome, telefoneCelular, telefoneFixo, cpfCnpj, servidorJms);
        
        salvar(cliente);
    }

    private void popularCliente(Cliente cliente, String nome, String telefoneCelular, String telefoneFixo, String cpfCnpj, String servidorJms) {
        cliente.setNome(nome);
        cliente.setTelCelular(telefoneCelular);
        cliente.setTelFixo(telefoneFixo);
        
        if (cliente instanceof ClientePessoaFisica) {
            ((ClientePessoaFisica) cliente).setCpf(cpfCnpj);
        } else {
            ((ClientePessoaJuridica) cliente).setCnpj(cpfCnpj);
            ((ClientePessoaJuridica) cliente).setServidorJMS(servidorJms);
        }
    }

    private void validarTipoPessoa(boolean pessoaFisica, boolean pessoaJuridica) {
        if (!pessoaFisica && !pessoaJuridica) {
            throw new IllegalArgumentException("Selecione um tipo de pessoa!");
        }
    }

    private Cliente instanciarCliente(boolean pessoaFisica, boolean pessoaJuridica) {
        if (pessoaFisica) {
            return new ClientePessoaFisica(null, null, null, null);
        } else if (pessoaJuridica) {
            return new ClientePessoaJuridica(null, null, null, null, null);
        }
        return null;
    }
}
