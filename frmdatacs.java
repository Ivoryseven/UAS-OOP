/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasiuas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static aplikasiuas.Koneksi.getConnection;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arya Restyandika
 */
public class frmdatacs extends javax.swing.JFrame {
    DefaultTableModel tm = new DefaultTableModel();
    

    /**
     
     * @throws java.sql.SQLException
     */
    public frmdatacs() throws SQLException {
        initComponents();
        jtb.setModel(tm);
        tm.addColumn("ID"); 
        tm.addColumn("Nama");
        tm.addColumn("Layanan");
        tm.addColumn("Harga");
        list_all();
    }

    private void list_all() throws SQLException{
      Connection cnn = getConnection();
      tm.getDataVector().removeAllElements();
        tm.fireTableDataChanged();

      if (cnn.isClosed()){
          System.out.println("Koneksi Tertutup");
      }else{
          String sql = "Select * FROM customer order by idcustomer;";
          PreparedStatement ps = cnn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          while(rs.next()){
              Object [] dta = new Object [4];
              dta[0] = rs.getInt("idcustomer");
              dta[1] = rs.getString("nama");
              dta[2] = rs.getString("layanan");
              dta[3] = rs.getString("harga");
              tm.addRow(dta);
          }
          cnn.close();
      }
    };
    private void StoreData() throws SQLException{
        Connection cnn = getConnection();
        String NM = xnama.getText();
        String LY = xlayanan.getText();
        String HG = xharga.getText();
        if(!cnn.isClosed()){
            PreparedStatement ps = cnn.prepareStatement("INSERT INTO customer (nama, layanan, harga) VALUES (?, ?, ?)");
            ps.setString(1, NM);
            ps.setString(2, LY);
            ps.setString(3, HG);
            ps.executeUpdate();                       
                 
        }
   
    
}
    private void UpdateData() throws SQLException{
        Connection cnn = getConnection();
        if(!cnn.isClosed()){
            String idteman = record1.getText();
            String NM = xnama.getText();
            String LY = xlayanan.getText();
            String HG = xharga.getText();
            PreparedStatement ps = cnn.prepareStatement("UPDATE datateman set nama=?, alamat=?, telp=? WHERE  idteman=?");
            ps.setString(1, NM);
              ps.setString(2, LY);
                ps.setString(3, HG);
                  ps.setString(4, idteman);
                    ps.executeUpdate();
            
            
            
        }
    }
    private void DestroyData() throws SQLException{
        Connection cnn = getConnection();
        if (!cnn.isClosed()){
            PreparedStatement ps = cnn.prepareStatement("DELETE FROM customer WHERE idcustomer=?;");
            ps.setString(1, record1.getText());
            ps.executeUpdate();
            cnn.close();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtb = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        xnama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        xlayanan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        xharga = new javax.swing.JTextField();
        cmdbaru = new javax.swing.JButton();
        cmdhapus = new javax.swing.JButton();
        cmdtutup = new javax.swing.JButton();
        record1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmdedit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Data Servis Bengkel");

        jLabel2.setText("Record : ");

        jLabel3.setText("Nama Customer :");

        xnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xnamaActionPerformed(evt);
            }
        });

        jLabel4.setText("Layanan :");

        xlayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xlayananActionPerformed(evt);
            }
        });

        jLabel5.setText("Harga :");

        xharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xhargaActionPerformed(evt);
            }
        });

        cmdbaru.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmdbaru.setText("Tambah");
        cmdbaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdbaruActionPerformed(evt);
            }
        });

        cmdhapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmdhapus.setText("Hapus");
        cmdhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdhapusActionPerformed(evt);
            }
        });

        cmdtutup.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmdtutup.setText("Tutup");
        cmdtutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdtutupActionPerformed(evt);
            }
        });

        record1.setText("888");

        jLabel7.setText("/");

        jLabel8.setText("888");

        cmdedit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmdedit.setText("Edit");
        cmdedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdeditActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Yong De Motor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(xlayanan)
                                    .addComponent(xnama)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmdedit)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(record1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel7))
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmdbaru)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmdhapus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmdtutup))
                                    .addComponent(xharga)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(75, 75, 75))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(record1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(xnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(xlayanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(xharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdbaru)
                            .addComponent(cmdhapus)
                            .addComponent(cmdtutup))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdedit)
                        .addGap(23, 23, 23))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdtutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdtutupActionPerformed
    if(cmdtutup.getText().equals("Tutup")){
        int jtp = JOptionPane.showOptionDialog(this, "Yakin untuk menutup form?", "Konfirmasi menutup form", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if(jtp == JOptionPane.YES_NO_OPTION)
        dispose(); 
    }else{
        cmdtutup.setText("Tutup");
        cmdbaru.setText("Baru");
        cmdhapus.setEnabled(true);
    }
   
    
    }//GEN-LAST:event_cmdtutupActionPerformed

    private void jtbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbMouseClicked
        // TODO add your handling code here:
        xnama.setText(jtb.getValueAt(jtb.getSelectedRow(),1).toString());
        record1.setText(jtb.getValueAt(jtb.getSelectedRow(),0).toString());
        xlayanan.setText(jtb.getValueAt(jtb.getSelectedRow(),2).toString());
        xharga.setText(jtb.getValueAt(jtb.getSelectedRow(),3).toString());
    }//GEN-LAST:event_jtbMouseClicked

    private void xnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xnamaActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_xnamaActionPerformed

    private void cmdbaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdbaruActionPerformed
        // TODO add your handling code here:
        if(cmdbaru.getText().equals("baru")){
            cmdbaru.setText("simpan");
            cmdtutup.setText("Batal");
            cmdhapus.setEnabled(false);
            
            xnama.setText(" ");
            xlayanan.setText(" ");
            xharga.setText(" ");
        }else{
            try {
                StoreData();
                list_all();
            } catch (SQLException ex) {
                Logger.getLogger(frmdatacs.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            cmdbaru.setText("BARU");
            cmdtutup.setText("Kembali");
            cmdhapus.setEnabled(true);
        }
    }//GEN-LAST:event_cmdbaruActionPerformed

    private void cmdhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdhapusActionPerformed
        // TODO add your handling code here:
    try {
        DestroyData();
        list_all();
    } catch (SQLException ex) {
        Logger.getLogger(frmdatacs.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_cmdhapusActionPerformed

    private void cmdeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdeditActionPerformed
        // TODO add your handling code here:
            try {
                UpdateData();
                list_all();
            } catch (SQLException ex) {
                Logger.getLogger(frmdatacs.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_cmdeditActionPerformed

    private void xhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xhargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xhargaActionPerformed

    private void xlayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xlayananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xlayananActionPerformed

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
            java.util.logging.Logger.getLogger(frmdatacs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmdatacs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmdatacs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmdatacs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmdatacs().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmdatacs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdbaru;
    private javax.swing.JButton cmdedit;
    private javax.swing.JButton cmdhapus;
    private javax.swing.JButton cmdtutup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtb;
    private javax.swing.JLabel record1;
    private javax.swing.JTextField xharga;
    private javax.swing.JTextField xlayanan;
    private javax.swing.JTextField xnama;
    // End of variables declaration//GEN-END:variables

    
  
}