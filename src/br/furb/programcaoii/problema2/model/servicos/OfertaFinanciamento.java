package br.furb.programcaoii.problema2.model.servicos;

import br.furb.programcaoii.problema2.model.ContaCorrente;
import br.furb.programcaoii.problema2.model.Operacao;
import br.furb.programcaoii.problema2.model.TipoOperacao;

/**
 *
 * @author ariel
 */
public class OfertaFinanciamento extends ContaCorrenteObserver {

    @Override
    public void update(ContaCorrente contaCorrente, Operacao operacao) {
        if (TipoOperacao.SAIDA.equals(operacao.getTipo())) {
            StringBuilder sb = new StringBuilder();

            sb.append("Oferta de financiamento - Conta [");
            sb.append(contaCorrente.getChave());
            sb.append("] Cliente [");
            sb.append(contaCorrente.getCliente().getNome());
            sb.append("]");

            adicionarNotificacaoConsole(sb.toString());
        }
    }
    
}
