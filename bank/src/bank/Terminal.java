/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

/**
 *
 * @author wetteifer
 */
public class Terminal {

    private BankTerminal bankTerminal;

    public Terminal(FactoryMethod method) {
        bankTerminal = new BankTerminal(method);
    }

    public void pay(Card card) {
        bankTerminal.pay(card);
    }

}
