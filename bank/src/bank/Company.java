/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

import java.util.Scanner;

/**
 *
 * @author wetteifer
 */
public class Company {

    private String name;
    private int code;
    private double amount;

    public Company() {}

    public Company(String name, int code, double amount) {
        this.name = name;
        this.code = code;
        this.amount = amount;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinimumAmount() {
        return amount;
    }

    public void setMinimumAmount(double amount) {
        this.amount = amount;
    }

    public void pay(Card card, FactoryMethod method) {
        Scanner s = new Scanner(System.in);
        double input;

        System.out.print("Amount: ");
        input = s.nextDouble();

        if (input == 0) {
            System.out.println("The amount must be greater than zero.");
            return;
        }

        if (input < amount) {
            System.out.println("The amount must be greater or equal to " + amount);
            return;
        }

        new PolicyFilter().filter(method, card, input);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n"
             + "Code: " + code + "\n"
             + "Amount: " + amount;
    }

}
