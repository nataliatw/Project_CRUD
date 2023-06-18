# App
Didalam 'App.java' terdapat object dari class Menu, dimana object ini akan memanggil method
'''java 
menu.showMenu();
'''
yang bertujuan untuk menampilkan menu program sesusai dengan implementasi di dalam kelas Menu 

# Com
terdapat beberapa package di dalamnya yaitu :
1. Config
2. Controllers
3. Layout
4. Models

## Config
Didalam Config terdapat file 'DataConfig.java' yang didalamnya memiliki class DataConfig, di dalam class tersebut mempunyai variabel konstanta dan variabel statis yaitu :
1. DB_URL : URL atau alamat koneksi ke database MySQL yang ditentukan dalam format "jdbc:mysql://localhost:3306/natalia_database"
2. DB_USER : Username atau nama pengguna untuk mengakses database, dalam program ini username adalah 'root'
3. DB_PASS : Password atau kata sandi untuk mengakses database, dalam program ini passsword di biarkan kosong
4. 'connect' : variabel statis yang digunakan untuk menyimpan koneksi database, dalam program ini mengunakan object 'Connection' dari JDBC untuk merepresentasikan koneksi ke database
selain memiliki variabel didalam 'DataConfig.java terdapat method getConnection() untuk mendapatkan koneksi ke database. 

## Controllers
Didalam Controllers terdapat file 'DataControllers.java' yang didalamnya memiliki class DataControllers, di dalam class tersebut mempunyai beberapa method yaitu :
1. 'getDatabase()' : Digunakan untuk mengambil data dari tabel 'utils' dalam database.
2. 'insertData()' : Digunakan untuk menyisipkan data baru ke dalam tabel 'utils' dalam database.
3. 'editData()' : Digunakan untuk mengedit jumlah barang dalam tabel 'utils' berdasarkan ID barang.
4. 'deleteData()' : Digunakan untuk mengahapus data dalam tabel 'utils' berdasarkan ID barang.

## Layout
di dalam Layout terdapat beberapa file yaitu :
1. 'DeleteDataAction.java'
2. 'EditDataAction.java'
3. 'InsertDataAction.java'
4. 'ReadDataAction.java'

### DeleteDataAction
Didalam 'DeleteDataAction.java' terdapat object dari kelas DataControllers untuk memanggil method 'deleteData()' yang ada didalamnya, yang berfungsi sebagai pengatur tindakan penghapusan data.

### EditDataAction
Didalam 'EditDataAction.java' terdapat object dari kelas DataControllers untuk memanggil method 'editData()' yang ada didalamnya, yang berfungsi sebagai pengatur tindakan pengeditan data.

### InsertDataAction
Didalam 'InsertDataAction.java' terdapat object dari kelas DataControllers untuk memanggil method 'insertData()' yang ada didalamnya, yang berfungsi sebagai pengatur tindakan penyisipan data.

### ReadDataAction
Didalam 'ReadDataAction.java' terdapat object dari kelas DataControllers untuk memanggil method 'getDatabase()' yang ada didalamnya, yang berfungsi sebagai pengatur tindakan pembacaan data.

## Models
Didalam Models terdapat file 'Menu.java' yang didalamnya memiliki class Menu, didalam class tersebut mempunyai method showMenu() yang didalamnya menu ditampilkan dengan menggunakan perintah System.out.println untuk mencetak teks ke layar. Pada program ini, program akan masuk ke dalam loop while (true) yang akan berjalan terus menerus sampai ada perintah keluar. Di dalam loop ini, pengguna diminta untuk memilih aksi dengan memasukkan angka melalui Scanner. Kemudian, menggunakan pernyataan switch, aksi yang sesuai dipilih berdasarkan pilihan pengguna. Pada case 1 class ReadDataAction akan dipanggil, pada case 2 class InsertdataAction akan dipanggil, pada case 3 class EditDataAction akan di panggil, pada case 4 class DeleteDataAction akan di panggil, dan pada case 5 pesan penutup akan ditampilkan dan program akan berhenti. Dan apabila selain case 1-5 maka akan ditampilkan "Pilihan tidak tersedia"