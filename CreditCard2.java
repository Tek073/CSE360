public class CreditCard2 {

    private String number;
    private String expirationDate;
    private String zipCode;

    public CreditCard2(String num, String exp, String zip) {
        number = num;
        expirationDate = exp;
        zipCode = zip;
    }

    public String getNumber() {
        return number;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getZipCode() {
        return zipCode;
    }
    
}
