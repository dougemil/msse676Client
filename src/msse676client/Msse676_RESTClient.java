/*
 * This class tests RESTful Web Resources deployed in msse676
 * Also tests resource deployed at http://api.wunderground.com/api/
 * Uses CLientConfig, WebResource and URIBuilder classes
 * Outputs raw XML received from a web resource
 * 
 */
package msse676client;

import com.sun.jersey.api.client.Client;
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
 * msse676 - wk4
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
        
        String dateString = "2012-01-01";
        
        Logger.getLogger(Msse676_RESTClient.class.getName())
                                    .log(Level.INFO, "Accessing FieldObsResource");
        
        // Define service path, identify expected return MediaType and fetch
        System.out.println(service.path("rest").path("fieldObs")
                                                .path(dateString)
                                                .accept(MediaType.APPLICATION_XML)
                                                .get(String.class));
        
        // Pause execution so Log msg will print above resource return
        try {
            Thread.sleep(1000);
            System.out.println();
        } catch (InterruptedException ex) {
            Logger.getLogger(Msse676_RESTClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Logger.getLogger(Msse676_RESTClient.class.getName())
                                    .log(Level.INFO, "Accessing PointForecastResource");
        
        // Define service path, identify expected return MediaType and fetch
        System.out.println(service.path("rest").path("pointForecast")
                                                .path("1")
                                                .path("1")
                                                .path(dateString)
                                                .accept(MediaType.APPLICATION_XML)
                                                .get(String.class));
        
        // Pause execution so Log msg will print above resource return
        try {
            Thread.sleep(1000);
            System.out.println();
        } catch (InterruptedException ex) {
            Logger.getLogger(Msse676_RESTClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Change baseURI to access third part resource
        resourceURI = "http://api.wunderground.com/api/";
        service = client.resource(getBaseURI());
        
        Logger.getLogger(Msse676_RESTClient.class.getName())
                                    .log(Level.INFO, "Accessing wunderground.com");
        
        // Define service path, identify expected return MediaType and fetch
        System.out.println(service.path("4b17eee045c8dda6").path("conditions")
                                                           .path("q")
                                                           .path("AK")
                                                           .path("Valdez.xml")
                                                .accept(MediaType.APPLICATION_XML)
                                                .get(String.class));
    }
    
    // UriBuilder is called by the service object to facilitate
    //  the chaining of the remaining path labels to the base URI
    private static URI getBaseURI(){
        return UriBuilder.fromUri(Msse676_RESTClient.resourceURI).build();
    }
}
