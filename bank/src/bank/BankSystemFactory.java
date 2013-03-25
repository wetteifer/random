/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

import java.util.Map;

/**
 *
 * @author wetteifer
 */
public class BankSystemFactory {

    private FactoryMethod method;

    public BankSystemFactory(FactoryMethod method) {
        this.method = method;
    }

    public BankSystem getBankSystem(Card card) {
        switch (method) {
            case DEFAULT:
                return getDefaultBankSystem(card);
            case RESOURCE:
                return getResourceBankSystem(card);
            default:
                return null;
        }
    }

    private static BankSystem getDefaultBankSystem(Card card) {
        switch (card.getCompanyCode()) {
            case 5:  return new DefaultBankSystem.MasterCardBankSystem();
            case 4:  return new DefaultBankSystem.VisaBankSystem();
            case 3:  return new DefaultBankSystem.AmericanExpressBankSystem();
            default: return null;
        }
    }

    private static BankSystem getResourceBankSystem(Card card) {
        BankSystemParser bankSystemParser = new BankSystemParser();
        Map<Integer, BankSystem> bankSystems = bankSystemParser.getBankSystems();
        int code = card.getCompanyCode();

        if (bankSystems.containsKey(code)) {
            return bankSystems.get(code);
        }

        return null;
    }

}
