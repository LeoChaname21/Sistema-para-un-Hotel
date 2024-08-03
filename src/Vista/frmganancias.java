/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author Juan
 */

import java.awt.BorderLayout;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.ui.TextAnchor;
import utils.Conexion;
public class frmganancias extends javax.swing.JFrame {
    FondoPanel fondo = new FondoPanel();
    /**
     * Creates new form frmganancias3
     */
    public frmganancias() {
         this.setContentPane(fondo);
      initComponents();
      generarGrafico();
    }

    
    private void generarGrafico() {
     Conexion conexion = new Conexion();

    try (Connection connection = conexion.conectar()) {

         
            String ingresosQuery = "SELECT MONTH(fecha_pago) AS mes, SUM(total_pago) AS total_pago_mes FROM pago GROUP BY MONTH(fecha_pago)";
            Statement ingresosStatement = connection.createStatement();
            ResultSet ingresosResultSet = ingresosStatement.executeQuery(ingresosQuery);


            String gastosQuery = "SELECT MONTH(fechapedido) AS mes, SUM(costo) AS costo_mes FROM pedido GROUP BY MONTH(fechapedido)";
            Statement gastosStatement = connection.createStatement();
            ResultSet gastosResultSet = gastosStatement.executeQuery(gastosQuery);


            DefaultCategoryDataset ingresosDataset = new DefaultCategoryDataset();

     
            while (ingresosResultSet.next()) {
                int mes = ingresosResultSet.getInt("mes");
                double totalPagoMes = ingresosResultSet.getDouble("total_pago_mes");

                String nombreMes = getNombreMes(mes);

                ingresosDataset.addValue(totalPagoMes, "Ingresos", nombreMes);
            }

         
            DefaultCategoryDataset gastosDataset = new DefaultCategoryDataset();

    
            while (gastosResultSet.next()) {
                int mes = gastosResultSet.getInt("mes");
                double totalPedidoMes = gastosResultSet.getDouble("costo_mes");

                String nombreMes = getNombreMes(mes);

                double totalSueldos = getTotalSueldos(connection);

                double gastosTotalesMes = totalPedidoMes + totalSueldos;

                gastosDataset.addValue(gastosTotalesMes, "Gastos", nombreMes);
            }

 
            ingresosResultSet.close();
            ingresosStatement.close();
            gastosResultSet.close();
            gastosStatement.close();
            connection.close();

        
            DefaultCategoryDataset gananciasDataset = new DefaultCategoryDataset();
            for (int i = 0; i < ingresosDataset.getRowCount(); i++) {
                Comparable<?> rowKey = ingresosDataset.getRowKey(i);
                for (int j = 0; j < ingresosDataset.getColumnCount(); j++) {
                   Comparable<?> columnKey = ingresosDataset.getColumnKey(j);
             
                    double ingresos = ingresosDataset.getValue(i, j).doubleValue();
                    double gastos = gastosDataset.getValue(i, j).doubleValue();
                    double ganancias = ingresos - gastos;

                    gananciasDataset.addValue(ganancias, "Ganancias", columnKey);
                }
            }

    
            JFreeChart chart = ChartFactory.createBarChart("", "Mes", "Valor en Soles", gananciasDataset);

         
            CategoryPlot plot = chart.getCategoryPlot();
            BarRenderer renderer = (BarRenderer) plot.getRenderer();
            renderer.setSeriesPaint(0, Color.GREEN); 

   
            ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER);
            renderer.setBasePositiveItemLabelPosition(position);
            renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            renderer.setBaseItemLabelsVisible(true);

           
            ChartPanel chartPanel = new ChartPanel(chart);
            
      
        chartPanel.setPreferredSize(jPanel1.getSize());

            
            jPanel1.setLayout(new BorderLayout());
            jPanel1.add(chartPanel, BorderLayout.CENTER);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String getNombreMes(int mes) {
        LocalDate fecha = LocalDate.of(2023, mes, 1);
        return fecha.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
    }

    private static double getTotalSueldos(Connection connection) throws SQLException {
        String sueldosQuery = "SELECT SUM(sueldo) AS total_sueldos FROM empleado";
        Statement sueldosStatement = connection.createStatement();
        ResultSet sueldosResultSet = sueldosStatement.executeQuery(sueldosQuery);

        double totalSueldos = 0;
        if (sueldosResultSet.next()) {
            totalSueldos = sueldosResultSet.getDouble("total_sueldos");
        }

        sueldosResultSet.close();
        sueldosStatement.close();

        return totalSueldos;
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1096, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Resumen Mensual de Ganancias ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(frmganancias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmganancias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmganancias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmganancias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmganancias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
class FondoPane4 extends JPanel
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
