
package fieldObs;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FieldObs", targetNamespace = "http://services/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FieldObs {


    /**
     * 
     * @param arg0
     * @return
     *     returns fieldObs.WeatherDataBean
     * @throws FieldObsException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getFieldObs", targetNamespace = "http://services/", className = "fieldObs.GetFieldObs")
    @ResponseWrapper(localName = "getFieldObsResponse", targetNamespace = "http://services/", className = "fieldObs.GetFieldObsResponse")
    @Action(input = "http://services/FieldObs/getFieldObsRequest", output = "http://services/FieldObs/getFieldObsResponse", fault = {
        @FaultAction(className = FieldObsException_Exception.class, value = "http://services/FieldObs/getFieldObs/Fault/FieldObsException")
    })
    public WeatherDataBean getFieldObs(
        @WebParam(name = "arg0", targetNamespace = "")
        XMLGregorianCalendar arg0)
        throws FieldObsException_Exception
    ;

}
