
package domain;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import services.SqlDateAdapter;

/**
 *
 * @author dougkrause
 * msse676 - wk7
 * 
 * EJB Entity Bean
 * Mapped to DB with persistence.xml
 * 
 */

@XmlRootElement(name="ForecastBean") // Enables use with RESTful Web Services
@Entity // Java Persistence API annotations
@Table(name="pointForecast")
public class ForecastBean {
    
    private int id;
    private Date sqlDate;
    private String stringDate;
    private String location;
    private String forecastText;
    
    /**
     * @return the sqlDate
     */
    @Id // Id defined for entity hierarchy
    @Column(name="sqlDate")
    @XmlJavaTypeAdapter(SqlDateAdapter.class) // allows passing via JAX-WS
    public Date getSqlDate() {
        return sqlDate;
    }

    @Column(name="id")
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the location
     */
    @Column(name="location")
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the forecastText
     */
    @Column(name="forecastText")
    public String getForecastText() {
        return forecastText;
    }

    /**
     * @param forecastText the forecastText to set
     */
    public void setForecastText(String forecastText) {
        this.forecastText = forecastText;
    }

    /**
     * @param sqlDate the sqlDate to set
     */
    public void setSqlDate(Date sqlDate) {
        this.sqlDate = sqlDate;
    }

    /**
     * @return the stringDate
     */
    @Column(name="stringDate")
    public String getStringDate() {
        return stringDate;
    }

    /**
     * @param stringDate the stringDate to set
     */
    public void setStringDate(String stringDate) {
        this.stringDate = stringDate;
    }
    
}
