/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author wetteifer
 */
public class PolicyParser extends JsonParser {

    public PolicyParser() {
        super("/config/policies.json");
    }

    @Override
    protected Object parse() {
        try {
            String content = getContents();

            JSONArray a = new JSONArray(content);
            Map<Integer, List<Policy>> entries = new HashMap<Integer, List<Policy>>();

            for (int i = 0; i < a.length(); i++) {
                JSONObject o = a.getJSONObject(i);
                Integer code = o.getInt("code");
                List<Policy> policies = getPolicies(o.getJSONArray("policies"));
                entries.put(code, policies);
            }

            return entries;
        } catch (JSONException e) {
            return null;
        }
    }

    public Map<Integer, List<Policy>> getPolicies() {
        return (Map<Integer, List<Policy>>) parse();
    }

    private static List<Policy> getPolicies(JSONArray a) throws JSONException {
        List<Policy> policies = new ArrayList<Policy>();

        for (int i = 0; i < a.length(); i++) {
            String policy = a.getString(i);
            policies.add(new ScriptPolicy(policy));
        }

        return policies;
    }

}
