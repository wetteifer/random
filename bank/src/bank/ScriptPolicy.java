/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author wetteifer
 */
public class ScriptPolicy implements Policy {

    private Script script;

    public ScriptPolicy(String name) {
        script = new Script(name);
    }

    @Override
    public boolean accept(Card c) {
        try {
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

            script.eval();
            Object retVal = script.invoke("accept", b, c);

            if (retVal instanceof Boolean) {
                return (Boolean) retVal;
            }
        } catch (Exception e) {}
        return false;
    }

}
