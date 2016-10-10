/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Tobias Grundtvig
 */
public class FileIO
{
    private String path;

    public FileIO(String path) {
        this.path = path;
    }

    public String readFile(String fileName) throws FileNotFoundException, IOException
    {
        String result;
        BufferedReader buffered = new BufferedReader(new FileReader(path+fileName));
        try {
            StringBuilder builder = new StringBuilder();
            String line = buffered.readLine();
            while(line != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
                line = buffered.readLine();
            }
            result = builder.toString();
        }
        finally {
            buffered.close();
        }
        return result;
    }

    public void writeFile(String fileName, String content) throws IOException
    {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(new File(fileName)));
            writer.write(content);
        }
        finally {
            try {
                if(writer != null) {
                    writer.close();
                }
            }
            catch(Exception e) {}
        }
    }
}
