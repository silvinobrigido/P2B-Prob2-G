package br.furb.programcaoii.problema2.model.servicos;

import br.furb.programcaoii.problema2.model.ContaCorrente;
import br.furb.programcaoii.problema2.model.Operacao;
import java.util.Observable;

/**
 *
 * @author User
 */
public class Notificacao extends ContaCorrenteObserver {
    
    private static final long serialVersionUID = 12312322L;
    
    private final TipoNotificacao tipoNotificacao;

    public Notificacao(TipoNotificacao tipoNotificacao) {
        this.tipoNotificacao = tipoNotificacao;
    }
    
    @Override
    public void update(ContaCorrente contaCorrente, Operacao operacao) {
        StringBuilder sb = new StringBuilder();

        sb.append("Notificação - [");
        sb.append(tipoNotificacao);
        sb.append("] ");
        sb.append(operacao.toString());

        adicionarNotificacaoConsole(sb.toString());
    }

}
