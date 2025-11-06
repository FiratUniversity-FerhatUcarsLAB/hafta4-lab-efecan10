Ad Soyad: EFECAN ÖNAL
 * Ogrenci No: 250541093
 * Tarih: 6.11.2025
 * Aciklama:Görev 3- Maaş Hesaplama
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * MaasHesap sınıfı, bir çalışanın brüt maaş, mesai ve çeşitli kesintilere göre
 * net maaşını ve ek istatistikleri hesaplar.
 */
public class MaasHesap {

    // --- Özel Gereksinim: Sabit (final) Kesinti Oranları ---
    private static final double SGK_ORANI = 0.14;       // %14
    private static final double GELIR_VERGISI_ORANI = 0.15; // %15
    private static final double DAMGA_VERGISI_ORANI = 0.00759; // %0.759
    private static final double MESAI_CARPANI = 1.5;   // Mesai saati devamı
    private static final int AYLIK_ORT_CALISMA_SAATI = 160;
    private static final int AYLIK_IS_GUNU = 22;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Formatlayıcılar: Para (2 ondalık), Yüzde/Oran (1 ondalık)
        DecimalFormat paraFormat = new DecimalFormat("0.00");
        DecimalFormat oranFormat = new DecimalFormat("0.0");

        System.out.println("=== 💰 Maaş Hesaplama Sistemi ===");
        
        // Kullanıcıdan Bilgi Alma
        System.out.print("Çalışanın Adı ve Soyadı: ");
        String adSoyad = scanner.nextLine();
        
        System.out.print("Aylık Brüt Maaş (TL): ");
        double brutMaas = scanner.nextDouble();
        
        // Haftalık çalışma saati bu hesaplamada doğrudan kullanılmasa da istenmiştir.
        System.out.print("Haftalık Çalışma Saati (int): ");
        int haftalikCalismaSaati = scanner.nextInt(); 
        
        System.out.print("Mesai Saati Sayısı (int): ");
        int mesaiSaati = scanner.nextInt();
        
        scanner.close();

        // --- Hesaplamalar ---

        // 1. Mesai Ücreti Hesaplama
        // Mesai ücreti = (Brüt Maaş / 160) × Mesai Saati × 1,5
        double saatlikBrutUcret = brutMaas / AYLIK_ORT_CALISMA_SAATI;
        double mesaiUcreti = saatlikBrutUcret * mesaiSaati * MESAI_CARPANI;

        // 2. Toplam Gelir
        // Toplam Gelir: Brüt devam + Mesai ücreti
        double toplamGelir = brutMaas + mesaiUcreti;

        // 3. Kesintiler Hesaplama
        double sgkKesintisi = toplamGelir * SGK_ORANI;
        double gelirVergisi = toplamGelir * GELIR_VERGISI_ORANI;
        double damgaVergisi = toplamGelir * DAMGA_VERGISI_ORANI;
        
        // Toplam Kesinti
        double toplamKesinti = sgkKesintisi + gelirVergisi + damgaVergisi;

        // 4. Net Maaş
        // Net Maaş = Toplam Gelir - Toplam Kesinti
        double netMaas = toplamGelir - toplamKesinti;

        // 5. İstatistikler
        // Kesinti Oranı (yüzde olarak)
        double kesintiOraniYuzde = (toplamKesinti / toplamGelir) * 100;

        // Saatlik net kazanç
        // Ayda toplam çalışılan saat (varsayım: brüt maaş 160 saate karşılık gelir)
        int toplamCalismaSaati = AYLIK_ORT_CALISMA_SAATI + mesaiSaati;
        double saatlikNetKazanc = netMaas / toplamCalismaSaati;
        
        // Günlük net kazanç (22 iş günü)
        double gunlukNetKazanc = netMaas / AYLIK_IS_GUNU;


        // --- Çıktı Formatı: Profesyonel Bordro Bileşimi ---
        
        System.out.println("\n==============================================");
        System.out.println("          🧾 AYLIK MAAŞ BORDROSU 🧾          ");
        System.out.println("==============================================");
        System.out.println("Çalışan Adı Soyadı : " + adSoyad);
        System.out.println("Brüt Maaş          : " + paraFormat.format(brutMaas) + " TL");
        System.out.println("Mesai Saati        : " + mesaiSaati + " Saat");
        System.out.println("----------------------------------------------");
        
        // Gelir Detayları
        System.out.println(">>> GELİRLER");
        System.out.println("Brüt Normal Maaş   : " + paraFormat.format(brutMaas) + " TL");
        System.out.println("Mesai Ücreti       : " + paraFormat.format(mesaiUcreti) + " TL");
        System.out.println("----------------------------------------------");
        System.out.println("** TOPLAM GELİR     : " + paraFormat.format(toplamGelir) + " TL **");
        System.out.println("----------------------------------------------");

        // Kesinti Detayları
        System.out.println(">>> KESİNTİLER");
        System.out.println("SGK Kesintisi (%14)  : " + paraFormat.format(sgkKesintisi) + " TL");
        System.out.println("Gelir Vergisi (%15)  : " + paraFormat.format(gelirVergisi) + " TL");
        System.out.println("Damga Vergisi (0.759%): " + paraFormat.format(damgaVergisi) + " TL");
        System.out.println("----------------------------------------------");
        System.out.println("** TOPLAM KESİNTİ   : " + paraFormat.format(toplamKesinti) + " TL **");
        System.out.println("==============================================");
        
        // Net Maaş
        System.out.println("⭐ NET MAAŞ          : " + paraFormat.format(netMaas) + " TL ⭐");
        
        System.out.println("==============================================");

        // İstatistikler
        System.out.println("\n--- 📊 İSTATİSTİKLER ---");
        System.out.println("Toplam Çalışılan Saat: " + toplamCalismaSaati + " Saat");
        System.out.println("Kesinti Oranı        : %" + oranFormat.format(kesintiOraniYuzde));
        System.out.println("Saatlik Net Kazanç   : " + paraFormat.format(saatlikNetKazanc) + " TL");
        System.out.println("Günlük Net Kazanç (22 İş Günü): " + paraFormat.format(gunlukNetKazanc) + " TL");
        System.out.println("----------------------------------------------");
    }
}
