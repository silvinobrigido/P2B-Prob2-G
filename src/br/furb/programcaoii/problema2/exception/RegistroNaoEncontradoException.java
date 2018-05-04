package br.furb.programcaoii.problema2.exception;

/**
 *
 * @author ariel
 */
public class RegistroNaoEncontradoException extends RuntimeException {
    
    public RegistroNaoEncontradoException() {
        super("Registro não encontrado!");
    }
}
