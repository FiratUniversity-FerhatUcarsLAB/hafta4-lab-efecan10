/*
 * Ad Soyad: EFECAN ÖNAL
 * Ogrenci No: 250541093
 * Tarih: 6.11.2025
 * Aciklama: Gorev 1 - Ogrenci Bilgi Sistemi

     import java.util.Scanner;

// Dosya adıyla aynı olmalı: OgrenciBilgi.java
public class OgrenciBilgi { 

    public static void main(String[] args) {
        Scanner girdi = new Scanner(System.in);

        // Kullanıcıdan Girdileri Alma
        System.out.println("=== ÖĞRENCİ BİLGİ SİSTEMİ GİRİŞ ===");
        System.out.print("Ad: ");
        String ad = girdi.nextLine();
        System.out.print("Soyad: ");
        String soyad = girdi.nextLine();
        System.out.print("Öğrenci No (int): ");
        int ogrenciNo = girdi.nextInt();
        System.out.print("Yaş (int): ");
        int yas = girdi.nextInt();
        System.out.print("GPA (çift): ");
        double gpa = girdi.nextDouble();

        girdi.close();

        // Durum Tespiti
        String durum = (gpa >= 2.00) ? "Basarili Ogrenci" : "Kosullu Ogrenci";

        // Çıktı Formatı: printf() kullanarak düzenli çıktı
        System.out.println("\n=== OGRENCI BILGI SISTEMI ===");
        System.out.printf("Ad Soyad: %s %s\n", ad, soyad);
        System.out.printf("Ogrenci No: %d\n", ogrenciNo);
        System.out.printf("Yas: %d\n", yas);
        System.out.printf("GPA: %.2f\n", gpa);
        System.out.printf("Durum: %s\n", durum);
    }
}
