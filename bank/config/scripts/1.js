/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function accept(b, c) {
    try {
        var input;

        print("Security code: ");
        input = b.readLine();

        return c.getSecurityCode().equals(input);
    } catch (e) {
        return false;
    }
}