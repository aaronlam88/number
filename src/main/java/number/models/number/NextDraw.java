package number.models.number;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class NextDraw implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("DrawNumber")
    private Integer drawNumber;

    @SerializedName("DrawDate")
    private String drawDate;

    @SerializedName("DrawCloseTime")
    private String drawCloseTime;

    @SerializedName("JackpotAmount")
    private String jackpotAmount;

    @SerializedName("EstimatedCashValue")
    private String estimatedCashValue;

    @SerializedName("WinningNumbers")
    private WinningNumbers winningNumbers;

    @SerializedName("Prizes")
    private Prizes prizes;

    @SerializedName("WinningRetailers")
    private List<String> winningRetailers;

    @SerializedName("RaceTime")
    private String raceTime;

    @SerializedName("DrawCloseDateTime")
    private String drawCloseDateTime;
}