package com.company;

public class Seans implements Comparable<Seans> {
    private Film movie;
    private int numerSali;
    private String dzien;
    private int godzina;
    private boolean[] miejsc;

    public Seans(Film movie, int numerSali, String dzien, int godzina, int iloscmiejsc) {
        this.movie = movie;
        this.numerSali = numerSali;
        this.dzien = dzien;
        this.godzina = godzina;
        miejsc = new boolean[iloscmiejsc];
    }

    @Override
    public String toString() {
        String s = String.valueOf(godzina);
        return movie.getTitle() +" sala " + numerSali + " dnia: " + dzien +" - godzina  " + s.substring(0,2) + ":" + s.substring(2,4);
    }

    public Film getMovie() {
        return movie;
    }

    public int getSala() {
        return numerSali;
    }

    public String getDzien() {
        return dzien;
    }

    public int getGodzina() {
        return godzina;
    }

    public void zajmijMiejsce(int... numery){
        boolean wolne = true;
        for(int numer: numery) {
            if (miejsc[numer - 1]) {
                wolne = false;
                System.out.println(numer - 1 + " wolne");
            }
        }
        if(wolne){
            for(int numer: numery) {
                numer--;
                miejsc[numer] = true;
            }
            System.out.println("Miejsca zostały zarezerwowane");
        }
        else{
            System.out.println("Przynajmniej jedno z podanych miejsc jest juz zajete. Miejsca nie zostaly zarezerwowane.");
        }
    }
    public void wyswietlSale(){
        int rozmiarRzedu = miejsc.length/10;
        int numer = 0;
        System.out.println("                       SCREEN                      ");
        System.out.println("---------------------------------------------------");

        for(boolean miejsce: miejsc){
            if(numer % rozmiarRzedu == 0)
                System.out.println("");
            if(!miejsce) {
                String druk = String.format("%02d", numer+1);
                System.out.print(" [" + druk + "]");
            }
            else{
                System.out.print(" [XX]");
            }
            numer++;
        }
    }

    @Override
    public int compareTo(Seans otherSeans) {
        return this.getGodzina()-otherSeans.getGodzina();
    }
}
