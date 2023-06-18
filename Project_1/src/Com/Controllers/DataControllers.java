package Com.Controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import Com.Config.DataConfig;

public class DataControllers {
    private static Connection connect = DataConfig.getConnection();
    private static Statement statement;
    private static ResultSet resultSet;

    public static void getDatabase() {
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `utils` ORDER BY ID DESC");

            while (resultSet.next()) {
                System.out.println(
                    resultSet.getString("Nama_Barang")+ ": Rp."+
                    resultSet.getInt("Harga_Barang")+ " (" +
                    resultSet.getInt("Jumlah_Barang") + ")"                    
                );
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertData() {
        String Nama_BarangBaru;
        long Harga_BarangBaru;
        int Jumlah_BarangBaru;

        Scanner input = new Scanner(System.in);

        System.out.print("Nama_Barang : ");
        Nama_BarangBaru = input.nextLine();

        System.out.print("Harga_Barang : ");
        Harga_BarangBaru = input.nextLong();

        System.out.print("Jumlah_Barang : ");
        Jumlah_BarangBaru = input.nextInt();

        try {
            statement = connect.createStatement();
            statement.executeUpdate("INSERT INTO `utils` (`ID`, `Nama_Barang`, `Harga_Barang`, `Jumlah_Barang`) VALUES (NULL, '"+Nama_BarangBaru+"', '"+Harga_BarangBaru+"', '"+Jumlah_BarangBaru+"') ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void editData() {
        int Jumlah_Barang;
        int Id;
        Scanner inp = new Scanner(System.in);
        Scanner inpt = new Scanner(System.in);
        System.out.print("Masukan Jumlah barang yang Ingin di Edit : ");
        Jumlah_Barang = inp.nextInt();
        System.out.print("Masukan Id Barang yang ingin di edit jumlah barang nya : ");
        Id = inpt.nextInt();

        try {
            statement = connect.createStatement();
            statement.executeUpdate("UPDATE `utils` SET `Jumlah_Barang` = '"+ Jumlah_Barang +"' WHERE `utils`.`ID` = " + Id);

            System.out.println("Data berhasil di update");
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteData() {
        int id;
        Scanner sc = new Scanner(System.in);
        System.out.print("masukkan id yang ingin di hapus : ");
        id = sc.nextInt();

        try {
            statement = connect.createStatement();
            statement.executeUpdate("DELETE FROM `utils` WHERE `ID` = " + id);
            System.out.println("Data berhasil dihapus");
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}  
