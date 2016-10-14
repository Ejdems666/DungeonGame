package libs;

import java.io.PrintStream;

/**
 * Created by Ejdems on 10/10/2016.
 */
public class Output {
    private PrintStream stream;

    public Output(PrintStream stream) {
        this.stream = stream;
    }
    public Output() {
        this.stream = System.out;
    }

    public void message(String message) {
        stream.println(message);
    }

    public void separator() {
        message("-----------------------------------------------------------------------");
    }

    public void separator(String message) {
        separator();
        message(message);
    }

    public void crashMessage(Exception e) {
        System.out.print(e.getMessage());
        System.exit(1);
    }
}
