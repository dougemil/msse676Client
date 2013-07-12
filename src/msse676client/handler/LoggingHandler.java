/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package msse676client.handler;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;
import pointForecast.ForecastBean;
import pointForecast.GetPointForecastResponse;

/**
 *
 * @author dougkrause
 */
public class LoggingHandler implements LogicalHandler<LogicalMessageContext> {

    @Override
    public boolean handleMessage(LogicalMessageContext c) {
        
        Boolean outbound = (Boolean)c.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        
        // only process inbound messages
        if (!outbound){
            LogicalMessage msg = c.getMessage();
        
            try{
                // context used to extract msg payload
                JAXBContext jaxb_ctx = JAXBContext.newInstance("whatever");
                Object payload = msg.getPayload(jaxb_ctx);
                
                if(payload instanceof JAXBElement){
                    Object obj = ((JAXBElement)payload).getValue();
                    
                    // GetPointForecastResponse is a generated class
                    if(obj instanceof GetPointForecastResponse){
                        GetPointForecastResponse resp = (GetPointForecastResponse)obj;
                        // getReturn() is a convenience method
                        // ForecastBean maps to WSDL so its methods are available
                        ForecastBean fcst = resp.getReturn();
                        System.out.println(fcst.getMessage());
                    }
                }
            }catch(JAXBException ex){
                Logger.getLogger(LoggingHandler.class.getName())
                                        .log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    @Override
    public boolean handleFault(LogicalMessageContext c) {
        return true;
    }

    @Override
    public void close(MessageContext mc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
