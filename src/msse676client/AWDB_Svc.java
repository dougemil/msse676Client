/*
 * NRCS Air and Water DB Web Service Access
 * http://www.wcc.nrcs.usda.gov/web_service/awdb_web_service_landing.htm
 * 
 */
package msse676client;

import gov.usda.nrcs.wcc.ns.awdbwebservice.AwdbWebService;
import gov.usda.nrcs.wcc.ns.awdbwebservice.AwdbWebService_Service;
import gov.usda.nrcs.wcc.ns.awdbwebservice.StationMetaData;
import java.net.URL;
import java.text.SimpleDateFormat;
import javax.xml.namespace.QName;

/**
 *
 * @author dougkrause
 * msse676 wk2
 * 
 */
public class AWDB_Svc {
    
    static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    /**
    * Initialize the web service member variable m_webService.
    */
    AwdbWebService m_webService = null;
   

/**
 * Constructor which initializes a web service instance.
 */

    public AWDB_Svc()
    {
        initWebService();
        
    } 
    
    private void initWebService()
    {
        try
        {
            URL wsURL = new URL
                ("http://www.wcc.nrcs.usda.gov/awdbWebService/services?wsdl");

            AwdbWebService_Service lookup = new AwdbWebService_Service(wsURL,
                new QName("http://www.wcc.nrcs.usda.gov/ns/awdbWebService",
                    "AwdbWebService"));
            m_webService = lookup.getAwdbWebServiceImplPort();
        }
        catch (Exception e)
        {    
            System.out.println("Problem creating web service client: "
                + e.getMessage());   

        }    
    }

    public static StationMetaData getStationMetadata(java.lang.String stationTriplet) {
        gov.usda.nrcs.wcc.ns.awdbwebservice.AwdbWebService_Service service = new gov.usda.nrcs.wcc.ns.awdbwebservice.AwdbWebService_Service();
        gov.usda.nrcs.wcc.ns.awdbwebservice.AwdbWebService port = service.getAwdbWebServiceImplPort();
        return port.getStationMetadata(stationTriplet);
    }
    
}
