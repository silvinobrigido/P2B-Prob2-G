/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.programcaoii.problema2.classes.servicos;

import br.furb.programcaoii.problema2.classes.ContaCorrente;
import java.util.Observable;

/**
 *
 * @author silvinos
 */
public class AnaliseFluxoCaixa implements ContaObserver{

     private Observable contaObservable;

    public AnaliseFluxoCaixa(Observable contaObservable) {
        this.contaObservable = contaObservable;
        this.contaObservable.addObserver(this);        
    }
    
    @Override
    public void update(Observable o, Object arg) {    
           if(arg instanceof ContaCorrente){
               this.update((ContaCorrente) arg);
           }
    }
    
    @Override
    public void update(ContaCorrente conta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String toString(ContaCorrente cc) {
        return "Cliente " +"Cliente " + cc.getChave() + "- Serviço de Análise de Fluxo de Caixa"; 
    }
}
