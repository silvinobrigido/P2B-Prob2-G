package br.furb.programcaoii.problema2.controller;

import br.furb.programcaoii.problema2.model.ContaCorrente;
import br.furb.programcaoii.problema2.dao.ContaCorrenteDAO;
import br.furb.programcaoii.problema2.factory.ControllerFactory;
import br.furb.programcaoii.problema2.model.Cliente;
import br.furb.programcaoii.problema2.model.servicos.AnaliseFluxoCaixa;
import br.furb.programcaoii.problema2.model.servicos.AnaliseInvestimento;
import br.furb.programcaoii.problema2.model.servicos.BaixaAutomatica;
import br.furb.programcaoii.problema2.model.servicos.Notificacao;
import br.furb.programcaoii.problema2.model.servicos.OfertaFinanciamento;
import br.furb.programcaoii.problema2.model.servicos.TipoNotificacao;
import br.furb.programcaoii.problema2.util.Util;
import java.util.Set;

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

    public void salvar(ContaCorrente contaCorrente, Cliente cliente, String numeroStr, String agenciaStr, boolean notificacaoWhatsapp, boolean notificacaoSms, boolean notificacaoJms, boolean analiseFluxoCaixa, boolean analiseInvestimento, boolean baixaAutomaticaInvestimento, boolean ofertaFinanciamento) {
        if (null == contaCorrente) {
            Integer numero = Util.castInt(numeroStr.replaceAll("[,.-]", ""));
            Integer agencia = Util.castInt(agenciaStr.replaceAll("[,.-]", ""));
            
            contaCorrente = instanciarContaCorrente(numero, agencia, cliente);
        }
        definirServicos(contaCorrente, notificacaoWhatsapp, notificacaoSms, notificacaoJms, analiseFluxoCaixa, analiseInvestimento, baixaAutomaticaInvestimento, ofertaFinanciamento);
        
        salvar(contaCorrente);
    }

    private ContaCorrente instanciarContaCorrente(Integer numero, Integer agencia, Cliente cliente) {
        validarCliente(cliente);
        validarNumeroAgencia(numero, agencia);
        
        ContaCorrente contaCorrente = new ContaCorrente(numero, agencia);
        contaCorrente.setCliente(cliente);
        cliente.addConta(contaCorrente);
        
        return contaCorrente;
    }

    private void validarCliente(Cliente cliente) {
        if (null == cliente) {
            throw new IllegalArgumentException("Cliente não informado!");
        }
    }

    private void validarNumeroAgencia(Integer numero, Integer agencia) {
        if (null == numero) {
            throw new IllegalArgumentException("Número não informado ou inválido!");
        }
        
        if (null == agencia) {
            throw new IllegalArgumentException("Agência não informada ou inválida!");
        }
    }

    private void definirServicos(ContaCorrente contaCorrente, boolean notificacaoWhatsapp, boolean notificacaoSms, boolean notificacaoJms, boolean analiseFluxoCaixa, boolean analiseInvestimento, boolean baixaAutomaticaInvestimento, boolean ofertaFinanciamento) {
        contaCorrente.deleteObservers();
        
        definirServicoNotificacaoWhatsapp(contaCorrente, notificacaoWhatsapp);
        definirServicoNotificacaoSms(contaCorrente, notificacaoSms);
        definirServicoNotificacaoJms(contaCorrente, notificacaoJms);
        
        definirServicoAnaliseFluxoCaixa(contaCorrente, analiseFluxoCaixa);
        definirServicoAnaliseInvestimento(contaCorrente, analiseInvestimento);
        definirServicoBaixaAutomaticaInvestimento(contaCorrente, baixaAutomaticaInvestimento);
        definirServicoOfertaFinanciamento(contaCorrente, ofertaFinanciamento);
    }

    private void definirServicoNotificacaoWhatsapp(ContaCorrente contaCorrente, boolean notificacaoWhatsapp) {
        if (notificacaoWhatsapp) {
            contaCorrente.addObserver(new Notificacao(TipoNotificacao.WHATSAPP));
        }
    }

    private void definirServicoNotificacaoSms(ContaCorrente contaCorrente, boolean notificacaoSms) {
        if (notificacaoSms) {
            contaCorrente.addObserver(new Notificacao(TipoNotificacao.SMS));
        }
    }

    private void definirServicoNotificacaoJms(ContaCorrente contaCorrente, boolean notificacaoJms) {
        if (notificacaoJms) {
            contaCorrente.addObserver(new Notificacao(TipoNotificacao.JMS));
        }
    }

    private void definirServicoAnaliseFluxoCaixa(ContaCorrente contaCorrente, boolean analiseFluxoCaixa) {
        if (analiseFluxoCaixa) {
            contaCorrente.addObserver(new AnaliseFluxoCaixa());
        }
    }

    private void definirServicoAnaliseInvestimento(ContaCorrente contaCorrente, boolean analiseInvestimento) {
        if (analiseInvestimento) {
            contaCorrente.addObserver(new AnaliseInvestimento());
        }
    }

    private void definirServicoBaixaAutomaticaInvestimento(ContaCorrente contaCorrente, boolean baixaAutomaticaInvestimento) {
        if (baixaAutomaticaInvestimento) {
            contaCorrente.addObserver(new BaixaAutomatica());
        }
    }

    private void definirServicoOfertaFinanciamento(ContaCorrente contaCorrente, boolean ofertaFinanciamento) {
        if (ofertaFinanciamento) {
            contaCorrente.addObserver(new OfertaFinanciamento());
        }
    }

    public void excluirContasCorrentePorCliente(Cliente obj) {
        Set<ContaCorrente> contasCorrente = getObjetosPersistidos();
        contasCorrente.stream().filter(cc -> obj.equals(cc.getCliente())).forEach(cc -> excluir(cc));
    }
    
    public ContaCorrente getContaCorrente(String nomeCliente, Integer numero, Integer agencia) {
        Cliente cliente = ControllerFactory.getController(ClienteController.class).buscar(nomeCliente);
        
        if (null != cliente) {
            Set<ContaCorrente> contasCorrente = getObjetosPersistidos();
            for (ContaCorrente contaCorrente : contasCorrente) {
                if (contaCorrente.getCliente().equals(cliente) && numero.equals(contaCorrente.getNumero()) && agencia.equals(contaCorrente.getAgencia())) {
                    return contaCorrente;
                }
            }
        }
            
        return null;
    }
}
