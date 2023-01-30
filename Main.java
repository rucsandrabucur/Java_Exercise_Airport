import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Aeroport aeroport = Aeroport.getInstance();
        System.out.println("Introduceti comanda:");
        String comanda;

        MyThread myThread = new MyThread();
        myThread.start();

        while (true) {
            comanda = scanner.nextLine();
            String[] cuvinte = comanda.split("\\s+");

            int nrPasageri;
            double pretCursa;
            boolean areEscala;

            switch (cuvinte[0]) {

                case "exit":
                    myThread.interrupt();
                    if(myThread.isAlive()){
                        myThread.setShouldExit(true);
                    }
                    return;

                case "afisare":
                    aeroport.afisareToateCursele();
                    break;

                case "adaugaCursaInterna":
                    pretCursa = Double.valueOf(cuvinte[1]);
                    nrPasageri = Integer.valueOf(cuvinte[2]);
                    areEscala = Boolean.parseBoolean(cuvinte[4]);
                    if(areEscala) {

                        try {
                            aeroport.adaugaCursaInterna(new CursaInterna(pretCursa * 1.15, nrPasageri, cuvinte[3], areEscala));
                        } catch (PreaMulteCurseException e) {
                            System.out.println(e);
                        }
                    }
                            else {
                            try {
                                aeroport.adaugaCursaInterna(new CursaInterna(pretCursa, nrPasageri, cuvinte[3], areEscala));
                            }catch (PreaMulteCurseException e){
                                System.out.println(e);
                        }

                    }
                    break;

                case "adaugaCursaExterna":
                    pretCursa = Double.valueOf(cuvinte[1]);
                    nrPasageri = Integer.valueOf(cuvinte[2]);
                    areEscala = Boolean.parseBoolean(cuvinte[4]);

                    try{
                        aeroport.adaugaCursaExterna(new CursaExterna(pretCursa * 0.9, nrPasageri, cuvinte[3], areEscala, cuvinte[5]));
                    }
                    catch (PreaMulteCurseException e){
                        System.out.println(e);
                    }
                    break;

                case "aflaTipCursa":
                    pretCursa = Double.valueOf(cuvinte[1]);
                    nrPasageri = Integer.valueOf(cuvinte[2]);
                    areEscala = Boolean.parseBoolean(cuvinte[4]);
                    aeroport.aflaTipCursa(new Cursa(pretCursa, nrPasageri, cuvinte[3], areEscala));
                    break;

                case "afisareCurseExterne":
                    aeroport.afisareCurseExterne();
                    break;

                default:
                    System.out.println("Comanda gresita. Try again!");

            }
        }
    }
}