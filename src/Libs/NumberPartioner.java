package Libs;

import java.util.*;

/**
 * Created by becva on 05.09.2016.
 */
public class NumberPartioner {

    private final int IS_SINGULAR = 1;

    private int amount;
    private String  unit;

    private List<Integer> resultMapper = new ArrayList<Integer>();
    private int[] amountMapper;
    private String[] unitMapper;
//    public static void main(String[] args) {
//        LinkedHashMap<String, Integer> timePartsMapper = new LinkedHashMap<String, Integer>();
//        timePartsMapper.put("hours",3600);
//        timePartsMapper.put("minutes",60);
//        timePartsMapper.put("seconds",1);
//        printParts(7030,"seconds",timePartsMapper);
//
//        LinkedHashMap<String, Integer> numberMapper = new LinkedHashMap<String, Integer>();
//        numberMapper.put("thousands",1000);
//        numberMapper.put("hundreds",100);
//        numberMapper.put("tens",10);
//        numberMapper.put("ones",1);
//        printParts(1835,"",numberMapper);
//    }

    public NumberPartioner(int amount,String[] unitMapper, int[] amountMapper, String unit) {
        this.amount = amount;
        this.unitMapper = unitMapper;
        this.amountMapper = amountMapper;
        this.unit = unit;
    }
    public String toString() {
        String separator = "";
        String output = "\n"+amount+" "+unit+" equals:"+"\n";
        calculateParts();
        int length = resultMapper.size();
        for (int i = 0; i < length; i++) {
            if(i == length-1) {
                separator = " and ";
            }
            output += separator + resultMapper.get(i) + " ";
            if(resultMapper.get(i) == IS_SINGULAR) {
                output += getSingularKey(unitMapper[i]);
            } else {
                output += unitMapper[i];
            }
            separator = ", ";
        }
        return output;
    }
    private void calculateParts() {
        double result;
        for (int i = 0; i < amountMapper.length; i++) {
            result = amount / amountMapper[i];
            amount = amount % amountMapper[i];
            if(result != 0) {
                resultMapper.add((int) result);
            }
        }
    }
    private String getSingularKey(String key) {
        return key.substring(0,key.length()-1);
    }
}
