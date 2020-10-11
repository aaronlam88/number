package number.models.number;

import java.io.Serializable;
import java.util.Set;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Numbers implements Serializable {
    private static final long serialVersionUID = 1L;

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
}
