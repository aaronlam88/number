package number.models.number;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Prizes implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("1")
    private Prize one;

    @SerializedName("2")
    private Prize two;

    @SerializedName("3")
    private Prize three;

    @SerializedName("4")
    private Prize four;

    @SerializedName("5")
    private Prize five;

    @SerializedName("6")
    private Prize six;

    @SerializedName("7")
    private Prize seven;

    @SerializedName("8")
    private Prize eight;

    @SerializedName("9")
    private Prize nine;
}
