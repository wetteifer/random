/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author wetteifer
 */
public class BankSystemParser extends JsonParser {

    public BankSystemParser() {
        super("/config/systems.json");
    }

    @Override
    protected Object parse() {
        try {
            String content = getContents();

            JSONArray a = new JSONArray(content);
            Map<Integer, BankSystem> entries = new HashMap<Integer, BankSystem>();

            for (int i = 0; i < a.length(); i++) {
                JSONObject o = a.getJSONObject(i);
                Integer code = o.getInt("code");
                BankSystem bankSystem = getBankSystem(o.getJSONObject("system"));
                entries.put(code, bankSystem);
            }

            return entries;
        } catch (JSONException e) {
            return null;
        }
    }

    public Map<Integer, BankSystem> getBankSystems() {
        return (Map<Integer, BankSystem>) parse();
    }

    private static BankSystem getBankSystem(final JSONObject o) throws JSONException {
        return new BankSystem() {
            public void pay(Card card, double amount) {
                try {
                    System.out.println(o.getString("name"));
                    System.out.println(o.getString("connectionMessage"));
                    Thread.sleep(o.getLong("connectionTime"));
                    System.out.println(card.getCardNumber() + " - $" + amount);
                    System.out.println(o.getString("paymentMessage"));
                    Thread.sleep(o.getLong("paymentTime"));
                    System.out.println(o.getString("paymentSentMessage"));
                } catch (Exception e) {}
            }
        };
    }

}
