/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function accept(b, c) {
    try {
        var input;
        
        print("Expiration date: ");
        input = b.readLine();
        
        return c.getExpirationDate().equals(input);
    } catch (e) {
        return false;
    }
}