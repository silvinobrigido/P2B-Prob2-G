package br.furb.programcaoii.problema2.classes.servicos;

import br.furb.programcaoii.problema2.classes.Cliente;
import br.furb.programcaoii.problema2.classes.ClientePessoaFisica;
import br.furb.programcaoii.problema2.classes.ClientePessoaJuridica;
import br.furb.programcaoii.problema2.classes.ContaCorrente;
import java.util.Observable;

/**
 *
 * @author User
 */
public class Notificacao extends ContaCorrenteObserver {
    
    private TipoNotificacao tipoNotificacao;
    private Cliente cliente;
    private String mensagem;

    
    public Notificacao(TipoNotificacao tipoNotificacao, Cliente c, ContaCorrente cc) {
        this.tipoNotificacao = tipoNotificacao;        
        this.cliente = c;
    }
    
     @Override
    public void update(Observable o, Object arg) {    
           if(arg instanceof ClientePessoaFisica){
               this.update((ContaCorrente) arg);
           }
           if(arg instanceof ClientePessoaJuridica){
               this.update((ContaCorrente) arg);
               if(tipoNotificacao == TipoNotificacao.JMS){
                   toString(TipoNotificacao.JMS);
               } else if(tipoNotificacao == TipoNotificacao.SMS){
                   toString(TipoNotificacao.JMS);
               }
           }
    }
    
    @Override
    public void update(ContaCorrente conta) {
        
        mensagem =" Operação realizada na conta " + conta.getChave() + " agencia " + conta.getAgencia() + ".\n" +
                "Para mais informações entre em contato.";        
        
    }
    public String toString(TipoNotificacao tipoNotificacao) {
        return mensagem + tipoNotificacao +"Mensagem" ; 
    }
    
    
}
