package br.furb.programcaoii.problema2.classes.servicos;

import br.furb.programcaoii.problema2.factory.ViewFactory;
import br.furb.programcaoii.problema2.view.ConsoleServicosView;
import java.util.Observer;

/**
 *
 * @author ariel
 */
public abstract class ContaCorrenteObserver implements Observer {

    protected void adicionarNotificacaoConsole() {
        ConsoleServicosView consoleServicosView = ViewFactory.getView(ConsoleServicosView.class);
        consoleServicosView.adicionarMensagem(toString());
    }
    
}
