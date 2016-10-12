package game;

import libs.form.Form;

/**
 * Created by Ejdems on 12/10/2016.
 */
public class PlayerFactory {
    private static Form form = new Form();
    static {
        form.addText("name","Insert your name");
//        form.addText("continue","Do you want to continue adding users?");
    }

    public Player getPlayer() {
        form.askForAllFields();
        return new Player(form.get("name"));
    }
}
