public class Coupon2 {
    private String code;
    private int discount; // %ge

    public Coupon2(String code, int discount) {
        this.code = code;
        this.discount = discount;
    }

    public String getCode() {
        return code;
    }

    public int getDiscount() {
        return discount;
    }
}
