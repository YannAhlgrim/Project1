package programm;

import java.util.Comparator;

public class TerminComp implements Comparator<Termin>{

    @Override
    public int compare(Termin t1, Termin t2){
      
    int i = t1.getZeit().getDayOfMonth() - t2.getZeit().getDayOfMonth();
    
    if(i == 0){
            if(t1.getZeit().getHour()-t2.getZeit().getHour() == 0){
              return t1.getZeit().getMinute()-t2.getZeit().getMinute();
            }else{
              return t1.getZeit().getHour()-t2.getZeit().getHour();
            }
       }else{
         return i;
       }
    }

}
