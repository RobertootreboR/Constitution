import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by robert on 05.12.16.
 */
public class AppTest {
    @Test
    public void main() throws Exception {

        String[] ar125127 = new String[]{"/home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt", "-ar", "125", "127"};
        String[] a124 = new String[]{"/home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt", "-a", "124"};
        String[] c12 = new String[]{"/home/robert/Pobrane/obiektowe-lab-master/lab8/konstytucja.txt", "-c", "12"};
        ParsingDetails detailsA = new ArgumentParser().parseArguments(a124);
        ParsingDetails detailsAR = new ArgumentParser().parseArguments(ar125127);
        ParsingDetails detailsC = new ArgumentParser().parseArguments(c12);
        new ChapterParser(detailsC).searchForChapter();
        new ArticleParser(detailsAR).searchForArticles();
        assertEquals(new ArticleParser(detailsA).searchForArticles().toString(), "Art. 124.\n" +
                "Do Senatu stosuje się odpowiednio przepisy art. 110, art. 112, art. 113 i art. 120.\n");

        assertEquals(new ArticleParser(detailsAR).searchForArticles().toString(), "Art. 125.\n" +
                "1. W sprawach o szczególnym znaczeniu dla państwa może być przeprowadzone\n" +
                "referendum ogólnokrajowe.\n" +
                "2. Referendum ogólnokrajowe ma prawo zarządzić Sejm bezwzględną większością\n" +
                "głosów w obecności co najmniej połowy ustawowej liczby posłów lub Prezydent\n" +
                "Rzeczypospolitej za zgodą Senatu wyrażoną bezwzględną większością głosów w\n" +
                "obecności co najmniej połowy ustawowej liczby senatorów.\n" +
                "3. Jeżeli w referendum ogólnokrajowym wzięło udział więcej niż połowa\n" +
                "uprawnionych do głosowania, wynik referendum jest wiążący.\n" +
                "4. Ważność referendum ogólnokrajowego oraz referendum, o którym mowa w art.\n" +
                "235 ust. 6, stwierdza Sąd Najwyższy.\n" +
                "5. Zasady i tryb przeprowadzania referendum określa ustawa.\n" +
                "Art. 126.\n" +
                "1. Prezydent Rzeczypospolitej Polskiej jest najwyższym przedstawicielem\n" +
                "Rzeczypospolitej Polskiej i gwarantem ciągłości władzy państwowej.\n" +
                "2. Prezydent Rzeczypospolitej czuwa nad przestrzeganiem Konstytucji, stoi na\n" +
                "straży suwerenności i bezpieczeństwa państwa oraz nienaruszalności i\n" +
                "niepodzielności jego terytorium.\n" +
                "3. Prezydent Rzeczypospolitej wykonuje swoje zadania w zakresie i na zasadach\n" +
                "określonych w Konstytucji i ustawach.\n");

        /*  The original text:
        Art. 125.
1. W sprawach o szczególnym znaczeniu dla państwa może być przeprowadzone
referendum ogólnokrajowe.
2. Referendum ogólnokrajowe ma prawo zarządzić Sejm bezwzględną większością
głosów w obecności co najmniej połowy ustawowej liczby posłów lub Prezydent
Rzeczypospolitej za zgodą Senatu wyrażoną bezwzględną większością głosów w
obecności co najmniej połowy ustawowej liczby senatorów.
3. Jeżeli w referendum ogólnokrajowym wzięło udział więcej niż połowa upraw-
nionych do głosowania, wynik referendum jest wiążący.
4. Ważność referendum ogólnokrajowego oraz referendum, o którym mowa w art.
235 ust. 6, stwierdza Sąd Najwyższy.
5. Zasady i tryb przeprowadzania referendum określa ustawa.
Rozdział V
PREZYDENT RZECZYPOSPOLITEJ POLSKIEJ
Art. 126.
1. Prezydent Rzeczypospolitej Polskiej jest najwyższym przedstawicielem Rzeczy-
pospolitej Polskiej i gwarantem ciągłości władzy państwowej.
2. Prezydent Rzeczypospolitej czuwa nad przestrzeganiem Konstytucji, stoi na
straży suwerenności i bezpieczeństwa państwa oraz nienaruszalności i niepo-
dzielności jego terytorium.
3. Prezydent Rzeczypospolitej wykonuje swoje zadania w zakresie i na zasadach
określonych w Konstytucji i ustawach.
         */

        assertEquals(new ChapterParser(detailsC).searchForChapter().toString(), "Rozdział XII\n" +
                "ZMIANA KONSTYTUCJI\n" +
                "Art. 235.\n" +
                "1. Projekt ustawy o zmianie Konstytucji może przedłożyć co najmniej 1/5\n" +
                "ustawowej liczby posłów, Senat lub Prezydent Rzeczypospolitej.\n" +
                "2. Zmiana Konstytucji następuje w drodze ustawy uchwalonej w jednakowym\n" +
                "brzmieniu przez Sejm i następnie w terminie nie dłuższym niż 60 dni przez\n" +
                "Senat.\n" +
                "3. Pierwsze czytanie projektu ustawy o zmianie Konstytucji może odbyć się nie\n" +
                "wcześniej niż trzydziestego dnia od dnia przedłożenia Sejmowi projektu ustawy.\n" +
                "4. Ustawę o zmianie Konstytucji uchwala Sejm większością co najmniej 2/3\n" +
                "głosów w obecności co najmniej połowy ustawowej liczby posłów oraz Senat\n" +
                "bezwzględną większością głosów w obecności co najmniej połowy ustawowej\n" +
                "liczby senatorów.\n" +
                "5. Uchwalenie przez Sejm ustawy zmieniającej przepisy rozdziałów I, II lub XII\n" +
                "Konstytucji może odbyć się nie wcześniej niż sześćdziesiątego dnia po\n" +
                "pierwszym czytaniu projektu tej ustawy.\n" +
                "6. Jeżeli ustawa o zmianie Konstytucji dotyczy przepisów rozdziału I, II lub XII,\n" +
                "podmioty określone w ust. 1 mogą zażądać, w terminie 45 dni od dnia\n" +
                "uchwalenia ustawy przez Senat, przeprowadzenia referendum zatwierdzającego. Z\n" +
                "wnioskiem w tej sprawie podmioty te zwracają się do Marszałka Sejmu, który\n" +
                "zarządza niezwłocznie przeprowadzenie referendum w ciągu 60 dni od dnia złożenia\n" +
                "wniosku. Zmiana Konstytucji zostaje przyjęta, jeżeli za tą zmianą opowiedziała\n" +
                "się większość głosujących.\n" +
                "7. Po zakończeniu postępowania określonego w ust. 4 i 6 Marszałek Sejmu\n" +
                "przedstawia Prezydentowi Rzeczypospolitej uchwaloną ustawę do podpisu. Prezydent\n" +
                "Rzeczypospolitej podpisuje ustawę w ciągu 21 dni od dnia przedstawienia i\n" +
                "zarządza jej ogłoszenie w Dzienniku Ustaw Rzeczypospolitej Polskiej.\n");


/* Original Chapter:
Rozdział XII
ZMIANA KONSTYTUCJI
Art. 235.
1. Projekt ustawy o zmianie Konstytucji może przedłożyć co najmniej 1/5 ustawo-
wej liczby posłów, Senat lub Prezydent Rzeczypospolitej.
2. Zmiana Konstytucji następuje w drodze ustawy uchwalonej w jednakowym
brzmieniu przez Sejm i następnie w terminie nie dłuższym niż 60 dni przez Se-
nat.
3. Pierwsze czytanie projektu ustawy o zmianie Konstytucji może odbyć się nie
wcześniej niż trzydziestego dnia od dnia przedłożenia Sejmowi projektu ustawy.
4. Ustawę o zmianie Konstytucji uchwala Sejm większością co najmniej 2/3 gło-
sów w obecności co najmniej połowy ustawowej liczby posłów oraz Senat bez-
względną większością głosów w obecności co najmniej połowy ustawowej licz-
by senatorów.
5. Uchwalenie przez Sejm ustawy zmieniającej przepisy rozdziałów I, II lub XII
Konstytucji może odbyć się nie wcześniej niż sześćdziesiątego dnia po pierw-
szym czytaniu projektu tej ustawy.
6. Jeżeli ustawa o zmianie Konstytucji dotyczy przepisów rozdziału I, II lub XII,
podmioty określone w ust. 1 mogą zażądać, w terminie 45 dni od dnia uchwale-
nia ustawy przez Senat, przeprowadzenia referendum zatwierdzającego. Z wnio-
skiem w tej sprawie podmioty te zwracają się do Marszałka Sejmu, który zarzą-
dza niezwłocznie przeprowadzenie referendum w ciągu 60 dni od dnia złożenia
wniosku. Zmiana Konstytucji zostaje przyjęta, jeżeli za tą zmianą opowiedziała
się większość głosujących.
7. Po zakończeniu postępowania określonego w ust. 4 i 6 Marszałek Sejmu przed-
stawia Prezydentowi Rzeczypospolitej uchwaloną ustawę do podpisu. Prezydent
Rzeczypospolitej podpisuje ustawę w ciągu 21 dni od dnia przedstawienia i za-
rządza jej ogłoszenie w Dzienniku Ustaw Rzeczypospolitej Polskiej.
©Kancelaria Sejmu
2009-11-16

*/


    }

}