/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wetteifer
 */
public class PolicyFactory {

    private FactoryMethod method;

    public PolicyFactory(FactoryMethod method) {
        this.method = method;
    }

    public List<Policy> getPolicies(Card card) {
        switch (method) {
            case DEFAULT:
                return getDefaultPolicies(card);
            case RESOURCE:
                return getResourcePolicies(card);
            default:
                return null;
        }
    }

    private static List<Policy> getDefaultPolicies(Card card) {
        List<Policy> policies = new ArrayList<Policy>();

        switch (card.getCompanyCode()) {
            case 5:
                policies.add(new DefaultPolicy.A());
                break;
            case 4:
                policies.add(new DefaultPolicy.B());
                break;
            case 3:
                policies.add(new DefaultPolicy.C());
                break;
            default:
                return null;
        }

        return policies;
    }

    private static List<Policy> getResourcePolicies(Card card) {
        PolicyParser policyParser = new PolicyParser();
        Map<Integer, List<Policy>> policies = policyParser.getPolicies();
        int code = card.getCompanyCode();

        if (policies.containsKey(code)) {
            return policies.get(code);
        }

        return null;
    }

}
