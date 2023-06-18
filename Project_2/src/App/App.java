package App;

import Com.Config.KoneksiDatabase;
import Com.Config.MyConfig;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class App extends javax.swing.JFrame {
    
    private Statement St;
    private Connection Con;
    private ResultSet Rs;
    private String sql = "";
    private DefaultTableModel model;
    
//    private void KoneksiDatabase(){
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/natalia_database","root","");
//            JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
//        }catch(Exception e) {
//            System.out.println("Koneksi Gagal" + e.getMessage());
//        }
//    }
    
    public void clear(){
        TFNamabarang.setText("");
        TFHargabarang.setText("");
        TFJumlahbarang.setText("");
        TFNamabarang.requestFocus();
    }
    public void clear1(){
        TFTotal.setText("");
        TFTunai.setText("");
        TFKembali.setText("");
        TFTunai.requestFocus();
    }
    public  void insertData(){
        DefaultTableModel model = (DefaultTableModel) TblBarang.getModel();
        int row = TblBarang.getRowCount();
        model.addRow(new Object[]{
            row += 1,
            TFNamabarang.getText(),
            TFHargabarang.getText(),
            TFJumlahbarang.getText()
        });
    }
    public double hitungTotal(){
        DefaultTableModel model = (DefaultTableModel) TblBarang.getModel();
//        int[] selectedRows = TblBarang.getSelectedRows();
        int rowCount = model.getRowCount();
        double total = 0.0;
        
//        double total = 0.0;
//        for(int row : selectedRows){
//            double harga = Double.parseDouble(model.getValueAt(row, 2).toString());
//            int jumlah = Integer.parseInt(model.getValueAt(row, 3).toString());
//            total += harga*jumlah;
//        }
        for(int i = 0; i < rowCount; i++){
            double harga = Double.parseDouble(model.getValueAt(i, 2).toString());
            int jumlah = Integer.parseInt(model.getValueAt(i, 3).toString());
            total += harga*jumlah;
        }
        return total;
    }
    public void Show(){
        MyConfig connect = new MyConfig();
        try{
            Con = connect.getConnect();
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM utils");
            model.setRowCount(0);
//            int i = 1;
            while(Rs.next()){
                String[] row = {Rs.getString("ID"), Rs.getString(2), Rs.getString(3), Rs.getString(4)};
                model.addRow(row);
//                i++;
            }
        }catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }
//    public void LoadData(){
//        DefaultTableModel model = (DefaultTableModel) TblDatabase.getModel();
//        model.getDataVector().removeAllElements();
//        sql = "SELECT * FROM utils";
//       
//        try{
//            St = Con.createStatement();
//            Rs = St.executeQuery(sql);
//            int i = 1;
//            while(Rs.next()){
//                String[] row = {Integer.toString(i), Rs.getString(2), Rs.getString(3), Rs.getString(4)};
//                model.addRow(row);
//                i++;
//            }
//        }catch(Exception e){
//            System.out.print("Error" + e.getMessage());
//        }
//    }
    public App() {
        initComponents();
        String [] header = {"ID", "Nama Barang", "Harga Barang", "Jumlah Barang"};
        model = new DefaultTableModel (header,0);
        TblDatabase.setModel(model);
        Show();
//        LoadData();
//        KoneksiDatabase();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LabelUtama = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LabelNamaBarang = new javax.swing.JLabel();
        LabelHargaBarang = new javax.swing.JLabel();
        LabelJumlahBarang = new javax.swing.JLabel();
        TFNamabarang = new javax.swing.JTextField();
        TFHargabarang = new javax.swing.JTextField();
        TFJumlahbarang = new javax.swing.JTextField();
        BTNTambah = new javax.swing.JButton();
        BTNEdit = new javax.swing.JButton();
        BTNDelete = new javax.swing.JButton();
        BTNClear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        LabelTotal = new javax.swing.JLabel();
        LabelTunai = new javax.swing.JLabel();
        LabelKembali = new javax.swing.JLabel();
        TFTotal = new javax.swing.JTextField();
        TFTunai = new javax.swing.JTextField();
        TFKembali = new javax.swing.JTextField();
        BTNHitung = new javax.swing.JButton();
        BTNBayar = new javax.swing.JButton();
        BTNSimpan = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        LabelTabelBarang = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblBarang = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblDatabase = new javax.swing.JTable();
        LabelTabelDatabase = new javax.swing.JLabel();
        BTNEditDB = new javax.swing.JButton();
        BTNDeleteDB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("H071221021_TUGAS_PROYEK");
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(17, 0, 158));
        jPanel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N

        LabelUtama.setBackground(new java.awt.Color(17, 0, 158));
        LabelUtama.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        LabelUtama.setForeground(new java.awt.Color(255, 255, 255));
        LabelUtama.setText("Database Project");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(LabelUtama)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(LabelUtama)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(17, 0, 158));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        LabelNamaBarang.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        LabelNamaBarang.setText("Nama Barang");

        LabelHargaBarang.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        LabelHargaBarang.setText("Harga Barang");

        LabelJumlahBarang.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        LabelJumlahBarang.setText("Jumlah Barang");

        TFNamabarang.setBackground(new java.awt.Color(134, 150, 254));
        TFNamabarang.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        TFNamabarang.setForeground(new java.awt.Color(255, 255, 255));

        TFHargabarang.setBackground(new java.awt.Color(135, 105, 254));
        TFHargabarang.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        TFHargabarang.setForeground(new java.awt.Color(255, 255, 255));
        TFHargabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFHargabarangActionPerformed(evt);
            }
        });

        TFJumlahbarang.setBackground(new java.awt.Color(136, 105, 254));
        TFJumlahbarang.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        TFJumlahbarang.setForeground(new java.awt.Color(255, 255, 255));

        BTNTambah.setBackground(new java.awt.Color(80, 66, 228));
        BTNTambah.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        BTNTambah.setForeground(new java.awt.Color(255, 255, 255));
        BTNTambah.setText("Tambah");
        BTNTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNTambahActionPerformed(evt);
            }
        });

        BTNEdit.setBackground(new java.awt.Color(85, 66, 228));
        BTNEdit.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        BTNEdit.setForeground(new java.awt.Color(255, 255, 255));
        BTNEdit.setText("Edit");
        BTNEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEditActionPerformed(evt);
            }
        });

        BTNDelete.setBackground(new java.awt.Color(96, 66, 228));
        BTNDelete.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        BTNDelete.setForeground(new java.awt.Color(255, 255, 255));
        BTNDelete.setText("Delete");
        BTNDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNDeleteActionPerformed(evt);
            }
        });

        BTNClear.setBackground(new java.awt.Color(101, 66, 228));
        BTNClear.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        BTNClear.setForeground(new java.awt.Color(255, 255, 255));
        BTNClear.setText("Clear");
        BTNClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNClearActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(196, 176, 255));

        LabelTotal.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        LabelTotal.setForeground(new java.awt.Color(255, 255, 255));
        LabelTotal.setText("Total");

        LabelTunai.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        LabelTunai.setForeground(new java.awt.Color(255, 255, 255));
        LabelTunai.setText("Tunai");

        LabelKembali.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        LabelKembali.setForeground(new java.awt.Color(255, 255, 255));
        LabelKembali.setText("Kembali");

        TFTotal.setEditable(false);
        TFTotal.setBackground(new java.awt.Color(137, 150, 254));
        TFTotal.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        TFTotal.setForeground(new java.awt.Color(255, 255, 255));
        TFTotal.setText("Rp.");
        TFTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFTotalActionPerformed(evt);
            }
        });

        TFTunai.setBackground(new java.awt.Color(144, 150, 254));
        TFTunai.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        TFTunai.setForeground(new java.awt.Color(255, 255, 255));
        TFTunai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFTunaiActionPerformed(evt);
            }
        });

        TFKembali.setEditable(false);
        TFKembali.setBackground(new java.awt.Color(145, 150, 254));
        TFKembali.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        TFKembali.setForeground(new java.awt.Color(255, 255, 255));
        TFKembali.setText("Rp.");

        BTNHitung.setBackground(new java.awt.Color(112, 66, 228));
        BTNHitung.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        BTNHitung.setForeground(new java.awt.Color(255, 255, 255));
        BTNHitung.setText("Hitung");
        BTNHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNHitungActionPerformed(evt);
            }
        });

        BTNBayar.setBackground(new java.awt.Color(117, 66, 228));
        BTNBayar.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        BTNBayar.setForeground(new java.awt.Color(255, 255, 255));
        BTNBayar.setText("Bayar");
        BTNBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBayarActionPerformed(evt);
            }
        });

        BTNSimpan.setBackground(new java.awt.Color(128, 66, 228));
        BTNSimpan.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        BTNSimpan.setForeground(new java.awt.Color(255, 255, 255));
        BTNSimpan.setText("Simpan");
        BTNSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(BTNHitung)
                        .addGap(18, 18, 18)
                        .addComponent(BTNBayar)
                        .addGap(18, 18, 18)
                        .addComponent(BTNSimpan))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(LabelKembali)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(TFKembali, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LabelTotal)
                                .addComponent(LabelTunai))
                            .addGap(24, 24, 24)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TFTunai, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                .addComponent(TFTotal)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTotal)
                    .addComponent(TFTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTunai)
                    .addComponent(TFTunai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelKembali)
                    .addComponent(TFKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNHitung)
                    .addComponent(BTNBayar)
                    .addComponent(BTNSimpan))
                .addGap(18, 18, 18))
        );

        jPanel4.setBackground(new java.awt.Color(196, 176, 255));

        LabelTabelBarang.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        LabelTabelBarang.setForeground(new java.awt.Color(255, 255, 255));
        LabelTabelBarang.setText("Tabel Pembelian");

        TblBarang.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        TblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama Barang", "Harga Barang", "Jumlah Barang"
            }
        ));
        TblBarang.setToolTipText("");
        jScrollPane1.setViewportView(TblBarang);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelTabelBarang)
                .addGap(154, 154, 154))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(LabelTabelBarang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jPanel5.setBackground(new java.awt.Color(196, 176, 255));

        TblDatabase.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(TblDatabase);

        LabelTabelDatabase.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        LabelTabelDatabase.setForeground(new java.awt.Color(255, 255, 255));
        LabelTabelDatabase.setText("Tabel Database");

        BTNEditDB.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        BTNEditDB.setText("Edit");
        BTNEditDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEditDBActionPerformed(evt);
            }
        });

        BTNDeleteDB.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        BTNDeleteDB.setText("Delete");
        BTNDeleteDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNDeleteDBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(LabelTabelDatabase)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(BTNEditDB, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNDeleteDB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LabelTabelDatabase)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNEditDB)
                    .addComponent(BTNDeleteDB))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BTNTambah)
                                .addGap(18, 18, 18)
                                .addComponent(BTNEdit)
                                .addGap(18, 18, 18)
                                .addComponent(BTNDelete)
                                .addGap(18, 18, 18)
                                .addComponent(BTNClear))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelJumlahBarang)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TFJumlahbarang))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelNamaBarang)
                                    .addComponent(LabelHargaBarang))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFHargabarang)
                                    .addComponent(TFNamabarang))))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelNamaBarang)
                            .addComponent(TFNamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelHargaBarang)
                            .addComponent(TFHargabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelJumlahBarang)
                            .addComponent(TFJumlahbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTNTambah)
                            .addComponent(BTNEdit)
                            .addComponent(BTNDelete)
                            .addComponent(BTNClear))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TFHargabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFHargabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFHargabarangActionPerformed

    private void TFTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFTotalActionPerformed

    private void TFTunaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFTunaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFTunaiActionPerformed

    private void BTNClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNClearActionPerformed
        // TODO add your handling code here:
//        TFNamabarang.setText("");
//        TFHargabarang.setText("");
//        TFJumlahbarang.setText("");
        clear();
    }//GEN-LAST:event_BTNClearActionPerformed

    private void BTNTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNTambahActionPerformed
        // TODO add your handling code here:
        if(TFNamabarang.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nama Barang Belum di Masukan");
        }else if(TFHargabarang.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harga Barang Belum di Masukan");
        }else if(TFJumlahbarang.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Jumlah Barang Belum di Masukan");
        }else{
            insertData();
            clear();
        }
    }//GEN-LAST:event_BTNTambahActionPerformed

    private void BTNEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEditActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) TblBarang.getModel();
        int rowSelect = TblBarang.getSelectedRow();
        
        if(BTNEdit.getText()=="Edit"){
            BTNTambah.setEnabled(false);
            BTNDelete.setEnabled(false);
            BTNEdit.setText("Update");
            TFNamabarang.setText(model.getValueAt(rowSelect, 1).toString());
            TFHargabarang.setText(model.getValueAt(rowSelect, 2).toString());
            TFJumlahbarang.setText(model.getValueAt(rowSelect, 3).toString());

        }else {
            BTNTambah.setEnabled(true);
            BTNDelete.setEnabled(true);
            BTNEdit.setText("Edit");
            
            String namabarang = TFNamabarang.getText();
            String hargabarang = TFHargabarang.getText();
            String jumlahbarang = TFJumlahbarang.getText();
            
            model.setValueAt(namabarang, rowSelect, 1);
            model.setValueAt(hargabarang, rowSelect, 2);
            model.setValueAt(jumlahbarang, rowSelect, 3);
        }
    }//GEN-LAST:event_BTNEditActionPerformed

    private void BTNDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) TblBarang.getModel();
        int rowSelect = TblBarang.getSelectedRow();
            
        if(rowSelect == -1){
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
          int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin menghapus data ini?", 
                  "Konfirmasi Pengahapusan Data",JOptionPane.YES_NO_OPTION);
          if(confirm == JOptionPane.YES_OPTION){
              model.removeRow(rowSelect);
          }
        }
    }//GEN-LAST:event_BTNDeleteActionPerformed

    private void BTNHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNHitungActionPerformed
        // TODO add your handling code here:
        double total = hitungTotal();
        TFTotal.setText("Rp." + String.valueOf(total));
    }//GEN-LAST:event_BTNHitungActionPerformed

    private void BTNBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBayarActionPerformed
        // TODO add your handling code here:
        try {
            String totalText = TFTotal.getText().substring(3);
            double total = Double.parseDouble(totalText);
            double bayar = Double.parseDouble(TFTunai.getText());
            double kembali = bayar - total;
            TFKembali.setText("Rp." + String.valueOf(kembali));
            
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Input tidak Valid");
        }
    }//GEN-LAST:event_BTNBayarActionPerformed

    private void BTNSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSimpanActionPerformed
        // TODO add your handling code here:
        try{
           Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/natalia_database","root","");
           
           int rowCount = TblBarang.getRowCount();
           for(int i = 0; i < rowCount; i++){
               String Column1 = TblBarang.getValueAt(i, 1).toString();
               String Column2 = TblBarang.getValueAt(i, 2).toString();
               String Column3 = TblBarang.getValueAt(i, 3).toString();
               
               String sql = "INSERT INTO utils (Nama_Barang, Harga_Barang, Jumlah_Barang) VALUES (?,?,?)";
               PreparedStatement statement = Con.prepareStatement(sql);
               
               statement.setString(1, Column1);
               statement.setString(2, Column2);
               statement.setString(3, Column3);
               
               statement.executeUpdate();
           }   
           
           JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke database.");
           Con.close();
           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data ke database.");
        }
        clear1();
    }//GEN-LAST:event_BTNSimpanActionPerformed

    private void BTNDeleteDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNDeleteDBActionPerformed
        // TODO add your handling code here:
//        int rowSelected = TblDatabase.getSelectedRow();
//        String IdDelete = TblDatabase.getValueAt(rowSelected, 0).toString();
//        sql = "DELETE FROM utils WHERE ID='"+IdDelete+"'";
//        
//        try{
//            St = Con.createStatement();
//            St.execute(sql);
//            LoadData();
//            if(rowSelected == -1){
//            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus.",
//                    "Error", JOptionPane.ERROR_MESSAGE);
//            } else {
//              int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin menghapus data ini?", 
//                      "Konfirmasi Pengahapusan Data",JOptionPane.YES_NO_OPTION);
//              if(confirm == JOptionPane.YES_OPTION){
//                  model.removeRow(rowSelected);
//              }
//        }
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
//        }
    }//GEN-LAST:event_BTNDeleteDBActionPerformed

    private void BTNEditDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEditDBActionPerformed
        // TODO add your handling code here:
//        int rowSelected = TblDatabase.getSelectedRow();
//        String IdEdit = TblDatabase.getValueAt(rowSelected, 0).toString();
//        sql = "UPDATE utils SET Nama_Barang='"+ TFNamabarang.getText()+ 
//                "'Harga_Barang='"+ TFHargabarang.getText()+ 
//                "'Jumlah_Barang='"+ TFJumlahbarang.getText()+ 
//                "'WHERE ID='"+ IdEdit+ "'";
//        
//        try{
//            St = Con.createStatement();
//            St.execute(sql);
//            LoadData();
//            if(BTNEditDB.getText()=="Edit"){
//                BTNDeleteDB.setEnabled(false);
//                BTNEditDB.setText("Update");
//                TFNamabarang.setText(model.getValueAt(rowSelected, 1).toString());
//                TFHargabarang.setText(model.getValueAt(rowSelected, 2).toString());
//                TFJumlahbarang.setText(model.getValueAt(rowSelected, 3).toString());
//
//            }else {
//                BTNDeleteDB.setEnabled(true);
//                BTNEditDB.setText("Edit");
//
//                String namabarang = TFNamabarang.getText();
//                String hargabarang = TFHargabarang.getText();
//                String jumlahbarang = TFJumlahbarang.getText();
//
//                model.setValueAt(namabarang, rowSelected, 1);
//                model.setValueAt(hargabarang, rowSelected, 2);
//                model.setValueAt(jumlahbarang, rowSelected, 3);
//            JOptionPane.showMessageDialog(null, "Data Telah Terhapus");
//        }
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
//        }
    }//GEN-LAST:event_BTNEditDBActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new App().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNBayar;
    private javax.swing.JButton BTNClear;
    private javax.swing.JButton BTNDelete;
    private javax.swing.JButton BTNDeleteDB;
    private javax.swing.JButton BTNEdit;
    private javax.swing.JButton BTNEditDB;
    private javax.swing.JButton BTNHitung;
    private javax.swing.JButton BTNSimpan;
    private javax.swing.JButton BTNTambah;
    private javax.swing.JLabel LabelHargaBarang;
    private javax.swing.JLabel LabelJumlahBarang;
    private javax.swing.JLabel LabelKembali;
    private javax.swing.JLabel LabelNamaBarang;
    private javax.swing.JLabel LabelTabelBarang;
    private javax.swing.JLabel LabelTabelDatabase;
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JLabel LabelTunai;
    private javax.swing.JLabel LabelUtama;
    private javax.swing.JTextField TFHargabarang;
    private javax.swing.JTextField TFJumlahbarang;
    private javax.swing.JTextField TFKembali;
    private javax.swing.JTextField TFNamabarang;
    private javax.swing.JTextField TFTotal;
    private javax.swing.JTextField TFTunai;
    private javax.swing.JTable TblBarang;
    private javax.swing.JTable TblDatabase;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    
}

    
