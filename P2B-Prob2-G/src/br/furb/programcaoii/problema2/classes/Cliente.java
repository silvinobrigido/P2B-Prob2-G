package problema2;

/*
 * Esta classe oferece as funcionalidades básicas para atender ao Problema 2.
 */

import java.util.HashMap;


/**
 *
 * @author marcel
 */
public abstract class Cliente {
    private String nome;
    private String telCelular;
    private String telFixo;
    private HashMap<String,ContaCorrente> contas;

    public Cliente(String nome, String telCelular, String telFixo) {
        this.setNome(nome);
        this.setTelCelular(telCelular);
        this.setTelFixo(telFixo);
        this.contas = new HashMap();
    }

    public void addConta(ContaCorrente cc){
        String chave = cc.getChave();
        if (this.contas.containsKey(chave)){
            throw new IllegalArgumentException("Já existe conta corrente com este número/agência");
        }
        else {
            this.contas.put(chave,cc);
            cc.setCliente(this);
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public String getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(String telFixo) {
        this.telFixo = telFixo;
    }
    
    
    
}
