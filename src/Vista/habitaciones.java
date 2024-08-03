package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


/**
 *
 * @author user
 */
public class habitaciones extends javax.swing.JFrame {

    /**
     * Creates new form habitaciones
     */
    
    public habitaciones() {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        updateRoomStates();
        // Crear el botón updateButton
    jButton30.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Obtener el estado de todas las habitaciones de la base de datos
            Map<Integer, String> roomStates = new HashMap<>();
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.18.7:3307/gestionhotel", "root", "");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM habitacion");
                while (rs.next()) {
                    int roomId = rs.getInt("idhabitacion");
                    String roomState = rs.getString("estado");
                    roomStates.put(roomId, roomState);
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }

            // Actualizar el estado de cada botón según el estado de la habitación correspondiente
            for (int i = 1; i <= 29; i++) {
                JButton roomButton = getRoomButton(i);
                String roomState = roomStates.get(i);
                if (roomState.equals("Ocupado")) {
                    roomButton.setBackground(Color.RED);
                } else if (roomState.equals("Disponible")) {
                    roomButton.setBackground(Color.GREEN);
                } else if (roomState.equals("Mantenimiento")) {
                    roomButton.setBackground(Color.YELLOW);
                }
            }
        }
    });
    }
    
    /*Conexion conectar= new Conexion();
    Connection connection = conectar.conectar();*/
    
    private void updateRoomStates() {
        try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.18.7:3307/gestionhotel", "root", "");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM habitacion");

        while (rs.next()) {
        int roomId = rs.getInt("idhabitacion");
        String roomState = rs.getString("estado");

        JButton roomButton = getRoomButton(roomId);

        if (roomState.equals("Ocupado")) {
        roomButton.setBackground(Color.RED);
        roomButton.setText("Ocupado");
        } else if (roomState.equals("Disponible")) {
        roomButton.setBackground(Color.GREEN);
        roomButton.setText("Disponible");
        } else if (roomState.equals("Mantenimiento")) {
        roomButton.setBackground(Color.YELLOW);
        roomButton.setText("Mantenimiento");
        }
        }

        rs.close();
        stmt.close();
        conn.close();
        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
        }

        private JButton getRoomButton(int roomId) {
        switch (roomId) {
        case 1:
        return jButton1;
        case 2:
        return jButton2;
        case 3:
        return jButton3;
        case 4:
        return jButton4;
        case 5:
        return jButton5;
        case 6:
        return jButton6;
        case 7:
        return jButton7;
        case 8:
        return jButton8;
        case 9:
        return jButton9;
        case 10:
        return jButton10;
        case 11:
        return jButton11;
        case 12:
        return jButton12;
        case 13:
        return jButton13;
        case 14:
        return jButton14;
        case 15:
        return jButton15;
        case 16:
        return jButton16;
        case 17:
        return jButton17;
        case 18:
        return jButton18;
        case 19:
        return jButton19;
        case 20:
        return jButton20;
        case 21:
        return jButton21;
        case 22:
        return jButton22;
        case 23:
        return jButton23;
        case 24:
        return jButton24;
        case 25:
        return jButton25;
        case 26:
        return jButton26;
        case 27:
        return jButton27;
        case 28:
        return jButton28;
        // ...
        case 29:
        return jButton29;
        }
        return null;
        }
        
    public void addButtonListener(JButton button, int roomId) {
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Cambiar el color del botón y el texto
            button.setBackground(Color.GREEN);
            button.setText("Disponible");

            // Actualizar la base de datos
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:192.168.18.7/gestionhotel", "root", "");
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE habitacion SET estado='Disponible' WHERE idhabitacion=" + roomId);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    });
}
    
    public void showError(String message) {
    // Aquí puedes escribir el código para mostrar el mensaje de error en el JFrame Form Habitaciones
    // Por ejemplo:
    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
}
    
    

// Agregar el ActionListener a cada botón



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Txt1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Txt2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        Txt3 = new javax.swing.JLabel();
        Txt4 = new javax.swing.JLabel();
        Txt5 = new javax.swing.JLabel();
        Txt6 = new javax.swing.JLabel();
        Txt7 = new javax.swing.JLabel();
        Txt8 = new javax.swing.JLabel();
        Txt9 = new javax.swing.JLabel();
        Txt10 = new javax.swing.JLabel();
        Txt11 = new javax.swing.JLabel();
        Txt12 = new javax.swing.JLabel();
        Txt13 = new javax.swing.JLabel();
        Txt14 = new javax.swing.JLabel();
        Txt15 = new javax.swing.JLabel();
        Txt16 = new javax.swing.JLabel();
        Txt17 = new javax.swing.JLabel();
        Txt18 = new javax.swing.JLabel();
        Txt19 = new javax.swing.JLabel();
        Txt20 = new javax.swing.JLabel();
        Txt21 = new javax.swing.JLabel();
        Txt22 = new javax.swing.JLabel();
        Txt23 = new javax.swing.JLabel();
        Txt24 = new javax.swing.JLabel();
        Txt25 = new javax.swing.JLabel();
        Txt26 = new javax.swing.JLabel();
        Txt27 = new javax.swing.JLabel();
        Txt28 = new javax.swing.JLabel();
        Txt29 = new javax.swing.JLabel();
        Txt30 = new javax.swing.JLabel();
        Txt31 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton30 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Txt1.setText("Habitación 1");
        getContentPane().add(Txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 70, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 170, 40));

        Txt2.setText("Habitación 2");
        getContentPane().add(Txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 81, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 170, 40));

        Txt3.setText("Habitación 3");
        getContentPane().add(Txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 81, -1));

        Txt4.setText("Habitación 4");
        getContentPane().add(Txt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, 81, -1));

        Txt5.setText("Habitación 5");
        getContentPane().add(Txt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, 81, -1));

        Txt6.setText("Habitación 10");
        getContentPane().add(Txt6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 140, 81, -1));

        Txt7.setText("Habitación 6");
        getContentPane().add(Txt7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 81, -1));

        Txt8.setText("Habitación 7");
        getContentPane().add(Txt8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 81, -1));

        Txt9.setText("Habitación 8");
        getContentPane().add(Txt9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 81, -1));

        Txt10.setText("Habitación 9");
        getContentPane().add(Txt10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, 81, -1));

        Txt11.setText("Habitación 19");
        getContentPane().add(Txt11, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 340, 81, -1));

        Txt12.setText("Habitación 20");
        getContentPane().add(Txt12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 81, -1));

        Txt13.setText("Habitación 11");
        getContentPane().add(Txt13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 81, -1));

        Txt14.setText("Habitación 12");
        getContentPane().add(Txt14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 81, -1));

        Txt15.setText("Habitación 13");
        getContentPane().add(Txt15, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 81, -1));

        Txt16.setText("Habitación 15");
        getContentPane().add(Txt16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 81, -1));

        Txt17.setText("Habitación 16");
        getContentPane().add(Txt17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 81, -1));

        Txt18.setText("Habitación 17");
        getContentPane().add(Txt18, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 81, -1));

        Txt19.setText("Habitación 18");
        getContentPane().add(Txt19, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 81, -1));

        Txt20.setText("Habitación 14");
        getContentPane().add(Txt20, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, 81, -1));

        Txt21.setText("Habitación 25");
        getContentPane().add(Txt21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 81, -1));

        Txt22.setText("Habitación 21");
        getContentPane().add(Txt22, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 81, -1));

        Txt23.setText("Habitación 22");
        getContentPane().add(Txt23, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 81, -1));

        Txt24.setText("Habitación 23");
        getContentPane().add(Txt24, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 410, 81, -1));

        Txt25.setText("Habitación 24");
        getContentPane().add(Txt25, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 410, 81, -1));

        Txt26.setText("Habitación 29");
        getContentPane().add(Txt26, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 490, 81, -1));

        Txt27.setText("Habitación 26");
        getContentPane().add(Txt27, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 81, -1));

        Txt28.setText("Habitación 27");
        getContentPane().add(Txt28, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, 81, -1));

        Txt29.setText("Habitación 28");
        getContentPane().add(Txt29, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 490, 81, -1));

        Txt30.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Txt30.setText("Piso 2");
        getContentPane().add(Txt30, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 120, -1));

        Txt31.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        Txt31.setText("Piso 1");
        getContentPane().add(Txt31, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 120, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 170, 40));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 170, 40));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, 170, 40));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 170, 40));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/jacuzzi.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 170, 40));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 170, 40));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 170, 40));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/suit.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 170, 170, 40));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/suit.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 170, 40));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 170, 40));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 170, 40));

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/jacuzzi.png"))); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 170, 40));

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 170, 40));

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 170, 40));

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, 170, 40));

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, 170, 40));

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 360, 170, 40));

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/jacuzzi.png"))); // NOI18N
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 170, 40));

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/jacuzzi.png"))); // NOI18N
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 170, 40));

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, 170, 40));

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 170, 40));

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 440, 170, 40));

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 170, 40));

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, 170, 40));

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 510, 170, 40));

        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 510, 170, 40));

        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/matrimonial.png"))); // NOI18N
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 510, 170, 40));

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 60, 60));

        jPanel4.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 580, 60, 60));

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 580, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mantenimiento");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 600, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Desocupado");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 600, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ocupado");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 600, -1, -1));

        jButton30.setBackground(new java.awt.Color(51, 51, 255));
        jButton30.setFont(new java.awt.Font("Sitka Small", 2, 18)); // NOI18N
        jButton30.setText("Actualizar");
        getContentPane().add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 580, 210, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addButtonListener(jButton1, 1);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        addButtonListener(jButton2, 2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        addButtonListener(jButton3, 3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                addButtonListener(jButton4, 4);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        addButtonListener(jButton5, 5);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        addButtonListener(jButton6, 6);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        addButtonListener(jButton7, 7);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        addButtonListener(jButton8, 8);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        addButtonListener(jButton9, 9);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        addButtonListener(jButton10, 10);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        addButtonListener(jButton11, 11);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        addButtonListener(jButton12, 12);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        addButtonListener(jButton13, 13);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        addButtonListener(jButton14, 14);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        addButtonListener(jButton15, 15);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        addButtonListener(jButton16, 16);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        addButtonListener(jButton17, 17);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        addButtonListener(jButton18, 18);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
                addButtonListener(jButton19, 19);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
                addButtonListener(jButton20, 20);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
         addButtonListener(jButton21, 21);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        addButtonListener(jButton22, 22);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        addButtonListener(jButton23, 23);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        addButtonListener(jButton24, 24);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        addButtonListener(jButton25, 25);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        addButtonListener(jButton26, 26);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        addButtonListener(jButton27, 27);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        addButtonListener(jButton28, 28);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        addButtonListener(jButton29, 29);
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(habitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(habitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(habitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(habitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new habitaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Txt1;
    private javax.swing.JLabel Txt10;
    private javax.swing.JLabel Txt11;
    private javax.swing.JLabel Txt12;
    private javax.swing.JLabel Txt13;
    private javax.swing.JLabel Txt14;
    private javax.swing.JLabel Txt15;
    private javax.swing.JLabel Txt16;
    private javax.swing.JLabel Txt17;
    private javax.swing.JLabel Txt18;
    private javax.swing.JLabel Txt19;
    private javax.swing.JLabel Txt2;
    private javax.swing.JLabel Txt20;
    private javax.swing.JLabel Txt21;
    private javax.swing.JLabel Txt22;
    private javax.swing.JLabel Txt23;
    private javax.swing.JLabel Txt24;
    private javax.swing.JLabel Txt25;
    private javax.swing.JLabel Txt26;
    private javax.swing.JLabel Txt27;
    private javax.swing.JLabel Txt28;
    private javax.swing.JLabel Txt29;
    private javax.swing.JLabel Txt3;
    private javax.swing.JLabel Txt30;
    private javax.swing.JLabel Txt31;
    private javax.swing.JLabel Txt4;
    private javax.swing.JLabel Txt5;
    private javax.swing.JLabel Txt6;
    private javax.swing.JLabel Txt7;
    private javax.swing.JLabel Txt8;
    private javax.swing.JLabel Txt9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
