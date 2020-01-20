package number.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Draw {
    @SerializedName("DrawNumber")
    private Integer drawNumber;

    @SerializedName("DrawDate")
    private String drawDate;

    @SerializedName("DrawCloseTime")
    private String drawCloseTime;

    @SerializedName("JackpotAmount")
    private Integer jackpotAmount;

    @SerializedName("EstimatedCashValue")
    private Integer EstimatedCashValue;

    @SerializedName("WinningNumbers")
    private WinningNumbers WinningNumbers;

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
        return drawDate;
    }

    public void setDrawDate(String drawDate) {
        this.drawDate = drawDate;
    }

    public String getDrawCloseTime() {
        return drawCloseTime;
    }

    public void setDrawCloseTime(String drawCloseTime) {
        this.drawCloseTime = drawCloseTime;
    }

    public Integer getJackpotAmount() {
        return jackpotAmount;
    }

    public void setJackpotAmount(Integer jackpotAmount) {
        this.jackpotAmount = jackpotAmount;
    }

    public Integer getEstimatedCashValue() {
        return EstimatedCashValue;
    }

    public void setEstimatedCashValue(Integer estimatedCashValue) {
        EstimatedCashValue = estimatedCashValue;
    }

    public WinningNumbers getWinningNumbers() {
        return WinningNumbers;
    }

    public void setWinningNumbers(WinningNumbers winningNumbers) {
        WinningNumbers = winningNumbers;
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
