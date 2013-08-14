
package services;

/**
 *
 * @author dougkrause
 */
public class BriefPause {
    
    public static void pause(){
        
        try {
            Thread.sleep(1000);
            System.out.println();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
}
