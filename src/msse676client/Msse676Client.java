/*
 * Web Service Client Application
 * References services from msse676
 * 
 * Employs a Handler pattern in two different ways
 * Employs a custom Web Service Exception pattern
 * 
 * 
 */
package msse676client;

import fieldObs.FieldObs;
import fieldObs.FieldObsImplService;
import fieldObs.ObsNotFoundException;
import fieldObs.ObsNotFoundException_Exception;
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
import msse676client.handler.ServiceHandlerResolver;
import pointForecast.ForecastBean;
import pointForecast.PointForecast;
import pointForecast.PointForecastImplService;
import remoteObs.Observation;
import remoteObs.RemoteObs;
import remoteObs.RemoteObsImplService;

/**
 *
 * @author dougkrause
 * msse676 wk3
 * 
 */
public class Msse676Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String stationTriplet = "1095:AK:SNTL";
        GregorianCalendar gC = new GregorianCalendar(2012, 0, 1);
        
        // Uncomment to test ObsNotFoundException handling
        // gC.set(1900, 0, 1);
        
        // Implements LoggingHandler programmatically
        Observation ob = getRemoteObs(gC, gC);
        System.out.println(ob.getMessage());
        

        // This operation is dependent on local DB access
        // Implements HeaderHandler declaratively (Requires annotation in gen class)
        WeatherDataBean bean = getFieldObs(gC);
        if (bean != null)
            System.out.println(bean.getComments());
        
        
        ForecastBean fcstBean = getPointForecast(1, 1, gC);
        System.out.println(fcstBean.getMessage());

        /*
         * Accesses NRCS Air and Water DB
         */
        AWDB_Svc awdb = new AWDB_Svc();
        StationMetaData mData = awdb.getStationMetadata(stationTriplet);
        String name = mData.getName();
        String cName = mData.getCountyName();
        BigDecimal elev = mData.getElevation();
        
        System.out.println("Station Name: " + name + " County: " + cName + " Elevation: " + elev);
            
    }
    
    /**
     * Use JAX-WS Generated Sources packages and Web Service References
     */
    private static Observation getRemoteObs(GregorianCalendar gC1, GregorianCalendar gC2){
        RemoteObsImplService service = new RemoteObsImplService();
        
        // Set HandlerResolver
        service.setHandlerResolver(new ServiceHandlerResolver());
        
        RemoteObs port = service.getRemoteObsImplPort();
        
        
        
        // Service call requires XMLGregorianCalendar parameters
        // Uses port to call method from web service
        XMLGregorianCalendar date1 = parseToXMLGregorianDate(gC1);
        XMLGregorianCalendar date2 = date1;
        return port.getObsRange(date1, date2);
    }
    
    private static WeatherDataBean getFieldObs(GregorianCalendar gC){
       WeatherDataBean bean = null;
       
       FieldObsImplService service = new FieldObsImplService();
       FieldObs port = service.getFieldObsImplPort();
       
       // Service call requires XMLGregorianCalendar parameters
       XMLGregorianCalendar xC = parseToXMLGregorianDate(gC);
       
       
        try {
            // Uses port to call method from web service
            bean = port.getFieldObs(xC);
            
        // Custom Fault Handling
        } catch (ObsNotFoundException_Exception ex) {
            
            // Get a reference to the custom fault object
            ObsNotFoundException oNFE = ex.getFaultInfo();
            // Gets exception msg and details
            Logger.getLogger(Msse676Client.class.getName())
                    .log(Level.INFO, ex.getMessage() + ": " + oNFE.getDetails());
            
            
            
        }
       return bean;

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
