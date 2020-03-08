package number.models;

import com.google.gson.annotations.SerializedName;

public class WinningNumbers {
    @SerializedName("0")
    private WinningNumber zero;

    @SerializedName("1")
    private WinningNumber one;

    @SerializedName("2")
    private WinningNumber two;

    @SerializedName("3")
    private WinningNumber three;

    @SerializedName("4")
    private WinningNumber four;

    @SerializedName("5")
    private WinningNumber five;

    @Override
    public String toString() {
        return String.format("[%s, %s, %s, %s, %s, %s]", zero, one, two, three, four, five);
    }

    public WinningNumber getZero() {
        return zero;
    }

    public void setZero(WinningNumber zero) {
        this.zero = zero;
    }

    public WinningNumber getOne() {
        return one;
    }

    public void setOne(WinningNumber one) {
        this.one = one;
    }

    public WinningNumber getTwo() {
        return two;
    }

    public void setTwo(WinningNumber two) {
        this.two = two;
    }

    public WinningNumber getThree() {
        return three;
    }

    public void setThree(WinningNumber three) {
        this.three = three;
    }

    public WinningNumber getFour() {
        return four;
    }

    public void setFour(WinningNumber four) {
        this.four = four;
    }

    public WinningNumber getFive() {
        return five;
    }

    public void setFive(WinningNumber five) {
        this.five = five;
    }
}
