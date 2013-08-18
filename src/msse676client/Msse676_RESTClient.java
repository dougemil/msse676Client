
package msse676client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
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
import services.ConvertDateStringToSqlDate;

/**
 *
 * @author dougkrause
 * msse676 - wk8
 * 
 * * This class tests RESTful Web Resources deployed in msse676
 * Uses ClientConfig, WebResource and URIBuilder classes
 * Receives XML data from resource and converts into 
 *      WeatherDataBena and ForecastBean entities
 * 
 * Evaluates response codes and manages error responses
 * 
 */
public class Msse676_RESTClient {
    
    // URI to be used by URIBuilder class in getBaseURI
    // Server diverts port 8080 requests to secure location at 8181
    private static String resourceURI = "https://localhost:8181/msse676";
    
    public static void main(String[] args){
        
        // Configure client and identify base resource
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        
        
        ClientResponse clientResponse;
        int statusCode;
        String dateString = "2012-01-01";
        
        // Filter adds authorization credentials
        // Security certificate added to JRE for SSL access
        HTTPBasicAuthFilter authFilter = 
                                new HTTPBasicAuthFilter("dougemil","cooter");
        client.addFilter(authFilter);
       
        WebResource service = client.resource(getBaseURI());
        
//************ Testing FieldObsResource of msse676
  
// Testing POST /newFieldObs
        
        WeatherDataBean wxBean = new WeatherDataBean();
        wxBean.setDateString("2013-01-01");
        wxBean.setLocation("Tasnuna Glacier");
        wxBean.setComments("Testing POST /newFieldObs");
        
        Logger.getLogger(Msse676_RESTClient.class.getName())
                                    .log(Level.INFO,
                                    "Accessing msse676.FieldObsResource:"
                                    + " Persisting new bean to DB");
        try{
            wxBean = service.path("rest").path("fieldObs")
                                         .path("newFieldObs")
                                         .accept(MediaType.APPLICATION_XML)
                                         .post(WeatherDataBean.class, wxBean);
        }catch(UniformInterfaceException uIE){
            
            clientResponse = uIE.getResponse();
            statusCode = clientResponse.getStatus();
            System.out.println("***Caught from POST /newFieldObs");
            System.out.println("***Status Code: " + statusCode);
            uIE.printStackTrace();
        }
        
        System.out.println("POST create");
        System.out.println("Location: " + wxBean.getLocation() 
                                            + "  Comments: " 
                                            + wxBean.getComments());

// Testing POST /updateFieldObs
        
        wxBean.setComments("Testing POST /updateFieldObs");
        
        try{
            wxBean = service.path("rest").path("fieldObs")
                                         .path("updateFieldObs")
                                         .accept(MediaType.APPLICATION_XML)
                                         .post(WeatherDataBean.class, wxBean);
        }catch(UniformInterfaceException uIE){
            
            clientResponse = uIE.getResponse();
            statusCode = clientResponse.getStatus();
            System.out.println("***Caught from POST /updateFieldObs");
            System.out.println("***Status Code: " + statusCode);
            uIE.printStackTrace();
        }
        
        System.out.println("POST update");
        System.out.println("Location: " + wxBean.getLocation() 
                                            + "  Comments: " 
                                            + wxBean.getComments());
        
// Testing GET
        
        System.out.println("GET read");
        
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
        
        System.out.println("GET read: exception scenario");
        dateString = "1999-01-01";
        
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
        
        
        
        
// Testing POST /deleteFieldObs
        
        System.out.println("POST destroy");
        
        try{
            service.path("rest")
                    .path("fieldObs")
                    .path("deleteFieldObs")
                    .accept(MediaType.APPLICATION_XML)
                    .post(WeatherDataBean.class, wxBean);
            
            System.out.println("FieldObs deleted");
            
        }catch(UniformInterfaceException uIE){
            
            clientResponse = uIE.getResponse();
            statusCode = clientResponse.getStatus();
            System.out.println("***Caught from POST /deleteFieldObs");
            System.out.println("***Status Code: " + statusCode);
            uIE.printStackTrace();
        }
        
System.out.println("********* Testing PointForecastResource of msse676");
        
// Testing POST /newForecast
       
        ForecastBean fcstBean = new ForecastBean();
        fcstBean.setStringDate("2013-01-01");
        fcstBean.setLocation("Meteorite");
        fcstBean.setForecastText("Test bean from msse676_RESTClient");
        fcstBean.setSqlDate(ConvertDateStringToSqlDate.convert("2013-01-01"));
        
        try{
            fcstBean = service.path("rest")
                                        .path("pointForecast")
                                        .path("newForecast")                                                  
                                        .accept(MediaType.APPLICATION_XML)
                                        .post(ForecastBean.class, fcstBean);
            
            System.out.println("POST create");
            System.out.println("Location: " + fcstBean.getLocation() 
                                            + "  Forecast Text: " 
                                            + fcstBean.getForecastText());
            
        }catch(UniformInterfaceException uIE){
            
            clientResponse = uIE.getResponse();
            statusCode = clientResponse.getStatus();
            System.out.println("***Caught from POST /newForecast");
            System.out.println("***Status Code: " + statusCode);
            uIE.printStackTrace();
        }
        
// Testing POST /updateForecast
        System.out.println("POST update");
        fcstBean.setForecastText("Updating forecastText");
        
        try{
            fcstBean = service.path("rest")
                                        .path("pointForecast")
                                        .path("updateForecast")                                                  
                                        .accept(MediaType.APPLICATION_XML)
                                        .post(ForecastBean.class, fcstBean);
            
            System.out.println("Location: " + fcstBean.getLocation() 
                                            + "  Forecast Text: " 
                                            + fcstBean.getForecastText());
            
        }catch(UniformInterfaceException uIE){
            
            clientResponse = uIE.getResponse();
            statusCode = clientResponse.getStatus();
            System.out.println("***Caught from POST /updateForecast");
            System.out.println("***Status Code: " + statusCode);
            uIE.printStackTrace();
        }
        
// Testing GET
        System.out.println("GET read");
        
        try{
            dateString = "2012-01-01";
            System.out.println(service.path("rest").path("pointForecast")
                                                    .path(dateString)
                                                    .accept(MediaType.APPLICATION_XML)
                                                    .get(String.class));
        }catch(UniformInterfaceException uIE){
            
            clientResponse = uIE.getResponse();
            statusCode = clientResponse.getStatus();
            System.out.println("***Caught from GET /{dateString}");
            System.out.println("***Status Code: " + statusCode);
            uIE.printStackTrace();
        }
        
// Testing POST /deleteForecast
        System.out.println("POST destroy");
        
        try{
            service.path("rest")
                    .path("pointForecast")
                    .path("deleteForecast")                                                  
                    .accept(MediaType.APPLICATION_XML)
                    .post(ForecastBean.class, fcstBean);
            
            System.out.println("fcstBean deleted");
            
        }catch(UniformInterfaceException uIE){
            
            clientResponse = uIE.getResponse();
            statusCode = clientResponse.getStatus();
            System.out.println("***Caught from POST /deleteForecast");
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
