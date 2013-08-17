package domain;

/**
	 * MSSE 674 - Douglas Krause - wk7
         * 
	 * Annotations for Spring/Hibernate validation
         *      @NotEmpty(message="Date is required") removed to pass test
         *      @Pattern(regexp="[2][0][0-2]\\d/[0-1]\\d/[0-3]\\d",
         *      message="Invalid Date Format") removed to accomodate RESTful
         *      requests. Can't use "/" in URLs
         * 
         * Enabled for RESTful Web Resource via @XMLRootElement
	 * 
         * Uses Java Persistence API (JPA) annotations to designate
         *  this class as a persistence entity
	 */

import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.hibernate.validator.constraints.NotEmpty;
import services.SqlDateAdapter;

@XmlRootElement(name="WeatherDataBean")
@Entity // JPA annotation identifies POJO as a JPA entity
@Table(name="wxData") // JPA annotation for mapping to DB table
public class WeatherDataBean implements Serializable{

	private int id;
	private String dateString;
	private Date sqlDate;
	private String time;
	@NotEmpty(message="Location is required")
	private String location;
	private String sky;
	@Size(min=0, max=360, message="Must be 0-360")
	private String windDirection;
	private String windSpeed;
	private String gustSpreadMin;
	private String gustSpreadMax;
	private String summitTemp;
	private String summitElevation;
	private String baseTemp;
	private String baseElevation;
	private String comments;
	
	public WeatherDataBean() {}
	
	public WeatherDataBean(String date, String time, String location,
			String sky, String windDirection, String windSpeed,
			String gustSpreadMin, String gustSpreadMax, String summitTemp,
			String summitElevation, String baseTemp, String baseElevation,
			String comments) {
		super();
		this.dateString = date;
		this.sqlDate = parseDateStringToSqlDate(date);
		this.time = time;
		this.location = location;
		this.sky = sky;
		this.windDirection = windDirection;
		this.windSpeed = windSpeed;
		this.gustSpreadMin = gustSpreadMin;
		this.gustSpreadMax = gustSpreadMax;
		this.summitTemp = summitTemp;
		this.summitElevation = summitElevation;
		this.baseTemp = baseTemp;
		this.baseElevation = baseElevation;
		this.comments = comments;	
	}
        
        @Id // JPA annotation identifies this field as the primary key
        @Column(name="sqlDate") // JPA annotation
        @XmlJavaTypeAdapter(SqlDateAdapter.class)// Adapts java.sql.Date for jax-ws
	public Date getSqlDate() {
		return sqlDate;
	}
        
        @Column(name="idwxData") // Table column to field mapping
        public int getId(){
            return id;
        }
        
        public void setId(int id){
            this.id = id;
        }
        
        @Column(name="datestring")
	public String getDateString() {
		return dateString;
	}


	public void setDateString(String date) {
		this.dateString = date;
	}

	public void setSqlDate(Date sqlDate) {
		this.sqlDate = sqlDate;
	}

        @Column(name="time") // JPA annotation
	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}

        @Column(name="location") // JPA annotation
	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}

        @Column(name="sky") // JPA annotation
	public String getSky() {
		return sky;
	}


	public void setSky(String sky) {
		this.sky = sky;
	}

        @Column(name="windDirection") // JPA annotation
	public String getWindDirection() {
		return windDirection;
	}


	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

        @Column(name="windSpeed") // JPA annotation
	public String getWindSpeed() {
		return windSpeed;
	}

        
	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

        @Column(name="gustSpreadMin") // JPA annotation
	public String getGustSpreadMin() {
		return gustSpreadMin;
	}


	public void setGustSpreadMin(String gustSpreadMin) {
		this.gustSpreadMin = gustSpreadMin;
	}

        @Column(name="gustSpreadMax") // JPA annotation
	public String getGustSpreadMax() {
		return gustSpreadMax;
	}


	public void setGustSpreadMax(String gustSpreadMax) {
		this.gustSpreadMax = gustSpreadMax;
	}

        @Column(name="summitTemp") // JPA annotation
	public String getSummitTemp() {
		return summitTemp;
	}


	public void setSummitTemp(String summitTemp) {
		this.summitTemp = summitTemp;
	}

        @Column(name="summitElevation") // JPA annotation
	public String getSummitElevation() {
		return summitElevation;
	}


	public void setSummitElevation(String summitElevation) {
		this.summitElevation = summitElevation;
	}

        @Column(name="baseTemp") // JPA annotation
	public String getBaseTemp() {
		return baseTemp;
	}


	public void setBaseTemp(String baseTemp) {
		this.baseTemp = baseTemp;
	}

        @Column(name="baseElevation") // JPA annotation
	public String getBaseElevation() {
		return baseElevation;
	}


	public void setBaseElevation(String baseElevation) {
		this.baseElevation = baseElevation;
	}

        @Column(name="comments") // JPA annotation
	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}

        // Accepts a date string and returns a MySql Date object
	public Date parseDateStringToSqlDate(String dateString){
		
		try {
			// Validates format of dateString and converts to Date object
			SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
			simple.setLenient(false);
			java.util.Date javaDate = simple.parse(dateString);
			
			// Converts java.util.Date object to java.sql.Date object
			long dateMilliseconds = javaDate.getTime();
			java.sql.Date sqlDate = new java.sql.Date(dateMilliseconds);
			
			return sqlDate;
			
		} catch (ParseException e) {
			System.out.println("Error in parseDateString");
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String parseSqlDateToString(Date sqlDate){
		
		return sqlDate.toString();
	}
        
	@Override
	public String toString() {
		return "WeatherDataBean [dateString=" + dateString + ", time=" + time
				+ ", location=" + location + ", sky=" + sky
				+ ", windDirection=" + windDirection + ", windSpeed="
				+ windSpeed + ", gustSpreadMin=" + gustSpreadMin
				+ ", gustSpreadMax=" + gustSpreadMax + ", summitTemp="
				+ summitTemp + ", summitElevation=" + summitElevation
				+ ", baseTemp=" + baseTemp + ", baseElevation=" + baseElevation
				+ ", comments=" + comments + "]";
	}
	
}
