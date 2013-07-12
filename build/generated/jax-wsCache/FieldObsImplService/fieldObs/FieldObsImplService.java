
package fieldObs;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "FieldObsImplService", targetNamespace = "http://services/", wsdlLocation = "http://localhost:8080/msse676/FieldObsImplService?wsdl")
public class FieldObsImplService
    extends Service
{

    private final static URL FIELDOBSIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException FIELDOBSIMPLSERVICE_EXCEPTION;
    private final static QName FIELDOBSIMPLSERVICE_QNAME = new QName("http://services/", "FieldObsImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/msse676/FieldObsImplService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FIELDOBSIMPLSERVICE_WSDL_LOCATION = url;
        FIELDOBSIMPLSERVICE_EXCEPTION = e;
    }

    public FieldObsImplService() {
        super(__getWsdlLocation(), FIELDOBSIMPLSERVICE_QNAME);
    }

    public FieldObsImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FIELDOBSIMPLSERVICE_QNAME, features);
    }

    public FieldObsImplService(URL wsdlLocation) {
        super(wsdlLocation, FIELDOBSIMPLSERVICE_QNAME);
    }

    public FieldObsImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FIELDOBSIMPLSERVICE_QNAME, features);
    }

    public FieldObsImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FieldObsImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FieldObs
     */
    @WebEndpoint(name = "FieldObsImplPort")
    public FieldObs getFieldObsImplPort() {
        return super.getPort(new QName("http://services/", "FieldObsImplPort"), FieldObs.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FieldObs
     */
    @WebEndpoint(name = "FieldObsImplPort")
    public FieldObs getFieldObsImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services/", "FieldObsImplPort"), FieldObs.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FIELDOBSIMPLSERVICE_EXCEPTION!= null) {
            throw FIELDOBSIMPLSERVICE_EXCEPTION;
        }
        return FIELDOBSIMPLSERVICE_WSDL_LOCATION;
    }

}
