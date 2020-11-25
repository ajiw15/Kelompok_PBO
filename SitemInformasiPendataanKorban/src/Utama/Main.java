package Utama;

import Entity.*;
import Model.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner (System.in);
    private static KorbanModel korban1 = new KorbanModel();
    private static DataKorbanModel datakorban1 = new DataKorbanModel();
    private static int pilstatus;
    static int cekkorban;
    
     public static void main(String[] args){
        int loop=0;
        do{
           int pilih = 0 ;
           System.out.print("\n Sistem Informasi Korban Bencana" +
                            "\n 1. Daftar Korban Baru" +
                            "\n 2. View Data " +
                            "\n 3. Update Status " +
                            "\n 0. Stop" +
                            "\n Masukkan Pilihan Anda : ");
                        pilih = input.nextInt();
                                if(pilih == 1){
                                  daftar();
                              }else if(pilih == 2){
                              viewdata();
                              }else if(pilih == 3){
                              updatestatus();
                              }else if(pilih == 4){
                              }else{
                                break;
            }
        }while (loop != 1);
     }
        
    static void daftar(){
        input.nextLine();
        System.out.print("Input NIK = ");
        String nik = input.nextLine();
        System.out.print("Input Nama = ");
        String nama = input.nextLine();
        System.out.print("Input Pekerjaan = ");
        String pekerjaan = input.nextLine();
        System.out.print("Input Golongan Darah = ");
        String goldar =  input.nextLine();
        System.out.print("Input Agama = ");
        String agama =  input.nextLine();
        System.out.print("Input Jenis Kelamin = ");
        String jeniskelamin =  input.nextLine();
        System.out.print("Input No Telp = ");
        String notelp =  input.nextLine();
        System.out.print("Input Tgl Lahir (mm/dd/yyyy) = ");
        Date tanggal = new Date(input.next());
        input.nextLine();
        System.out.print("Bantuan = ");
        String bantuan = input.nextLine();
        korban1.insert(new KorbanEntity(nik,nama,pekerjaan,goldar,agama,jeniskelamin,notelp,bantuan,tanggal));
    }

    static void viewdata(){
        input.nextLine();
        System.out.print("NIK : ");
        String nik = input.nextLine();
        System.out.print("Nama : ");
        String nama = input.nextLine();
        cekkorban = korban1.cekData(nik, nama);
        System.out.println("\n Data Dari "+korban1.getkorbanEntityArrayList(cekkorban).getNama());
        int cekstatus = datakorban1.cekData(nik, nama);
        if (cekstatus == -1){
            System.out.println("\n Status Anda Belom Di Daftarkan");
                daftarstatus();
        }else if(cekstatus == -2){
            System.out.println("\n Status Anda Belom Di Daftarkan");
                daftarstatus();
        }else{
        System.out.println("Nama = "+datakorban1.showDataKorban(cekkorban).getKorban().getNama());
        System.out.println("NIK = "+datakorban1.showDataKorban(cekkorban).getKorban().getNik());
        System.out.println("Pekerjaan = "+datakorban1.showDataKorban(cekkorban).getKorban().getPekerjaan());
        System.out.println("Golongan Darah = "+datakorban1.showDataKorban(cekkorban).getKorban().getGoldarah());
        System.out.println("Agama = "+datakorban1.showDataKorban(cekkorban).getKorban().getAgama());
        System.out.println("Jenis Kelamin = "+datakorban1.showDataKorban(cekkorban).getKorban().getJeniskelamin());
        System.out.println("No Telp = "+datakorban1.showDataKorban(cekkorban).getKorban().getNotelp());
        System.out.println("Tanggal Lahir = "+new SimpleDateFormat("dd-MM-yyyy").format(datakorban1.showDataKorban(cekkorban)
                .getKorban().getTglLahir()));
        System.out.println("Status Korban = "+StatusEntity.status[datakorban1.showDataKorban(cekkorban).getIndexStatus()]);
        }
    }
    
    static void daftarstatus(){
        System.out.print("Pilih Status = \n");
        for(int i=0;i<StatusEntity.status.length;i++){
        System.out.println(i+". "+StatusEntity.status[i]);
        }
        System.out.print("Pilih Status = ");
            pilstatus = input.nextInt();
            datakorban1.insertDataKorban(new DataKorbanEntity(pilstatus,
               korban1.getkorbanEntityArrayList(cekkorban)));
        }
    static void updatestatus(){
        System.out.print("Input NIK = ");
        String nik = input.next();
        datakorban1.update(nik);
    }
}
