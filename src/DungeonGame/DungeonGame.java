package DungeonGame;

import Libs.Form.Form;

/**
 * Created by Ejdems on 10/10/2016.
 */
public class DungeonGame {
    private static Form form = new Form();
    static {
        form.addContinue("test","Test");
        form.addNumber("tesst","Test");
    }

    public static void main(String[] args) {
        form.askForAllFields();
        System.out.print(((int) form.getNumber("tesst")));
//        Application game = new Application();
        // TODO: init
    }
}
