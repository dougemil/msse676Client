/*
 * Web Service Client Application
 * References services from msse676
 * 
 */
package msse676client;

import fieldObs.FieldObs;
import fieldObs.FieldObsImplService;
import fieldObs.WeatherDataBean;
import gov.usda.nrcs.wcc.ns.awdbwebservice.StationMetaData;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import pointForecast.ForecastBean;
import pointForecast.PointForecast;
import pointForecast.PointForecastImplService;
import remoteObs.Ob;
import remoteObs.RemoteObs;
import remoteObs.RemoteObsImplService;

/**
 *
 * @author dougkrause
 * msse676 wk2
 * 
 */
public class Msse676Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GregorianCalendar gC = new GregorianCalendar(2012, 0, 1);

        Ob ob = getRemoteObs(gC, gC);
        System.out.println(ob.getMessage());

        // This operation is dependent on local DB access
        WeatherDataBean bean = getFieldObs(gC);
        System.out.println(bean.getComments());

        ForecastBean fcstBean = getPointForecast(1, 1, gC);
        System.out.println(fcstBean.getMessage());

        /*
         * Accesses NRCS Air and Water DB
         */
        AWDB_Svc awdb = new AWDB_Svc();
        StationMetaData mData = awdb.getStationMetadata("1095:AK:SNTL");
        String name = mData.getName();
        String cName = mData.getCountyName();
        BigDecimal elev = mData.getElevation();
        
        System.out.println("Station Name: " + name + " County: " + cName + " Elevation: " + elev);
            
    }
    
    /**
     * Use JAX-WS Generated Sources packages and Web Service References
     * 
     * @param gC1 
     * @param gC2 
     * @return msse676.Domain.Ob
     */
    private static Ob getRemoteObs(GregorianCalendar gC1, GregorianCalendar gC2){
        RemoteObsImplService service = new RemoteObsImplService();
        RemoteObs port = service.getRemoteObsImplPort();
        
        // Service call requires XMLGregorianCalendar parameters
        // Uses port to call method from web service
        XMLGregorianCalendar date1 = parseToXMLGregorianDate(gC1);
        XMLGregorianCalendar date2 = date1;
        return port.getObsRange(date1, date2);
    }
    
    private static WeatherDataBean getFieldObs(GregorianCalendar gC){
        
       FieldObsImplService service = new FieldObsImplService();
       FieldObs port = service.getFieldObsImplPort();
       
       // Service call requires XMLGregorianCalendar parameters
       // Uses port to call method from web service
       XMLGregorianCalendar xC = parseToXMLGregorianDate(gC);  
       return port.getFieldObs(xC);

    }
    
    private static ForecastBean getPointForecast(int lat, int lon, Calendar endForecast){
        
        PointForecastImplService service = new PointForecastImplService();
        PointForecast port = service.getPointForecastImplPort();
        
        // Service call requires XMLGregorianCalendar parameters
        // Uses port to call method from web service
        XMLGregorianCalendar xC = parseToXMLGregorianDate((GregorianCalendar)endForecast);
        return port.getPointForecast(lat, lon, xC);
    }
    
    public static XMLGregorianCalendar parseToXMLGregorianDate(GregorianCalendar gcalDate){
        
        XMLGregorianCalendar xmlDate = null;
        
        try {
            xmlDate = DatatypeFactory.newInstance()
                                                .newXMLGregorianCalendar(gcalDate);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(Msse676Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return xmlDate;
    }
}
