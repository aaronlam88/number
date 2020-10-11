package number.models.number;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class WinningNumbers implements Serializable {
    private static final long serialVersionUID = 1L;

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
}
