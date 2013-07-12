
package pointForecast;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pointForecast package. 
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

    private final static QName _GetPointForecastResponse_QNAME = new QName("http://services/", "getPointForecastResponse");
    private final static QName _GetPointForecast_QNAME = new QName("http://services/", "getPointForecast");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pointForecast
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPointForecast }
     * 
     */
    public GetPointForecast createGetPointForecast() {
        return new GetPointForecast();
    }

    /**
     * Create an instance of {@link GetPointForecastResponse }
     * 
     */
    public GetPointForecastResponse createGetPointForecastResponse() {
        return new GetPointForecastResponse();
    }

    /**
     * Create an instance of {@link ForecastBean }
     * 
     */
    public ForecastBean createForecastBean() {
        return new ForecastBean();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPointForecastResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getPointForecastResponse")
    public JAXBElement<GetPointForecastResponse> createGetPointForecastResponse(GetPointForecastResponse value) {
        return new JAXBElement<GetPointForecastResponse>(_GetPointForecastResponse_QNAME, GetPointForecastResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPointForecast }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getPointForecast")
    public JAXBElement<GetPointForecast> createGetPointForecast(GetPointForecast value) {
        return new JAXBElement<GetPointForecast>(_GetPointForecast_QNAME, GetPointForecast.class, null, value);
    }

}
