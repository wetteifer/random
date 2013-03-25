/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

/**
 *
 * @author wetteifer
 */
public class Card {

    private String cardNumber;
    private String securityCode;
    private String expirationDate;

    public Card() {}

    public Card(String cardNumber, String securityCode, String expirationDate) {
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public int getCompanyCode() {
        return cardNumber == null ? -1 : Character.getNumericValue(cardNumber.charAt(0));
    }

    @Override
    public String toString() {
        return "Card Number: " + cardNumber + "\n"
             + "Security Code: " + securityCode + "\n"
             + "Expiration Date: " + expirationDate;
    }

}
