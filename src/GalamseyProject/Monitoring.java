package GalamseyProject;

import java.util.ArrayList;

public class Monitoring {

    private ArrayList<Observatory> ObservatoryRecords = new ArrayList<>();
    private ArrayList<Galamsey> galamsey = new ArrayList<>();

    /**
     * Default Constructor
     */
    public Monitoring() {
    }

    /**Constructor
     *
     * @param observatoryRecords
     */
    public Monitoring(ArrayList<Observatory> observatoryRecords){
        this.ObservatoryRecords = observatoryRecords;
    }

    /**Add more Observatories to the monitoring
     *
     * @param item
     */
    public void addObservatory(Observatory item){
        this.ObservatoryRecords.add(item);
    }

    /**This returns the observatory with largest average color value
     *
     * @return Max
     */
    public String LargestAverage(){
        Observatory Max = ObservatoryRecords.get(0);
        for(Observatory a : ObservatoryRecords){
            if(Max.AverageCol() <= a.AverageCol()){
                Max = a;
            }
        }
        return Max.getObservatoryName();
    }

    /**Returns the largest galamsey color value recorded
     *
     * @return MaxCol
     */
    public int MaxColVal(){
        int one = 0;
        int two = 0;
        int three = 0;

        for(Observatory item:ObservatoryRecords){
            this.galamsey.addAll(item.getGalamseyEvents());
        }
        for(Galamsey Item: this.galamsey){
            switch (Item.getColorValue()) {
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
        return maxCol;
    }

    /**Returns a list of galamsey records with colour value greater
     * than a given number
     *
     * @param ColVal
     * @return list
     */
    public ArrayList<Galamsey> LargerThan(int ColVal){
        ArrayList<Galamsey> list = new ArrayList<>();
        if (ColVal < 3 && ColVal > 0) {
            for(Observatory item:ObservatoryRecords){
                this.galamsey.addAll(item.getGalamseyEvents());
            }
            for(Galamsey item: this.galamsey){
                if(item.getColorValue()>ColVal){
                    list.add(item);
                }
            }
        }
        return list;
    }

    public static void main(String[] args){

        /**
         * Test
         */
        Galamsey A = new Galamsey("Yellow",2,2,473,2019);
        Galamsey B = new Galamsey("Green",1,122,374,2020);
        Galamsey C = new Galamsey("Green",1,112,765,2020);
        Galamsey D = new Galamsey("Brown",3,-574, -907,2020);
        Galamsey E = new Galamsey("Yellow",2,141,-746,2020);
        Galamsey F = new Galamsey("Yellow",2,-415,490,2020);

        Galamsey A2 = new Galamsey("Green",1,435,235,2019);
        Galamsey B2 = new Galamsey("Green",1,32,33,2019);
        Galamsey C2 = new Galamsey("Green",1,128,25,2019);
        Galamsey D2 = new Galamsey("Yellow",2,124,47,2019);
        Galamsey E2 = new Galamsey("Yellow",2,570,34,2019);
        Galamsey F2 = new Galamsey("Yellow",2,985,43,2019);


        ArrayList<Galamsey> First = new ArrayList<>();
        ArrayList<Galamsey> Second = new ArrayList<>();

        First.add(A);
        First.add(B);
        First.add(C);
        First.add(D);
        First.add(E);
        First.add(F);

        Second.add(A2);
        Second.add(B2);
        Second.add(C2);
        Second.add(D2);
        Second.add(E2);
        Second.add(F2);

        Observatory S1 = new Observatory("Tema Lands","Ghana",2012,2417,First);
        Observatory S2 = new Observatory("Accra Lands","Ghana",2012,2745,Second);

        ArrayList<Observatory> monitoring = new ArrayList<>();
        monitoring.add(S2);
        monitoring.add(S1);

        Monitoring monitor = new Monitoring(monitoring);
        System.out.println(monitor.LargestAverage());

        System.out.println(monitor.MaxColVal());

        /**
         * print out lands greater than 2
         */
        System.out.println(monitor.LargerThan(2));


    }

}
