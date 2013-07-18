/*
 * Implements a Logical Handler to add logging information
 * to message body. Handler is added to the handler-chain
 * programmatically using a HandlerResolver
 * 
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
import remoteObs.GetObsRangeResponse;
import remoteObs.Observation;

/**
 *
 * @author dougkrause
 * msse676 - wk3
 * 
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
                JAXBContext jaxb_ctx = JAXBContext.newInstance("remoteObs");
                Object payload = msg.getPayload(jaxb_ctx);
                
                if(payload instanceof JAXBElement){
                    Object obj = ((JAXBElement)payload).getValue();
                    
                    // GetPointForecastResponse is a generated class
                    if(obj instanceof GetObsRangeResponse){
                        
                        GetObsRangeResponse resp = (GetObsRangeResponse)obj;
                        // getReturn() is a convenience method
                        // ForecastBean maps to WSDL so its methods are available
                        Observation ob = resp.getReturn();
                        Logger.getLogger(HeaderHandler.class.getName())
                                    .log(Level.INFO, "Logging from LoggingHandler");
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
//        Logger.getLogger(HeaderHandler.class.getName())
//                                    .log(Level.INFO, "dk: closed");
    }
    
    
    
}
