/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

/**
 *
 * @author esteban
 */


        
public class interfaz extends javax.swing.JFrame {

    /**
     * Creates new form interfaz
     */
    public interfaz() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        regClientes = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        infoCliente = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );

        jMenu1.setText("Inicio");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Registros");

        regClientes.setText("Registrar Cliente");
        regClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regClientesActionPerformed(evt);
            }
        });
        jMenu2.add(regClientes);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Consultas");

        infoCliente.setText("Informacion Cliente");
        infoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoClienteActionPerformed(evt);
            }
        });
        jMenu3.add(infoCliente);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regClientesActionPerformed
        RegistrarCliente ventanaRegCliente = new RegistrarCliente();
        ventanaRegCliente.setVisible(true);
    }//GEN-LAST:event_regClientesActionPerformed

    private void infoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoClienteActionPerformed
        InfoCliente ventanaInfoCliente = new InfoCliente();
        ventanaInfoCliente.setVisible(true);
    }//GEN-LAST:event_infoClienteActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem infoCliente;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem regClientes;
    // End of variables declaration//GEN-END:variables
}
