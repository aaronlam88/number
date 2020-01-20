package number.models;

import com.google.gson.annotations.SerializedName;

public class Prize {
    @SerializedName("PrizeTypeDescription")
    private String prizeTypeDescription;

    @SerializedName("Count")
    private Integer count;
    
    @SerializedName("Amount")
    private Integer amount;
}
