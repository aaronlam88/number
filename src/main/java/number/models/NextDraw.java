package number.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class NextDraw {
    @SerializedName("DrawNumber")
    private Integer drawNumber;
    
    @SerializedName("DrawDate")
    private String DrawDate;
    
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