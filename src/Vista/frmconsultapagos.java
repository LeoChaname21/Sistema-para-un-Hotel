/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Crud.fconsumo;
import Crud.fpago;
import static Vista.frmpago.idreserva;
import java.awt.Graphics;
import java.awt.Image;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Vector;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo
 */
public class frmconsultapagos extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmconsulta
     */
    public frmconsultapagos() {
        initComponents();
        mostrar("");    
    }
    void ocultar_columnas(){
        jtblPagos.getColumnModel().getColumn(0).setMaxWidth(0);
        jtblPagos.getColumnModel().getColumn(0).setMinWidth(0);
        jtblPagos.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        jtblPagos.getColumnModel().getColumn(1).setMaxWidth(0);
        jtblPagos.getColumnModel().getColumn(1).setMinWidth(0);
        jtblPagos.getColumnModel().getColumn(1).setPreferredWidth(0);
    
    }
    void tamañocolumnas(){
        
        //jtblPagos.getColumnModel().getColumn(1).setPreferredWidth(0);
               
    }
    
    
    void centrarceldas(){
        
        DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
        centrar.setHorizontalAlignment(SwingConstants.CENTER);
        jtblPagos.getColumnModel().getColumn(2).setCellRenderer(centrar);
        jtblPagos.getColumnModel().getColumn(3).setCellRenderer(centrar);
        jtblPagos.getColumnModel().getColumn(4).setCellRenderer(centrar);

           
    }
    void mostrar(String tipopago){
        try {
            DefaultTableModel modelo;
            fpago func= new fpago();
            modelo = func.mostrartodos(tipopago);
            Vector<String> columnNames = new Vector<>();
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                columnNames.add(modelo.getColumnName(i));
            }

            DefaultTableModel noeditable = new DefaultTableModel(modelo.getDataVector(), columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jtblPagos.setModel(noeditable);
            ocultar_columnas();
            centrarceldas();
            lbltotalregistros.setText("Total Pagos: "+Integer.toString(func.totalregistros));
            lblpago.setText("S/. "+func.totalpago);
                  
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
                    
        }
    }
    
    
    
    void buscarporfechas(String buscar,String buscar2){
        try {
            DefaultTableModel modelo;
            fpago func= new fpago();
            modelo = func.buscarporfechas(buscar,buscar2);
            Vector<String> columnNames = new Vector<>();
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                columnNames.add(modelo.getColumnName(i));
            }

            DefaultTableModel noeditable = new DefaultTableModel(modelo.getDataVector(), columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jtblPagos.setModel(noeditable);
            ocultar_columnas();
            centrarceldas();
            lbltotalregistros.setText("Total Pagos: "+Integer.toString(func.totalregistros));
            lblpago.setText("S/. "+func.totalpago);
                  
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
                    
        }
    }
    
    void buscartipopago(String buscar,String buscar2,String tipopago){
        try {
            DefaultTableModel modelo;
            fpago func= new fpago();
            modelo = func.buscartipopago(buscar, buscar2, tipopago);
            Vector<String> columnNames = new Vector<>();
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                columnNames.add(modelo.getColumnName(i));
            }

            DefaultTableModel noeditable = new DefaultTableModel(modelo.getDataVector(), columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jtblPagos.setModel(noeditable);
            ocultar_columnas();
            centrarceldas();
            lbltotalregistros.setText("Total Pagos: "+Integer.toString(func.totalregistros));
            lblpago.setText("S/. "+func.totalpago);
                  
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
                    
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new FondoPanel2();
        jcbTipopago = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblPagos = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        lblpago = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        dcfecha1 = new com.toedter.calendar.JDateChooser();
        dcfecha2 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        btnBuscar1 = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        jbtnPDF = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Consulta de Pagos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 22))); // NOI18N

        jcbTipopago.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jcbTipopago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta", "Yape", "Plin" }));

        jtblPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblPagosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtblPagos);

        btnSalir.setBackground(new java.awt.Color(102, 102, 102));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/salir.gif"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lbltotalregistros.setBackground(new java.awt.Color(255, 255, 255));
        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbltotalregistros.setForeground(new java.awt.Color(255, 255, 255));
        lbltotalregistros.setText("Registros");

        lblpago.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblpago.setForeground(new java.awt.Color(255, 255, 255));
        lblpago.setText("S/. ");

        btnBuscar.setBackground(new java.awt.Color(102, 102, 102));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/buscar.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setText("Buscar por Fechas:");

        dcfecha1.setDateFormatString("yyyy/MM/dd");

        dcfecha2.setDateFormatString("yyyy/MM/dd");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("Filtrar:");

        btnBuscar1.setBackground(new java.awt.Color(102, 102, 102));
        btnBuscar1.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/buscar.png"))); // NOI18N
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        btnlimpiar.setBackground(new java.awt.Color(102, 102, 102));
        btnlimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/limpiar2.png"))); // NOI18N
        btnlimpiar.setText("LIMPIAR");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        jbtnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/pdf icon.png"))); // NOI18N
        jbtnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dcfecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnlimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblpago)
                                .addGap(183, 183, 183)
                                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbTipopago, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(526, 526, 526)
                                .addComponent(jbtnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 20, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcfecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnlimpiar))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jcbTipopago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpago)
                    .addComponent(lbltotalregistros))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtblPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblPagosMouseClicked
        // TODO add your handling code her
    }//GEN-LAST:event_jtblPagosMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String fecha1=((JTextField)dcfecha1.getDateEditor().getUiComponent()).getText();
        String fecha2=((JTextField)dcfecha2.getDateEditor().getUiComponent()).getText();
        if(dcfecha1.getDate()==null) {
            JOptionPane.showMessageDialog(rootPane,"Debes seleccionar la fecha inicial");
            dcfecha1.requestFocus();
            return;
        }
        if(dcfecha2.getDate()==null) {
            JOptionPane.showMessageDialog(rootPane,"Debes seleccionar la fecha final");
            dcfecha2.requestFocus();
            return;
        }
        buscarporfechas(fecha1, fecha2); 
  
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        // TODO add your handling code here:
       
        String fecha1=((JTextField)dcfecha1.getDateEditor().getUiComponent()).getText();
        String fecha2=((JTextField)dcfecha2.getDateEditor().getUiComponent()).getText();
        int seleccionado=jcbTipopago.getSelectedIndex();
        String tipopago=(String)jcbTipopago.getItemAt(seleccionado);
        
        if (dcfecha1.getDate()==null) {
            mostrar(tipopago);      
        }
        else {
        buscartipopago(fecha1, fecha2, tipopago);
        }
        
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        // TODO add your handling code here:
        ((JTextField)dcfecha1.getDateEditor().getUiComponent()).setText("");
        ((JTextField)dcfecha2.getDateEditor().getUiComponent()).setText("");
        mostrar("");
    
       
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void jbtnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPDFActionPerformed
        // TODO add your handling code here:
        
        MessageFormat header = new MessageFormat("Reporte de Consulta de Pagos");
        MessageFormat footer = new MessageFormat("Hotel Memphis ©");
        
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.LANDSCAPE);
            jtblPagos.print(JTable.PrintMode.FIT_WIDTH,header,footer,true,set,true);
            JOptionPane.showMessageDialog(null,"\n"+"Printed Succesfully");    
            
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(null,"\n"+"Failed"
            +"\n"+ e);
        } 
        
    }//GEN-LAST:event_jbtnPDFActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmconsultapagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmconsultapagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmconsultapagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmconsultapagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmconsultapagos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnlimpiar;
    private com.toedter.calendar.JDateChooser dcfecha1;
    private com.toedter.calendar.JDateChooser dcfecha2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtnPDF;
    private javax.swing.JComboBox<String> jcbTipopago;
    private javax.swing.JTable jtblPagos;
    private javax.swing.JLabel lblpago;
    private javax.swing.JLabel lbltotalregistros;
    // End of variables declaration//GEN-END:variables
class FondoPanel2 extends JPanel
    {
        private Image imagen;
        
        @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("/Files/clarof.png")).getImage();
            
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
}
