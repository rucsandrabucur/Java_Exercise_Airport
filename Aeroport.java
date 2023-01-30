import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aeroport {
    List<CursaExterna> cursaExternaList = new ArrayList<>();
    List<CursaInterna> cursaInternaList = new ArrayList<>();
    private Aeroport(){

    }
    private static final class SingletonHolder{
        private static final Aeroport SINGLETON = new Aeroport();
    }

    public static Aeroport getInstance(){
        return SingletonHolder.SINGLETON;
    }

    public boolean verificaNrMaxCurse()
    {
        if (cursaExternaList.size() + cursaInternaList.size() > 30 ){
            return false;
        }
        return true;
    }

    public void afisareCurseExterne(){
        cursaExternaList.stream()
                .forEach(System.out::println);
    }

    public void afisareToateCursele(){
        cursaExternaList.stream()
                .forEach(System.out::println);

        cursaInternaList.stream()
                .forEach(System.out::println);

    }

    public void adaugaCursaInterna(CursaInterna cursaInterna) throws PreaMulteCurseException{

        if(verificaNrMaxCurse()){
            cursaInternaList.add(cursaInterna);
        } else {
            throw new PreaMulteCurseException("Numarul maxim de curse a fost atins!");
        }
    }

    public void adaugaCursaExterna(CursaExterna cursaExterna) throws PreaMulteCurseException{
        if(verificaNrMaxCurse()){
            cursaExternaList.add(cursaExterna);
        } else {
            throw new PreaMulteCurseException("Numarul maxim de curse a fost atins!");
        }
    }

    public void aflaTipCursa(Cursa cursa){

        if(cursaInternaList.contains(cursa)){
            System.out.println("Aceasta este o cursa interna!");
        } else if (cursaExternaList.contains(cursa)) {
            System.out.println("Aceasta este o cursa externa!");
        }
    }

    public int nrCurseCurente(){
        return cursaExternaList.size() + cursaInternaList.size();
    }
}
