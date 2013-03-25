/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

/**
 *
 * @author wetteifer
 */
public final class DefaultBankSystem {

    private DefaultBankSystem() {}

    public static class MasterCardBankSystem implements BankSystem {
        public void pay(Card card, double amount) {
            try {
                System.out.println("Master Card Payment System");
                System.out.println("Establishing connection...");
                Thread.sleep(5000);
                System.out.println(card.getCardNumber() + " - $" + amount);
                System.out.println("Sending payment...");
                Thread.sleep(7000);
                System.out.println("Payment sent.");
            } catch (Exception e) {}
        }
    }

    public static class VisaBankSystem implements BankSystem {
        public void pay(Card card, double amount) {
            try {
                System.out.println("*** VISA PAYMENT SYSTEM ***");
                System.out.println("WAIT A MOMENT, ESTABLISHING CONNECTION...");
                Thread.sleep(3000);
                System.out.println(card.getCardNumber() + " - $" + amount);
                System.out.println("WAIT A MOMENT, SENDING PAYMENT...");
                Thread.sleep(5000);
                System.out.println("Payment sent.");
            } catch (Exception e) {}
        }
    }

    public static class AmericanExpressBankSystem implements BankSystem {
        public void pay(Card card, double amount) {
            try {
                System.out.println("American Express © Payment System");
                System.out.println("Connecting to our servers...");
                Thread.sleep(2000);
                System.out.println(card.getCardNumber() + " - $" + amount);
                System.out.println("Sending payment...");
                Thread.sleep(3000);
                System.out.println("Payment sent.");
            } catch (Exception e) {}
        }
    }

}
