/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

import java.util.List;

/**
 *
 * @author wetteifer
 */
public class PolicyFilter {
    
    public PolicyFilter() {}

    public void filter(FactoryMethod method, Card card, double amount) {
        PolicyFactory factory = new PolicyFactory(method);
        List<Policy> policies = factory.getPolicies(card);

        for (Policy policy : policies) {
            if (!policy.accept(card)) {
                System.out.println("Payment failed.");
                return;
            }
        }

        pay(method, card, amount);
    }

    private void pay(FactoryMethod method, Card card, double amount) {
        BankSystemFactory factory = new BankSystemFactory(method);
        BankSystem bankSystem = factory.getBankSystem(card);
        bankSystem.pay(card, amount);
    }

}
