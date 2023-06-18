package Com.Models;

import java.util.Scanner;
import Com.Layout.DeleteDataAction;
import Com.Layout.EditDataAction;
import Com.Layout.ReadDataAction;
import Com.Layout.InsertDataAction;

public class Menu {
    public void showMenu() throws Exception {
        Scanner input = new Scanner(System.in);
        int choice;

        System.out.println("-".repeat(20));
        System.out.println("WELCOME TO  APLIKASI PENGECEKAN DATA BASE");
        System.out.println("-".repeat(20));
        System.out.println("1. Read Data");
        System.out.println("2. Insert Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Delete Data");
        System.out.println("5. Exit");
        System.out.println("-".repeat(20));

        while (true) {
            System.out.println("-".repeat(20));
            System.out.print("Pilih: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    ReadDataAction.readData();
                    break;
                case 2:
                    InsertDataAction.insertData();
                    break;
                case 3:
                    EditDataAction.editData();
                    break;
                case 4:
                    DeleteDataAction.deleteData();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
                    break;
            }
        }
    }    
}