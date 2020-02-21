package GalamseyProject;

public class Galamsey {

    /***
     * This is a model class to hold information about Galamsey activity, the vegetation colour, colour value, position (latitude and longitude) and year of the event.
     * @author Kweku-Abeiku Attah Anyen
     * @author GLoria
     * @author Collins
     * @version 1.0.0.1
     *
     *This program is provided in a terminal base output and a JavaFX GUI output.
     */

        String vegetationColor;
        int colorValue;
        String position;
        int year;
        float positionLAT;
        float positionLON;


        public Galamsey() {

         }

    /**
     * Constructor
     * @param vegetationColor stores vegetation color
     * @param colorValue stores vegetation color value
     * @param positionLON stores longitude of vegetation
     * @param positionLAT stores latitude of vegetation
     * @param year stores year of observation
     */
        public Galamsey(String vegetationColor, int colorValue, float positionLON, float positionLAT, int year) {
            this.vegetationColor = vegetationColor;
            this.colorValue = colorValue;
            this.position = String.format("(%s, %s)", positionLON, positionLAT);
            this.year = year;
        }

    /**
     * Getter for vegetation color
     * @return Vegetation color
     */
        public String getVegetationColor() {
            return vegetationColor;
        }

    /**
     * setter for vegetation color
     *
     */
        public void setVegetationColor(String vegetationColor) {
            this.vegetationColor = vegetationColor;
        }


    /**
     * Getter for vegetation color value
     * @return color value
     */
        public int getColorValue ( ) {
            return colorValue;
        }

    /**
     * setter for vegetation color value
     * @return color value
     */
        public void setColorValue(int colorValue) {
            this.colorValue = colorValue;
        }


    /**
     * Getter for vegetation location
     * @return color value
     */
        public String getPosition() {
            return position;
        }

    /**
     * setter for vegetation location
     *
     */
        public void setPosition(float positionLON , float positionLAT) {
            this.position = "(" + this.positionLON + ", " + this.positionLAT + ")";
        }

    /**
     * Getter for year
     * @return year value
     */
        public int getYear() {
            return year;
        }


    /**
     * setter for vegetation color value
     *
     */
        public void setYear(int year) {
            this.year = year;
        }


    /**
     * Getter for vegetation location latitude
     * @return latitude
     */
        public float getPositionLAT() {
        return positionLAT;
        }


    /**
     * setter for vegetation location latitude
     *
     */
        public void setPositionLAT(float positionLAT) {
            this.positionLAT = positionLAT;
            this.position = "(" + this.positionLON + ", " + this.positionLAT + ")";
        }



    /**
     * setter for vegetation location longitude
     * @return longitude
     */
        public float getPositionLON() {
            return positionLON;
        }


    /**
     * setter for vegetation location langitude.
     *
     */
        public void setPositionLON(float positionLON) {
            this.positionLON = positionLON;
            this.position = "(" + this.positionLON + ", " + this.positionLAT + ")";
        }


    /**
     *
     * @return string of objects in the class.
     */
    @Override
    public String toString() {
        return "Galamsey{" +
                "vegetationColor='" + vegetationColor + '\'' +
                ", colorValue=" + colorValue +
                ", position='" + position + '\'' +
                ", year=" + year +
                '}';
    }

    public static void main(String[] args) {

    }



}
