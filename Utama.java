import java.text.*;
import javax.swing.JOptionPane;
import java.util.*;
import java.util.logging.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class Utama extends javax.swing.JFrame {
    DefaultTableModel model = new DefaultTableModel();
    barangServices barangServices;
    List record = new ArrayList();
    int baris;
    public Utama() {
        initComponents();
        koneksi.getConnection();
        barangServices = new BarangImpl();
        bedit.setEnabled(false);
        bhapus.setEnabled(false);
        ambil_data();
        ambil_data_tabel();
    }
    
    public void ambil_data() {
        try {
            record = barangServices.getAll();
            Object data[][] = new Object[record.size()][5];
            int x = 0;
            for (Iterator it = record.iterator(); it.hasNext();) {
                Barang p = (Barang) it.next();
                data[x][0] = p.getNobarang();
                data[x][1] = p.getNama();
                data[x][2] = p.getHarga();
                data[x][3] = p.getQty();
                data[x][4] = p.getTotalbarang();
                x++;
            }
            String judul[] = {"No. Barang", "Nama Barang", "Harga", "Qty", "Total Harga"};
            tabelbarang.setModel(new DefaultTableModel(data, judul));
            jScrollPane1.setViewportView(tabelbarang);
        } catch (SQLException ex) {
            Logger.getLogger(Utama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ambil_data_tabel() {
        tabelbarang.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
            baris = tabelbarang.getSelectedRow();
            if (baris != -1) {
                isiFields();
            }
        });
    }

    public void isiFields() {
        Barang p = (Barang) record.get(baris);
        txtnobar.setText(p.getNobarang());
        txtnamabarang.setText(p.getNama());
        txtharga.setText(String.valueOf(p.getHarga()));
        txtqty.setText(String.valueOf(p.getQty()));
        txttotal.setText(String.valueOf(p.getTotalbarang()));
    } 
    
    public void bersih() {
        txtnobar.setText("");
        txtnamabarang.setText("");
        txtharga.setText("");
        txtqty.setText("");
        txttotal.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bhitung = new javax.swing.JButton();
        total = new javax.swing.JLabel();
        bsimpan = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        btambah = new javax.swing.JButton();
        txtnamabarang = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        txtqty = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelbarang = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtnobar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("DATA PEMBELIAN BARANG");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel2.setText("NAMA BARANG");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel3.setText("HARGA");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel4.setText("QTY");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel5.setText("TOTAL");

        bhitung.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        bhitung.setText("HITUNG");
        bhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhitungActionPerformed(evt);
            }
        });

        total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        total.setText("TOTAL");

        bsimpan.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        bsimpan.setText("SIMPAN");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bedit.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        bedit.setText("EDIT");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });

        bhapus.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        bhapus.setText("HAPUS");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        bkeluar.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        bkeluar.setText("KELUAR");
        bkeluar.setToolTipText("");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        btambah.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        btambah.setText("+");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        txtnamabarang.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtnamabarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtnamabarangMouseClicked(evt);
            }
        });

        txtharga.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        txtqty.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        txttotal.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        tabelbarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelbarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbarangMouseClicked(evt);
            }
        });
        tabelbarang.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabelbarangPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tabelbarang);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel6.setText("NO. BARANG");

        txtnobar.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 493, Short.MAX_VALUE)
                        .addComponent(btambah))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(65, 65, 65)
                                        .addComponent(txttotal))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(78, 78, 78)
                                        .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(63, 63, 63)
                                        .addComponent(txtharga))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel6))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtnamabarang)
                                            .addComponent(txtnobar, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(bhitung)
                                .addGap(18, 18, 18)
                                .addComponent(bsimpan)
                                .addGap(18, 18, 18)
                                .addComponent(bedit)
                                .addGap(18, 18, 18)
                                .addComponent(bhapus)
                                .addGap(18, 18, 18)
                                .addComponent(bkeluar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(total))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtnobar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(total)
                .addGap(3, 3, 3)
                .addComponent(btambah)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bhitung)
                    .addComponent(bsimpan)
                    .addComponent(bedit)
                    .addComponent(bhapus)
                    .addComponent(bkeluar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhitungActionPerformed
        int jumlah = (int) (Integer.parseInt(txtharga.getText())*
        Integer.parseInt(txtqty.getText()));
        txttotal.setText(Integer.toString(jumlah));
        DecimalFormat angka = new DecimalFormat("###,###");
        total.setText("Total : Rp. "+angka.format(jumlah));
    }//GEN-LAST:event_bhitungActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        JOptionPane.showMessageDialog(this, "Terima Kasih Sudah Membeli");
        System.exit(0);
    }//GEN-LAST:event_bkeluarActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        try {
            if (txtnobar.getText().equals("") 
                    && txtnamabarang.getText().equals("") 
                    && txtharga.getText().equals("") 
                    && txtqty.getText().equals("") 
                    && txttotal.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "silahkan isi data yang akan ditambah");
            } else {
                Barang p = new Barang();
                p.setNobarang(txtnobar.getText());
                p.setNama(txtnamabarang.getText());
                p.setHarga(Integer.parseInt(txtharga.getText()));
                p.setQty(Integer.parseInt(txtqty.getText()));
                p.setTotalbarang(Integer.parseInt(txttotal.getText()));
                barangServices.insert(p);
                JOptionPane.showMessageDialog(this, "Data tersimpan");
                ambil_data();
                bersih();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        try {
            if (txtnobar.getText().equals("") 
                    && txtnamabarang.getText().equals("") 
                    && txtharga.getText().equals("") 
                    && txtqty.getText().equals("") 
                    && txttotal.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "silahkan isi data yang akan ditambah");
            } else {
                Barang p = new Barang();
                p.setNobarang(txtnobar.getText());
                p.setNama(txtnamabarang.getText());
                p.setHarga(Integer.parseInt(txtharga.getText()));
                p.setQty(Integer.parseInt(txtqty.getText()));
                p.setTotalbarang(Integer.parseInt(txttotal.getText()));
                barangServices.update(p);
                JOptionPane.showMessageDialog(this, "Data tersimpan");
                ambil_data();
                bersih();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_beditActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        try {
            // TODO add your handling code here:
            String nobar = txtnobar.getText();
            if (nobar.equals("")) {
                JOptionPane.showMessageDialog(null, "Silahkan pilih yang akan dihapus");
            } else {
                barangServices.delete(nobar);
                ambil_data();
                JOptionPane.showMessageDialog(this, "data berhasil dihapus");
                bersih();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "data gagal dihapus");
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        txtnobar.setText("");
        txtnamabarang.setText("");
        txtharga.setText("");
        txtqty.setText("");
        txttotal.setText("");
        txtnobar.requestFocus();
    }//GEN-LAST:event_btambahActionPerformed

    private void tabelbarangPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabelbarangPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelbarangPropertyChange

    private void tabelbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbarangMouseClicked
        bedit.setEnabled(true);
        bhapus.setEnabled(true);
        bsimpan.setEnabled(false);
    }//GEN-LAST:event_tabelbarangMouseClicked

    private void txtnamabarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtnamabarangMouseClicked
        bsimpan.setEnabled(true);
        bedit.setEnabled(false);
        bhapus.setEnabled(false);
    }//GEN-LAST:event_txtnamabarangMouseClicked

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
            java.util.logging.Logger.getLogger(Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bedit;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bhitung;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelbarang;
    private javax.swing.JLabel total;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtnamabarang;
    private javax.swing.JTextField txtnobar;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
