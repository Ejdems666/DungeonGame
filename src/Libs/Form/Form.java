package Libs.Form;

import Libs.Form.Inputs.FormField;
import Libs.Form.Inputs.NumberField;

import java.util.*;

/**
 * Created by becva on 14.09.2016.
 */
public class Form {
    private LinkedHashMap<String, FormField> inputs = new LinkedHashMap<String, FormField>();
    private Scanner scanner = new Scanner(System.in);

    public FormField addText(String name, String label) {
        FormField input = new FormField(label);
        inputs.put(name,input);
        return input;
    }

    public NumberField addNumber(String name, String label) {
        NumberField input = new NumberField(label);
        inputs.put(name,input);
        return input;
    }

    public FormField addContinue(String name, String label) {
        FormField input = new FormField(label+" (y/n)");
        input.setAllowedValues(new String[]{"y","n","Y","N","Yes","No","yes","no"})
            .setRequired(true);
        inputs.put(name,input);
        return input;
    }

    public int size() {
        return inputs.size();
    }

    public Object get(String name) {
        if(!inputs.containsKey(name)) {
            // TODO: error log, maybe exception, but need a debugger wrapper to catch it
            System.out.println("Nonexistent form field '"+name+"'.");
            System.exit(1);
        }
        return inputs.get(name).getValue();
    }

    public HashMap<String,Object> getAllInputs() {
        HashMap<String,Object> values = new HashMap<>();
        for (Map.Entry<String,FormField> input : inputs.entrySet()) {
            values.put(input.getKey(),input.getValue().getValue());
        }
        return values;
    }

    public String askForField(String name) {
        if(inputs.containsKey(name)) {
            inputs.get(name).askForInput(scanner);
            return inputs.get(name).toString();
        } else {
            System.out.println("Nonexistent form field "+name+", supposed to be asked!");
            System.exit(1);
            return "";
        }
    }

    public void askForAllFields() {
        for (Map.Entry<String,FormField> item : inputs.entrySet()) {
            askForField(item.getKey());
        }
    }
}
