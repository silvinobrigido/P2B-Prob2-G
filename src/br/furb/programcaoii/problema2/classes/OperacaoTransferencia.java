package br.furb.programcaoii.problema2.classes;

import java.util.Date;

/**
 *
 * @author marcel
 */
public class OperacaoTransferencia extends Operacao {
    
    private static final long serialVersionUID = 12312317L;
    
    private ContaCorrente contraPartida;

    public OperacaoTransferencia(double valor, double saldoAnterior, TipoOperacao tipo, Date dataHora, ContaCorrente conta, ContaCorrente contraPartida) {
        super(valor, saldoAnterior, tipo, dataHora, conta);
        this.contraPartida = contraPartida;
    }

    public ContaCorrente getContraPartida() {
        return contraPartida;
    }
 
    @Override
    public String toString(){
        return "Conta "+this.getConta().getChave()+": Operação de Transferência: "+this.getTipo()
                +" no valor de "+this.getValor()+" em "+df.format(this.getDataHora())
                +" com a conta "+this.contraPartida.getChave();
    }    
}
