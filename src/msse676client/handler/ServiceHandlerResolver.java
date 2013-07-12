/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package msse676client.handler;

import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

/**
 *
 * @author dougkrause
 */

// Before the client calls a remote service,  set HandlerResolver on the service
// service.setHandlerResolver(new ServiceHandlerResolver());
public class ServiceHandlerResolver implements HandlerResolver{

    @Override
    public List<Handler> getHandlerChain(PortInfo pi) {
        
        List<Handler> handlers = new ArrayList<Handler>();
        handlers.add(new LoggingHandler());
        handlers.add(new HeaderHandler());
        
        return handlers;
    }
    
}
