/*
 * This class tests RESTful Web Resources deployed in msse676
 * Uses ClientConfig, WebResource and URIBuilder classes
 * Outputs raw XML and JSON received from a web resource
 * 
 * Tests various forms of content negotiation and return media types
 * Evaluates response codes and manages error responses
 * 
 */
package msse676client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import domain.ForecastBean;
import domain.WeatherDataBean;
//import fieldObs.WeatherDataBean;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import msse676client.handler.HeaderHandler;

import services.BriefPause;

/**
 *
 * @author dougkrause
 * msse676 - wk6
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
                                    + " Retrieving XML from DB");
        
        // ** Negotiate content via header, request XML content
        System.out.println(service.path("rest").path("fieldObs")
                                                .path(dateString)
                                                .accept(MediaType.APPLICATION_XML)
                                                .get(String.class));
        
        
        // ** Evaluate response code
        clientResponse = service.head();
        statusCode = clientResponse.getStatus();
        if(statusCode==200)
            System.out.println("** XML content returned.");
        
        System.out.println();
        
        Logger.getLogger(Msse676_RESTClient.class.getName())
                                    .log(Level.INFO,
                                    "Accessing FieldObsResource:"
                                    + " Persisting new bean to DB");
        
        dateString = "2012-12-12";
        System.out.println(service.path("rest").path("fieldObs")
                                                .path(dateString)
                                                .path(location)
                                                .accept(MediaType.APPLICATION_XML)
                                                .post(String.class));
        
        ///////************ Working, needs refinement
        WeatherDataBean wxBean = new WeatherDataBean();
        //long benchTime = new Date().getTime();
        
        //wxBean.setSqlDate(new java.sql.Date(benchTime)); ***cant use java.sql.date >> no default constructor
//        wxBean.setDateString("2013-08-08");
//        wxBean.setLocation("White Room");
//        wxBean.setComments("Great day in the morning!");
//        
//        service.path("rest").path("fieldObs").path("newFieldObs")                                               
//                                                .accept(MediaType.APPLICATION_XML)
//                                                .post(WeatherDataBean.class, wxBean);
//        
        
//        // ** Evaluate response code
//        clientResponse = service.head();
//        statusCode = clientResponse.getStatus();
//        if(statusCode==200)
//            System.out.println("Field Obs Saved.");
//        else
//            System.out.println("** Field Obs Not Saved.");
//        
//        System.out.println();
//        
//        Logger.getLogger(Msse676_RESTClient.class.getName())
//                                    .log(Level.INFO,
//                                    "Accessing FieldObsResource:"
//                                    + " Deleting new bean from DB");
        
        System.out.println(service.path("rest").path("fieldObs")
                                                .path(dateString)
                                                .accept(MediaType.APPLICATION_XML)
                                                .delete(String.class));
        
        // ** Evaluate response code
        clientResponse = service.head();
        statusCode = clientResponse.getStatus();
        if(statusCode==200)
            System.out.println("Field Obs Deleted.");
        else
            System.out.println("Field Obs Not Deleted.");
        
        
        // ** Manage Error Response Scenario
        try{
            System.out.println(service.path("rest").path("fieldObs")
                                                    .path(dateString)
                                                    .accept(MediaType.APPLICATION_XML)
                                                    .get(String.class));
        }catch(UniformInterfaceException uIE){
            clientResponse = uIE.getResponse();
            statusCode = clientResponse.getStatus();
            if(statusCode==404)
                System.out.println("** No obs found for the requested date parameter");
        }
        Logger.getLogger(Msse676_RESTClient.class.getName())
                                    .log(Level.INFO, "Accessing PointForecastResource");
        
        BriefPause.pause();
// Testing PointForcastResource of msse676
// Testing POST
       
        ForecastBean fcstBean = new ForecastBean();
        fcstBean.setStringDate("2013-01-01");
        fcstBean.setLocation("Meteorite");
        fcstBean.setForecastText("Test bean from msse676_RESTClient");
        
        try{
            fcstBean = service.path("rest")
                                        .path("pointForecast")
                                        .path("newForecast")                                                  
                                        .accept(MediaType.APPLICATION_XML)
                                        .post(ForecastBean.class, fcstBean);
            
            System.out.println(fcstBean.getForecastText());
            
        }catch(UniformInterfaceException uIE){
            
            clientResponse = uIE.getResponse();
            statusCode = clientResponse.getStatus();
            System.out.println("***Testing PointForcastResource");
            System.out.println("***Status Code: " + statusCode);
            uIE.printStackTrace();
        }
        
        
        try{
            dateString = "2012-01-01";
            System.out.println(service.path("rest").path("pointForecast")
                                                    .path("1")
                                                    .path("1")
                                                    .path(dateString)
                                                    .accept(MediaType.APPLICATION_XML)
                                                    .get(String.class));
        }catch(UniformInterfaceException uIE){
            
            clientResponse = uIE.getResponse();
            statusCode = clientResponse.getStatus();
            System.out.println("***Status Code: " + statusCode);
            uIE.printStackTrace();
        }
    }
    
    // UriBuilder is called by the service object to facilitate
    //  the chaining of the remaining path labels to the base URI
    private static URI getBaseURI(){
        return UriBuilder.fromUri(Msse676_RESTClient.resourceURI).build();
    }
}
