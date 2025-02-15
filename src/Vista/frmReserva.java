/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Crud.fhabitacion;
import Modelo.Reserva;
import Crud.freserva;
import Modelo.habitacion;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class frmReserva extends javax.swing.JInternalFrame{
       FondoPanel2 fondo = new FondoPanel2();

    /**
     * Creates new form frmreserva
     */
    public frmReserva() {
         this.setContentPane(fondo);
        initComponents();
        mostrar("");
        inhabilitar();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        for (int i = 0; i < jtblAlquileres.getColumnCount(); i++) {
            jtblAlquileres.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
       
    }
    private String accion="guardar";
    //public static int idusuario;
    
    void ocultar_columnas(){
        jtblAlquileres.getColumnModel().getColumn(0).setMaxWidth(0);
        jtblAlquileres.getColumnModel().getColumn(0).setMinWidth(0);
        jtblAlquileres.getColumnModel().getColumn(0).setPreferredWidth(0);
        jtblAlquileres.getColumnModel().getColumn(1).setMaxWidth(0);
        jtblAlquileres.getColumnModel().getColumn(1).setMinWidth(0);
        jtblAlquileres.getColumnModel().getColumn(1).setPreferredWidth(0);
        jtblAlquileres.getColumnModel().getColumn(3).setMaxWidth(0);
        jtblAlquileres.getColumnModel().getColumn(3).setMinWidth(0);
        jtblAlquileres.getColumnModel().getColumn(3).setPreferredWidth(0);
    }
    
    void inhabilitar(){
        txtidreserva.setVisible(false);
        txtidhabitacion.setVisible(false);
        txtidhuesped.setVisible(false);
        
        txtnumhab.setEnabled(false);
        txtnomhuesped.setEnabled(false);
        jcbEstancia.setEnabled(false);
        dcfechareserva.setEnabled(false);
        dcIngreso.setEnabled(false);
        dcSalida.setEnabled(false);
        txtCosto.setEnabled(false);
        btnbuscarhab.setEnabled(false);
        btnbuscarhuesped.setEnabled(false);
        
        
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtidreserva.setText("");
        txtidhabitacion.setText("");
        txtnumhab.setText("");
        txtidhuesped.setText("");
        txtnomhuesped.setText("");
        txtCosto.setText("");
        dcfechareserva.setCalendar(null);
        dcIngreso.setCalendar(null);
        dcSalida.setCalendar(null);
                  
    }

        void habilitar(){
        txtidreserva.setVisible(false);
        txtidhabitacion.setVisible(false);
        txtidhuesped.setVisible(false);
        
        txtnumhab.setEnabled(false);
        txtnomhuesped.setEnabled(false);
        jcbEstancia.setEnabled(true);
        dcfechareserva.setEnabled(true);
        dcIngreso.setEnabled(true);
        dcSalida.setEnabled(true);
        txtCosto.setEnabled(true);
        btnbuscarhab.setEnabled(true);
        btnbuscarhuesped.setEnabled(true);

        
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);
        txtidreserva.setText("");
        txtidhabitacion.setText("");
        txtnumhab.setText("");
        txtidhuesped.setText("");
        txtnomhuesped.setText("");
        txtCosto.setText("0");
        dcfechareserva.setCalendar(null);
        dcIngreso.setCalendar(null);
        dcSalida.setCalendar(null);
        
        txtidhabitacion.requestFocus();
        
        //deshabiiatar fechas anteriores y posteriores
        dcfechareserva.setMinSelectableDate(new java.util.Date());
        dcfechareserva.setMaxSelectableDate(new java.util.Date());
        dcIngreso.setMinSelectableDate(new java.util.Date());
        dcSalida.setMinSelectableDate(new java.util.Date());
        

        
    }
        
    void mostrar(String buscar){
        try {
            DefaultTableModel modelo;
            freserva func= new freserva();
            modelo = func.mostrar(buscar);
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
            jtblAlquileres.setModel(noeditable);
            ocultar_columnas();
            lbltotalregistros.setText("Total Registros: "+Integer.toString(func.totalregistros));
            
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new FondoPanel();
        txtnumhab = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtidreserva = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtidhabitacion = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        txtnomhuesped = new javax.swing.JTextField();
        jcbEstancia = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        dcfechareserva = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        dcIngreso = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        dcSalida = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        txtidhuesped = new javax.swing.JTextField();
        btnbuscarhab = new javax.swing.JButton();
        btnbuscarhuesped = new javax.swing.JButton();
        btnHabitaciones = new javax.swing.JButton();
        jPanel2 = new FondoPanel1();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblAlquileres = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        btnConsumos = new javax.swing.JButton();
        btnrealizarpagos = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Reserva");

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Registro de Reservas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 22))); // NOI18N

        txtnumhab.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtnumhab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumhabActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Habitación:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Huesped:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Estancia (h):");

        txtidreserva.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        btnNuevo.setBackground(new java.awt.Color(102, 102, 102));
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/nuevo.GIF"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(102, 102, 102));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/guardar.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(102, 102, 102));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/cancelar.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");

        txtidhabitacion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtidhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidhabitacionActionPerformed(evt);
            }
        });

        txtCosto.setEditable(false);
        txtCosto.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });

        txtnomhuesped.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtnomhuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomhuespedActionPerformed(evt);
            }
        });

        jcbEstancia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jcbEstancia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[Seleccionar horas]", "6", "12", "24" }));
        jcbEstancia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEstanciaItemStateChanged(evt);
            }
        });
        jcbEstancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstanciaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Fecha Reserva:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Ingreso:");

        dcIngreso.setDateFormatString("yyyy/MM/dd HH:mm:ss");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("Salida:");

        dcSalida.setDateFormatString("yyyy/MM/dd HH:mm:ss");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setText("Costo:");

        txtidhuesped.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtidhuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidhuespedActionPerformed(evt);
            }
        });

        btnbuscarhab.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnbuscarhab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/buscar.png"))); // NOI18N
        btnbuscarhab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarhabActionPerformed(evt);
            }
        });

        btnbuscarhuesped.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnbuscarhuesped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/buscar.png"))); // NOI18N
        btnbuscarhuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarhuespedActionPerformed(evt);
            }
        });

        btnHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/puertas.png"))); // NOI18N
        btnHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabitacionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtnumhab, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnbuscarhab, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcbEstancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(dcfechareserva, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dcIngreso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                    .addComponent(txtnomhuesped, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                    .addComponent(dcSalida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnbuscarhuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(txtidhuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btnNuevo)
                                .addGap(22, 22, 22)
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(89, 89, 89)
                                .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnumhab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnHabitaciones)
                    .addComponent(btnbuscarhab))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnbuscarhuesped)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnomhuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtidhuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcbEstancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(dcfechareserva, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(dcIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(dcSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnNuevo))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Listado de Reservas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 22))); // NOI18N

        jtblAlquileres.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblAlquileres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblAlquileresMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtblAlquileres);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setText("BUSCAR:");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(102, 102, 102));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/buscar.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(102, 102, 102));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/eliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(102, 102, 102));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/salir.gif"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbltotalregistros.setText("Registros");

        btnConsumos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsumos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/consumo.png"))); // NOI18N
        btnConsumos.setText("Consumos");
        btnConsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsumosActionPerformed(evt);
            }
        });

        btnrealizarpagos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnrealizarpagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/cpagos.png"))); // NOI18N
        btnrealizarpagos.setText("Realizar Pagos");
        btnrealizarpagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrealizarpagosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir)
                        .addGap(0, 165, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnConsumos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnrealizarpagos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbltotalregistros)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnConsumos)
                        .addComponent(btnrealizarpagos)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtblAlquileresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblAlquileresMouseClicked
        // TODO add your handling code here:
        habilitar();
        btnGuardar.setText("Editar");
        btnEliminar.setEnabled(true);
        accion="editar";

        int fila = jtblAlquileres.rowAtPoint(evt.getPoint());

        txtidreserva.setText(jtblAlquileres.getValueAt(fila,0).toString());
        txtidhabitacion.setText(jtblAlquileres.getValueAt(fila,1).toString());
        txtnumhab.setText(jtblAlquileres.getValueAt(fila,2).toString());
        txtidhuesped.setText(jtblAlquileres.getValueAt(fila,3).toString());
        txtnomhuesped.setText(jtblAlquileres.getValueAt(fila,4).toString());
        jcbEstancia.setSelectedItem(jtblAlquileres.getValueAt(fila,5).toString());
        dcfechareserva.setDate(Date.valueOf(jtblAlquileres.getValueAt(fila,6).toString()));
        txtCosto.setText(jtblAlquileres.getValueAt(fila, 9).toString());
        

    }//GEN-LAST:event_jtblAlquileresMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        mostrar(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

        if (!txtidreserva.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de eliminar la reserva?","confirmar",2);

            if (confirmacion==0) {
                freserva func=new freserva();
                Reserva pdt= new Reserva();

                pdt.setIdreserva(Integer.parseInt(txtidreserva.getText()));
                func.eliminar(pdt);
                mostrar("");
                inhabilitar();

            }

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtidhuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidhuespedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidhuespedActionPerformed

    private void txtnomhuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomhuespedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomhuespedActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void txtidhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidhabitacionActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtidhabitacionActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(txtnumhab.getText().length() ==0){
            JOptionPane.showConfirmDialog(rootPane,"Debes seleccionar una Habitación");
            txtnumhab.requestFocus();
            return;
        }
        if(txtnomhuesped.getText().length() ==0){
            JOptionPane.showConfirmDialog(rootPane,"Debes seleccionar el Huesped");
            txtnomhuesped.requestFocus();
            return;
        }

        if(txtCosto.getText().length() ==0){
            JOptionPane.showConfirmDialog(rootPane,"Debes ingresar un costo de la reserva");
            txtCosto.requestFocus();
            return;
        }

        Reserva rsv=new Reserva();
        freserva func=new freserva();

        rsv.setIdhab(Integer.parseInt(txtidhabitacion.getText()));
        rsv.setIdhuesped(Integer.parseInt(txtidhuesped.getText()));
        
        int seleccionado=jcbEstancia.getSelectedIndex();
        rsv.setEstancia(Integer.parseInt(jcbEstancia.getItemAt(seleccionado)));
        
        rsv.setIngreso(((JTextField)dcIngreso.getDateEditor().getUiComponent()).getText());
        rsv.setSalida(((JTextField)dcSalida.getDateEditor().getUiComponent()).getText());
        
        Calendar cal;
        String calhoras;
        int d,m,a;
        
        cal=dcfechareserva.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        rsv.setFecharsv(new Date(a,m,d));
        
        
        rsv.setCosto(Double.parseDouble(txtCosto.getText()));
        
        
        
        //calhoras=dcSalida.getDateEditor().getUiComponent();
        //d=cal.get(Calendar.DAY_OF_MONTH);
        //m=cal.get(Calendar.MONTH);
        //a=cal.get(Calendar.YEAR) - 1900;
        //h=cal.get(Calendar.HOUR_OF_DAY);
        //min=cal.get(Calendar.MINUTE);
        //sec=cal.get(Calendar.SECOND);
        //rsv.setSalida(new DateTimeAtCreation(a,m,d,m,a));
        
        //fhabitacion func3=new fhabitacion();
        //habitacion hab=new habitacion();


        if(accion.equals("guardar")){
            if(func.insertar(rsv)){
                
                JOptionPane.showMessageDialog(rootPane,"La reserva fue registrada correctamente");
                //ocupamos la habitacion reservada
                fhabitacion func3=new fhabitacion();
                habitacion hab=new habitacion();
                hab.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));
                func3.ocupar(hab);
                JOptionPane.showMessageDialog(rootPane,"La habitacion fue reservada");
                mostrar("");
                inhabilitar();
      }
            else{
                JOptionPane.showMessageDialog(rootPane,"La reserva no fue registrada correctamente");

            }
        }
        else if(accion.equals("editar")){
            rsv.setIdreserva(Integer.parseInt(txtidreserva.getText()));

            if(func.editar(rsv)){
                JOptionPane.showMessageDialog(rootPane,"La hora de salida fue registrada correctamente");
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnGuardar.setText("guardar");
        accion="guardar";
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtnumhabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumhabActionPerformed
        // TODO add your handling code here:
        txtnumhab.transferFocus();
    }//GEN-LAST:event_txtnumhabActionPerformed

    private void btnbuscarhabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarhabActionPerformed
        // TODO add your handling code here:
        jcbEstancia.setSelectedItem("[Seleccionar horas]");
        frmvistahabitacion form=new frmvistahabitacion();
        form.toFront();
        form.setVisible(true);
        
    }//GEN-LAST:event_btnbuscarhabActionPerformed

    private void btnbuscarhuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarhuespedActionPerformed
        // TODO add your handling code here:
        frmvistahuesped form=new frmvistahuesped();
        form.toFront();
        form.setVisible(true);
        
        
    }//GEN-LAST:event_btnbuscarhuespedActionPerformed

    private void btnConsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsumosActionPerformed
        // TODO add your handling code here:
        int  fila = jtblAlquileres.getSelectedRow();
        frmConsumo.idreserva=jtblAlquileres.getValueAt(fila, 0).toString();
        frmConsumo.cliente=jtblAlquileres.getValueAt(fila, 4).toString();
        
        frmConsumo form = new frmConsumo();
        frminicio.escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnConsumosActionPerformed

    private void btnrealizarpagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrealizarpagosActionPerformed
        // TODO add your handling code here:
        int fila = jtblAlquileres.getSelectedRow();
        
        frmpago.idreserva = jtblAlquileres.getValueAt(fila, 0).toString();
        frmpago.huesped = jtblAlquileres.getValueAt(fila, 4).toString();
        frmpago.idhabitacion = jtblAlquileres.getValueAt(fila, 1).toString();
        frmpago.habitacion = jtblAlquileres.getValueAt(fila, 2).toString();
        frmpago.totalreserva = Double.parseDouble(jtblAlquileres.getValueAt(fila, 9).toString());
        
        frmpago form=new frmpago();
        frminicio.escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnrealizarpagosActionPerformed

    private void btnHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabitacionesActionPerformed
        // TODO add your handling code here:
        habitaciones form=new habitaciones();
        form.toFront();
        form.setVisible(true); 
        frminicio.escritorio.add(form);
        form.setExtendedState(form.MAXIMIZED_BOTH);

    }//GEN-LAST:event_btnHabitacionesActionPerformed
public static String costohoras;
public static String idhabitacion;
    private void jcbEstanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstanciaActionPerformed
        // TODO add your handling code here:
            if(txtnumhab.getText().length() ==0){
            JOptionPane.showMessageDialog(null,"Debes seleccionar una Habitación");
            txtnumhab.requestFocus();
            return;
            }
            
        costohoras=jcbEstancia.getSelectedItem().toString();
        idhabitacion=txtidhabitacion.getText();
        fhabitacion func4=new fhabitacion(); 
        txtCosto.setText(func4.costo());
        
    }//GEN-LAST:event_jcbEstanciaActionPerformed


    private void jcbEstanciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbEstanciaItemStateChanged
        // TODO add your handling code here:

        
    }//GEN-LAST:event_jcbEstanciaItemStateChanged

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formInternalFrameOpened

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
            java.util.logging.Logger.getLogger(frmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsumos;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnHabitaciones;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnbuscarhab;
    private javax.swing.JButton btnbuscarhuesped;
    private javax.swing.JButton btnrealizarpagos;
    private com.toedter.calendar.JDateChooser dcIngreso;
    private com.toedter.calendar.JDateChooser dcSalida;
    private com.toedter.calendar.JDateChooser dcfechareserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JComboBox<String> jcbEstancia;
    private javax.swing.JTable jtblAlquileres;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCosto;
    public static javax.swing.JTextField txtidhabitacion;
    public static javax.swing.JTextField txtidhuesped;
    private javax.swing.JTextField txtidreserva;
    public static javax.swing.JTextField txtnomhuesped;
    public static javax.swing.JTextField txtnumhab;
    // End of variables declaration//GEN-END:variables
//author Juan
class FondoPanel extends JPanel {
    private Image imagen;
    
    public FondoPanel() {
        setOpaque(false);
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        

        float alpha = 0.9f;
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        g2d.setComposite(alphaComposite);
        
        int x = 0;
        int y = 0;
        int width = getWidth();
        int height = getHeight();
        int arcWidth = 20; 
        int arcHeight = 20; 
        
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(x, y, width, height, arcWidth, arcHeight);
        g2d.clip(roundedRectangle);
        
        imagen = new ImageIcon(getClass().getResource("/Files/azulf.png")).getImage();
        g2d.drawImage(imagen, x, y, width, height, this);
        
    
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        
        super.paint(g);
    }
}

class FondoPanel1 extends JPanel {
    private Image imagen;
    
    public FondoPanel1() {
        setOpaque(false);
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
  
        float alpha = 0.9f;
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        g2d.setComposite(alphaComposite);
        
        int x = 0;
        int y = 0;
        int width = getWidth();
        int height = getHeight();
        int arcWidth = 20; 
        int arcHeight = 20; 
        
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(x, y, width, height, arcWidth, arcHeight);
        g2d.clip(roundedRectangle);
        
        imagen = new ImageIcon(getClass().getResource("/Files/azulf.png")).getImage();
        g2d.drawImage(imagen, x, y, width, height, this);
        
  
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        
        super.paint(g);
    }
}

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
