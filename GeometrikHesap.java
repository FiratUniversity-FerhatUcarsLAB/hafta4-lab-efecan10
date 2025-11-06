 * Ad Soyad: EFECAN ÖNAL
 * Ogrenci No: 250541093
 * Tarih: 6.11.2025
 * Aciklama: Görev 2-Geometrik Hesaplayıcı
   
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * GeometrikHesap sınıfı, kullanıcıdan bir dairenin yarıçapını alır
 * ve bu yarıçapa ait daire ve küre özelliklerini hesaplar.
 * Sonuçlar 2 ondalık basamakla formatlanır.
 */
public class GeometrikHesap {

    // Sabit (final) PI değerini tanımlama
    private static final double PI = 3.14159;

    public static void main(String[] args) {
        // Scanner nesnesi ile kullanıcıdan veri girişi al
        Scanner scanner = new Scanner(System.in);
        
        // Sonuçları 2 ondalık basamakla formatlamak için DecimalFormat
        // #.00 formatı, iki ondalık basamağı zorlar.
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("=== 📐 Geometrik Hesaplayıcı ===");
        System.out.println("Lütfen dairenin yarıçapını (double tipinde) giriniz:");

        // Yarıçapı double tipinde al
        double yaricap;
        try {
            yaricap = scanner.nextDouble();
            
            if (yaricap <= 0) {
                System.out.println("Hata: Yarıçap pozitif bir değer olmalıdır.");
                return; // Programı sonlandır
            }
            
        } catch (java.util.InputMismatchException e) {
            System.out.println("Hata: Geçersiz giriş. Lütfen bir sayı giriniz.");
            return; // Programı sonlandır
        } finally {
            scanner.close(); // Scanner nesnesini kapat
        }

        // --- Hesaplamalar ---
        
        // 1. Dairenin Alanı: π × r²
        double daireAlani = PI * yaricap * yaricap;

        // 2. Dairenin Sınırları (Çevresi): 2 × π × r
        double daireCevresi = 2 * PI * yaricap;

        // 3. Dairenin Çapı: 2 × r
        double daireCapi = 2 * yaricap;

        // 4. Kürenin Hacmi: (4/3) × π × r³
        // Not: 4.0 / 3.0 kullanımı, ondalıklı bölme yapılmasını sağlar.
        double kureHacmi = (4.0 / 3.0) * PI * yaricap * yaricap * yaricap;

        // 5. Kürenin Yüzey Alanı: 4 × π × r²
        double kureYuzeyAlani = 4 * PI * yaricap * yaricap;


        // --- Sonuçların Görüntülenmesi ---
        System.out.println("\n--- 💡 Hesaplama Sonuçları (Yarıçap: " + df.format(yaricap) + ") ---");
        
        // Daire Hesaplamaları
        System.out.println("\n*** Daire Özellikleri ***");
        System.out.println("Dairenin Çapı           : " + df.format(daireCapi));
        System.out.println("Dairenin Çevresi        : " + df.format(daireCevresi));
        System.out.println("Dairenin Alanı          : " + df.format(daireAlani));

        // Küre Hesaplamaları
        System.out.println("\n*** Küre Özellikleri ***");
        System.out.println("Kürenin Yüzey Alanı     : " + df.format(kureYuzeyAlani));
        System.out.println("Kürenin Hacmi           : " + df.format(kureHacmi));
        
        System.out.println("----------------------------------------------");
    }
}
