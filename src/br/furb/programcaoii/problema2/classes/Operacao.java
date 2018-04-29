package problema2;


import problema2.ContaCorrente;
import java.text.DateFormat;
import java.util.Date;


/**
 *
 * @author marcel
 */
public class Operacao {
    private double valor;
    private double saldoAnterior;
    private TipoOperacao tipo;
    private Date dataHora;
    private ContaCorrente conta;
    protected static final DateFormat df = DateFormat.getDateInstance();

    public Operacao(double valor, double saldoAnterior, TipoOperacao tipo, Date dataHora, ContaCorrente conta) {
        this.valor = valor;
        this.saldoAnterior = saldoAnterior;
        this.tipo = tipo;
        this.dataHora = dataHora;
        this.conta = conta;
    }

    
    public double getValor() {
        return valor;
    }

    public TipoOperacao getTipo(){
        return this.tipo;
    }

    public double getSaldoAnterior() {
        return saldoAnterior;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public ContaCorrente getConta() {
        return conta;
    }
    
    @Override
    public String toString(){
        return "Conta "+this.getConta().getChave()+": Operação de "+tipo+" no valor de "+valor+" em "+df.format(dataHora);
    }
    
}
