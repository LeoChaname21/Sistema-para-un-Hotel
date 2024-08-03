/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import utils.Conexion;

/**
 *
 * @author Juan
 */
public class frmtipopago extends javax.swing.JFrame {

    private static JComboBox<String> monthComboBox;

    public frmtipopago() {
  
        generarGrafico();
    }

    

    private void generarGrafico() {
   
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();

        if (conn != null) {
       
            JFrame frame = new JFrame("Selección de mes");        
            frame.setSize(300, 200);
        
            String[] months = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
            monthComboBox = new JComboBox<>(months);

            JButton generateButton = new JButton("Generar Gráfico");
            generateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                
                    String selectedMonth = (String) monthComboBox.getSelectedItem();

                   
                    String query = "SELECT tipo_pago, COUNT(*) as count, SUM(total_pago) as total FROM pago WHERE MONTH(fecha_pago) = ? GROUP BY tipo_pago";

                    try {
                        PreparedStatement statement = conn.prepareStatement(query);
                        int selectedMonthIndex = monthComboBox.getSelectedIndex() + 1;  
                        statement.setInt(1, selectedMonthIndex);
                        ResultSet resultSet = statement.executeQuery();

                        DefaultPieDataset dataset = new DefaultPieDataset();

                     
                        boolean hasData = false;

                 
                        while (resultSet.next()) {
                            hasData = true;
                            String tipoPago = resultSet.getString("tipo_pago");
                            int count = resultSet.getInt("count");
                            double totalPago = resultSet.getDouble("total");
                            dataset.setValue(tipoPago + "  Cantidad: (" + count + ") , Suma total: (" + totalPago + ")", count);
                        }

                        if (!hasData) {
                            JOptionPane.showMessageDialog(frame, "No hay información disponible para el mes seleccionado.", "Sin información", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                       
                        JFreeChart chart = ChartFactory.createPieChart("Porcentaje de tipos de pago - " + selectedMonth, dataset, true, true, false);
             
                        PiePlot plot = (PiePlot) chart.getPlot();
                        DecimalFormat decimalFormat = new DecimalFormat("0.0%");
                        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}, Porcentaje: ({2})", decimalFormat, decimalFormat));

                        
                        ChartFrame chartFrame = new ChartFrame("Gráfico de torta", chart);
                        chartFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                            @Override
                            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                                monthComboBox.setSelectedIndex(0); 
                            }
                        });
                        chartFrame.pack();
                        chartFrame.setLocationRelativeTo(null);
                        chartFrame.setVisible(true);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
          
              JPanel panel = new JPanel();
            panel.add(new JLabel("Seleccionar mes:"));
            panel.add(monthComboBox);
            panel.add(generateButton);
    
            frame.getContentPane().add(panel, BorderLayout.CENTER);
        
        frame.pack();
        int x =50;
        int y = 200;

        frame.pack();
        frame.setLocation(x, y); // Establece la posición del JFrame en la pantalla
        frame.setVisible(true);
  
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

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmtipopago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmtipopago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmtipopago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmtipopago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmtipopago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
