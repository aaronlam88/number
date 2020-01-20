package number.models;

import com.google.gson.annotations.SerializedName;

public class WinningNumber {
    @SerializedName("Number")
    private String number;

    @SerializedName("IsSpecial")
    private Boolean isSpecial;

    @SerializedName("Name")
    private String name;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(Boolean isSpecial) {
        this.isSpecial = isSpecial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return number;
    }
}
