import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static oracle.jrockit.jfr.events.Bits.doubleValue;

/**
 * Created by Sanjeev on 11/29/2016.
 */
public class SolvingEquations {


    public double[] solveEquation(String[][] equations, String[][] queries, double[] value){

        HashMap<String, ArrayList<String>> pair = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<Double>> valuepair = new HashMap<String, ArrayList<Double>>();

        for(int i = 0; i<equations.length; i++) {
            String[] equation = equations[i];

            if (!pair.containsKey(equation[0])) {
                pair.put(equation[0], new ArrayList<String>());
                valuepair.put(equation[0], new ArrayList<Double>());
            }

            if (!pair.containsKey(equation[1])) {
                pair.put(equation[1], new ArrayList<String>());
                valuepair.put(equation[1], new ArrayList<Double>());
            }

            pair.get(equation[0]).add(equation[1]);
            pair.get(equation[1]).add(equation[0]);

            valuepair.get(equation[0]).add(value[i]);
            valuepair.get(equation[1]).add(1 / value[i]);
        }
            double[] result = new double[queries.length];
            for (int i = 0; i < queries.length; i++) {
                String[] query = queries[i];
                result[i] = dfs(query[0], query[1], pair, valuepair, new HashSet<String>(), 1.0);
                if (result[i] == 0.0) result[i] = -1.0;
            }

        return result;

    }

    public static double dfs (String start, String end, HashMap<String, ArrayList<String>> pair, HashMap<String, ArrayList<Double>> valuepair, HashSet<String> set, double v){

        if(set.contains(start)) return 0.0;
        if(!pair.containsKey(start)) return 0.0;
        if(start.equals(end)) return v;
        set.add(start);

        ArrayList<String> lststr = pair.get(start);
        ArrayList<Double> vllst = valuepair.get(start);
        double tmp = 0.0;
        for(int i=0; i<lststr.size(); i++){
            tmp = dfs(String.valueOf(pair.get(i)), end, pair, valuepair, set,v*vllst.get(i));
            if(tmp!=0.0) break;
        }
        set.remove(start);
        return tmp;


    }







}
