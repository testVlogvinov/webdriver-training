import java.util.Date;

/**
 * Created by v.logvinov on 1/3/2017.
 */
public class generator {



   public static long randomValue(){
        Date date = new Date();

        long millis = date.getTime();
        return millis;
    }
}
