/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.programcaoii.problema2.view;

import br.furb.programcaoii.problema2.classes.Cliente;
import br.furb.programcaoii.problema2.classes.ContaCorrente;
import br.furb.programcaoii.problema2.controller.ClienteController;
import br.furb.programcaoii.problema2.controller.ContaCorrenteController;
import br.furb.programcaoii.problema2.factory.ControllerFactory;
import br.furb.programcaoii.problema2.util.Util;
import java.text.ParseException;
import java.util.Set;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author ariel
 */
public class ContaView extends javax.swing.JFrame implements View<ContaCorrente> {

    private ContaCorrente contaCorrente;
    private MaskFormatter mascaraNumero = null;
    private MaskFormatter mascaraAgencia = null;
    private MaskFormatter mascaraSaldo = null;
    
    
    /**
     * Creates new form ClienteView
     */
    public ContaView() {
        initComponents();

        try {
            // criando máscaras
            mascaraNumero = new MaskFormatter("#######-#");
            mascaraAgencia = new MaskFormatter("####-#");

        } catch (ParseException exc) {
        }

        mascaraNumero.install(txtNumero);
        mascaraAgencia.install(txtAgencia);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbCliente = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        txtNumero = new javax.swing.JFormattedTextField();
        txtAgencia = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Cliente");

        jLabel2.setText("Número");

        jLabel3.setText("Agência");

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(txtNumero)
                    .addComponent(txtAgencia)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        try {
            Integer conta = Util.castInt(txtNumero.getText().replaceAll("[,.-]", ""));
            Integer agencia = Util.castInt(txtAgencia.getText().replaceAll("[,.-]", ""));
            Cliente cliente = ControllerFactory.getController(ClienteController.class).buscar((String) cbCliente.getSelectedItem());

            if (null == contaCorrente) {
                contaCorrente = new ContaCorrente(conta, agencia);
                contaCorrente.setCliente(cliente);
            }
            contaCorrente.setAgencia(agencia);
            contaCorrente.setNumero(conta);

            ControllerFactory.getController(ContaCorrenteController.class).salvar(contaCorrente);
            this.setVisible(false);
        } catch (Exception e) {
            abrirDialogoErro(this, e);
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        atualizarClientes();
    }//GEN-LAST:event_formWindowActivated

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JFormattedTextField txtAgencia;
    private javax.swing.JFormattedTextField txtNumero;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setEntidade(ContaCorrente entidade) {
        this.contaCorrente = entidade;
        
        cbCliente.setSelectedItem(contaCorrente.getCliente().getNome());
        txtAgencia.setText(String.valueOf(contaCorrente.getAgencia()));
        txtNumero.setText(String.valueOf(contaCorrente.getNumero()));
        
        txtAgencia.setEditable(false);
        txtNumero.setEditable(false);
    }

    private void atualizarClientes() {
        cbCliente.removeAllItems();
        
        Set<Cliente> clientes = ControllerFactory.getController(ClienteController.class).getObjetosPersistidos();
        clientes.stream().map(obj -> (Cliente) obj).filter(cliente -> null != cliente.getNome() && !cliente.getNome().isEmpty()).forEach(cliente -> cbCliente.addItem(cliente.getNome()));
    }
}
