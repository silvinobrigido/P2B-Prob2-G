package br.furb.programcaoii.problema2.classes.servicos;

import br.furb.programcaoii.problema2.classes.ContaCorrente;
import java.util.Observable;

public class BaixaAutomatica implements ContaObserver {
    private Observable contaObservable;

    public BaixaAutomatica(Observable conta) {
        this.contaObservable = conta;
        this.contaObservable.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {    
           if(arg instanceof ContaCorrente){
               this.update((ContaCorrente) arg);
           }
    }
    /*Mais detalhes em https://www.devmedia.com.br/padrao-de-projeto-observer-em-java/26163*/

    @Override
    public void update(ContaCorrente conta) {
        System.out.println("Realizada baixa automática na Conta: "+ conta.getChave() +", Cliente "+ conta.getCliente());
    }
}
