/*
 * This class implements a SOAPHandler to insert
 * a timestamp on incoming messages. Example of the
 * intercptor pattern
 * 
 */
package msse676client.handler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author dougkrause
 * msse676 - wk3
 * 
 */
public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext c) {
        
        // Determines whether msg is inbound or outbond
        Boolean isRequest =(Boolean)c.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        
        // if outbound, process msg
        if(isRequest){
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy  hh:mm:sss");
            Date dt = Calendar.getInstance().getTime();
            
            try{
                // Get references
                SOAPMessage msg = c.getMessage();
                SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
                SOAPHeader header = env.getHeader();
                
                // Header is optional so it may be null
                if(header == null)
                    header = env.addHeader();
                
                // URI will appear in header as the name space
                // new header element named "sent-time"
                QName name = new QName("http://service.msse676", "Sent-time");
                SOAPHeaderElement el = header.addHeaderElement(name);
                
                // add timestamp to element
                el.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT); //default
                el.addTextNode(df.format(dt)); // set time stamp
                // commit
                msg.saveChanges();
                Logger.getLogger(HeaderHandler.class.getName())
                                    .log(Level.INFO, "Time stamp set from HeaderHandler");
            }catch(SOAPException ex){
                Logger.getLogger(HeaderHandler.class.getName())
                                        .log(Level.SEVERE, null, ex);
            }
                
        }
        return true; // true to continue chain
    }

    @Override
    public boolean handleFault(SOAPMessageContext c) {
        Logger.getLogger(HeaderHandler.class.getName())
                                      .log(Level.WARNING, "Fault!");
        return true;
    }

    @Override
    public void close(MessageContext mc) {
//        Logger.getLogger(HeaderHandler.class.getName())
//                                    .log(Level.INFO, "closed");
    }
    
}
