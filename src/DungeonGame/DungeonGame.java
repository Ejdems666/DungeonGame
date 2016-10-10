package DungeonGame;

import Libs.Form.Form;

/**
 * Created by Ejdems on 10/10/2016.
 */
public class DungeonGame {
    private static Form form = new Form();
    static {
        form.addContinue("test","Test");
    }

    public static void main(String[] args) {
        form.askForAllFields();
        System.out.println(form.getAllInputs().get("test"));
        System.out.println(form.get("test"));
//        Application game = new Application();
        // TODO: init
    }
}
