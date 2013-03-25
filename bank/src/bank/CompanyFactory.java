/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

import java.util.List;

/**
 *
 * @author wetteifer
 */
public class CompanyFactory {

    private FactoryMethod method;

    public CompanyFactory(FactoryMethod method) {
        this.method = method;
    }

    public Company getCompany(Card card) {
        switch (method) {
            case DEFAULT:
                return getDefaultCompany(card);
            case RESOURCE:
                return getResourceCompany(card);
            default:
                return null;
        }
    }

    private static Company getDefaultCompany(Card card) {
        switch (card.getCompanyCode()) {
            case 5:  return new DefaultCompany.MasterCard();
            case 4:  return new DefaultCompany.Visa();
            case 3:  return new DefaultCompany.AmericanExpress();
            default: return null;
        }
    }

    private static Company getResourceCompany(Card card) {
        CompanyParser companyParser = new CompanyParser();
        List<Company> companies = companyParser.getCompanies();
        int code = card.getCompanyCode();

        for (Company company : companies) {
            if (code == company.getCode()) {
                return company;
            }
        }

        return null;
    }

}
