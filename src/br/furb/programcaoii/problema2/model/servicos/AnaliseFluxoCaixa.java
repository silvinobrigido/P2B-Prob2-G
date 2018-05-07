package br.furb.programcaoii.problema2.model.servicos;

import br.furb.programcaoii.problema2.model.ContaCorrente;
import br.furb.programcaoii.problema2.model.Operacao;

/**
 *
 * @author silvinos
 */
public class AnaliseFluxoCaixa extends ContaCorrenteObserver {
    
    @Override
    public void update(ContaCorrente contaCorrente, Operacao operacao) {    
        StringBuilder sb = new StringBuilder();

        sb.append("Análise do fluxo de caixa - ");
        sb.append(operacao.toString());

        adicionarNotificacaoConsole(sb.toString());
    }

}
