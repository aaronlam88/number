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

    public Integer getDrawNumber() {
        return drawNumber;
    }

    public void setDrawNumber(Integer drawNumber) {
        this.drawNumber = drawNumber;
    }

    public String getDrawDate() {
        return DrawDate;
    }

    public void setDrawDate(String drawDate) {
        DrawDate = drawDate;
    }

    public String getDrawCloseTime() {
        return drawCloseTime;
    }

    public void setDrawCloseTime(String drawCloseTime) {
        this.drawCloseTime = drawCloseTime;
    }

    public String getJackpotAmount() {
        return jackpotAmount;
    }

    public void setJackpotAmount(String jackpotAmount) {
        this.jackpotAmount = jackpotAmount;
    }

    public String getEstimatedCashValue() {
        return estimatedCashValue;
    }

    public void setEstimatedCashValue(String estimatedCashValue) {
        this.estimatedCashValue = estimatedCashValue;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Prizes getPrizes() {
        return prizes;
    }

    public void setPrizes(Prizes prizes) {
        this.prizes = prizes;
    }

    public List<String> getWinningRetailers() {
        return winningRetailers;
    }

    public void setWinningRetailers(List<String> winningRetailers) {
        this.winningRetailers = winningRetailers;
    }

    public String getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(String raceTime) {
        this.raceTime = raceTime;
    }

    public String getDrawCloseDateTime() {
        return drawCloseDateTime;
    }

    public void setDrawCloseDateTime(String drawCloseDateTime) {
        this.drawCloseDateTime = drawCloseDateTime;
    }
}