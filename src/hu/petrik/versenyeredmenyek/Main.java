package hu.petrik.versenyeredmenyek;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static Map <String, List<Eredmeny>> sportagEredmenyek = new HashMap<>();
    public static void main(String[] args) {
        String fajlnev = "eredmenyek.txt";
        try {
            Beolvas(fajlnev);
        } catch (FileNotFoundException e) {
            System.out.printf("A %s fájl nem található", fajlnev);
        }
        Kiiras();
        System.out.printf("Az olimpia veresneyszámok száma %d ", getSportAgakSzama());
        getVersenyzokSzama();
    }

    private static int getVersenyzokSzama() {
        List<String> versenyzok = new ArrayList<>();
        for(Map.Entry<String, List<Eredmeny>> entry : sportagEredmenyek.entrySet()) {
            List<Eredmeny> eredmey = entry.getValue();
            for(Eredmeny e : eredmey) {
                if (!versenyzok.contains(e.getNev())) {
                    versenyzok.add(e.getNev());
                }

            }
        }
        return versenyzok.size();
    }

    private static int getSportAgakSzama() {
        return sportagEredmenyek.keySet().size();
    }

    private static void Kiiras() {
        for (Map.Entry<String, List<Eredmeny>> entry : sportagEredmenyek.entrySet()) {
            String sportag = entry.getKey();
            List<Eredmeny> eredmenyek = entry.getValue();
            System.out.println(sportag);
            for(Eredmeny e : eredmenyek) {
                System.out.println("\t" + e);
            };
        };
    }

    private static void Beolvas(String fajlnev) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fajlnev));
        while(sc.hasNext()) {
            String[] sor = sc.nextLine().split(" ");
            String sportag = sor[0];
            String reszIdo = sor[1];
            String nev = sor[2] + " " + sor[3];
            Eredmeny e = new Eredmeny(reszIdo, nev);
            sportagEredmenyek.putIfAbsent(sportag, new ArrayList<>());
            sportagEredmenyek.get(sportag).add(e);

        }
        sc.close();
    }
}
