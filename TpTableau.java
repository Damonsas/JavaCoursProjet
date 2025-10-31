package JavaProjet;

import static java.util.Arrays.stream;

public class TpTableau {
    public static void main(String[]args){
        double[] salesAnalysis = {21,124,87,64,98,6};
        System.out.println(salesAnalysis.length);

        // la moyenne des ventes par jour
        double total = salesAnalysis[0]+ salesAnalysis[1]+ salesAnalysis[2]+ salesAnalysis[3]+ salesAnalysis[4]+ salesAnalysis[5];

        double average = total/ salesAnalysis.length;

        System.out.println(average);

        // la plus grosse vente
        System.out.println(stream(salesAnalysis).max());




    }
}
