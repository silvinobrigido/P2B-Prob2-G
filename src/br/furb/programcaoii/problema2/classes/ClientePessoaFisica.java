package br.furb.programcaoii.problema2.classes;



/**
 *
 * @author marcel
 */
public class ClientePessoaFisica extends Cliente {
    
    private static final long serialVersionUID = 12312312L;
    
    private String cpf;

    public ClientePessoaFisica(String nome, String telCelular, String telFixo, String cpf) {
        super(nome, telCelular, telFixo);
        this.setCpf(cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
}
