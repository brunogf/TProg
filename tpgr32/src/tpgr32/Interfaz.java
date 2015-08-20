/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpgr32;

/**
 *
 * @author Nicolás Rostán
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
	initComponents();
	setLocationRelativeTo(null); //Centra el MainFrame en la pantalla
	PanelCentral.removeAll();
	PanelCentral.repaint();
	PanelCentral.revalidate(); //HACE QUE NO SE VEA NADA AL ABRIR EL PROGRAMA
	
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCentral = new javax.swing.JPanel();
        RegistrarUsuarioFrame = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        RegUsuarioNicknameLabel = new javax.swing.JLabel();
        RegUsuarioNombreLabel = new javax.swing.JLabel();
        RegUsuarioApellidoLabel = new javax.swing.JLabel();
        RegUsuarioCorreoLabel = new javax.swing.JLabel();
        RegUsuarioFechaLabel = new javax.swing.JLabel();
        RegUsuarioSeleccionarImagenButton = new javax.swing.JButton();
        BarraMenu = new javax.swing.JMenuBar();
        MenuInicio = new javax.swing.JMenu();
        MenuRegistros = new javax.swing.JMenu();
        MenuRegistrarUsuario = new javax.swing.JMenuItem();
        MenuConsultas = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tarea 1");
        setLocation(new java.awt.Point(0, 0));
        setPreferredSize(new java.awt.Dimension(450, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(450, 550));

        PanelCentral.setLayout(new java.awt.CardLayout());

        RegistrarUsuarioFrame.setVisible(false);

        jLabel1.setText("Registrar Usuario");

        RegUsuarioNicknameLabel.setText("Nickname:");

        RegUsuarioNombreLabel.setText("Nombre:");

        RegUsuarioApellidoLabel.setText("Apellido:");

        RegUsuarioCorreoLabel.setText("Correo:");

        RegUsuarioFechaLabel.setText("Fecha de Nacimiento:");

        RegUsuarioSeleccionarImagenButton.setText("Seleccionar Imagen");
        RegUsuarioSeleccionarImagenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegUsuarioSeleccionarImagenButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegistrarUsuarioFrameLayout = new javax.swing.GroupLayout(RegistrarUsuarioFrame.getContentPane());
        RegistrarUsuarioFrame.getContentPane().setLayout(RegistrarUsuarioFrameLayout);
        RegistrarUsuarioFrameLayout.setHorizontalGroup(
            RegistrarUsuarioFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarUsuarioFrameLayout.createSequentialGroup()
                .addGroup(RegistrarUsuarioFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistrarUsuarioFrameLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel1))
                    .addGroup(RegistrarUsuarioFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RegUsuarioNombreLabel))
                    .addGroup(RegistrarUsuarioFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RegUsuarioNicknameLabel))
                    .addGroup(RegistrarUsuarioFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RegUsuarioApellidoLabel))
                    .addGroup(RegistrarUsuarioFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RegUsuarioCorreoLabel))
                    .addGroup(RegistrarUsuarioFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RegUsuarioFechaLabel))
                    .addGroup(RegistrarUsuarioFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RegUsuarioSeleccionarImagenButton)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        RegistrarUsuarioFrameLayout.setVerticalGroup(
            RegistrarUsuarioFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarUsuarioFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RegUsuarioNicknameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RegUsuarioNombreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RegUsuarioApellidoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RegUsuarioCorreoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RegUsuarioFechaLabel)
                .addGap(37, 37, 37)
                .addComponent(RegUsuarioSeleccionarImagenButton)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        PanelCentral.add(RegistrarUsuarioFrame, "card2");

        MenuInicio.setText("Inicio");
        BarraMenu.add(MenuInicio);

        MenuRegistros.setText("Registros");

        MenuRegistrarUsuario.setText("Registrar Usuario");
        MenuRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuRegistrarUsuarioActionPerformed(evt);
            }
        });
        MenuRegistros.add(MenuRegistrarUsuario);

        BarraMenu.add(MenuRegistros);

        MenuConsultas.setText("Consultas");
        BarraMenu.add(MenuConsultas);

        setJMenuBar(BarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuRegistrarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuRegistrarUsuarioActionPerformed

    private void RegUsuarioSeleccionarImagenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegUsuarioSeleccionarImagenButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegUsuarioSeleccionarImagenButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	/* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	 */
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	}
	catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
        //</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new Interfaz().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraMenu;
    private javax.swing.JMenu MenuConsultas;
    private javax.swing.JMenu MenuInicio;
    private javax.swing.JMenuItem MenuRegistrarUsuario;
    private javax.swing.JMenu MenuRegistros;
    private javax.swing.JPanel PanelCentral;
    private javax.swing.JLabel RegUsuarioApellidoLabel;
    private javax.swing.JLabel RegUsuarioCorreoLabel;
    private javax.swing.JLabel RegUsuarioFechaLabel;
    private javax.swing.JLabel RegUsuarioNicknameLabel;
    private javax.swing.JLabel RegUsuarioNombreLabel;
    private javax.swing.JButton RegUsuarioSeleccionarImagenButton;
    private javax.swing.JInternalFrame RegistrarUsuarioFrame;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
