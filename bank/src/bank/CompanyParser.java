/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author wetteifer
 */
public class CompanyParser extends JsonParser {

    public CompanyParser() {
        super("/config/companies.json");
    }

    @Override
    protected Object parse() {
        try {
            String content = getContents();

            JSONArray a = new JSONArray(content);
            List<Company> companies = new ArrayList<Company>();

            for (int i = 0; i < a.length(); i++) {
                JSONObject o = a.getJSONObject(i);
                Company company = getCompany(o);
                companies.add(company);
            }

            return companies;
        } catch (JSONException e) {
            return null;
        }
    }

    public List<Company> getCompanies() {
        return (List<Company>) parse();
    }

    private static Company getCompany(JSONObject o) throws JSONException {
        Company c = new Company();

        c.setName(o.getString("name"));
        c.setCode(o.getInt("code"));
        c.setMinimumAmount(o.getDouble("amount"));

        return c;
    }

}
