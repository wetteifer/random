/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author wetteifer
 */
public class Script {

    private ScriptEngine engine;
    private String script;

    public Script(String name) {
        ScriptEngineManager factory = new ScriptEngineManager();
        engine = factory.getEngineByName("JavaScript");
        script = name;
    }

    public void put(String name, Object object) {
        engine.put(name, object);
    }

    public Object eval() throws ScriptException {
        return engine.eval(getResource("/config/scripts/" + script));
    }

    public Object invoke(String function, Object ... args) throws ScriptException, NoSuchMethodException {
        return ((Invocable) engine).invokeFunction(function, args);
    }

    private Reader getResource(String name) {
        try {
            return new FileReader(System.getProperty("user.dir") + name);
        } catch (FileNotFoundException e) {
            System.err.println("Script " + name + " not found.");
            return null;
        }
    }

}
