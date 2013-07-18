
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
    private final static QName _WeatherDataBean_QNAME = new QName("http://services/", "WeatherDataBean");
    private final static QName _GetFieldObs_QNAME = new QName("http://services/", "getFieldObs");
    private final static QName _ObsNotFoundException_QNAME = new QName("http://services/", "ObsNotFoundException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fieldObs
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObsNotFoundException }
     * 
     */
    public ObsNotFoundException createObsNotFoundException() {
        return new ObsNotFoundException();
    }

    /**
     * Create an instance of {@link GetFieldObs }
     * 
     */
    public GetFieldObs createGetFieldObs() {
        return new GetFieldObs();
    }

    /**
     * Create an instance of {@link WeatherDataBean }
     * 
     */
    public WeatherDataBean createWeatherDataBean() {
        return new WeatherDataBean();
    }

    /**
     * Create an instance of {@link GetFieldObsResponse }
     * 
     */
    public GetFieldObsResponse createGetFieldObsResponse() {
        return new GetFieldObsResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link WeatherDataBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "WeatherDataBean")
    public JAXBElement<WeatherDataBean> createWeatherDataBean(WeatherDataBean value) {
        return new JAXBElement<WeatherDataBean>(_WeatherDataBean_QNAME, WeatherDataBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFieldObs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getFieldObs")
    public JAXBElement<GetFieldObs> createGetFieldObs(GetFieldObs value) {
        return new JAXBElement<GetFieldObs>(_GetFieldObs_QNAME, GetFieldObs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObsNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "ObsNotFoundException")
    public JAXBElement<ObsNotFoundException> createObsNotFoundException(ObsNotFoundException value) {
        return new JAXBElement<ObsNotFoundException>(_ObsNotFoundException_QNAME, ObsNotFoundException.class, null, value);
    }

}
