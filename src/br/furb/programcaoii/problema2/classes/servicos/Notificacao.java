/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.programcaoii.problema2.classes.servicos;

import br.furb.programcaoii.problema2.classes.Cliente;
import br.furb.programcaoii.problema2.classes.ClientePessoaFisica;
import br.furb.programcaoii.problema2.classes.ClientePessoaJuridica;
import br.furb.programcaoii.problema2.classes.ContaCorrente;

/**
 *
 * @author User
 */
public class Notificacao implements ContaObserver{
    
    private TipoNotificacao tipoNotificacao;
    private Cliente cliente;
    private String mensagem;

    public Notificacao(TipoNotificacao tipoNotificacao, Cliente c) {
        this.tipoNotificacao = tipoNotificacao;
        this.cliente = c;
    }
    
    @Override
    public void update(ContaCorrente conta) {
        //tratar as notificacoes no frame ou com o enum 
        mensagem = tipoNotificacao +" Operação realizada na conta " + conta.getChave() + " agencia " + conta.getAgencia() + ".\n" +
                "Para mais informações entre em contato.";        
        
    }

    @Override
    public String toString() {
        return mensagem; 
    }
    
    
}
