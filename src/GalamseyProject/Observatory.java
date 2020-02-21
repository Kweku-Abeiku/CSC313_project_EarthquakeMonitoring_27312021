package GalamseyProject;

import java.util.ArrayList;
import java.util.Iterator;

public class Observatory{

    private String observatoryName;
    private String countryLocated;
    private int yearStarted;
    private double areaOfObservatory;
    private ArrayList<Galamsey> galamseyEvents;

    @Override
    public String toString() {
        return "Observatory{" +
                "observatoryName='" + observatoryName + '\'' +
                ", countryLocated='" + countryLocated + '\'' +
                ", yearStarted=" + yearStarted +
                ", areaOfObservatory=" + areaOfObservatory +
                ", galamseyEvents=" + galamseyEvents +
                '}';
    }


    public Observatory() {

    }

    /***
     * COnstructor
     * @param observatoryName Name of observatory
     * @param countryLocated Country located
     * @param yearStarted year
     * @param areaOfObservatory area covered
     * @param galamseyEvents array of events recorded
     */
    public Observatory(String observatoryName, String countryLocated, int yearStarted, double areaOfObservatory, ArrayList<Galamsey> galamseyEvents) {
        this.observatoryName = observatoryName;
        this.countryLocated = countryLocated;
        this.yearStarted = yearStarted;
        this.areaOfObservatory = areaOfObservatory;
        this.galamseyEvents = galamseyEvents;
    }


    public String getObservatoryName() {
        return observatoryName;
    }

    public void setObservatoryName(String observatoryName) {
        this.observatoryName = observatoryName;
    }

    public String getCountryLocated() {
        return countryLocated;
    }

    public void setCountryLocated(String countryLocated) {
        this.countryLocated = countryLocated;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    public void setYearStarted(int yearStarted) {
        this.yearStarted = yearStarted;
    }

    public double getAreaOfObservatory() {
        return areaOfObservatory;
    }

    public void setAreaOfObservatory(double areaOfObservatory) {
        this.areaOfObservatory = areaOfObservatory;
    }

    public ArrayList<Galamsey> getGalamseyEvents() {
        return galamseyEvents;
    }

    public void setGalamseyEvents(ArrayList<Galamsey> galamseyEvents) {
        this.galamseyEvents = galamseyEvents;
    }

    public void addRecord(Galamsey obj){
        this.getGalamseyEvents().add(obj);
    }

    public void removeRecord(Galamsey obj){
        this.getGalamseyEvents().remove(obj);
    }

    /**
     * Method for average value
     */

    public float AverageCol(){
        float sum = 0;
        for(Galamsey item: galamseyEvents){
            switch (item.getColorValue()) {
                case 1:
                    sum++;
                    break;
                case 2:
                    sum = sum + 2;
                    break;
                case 3:
                    sum = sum + 3;
                    break;
                default:
                    break;
            }
        }
        return (sum/galamseyEvents.size());
    }


    /***
     * Greatest color value
     * @return
     */
    public int MaxColValue(){
        int one = 0;
        int two = 0;
        int three = 0;
        for(Galamsey item: galamseyEvents){
            switch (item.getColorValue()) {
                case 1:
                    one++;
                    break;
                case 2:
                    two++;
                    break;
                case 3:
                    three++;
                    break;
                default:
                    break;
            }
        }


        int maxCol = Math.max(one, Math.max(two,three));
        if (one == maxCol) {
            maxCol = 1;
        }
        else if (two == maxCol) {
            maxCol = 2;
        }
        else{
            maxCol=3;
        }
        return maxCol ;
    }


    /***
     * Color value greater than given number
     * @param num
     * @return
     */

    public ArrayList<Galamsey> aboveColValue(int num){
        ArrayList<Galamsey> list;
        list = new ArrayList<>();
        for(Galamsey item: galamseyEvents){
            if(item.getColorValue()>num){
                list.add(item);
            }
        }
        return (list);
    }


    public static void main (String[] args) {

        Galamsey A = new Galamsey("Yellow",2,2743,122,2020);
        Galamsey B = new Galamsey("Green",1,12, 323,2020);
        Galamsey C = new Galamsey("Green",1,710,120,2020);
        Galamsey D = new Galamsey("Brown",3,454,433,2020);
        Galamsey E = new Galamsey("Yellow",2,152,534,2020);
        Galamsey F = new Galamsey("Yellow",2,542,853,2020);

        ArrayList<Galamsey> records = new ArrayList<>();
        records.add(A);
        records.add(B);
        records.add(C);
        records.add(D);
        records.add(E);
        records.add(F);

        Observatory first = new Observatory("A","Ghana",2012,23,records);
        System.out.println("The Average Color value: "+first.AverageCol());
        System.out.println("Places above the color value: " +first.aboveColValue(1));
        System.out.println("Greatest Color Value: " + first.MaxColValue());
        System.out.println(first);


    }






}
