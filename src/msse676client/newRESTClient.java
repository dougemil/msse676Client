/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package msse676client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 *
 * @author dougkrause
 */
public class newRESTClient {
    
    public static void main(String[] args){
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(getBaseURI());
        
        System.out.println(service.path("rest").path("customers").path("1234")
                .accept(MediaType.APPLICATION_XML).get(String.class));
        
        System.out.println(service.path("rest").path("customers")
                .accept(MediaType.APPLICATION_JSON).get(String.class));
        
    }
    
    private static URI getBaseURI(){
        return UriBuilder.fromUri("http://localhost:8080/msse676").build();
    }
}
