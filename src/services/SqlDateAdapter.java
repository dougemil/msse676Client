/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author dougkrause
 * http://shakthydoss.com/java-sql-date-does-not-have-a-no-arg-default-constructor/
 * 
 */
public class SqlDateAdapter extends XmlAdapter <String , Date> {
    
    @Override
    public String marshal(java.sql.Date d) {
        return d.toString();
    }
    
    
    public Date unmarshal(String v) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = null;
        
        
        long benchTime = new java.util.Date().getTime();
        
            return new java.sql.Date(new java.util.Date().getTime());
        
        
//       try {
//             java.util.Date convertedDate = dateFormat.parse(v);
//             sqlDate = new java.sql.Date(convertedDate.getTime());
//        } catch (ParseException e) {
//            System.out.println("**" + v);
//           e.printStackTrace();
//        }
//       
//        return sqlDate;
    }
}
