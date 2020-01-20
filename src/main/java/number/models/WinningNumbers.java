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
}
