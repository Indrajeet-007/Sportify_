package sportify;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;

import javax.swing.JOptionPane;

/**
 *
 * @author General
 */
public class PreviousBookings extends javax.swing.JFrame {

    String email = "";
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public PreviousBookings(String em) {

        initComponents();
        email = em;

        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
            String q1 = "SELECT * FROM booking WHERE email = ? ";
            pst = conn.prepareStatement(q1);
            pst.setString(1, email);
            rs = pst.executeQuery();

            while (rs.next()) {

                String BID = rs.getString("BookingID");
                String FID = rs.getString("FacilityID");
                String amount = rs.getString("amount");
                String starttime = rs.getString("starttime");
                String dob = rs.getString("dob");
                String name = rs.getString("name");
                String sport = rs.getString("sport");

                String tbData[] = {sport, name, amount, starttime, dob, FID, BID};

                DefaultTableModel tbm = (DefaultTableModel) table.getModel();
                tbm.addRow(tbData);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        back = new javax.swing.JButton();
        exitlb2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel1.setFont(new java.awt.Font("Rubik", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Previous Bookings");

        table.setBackground(new java.awt.Color(51, 51, 51));
        table.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sport", "Name", "Amount", "StartTime", "DOB", "FID", "BID"
            }
        ));
        table.setRowSelectionAllowed(false);
        table.setShowGrid(true);
        jScrollPane1.setViewportView(table);

        back.setBackground(new java.awt.Color(51, 51, 51));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        exitlb2.setForeground(new java.awt.Color(255, 255, 255));
        exitlb2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitlb2.setText("X");
        exitlb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitlb2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitlb2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitlb2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(287, 287, 287))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(exitlb2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitlb2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(back)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed

        this.dispose();
        Landing LandingFrame = new Landing(email);
        LandingFrame.setVisible(true);
        LandingFrame.pack();
        LandingFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_backActionPerformed

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        back.setForeground(new Color(255, 204, 102));
        back.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        back.setForeground(Color.white);
        back.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
    }//GEN-LAST:event_backMouseExited

    private void exitlb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitlb2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitlb2MouseClicked

    private void exitlb2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitlb2MouseEntered
        // TODO add your handling code here:
        exitlb2.setBorder(BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_exitlb2MouseEntered

    private void exitlb2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitlb2MouseExited
        // TODO add your handling code here:
        exitlb2.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 51)));

    }//GEN-LAST:event_exitlb2MouseExited

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
            java.util.logging.Logger.getLogger(PreviousBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PreviousBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PreviousBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PreviousBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PreviousBookings("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel exitlb2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
