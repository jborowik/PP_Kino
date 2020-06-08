package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Kino {
    private String nazwa;
    private String adres;
    private ArrayList<Film> repertuar = new ArrayList<>();
    private ArrayList<boolean[]> listaSal = new ArrayList<>();
    private ArrayList<Seans> Seanse = new ArrayList<>();

    public Kino() {
    }

    public Kino(String nazwa, String adres, int rozmiarsali) {
        this.nazwa = nazwa;
        this.adres = adres;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void addSala(int size){
        listaSal.add(new boolean[size]);
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public ArrayList<Film> getRepertuar() {
        return repertuar;
    }

    public void setRepertuar(ArrayList<Film> repertuar) {
        this.repertuar = repertuar;
    }

    public void addToRepertuar(Film... args){
        for (Film arg: args){
            repertuar.add(arg);
        }
    }

    public void wyswietlRepertuar(){
        int c =1;
        for(Film a: repertuar){
            System.out.println(c + ". " + a.getTitle());
            c++;
        }
    }



    public void zajmijMiejsce(Seans seans, int... numery){
        seans.zajmijMiejsce();

    }

    public void addSeans(Film film, int numerSali, String dzien, int godzina){
        int miejscWSali = listaSal.get(numerSali-1).length;
        Seanse.add(new Seans(film,numerSali,dzien,godzina,miejscWSali));
    }

    public boolean[] getSala(int numerSali) {
        return listaSal.get(numerSali-1);
    }

    public ArrayList<Seans> dzienneSeanse(String dzien){
        ArrayList<Seans> lista = new ArrayList<>();
        for(Seans s : Seanse){
            if(s.getDzien().equals(dzien))
                lista.add(s);
        }
        Collections.sort(lista);
        System.out.println("");
        System.out.println("" + "Seanse : " + dzien);
        wyswietlListeSeansow(lista);
        return lista;
    }

    private void wyswietlListeSeansow(ArrayList<Seans> lista){
        int id = 1;
        for(Seans s : lista){
            System.out.println(id + ". " + s.toString());
            id++;
        }
    }

    public void filmDnia(Film film, String dzien){
        ArrayList<Seans> lista = new ArrayList<>();
        for(Seans seans : Seanse) {
            if (seans.getDzien().equals(dzien) && seans.getMovie() == film){
                lista.add(seans);
            }
        }
        wyswietlListeSeansow(lista);
    }
    public void usunZRepertuaru(int index){
        repertuar.remove(index);
    }

    public void pokazSale(){
        int numerSali = 1;
        for(boolean[] sala: listaSal){
            System.out.println("Sala "+ numerSali + " - miejsc: " + sala.length);
            numerSali++;
        }
    }

    public void usunSeans(Seans seansDoUsuniecia){
        Seanse.remove(seansDoUsuniecia);
    }

    public void zmienNazwe(){
        System.out.println("Obecna nazwa kina: " + nazwa);
        System.out.println("Podaj nowa nazwe kina: ");
        String nowaNazwa = Main.input.nextLine();
        System.out.println("Czy na pewno chcesz zmienic nazwe kina na \"" + nowaNazwa + "\"?");
        System.out.println("[T/N]?");
        String tn = Main.input.nextLine();
        if(tn.equals("T")){
            setNazwa(nowaNazwa);
            System.out.println("Nazwa zostala zmieniona");
        }
        else{
            System.out.println("Zmiana nazwy zostala anulowana");
        }
    }

    public void zmienAdresKina(){
        System.out.println("Obecny adres kina: " + adres);
        System.out.println("Podaj nowy adres kina: ");
        String nowyAdres = Main.input.nextLine();
        System.out.println("Czy na pewno chcesz zmienic adres kina na \"" + nowyAdres + "\"?");
        System.out.println("[T/N]?");
        String tn = Main.input.nextLine();
        if(tn.equals("T")){
            setAdres(nowyAdres);
            System.out.println("Adres zostal zmieniony");
        }
        else{
            System.out.println("Zmiana adresu zostala anulowana");
        }
    }

    public void dodajSale(){
        System.out.println("Podaj rozmiar nowej sali: ");
        int iloscMiejsc = Integer.parseInt(Main.input.nextLine());
        System.out.println("Czy na pewno chcesz dodac sale posiadajaca \"" + iloscMiejsc + "\" miejsc?");
        System.out.println("[T/N]?");
        String tn = Main.input.nextLine();
        if(tn.equals("T")){
            addSala(iloscMiejsc);
            System.out.println("Sala zostala dodana");
        }
        else{
            System.out.println("Dodawanie sali zostało anulowane");
        }
    }

    public void usunSale(){
        pokazSale();
        System.out.println("Podaj numer sali do usuniecia: ");
        int numerSali = Integer.parseInt(Main.input.nextLine());
        System.out.println("Czy na pewno chcesz usunac sale nr " + numerSali + "?");
        System.out.println("[T/N]?");
        String tn = Main.input.nextLine();
        if(tn.equals("T")){
            listaSal.remove(numerSali-1);
            System.out.println("Sala " + numerSali +" zostala usunieta");
        }
        else{
            System.out.println("Usuwanie sali zostało anulowane");
        }
    }

}
