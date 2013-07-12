
package fieldObs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for weatherDataBean complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="weatherDataBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="baseElevation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="baseTemp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gustSpreadMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gustSpreadMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sky" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sqlDate" type="{http://services/}date" minOccurs="0"/>
 *         &lt;element name="summitElevation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="summitTemp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="windDirection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="windSpeed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "weatherDataBean", propOrder = {
    "baseElevation",
    "baseTemp",
    "comments",
    "dateString",
    "gustSpreadMax",
    "gustSpreadMin",
    "location",
    "sky",
    "sqlDate",
    "summitElevation",
    "summitTemp",
    "time",
    "windDirection",
    "windSpeed"
})
public class WeatherDataBean {

    protected String baseElevation;
    protected String baseTemp;
    protected String comments;
    protected String dateString;
    protected String gustSpreadMax;
    protected String gustSpreadMin;
    protected String location;
    protected String sky;
    protected Date sqlDate;
    protected String summitElevation;
    protected String summitTemp;
    protected String time;
    protected String windDirection;
    protected String windSpeed;

    /**
     * Gets the value of the baseElevation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseElevation() {
        return baseElevation;
    }

    /**
     * Sets the value of the baseElevation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseElevation(String value) {
        this.baseElevation = value;
    }

    /**
     * Gets the value of the baseTemp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseTemp() {
        return baseTemp;
    }

    /**
     * Sets the value of the baseTemp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseTemp(String value) {
        this.baseTemp = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the dateString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateString() {
        return dateString;
    }

    /**
     * Sets the value of the dateString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateString(String value) {
        this.dateString = value;
    }

    /**
     * Gets the value of the gustSpreadMax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGustSpreadMax() {
        return gustSpreadMax;
    }

    /**
     * Sets the value of the gustSpreadMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGustSpreadMax(String value) {
        this.gustSpreadMax = value;
    }

    /**
     * Gets the value of the gustSpreadMin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGustSpreadMin() {
        return gustSpreadMin;
    }

    /**
     * Sets the value of the gustSpreadMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGustSpreadMin(String value) {
        this.gustSpreadMin = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the sky property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSky() {
        return sky;
    }

    /**
     * Sets the value of the sky property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSky(String value) {
        this.sky = value;
    }

    /**
     * Gets the value of the sqlDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getSqlDate() {
        return sqlDate;
    }

    /**
     * Sets the value of the sqlDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setSqlDate(Date value) {
        this.sqlDate = value;
    }

    /**
     * Gets the value of the summitElevation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSummitElevation() {
        return summitElevation;
    }

    /**
     * Sets the value of the summitElevation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSummitElevation(String value) {
        this.summitElevation = value;
    }

    /**
     * Gets the value of the summitTemp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSummitTemp() {
        return summitTemp;
    }

    /**
     * Sets the value of the summitTemp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSummitTemp(String value) {
        this.summitTemp = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTime(String value) {
        this.time = value;
    }

    /**
     * Gets the value of the windDirection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindDirection() {
        return windDirection;
    }

    /**
     * Sets the value of the windDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindDirection(String value) {
        this.windDirection = value;
    }

    /**
     * Gets the value of the windSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindSpeed() {
        return windSpeed;
    }

    /**
     * Sets the value of the windSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindSpeed(String value) {
        this.windSpeed = value;
    }

}
