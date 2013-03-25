/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

/**
 *
 * @author wetteifer
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Card card = new Card("3495283859402847", "8273", "11/12");
        Terminal terminal = new Terminal(FactoryMethod.RESOURCE);
        terminal.pay(card);        
    }

}
