/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

/**
 *
 * @author wetteifer
 */
public class BankTerminal {

    private FactoryMethod method;

    public BankTerminal(FactoryMethod method) {
        this.method = method;
    }

    public void pay(Card card) {
        CompanyFactory factory = new CompanyFactory(method);
        Company company = factory.getCompany(card);
        if (company != null) {
            company.pay(card, method);
        } else {
            System.out.println("Unknown company.");
        }
    }

}
