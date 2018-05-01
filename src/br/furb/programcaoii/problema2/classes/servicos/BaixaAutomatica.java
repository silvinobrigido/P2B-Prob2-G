/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.programcaoii.problema2.classes.servicos;

import br.furb.programcaoii.problema2.classes.ContaCorrente;
import java.util.Observable;
import java.util.Observer;


public class BaixaAutomatica implements ContaObserver {
    Observable conta;

    public BaixaAutomatica(Observable conta) {
        this.conta = conta;
        conta.addObserver(this);
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
        System.out.println("Realizada baixa automática na Conta: "+ conta.getChave());
    }
}
