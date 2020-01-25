package number.models;

import java.util.Set;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("DrawGameId")
    private Integer drawGameId;
    
    @SerializedName("Name")
    private String name;
    
    @SerializedName("NextDraw")
    private NextDraw nextDraw;
    
    @SerializedName("HasJackpot")
    private Boolean hasJackpot;
    
    @SerializedName("TotalPreviousDraws")
    private Integer totalPreviousDraws;
    
    @SerializedName("LastWinningStraightPrizeAmount")
    private Integer lastWinningStraightPrizeAmount;
    
    @SerializedName("MostRecentDraw")
    private Draw mostRecentDraw;
    
    @SerializedName("PreviousDraws")
    private Set<Draw> previousDraws;

    public Integer getDrawGameId() {
        return drawGameId;
    }

    public void setDrawGameId(Integer drawGameId) {
        this.drawGameId = drawGameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NextDraw getNextDraw() {
        return nextDraw;
    }

    public void setNextDraw(NextDraw nextDraw) {
        this.nextDraw = nextDraw;
    }

    public Boolean getHasJackpot() {
        return hasJackpot;
    }

    public void setHasJackpot(Boolean hasJackpot) {
        this.hasJackpot = hasJackpot;
    }

    public Integer getTotalPreviousDraws() {
        return totalPreviousDraws;
    }

    public void setTotalPreviousDraws(Integer totalPreviousDraws) {
        this.totalPreviousDraws = totalPreviousDraws;
    }

    public Integer getLastWinningStraightPrizeAmount() {
        return lastWinningStraightPrizeAmount;
    }

    public void setLastWinningStraightPrizeAmount(Integer lastWinningStraightPrizeAmount) {
        this.lastWinningStraightPrizeAmount = lastWinningStraightPrizeAmount;
    }

    public Draw getMostRecentDraw() {
        return mostRecentDraw;
    }

    public void setMostRecentDraw(Draw mostRecentDraw) {
        this.mostRecentDraw = mostRecentDraw;
    }

    public Set<Draw> getPreviousDraws() {
        return previousDraws;
    }

    public void setPreviousDraws(Set<Draw> previousDraws) {
        this.previousDraws = previousDraws;
    }
}
