/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

/**
 *
 * @author wetteifer
 */
public final class DefaultCompany {

    private DefaultCompany() {}

    public static class MasterCard extends Company {
        public MasterCard() {
            super("Master Card", 5, 50.0);
        }
    }

    public static class Visa extends Company {
        public Visa() {
            super("Visa", 4, 0.0);
        }
    }

    public static class AmericanExpress extends Company {
        public AmericanExpress() {
            super("American Express", 3, 0.0);
        }
    }

}
