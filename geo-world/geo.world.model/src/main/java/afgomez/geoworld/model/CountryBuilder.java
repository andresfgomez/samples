package afgomez.geoworld.model;

/**
 *
 * @author agomez
 */
public class CountryBuilder extends Country {

    private CountryBuilder() {

    }

    public static CountryBuilder builder() {
        return new CountryBuilder();
    }

    public CountryBuilder withName(String val) {
        setName(val);
        return this;
    }

    public Country build() {
        Country c = new Country();
        c.setName(getName());
        return c;
    }

}
