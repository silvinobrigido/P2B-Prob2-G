package br.furb.programcaoii.problema2.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ariel
 */
public interface View<O extends Object> {
    
    void setEntidade(O entidade);
    
    default void abrirDialogoErro(JFrame frame, Exception e) {
        JOptionPane.showMessageDialog(frame,
                                        e.getMessage(),
                                        "Erro",
                                        JOptionPane.ERROR_MESSAGE);
    }
}
