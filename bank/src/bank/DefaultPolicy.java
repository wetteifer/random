/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author wetteifer
 */
public final class DefaultPolicy {

    private DefaultPolicy() {}

    public static class A implements Policy {
        public boolean accept(Card card) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String value;

                System.out.print("Security code: ");
                value = br.readLine();

                return card.getSecurityCode().equals(value);
            } catch (IOException e) {
                return false;
            }
        }
    }

    public static class B implements Policy {
        public boolean accept(Card card) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String value;

                System.out.print("Last four digits: ");
                value = br.readLine();

                return card.getCardNumber().substring(12).equals(value);
            } catch (IOException e) {
                return false;
            }
        }
    }

    public static class C implements Policy {
        public boolean accept(Card card) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String value;

                System.out.print("Expiration date: ");
                value = br.readLine();

                return card.getExpirationDate().equals(value);
            } catch (IOException e) {
                return false;
            }
        }
    }

}
