/*
 * This class tests RESTful Web Resources deployed in msse676
 * Uses ClientConfig, WebResource and URIBuilder classes
 * Outputs raw XML and JSON received from a web resource
 * Tests various ofrms of content negotiation and return media types
 * 
 */
package msse676client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import msse676client.handler.HeaderHandler;

/**
 *
 * @author dougkrause
 * msse676 - wk5
 * 
 */
public class Msse676_RESTClient {
    
    // URI to be used by URIBuilder class in getBaseURI
    private static String resourceURI = "http://localhost:8080/msse676";
    
    public static void main(String[] args){
        
        // Configure client and identify base resource
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(getBaseURI());
        
        ClientResponse clientResponse;
        int statusCode;
        
        String dateString = "2012-01-01";
        String location = "Tasnuna Glacier";
        String format = "format";
        
        Logger.getLogger(Msse676_RESTClient.class.getName())
                                    .log(Level.INFO,
                                    "Accessing FieldObsResource:"
                                    + " Retrieving XML and JSON Field Obs from DB");
        
        System.out.println("XML content returned");
        // Negotiate content via header, request XML content
        System.out.println(service.path("rest").path("fieldObs")
                                                .path(dateString)
                                                .accept(MediaType.APPLICATION_XML)
                                                .get(String.class));
        clientResponse = service.head();
        System.out.println(clientResponse.getStatus());
        
        System.out.println();
        
        // Negotiate content based on URL, request JSON content
        System.out.println(service.path("rest").path("fieldObs")
                                                .path(dateString + ".json")
                                                .get(String.class));
             
        System.out.println();
        Logger.getLogger(Msse676_RESTClient.class.getName())
                                    .log(Level.INFO,
                                    "Accessing FieldObsResource:"
                                    + " Persisting new bean to DB");
        
        dateString = "2012-12-12";
        // Testing dependency injection of RESTful resource
        System.out.println(service.path("rest").path("fieldObs")
                                                .path(dateString)
                                                .path(location)
                                                .accept(MediaType.APPLICATION_XML)
                                                .post(String.class));
        clientResponse = service.head();
        statusCode = clientResponse.getStatus();
        if(statusCode==200)
            System.out.println("Field Obs Saved.");
        
        System.out.println();
        
        Logger.getLogger(Msse676_RESTClient.class.getName())
                                    .log(Level.INFO,
                                    "Accessing FieldObsResource:"
                                    + " Deleting new bean from DB");
        
        // Testing dependency injection of RESTful resource
        System.out.println(service.path("rest").path("fieldObs")
                                                .path(dateString)
                                                .accept(MediaType.APPLICATION_XML)
                                                .delete(String.class));
        
        clientResponse = service.head();
        statusCode = clientResponse.getStatus();
        if(statusCode==200)
            System.out.println("Field Obs deleted.");
        
        
        try{
            System.out.println(service.path("rest").path("fieldObs")
                                                    .path(dateString)
                                                    .accept(MediaType.APPLICATION_XML)
                                                    .get(String.class));
        }catch(UniformInterfaceException uIE){
            clientResponse = uIE.getResponse();
            statusCode = clientResponse.getStatus();
//            System.out.print(statusCode);
            if(statusCode==416)
                System.out.println("No obs found for the requested date parameter");
        }
        Logger.getLogger(Msse676_RESTClient.class.getName())
                                    .log(Level.INFO, "Accessing PointForecastResource");
        
        // Pause execution so Log msg will print above resource return
        try {
            Thread.sleep(1000);
            System.out.println();
        } catch (InterruptedException ex) {
            Logger.getLogger(Msse676_RESTClient.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
        // Negotiate content via Request Parameter
        System.out.println(service.path("rest").path("pointForecast")
                                                .path("1")
                                                .path("1")
                                                .path(dateString)
                                                .queryParam(format, "json")
                                                .accept(MediaType.APPLICATION_JSON)
                                                .get(String.class));
        
        System.out.println(service.path("rest").path("pointForecast")
                                                .path("1")
                                                .path("1")
                                                .path(dateString)
                                                .queryParam(format, "xml")
                                                .accept(MediaType.APPLICATION_XML)
                                                .get(String.class));
        try{
            System.out.println(service.path("rest").path("pointForecast")
                                                    .path("1")
                                                    .path("1")
                                                    .path(dateString)
                                                    .queryParam(format, "fail")
                                                    .accept(MediaType.APPLICATION_XML)
                                                    .get(String.class));
        }catch(UniformInterfaceException uIE){
            
            clientResponse = uIE.getResponse();
            statusCode = clientResponse.getStatus();
            if(statusCode==415)
                System.out.println("The requested return media type is not supported");
        }
        // Pause execution so Log msg will print above resource return
//        try {
//            Thread.sleep(1000);
//            System.out.println();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Msse676_RESTClient.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        // Change baseURI to access third part resource
//        resourceURI = "http://api.wunderground.com/api/";
//        service = client.resource(getBaseURI());
//        
//        Logger.getLogger(Msse676_RESTClient.class.getName())
//                                    .log(Level.INFO, "Accessing wunderground.com");
//        
//        // Define service path, identify expected return MediaType and fetch
//        System.out.println(service.path("4b17eee045c8dda6").path("conditions")
//                                                           .path("q")
//                                                           .path("AK")
//                                                           .path("Valdez.xml")
//                                                .accept(MediaType.APPLICATION_XML)
//                                                .get(String.class));
    }
    
    // UriBuilder is called by the service object to facilitate
    //  the chaining of the remaining path labels to the base URI
    private static URI getBaseURI(){
        return UriBuilder.fromUri(Msse676_RESTClient.resourceURI).build();
    }
}
