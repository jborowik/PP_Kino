package com.company;

import java.util.ArrayList;

public class kinoHelper {
    Kino zorza = new Kino("Zorza", "Narutowicza 2 10-176 Warszawa", 80);
    public kinoHelper() {
    }

    public void setup() {
        Film tarzan = new Film("Tarzan", 75);
        Film batman1 = new Film("Dark knight", 90);
        Film batman2 = new Film("Batman & robin", 120);
        Film zorro = new Film("Zorro",115);
        Film ironman = new Film("Iron Man", 130);
        Film Narnia1 = new Film("Opowiesci z Narnii", 145);
        Film ochrzestny = new Film("Ojciec Chrzestny", 180);

        zorza.addSala(80);

        zorza.addToRepertuar(tarzan,batman1,batman2,zorro,ironman,Narnia1,ochrzestny);

        zorza.addSeans(tarzan,1,"Pn",1730);
        zorza.addSeans(batman1,1,"Pn",1930);

        zorza.addSeans(batman2,1,"Wt",1630);
        zorza.addSeans(zorro,1,"Wt",2030);

        zorza.addSeans(ironman,1,"Sr",2030);
        zorza.addSeans(Narnia1,1,"Sr",1930);

        zorza.addSeans(ochrzestny,1,"Czw",2130);
        zorza.addSeans(tarzan,1,"Czw",1930);

        zorza.addSeans(batman1,1,"Pt",2230);
        zorza.addSeans(batman2,1,"Pt",1930);

        zorza.addSeans(zorro,1,"So",1700);
        zorza.addSeans(ironman,1,"So",2000);

        zorza.addSeans(Narnia1,1,"Nd",1830);
        zorza.addSeans(ochrzestny,1,"Nd",2030);

        klientCzyAdmin();
    }

    public void klientCzyAdmin(){
        int in = 99;
        while(in != 0) {
            System.out.println("1. Aby wejść jako widz");
            System.out.println("2. Aby wejść jako pracownik");
            System.out.println("0. Aby anulowac");
            in = Integer.parseInt(wyborOpcji("1", "2", "0"));
            if (in == 1)
                klient();
            else if (in == 2)
                pracownik();
            else{
                System.out.println("");
            }
        }
    }

    private void pracownik(){
        int in =99;
        while(in!=0) {
            System.out.println("1. Repertuar");
            System.out.println("2. Seanse");
            System.out.println("3. Kino");
            System.out.println("0. Wyjdz");
            in = Integer.parseInt(wyborOpcji("1", "2", "3", "0"));
            if (in == 1)
                repertuarPracownik();
            else if (in == 2)
                seansePracownik();
            else if (in == 3)
                kinoPracownik();
            else
                System.out.println("Wylogowano");
        }
    }

    private void repertuarPracownik(){
        int in =99;
        while(in!=0) {
            System.out.println("1. Wyswietl repertuar");
            System.out.println("2. Dodaj film do repertuaru");
            System.out.println("3. Usun film z repertuaru");
            System.out.println("0. Cofnij");
            in = Integer.parseInt(wyborOpcji("1", "2","3", "0"));
            if(in == 1)
                wyswietlRepertuar();
            if (in == 2)
                dodajDoRepertuaru();
            else if (in == 3)
                usunZRepertuaru();
        }
    }

    private void dodajDoRepertuaru(){
        System.out.println("Podaj tytul filmu:");
        String tytul = Main.input.nextLine();
        System.out.println("Podaj czas trwania filmu w minutach");
        int czasTrwania = Integer.parseInt(Main.input.nextLine());
        System.out.println("Czy na pewno chcesz dodac \"" + tytul + "\" (" + czasTrwania + "min) do repertuaru?");
        System.out.println("[T/N]");
        String in = wyborOpcji("T","N");
        if(in.equals("T")){
            zorza.addToRepertuar(new Film(tytul,czasTrwania));
            System.out.println("Film zostal dodany");
        }
        else
            System.out.println("Anulowano dodawanie filmu");
    }

    private void usunZRepertuaru(){
        ArrayList<Film> repertuar = wyswietlRepertuar();
        System.out.println("Ktory z filmow chcesz usunac?");
        int id = Integer.parseInt(Main.input.nextLine());
        System.out.println("Czy na pewno chcesz usunac \"" + repertuar.get(id-1).getTitle() + "\" (" + repertuar.get(id-1).getDuration() + "min) z repertuaru?");
        System.out.println("[T/N]");
        String in = wyborOpcji("T","N");
        if(in.equals("T")){
            zorza.usunZRepertuaru(id-1);
            System.out.println("Film zostal usuniety z repertuaru");
        }
        else
            System.out.println("Anulowano usuwanie filmu");
    }

    private void seansePracownik(){
        int in =99;
        while(in!=0) {
            System.out.println("1. Wyswietl lise seansy");
            System.out.println("2. Dodaj pozycję do listy seansy");
            System.out.println("3. Usun pozycje z listy seansy");
            System.out.println("0. Cofnij");
            in = Integer.parseInt(wyborOpcji("1", "2","3", "0"));
            if(in == 1)
                pokazSeanse();
            if (in == 2)
                dodajSeans();
            else if (in == 3)
                usunSeans();
        }
    }

    private void dodajSeans(){
        System.out.println("Wybierz film:");
        ArrayList<Film> repertuar = wyswietlRepertuar();
        int idfilm = Integer.parseInt(Main.input.nextLine());
        zorza.pokazSale();
        System.out.println("Podaj numer Sali:");
        int numerSali = Integer.parseInt(Main.input.nextLine());
        System.out.println("Podaj dzien seansu:");
        String dzien = wybierzDzien();
        System.out.println("Podaj godzine seansu w formacie HHMM");
        int godzina  = Integer.parseInt(Main.input.nextLine());

        System.out.println("Czy chcesz dodac Seans \"" + repertuar.get(idfilm-1).getTitle() + "\" w sali " + numerSali + " dnia: " + dzien + " o godzinie " + godzina/100 + ":" + godzina%100);
        System.out.println("[T/N]");
        String in = wyborOpcji("T","N");
        if(in.equals("T")){
            zorza.addSeans(repertuar.get(idfilm-1),numerSali,dzien,godzina);
            System.out.println("Seans zostal dodany");
        }
        else
            System.out.println("Anulowano dodawanie seansu");
    }

    private void usunSeans(){
        System.out.println("Ktorego dnia chcesz usunac seans?");
        String dzien = wybierzDzien();
        ArrayList<Seans> seanse = zorza.dzienneSeanse(dzien);
        System.out.println("Ktory seans chcesz usunac?");
        int idSeansu = Integer.parseInt(Main.input.nextLine());
        System.out.println("Czy na pewno chcesz usunac seans:");
        System.out.println(seanse.get(idSeansu-1) + " ?");
        System.out.println("[T/N]");
        String in = wyborOpcji("T","N");
        if(in.equals("T")){
            zorza.usunSeans(seanse.get(idSeansu - 1));
            System.out.println("Seans zostal usuniety");
        }
        else
            System.out.println("Anulowano usuwanie seansu");
    }

    private void kinoPracownik(){
        int in =99;
        while(in!=0) {
            System.out.println("1. Edytuj dane kina");
            System.out.println("2. Edytuj liste sal");
            System.out.println("0. Cofnij");
            in = Integer.parseInt(wyborOpcji("1", "2", "0"));
            if(in == 1)
                edytujDaneKina();
            if (in == 2)
                edytujSaleKina();
        }
    }

    private void edytujDaneKina(){
        int in =99;
        while(in!=0) {
            System.out.println("1. Zmien nazwe kina");
            System.out.println("2. Zmien adres kina");
            System.out.println("0. Cofnij");
            in = Integer.parseInt(wyborOpcji("1", "2", "0"));
            if (in == 1)
                zorza.zmienNazwe();
            if (in == 2)
                zorza.zmienAdresKina();
        }
    }

    private void edytujSaleKina(){
        int in =99;
        while(in!=0) {
            System.out.println("1. Wyswietl liste sal");
            System.out.println("2. Dodaj sale");
            System.out.println("3. Usun sale");
            System.out.println("0. Cofnij");
            in = Integer.parseInt(wyborOpcji("1", "2","3", "0"));
            if (in == 1)
                zorza.pokazSale();
            if (in == 2)
                zorza.dodajSale();
            if (in == 3)
                zorza.usunSale();
        }
    }


    private String wyborOpcji(String... opcje) {
        String in = "0";
        boolean correctInput = false;
        while (!correctInput) {
            in = Main.input.nextLine();
            for (String opcja : opcje) {
                if (in.equals(opcja)) {
                    correctInput = true;
                    break;
                }
            }
            if(!correctInput)
                System.out.println("Incorrect input");
        }
        return in;
    }

    private String wybierzDzien(){
        System.out.println("Wybierz dzien: ");
        System.out.println(" Pn, Wt, Sr, Czw, Pt, So, Nd");
        return wyborOpcji("Pn", "Wt", "Sr", "Czw", "Pt", "So", "Nd");
    }

    private void pokazSeanse(){

        int in = 99;
        while(in != 0 ) {
            System.out.println("");
            System.out.println("Pokaz seanse: ");
            System.out.println("1. Wszystkie");
            System.out.println("2. Konkretny dzien");
            System.out.println("0. Anuluj");

            in = Integer.parseInt(wyborOpcji("1","2","0"));
            if (in == 1)
                pokazWszystkieSeanse();
            if (in == 2)
                zorza.dzienneSeanse(wybierzDzien());
        }
    }

    private void pokazWszystkieSeanse(){
        zorza.dzienneSeanse("Pn");
        zorza.dzienneSeanse("Wt");
        zorza.dzienneSeanse("Sr");
        zorza.dzienneSeanse("Czw");
        zorza.dzienneSeanse("Pt");
        zorza.dzienneSeanse("So");
        zorza.dzienneSeanse("Nd");
    }

    public void klient(){
        int in = 99;
        while(in != 0) {
            System.out.println("");
            System.out.println("Witaj w kinie " + zorza.getNazwa());
            System.out.println("1. Repertuar");
            System.out.println("2. Seanse");
            System.out.println("3. Zarezerwuj Bilet");
            System.out.println("0. Wyjdz");

            in = Integer.parseInt(wyborOpcji("1","2","3","0"));

            if (in == 1) {
                wyswietlRepertuarKlient();
            }
            else if (in == 2) {
                pokazSeanse();
            }
            else if ( in == 3){
                rezerwacja();
            }
            else if ( in == 0){
                System.out.println("Zapraszamy ponownie!");
            }
        }
    }

    private ArrayList<Film> wyswietlRepertuar(){
        ArrayList<Film> repertuar = zorza.getRepertuar();
        int id = 1;
        for(Film film: repertuar){
            System.out.println(id + ". " + film.getTitle() + " - Czas trwania: " + film.getDuration() + " minut");
            id++;
        }
        System.out.println("");
        return repertuar;
    }

    private void wyswietlRepertuarKlient(){
        ArrayList<Film> repertuar = wyswietlRepertuar();
        int in = 99;
        while(in != 0){
            System.out.println("1. Sprawdz kiedy gramy film");
            System.out.println("0. Anuluj");
            in = Integer.parseInt(wyborOpcji("1","0"));
            System.out.println("");
            if(in == 1) {
                System.out.println("Ktory film?");
                in = Integer.parseInt(Main.input.nextLine());
                kiedyFilm(repertuar.get(in-1));
            }
        }

    }

    private void kiedyFilm(Film film){
        System.out.println("Pn:");
        zorza.filmDnia(film, "Pn");
        System.out.println("Wt:");
        zorza.filmDnia(film, "Wt");
        System.out.println("Sr:");
        zorza.filmDnia(film, "Sr");
        System.out.println("Czw:");
        zorza.filmDnia(film, "Czw");
        System.out.println("Pt:");
        zorza.filmDnia(film, "Pt");
        System.out.println("So:");
        zorza.filmDnia(film, "So");
        System.out.println("Nd:");
        zorza.filmDnia(film, "Nd");
    }

    private void rezerwacja(){
        System.out.println("Na kiedy chcesz kupic bilet?");
        ArrayList<Seans> seanse = zorza.dzienneSeanse(wybierzDzien());
        System.out.println("");
        String tn;
        int in = 99;
        while (in != 0){
            System.out.println("");
            System.out.println("Na ktory seans chcesz zarezerwowac bilet?");
            System.out.println("Wpisz \"0\" aby anulowac");

            in = Integer.parseInt(Main.input.nextLine());
            if( in < 0 || in > seanse.size()){
                System.out.println("Invalid input");
            }
            else if(in!= 0 ){
                System.out.println("Czy chcesz zarezerwowac bilet na: ");
                System.out.println(seanse.get(in-1).getMovie().getTitle() + " o godzinie " + seanse.get(in-1).getGodzina() + "?");
                System.out.println("[T/N]?");
                tn = Main.input.nextLine();
                if(tn.equals("T")){
                    wybierzMiejsca(seanse.get(in -1));
                }
            }
        }
    }
    private void wybierzMiejsca(Seans seans){
        System.out.println("Wolne miejsca sa oznaczone numerami, zajete miejsca sa oznaczone \"XX\".");
        seans.wyswietlSale();
        System.out.println();
        System.out.println("Podaj po kolei numery interesujacych Cie miejsc:");
        System.out.println("Aby zakonczyc podawanie miejsc wpisz \"0\"");
        int in = 99;
        ArrayList<Integer> miejsca = new ArrayList<>();
        while(in != 0) {
            in = Integer.parseInt(Main.input.nextLine());
            if(in!= 0)
                miejsca.add(in);
        }
        System.out.println("Czy na pewno chcesz zarezerwowac nastepujaca liczbe miejsc : " + miejsca.size() + "?");
        System.out.println("[T/N]");
        String sin = Main.input.nextLine();
        if(sin.equals("T")) {
            int[] tabelamiejsc = new int[miejsca.size()];
            int ile = 0;
            for(int miejsce: miejsca){
                tabelamiejsc[ile] = miejsce;
                ile++;
            }
            seans.zajmijMiejsce(tabelamiejsc);
        }
        else {
            System.out.println("Rezerwacja anulowana");
        }
    }
}