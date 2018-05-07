/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.programcaoii.problema2.view;

import br.furb.programcaoii.problema2.model.Cliente;
import br.furb.programcaoii.problema2.model.ContaCorrente;
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
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();

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

        jCheckBox1.setText("WhatsApp");

        jCheckBox2.setText("SMS");

        jCheckBox3.setText(" JMS (Java Message Service).");

        jLabel4.setText("Serviços de Notificação:");

        jLabel6.setText("Análise de Fluxo de Caixa:");

        jLabel7.setText("Baixa Automática de Investimento:");

        jLabel8.setText("Oferta de Financiamento:");

        jLabel9.setText("Análise de Investimento:");

        jCheckBox6.setText("Sim");

        jCheckBox7.setText("Sim");

        jCheckBox8.setText("Sim");

        jCheckBox9.setText("Sim");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNumero)
                    .addComponent(txtAgencia)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox2)
                                .addGap(10, 10, 10)
                                .addComponent(jCheckBox3))
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(51, 51, 51)
                                .addComponent(jCheckBox6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox9)
                                    .addComponent(jCheckBox8)
                                    .addComponent(jCheckBox7))))
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
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jCheckBox6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jCheckBox7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jCheckBox8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jCheckBox9))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSalvar)
                .addContainerGap())
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
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
