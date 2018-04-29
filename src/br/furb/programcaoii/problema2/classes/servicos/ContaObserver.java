/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.programcaoii.problema2.classes.servicos;
import br.furb.programcaoii.problema2.classes.ContaCorrente;
import java.util.Observable;
import java.util.Observer;
/**
 *
 * @author User
 */
public interface ContaObserver extends Observer{
    //teste 
     @Override
     public default void update(Observable observable, Object o) {        
     }
     public void update(ContaCorrente conta);
     
}
