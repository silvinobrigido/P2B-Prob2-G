package br.furb.programcaoii.problema2.controller;

import br.furb.programcaoii.problema2.model.ContaCorrente;
import br.furb.programcaoii.problema2.dao.ContaCorrenteDAO;
import br.furb.programcaoii.problema2.util.Util;

/**
 *
 * @author ariel
 */
public class ContaCorrenteController extends Controller<ContaCorrente, ContaCorrenteDAO> {
    
    public ContaCorrenteController() {
        this.dao = new ContaCorrenteDAO();
    }

    public void sacar(ContaCorrente contaCorrente, String valorStr) {
        Double valorSaque = Util.castDouble(valorStr);
        validarConta(contaCorrente);
        validarValor(valorSaque);
        
        contaCorrente.sacar(valorSaque);
    }

    public void depositar(ContaCorrente contaCorrente, String valorStr) {
        Double valorDeposito = Util.castDouble(valorStr);
        validarConta(contaCorrente);
        validarValor(valorDeposito);
        
        contaCorrente.depositar(valorDeposito);
    }

    public void transferir(ContaCorrente contaCorrente, ContaCorrente contaCorrenteTransferencia, String valorStr) {
        Double valorTransferencia = Util.castDouble(valorStr);
        validarConta(contaCorrente);
        validarContaTransferencia(contaCorrenteTransferencia, contaCorrente);
        
        contaCorrente.transferir(valorTransferencia, contaCorrenteTransferencia);
    }

    private void validarConta(ContaCorrente contaCorrente) {
        if (null == contaCorrente) {
            throw new IllegalArgumentException("Conta corrente não informada!");
        }
    }
    
    private void validarValor(Double valor) {
        if (null == valor) {
            throw new IllegalArgumentException("Valor inválido!");
        }
    }

    private void validarContaTransferencia(ContaCorrente contaCorrenteTransferencia, ContaCorrente contaCorrente) {
        if (null == contaCorrenteTransferencia) {
            throw new IllegalArgumentException("Conta corrente de transferência não informada!");
        }
        
        if (contaCorrenteTransferencia.equals(contaCorrente)) {
            throw new IllegalArgumentException("Conta corrente de transferência é a mesma conta corrente!");
        }
    }
}
