package br.furb.programcaoii.problema2.model.servicos;

import br.furb.programcaoii.problema2.model.ContaCorrente;
import br.furb.programcaoii.problema2.model.Operacao;
import br.furb.programcaoii.problema2.model.TipoOperacao;
import java.util.Observable;

/**
 * 
 * @author ariel
 */
public class BaixaAutomatica extends ContaCorrenteObserver {
    
    private static final long serialVersionUID = 12312323L;

    @Override
    public void update(ContaCorrente contaCorrente, Operacao operacao) {    
        if (Operacao.class.equals(operacao.getClass())) {
            
            if (TipoOperacao.SAIDA.equals(operacao.getTipo())) {
                StringBuilder sb = new StringBuilder();
                
                sb.append("Baixa automática de investimento - Conta [");
                sb.append(contaCorrente.getChave());
                sb.append("] Cliente [");
                sb.append(contaCorrente.getCliente().getNome());
                sb.append("]");
                
                adicionarNotificacaoConsole(sb.toString());
            }
        }
    }

}
