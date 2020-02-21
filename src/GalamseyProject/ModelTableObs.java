package GalamseyProject;

public class ModelTableObs {
    /**
     * This glass class creates objects from database to be used in javaFX.
     */

    String name,country;
    int year;
    Double area;

    /**
     * Constructor
     * @param name Name of observatory
     * @param country name of country located
     * @param year year created
     * @param area area covered
     */
    public ModelTableObs (String name, String country, int year, Double area) {
        this.name = name;
        this.country = country;
        this.year = year;
        this.area = area;
    }

    public String getName ( ) {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getCountry ( ) {
        return country;
    }

    public void setCountry (String country) {
        this.country = country;
    }

    public int getYear ( ) {
        return year;
    }

    public void setYear (int year) {
        this.year = year;
    }

    public Double getArea ( ) {
        return area;
    }

    public void setArea (Double area) {
        this.area = area;
    }
}
