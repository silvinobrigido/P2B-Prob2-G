package br.furb.programcaoii.problema2.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Observable;

/*
 * Esta classe oferece as funcionalidades básicas para atender ao Problema 2.
 */

/**
 *
 * @author marcel
 */
public class ContaCorrente extends Observable implements Serializable {
    
    private static final long serialVersionUID = 12312314L;
    
    private int numero;
    private int agencia;
    private Cliente cliente;
    private double saldo = 0;
    private List<Operacao> operacoes = new ArrayList<>();
    
    public ContaCorrente(int numero, int agencia) {
        this.setNumero(numero);
        this.setAgencia(agencia);
    }

    public String getChave(){
        return String.valueOf(agencia)+"-"+String.valueOf(numero);
    }
    
    public void sacar(double valor){
        if (valor > this.getSaldo()){
            throw new IllegalArgumentException("Saldo insuficiente para o saque");
        }
        Operacao oper = new Operacao(valor,this.getSaldo(),TipoOperacao.SAIDA,new Date(),this);
        adicionarOperacao(oper);
        this.saldo -= valor;
    }
    
    public void depositar(double valor){
        Operacao oper = new Operacao(valor,this.getSaldo(),TipoOperacao.ENTRADA,new Date(),this);
        adicionarOperacao(oper);
        this.saldo += valor;
    }    
    
    public void transferir(double valor, ContaCorrente destino){
        if (valor > this.getSaldo()){
            throw new IllegalArgumentException("Saldo insuficiente para transferência");
        }        
        destino.receberTransferencia(valor, this);
        Operacao oper = new OperacaoTransferencia(valor,this.getSaldo(),TipoOperacao.SAIDA,new Date(),this,destino);
        adicionarOperacao(oper);
        this.saldo -= valor;
    }   
    
    private void receberTransferencia(double valor, ContaCorrente origem){    
        Operacao oper = new OperacaoTransferencia(valor,this.getSaldo(),TipoOperacao.ENTRADA,new Date(),this,origem);
        adicionarOperacao(oper);
        this.saldo += valor;        
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    @Override
    public String toString(){
        return this.getChave();
    }
    
    protected void adicionarOperacao(Operacao operacao) {
        operacoes.add(operacao);
        
        setChanged();
        notifyObservers(operacao);
    }
    
    public List<Operacao> getOperacoes() {
        return new ArrayList<>(operacoes);
    }
}
