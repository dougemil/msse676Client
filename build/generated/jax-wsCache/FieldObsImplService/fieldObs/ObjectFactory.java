
package fieldObs;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fieldObs package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetFieldObsResponse_QNAME = new QName("http://services/", "getFieldObsResponse");
    private final static QName _FieldObsException_QNAME = new QName("http://services/", "FieldObsException");
    private final static QName _GetFieldObs_QNAME = new QName("http://services/", "getFieldObs");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fieldObs
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFieldObs }
     * 
     */
    public GetFieldObs createGetFieldObs() {
        return new GetFieldObs();
    }

    /**
     * Create an instance of {@link FieldObsException }
     * 
     */
    public FieldObsException createFieldObsException() {
        return new FieldObsException();
    }

    /**
     * Create an instance of {@link GetFieldObsResponse }
     * 
     */
    public GetFieldObsResponse createGetFieldObsResponse() {
        return new GetFieldObsResponse();
    }

    /**
     * Create an instance of {@link WeatherDataBean }
     * 
     */
    public WeatherDataBean createWeatherDataBean() {
        return new WeatherDataBean();
    }

    /**
     * Create an instance of {@link Date }
     * 
     */
    public Date createDate() {
        return new Date();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFieldObsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getFieldObsResponse")
    public JAXBElement<GetFieldObsResponse> createGetFieldObsResponse(GetFieldObsResponse value) {
        return new JAXBElement<GetFieldObsResponse>(_GetFieldObsResponse_QNAME, GetFieldObsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldObsException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "FieldObsException")
    public JAXBElement<FieldObsException> createFieldObsException(FieldObsException value) {
        return new JAXBElement<FieldObsException>(_FieldObsException_QNAME, FieldObsException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFieldObs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getFieldObs")
    public JAXBElement<GetFieldObs> createGetFieldObs(GetFieldObs value) {
        return new JAXBElement<GetFieldObs>(_GetFieldObs_QNAME, GetFieldObs.class, null, value);
    }

}
