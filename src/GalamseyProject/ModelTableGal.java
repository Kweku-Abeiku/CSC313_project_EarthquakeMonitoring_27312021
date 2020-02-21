package GalamseyProject;

public class ModelTableGal {
    /**
     * This glass class creates objects from database to be used in javaFX.
     */

    String Vegcolor;
    int colorVal;
    String position;
    int year;
    String ObsName;

    /**
     *
     * @param vegcolor contains vegetation color
     * @param colorVal contains vegetation color value
     * @param position contains vegetation position
     * @param year contains year
     * @param obsName contains observatory name
     */
    public ModelTableGal (String vegcolor, int colorVal, String position, int year, String obsName) {
        Vegcolor = vegcolor;
        this.colorVal = colorVal;
        this.position = position;
        this.year = year;
        ObsName = obsName;
    }

    public String getVegcolor ( ) {
        return Vegcolor;
    }

    public void setVegcolor (String vegcolor) {
        Vegcolor = vegcolor;
    }

    public int getColorVal ( ) {
        return colorVal;
    }

    public void setColorVal (int colorVal) {
        this.colorVal = colorVal;
    }

    public String getPosition ( ) {
        return position;
    }

    public void setPosition (String position) {
        this.position = position;
    }

    public int getYear ( ) {
        return year;
    }

    public void setYear (int year) {
        this.year = year;
    }

    public String getObsName ( ) {
        return ObsName;
    }

    public void setObsName (String obsName) {
        ObsName = obsName;
    }
}
