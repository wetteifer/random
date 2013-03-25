/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function accept(b, c) {
    try {
        var input;
        
        print("Last four digits: ");
        input = b.readLine();
        
        return c.getCardNumber().substring(12).equals(input);
    } catch (e) {
        return false;
    }
}