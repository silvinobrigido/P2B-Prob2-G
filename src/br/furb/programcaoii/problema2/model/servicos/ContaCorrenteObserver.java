package br.furb.programcaoii.problema2.model.servicos;

import br.furb.programcaoii.problema2.model.ContaCorrente;
import br.furb.programcaoii.problema2.model.Operacao;
import br.furb.programcaoii.problema2.factory.ViewFactory;
import br.furb.programcaoii.problema2.view.ConsoleServicosView;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author ariel
 */
public abstract class ContaCorrenteObserver implements Observer, Serializable {

    private static final long serialVersionUID = 12312321L;
    
    protected void adicionarNotificacaoConsole(String mensagem) {
        ConsoleServicosView consoleServicosView = ViewFactory.getView(ConsoleServicosView.class);
        consoleServicosView.adicionarMensagem(mensagem);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ContaCorrente && arg instanceof Operacao) {
            ContaCorrente contaCorrente = (ContaCorrente) o;
            Operacao operacao = (Operacao) arg;
            
            update(contaCorrente, operacao);
        }
    }
    
    public abstract void update(ContaCorrente contaCorrente, Operacao operacao);
    
}
