package br.furb.programcaoii.problema2.view;

import br.furb.programcaoii.problema2.model.Cliente;
import br.furb.programcaoii.problema2.model.ClientePessoaFisica;
import br.furb.programcaoii.problema2.controller.ContaCorrenteController;
import br.furb.programcaoii.problema2.factory.ControllerFactory;
import br.furb.programcaoii.problema2.model.ContaCorrente;
import br.furb.programcaoii.problema2.model.Operacao;
import br.furb.programcaoii.problema2.model.OperacaoTransferencia;
import br.furb.programcaoii.problema2.model.TipoOperacao;
import br.furb.programcaoii.problema2.util.Util;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ariel
 */
public class OperacoesView extends javax.swing.JFrame implements View<Cliente> {

    /**
     * Creates new form ClientesView
     */
    public OperacoesView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbContasCorrente = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableConsulta = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtValorSaque = new javax.swing.JTextField();
        btSacar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtValorDeposito = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btDepositar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtValorTransferencia = new javax.swing.JTextField();
        btTransferencia = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbContasCorrenteTransferencia = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fast_money_business-48.png"))); // NOI18N
        jLabel1.setText("FastMoney");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Operações");

        jLabel3.setText("Conta Corrente");

        cbContasCorrente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbContasCorrenteItemStateChanged(evt);
            }
        });

        tableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Data", "Tipo", "Operação", "Conta destino", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableConsulta);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Consulta", jPanel1);

        jLabel5.setText("Valor saque");

        btSacar.setText("Sacar");
        btSacar.setToolTipText("");
        btSacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSacarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtValorSaque)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 568, Short.MAX_VALUE))
                    .addComponent(btSacar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorSaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                .addComponent(btSacar)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Saque", jPanel2);

        jLabel6.setText("Valor depósito");

        btDepositar.setText("Depositar");
        btDepositar.setToolTipText("");
        btDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDepositarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtValorDeposito)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 549, Short.MAX_VALUE))
                    .addComponent(btDepositar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                .addComponent(btDepositar)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Depósito", jPanel3);

        jLabel7.setText("Valor transferência");

        btTransferencia.setToolTipText("");
        btTransferencia.setLabel("Transferir");
        btTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTransferenciaActionPerformed(evt);
            }
        });

        jLabel8.setText("Conta transferência");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btTransferencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbContasCorrenteTransferencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtValorTransferencia)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(0, 510, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbContasCorrenteTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addComponent(btTransferencia)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Transferência", jPanel4);

        jLabel4.setText("Saldo");

        txtSaldo.setEditable(false);
        txtSaldo.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbContasCorrente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbContasCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Consulta");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        atualizarContasCorrente();
        atualizarConsulta();
    }//GEN-LAST:event_formWindowActivated

    private void cbContasCorrenteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbContasCorrenteItemStateChanged
        atualizarConsulta();
    }//GEN-LAST:event_cbContasCorrenteItemStateChanged

    private void btSacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSacarActionPerformed
        ContaCorrente contaCorrente = getContaCorrenteSelecionada();
        ControllerFactory.getController(ContaCorrenteController.class).sacar(contaCorrente, txtValorSaque.getText());
        
        atualizarConsulta();
    }//GEN-LAST:event_btSacarActionPerformed

    private void btDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDepositarActionPerformed
        ContaCorrente contaCorrente = getContaCorrenteSelecionada();
        ControllerFactory.getController(ContaCorrenteController.class).depositar(contaCorrente, txtValorDeposito.getText());
        
        atualizarConsulta();
    }//GEN-LAST:event_btDepositarActionPerformed

    private void btTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTransferenciaActionPerformed
        ContaCorrente contaCorrente = getContaCorrenteSelecionada();
        ContaCorrente contaCorrenteTransferencia = getContaCorrenteTransferenciaSelecionada();
        ControllerFactory.getController(ContaCorrenteController.class).transferir(contaCorrente, contaCorrenteTransferencia, txtValorTransferencia.getText());
        
        atualizarConsulta();
    }//GEN-LAST:event_btTransferenciaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDepositar;
    private javax.swing.JButton btSacar;
    private javax.swing.JButton btTransferencia;
    private javax.swing.JComboBox<ContaCorrente> cbContasCorrente;
    private javax.swing.JComboBox<ContaCorrente> cbContasCorrenteTransferencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tableConsulta;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtValorDeposito;
    private javax.swing.JTextField txtValorSaque;
    private javax.swing.JTextField txtValorTransferencia;
    // End of variables declaration//GEN-END:variables

    private ContaCorrente getContaCorrenteSelecionada() {
        return (ContaCorrente) cbContasCorrente.getSelectedItem();
    }
    
    private ContaCorrente getContaCorrenteTransferenciaSelecionada() {
        return (ContaCorrente) cbContasCorrenteTransferencia.getSelectedItem();
    }

    private void atualizarConsulta() {
        ContaCorrente contaCorrente = getContaCorrenteSelecionada();
        txtSaldo.setText("R$ ".concat(String.valueOf(contaCorrente.getSaldo()).replaceAll("[.]", ",")));

        DefaultTableModel model = (DefaultTableModel) tableConsulta.getModel();   
        while (model.getRowCount() > 0){
            model.removeRow(0);
        }
        
        for (Operacao operacao : contaCorrente.getOperacoes()) {
            String data = Util.castDateToString(operacao.getDataHora());
            String tipo = TipoOperacao.ENTRADA.equals(operacao.getTipo()) ? "Entrada" : "Saída";
            String valor = "R$ ".concat(String.valueOf(operacao.getValor()).replaceAll("[.]", ","));
            String operacaoStr = operacao instanceof OperacaoTransferencia ? "Transferência" : "Operação";
            String contaDestino = operacao instanceof OperacaoTransferencia ? ((OperacaoTransferencia) operacao).getContraPartida().getChave() : "";
            
            model.addRow(new Object[]{data, tipo, operacaoStr, contaDestino, valor});
        }
    }

    @Override
    public void setEntidade(Cliente entidade) {
    }

    private void atualizarContasCorrente() {
        cbContasCorrente.removeAllItems();
        cbContasCorrenteTransferencia.removeAllItems();
        
        Set<ContaCorrente> contasCorrente = ControllerFactory.getController(ContaCorrenteController.class).getObjetosPersistidos();
        
        contasCorrente.forEach(contaCorrente -> {
            cbContasCorrente.addItem(contaCorrente);
            cbContasCorrenteTransferencia.addItem(contaCorrente);
        });
    }
}
