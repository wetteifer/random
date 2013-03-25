/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author wetteifer
 */
public abstract class JsonParser {

    private String file;
    
    protected JsonParser(String file) {
        this.file = file;
    }

    protected abstract Object parse();

    protected String getFile() {
        return file;
    }

    protected String getContents() {
        StringBuilder builder = new StringBuilder();
        BufferedReader br = null;

        try {
            br = new BufferedReader(
                 new FileReader(System.getProperty("user.dir") + file));

            try {
                String line;
                while ((line = br.readLine()) != null) {
                    builder.append(line);
                }
            } catch (IOException e) {
                return null;
            } finally {
                try {
                    br.close();
                } catch (IOException e) {}
            }

            return builder.toString();
        } catch (FileNotFoundException e) {
            System.err.println("File " + file + " not found.");
        } finally {
            try {
                br.close();
            } catch (IOException e) {}
        }

        return null;
    }

}
