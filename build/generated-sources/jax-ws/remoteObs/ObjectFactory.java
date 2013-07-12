
package remoteObs;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the remoteObs package. 
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

    private final static QName _GetMostRecentOb_QNAME = new QName("http://services/", "getMostRecentOb");
    private final static QName _GetObsRange_QNAME = new QName("http://services/", "getObsRange");
    private final static QName _GetMostRecentObResponse_QNAME = new QName("http://services/", "getMostRecentObResponse");
    private final static QName _GetObsRangeResponse_QNAME = new QName("http://services/", "getObsRangeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: remoteObs
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetObsRangeResponse }
     * 
     */
    public GetObsRangeResponse createGetObsRangeResponse() {
        return new GetObsRangeResponse();
    }

    /**
     * Create an instance of {@link GetMostRecentObResponse }
     * 
     */
    public GetMostRecentObResponse createGetMostRecentObResponse() {
        return new GetMostRecentObResponse();
    }

    /**
     * Create an instance of {@link GetObsRange }
     * 
     */
    public GetObsRange createGetObsRange() {
        return new GetObsRange();
    }

    /**
     * Create an instance of {@link GetMostRecentOb }
     * 
     */
    public GetMostRecentOb createGetMostRecentOb() {
        return new GetMostRecentOb();
    }

    /**
     * Create an instance of {@link Ob }
     * 
     */
    public Ob createOb() {
        return new Ob();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMostRecentOb }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getMostRecentOb")
    public JAXBElement<GetMostRecentOb> createGetMostRecentOb(GetMostRecentOb value) {
        return new JAXBElement<GetMostRecentOb>(_GetMostRecentOb_QNAME, GetMostRecentOb.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetObsRange }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getObsRange")
    public JAXBElement<GetObsRange> createGetObsRange(GetObsRange value) {
        return new JAXBElement<GetObsRange>(_GetObsRange_QNAME, GetObsRange.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMostRecentObResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getMostRecentObResponse")
    public JAXBElement<GetMostRecentObResponse> createGetMostRecentObResponse(GetMostRecentObResponse value) {
        return new JAXBElement<GetMostRecentObResponse>(_GetMostRecentObResponse_QNAME, GetMostRecentObResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetObsRangeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getObsRangeResponse")
    public JAXBElement<GetObsRangeResponse> createGetObsRangeResponse(GetObsRangeResponse value) {
        return new JAXBElement<GetObsRangeResponse>(_GetObsRangeResponse_QNAME, GetObsRangeResponse.class, null, value);
    }

}
