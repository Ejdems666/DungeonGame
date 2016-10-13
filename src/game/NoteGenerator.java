package game;

import libs.FileIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ejdems on 13/10/2016.
 */
public class NoteGenerator {
    private FileIO fileReader = new FileIO("../resources/");
    private Random random = new Random();
    private ArrayList<String> excludes = new ArrayList<>();
    private ArrayList<String> contents;

    public NoteGenerator() {
        try {
            ArrayList<String> contents = fileReader.readFile("notes.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRandomNote() {
        String note;
        if(excludes.size() == contents.size()) {
            try {
                throw new Exception("no notes left");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        while (true) {
            note = contents.get(random.nextInt(contents.size()));
            if (!excludes.contains(note)) {
                excludes.add(note);
                return note;
            }
        }
    }
}
