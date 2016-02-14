package afgomez.geoworld.model;

/**
 *
 * @author agomez
 */
public class Country {

    protected String name;
    protected String capital;
    protected String region;
    protected String timezone;

    protected Country() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "Country{" + "name=" + name + ", capital=" + capital + ", region=" + region + ", timezone=" + timezone + '}';
    }

}
