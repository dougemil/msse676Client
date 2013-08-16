
package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

/**
 *
 * @author dougkrause
 * msse676 - wk7
 * 
 * Simple utility
 * 
 */
public class ConvertDateStringToSqlDate {
    
    public static java.sql.Date convert (String date){
        
        
        java.util.Date javaDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                javaDate = formatter.parse (date);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());
        return sqlDate;
    }
    
}
